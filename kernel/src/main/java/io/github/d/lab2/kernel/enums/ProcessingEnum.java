package io.github.d.lab2.kernel.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProcessingEnum {
    INT("int"),
    STR("str"),
    DROP("DROP");

    private final String processing;
}
