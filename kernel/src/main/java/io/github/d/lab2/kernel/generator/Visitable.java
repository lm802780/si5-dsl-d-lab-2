package io.github.d.lab2.kernel.generator;

public interface Visitable {
    void accept(Visitor<StringBuffer> visitor);
}
