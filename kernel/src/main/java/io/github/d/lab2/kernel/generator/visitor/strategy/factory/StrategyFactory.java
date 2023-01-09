package io.github.d.lab2.kernel.generator.visitor.strategy.factory;

import io.github.d.lab2.kernel.generator.visitor.strategy.IFrameworkStrategy;
import io.github.d.lab2.kernel.generator.visitor.strategy.impl.DefaultStrategy;
import io.github.d.lab2.kernel.generator.visitor.strategy.impl.KerasStrategy;
import io.github.d.lab2.kernel.generator.visitor.strategy.impl.PyTorchStrategy;

public class StrategyFactory implements IStrategyFactory {

    @Override
    public IFrameworkStrategy createStrategy(String strategyName) {
        switch (strategyName) {
            case "pytorch":
                return new PyTorchStrategy();
            case "keras":
                return new KerasStrategy();
            default:
                System.out.println("Unknown strategy: " + strategyName);
                return new DefaultStrategy();
        }
    }
}
