package io.github.d.lab2.kernel.categories.knowledge;

import io.github.d.lab2.kernel.categories.Step;
import io.github.d.lab2.kernel.generator.Visitor;
import io.github.d.lab2.notebook.Notebook;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Knowledge extends Step {

    public Knowledge() {
        super("Knowledge");
    }

    @Override
    public void accept(Visitor<Notebook> visitor) {
        visitor.visit(this);
    }
}
