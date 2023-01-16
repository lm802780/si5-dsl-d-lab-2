package io.github.d.lab2.kernel.generator.visitor.strategy.impl;

import io.github.d.lab2.kernel.categories.datamining.network.Network;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.LinearLayer;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.SoftmaxLayer;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.TanhLayer;
import io.github.d.lab2.kernel.categories.datamining.training.Training;
import io.github.d.lab2.kernel.categories.validation.diagrams.LossEpochEvolution;
import io.github.d.lab2.kernel.categories.validation.diagrams.Prediction;
import io.github.d.lab2.notebook.Notebook;

public class PyTorchStrategy extends DefaultStrategy {

    public PyTorchStrategy(Notebook notebook) {
        super(notebook);
    }

    @Override
    public void visit(Network network) {
        notebook.addCellCode("## define network");
        notebook.appendCode("class Network(nn.Module):");
        notebook.appendCode(1, "def __init__(self, nbIn, nbOut):");
        notebook.appendCode(2, "super(Network, self).__init__()");
        notebook.appendCode(2, "self.network = nn.Sequential(");
        network.getLayers().forEach(layer -> layer.accept(this));
        notebook.appendCode(2, ")");
        notebook.appendCode(1, "def forward(self, x):");
        notebook.appendCode(2, "return self.network(x)");

        notebook.addCellCode("## create network");
        notebook.appendCode("nbIn = X_train.shape[1]");
        notebook.appendCode("nbOut = 1");
        notebook.appendCode("model = Network(nbIn, nbOut)");
        notebook.appendCode("neuralNetwork");
    }

    @Override
    public void visit(LinearLayer linearLayer) {
        notebook.appendCode(2, "nn.Linear(" + linearLayer.getInFeatures() + "," + linearLayer.getOutFeatures() + ",\n");
    }

    @Override
    public void visit(TanhLayer tanhLayer) {
        notebook.appendCode(2, "nn.Tanh(),\n");
    }

    @Override
    public void visit(SoftmaxLayer softmaxLayer) {
        notebook.appendCode(2, "nn.Softmax(),\n");
    }

    @Override
    public void visit(Training training) {
        notebook.addCellMarkdown();
        notebook.appendMarkdown("#### Loss/optimizers catalog\n");
        notebook.addCellCode();
        String loss = switch (training.getLoss()) {
            case MSE -> "nn.MSELoss";
            case CROSSENTROPY -> "nn.CrossEntropyLoss";
            default -> throw new IllegalStateException("Unexpected value: " + training.getLoss());
        };
        String optimizer = switch (training.getOptimizer()) {
            case SGD -> "torch.optim.SGD";
            case ADAM -> "torch.optim.Adam";
            default -> throw new IllegalStateException("Unexpected value: " + training.getOptimizer());
        };
        //Hyper parameters
        notebook.appendCode("selected_loss_function =" + loss + "\n");
        notebook.appendCode("selected_optimizer =" + optimizer + "\n");
        notebook.appendCode("learning_rate = " + training.getLearningRate() + "\n");
        notebook.appendCode("nbEpochs = " + training.getEpochs() + "\n");
        notebook.appendCode("batch_size = " + training.getBatchSize() + "\n");
        notebook.appendCode("criterion = selected_loss_function()\n");
        notebook.appendCode("optimizer = selected_optimizer(neuralNetwork.parameters(), lr=learning_rate)\n");

        notebook.addCellCode();
        notebook.appendCode("""
                dataset = TensorDataset(input_data, target)
                dataloader = DataLoader(dataset, batch_size=batch_size, shuffle=False)
                items = []
                """);
        notebook.addCellCode("# launching iterations\n");
        notebook.appendCode("""
                for epoch in range(nbEpochs):
                    for id_batch, (batch_X_train, batch_y_train) in enumerate(dataloader):
                        optimizer.zero_grad()
                        output = neuralNetwork(batch_X_train)
                        loss = criterion(output, batch_y_train) # calcul de la fonction cout (moindres carrés)
                        loss.backward() # calcul du gradient (sens = droite vers gauche)
                        optimizer.step() # modification des parametres du réseau de neurones
                        print(id_batch, loss.item())
                        items.append(loss.item())
                """);
    }

    @Override
    public void visit(LossEpochEvolution lossEpochEvolution) {
        notebook.addCellCode();
        notebook.appendCode("# Loss epoch evolution\n");
        notebook.appendCode("fig, ax = plt.subplots()\n");
        notebook.appendCode("x = np.arange(len(items))\n");
        notebook.appendCode("ax.plot(x, items)\n");
        notebook.appendCode("ax.set(xlabel='number of epochs', ylabel='loss', title='Evolution')\n");
        notebook.appendCode("plt.show()");
    }

    @Override
    public void visit(Prediction prediction) {
        int size = prediction.getSize();

        notebook.addCellCode();
        notebook.appendCode("# Prediction\n");
        notebook.appendCode("ax = plt.gca()\n");
        notebook.appendCode(String.format("plt.plot(np.arange(y_train.values[:%d].size), y_train.values[:%d], '-', label='True data', color='b')%n", size, size));
        notebook.appendCode(String.format("plt.plot(np.arange(output.detach().numpy()[:%d].size), output.detach().numpy()[:%d], '--', label='Predictions', color='r')%n", size, size));
        notebook.appendCode("plt.gcf().autofmt_xdate()\n");
        notebook.appendCode("plt.show()");
    }
}
