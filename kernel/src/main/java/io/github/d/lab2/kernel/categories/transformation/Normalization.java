package io.github.d.lab2.kernel.categories.transformation;

import io.github.d.lab2.kernel.generator.Visitor;
import io.github.d.lab2.notebook.Notebook;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Normalization extends TransformationElement {
    @Override
    public void accept(Visitor<Notebook> visitor) {
        visitor.visit(this);
    }
}
