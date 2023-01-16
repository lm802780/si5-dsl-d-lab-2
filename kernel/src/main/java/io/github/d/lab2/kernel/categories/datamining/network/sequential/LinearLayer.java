package io.github.d.lab2.kernel.categories.datamining.network.sequential;

import io.github.d.lab2.kernel.categories.datamining.network.Layer;
import io.github.d.lab2.kernel.generator.visitor.IElementVisitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LinearLayer implements Layer {
    private int inFeatures;
    private int outFeatures;

    @Override
    public void accept(IElementVisitor visitor) {
        visitor.visit(this);
    }
}
