package io.github.d.lab2.kernel.categories.validation.functions;

import io.github.d.lab2.kernel.categories.validation.ValidationElement;
import io.github.d.lab2.kernel.generator.visitor.IElementVisitor;

public class MSEFunction extends ValidationElement {

    @Override
    public void accept(IElementVisitor visitor) {
        visitor.visit(this);
    }
}
