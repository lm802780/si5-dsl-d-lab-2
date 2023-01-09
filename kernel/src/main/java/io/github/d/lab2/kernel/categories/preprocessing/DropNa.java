package io.github.d.lab2.kernel.categories.preprocessing;

import io.github.d.lab2.kernel.generator.Visitor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DropNa extends PreprocessingElement {

    @Override
    public void accept(Visitor<StringBuffer> visitor) {
        visitor.visit(this);
    }
}
