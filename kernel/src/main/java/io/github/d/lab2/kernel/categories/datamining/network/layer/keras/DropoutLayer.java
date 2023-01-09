package io.github.d.lab2.kernel.categories.datamining.network.layer.keras;


import io.github.d.lab2.kernel.categories.datamining.network.layer.Layer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DropoutLayer extends Layer {
    private double rate;

    public DropoutLayer(){
        super();
    }

}
