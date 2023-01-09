package io.github.d.lab2.notebook;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CellTypeEnum {
    CODE("code"),
    MARKDOWN("markdown");

    private final String name;
}
