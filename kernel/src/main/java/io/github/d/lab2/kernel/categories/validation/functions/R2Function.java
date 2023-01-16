package io.github.d.lab2.kernel.categories.validation.functions;

import io.github.d.lab2.kernel.categories.validation.Score;
import io.github.d.lab2.kernel.generator.visitor.IElementVisitor;

public class R2Function extends Score {

    @Override
    public void accept(IElementVisitor visitor) {
        visitor.visit(this);
    }
}
