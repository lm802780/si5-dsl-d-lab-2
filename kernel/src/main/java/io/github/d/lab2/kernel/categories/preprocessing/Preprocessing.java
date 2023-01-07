package io.github.d.lab2.kernel.categories.preprocessing;

import io.github.d.lab2.kernel.enums.ProcessingEnum;
import io.github.d.lab2.kernel.generator.Visitable;
import io.github.d.lab2.kernel.generator.Visitor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Preprocessing implements Visitable {
    private ProcessingEnum processing;

    @Override
    public void accept(Visitor<StringBuffer> visitor) {
        visitor.visit(this);
    }
}
