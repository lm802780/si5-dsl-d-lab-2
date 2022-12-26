package io.github.mosser.arduinoml.kernel.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TypeEnum {
    TRAIN("train"),
    TEST("test"),
    VALIDATION("validation");

    private final String type;
}
