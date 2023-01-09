package io.github.d.lab2.kernel.categories.datamining.network;

import io.github.d.lab2.kernel.categories.datamining.DataMiningElement;
import io.github.d.lab2.kernel.categories.datamining.network.layer.Layer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public abstract class Network extends DataMiningElement {
    private List<Layer> layers;

    public Network(){
        layers=new LinkedList<>();
    }
}
