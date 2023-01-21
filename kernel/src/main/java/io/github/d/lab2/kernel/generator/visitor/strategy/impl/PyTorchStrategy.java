package io.github.d.lab2.kernel.generator.visitor.strategy.impl;

import io.github.d.lab2.kernel.categories.datamining.network.sequential.EluLayer;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.LinearLayer;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.SeluLayer;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.Sequential;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.SigmoidLayer;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.SoftmaxLayer;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.SoftplusLayer;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.SoftsignLayer;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.TanhLayer;
import io.github.d.lab2.kernel.categories.datamining.training.Training;
import io.github.d.lab2.kernel.categories.validation.diagrams.ConfusionMatrix;
import io.github.d.lab2.kernel.categories.validation.diagrams.Prediction;
import io.github.d.lab2.notebook.Notebook;

public class PyTorchStrategy extends DefaultStrategy {

    public PyTorchStrategy(Notebook notebook) {
        super(notebook);
    }

    @Override
    public void visit(Sequential sequential) {
        notebook.addCellCode("#### define network\n");
        notebook.appendCode("class TorchNetwork(nn.Module):\n");
        notebook.appendCode(1, "def __init__(self, nbIn, nbOut):\n");
        notebook.appendCode(2, "super(TorchNetwork, self).__init__()\n");
        notebook.appendCode(2, "self.network = nn.Sequential(\n");
        sequential.getLayers().forEach(layer -> layer.accept(this));
        notebook.appendCode(2, ")\n");
        notebook.appendCode(1, "def forward(self, x):\n");
        notebook.appendCode(2, "return self.network(x)");

        notebook.addCellCode("#### create network\n");
        notebook.appendCode("nbIn = input_data.shape[1]\n");
        notebook.appendCode("nbOut = 1\n");
        notebook.appendCode("model_torch = TorchNetwork(nbIn, nbOut)\n");
        notebook.appendCode("model_torch");
    }

    @Override
    public void visit(LinearLayer linearLayer) {
        notebook.appendCode(3, String.format("nn.Linear(%d, %d),%n", linearLayer.getInFeatures(),
                linearLayer.getOutFeatures()));
    }

    @Override
    public void visit(TanhLayer tanhLayer) {
        notebook.appendCode(3, "nn.Tanh(),\n");
    }

    @Override
    public void visit(SoftmaxLayer softmaxLayer) {
        notebook.appendCode(3, "nn.Softmax(),\n");
    }

    @Override
    public void visit(SigmoidLayer sigmoidLayer) {
        notebook.appendCode(3, "nn.Sigmoid(),\n");
    }

    @Override
    public void visit(SoftplusLayer softplusLayer) {
        notebook.appendCode(3, "nn.Softplus(),\n");
    }

    @Override
    public void visit(SoftsignLayer softsignLayer) {
        notebook.appendCode(3, "nn.Softsign(),\n");
    }

    @Override
    public void visit(SeluLayer seluLayer) {
        notebook.appendCode(3, "nn.SELU(),\n");
    }

    @Override
    public void visit(EluLayer eluLayer) {
        notebook.appendCode(3, "nn.ELU(),\n");
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
        notebook.appendCode("selected_loss_function_torch = " + loss + "\n");
        notebook.appendCode("selected_optimizer_torch = " + optimizer + "\n");
        notebook.appendCode("learning_rate = " + training.getLearningRate() + "\n");
        notebook.appendCode("nbEpochs = " + training.getEpochs() + "\n");
        notebook.appendCode("batch_size = " + training.getBatchSize() + "\n");
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

    @Override
    public void visit(ConfusionMatrix confusionMatrix) {
        notebook.addCellCode();
        notebook.appendCode("# Confusion matrix (PyTorch)\n");
        notebook.appendCode("from sklearn.metrics import confusion_matrix\n");
        notebook.appendCode("");
        notebook.appendCode("""
                cm = confusion_matrix(y_test, y_pred_torch.detach().numpy())
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
    public void visit(Prediction prediction) {
        notebook.addCellCode();
        notebook.appendCode("# Prediction (PyTorch)\n");
        notebook.appendCode("X_test_torch = torch.FloatTensor(X_test.select_dtypes(include=['int', 'float']).values)" +
                "\n");
        notebook.appendCode("y_pred_torch = model_torch(X_test_torch)\n");
        notebook.appendCode("ax = plt.gca()\n");
        notebook.appendCode("plt.plot(np.arange(50), y_test.values[:50], '-', label='True data', color='b')\n");
        notebook.appendCode("plt.plot(np.arange(50), y_pred_torch.detach().numpy()[:50], '--', label='Predictions', " +
                "color='r')\n");
        notebook.appendCode("plt.gcf().autofmt_xdate()\n");
        notebook.appendCode("plt.show()");
    }
}
