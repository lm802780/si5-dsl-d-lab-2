package io.github.mosser.arduinoml.kernel.categories.datamining;

import io.github.mosser.arduinoml.kernel.generator.Visitable;
import io.github.mosser.arduinoml.kernel.generator.Visitor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DataMining implements Visitable {
    @Override
    public void accept(Visitor<StringBuffer> visitor) {
        visitor.visit(this);
    }
}
