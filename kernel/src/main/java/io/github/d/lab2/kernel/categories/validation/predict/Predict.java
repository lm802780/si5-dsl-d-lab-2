package io.github.d.lab2.kernel.categories.validation.predict;

import io.github.d.lab2.kernel.generator.visitor.ElementVisitable;
import io.github.d.lab2.kernel.generator.visitor.IElementVisitor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class Predict implements ElementVisitable {

    public abstract void accept(IElementVisitor visitor);
}
