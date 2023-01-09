package io.github.d.lab2.kernel.categories.datamining.training;

import io.github.d.lab2.kernel.categories.datamining.DataMiningElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public abstract class Training extends DataMiningElement {
    private int batchSize;
    private int epochs;
    private double learningRate;
    private OptimizerEnum optimizer;
    private LossEnum loss;

}
