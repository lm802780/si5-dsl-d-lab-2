package io.github.d.lab2.kernel.categories.validation.predict;

import io.github.d.lab2.kernel.generator.Visitable;
import io.github.d.lab2.kernel.generator.Visitor;
import io.github.d.lab2.notebook.Notebook;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class Predict implements Visitable {

    public abstract void accept(Visitor<Notebook> visitor);
}
