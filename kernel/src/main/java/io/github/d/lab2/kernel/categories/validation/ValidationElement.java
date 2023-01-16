package io.github.d.lab2.kernel.categories.validation;

import io.github.d.lab2.kernel.generator.visitor.ElementVisitable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public abstract class ValidationElement implements ElementVisitable {
    private String diagramName;
    private int size;

}

