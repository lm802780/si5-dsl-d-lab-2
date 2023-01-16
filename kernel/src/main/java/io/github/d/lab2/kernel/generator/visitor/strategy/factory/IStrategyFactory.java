package io.github.d.lab2.kernel.generator.visitor.strategy.factory;

import io.github.d.lab2.kernel.enums.FrameworkEnum;
import io.github.d.lab2.kernel.generator.visitor.strategy.IFrameworkStrategy;
import io.github.d.lab2.notebook.Notebook;

public interface IStrategyFactory {

    IFrameworkStrategy createStrategy(FrameworkEnum strategyName, Notebook notebook);
}
