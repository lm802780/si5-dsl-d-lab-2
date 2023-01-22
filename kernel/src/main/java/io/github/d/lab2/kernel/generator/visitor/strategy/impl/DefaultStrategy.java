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
import io.github.d.lab2.kernel.categories.preprocessing.DropNa;
import io.github.d.lab2.kernel.categories.preprocessing.ReplaceBy;
import io.github.d.lab2.kernel.categories.transformation.Normalization;
import io.github.d.lab2.kernel.categories.transformation.Reshape;
import io.github.d.lab2.kernel.categories.validation.diagrams.ConfusionMatrix;
import io.github.d.lab2.kernel.categories.validation.diagrams.LossEpochEvolution;
import io.github.d.lab2.kernel.categories.validation.diagrams.Prediction;
import io.github.d.lab2.kernel.generator.visitor.strategy.IFrameworkStrategy;
import io.github.d.lab2.notebook.Notebook;

public class DefaultStrategy implements IFrameworkStrategy {

    protected Notebook notebook;

    public DefaultStrategy(Notebook notebook) {
        this.notebook = notebook;
    }

    @Override
    public void visit(DropNa dropNa) {
        // Empty
    }

    @Override
    public void visit(ReplaceBy replaceBy) {
        // Empty
    }


    @Override
    public void visit(Training training) {
        // Empty
    }

    @Override
    public void visit(Sequential sequential) {
        // Empty
    }

    @Override
    public void visit(LinearLayer linearLayer) {
        // Empty
    }

    @Override
    public void visit(SoftmaxLayer softmaxLayer) {
        // Empty
    }

    @Override
    public void visit(TanhLayer tanhLayer) {
        // Empty
    }

    @Override
    public void visit(SigmoidLayer sigmoidLayer) {
        // Empty
    }

    @Override
    public void visit(SoftplusLayer softplusLayer) {
        // Empty
    }

    @Override
    public void visit(SoftsignLayer softsignLayer) {
        // Empty
    }

    @Override
    public void visit(SeluLayer seluLayer) {
        // Empty
    }

    @Override
    public void visit(EluLayer eluLayer) {
        // Empty
    }

    @Override
    public void visit(Reshape reshape) {
        // Empty
    }

    @Override
    public void visit(Normalization normalization) {
        notebook.addCellCode();
        notebook.appendCode("X_train = X_train / 255\n");
        notebook.appendCode("X_test = X_test / 255");
    }

    @Override
    public void visit(ConfusionMatrix confusionMatrix) {
        // Empty
    }

    @Override
    public void visit(LossEpochEvolution lossEpochEvolution) {
        // Empty
    }

    @Override
    public void visit(Prediction prediction) {
        // Empty
    }
}
