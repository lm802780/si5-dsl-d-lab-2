package io.github.d.lab2.kernel.categories.datamining.training;

import io.github.d.lab2.kernel.generator.visitor.AbstractStepVisitor;
import io.github.d.lab2.notebook.Notebook;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PytorchTraining extends Training{
    @Override
    public void accept(AbstractStepVisitor<Notebook> visitor) {
        visitor.visit(this);
    }
}
