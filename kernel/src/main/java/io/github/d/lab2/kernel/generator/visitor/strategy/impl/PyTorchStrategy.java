package io.github.d.lab2.kernel.generator.visitor.strategy.impl;

import io.github.d.lab2.kernel.categories.datamining.network.Network;
import io.github.d.lab2.kernel.categories.datamining.network.layer.pytorch.LinearLayer;
import io.github.d.lab2.kernel.categories.datamining.network.layer.pytorch.SoftmaxLayer;
import io.github.d.lab2.kernel.categories.datamining.network.layer.pytorch.TanhLayer;
import io.github.d.lab2.kernel.categories.datamining.training.Training;
import io.github.d.lab2.notebook.Notebook;

public class PyTorchStrategy extends DefaultStrategy {

    public PyTorchStrategy(Notebook notebook) {
        super(notebook);
    }

    @Override
    public void visit(Network network){
        notebook.addCellCode("## define network");
        notebook.appendCode("class Network(nn.Module):");
        notebook.appendCode("  def __init__(self, nbIn, nbOut):");
        notebook.appendCode("    super(Network, self).__init__()");
        notebook.appendCode("    self.network = nn.Sequential(");
        network.getLayers().forEach(layer -> layer.accept(this));
        notebook.appendCode("    )");
        notebook.appendCode("  def forward(self, x):");
        notebook.appendCode("    return self.network(x)");

        notebook.addCellCode("## create network");
        notebook.appendCode("nbIn = X_train.shape[1]");
        notebook.appendCode("nbOut = 1");
        notebook.appendCode("model = Network(nbIn, nbOut)");
        notebook.appendCode("neuralNetwork");
    }

    @Override
    public void visit(LinearLayer linearLayer){
        notebook.appendCode("    nn.Linear("+linearLayer.getInFeatures()+","+linearLayer.getOutFeatures()+",");
    }
    @Override
    public void visit(TanhLayer tanhLayer){
        notebook.appendCode("    nn.Tanh(),");
    }

    @Override
    public void visit(SoftmaxLayer softmaxLayer){
        notebook.appendCode("    nn.Softmax(),");
    }

    @Override
    public void visit(Training training){
        notebook.addCellMarkdown();
        notebook.appendMarkdown("#### Loss/optimizers catalog");
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
        notebook.appendCode("selected_loss_function =" + loss);
        notebook.appendCode("selected_optimizer =" + optimizer);
        notebook.appendCode("learning_rate = "+training.getLearningRate());
        notebook.appendCode("nbEpochs = "+training.getEpochs());
        notebook.appendCode("batch_size = "+training.getBatchSize());
        notebook.appendCode("criterion = selected_loss_function()");
        notebook.appendCode("optimizer = selected_optimizer(neuralNetwork.parameters(), lr=learning_rate)");

        notebook.addCellCode();
        notebook.appendCode("""
                dataset = TensorDataset(input_data, target)
                dataloader = DataLoader(dataset, batch_size=batch_size, shuffle=False)
                items = []
                """);
        notebook.addCellCode("# launching iterations");
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