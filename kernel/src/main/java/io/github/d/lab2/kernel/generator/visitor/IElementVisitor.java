package io.github.d.lab2.kernel.generator.visitor;

import io.github.d.lab2.kernel.categories.datamining.network.sequential.LinearLayer;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.Sequential;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.SoftmaxLayer;
import io.github.d.lab2.kernel.categories.datamining.network.sequential.TanhLayer;
import io.github.d.lab2.kernel.categories.datamining.training.Training;
import io.github.d.lab2.kernel.categories.preprocessing.DropNa;
import io.github.d.lab2.kernel.categories.preprocessing.ReplaceBy;
import io.github.d.lab2.kernel.categories.transformation.Normalization;
import io.github.d.lab2.kernel.categories.transformation.Reshape;
import io.github.d.lab2.kernel.categories.validation.diagrams.ConfusionMatrix;
import io.github.d.lab2.kernel.categories.validation.diagrams.LossEpochEvolution;
import io.github.d.lab2.kernel.categories.validation.diagrams.Prediction;
import io.github.d.lab2.kernel.categories.validation.functions.MSEFunction;
import io.github.d.lab2.kernel.categories.validation.functions.R2Function;

public interface IElementVisitor {

    void visit(DropNa dropNa);

    void visit(ReplaceBy replaceBy);

    void visit(Reshape reshape);

    void visit(Normalization normalization);

    void visit(ConfusionMatrix confusionMatrix);

    void visit(LossEpochEvolution lossEpochEvolution);

    void visit(Prediction prediction);

//    void visit(Network network);

    void visit(Training training);

    void visit(Sequential sequential);


    void visit(LinearLayer linearLayer);

    void visit(SoftmaxLayer softmaxLayer);

    void visit(TanhLayer tanhLayer);

    void visit(MSEFunction mseFunction);

    void visit(R2Function r2Function);

}
