package io.github.d.lab2.kernel.categories.datamining.training;

import io.github.d.lab2.kernel.categories.datamining.DataMiningElement;
import io.github.d.lab2.kernel.generator.visitor.ElementVisitable;
import io.github.d.lab2.kernel.generator.visitor.IElementVisitor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Training implements ElementVisitable {
    private int batchSize;
    private int epochs;
    private double learningRate;
    private OptimizerEnum optimizer;
    private LossEnum loss;

    @Override
    public void accept(IElementVisitor visitor) {
        visitor.visit(this);
    }
}
