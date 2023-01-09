package io.github.d.lab2.kernel.categories.transformation;

import io.github.d.lab2.kernel.categories.Step;
import io.github.d.lab2.kernel.generator.Visitor;
import io.github.d.lab2.notebook.Notebook;
import lombok.Getter;
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
    public void accept(Visitor<Notebook> visitor) {
        visitor.visit(this);
    }
}
