package io.github.d.lab2.kernel.categories.datamining.network.sequential;

import io.github.d.lab2.kernel.categories.datamining.network.Network;
import io.github.d.lab2.kernel.generator.visitor.IElementVisitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sequential extends Network {
//    private List<SequentialLayer> sequentialLayers;
//
//    public Sequential() {
//        sequentialLayers = new LinkedList<>();
//    }

    @Override
    public void accept(IElementVisitor visitor) {
        visitor.visit(this);
    }
}
