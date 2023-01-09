package io.github.d.lab2.kernel.categories.validation.predict;

import io.github.d.lab2.kernel.generator.visitor.Visitable;
import io.github.d.lab2.kernel.generator.visitor.AbstractStepVisitor;
import io.github.d.lab2.notebook.Notebook;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class Predict implements Visitable {

    public abstract void accept(AbstractStepVisitor<Notebook> visitor);
}
