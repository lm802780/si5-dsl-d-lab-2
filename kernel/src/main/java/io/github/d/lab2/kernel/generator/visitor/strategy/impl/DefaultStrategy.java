package io.github.d.lab2.kernel.generator.visitor.strategy.impl;

import io.github.d.lab2.kernel.categories.datamining.network.KerasNetwork;
import io.github.d.lab2.kernel.categories.datamining.network.PytorchNetwork;
import io.github.d.lab2.kernel.categories.datamining.training.KerasTraining;
import io.github.d.lab2.kernel.categories.datamining.training.PytorchTraining;
import io.github.d.lab2.kernel.categories.preprocessing.DropNa;
import io.github.d.lab2.kernel.categories.preprocessing.ReplaceBy;
import io.github.d.lab2.kernel.categories.transformation.Normalization;
import io.github.d.lab2.kernel.categories.transformation.Reshape;
import io.github.d.lab2.kernel.categories.validation.MSEFunction;
import io.github.d.lab2.kernel.categories.validation.R2Function;
import io.github.d.lab2.kernel.categories.validation.predict.KerasPredict;
import io.github.d.lab2.kernel.categories.validation.predict.PytorchPredict;
import io.github.d.lab2.kernel.generator.visitor.strategy.IFrameworkStrategy;

public class DefaultStrategy implements IFrameworkStrategy {

    @Override
    public void visit(DropNa dropNa) {

    }

    @Override
    public void visit(ReplaceBy replaceBy) {

    }

    @Override
    public void visit(KerasNetwork kerasNetwork) {

    }

    @Override
    public void visit(PytorchNetwork pytorchNetwork) {

    }

    @Override
    public void visit(PytorchPredict pytorchPredict) {

    }

    @Override
    public void visit(KerasPredict kerasPredict) {

    }

    @Override
    public void visit(PytorchTraining pytorchTraining) {

    }

    @Override
    public void visit(KerasTraining kerasTraining) {

    }

    @Override
    public void visit(Reshape reshape) {

    }

    @Override
    public void visit(Normalization normalization) {

    }

    @Override
    public void visit(MSEFunction mseFunction) {

    }

    @Override
    public void visit(R2Function r2Function) {

    }
}
