package io.github.d.lab2.kernel.categories.transformation;

import io.github.d.lab2.kernel.enums.TypeEnum;
import io.github.d.lab2.kernel.generator.Visitor;
import io.github.d.lab2.notebook.Notebook;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Reshape extends TransformationElement {
    private TypeEnum type;
    // TODO: how to get an array of integer?
    @Override
    public void accept(Visitor<Notebook> visitor) {
        visitor.visit(this);
    }

}
