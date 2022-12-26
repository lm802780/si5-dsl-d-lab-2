package io.github.mosser.arduinoml.kernel.categories.transformation;

import io.github.mosser.arduinoml.kernel.generator.Visitable;
import io.github.mosser.arduinoml.kernel.generator.Visitor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Transformation implements Visitable {
    private List<Reshape> reshape;
    private Normalization normalization;

    @Override
    public void accept(Visitor<StringBuffer> visitor) {
        visitor.visit(this);
    }
}
