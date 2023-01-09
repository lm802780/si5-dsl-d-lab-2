package io.github.d.lab2.kernel.categories.datamining.training;

import io.github.d.lab2.kernel.generator.Visitor;
import io.github.d.lab2.notebook.Notebook;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class KerasTraining extends Training {
    @Override
    public void accept(Visitor<Notebook> visitor) {
        visitor.visit(this);
    }
}
