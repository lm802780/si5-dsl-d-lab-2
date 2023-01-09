package io.github.d.lab2.kernel.generator;

import io.github.d.lab2.kernel.App;
import io.github.d.lab2.kernel.categories.datamining.DataMining;
import io.github.d.lab2.kernel.categories.datamining.network.KerasNetwork;
import io.github.d.lab2.kernel.categories.datamining.network.PytorchNetwork;
import io.github.d.lab2.kernel.categories.datamining.predict.KerasPredict;
import io.github.d.lab2.kernel.categories.datamining.predict.PytorchPredict;
import io.github.d.lab2.kernel.categories.datamining.training.KerasTraining;
import io.github.d.lab2.kernel.categories.datamining.training.PytorchTraining;
import io.github.d.lab2.kernel.categories.preprocessing.DropNa;
import io.github.d.lab2.kernel.categories.preprocessing.ReplaceBy;
import io.github.d.lab2.kernel.categories.transformation.Normalization;
import io.github.d.lab2.kernel.categories.transformation.Reshape;
import io.github.d.lab2.kernel.mandatory.Description;
import io.github.d.lab2.kernel.categories.knowledge.Knowledge;
import io.github.d.lab2.kernel.categories.preprocessing.Preprocessing;
import io.github.d.lab2.kernel.categories.selection.Selection;
import io.github.d.lab2.kernel.categories.validation.Validation;
import io.github.d.lab2.kernel.categories.transformation.Transformation;

import java.util.HashMap;
import java.util.Map;

public abstract class Visitor<T> {

    public abstract void visit(App app);

    public abstract void visit(Description description);

    public abstract void visit(Selection selection);

    public abstract void visit(Preprocessing preprocessing);

    public abstract void visit(Transformation transformation);

    public abstract void visit(DataMining dataMining);

    public abstract void visit(Validation validation);

    public abstract void visit(Knowledge knowledge);

    public abstract void visit(DropNa dropNa);

    public abstract void visit(ReplaceBy replaceBy);

    public abstract void visit(KerasNetwork kerasNetwork);

    public abstract void visit(PytorchNetwork pytorchNetwork);

    public abstract void visit(PytorchPredict pytorchPredict);

    public abstract void visit(KerasPredict kerasPredict);

    public abstract void visit(PytorchTraining pytorchTraining);

    public abstract void visit(KerasTraining kerasTraining);

    public abstract void visit(Reshape reshape);

    public abstract void visit(Normalization normalization);


    /***********************
     ** Helper mechanisms **
     ***********************/

    protected Map<String, Object> context = new HashMap<>();

    protected T notebook;

    public T getNotebook() {
        return notebook;
    }

}

