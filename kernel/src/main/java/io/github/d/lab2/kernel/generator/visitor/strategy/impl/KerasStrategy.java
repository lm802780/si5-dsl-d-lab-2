package io.github.d.lab2.kernel.generator.visitor.strategy.impl;

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

    @Override
    public void visit(Sequential sequential) {
        notebook.addCellCode("#### define network\n");
        notebook.appendCode("def KerasNetwork(nbIn, nbOut):\n");
        notebook.appendCode(1,"model = km.Sequential()\n");
        var layers = new LinkedList<>(sequential.getLayers());
        while (!layers.isEmpty()) {
            if(!(layers.get(0)  instanceof LinearLayer)){
                throw new RuntimeException("Wrong network model");
            }
            if(layers.size() == 1){
                notebook.appendCode(1,"model.add(kl.Dense("+((LinearLayer) layers.get(0)).getOutFeatures()+
                        ",input_shape=("+((LinearLayer) layers.get(0)).getInFeatures()+",)))\n");
                layers.removeFirst();
            }
            switch (layers.get(1).getClass().getSimpleName()){
                case "TanhLayer":
                        notebook.appendCode(1,"model.add(kl.Dense("+((LinearLayer) layers.get(0)).getOutFeatures()+
                                ", activation='tanh', input_shape=("+((LinearLayer) layers.get(0)).getInFeatures()+",)))\n");
                        layers.removeFirst();
                        layers.removeFirst();
                        break;
                case "SoftmaxLayer":
                        notebook.appendCode(1,"model.add(kl.Dense("+((LinearLayer) layers.get(0)).getOutFeatures()+
                                ", activation='softmax', input_shape=("+((LinearLayer) layers.get(0)).getInFeatures()+",)))\n");
                        layers.removeFirst();
                        layers.removeFirst();
                        break;
                case "LinearLayer":
                        notebook.appendCode(1,"model.add(kl.Dense("+((LinearLayer) layers.get(0)).getOutFeatures()+
                                ",input_shape=("+((LinearLayer) layers.get(0)).getInFeatures()+",)))\n");
                    layers.removeFirst();
                    break;
                default:
                        throw new RuntimeException("Unknown layer");
            }

        }
        notebook.appendCode(1,"return model\n");


        notebook.addCellCode("#### create network\n");
        notebook.appendCode("nbIn = X_train.shape[1]\n");
        notebook.appendCode("nbOut = 1\n");
        notebook.appendCode("model_keras = KerasNetwork(nbIn, nbOut)\n");
        notebook.appendCode("model_keras.summary()\n");
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
        notebook.appendCode("# Confusion matrix\n");
        notebook.appendCode("from sklearn.metrics import confusion_matrix\n");
        notebook.appendCode("");
        notebook.appendCode("""
                cm = confusion_matrix(y_test, y_pred_keras)
                plt.figure(figsize=(9,9))
                plt.imshow(cm, interpolation='nearest', cmap='Pastel1')
                plt.title('Confusion matrix', size = 15)
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
        notebook.appendCode("plt.plot(np.arange(50), y_test.values[:50], '-', label='True data', color='b')\n");
        notebook.appendCode("plt.plot(np.arange(50), y_pred_keras[:50], '--', label='Predictions', color='r')\n");
        notebook.appendCode("plt.gcf().autofmt_xdate()\n");
        notebook.appendCode("plt.show()");
    }
}
