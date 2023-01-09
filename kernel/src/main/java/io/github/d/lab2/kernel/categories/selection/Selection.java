package io.github.d.lab2.kernel.categories.selection;

import io.github.d.lab2.kernel.categories.Step;
import io.github.d.lab2.kernel.enums.TypeEnum;
import io.github.d.lab2.kernel.generator.Visitor;
import io.github.d.lab2.notebook.Notebook;
import lombok.Getter;
import lombok.Setter;

import java.util.EnumMap;
import java.util.Map;

@Getter
@Setter
public class Selection extends Step {
    private Source source;
    private Map<TypeEnum, Double> split;

    // See https://datascience.stackexchange.com/questions/15135/train-test-validation-set-splitting-in-sklearn for calculation of percentage
    public Selection() {
        super("Selection");
        this.split = new EnumMap<>(TypeEnum.class);
        split.put(TypeEnum.TRAIN, 0.0);
        split.put(TypeEnum.TEST, 0.0);
        split.put(TypeEnum.VALIDATION, 0.0);
    }

    @Override
    public void accept(Visitor<Notebook> visitor) {
        visitor.visit(this);
    }
}
