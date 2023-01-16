package io.github.d.lab2.kernel.categories.datamining;

import io.github.d.lab2.kernel.categories.Step;
import io.github.d.lab2.kernel.categories.datamining.network.Network;
import io.github.d.lab2.kernel.categories.datamining.training.Training;
import io.github.d.lab2.kernel.generator.visitor.IStepVisitor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DataMining extends Step {
    private Training training;
    private Network network;

    public DataMining() {
        super("Data Mining");
    }

    @Override
    public void accept(IStepVisitor visitor) {
        visitor.visit(this);
    }
}
