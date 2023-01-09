package io.github.d.lab2.kernel.categories.datamining.network;

import io.github.d.lab2.kernel.categories.datamining.network.layer.Layer;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class KerasNetwork extends Network {
    private int batchSize;
    private int epochs;


    public KerasNetwork(){
        super();

    }
}
