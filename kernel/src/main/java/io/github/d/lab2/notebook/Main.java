package io.github.d.lab2.notebook;

/**
 * Test class.
 */
public class Main {
    public static void main(String[] args) {
        Notebook notebook = new Notebook();

        StringBuilder markdown = new StringBuilder();
        markdown.append("This is a markdown cell!");
        notebook.addMarkdown(markdown);

        StringBuilder code = new StringBuilder();
        code.append("print('Hello world!')");
        notebook.addCode(code);

        notebook.save("myNotebook.ipynb");
    }
}
