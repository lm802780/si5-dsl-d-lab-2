package io.github.d.lab2.kernel.categories.preprocessing;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReplaceBy extends PreprocessingElement {
    private String toReplace;
    private String value;
}
