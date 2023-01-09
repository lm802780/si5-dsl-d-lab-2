package io.github.d.lab2.kernel.categories.validation.predict;

import io.github.d.lab2.kernel.generator.visitor.IElementVisitor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class KerasPredict extends Predict {

    @Override
    public void accept(IElementVisitor visitor) {
        visitor.visit(this);
    }
}
