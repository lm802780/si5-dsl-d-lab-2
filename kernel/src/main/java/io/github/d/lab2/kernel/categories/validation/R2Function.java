package io.github.d.lab2.kernel.categories.validation;

import io.github.d.lab2.kernel.generator.visitor.IElementVisitor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class R2Function extends ValidationElement {

    @Override
    public void accept(IElementVisitor visitor) {
        visitor.visit(this);
    }
}
