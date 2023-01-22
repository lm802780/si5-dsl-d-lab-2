package io.github.d.lab2.externals.antlr;

import io.github.d.lab2.externals.antlr.grammar.NotebookmlBaseListener;
import io.github.d.lab2.externals.antlr.grammar.NotebookmlParser;
import io.github.d.lab2.kernel.App;
import io.github.d.lab2.kernel.categories.datamining.DataMining;
import io.github.d.lab2.kernel.categories.datamining.network.Network;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.EluLayer;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.LinearLayer;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.SeluLayer;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.Sequential;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.SigmoidLayer;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.SoftmaxLayer;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.SoftplusLayer;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.SoftsignLayer;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.TanhLayer;
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
import io.github.d.lab2.kernel.categories.validation.DiagramEnum;
import io.github.d.lab2.kernel.categories.validation.Validation;
import io.github.d.lab2.kernel.categories.validation.ValidationElement;
import io.github.d.lab2.kernel.categories.validation.diagrams.ConfusionMatrix;
import io.github.d.lab2.kernel.categories.validation.diagrams.LossEpochEvolution;
import io.github.d.lab2.kernel.categories.validation.diagrams.Prediction;
import io.github.d.lab2.kernel.enums.FrameworkEnum;
import io.github.d.lab2.kernel.enums.ProcessingEnum;
import io.github.d.lab2.kernel.enums.TypeEnum;
import io.github.d.lab2.kernel.mandatory.Description;
import io.github.d.lab2.kernel.mandatory.Framework;
import org.apache.commons.lang3.EnumUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Locale;

public class ModelBuilder extends NotebookmlBaseListener {

    /********************
     ** Business Logic **
     ********************/

    private App theApp;
    private boolean built;

    public App retrieve() {
        if (built) {
            return theApp;
        }
        throw new RuntimeException("Cannot retrieve a model that was not created!");
    }

    /*******************
     ** Symbol tables **
     *******************/

    protected Network network;

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
    public void enterFrameworks(NotebookmlParser.FrameworksContext ctx) {
        theApp.setFrameworks(ctx.framework().stream()
                .map(f -> new Framework(FrameworkEnum.valueOf(f.frameworkType.getText())))
                .toList()
        );
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

        selection.setLabel(ctx.label() == null ? "label" : ctx.label().label_name.getText());

        // Split
        EnumMap<TypeEnum, Double> splits = new EnumMap<>(TypeEnum.class);

        if (ctx.split() == null || ctx.split().split_list().isEmpty()) {
            // Select default train - validation - test percentage.
            splits.put(TypeEnum.TRAIN, 40.0);
            splits.put(TypeEnum.VALIDATION, 30.0);
            splits.put(TypeEnum.TEST, 30.0);
            System.out.println("No split information found. Default split set to TRAIN (40%), VALIDATION (30%) and " +
                    "TEST (30%).");
        } else {
            ctx.split().split_list().forEach(splitContext -> {
                TypeEnum type = TypeEnum.valueOf(splitContext.type.getText());
                double percentage = Double.parseDouble(splitContext.percentage.getText());
                splits.put(type, percentage);
            });

            if (splits.size() > 3) {
                ExceptionHandler.exit("You should have at most 3 unique split directives (TRAIN, VALIDATION and TEST)" +
                        ".");
            } else if (splits.size() < 3) {
                double currentTotal = splits.values().stream().reduce(0.0, Double::sum);
                double remainingValue = 100 - currentTotal;
                int remainingKey = TypeEnum.values().length - splits.size();
                double valueToSet = remainingValue / remainingKey;
                for (TypeEnum typeEnum : TypeEnum.values()) {
                    splits.computeIfAbsent(typeEnum, type -> {
                        System.out.printf("%s split absents, default value set to %.2f%n", type.name(), valueToSet);
                        return valueToSet;
                    });
                }
            }
        }

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
        preprocessing.setProcessing(ProcessingEnum.valueOf(ctx.nan().nan_processing.getText().toUpperCase(Locale.US)));
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
    public void enterLinear(NotebookmlParser.LinearContext ctx) {
        network.getLayers().add(new LinearLayer(Integer.parseInt(ctx.linear_in.getText()),
                Integer.parseInt(ctx.linear_out.getText())));
    }

    @Override
    public void enterTanh(NotebookmlParser.TanhContext ctx) {
        network.getLayers().add(new TanhLayer());
    }

    @Override
    public void enterSoftmax(NotebookmlParser.SoftmaxContext ctx) {
        network.getLayers().add(new SoftmaxLayer());
    }

    @Override
    public void enterElu(NotebookmlParser.EluContext ctx) {
        network.getLayers().add(new EluLayer());
    }

    @Override
    public void enterSelu(NotebookmlParser.SeluContext ctx) {
        network.getLayers().add(new SeluLayer());
    }

    @Override
    public void enterSigmoid(NotebookmlParser.SigmoidContext ctx) {
        network.getLayers().add(new SigmoidLayer());
    }

    @Override
    public void enterSoftplus(NotebookmlParser.SoftplusContext ctx) {
        network.getLayers().add(new SoftplusLayer());
    }

    @Override
    public void enterSoftsign(NotebookmlParser.SoftsignContext ctx) {
        network.getLayers().add(new SoftsignLayer());
    }

    @Override
    public void enterSequential(NotebookmlParser.SequentialContext ctx) {
        network = new Sequential();
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
        String diagramName = ctx.diagram_name.getText().toUpperCase(Locale.ENGLISH);
        if (!EnumUtils.isValidEnum(DiagramEnum.class, diagramName)) {
            String message = String.format("Invalid diagram name: '%s'%nShould be (select one item): %s",
                    ctx.diagram_name.getText(),
                    Arrays.toString(
                            Arrays.stream(DiagramEnum.values())
                                    .map(element -> element.name().toLowerCase(Locale.ENGLISH))
                                    .toArray()
                    )
            );
            ExceptionHandler.exit(message);
        }
        DiagramEnum diagram = DiagramEnum.valueOf(diagramName);
        switch (diagram) {
            case LOSS_EPOCH_EVOLUTION -> validationElements.add(new LossEpochEvolution());
            case PREDICTION -> validationElements.add(new Prediction());
            case CONFUSION -> validationElements.add(new ConfusionMatrix());
        }
        theApp.getValidation().getValidationElement().addAll(validationElements);
    }

    @Override
    public void exitRoot(NotebookmlParser.RootContext ctx) {
        // Resolving states in transitions
        theApp.getDataMining().setNetwork(network);
        this.built = true;
    }
}

