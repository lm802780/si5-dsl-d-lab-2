package io.github.d.lab2.kernel.categories.validation;

import io.github.d.lab2.kernel.generator.visitor.ElementVisitable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public abstract class ValidationElement implements ElementVisitable {
    private DiagramEnum diagram;
}

