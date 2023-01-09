package io.github.d.lab2.notebook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Cell {
    /**
     * Type of the cell. Code or markdown.
     */
    private CellTypeEnum type;

    /**
     * Content of the cell.
     */
    private StringBuilder content;
}
