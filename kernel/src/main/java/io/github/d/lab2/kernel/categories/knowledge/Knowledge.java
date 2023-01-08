package io.github.d.lab2.kernel.categories.knowledge;

import io.github.d.lab2.kernel.categories.Step;
import io.github.d.lab2.kernel.generator.Visitable;
import io.github.d.lab2.kernel.generator.Visitor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Knowledge extends Step {

    public Knowledge() {
        super("Knowledge");
    }

    @Override
    public void accept(Visitor<StringBuffer> visitor) {
        visitor.visit(this);
    }
}
