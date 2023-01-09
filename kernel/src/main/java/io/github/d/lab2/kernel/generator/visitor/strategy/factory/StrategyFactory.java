package io.github.d.lab2.kernel.generator.visitor.strategy.factory;

import io.github.d.lab2.kernel.generator.visitor.strategy.IFrameworkStrategy;
import io.github.d.lab2.kernel.generator.visitor.strategy.impl.DefaultStrategy;
import io.github.d.lab2.kernel.generator.visitor.strategy.impl.KerasStrategy;
import io.github.d.lab2.kernel.generator.visitor.strategy.impl.PyTorchStrategy;
import io.github.d.lab2.notebook.Notebook;

public class StrategyFactory implements IStrategyFactory {

    @Override
    public IFrameworkStrategy createStrategy(String strategyName, Notebook notebook) {
        switch (strategyName) {
            case "pytorch":
                return new PyTorchStrategy(notebook);
            case "keras":
                return new KerasStrategy(notebook);
            default:
                System.out.println("Unknown strategy: " + strategyName);
                return new DefaultStrategy(notebook);
        }
    }
}
