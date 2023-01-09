package io.github.d.lab2.kernel;

import io.github.d.lab2.kernel.categories.datamining.DataMining;
import io.github.d.lab2.kernel.mandatory.Description;
import io.github.d.lab2.kernel.categories.knowledge.Knowledge;
import io.github.d.lab2.kernel.categories.preprocessing.Preprocessing;
import io.github.d.lab2.kernel.categories.selection.Selection;
import io.github.d.lab2.kernel.categories.validation.Validation;
import io.github.d.lab2.kernel.categories.transformation.Transformation;
import io.github.d.lab2.kernel.generator.Visitable;
import io.github.d.lab2.kernel.generator.Visitor;
import io.github.d.lab2.notebook.Notebook;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class App implements Visitable {

    private Description description;
    private Selection selection;
    private Preprocessing preprocessing;
    private Transformation transformation;
    private DataMining dataMining;
    private Validation validation;
    private Knowledge knowledge;

    @Override
    public void accept(Visitor<Notebook> visitor) {
        visitor.visit(this);
    }
}
