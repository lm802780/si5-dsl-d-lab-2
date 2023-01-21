package io.github.d.lab2.kernel.categories;

import io.github.d.lab2.kernel.generator.visitor.StepVisitable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Step implements StepVisitable {
    private String name;
}
