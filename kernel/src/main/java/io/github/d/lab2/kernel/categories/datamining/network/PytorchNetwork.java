package io.github.d.lab2.kernel.categories.datamining.network;

import io.github.d.lab2.kernel.generator.Visitor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class PytorchNetwork extends Network{

    public PytorchNetwork(){
        super();
    }

    @Override
    public void accept(Visitor<StringBuffer> visitor) {
        visitor.visit(this);
    }
}
