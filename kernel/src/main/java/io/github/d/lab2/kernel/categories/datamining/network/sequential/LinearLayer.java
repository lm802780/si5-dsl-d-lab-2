package io.github.d.lab2.kernel.categories.datamining.network.sequential;

import io.github.d.lab2.kernel.generator.visitor.IElementVisitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LinearLayer extends SequentialLayer {
    private int inFeatures;
    private int outFeatures;

}
