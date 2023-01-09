package io.github.d.lab2.kernel.generator.visitor;

import io.github.d.lab2.kernel.generator.visitor.strategy.IFrameworkStrategy;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.Delegate;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractStepVisitor<T> implements IStepVisitor {

    /***********************
     ** Helper mechanisms **
     ***********************/

    protected Map<String, Object> context = new HashMap<>();

    protected T notebook;
    @Delegate
    @Setter(AccessLevel.PROTECTED)
    protected IFrameworkStrategy frameworkStrategy;

    protected AbstractStepVisitor(T notebook, final IFrameworkStrategy frameworkStrategy) {
        this.notebook = notebook;
        this.frameworkStrategy = frameworkStrategy;
    }

    public T getNotebook() {
        return notebook;
    }
}

