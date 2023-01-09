package io.github.d.lab2.kernel.categories.transformation;

import io.github.d.lab2.kernel.generator.visitor.IElementVisitor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Normalization extends TransformationElement {
    @Override
    public void accept(IElementVisitor visitor) {
        visitor.visit(this);
    }
}
