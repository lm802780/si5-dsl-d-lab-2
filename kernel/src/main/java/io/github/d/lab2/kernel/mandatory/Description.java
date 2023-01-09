package io.github.d.lab2.kernel.mandatory;

import io.github.d.lab2.kernel.generator.visitor.IStepVisitor;
import io.github.d.lab2.kernel.generator.visitor.StepVisitable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Description implements StepVisitable {
    private String detail;

    @Override
    public void accept(IStepVisitor visitor) {
        visitor.visit(this);
    }
}
