package io.github.d.lab2.kernel.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FrameworkEnum {
    PYTORCH("pytorch"),
    KERAS("keras");

    private final String framework;
}
