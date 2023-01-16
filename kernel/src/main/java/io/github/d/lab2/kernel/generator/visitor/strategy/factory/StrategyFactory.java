package io.github.d.lab2.kernel.generator.visitor.strategy.factory;

import io.github.d.lab2.kernel.enums.FrameworkEnum;
import io.github.d.lab2.kernel.generator.visitor.strategy.IFrameworkStrategy;
import io.github.d.lab2.kernel.generator.visitor.strategy.impl.DefaultStrategy;
import io.github.d.lab2.kernel.generator.visitor.strategy.impl.KerasStrategy;
import io.github.d.lab2.kernel.generator.visitor.strategy.impl.PyTorchStrategy;
import io.github.d.lab2.notebook.Notebook;

public class StrategyFactory implements IStrategyFactory {

    @Override

    public IFrameworkStrategy createStrategy(FrameworkEnum strategyName, Notebook notebook) {
        System.out.println("Strategy name: " + strategyName);

        switch (strategyName) {
            case PYTORCH -> {
                return new PyTorchStrategy(notebook);
            }
            case KERAS -> {
                return new KerasStrategy(notebook);
            }
            case null, default -> {
                System.out.println("Unknown strategy: " + strategyName);
                return new DefaultStrategy(notebook);
            }
        }
    }
}
