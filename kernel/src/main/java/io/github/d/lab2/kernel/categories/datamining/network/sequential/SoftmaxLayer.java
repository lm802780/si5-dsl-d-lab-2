package io.github.d.lab2.kernel.categories.datamining.network.sequential;

import io.github.d.lab2.kernel.generator.visitor.IElementVisitor;

public class SoftmaxLayer extends SequentialLayer {

    @Override
    public void accept(IElementVisitor visitor) {
        visitor.visit(this);
    }

}