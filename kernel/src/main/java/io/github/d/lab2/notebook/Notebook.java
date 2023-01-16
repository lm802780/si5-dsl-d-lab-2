package io.github.d.lab2.notebook;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import java.util.LinkedList;

@NoArgsConstructor
public class Notebook {

    /**
     * Cells of the notebook.
     */
    private final LinkedList<Cell> cells = new LinkedList<>();

    private void append(CellTypeEnum cellTypeEnum, String string) {
        for (Iterator<Cell> it = cells.descendingIterator(); it.hasNext(); ) {
            Cell cell = it.next();
            if (cellTypeEnum == cell.getType()) {
                cell.getContent().append(string);
                return;
            }
        }
        throw new CellNotFoundException(cellTypeEnum);
    }

    private Cell addCell(CellTypeEnum cellTypeEnum) {
        Cell cell;

        if (CellTypeEnum.CODE == cellTypeEnum) {
            cell = new Cell(cellTypeEnum, new StringBuilder(128));
        } else {
            // For markdown.
            cell = new Cell(cellTypeEnum, new StringBuilder(64));
        }
        cells.add(cell);
        return cell;
    }

    public void appendCode(String string) {
        append(CellTypeEnum.CODE, string);
    }

    public void appendCode(int tab, String string) {
        appendCode("\t".repeat(tab) + string);
    }

    public void appendMarkdown(String string) {
        append(CellTypeEnum.MARKDOWN, string);
    }

    /**
     * Add a cell code in the notebook.
     */
    public Cell addCellCode() {
        return addCell(CellTypeEnum.CODE);
    }

    /**
     * Add a cell code in the notebook. In addition, add just before the cell code a cell markdown to describe the code.
     */
    public Cell addCellCode(String description) {
        addCell(CellTypeEnum.MARKDOWN);
        appendMarkdown(description);
        return addCell(CellTypeEnum.CODE);
    }

    /**
     * Add a markdown cell in the notebook.
     */
    public Cell addCellMarkdown() {
        return addCell(CellTypeEnum.MARKDOWN);
    }

    /**
     * Save the notebook in a file.
     */
    public void save(String filename) {
        // Create the JSON object.
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = JsonNodeFactory.instance.objectNode();

        // Header data
        root.set("metadata", JsonNodeFactory.instance.objectNode());
        root.set("nbformat", JsonNodeFactory.instance.numberNode(4));
        root.set("nbformat_minor", JsonNodeFactory.instance.numberNode(5));

        // Cells
        ArrayNode cellsNode = JsonNodeFactory.instance.arrayNode();
        root.set("cells", cellsNode);

        for (Cell cell : cells) {
            ObjectNode cellNode = cellsNode.addObject();
            cellNode.set("cell_type", JsonNodeFactory.instance.textNode(cell.getType().getName()));
            cellNode.set("metadata", JsonNodeFactory.instance.objectNode());
            cellNode.set("source", JsonNodeFactory.instance.textNode(cell.getContent().toString()));
        }

        // Write the notebook in a file.
        try {
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(Files.newOutputStream(Paths.get(filename),
                                    StandardOpenOption.WRITE,
                                    StandardOpenOption.CREATE,
                                    StandardOpenOption.TRUNCATE_EXISTING),
                            root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
