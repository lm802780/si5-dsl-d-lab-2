package io.github.d.lab2.kernel.generator;

import io.github.d.lab2.notebook.Notebook;

public interface Visitable {
    void accept(Visitor<Notebook> visitor);
}
