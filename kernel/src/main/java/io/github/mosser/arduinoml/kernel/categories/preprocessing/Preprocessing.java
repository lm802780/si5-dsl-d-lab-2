package io.github.mosser.arduinoml.kernel.categories.preprocessing;

import io.github.mosser.arduinoml.kernel.enums.ProcessingEnum;
import io.github.mosser.arduinoml.kernel.generator.Visitable;
import io.github.mosser.arduinoml.kernel.generator.Visitor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Preprocessing implements Visitable {
    private ProcessingEnum processing;

    @Override
    public void accept(Visitor<StringBuffer> visitor) {
        visitor.visit(this);
    }
}
