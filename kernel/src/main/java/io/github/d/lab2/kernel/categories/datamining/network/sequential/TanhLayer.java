package io.github.d.lab2.kernel.categories.datamining.network.sequential;

import io.github.d.lab2.kernel.categories.datamining.network.Layer;
import io.github.d.lab2.kernel.generator.visitor.IElementVisitor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class TanhLayer implements Layer {
    @Override
    public void accept(IElementVisitor visitor) {
        visitor.visit(this);
    }
}
