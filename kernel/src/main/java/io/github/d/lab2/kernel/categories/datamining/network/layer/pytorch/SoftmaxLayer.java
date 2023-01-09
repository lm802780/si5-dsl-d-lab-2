package io.github.d.lab2.kernel.categories.datamining.network.layer.pytorch;

import io.github.d.lab2.kernel.categories.datamining.network.layer.Layer;
import io.github.d.lab2.kernel.generator.visitor.IElementVisitor;

public class SoftmaxLayer extends Layer {



    @Override
    public void accept(IElementVisitor visitor) {
        visitor.visit(this);
    }

}
