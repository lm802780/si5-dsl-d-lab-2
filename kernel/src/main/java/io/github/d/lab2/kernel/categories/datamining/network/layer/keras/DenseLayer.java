package io.github.d.lab2.kernel.categories.datamining.network.layer.keras;

import io.github.d.lab2.kernel.categories.datamining.network.layer.Layer;
import io.github.d.lab2.kernel.generator.visitor.IElementVisitor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DenseLayer extends Layer {
    private int units;
    private String activation;

    @Override
    public void accept(IElementVisitor visitor) {
        visitor.visit(this);
    }
}
