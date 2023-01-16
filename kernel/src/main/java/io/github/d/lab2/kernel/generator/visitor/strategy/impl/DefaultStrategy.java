package io.github.d.lab2.kernel.generator.visitor.strategy.impl;

import io.github.d.lab2.kernel.categories.datamining.network.Network;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.Sequential;
import io.github.d.lab2.kernel.categories.datamining.training.Training;
import io.github.d.lab2.kernel.categories.preprocessing.DropNa;
import io.github.d.lab2.kernel.categories.preprocessing.ReplaceBy;
import io.github.d.lab2.kernel.categories.transformation.Normalization;
import io.github.d.lab2.kernel.categories.transformation.Reshape;
import io.github.d.lab2.kernel.categories.validation.diagrams.LossEpochEvolution;
import io.github.d.lab2.kernel.categories.validation.diagrams.Prediction;
import io.github.d.lab2.kernel.categories.validation.functions.MSEFunction;
import io.github.d.lab2.kernel.categories.validation.functions.R2Function;
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
    public void visit(Training training) {
        System.out.println("Training default");
    }

    @Override
    public void visit(Sequential sequential) {
    }

    @Override
    public void visit(MSEFunction mseFunction) {

    }

    @Override
    public void visit(R2Function r2Function) {

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
    public void visit(LossEpochEvolution lossEpochEvolution) {

    }

    @Override
    public void visit(Prediction prediction) {

    }
}
