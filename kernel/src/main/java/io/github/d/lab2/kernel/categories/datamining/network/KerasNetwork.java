package io.github.d.lab2.kernel.categories.datamining.network;

import io.github.d.lab2.kernel.generator.visitor.IElementVisitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KerasNetwork extends Network {

    public KerasNetwork(){
        super();
    }

    @Override
    public void accept(IElementVisitor visitor) {
        visitor.visit(this);
    }
}
