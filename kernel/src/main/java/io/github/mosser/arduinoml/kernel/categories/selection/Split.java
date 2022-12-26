package io.github.mosser.arduinoml.kernel.categories.selection;

import io.github.mosser.arduinoml.kernel.enums.TypeEnum;
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
