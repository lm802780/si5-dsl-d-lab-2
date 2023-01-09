package io.github.d.lab2.kernel.generator.visitor;

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

public interface IElementVisitor {

    void visit(DropNa dropNa);

    void visit(ReplaceBy replaceBy);

    void visit(KerasNetwork kerasNetwork);

    void visit(PytorchNetwork pytorchNetwork);

    void visit(PytorchPredict pytorchPredict);

    void visit(KerasPredict kerasPredict);

    void visit(PytorchTraining pytorchTraining);

    void visit(KerasTraining kerasTraining);

    void visit(Reshape reshape);

    void visit(Normalization normalization);

    void visit(MSEFunction mseFunction);

    void visit(R2Function r2Function);
}
