package io.github.d.lab2.kernel.generator.visitor.strategy.impl;

import io.github.d.lab2.kernel.categories.datamining.network.Network;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.Sequential;
import io.github.d.lab2.kernel.categories.datamining.training.Training;
import io.github.d.lab2.kernel.categories.validation.diagrams.LossEpochEvolution;
import io.github.d.lab2.kernel.categories.validation.diagrams.Prediction;
import io.github.d.lab2.notebook.Notebook;

public class KerasStrategy extends DefaultStrategy {

    public KerasStrategy(Notebook notebook) {
        super(notebook);
    }

    @Override
    public void visit(Network network) {
        notebook.addCellCode("## define network\n");
        notebook.appendCode("def Network(nbIn, nbOut):\n");
        notebook.appendCode(1, "model = Sequential()\n");
//        network.getLayers().forEach(layer -> layer.accept(this));
        notebook.appendCode(1, "return model\n");

        notebook.addCellCode("## create network\n");
        notebook.appendCode("nbIn = X_train.shape[1]\n");
        notebook.appendCode("nbOut = 1\n");
        notebook.appendCode("model = Network(nbIn, nbOut)\n");
        notebook.appendCode("neuralNetwork.summary()\n");
    }

//    @Override
//    public void visit(DenseLayer denseLayer){
//        notebook.appendCode("  model.add(Dense(units=" + denseLayer.getUnits() + ", activation='" + denseLayer.getActivation() + "'))\n");
//    }
//    @Override
//    public void visit(DropoutLayer dropoutLayer){
//        notebook.appendCode("  model.add(Dropout(" + dropoutLayer.getRate() + "))\n");
//    }
//
//    @Override
//    public void visit(TanhLayer tanhLayer){
//        notebook.appendCode("  model.add(Tanh())\n");
//    }

    @Override
    public void visit(Sequential sequential) {

    }

    @Override
    public void visit(Training training) {
        notebook.addCellMarkdown();
        notebook.appendMarkdown("#### Loss/optimizers catalog\n");
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
        notebook.appendCode("selected_loss_function =" + loss + "\n");
        notebook.appendCode("selected_optimizer =" + optimizer + "\n");
        notebook.appendCode("learning_rate = " + training.getLearningRate() + "\n");
        notebook.appendCode("nbEpochs = " + training.getEpochs() + "\n");
        notebook.appendCode("batch_size = " + training.getBatchSize() + "\n");

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

    @Override
    public void visit(LossEpochEvolution lossEpochEvolution) {
        notebook.addCellCode();
        notebook.appendCode("# Loss epoch evolution\n");
        notebook.appendCode("fig, ax = plt.subplots()\n");
        notebook.appendCode("x = np.arange(len(history.history['loss']))\n");
        notebook.appendCode("ax.plot(x, history.history['loss'])\n");
        notebook.appendCode("ax.set(xlabel='number of epochs', ylabel='loss', title='Evolution')\n");
        notebook.appendCode("plt.show()");
    }

    @Override
    public void visit(Prediction prediction) {
        notebook.addCellCode();
        notebook.appendCode("# Prediction\n");
        notebook.appendCode("ax = plt.gca()\n");
        notebook.appendCode("output = neuralNetwork.predict(X_train.values[:%d])\n");
        notebook.appendCode("plt.plot(np.arange(y_train.values.size), y_train.values[:%d], '-', label='True data', color='b')\n");
        notebook.appendCode("plt.plot(np.arange(output.size), output, '--', label='Predictions', color='r')\n");
        notebook.appendCode("plt.gcf().autofmt_xdate()\n");
        notebook.appendCode("plt.show()");
    }

}
