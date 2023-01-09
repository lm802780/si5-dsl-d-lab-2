package io.github.d.lab2.kernel.categories.preprocessing;

import io.github.d.lab2.kernel.categories.Step;
import io.github.d.lab2.kernel.enums.ProcessingEnum;
import io.github.d.lab2.kernel.generator.Visitable;
import io.github.d.lab2.kernel.generator.Visitor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Preprocessing extends Step {
    private ProcessingEnum processing;
    private List<PreprocessingElement> elements;

    public Preprocessing() {
        super("Preprocessing");
        elements= new ArrayList<>();
    }
    @Override
    public void accept(Visitor<StringBuffer> visitor) {
        visitor.visit(this);
    }
}
