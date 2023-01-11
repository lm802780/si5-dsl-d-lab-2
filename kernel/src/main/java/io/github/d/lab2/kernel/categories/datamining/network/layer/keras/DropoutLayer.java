package io.github.d.lab2.kernel.categories.datamining.network.layer.keras;


import io.github.d.lab2.kernel.categories.datamining.network.Layer;
import io.github.d.lab2.kernel.generator.visitor.IElementVisitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Deprecated
public class DropoutLayer extends Layer {
    private double rate;

    public DropoutLayer(){
        super();
    }

    @Override
    public void accept(IElementVisitor visitor) {

    }
}
