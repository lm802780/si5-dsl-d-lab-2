package io.github.d.lab2.kernel.generator.visitor;

import io.github.d.lab2.kernel.categories.datamining.network.Network;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.Sequential;
import io.github.d.lab2.kernel.categories.datamining.training.Training;
import io.github.d.lab2.kernel.categories.preprocessing.DropNa;
import io.github.d.lab2.kernel.categories.preprocessing.ReplaceBy;
import io.github.d.lab2.kernel.categories.transformation.Normalization;
import io.github.d.lab2.kernel.categories.transformation.Reshape;
import io.github.d.lab2.kernel.categories.validation.MSEFunction;
import io.github.d.lab2.kernel.categories.validation.R2Function;
import io.github.d.lab2.kernel.categories.validation.predict.KerasPredict;
import io.github.d.lab2.kernel.categories.validation.predict.PytorchPredict;

public interface IElementVisitor {

    void visit(DropNa dropNa);

    void visit(ReplaceBy replaceBy);

    void visit(PytorchPredict pytorchPredict);

    void visit(KerasPredict kerasPredict);


    void visit(Reshape reshape);

    void visit(Normalization normalization);

    void visit(MSEFunction mseFunction);

    void visit(R2Function r2Function);

    void visit(Network network);

    void visit(Training training);

    void visit(Sequential sequential);
}
