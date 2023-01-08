package io.github.d.lab2.kernel.categories.validation;

import io.github.d.lab2.kernel.categories.Step;
import io.github.d.lab2.kernel.generator.Visitable;
import io.github.d.lab2.kernel.generator.Visitor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class Validation extends Step {
    public Validation() {
        super("Validation");
    }

    @Override
    public void accept(Visitor<StringBuffer> visitor) {
        visitor.visit(this);
    }
}
