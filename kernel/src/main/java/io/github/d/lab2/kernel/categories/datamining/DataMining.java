package io.github.d.lab2.kernel.categories.datamining;

import io.github.d.lab2.kernel.categories.Step;
import io.github.d.lab2.kernel.generator.visitor.IStepVisitor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DataMining extends Step {
    //TODO
    private List<DataMiningElement> elements;

    public DataMining() {
        super("Data Mining");
        elements = new ArrayList<>();
    }

    @Override
    public void accept(IStepVisitor visitor) {
        visitor.visit(this);
    }
}
