package io.github.d.lab2.kernel.categories.validation.diagrams;

import io.github.d.lab2.kernel.categories.validation.DiagramEnum;
import io.github.d.lab2.kernel.categories.validation.ValidationElement;
import io.github.d.lab2.kernel.generator.visitor.IElementVisitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Prediction extends ValidationElement {
    private int size;

    public Prediction(int size) {
        super(DiagramEnum.PREDICTION);
        this.size = size;
    }

    @Override
    public void accept(IElementVisitor visitor) {
        visitor.visit(this);
    }
}
