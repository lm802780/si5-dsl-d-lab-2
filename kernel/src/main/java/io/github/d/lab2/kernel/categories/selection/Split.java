package io.github.d.lab2.kernel.categories.selection;

import io.github.d.lab2.kernel.enums.TypeEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Split {
    private TypeEnum type;
    private int percentage;
}
