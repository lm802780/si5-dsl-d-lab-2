package io.github.d.lab2.kernel.categories.transformation;

import io.github.d.lab2.kernel.enums.TypeEnum;
import io.github.d.lab2.kernel.generator.visitor.IElementVisitor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Reshape extends TransformationElement {
    private TypeEnum type;
    private List<Double> reshapeValues;
    @Override
    public void accept(IElementVisitor visitor) {
        visitor.visit(this);
    }

}
