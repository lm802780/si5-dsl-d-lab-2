package io.github.d.lab2.externals.antlr;

import io.github.d.lab2.externals.antlr.grammar.NotebookmlBaseListener;
import io.github.d.lab2.externals.antlr.grammar.NotebookmlParser;
import io.github.d.lab2.kernel.App;
import io.github.d.lab2.kernel.categories.datamining.DataMining;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.*;
import io.github.d.lab2.kernel.categories.datamining.training.LossEnum;
import io.github.d.lab2.kernel.categories.datamining.training.OptimizerEnum;
import io.github.d.lab2.kernel.categories.datamining.training.Training;
import io.github.d.lab2.kernel.categories.preprocessing.Preprocessing;
import io.github.d.lab2.kernel.categories.selection.Selection;
import io.github.d.lab2.kernel.categories.selection.Source;
import io.github.d.lab2.kernel.categories.transformation.Normalization;
import io.github.d.lab2.kernel.categories.transformation.Reshape;
import io.github.d.lab2.kernel.categories.transformation.Transformation;
import io.github.d.lab2.kernel.categories.transformation.TransformationElement;
import io.github.d.lab2.kernel.categories.validation.Validation;
import io.github.d.lab2.kernel.categories.validation.ValidationElement;
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
            List<Double> doubles = new ArrayList<>();
            reshapeContext.reshape_values().forEach(reshapeValuesContext -> doubles.add(Double.valueOf(reshapeValuesContext.reshape_value.getText())));
            reshape.setReshapeValues(doubles);
            elementList.add(reshape);
        });
        ctx.normalization().forEach(normalizationContext -> {
            Normalization normalization = new Normalization();
            EnumMap<TypeEnum, Double> enumMap = new EnumMap<>(TypeEnum.class);
            normalizationContext.normalization_elem().forEach(normalizationElemContext -> enumMap.put(TypeEnum.valueOf(normalizationElemContext.type.getText()), Double.parseDouble(normalizationElemContext.size.getText())));
            normalization.setNormalizationElem(enumMap);
            elementList.add(normalization);
        });
        transformation.setElements(elementList);
        theApp.setTransformation(transformation);
    }

    /**************************
     ** data_mining **
     **************************/

    @Override
    public void enterData_mining(NotebookmlParser.Data_miningContext ctx) {
        theApp.setDataMining(new DataMining());
    }

    @Override
    public void enterSequential(NotebookmlParser.SequentialContext ctx) {
        Sequential sequential = new Sequential();
        List<SequentialLayer> sequentialLayers = new ArrayList<>();
        ctx.linear().forEach(linearContext -> {
            sequentialLayers.add(new LinearLayer(Integer.parseInt(linearContext.linear_in.getText()), Integer.parseInt(linearContext.linear_out.getText())));
        });
        ctx.tanh().forEach(tanhContext -> {
            sequentialLayers.add(new TanhLayer());
        });
        ctx.softmax().forEach(softmaxContext -> {
            sequentialLayers.add(new SoftmaxLayer());
        });
        sequential.setSequentialLayers(sequentialLayers);
        theApp.getDataMining().getElements().add(sequential);
    }

    @Override
    public void enterParams(NotebookmlParser.ParamsContext ctx) {
        Training training = new Training();
        training.setLoss(LossEnum.valueOf(ctx.loss().loss_type.getText()));
        training.setOptimizer(OptimizerEnum.valueOf(ctx.optimizers().optimizers_type.getText()));
        training.setLearningRate(Double.parseDouble(ctx.learningRate().learningRate_nb.getText()));
        training.setEpochs(Integer.parseInt(ctx.nbEpochs().nbEpochs_nb.getText()));
        training.setBatchSize(Integer.parseInt(ctx.batchSize().batchSize_nb.getText()));
        theApp.getDataMining().setTraining(training);
    }

    @Override
    public void enterValidation(NotebookmlParser.ValidationContext ctx) {
        Validation validation = new Validation();
        theApp.setValidation(validation);
    }

    @Override
    public void enterDiagram(NotebookmlParser.DiagramContext ctx) {
        List<ValidationElement> validationElements = new ArrayList<>();
        //validationElements.add();
        //theApp.getValidation().getValidationElement().addAll(validationElements);
    }

    @Override
    public void exitRoot(NotebookmlParser.RootContext ctx) {
        // Resolving states in transitions
        // TODO: to complete
        this.built = true;
    }
}

