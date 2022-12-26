package io.github.mosser.arduinoml.kernel;

import io.github.mosser.arduinoml.kernel.categories.datamining.DataMining;
import io.github.mosser.arduinoml.kernel.categories.description.Description;
import io.github.mosser.arduinoml.kernel.categories.knowledge.Knowledge;
import io.github.mosser.arduinoml.kernel.categories.preprocessing.Preprocessing;
import io.github.mosser.arduinoml.kernel.categories.selection.Selection;
import io.github.mosser.arduinoml.kernel.categories.transformation.Transformation;
import io.github.mosser.arduinoml.kernel.categories.validation.Validation;
import io.github.mosser.arduinoml.kernel.generator.Visitable;
import io.github.mosser.arduinoml.kernel.generator.Visitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class App implements Visitable {

    private Description description;
    private Selection selection;
    private Preprocessing preprocessing;
    private Transformation transformation;
    private DataMining dataMining;
    private Validation validation;
    private Knowledge knowledge;

    @Override
    public void accept(Visitor<StringBuffer> visitor) {
        visitor.visit(this);
    }
}
