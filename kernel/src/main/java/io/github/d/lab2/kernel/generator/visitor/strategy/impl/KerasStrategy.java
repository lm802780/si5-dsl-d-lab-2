package io.github.d.lab2.kernel.generator.visitor.strategy.impl;

import io.github.d.lab2.kernel.categories.datamining.network.Network;
import io.github.d.lab2.kernel.categories.datamining.network.layer.keras.DenseLayer;
import io.github.d.lab2.kernel.categories.datamining.network.layer.keras.DropoutLayer;
import io.github.d.lab2.kernel.categories.datamining.training.Training;
import io.github.d.lab2.notebook.Notebook;

public class KerasStrategy extends DefaultStrategy {

    public KerasStrategy(Notebook notebook) {
        super(notebook);
    }

    @Override
    public void visit(Network network){
        notebook.addCellCode("## define network");
        notebook.appendCode("def Network(nbIn, nbOut):");
        notebook.appendCode("  model = Sequential()");
        network.getLayers().forEach(layer -> layer.accept(this));
        notebook.appendCode("  return model");

        notebook.addCellCode("## create network");
        notebook.appendCode("nbIn = X_train.shape[1]");
        notebook.appendCode("nbOut = 1");
        notebook.appendCode("model = Network(nbIn, nbOut)");
        notebook.appendCode("neuralNetwork.summary()");
    }

    @Override
    public void visit(DenseLayer denseLayer){
        notebook.appendCode("  model.add(Dense(units=" + denseLayer.getUnits() + ", activation='" + denseLayer.getActivation() + "'))");
    }
    @Override
    public void visit(DropoutLayer dropoutLayer){
        notebook.appendCode("  model.add(Dropout(" + dropoutLayer.getRate() + "))");
    }

    @Override
    public void visit(Training training){
        notebook.addCellMarkdown();
        notebook.appendMarkdown("#### Loss/optimizers catalog");
        notebook.addCellCode();
        String loss = switch (training.getLoss()) {
            case MSE -> "'mse'";
            case CROSSENTROPY -> "categorical_crossentropy";
            default -> throw new IllegalStateException("Unexpected value: " + training.getLoss());
        };
        String optimizer = switch (training.getOptimizer()) {
            case SGD -> "'SGD'";
            case ADAM -> "'Adam'";
            default -> throw new IllegalStateException("Unexpected value: " + training.getOptimizer());
        };
        //Hyper parameters
        notebook.appendCode("selected_loss_function =" + loss);
        notebook.appendCode("selected_optimizer =" + optimizer);
        notebook.appendCode("learning_rate = "+training.getLearningRate());
        notebook.appendCode("nbEpochs = "+training.getEpochs());
        notebook.appendCode("batch_size = "+training.getBatchSize());

        notebook.addCellCode();
        notebook.appendCode("""
                neuralNetwork.compile(
                    loss=selected_loss_function,
                    optimizer=selected_optimizer,
                    metrics=['accuracy']
                )""");
        notebook.appendCode("""
                history = neuralNetwork.fit(X_train, y_train,
                                            batch_size=batch_size,
                                            epochs=nbEpochs,
                                            verbose=1)""");
    }

}