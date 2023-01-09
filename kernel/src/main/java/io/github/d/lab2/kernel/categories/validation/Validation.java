package io.github.d.lab2.kernel.categories.validation;

import io.github.d.lab2.kernel.categories.Step;
import io.github.d.lab2.kernel.categories.validation.predict.Predict;
import io.github.d.lab2.kernel.generator.Visitor;
import io.github.d.lab2.notebook.Notebook;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Validation extends Step {

    private Predict predict;

    // TODO: use List?
    private ValidationElement validationElement;

    public Validation() {
        super("Validation");
    }

    @Override
    public void accept(Visitor<Notebook> visitor) {
        visitor.visit(this);
    }
}
