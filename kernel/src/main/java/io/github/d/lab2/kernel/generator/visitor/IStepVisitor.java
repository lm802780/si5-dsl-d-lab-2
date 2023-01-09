package io.github.d.lab2.kernel.generator.visitor;

import io.github.d.lab2.kernel.App;
import io.github.d.lab2.kernel.categories.datamining.DataMining;
import io.github.d.lab2.kernel.categories.knowledge.Knowledge;
import io.github.d.lab2.kernel.categories.preprocessing.Preprocessing;
import io.github.d.lab2.kernel.categories.selection.Selection;
import io.github.d.lab2.kernel.categories.transformation.Transformation;
import io.github.d.lab2.kernel.categories.validation.Validation;
import io.github.d.lab2.kernel.mandatory.Description;

public interface IStepVisitor extends IElementVisitor {

    void visit(App app);

    void visit(Description description);

    void visit(Selection selection);

    void visit(Preprocessing preprocessing);

    void visit(Transformation transformation);

    void visit(DataMining dataMining);

    void visit(Validation validation);

    void visit(Knowledge knowledge);
}
