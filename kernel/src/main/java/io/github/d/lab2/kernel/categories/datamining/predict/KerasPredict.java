package io.github.d.lab2.kernel.categories.datamining.predict;

import io.github.d.lab2.kernel.generator.Visitor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class KerasPredict extends Predict {

    @Override
    public void accept(Visitor<StringBuffer> visitor) {
        visitor.visit(this);
    }
}
