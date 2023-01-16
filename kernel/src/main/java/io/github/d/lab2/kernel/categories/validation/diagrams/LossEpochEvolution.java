package io.github.d.lab2.kernel.categories.validation.diagrams;

import io.github.d.lab2.kernel.categories.validation.DiagramEnum;
import io.github.d.lab2.kernel.categories.validation.ValidationElement;
import io.github.d.lab2.kernel.generator.visitor.IElementVisitor;

public class LossEpochEvolution extends ValidationElement {

    public LossEpochEvolution() {
        super(DiagramEnum.LOSS_EPOCH_EVOLUTION);
    }

    @Override
    public void accept(IElementVisitor visitor) {
        visitor.visit(this);
    }
}

