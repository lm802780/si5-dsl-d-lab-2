package io.github.d.lab2.kernel.categories.preprocessing;

import io.github.d.lab2.kernel.generator.visitor.IElementVisitor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DropNa implements PreprocessingElement {

    @Override
    public void accept(IElementVisitor visitor) {
        visitor.visit(this);
    }
}
