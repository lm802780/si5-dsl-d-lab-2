package io.github.d.lab2.kernel.categories.validation;

import io.github.d.lab2.kernel.generator.visitor.AbstractStepVisitor;
import io.github.d.lab2.notebook.Notebook;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class R2Function extends ValidationElement {

    @Override
    public void accept(AbstractStepVisitor<Notebook> visitor) {
        visitor.visit(this);
    }
}
