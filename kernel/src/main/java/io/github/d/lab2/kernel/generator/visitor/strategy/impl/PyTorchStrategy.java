package io.github.d.lab2.kernel.generator.visitor.strategy.impl;

import io.github.d.lab2.kernel.categories.datamining.network.Network;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.LinearLayer;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.Sequential;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.SoftmaxLayer;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.TanhLayer;
import io.github.d.lab2.kernel.categories.datamining.training.Training;
import io.github.d.lab2.notebook.Notebook;

public class PyTorchStrategy extends DefaultStrategy {

    public PyTorchStrategy(Notebook notebook) {
        super(notebook);
    }

    @Override
    public void visit(Sequential sequential){
        notebook.addCellCode("#### define network\n");
        notebook.appendCode("class Network(nn.Module):\n");
        notebook.appendCode(1,"def __init__(self, nbIn, nbOut):\n");
        notebook.appendCode(2,"super(Network, self).__init__()\n");
        notebook.appendCode(2,"self.network = nn.Sequential(\n");
        sequential.getLayers().forEach(layer -> {
            layer.accept(this);
        });
        notebook.appendCode(2,")\n");
        notebook.appendCode(1,"def forward(self, x):\n");
        notebook.appendCode(2,"return self.network(x)");

        notebook.addCellCode("#### create network\n");
        notebook.appendCode("nbIn = X_train.shape[1]\n");
        notebook.appendCode("nbOut = 1\n");
        notebook.appendCode("model = Network(nbIn, nbOut)\n");
        notebook.appendCode("neuralNetwork");
    }

    @Override
    public void visit(LinearLayer linearLayer){
        notebook.appendCode(3,"nn.Linear("+linearLayer.getInFeatures()+","+linearLayer.getOutFeatures()+"),\n");
    }

//    @Override
//    public void visit(Sequential sequential) {
//
//    }

    @Override
    public void visit(TanhLayer tanhLayer){
        notebook.appendCode(3,"nn.Tanh(),\n");
    }

    @Override
    public void visit(SoftmaxLayer softmaxLayer){
        notebook.appendCode(3,"nn.Softmax(),\n");
    }

    @Override
    public void visit(Training training){
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
        notebook.appendCode("selected_loss_function =" + loss+"\n");
        notebook.appendCode("selected_optimizer =" + optimizer+"\n");
        notebook.appendCode("learning_rate = "+training.getLearningRate()+"\n");
        notebook.appendCode("nbEpochs = "+training.getEpochs()+"\n");
        notebook.appendCode("batch_size = "+training.getBatchSize()+"\n");
        notebook.appendCode("criterion = selected_loss_function()\n");
        notebook.appendCode("optimizer = selected_optimizer(neuralNetwork.parameters(), lr=learning_rate)");

        notebook.addCellCode();
        notebook.appendCode("""
                dataset = TensorDataset(input_data, target)
                dataloader = DataLoader(dataset, batch_size=batch_size, shuffle=False)
                items = []
                """);
        notebook.addCellCode("#### launching iterations\n");
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
}
