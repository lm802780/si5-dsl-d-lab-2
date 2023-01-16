package io.github.d.lab2.kernel.generator.visitor.strategy.impl;

import io.github.d.lab2.kernel.categories.datamining.network.Network;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.LinearLayer;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.Sequential;
import io.github.d.lab2.kernel.categories.datamining.training.Training;
import io.github.d.lab2.notebook.Notebook;

import java.util.LinkedList;

public class KerasStrategy extends DefaultStrategy {

    public KerasStrategy(Notebook notebook) {
        super(notebook);
    }

    @Override
    public void visit(Sequential sequential) {
        notebook.addCellCode("#### define network\n");
        notebook.appendCode("def Network(nbIn, nbOut):\n");
        notebook.appendCode("  model = km.Sequential()\n");
        var layers = new LinkedList<>(sequential.getLayers());
        while (!layers.isEmpty()) {
            if(!(layers.get(0)  instanceof LinearLayer)){
                throw new RuntimeException("Wrong network model");
            }
            if(layers.size() == 1){
                notebook.appendCode("  model.add(kl.Dense("+((LinearLayer) layers.get(0)).getOutFeatures()+
                        ",input_shape=("+((LinearLayer) layers.get(0)).getInFeatures()+",))\n");
                layers.removeFirst();
            }
            switch (layers.get(1).getClass().getSimpleName()){
                case "TanhLayer":
                        notebook.appendCode("  model.add(kl.Dense("+((LinearLayer) layers.get(0)).getOutFeatures()+
                                ", activation='tanh', input_shape=("+((LinearLayer) layers.get(0)).getInFeatures()+",))\n");
                        layers.removeFirst();
                        layers.removeFirst();
                        break;
                case "SoftmaxLayer":
                        notebook.appendCode("  model.add(kl.Dense("+((LinearLayer) layers.get(0)).getOutFeatures()+
                                ", activation='softmax', input_shape=("+((LinearLayer) layers.get(0)).getInFeatures()+",))\n");
                        layers.removeFirst();
                        layers.removeFirst();
                        break;
                case "LinearLayer":
                        notebook.appendCode("  model.add(kl.Dense("+((LinearLayer) layers.get(0)).getOutFeatures()+
                                ",input_shape=("+((LinearLayer) layers.get(0)).getInFeatures()+",))\n");
                    layers.removeFirst();
                    break;
                default:
                        throw new RuntimeException("Unknown layer");
            }

        }
        notebook.appendCode("  return model\n");

        notebook.addCellCode("#### create network\n");
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


}
