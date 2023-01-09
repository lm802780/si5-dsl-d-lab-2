package io.github.d.lab2.kernel.categories.datamining.training;

import io.github.d.lab2.kernel.generator.Visitor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class KerasTraining extends Training {
    @Override
    public void accept(Visitor<StringBuffer> visitor) {
        visitor.visit(this);
    }
}
