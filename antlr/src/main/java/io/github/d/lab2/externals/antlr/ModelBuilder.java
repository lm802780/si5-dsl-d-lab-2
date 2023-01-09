package io.github.d.lab2.externals.antlr;

import io.github.d.lab2.externals.antlr.grammar.NotebookmlBaseListener;
import io.github.d.lab2.externals.antlr.grammar.NotebookmlParser;
import io.github.d.lab2.kernel.App;
import io.github.d.lab2.kernel.categories.preprocessing.Preprocessing;
import io.github.d.lab2.kernel.categories.selection.Selection;
import io.github.d.lab2.kernel.categories.selection.Source;
import io.github.d.lab2.kernel.enums.FrameworkEnum;
import io.github.d.lab2.kernel.enums.ProcessingEnum;
import io.github.d.lab2.kernel.enums.TypeEnum;
import io.github.d.lab2.kernel.mandatory.Description;
import io.github.d.lab2.kernel.mandatory.Framework;

import java.util.EnumMap;

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


    @Override
    public void enterDescription(NotebookmlParser.DescriptionContext ctx) {
        Description description = new Description();
        description.setDetail(ctx.detail.getText());
        theApp.setDescription(description);
    }


    @Override
    public void enterFramework(NotebookmlParser.FrameworkContext ctx) {
        Framework framework = new Framework();
        framework.setFramework(FrameworkEnum.valueOf(ctx.frameworkType.getText()));
    }

    @Override
    public void enterWorkflow(NotebookmlParser.WorkflowContext ctx) {
    }

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
        selection.setSplit(splits);
        theApp.setSelection(selection);
    }

    @Override
    public void enterPreProcessing(NotebookmlParser.PreProcessingContext ctx) {
        Preprocessing preprocessing = new Preprocessing();
        ctx.nan().forEach(nanContext -> {
            preprocessing.setProcessing(ProcessingEnum.valueOf(nanContext.processing.getText()));
        });
        theApp.setPreprocessing(preprocessing);
    }


    @Override
    public void exitRoot(NotebookmlParser.RootContext ctx) {
        // Resolving states in transitions
        // TODO: to complete
        this.built = true;
    }
}

