package io.github.d.lab2.kernel.categories;

import io.github.d.lab2.kernel.generator.visitor.StepVisitable;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public abstract class Step implements StepVisitable {
    private String name;

    public Step(String name) {
        this.name = name;
    }
}
