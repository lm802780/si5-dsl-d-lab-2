package io.github.d.lab2.externals.antlr;

import io.github.d.lab2.externals.antlr.grammar.NotebookmlBaseListener;
import io.github.d.lab2.externals.antlr.grammar.NotebookmlParser;
import io.github.d.lab2.kernel.App;
import io.github.d.lab2.kernel.categories.preprocessing.Preprocessing;
import io.github.d.lab2.kernel.categories.selection.Selection;
import io.github.d.lab2.kernel.categories.selection.Source;
import io.github.d.lab2.kernel.categories.transformation.Normalization;
import io.github.d.lab2.kernel.categories.transformation.Reshape;
import io.github.d.lab2.kernel.categories.transformation.Transformation;
import io.github.d.lab2.kernel.categories.transformation.TransformationElement;
import io.github.d.lab2.kernel.enums.FrameworkEnum;
import io.github.d.lab2.kernel.enums.ProcessingEnum;
import io.github.d.lab2.kernel.enums.TypeEnum;
import io.github.d.lab2.kernel.mandatory.Description;
import io.github.d.lab2.kernel.mandatory.Framework;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class ModelBuilder extends NotebookmlBaseListener {

    /********************
     ** Business Logic **
     ********************/

    private App theApp;
    private boolean built = false;

    public App retrieve() {
        if (built) {
            return theApp;
        }
        throw new RuntimeException("Cannot retrieve a model that was not created!");
    }

    /*******************
     ** Symbol tables **
     *******************/
    // TODO: to complete

    /**************************
     ** Listening mechanisms **
     **************************/

    @Override
    public void enterRoot(NotebookmlParser.RootContext ctx) {
        built = false;
        theApp = new App();
    }

    /**************************
     ** description **
     **************************/
    @Override
    public void enterDescription(NotebookmlParser.DescriptionContext ctx) {
        Description description = new Description();
        description.setDetail(ctx.detail.getText());
        theApp.setDescription(description);
    }

    /**************************
     ** framework **
     **************************/

    @Override
    public void enterFramework(NotebookmlParser.FrameworkContext ctx) {
        Framework framework = new Framework();
        framework.setFramework(FrameworkEnum.valueOf(ctx.frameworkType.getText()));
        theApp.setFramework(framework);
    }

    /**************************
     ** workflow **
     **************************/

    @Override
    public void enterWorkflow(NotebookmlParser.WorkflowContext ctx) {
    }

    /**************************
     ** selection **
     **************************/
    @Override
    public void enterSelection(NotebookmlParser.SelectionContext ctx) {
        Selection selection = new Selection();
        Source source = new Source();
        source.setSourceId(ctx.source().sourceId.getText());
        selection.setSource(source);

        EnumMap<TypeEnum, Double> splits = new EnumMap<>(TypeEnum.class);

        ctx.split().split_list().forEach(splitContext -> {
            TypeEnum type = TypeEnum.valueOf(splitContext.type.getText());
            double percentage = Double.parseDouble(splitContext.percentage.getText());
            splits.put(type, percentage);
        });

        // Assert that all the percentages are equal to 100.
        if (splits.values().stream().reduce(0.0, Double::sum) != 100) {
            String message = String.format("The total value of percentages should be equals to 100 (%s).", splits);
            ExceptionHandler.exit(message);
        }

        selection.setSplit(splits);
        theApp.setSelection(selection);
    }

    /**************************
     ** preProcessing **
     **************************/

    @Override
    public void enterPreProcessing(NotebookmlParser.PreProcessingContext ctx) {
        Preprocessing preprocessing = new Preprocessing();
        preprocessing.setProcessing(ProcessingEnum.valueOf(ctx.nan().nan_processing.getText().toUpperCase()));
        theApp.setPreprocessing(preprocessing);
    }



    /**************************
     ** transformation **
     **************************/

    @Override
    public void enterTransformation(NotebookmlParser.TransformationContext ctx) {
        Transformation transformation = new Transformation();

        List<TransformationElement> elementList = new ArrayList<>();

        ctx.reshape().forEach(reshapeContext -> {
            Reshape reshape = new Reshape();
            reshape.setType(TypeEnum.valueOf(reshapeContext.type.getText()));
            //TODO: array int
            elementList.add(reshape);
        });
        ctx.normalization().forEach(normalizationContext -> {
            Normalization normalization = new Normalization();
            EnumMap<TypeEnum, Double> enumMap = new EnumMap<>(TypeEnum.class);
            normalizationContext.normalization_elem().forEach(normalization_elemContext -> enumMap.put(TypeEnum.valueOf(normalization_elemContext.type.getText()), Double.parseDouble(normalization_elemContext.size.getText())));
            normalization.setNormalizationElem(enumMap);
            elementList.add(normalization);
        });
        transformation.setElements(elementList);
        theApp.setTransformation(transformation);
    }

    @Override
    public void exitRoot(NotebookmlParser.RootContext ctx) {
        // Resolving states in transitions
        // TODO: to complete
        this.built = true;
    }
}

