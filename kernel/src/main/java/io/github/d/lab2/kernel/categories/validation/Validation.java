package io.github.d.lab2.kernel.categories.validation;

import io.github.d.lab2.kernel.categories.Step;
import io.github.d.lab2.kernel.categories.validation.predict.Predict;
import io.github.d.lab2.kernel.generator.visitor.IStepVisitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Validation extends Step {

    private Predict predict;

    private ValidationElement validationElement;

    public Validation() {
        super("Validation");
    }

    @Override
    public void accept(IStepVisitor visitor) {
        visitor.visit(this);
    }
}
