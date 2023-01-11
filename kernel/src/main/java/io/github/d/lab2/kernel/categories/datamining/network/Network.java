package io.github.d.lab2.kernel.categories.datamining.network;

import io.github.d.lab2.kernel.categories.datamining.DataMiningElement;
import io.github.d.lab2.kernel.generator.visitor.IElementVisitor;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class Network extends DataMiningElement {
    private List<Layer> layers;

    public Network() {
        layers = new LinkedList<>();
    }

    @Override
    public void accept(IElementVisitor visitor) {
        visitor.visit(this);
    }
}
