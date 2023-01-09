package io.github.d.lab2.kernel.categories.datamining.network;

import io.github.d.lab2.kernel.categories.datamining.network.layer.Layer;
import io.github.d.lab2.kernel.generator.Visitor;
import io.github.d.lab2.notebook.Notebook;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class KerasNetwork extends Network {

    public KerasNetwork(){
        super();
    }

    @Override
    public void accept(Visitor<Notebook> visitor) {
        visitor.visit(this);
    }
}
