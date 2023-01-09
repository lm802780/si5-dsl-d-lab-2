package io.github.d.lab2.kernel.generator.visitor.strategy.factory;

import io.github.d.lab2.kernel.generator.visitor.strategy.IFrameworkStrategy;

public interface IStrategyFactory {

    IFrameworkStrategy createStrategy(String strategyName);
}
