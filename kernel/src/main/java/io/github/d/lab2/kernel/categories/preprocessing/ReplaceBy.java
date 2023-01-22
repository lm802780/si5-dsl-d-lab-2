package io.github.d.lab2.kernel.categories.preprocessing;

import io.github.d.lab2.kernel.generator.visitor.IElementVisitor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReplaceBy implements PreprocessingElement {
    private String toReplace;
    private String value;

    @Override
    public void accept(IElementVisitor visitor) {
        visitor.visit(this);
    }
}
