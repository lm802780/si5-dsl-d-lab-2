package io.github.d.lab2.kernel.generator.visitor.strategy.impl;

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
        notebook.appendCode("class TorchNetwork(nn.Module):\n");
        notebook.appendCode(1,"def __init__(self, nbIn, nbOut):\n");
        notebook.appendCode(2,"super(TorchNetwork, self).__init__()\n");
        notebook.appendCode(2,"self.network = nn.Sequential(\n");
        sequential.getLayers().forEach(layer -> {
            layer.accept(this);
        });
        notebook.appendCode(2,")\n");
        notebook.appendCode(1,"def forward(self, x):\n");
        notebook.appendCode(2,"return self.network(x)");

        notebook.addCellCode("#### create network\n");
        notebook.appendCode("nbIn = input_data.shape[1]\n");
        notebook.appendCode("nbOut = 1\n");
        notebook.appendCode("model_torch = TorchNetwork(nbIn, nbOut)\n");
        notebook.appendCode("model_torch");
    }

    @Override
    public void visit(LinearLayer linearLayer){
        notebook.appendCode(3,"nn.Linear("+linearLayer.getInFeatures()+","+linearLayer.getOutFeatures()+"),\n");
    }

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
        notebook.appendCode("selected_loss_function_torch = " + loss+"\n");
        notebook.appendCode("selected_optimizer_torch = " + optimizer+"\n");
        notebook.appendCode("learning_rate = "+training.getLearningRate()+"\n");
        notebook.appendCode("nbEpochs = "+training.getEpochs()+"\n");
        notebook.appendCode("batch_size = "+training.getBatchSize()+"\n");
        notebook.appendCode("criterion_torch = selected_loss_function_torch()\n");
        notebook.appendCode("optimizer_torch = selected_optimizer_torch(model_torch.parameters(), lr=learning_rate)");

        notebook.addCellCode();
        notebook.appendCode("""
                torch_tensor_dataset = TensorDataset(input_data, target)
                torch_dataloader = DataLoader(torch_tensor_dataset, batch_size=batch_size, shuffle=False)
                items = []
                """);
        notebook.addCellCode("#### launching iterations\n");
        notebook.appendCode("""
                for epoch in range(nbEpochs):
                    for id_batch, (batch_X_train, batch_y_train) in enumerate(torch_dataloader):
                        optimizer_torch.zero_grad()
                        output = model_torch(batch_X_train)
                        loss_torch = criterion_torch(output, batch_y_train)
                        loss_torch.backward()
                        optimizer_torch.step()
                        print(id_batch, loss_torch.item())
                        items.append(loss_torch.item())
                """);
    }
}
