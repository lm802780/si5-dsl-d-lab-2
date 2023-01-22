package io.github.d.lab2.kernel.generator.visitor.strategy.impl;

import io.github.d.lab2.kernel.categories.datamining.network.Layer;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.LinearLayer;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.Sequential;
import io.github.d.lab2.kernel.categories.datamining.training.Training;
import io.github.d.lab2.kernel.categories.validation.diagrams.ConfusionMatrix;
import io.github.d.lab2.kernel.categories.validation.diagrams.LossEpochEvolution;
import io.github.d.lab2.kernel.categories.validation.diagrams.Prediction;
import io.github.d.lab2.notebook.Notebook;

import java.util.LinkedList;

public class KerasStrategy extends DefaultStrategy {

    public KerasStrategy(Notebook notebook) {
        super(notebook);
    }

    private void writeLayer(LinkedList<Layer> layers) {
        LinearLayer linearLayer = (LinearLayer) layers.get(0);
        notebook.appendCode(1, String.format("model.add(kl.Dense(%d,input_shape=(%d,)))%n",
                linearLayer.getOutFeatures(), linearLayer.getInFeatures()));

        layers.removeFirst();
    }

    private void writeLayer(String activation, LinkedList<Layer> layers) {
        LinearLayer linearLayer = (LinearLayer) layers.get(0);
        notebook.appendCode(1, String.format("model.add(kl.Dense(%d, activation='%s', input_shape=(%d,)))%n",
                linearLayer.getOutFeatures(), activation, linearLayer.getInFeatures()));

        layers.removeFirst();
        layers.removeFirst();
    }

    @Override
    public void visit(Sequential sequential) {
        notebook.addCellCode("#### define network\n");
        notebook.appendCode("def KerasNetwork(nbIn, nbOut):\n");
        notebook.appendCode(1, "model = km.Sequential()\n");
        LinkedList<Layer> layers = new LinkedList<>(sequential.getLayers());
        while (!layers.isEmpty()) {
            if (!(layers.get(0) instanceof LinearLayer)) {
                throw new RuntimeException("Wrong network model");
            }
            if (layers.size() == 1) {
                writeLayer(layers);
            }
            switch (layers.get(1).getClass().getSimpleName()) {
                case "TanhLayer":
                    writeLayer("tanh", layers);
                    break;
                case "SoftmaxLayer":
                    writeLayer("softmax", layers);
                    break;
                case "SigmoidLayer":
                    writeLayer("sigmoid", layers);
                    break;
                case "SoftplusLayer":
                    writeLayer("softplus", layers);
                    break;
                case "SoftsignLayer":
                    writeLayer("softsign", layers);
                    break;
                case "SeluLayer":
                    writeLayer("selu", layers);
                    break;
                case "EluLayer":
                    writeLayer("elu", layers);
                    break;
                case "LinearLayer":
                    writeLayer(layers);
                    break;
                default:
                    throw new RuntimeException("Unknown layer");
            }
        }

        notebook.appendCode(1, "return model\n");
        notebook.addCellCode("#### create network\n");
        notebook.appendCode("nbIn = X_train.shape[1]\n");
        notebook.appendCode("nbOut = 1\n");
        notebook.appendCode("model_keras = KerasNetwork(nbIn, nbOut)\n");
        notebook.appendCode("model_keras.summary()\n");
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
        notebook.appendCode("selected_loss_function_keras =" + loss + "\n");
        notebook.appendCode("selected_optimizer_keras =" + optimizer + "\n");
        notebook.appendCode("learning_rate = " + training.getLearningRate() + "\n");
        notebook.appendCode("nbEpochs = " + training.getEpochs() + "\n");
        notebook.appendCode("batch_size = " + training.getBatchSize() + "\n");

        notebook.addCellCode();
        notebook.appendCode("""
                model_keras.compile(
                    loss=selected_loss_function_keras,
                    optimizer=selected_optimizer_keras,
                    metrics=['accuracy']
                )
                """);
        notebook.appendCode("""
                history_keras = model_keras.fit(X_train, y_train,
                                            batch_size=batch_size,
                                            epochs=nbEpochs,
                                            verbose=1)""");
    }

    @Override
    public void visit(ConfusionMatrix confusionMatrix) {
        notebook.addCellCode();
        notebook.appendCode("# Confusion matrix (Keras)\n");
        notebook.appendCode("from sklearn.metrics import confusion_matrix\n");
        notebook.appendCode("");
        notebook.appendCode("""
                cm = confusion_matrix(y_test, y_pred_keras)
                plt.figure(figsize=(9,9))
                plt.imshow(cm, interpolation='nearest', cmap='Pastel1')
                plt.title('Confusion matrix (Keras)', size = 15)
                plt.colorbar()
                plt.tight_layout()
                plt.ylabel('Actual label', size = 15)
                plt.xlabel('Predicted label', size = 15)
                width, height = cm.shape
                for x in range(width):
                    for y in range(height):
                        plt.annotate(str(cm[x][y]), xy=(y, x),
                            horizontalalignment='center',
                            verticalalignment='center'
                        )
                """);
    }

    @Override
    public void visit(LossEpochEvolution lossEpochEvolution) {
        notebook.addCellCode();
        notebook.appendCode("# Loss epoch evolution (Keras)\n");
        notebook.appendCode("fig, ax = plt.subplots()\n");
        notebook.appendCode("x = np.arange(len(history_keras.history['loss']))\n");
        notebook.appendCode("ax.plot(x, history_keras.history['loss'])\n");
        notebook.appendCode("ax.set(xlabel='number of epochs', ylabel='loss', title='Evolution')\n");
        notebook.appendCode("plt.show()");
    }

    @Override
    public void visit(Prediction prediction) {
        notebook.addCellCode();
        notebook.appendCode("# Prediction (Keras)\n");
        notebook.appendCode("ax = plt.gca()\n");
        notebook.appendCode("y_pred_keras = np.argmax(model_keras.predict(X_test.values), axis=1)\n");
        notebook.appendCode("plt.plot(np.arange(50), y_test[:50], '-', label='True data', color='b')\n");
        notebook.appendCode("plt.plot(np.arange(50), y_pred_keras[:50], '--', label='Predictions', color='r')\n");
        notebook.appendCode("plt.gcf().autofmt_xdate()\n");
        notebook.appendCode("plt.show()");
    }
}
