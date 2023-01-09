package io.github.d.lab2.kernel.mandatory;

import io.github.d.lab2.kernel.generator.Visitable;
import io.github.d.lab2.kernel.generator.Visitor;
import io.github.d.lab2.notebook.Notebook;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Description implements Visitable {
    private String detail;

    @Override
    public void accept(Visitor<Notebook> visitor) {
        visitor.visit(this);
    }
}
