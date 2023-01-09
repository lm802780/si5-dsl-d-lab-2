package io.github.d.lab2.kernel.categories.datamining.training;

import io.github.d.lab2.kernel.generator.visitor.IElementVisitor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class KerasTraining extends Training {
    @Override
    public void accept(IElementVisitor visitor) {
        visitor.visit(this);
    }
}
