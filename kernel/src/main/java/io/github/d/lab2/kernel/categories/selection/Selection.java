package io.github.d.lab2.kernel.categories.selection;

import io.github.d.lab2.kernel.categories.Step;
import io.github.d.lab2.kernel.generator.Visitable;
import io.github.d.lab2.kernel.generator.Visitor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Selection extends Step {
    private Source source;
    private List<Split> split;

    // See https://datascience.stackexchange.com/questions/15135/train-test-validation-set-splitting-in-sklearn for calculation of percentage
    public Selection(){
        super("Selection");
        this.split = new ArrayList<>();
        split.add(new TrainSplit());
        split.add(new TestSplit());
        split.add(new ValidationSplit());
    }
    @Override
    public void accept(Visitor<StringBuffer> visitor) {
        visitor.visit(this);
    }
}
