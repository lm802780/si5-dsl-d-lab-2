package io.github.d.lab2.notebook;

/**
 * Test class.
 */
public class Main {
    public static void main(String[] args) {
        Notebook notebook = new Notebook();

        notebook.addCellMarkdown();
        notebook.appendMarkdown("This is a markdown cell!");

        notebook.addCellCode();
        notebook.appendCode("print('Hello world!')");

        notebook.save("myNotebook.ipynb");
    }
}
