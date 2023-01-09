package io.github.d.lab2.notebook;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Notebook {

    /**
     * Cells of the notebook.
     */
    private final List<Cell> cells = new ArrayList<>();

    /**
     * Add a cell code in the notebook.
     */
    public void addCode(StringBuilder s) {
        cells.add(new Cell(CellTypeEnum.CODE, s));
    }

    /**
     * Add a markdown cell in the notebook.
     */
    public void addMarkdown(StringBuilder s) {
        cells.add(new Cell(CellTypeEnum.MARKDOWN, s));
    }

    /**
     * Save the notebook in a file.
     */
    public void save(String filename) {
        // Create the JSON object.
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = JsonNodeFactory.instance.objectNode();
        ArrayNode cellsNode = JsonNodeFactory.instance.arrayNode();
        root.set("cells", cellsNode);

        for (Cell cell : cells) {
            ObjectNode cellNode = cellsNode.addObject();
            cellNode.set("cell_type", JsonNodeFactory.instance.textNode(cell.getType()));
            cellNode.set("source", JsonNodeFactory.instance.textNode(cell.getContent().toString()));
        }

        // Write the notebook in a file.
        try {
            mapper.writeValue(Files.newOutputStream(Paths.get(filename)), root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
