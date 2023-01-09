package io.github.d.lab2.kernel.categories.transformation;

import io.github.d.lab2.kernel.categories.Step;
import io.github.d.lab2.kernel.generator.Visitable;
import io.github.d.lab2.kernel.generator.Visitor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Transformation extends Step {
    private List<Reshape> reshape;
    private Normalization normalization;

    public Transformation() {
        super("Transformation");
    }

    @Override
    public void accept(Visitor<StringBuffer> visitor) {
        visitor.visit(this);
    }
}
