package io.github.d.lab2.kernel.generator.visitor;

import io.github.d.lab2.kernel.enums.FrameworkEnum;
import io.github.d.lab2.kernel.generator.visitor.strategy.IFrameworkStrategy;
import io.github.d.lab2.kernel.generator.visitor.strategy.factory.StrategyFactory;
import io.github.d.lab2.notebook.Notebook;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.Delegate;

public abstract class AbstractStepVisitor implements IStepVisitor {

    /***********************
     ** Helper mechanisms **
     ***********************/
    @Setter
    protected FrameworkEnum framework;
//    protected Map<String, Object> context = new HashMap<>();

    protected Notebook notebook;
    @Delegate
    @Setter(AccessLevel.PROTECTED)
    protected IFrameworkStrategy frameworkStrategy;

    protected AbstractStepVisitor(Notebook notebook) {
        this.notebook = notebook;
        this.frameworkStrategy = new StrategyFactory().createStrategy("default", notebook);
    }

    public Notebook getNotebook() {
        return notebook;
    }
}

