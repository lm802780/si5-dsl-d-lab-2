package io.github.d.lab2.notebook;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Cell {
    /**
     * Type of the cell. Code or markdown.
     */
    private CellTypeEnum type;

    /**
     * Content of the cell.
     * Initial capacity set to 100 to improve memory allocation.
     */
    private StringBuilder content = new StringBuilder(100);

    public String getType() {
        return type.getType();
    }

    public StringBuilder getContent() {
        return content;
    }
}
