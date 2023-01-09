package io.github.d.lab2.notebook;

public class CellNotFoundException extends RuntimeException {
    public CellNotFoundException(CellTypeEnum cellTypeEnum) {
        super(String.format("Cell type '%s' not found", cellTypeEnum.getName()));
    }
}
