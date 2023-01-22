package io.github.d.lab2.kernel;

import io.github.d.lab2.kernel.categories.datamining.DataMining;
import io.github.d.lab2.kernel.categories.knowledge.Knowledge;
import io.github.d.lab2.kernel.categories.preprocessing.Preprocessing;
import io.github.d.lab2.kernel.categories.selection.Selection;
import io.github.d.lab2.kernel.categories.transformation.Transformation;
import io.github.d.lab2.kernel.categories.validation.Validation;
import io.github.d.lab2.kernel.generator.visitor.IStepVisitor;
import io.github.d.lab2.kernel.generator.visitor.StepVisitable;
import io.github.d.lab2.kernel.mandatory.Description;
import io.github.d.lab2.kernel.mandatory.Framework;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class App implements StepVisitable {

    private List<Framework> frameworks;
    private Description description;
    private Selection selection;
    private Preprocessing preprocessing;
    private Transformation transformation;
    private DataMining dataMining;
    private Validation validation;
    private Knowledge knowledge;

    @Override
    public void accept(IStepVisitor visitor) {
        visitor.visit(this);
    }
}
