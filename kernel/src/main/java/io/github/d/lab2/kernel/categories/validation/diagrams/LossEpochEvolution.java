package io.github.d.lab2.kernel.categories.validation.diagrams;

import io.github.d.lab2.kernel.categories.validation.ValidationElement;
import io.github.d.lab2.kernel.generator.visitor.IElementVisitor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LossEpochEvolution implements ValidationElement {

    @Override
    public void accept(IElementVisitor visitor) {
        visitor.visit(this);
    }
}

