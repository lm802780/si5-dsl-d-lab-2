package io.github.d.lab2.kernel.categories.datamining;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HyperParameters extends DataMiningElement{
    private int batchSize;
    private int epochs;
    private double learningRate;
}
