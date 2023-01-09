package io.github.d.lab2.kernel.generator.visitor;

public interface Visitable<T> {

    void accept(T visitor);
}
