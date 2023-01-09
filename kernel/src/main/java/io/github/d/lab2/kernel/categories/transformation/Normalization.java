package io.github.d.lab2.kernel.categories.transformation;

import io.github.d.lab2.kernel.enums.TypeEnum;
import io.github.d.lab2.kernel.generator.visitor.IElementVisitor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class Normalization extends TransformationElement {
    private Map<TypeEnum, Double> normalizationElem;
    @Override
    public void accept(IElementVisitor visitor) {
        visitor.visit(this);
    }
}
