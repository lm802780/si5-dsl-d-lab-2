package io.github.d.lab2.kernel.categories.transformation;

import io.github.d.lab2.kernel.categories.Step;
import io.github.d.lab2.kernel.generator.Visitor;
import io.github.d.lab2.notebook.Notebook;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Transformation extends Step {
    private List<TransformationElement> elements;


    public Transformation() {
        super("Transformation");
        elements = new ArrayList<>();
    }

    @Override
    public void accept(Visitor<Notebook> visitor) {
        visitor.visit(this);
    }
}
