package io.github.d.lab2.kernel.generator.visitor.strategy.impl;

import io.github.d.lab2.kernel.categories.datamining.network.Network;
import io.github.d.lab2.kernel.categories.datamining.network.layer.keras.DenseLayer;
import io.github.d.lab2.kernel.categories.datamining.network.layer.keras.DropoutLayer;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.LinearLayer;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.Sequential;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.SoftmaxLayer;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.TanhLayer;
import io.github.d.lab2.kernel.categories.datamining.training.Training;
import io.github.d.lab2.kernel.categories.preprocessing.DropNa;
import io.github.d.lab2.kernel.categories.preprocessing.ReplaceBy;
import io.github.d.lab2.kernel.categories.transformation.Normalization;
import io.github.d.lab2.kernel.categories.transformation.Reshape;
import io.github.d.lab2.kernel.categories.validation.MSEFunction;
import io.github.d.lab2.kernel.categories.validation.R2Function;
import io.github.d.lab2.kernel.categories.validation.predict.KerasPredict;
import io.github.d.lab2.kernel.categories.validation.predict.PytorchPredict;
import io.github.d.lab2.kernel.generator.visitor.strategy.IFrameworkStrategy;
import io.github.d.lab2.notebook.Notebook;

public class DefaultStrategy implements IFrameworkStrategy {

    protected Notebook notebook;

    public DefaultStrategy(Notebook notebook) {
        this.notebook = notebook;
    }

    @Override
    public void visit(DropNa dropNa) {
    }

    @Override
    public void visit(ReplaceBy replaceBy) {

    }

    @Override
    public void visit(Network network) {

    }

    @Override
    public void visit(DenseLayer denseLayer) {

    }

    @Override
    public void visit(DropoutLayer dropoutLayer) {

    }

    @Override
    public void visit(LinearLayer linearLayer) {

    }

    @Override
    public void visit(TanhLayer tanhLayer) {

    }

    @Override
    public void visit(SoftmaxLayer softmaxLayer) {

    }

    @Override
    public void visit(Training training) {

    }

    @Override
    public void visit(Sequential sequential) {

    }

    @Override
    public void visit(PytorchPredict pytorchPredict) {

    }

    @Override
    public void visit(KerasPredict kerasPredict) {

    }

    @Override
    public void visit(Reshape reshape) {

    }

    @Override
    public void visit(Normalization normalization) {
        notebook.addCellCode();
        notebook.appendCode("X_train = X_train / 255\n");
        notebook.appendCode("X_test = X_test / 255\n");
    }

    @Override
    public void visit(MSEFunction mseFunction) {

    }

    @Override
    public void visit(R2Function r2Function) {

    }
}
