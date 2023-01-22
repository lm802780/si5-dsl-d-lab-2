package io.github.d.lab2.kernel.categories.selection;

import io.github.d.lab2.kernel.categories.Step;
import io.github.d.lab2.kernel.enums.TypeEnum;
import io.github.d.lab2.kernel.generator.visitor.IStepVisitor;
import lombok.Getter;
import lombok.Setter;

import java.util.EnumMap;
import java.util.Map;

@Getter
@Setter
public class Selection extends Step {
    private Source source;
    private String label;
    private Map<TypeEnum, Double> split;

    public Selection(){
        super("Selection");
        this.split = new EnumMap<>(TypeEnum.class);
        split.put(TypeEnum.TRAIN, 0.0);
        split.put(TypeEnum.TEST, 0.0);
        split.put(TypeEnum.VALIDATION, 0.0);
        this.label = "label";
    }

    @Override
    public void accept(IStepVisitor visitor) {
        visitor.visit(this);
    }
}
