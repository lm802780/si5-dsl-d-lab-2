package io.github.d.lab2.kernel.generator.visitor.strategy.factory;

import io.github.d.lab2.kernel.enums.FrameworkEnum;
import io.github.d.lab2.kernel.generator.visitor.strategy.IFrameworkStrategy;
import io.github.d.lab2.kernel.generator.visitor.strategy.impl.DefaultStrategy;
import io.github.d.lab2.kernel.generator.visitor.strategy.impl.KerasStrategy;
import io.github.d.lab2.kernel.generator.visitor.strategy.impl.PyTorchStrategy;
import io.github.d.lab2.notebook.Notebook;

public class StrategyFactory implements IStrategyFactory {

    private static IFrameworkStrategy getDefaultStrategy(FrameworkEnum strategyName, Notebook notebook) {
        System.out.println("Unknown strategy: " + strategyName);
        return new DefaultStrategy(notebook);
    }

    @Override
    public IFrameworkStrategy createStrategy(FrameworkEnum strategyName, Notebook notebook) {
        if (strategyName == null) {
            return getDefaultStrategy(null, notebook);
        }

        switch (strategyName) {
            case PYTORCH -> {
                System.out.println("Strategy name: " + strategyName);
                return new PyTorchStrategy(notebook);
            }
            case KERAS -> {
                System.out.println("Strategy name: " + strategyName);
                return new KerasStrategy(notebook);
            }
        }

        return getDefaultStrategy(strategyName, notebook);
    }
}
