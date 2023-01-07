package io.github.d.lab2.kernel.generator;

import io.github.d.lab2.kernel.App;
import io.github.d.lab2.kernel.categories.datamining.DataMining;
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

    /***********************
     ** Helper mechanisms **
     ***********************/

    protected Map<String, Object> context = new HashMap<>();

    protected T result;

    public T getResult() {
        return result;
    }

}

