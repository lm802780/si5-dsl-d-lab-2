package io.github.mosser.arduinoml.kernel.enums;

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
