import io.github.d.lab2.externals.antlr.ModelBuilder;
import io.github.d.lab2.externals.antlr.StopErrorListener;
import io.github.d.lab2.externals.antlr.grammar.NotebookmlLexer;
import io.github.d.lab2.externals.antlr.grammar.NotebookmlParser;
import io.github.d.lab2.kernel.App;
import io.github.d.lab2.kernel.generator.ToWiring;
import io.github.d.lab2.kernel.generator.visitor.AbstractStepVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("\n\nRunning the ANTLR compiler for Notebookml");

        CharStream stream = getCharStream(args);
        App theApp = buildModel(stream);
        exportToCode(theApp);
    }

    private static CharStream getCharStream(String[] args) throws IOException {
        if (args.length < 1) {
            throw new RuntimeException("no input file");
        }
        Path input = Paths.get(new File(args[0]).toURI());
        System.out.println("Using input file: " + input);
        return CharStreams.fromPath(input);
    }

    private static App buildModel(CharStream stream) {
        NotebookmlLexer lexer = new NotebookmlLexer(stream);
        lexer.removeErrorListeners();
        lexer.addErrorListener(new StopErrorListener());

        NotebookmlParser parser = new NotebookmlParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        parser.addErrorListener(new StopErrorListener());

        ParseTreeWalker walker = new ParseTreeWalker();
        ModelBuilder builder = new ModelBuilder();

        // parser.root() is the entry point of the grammar
        walker.walk(builder, parser.root());

        return builder.retrieve();
    }

    private static void exportToCode(App theApp) {
        AbstractStepVisitor codeGenerator = new ToWiring();
        theApp.accept(codeGenerator);
        System.out.println("Notebook saved in 'notebooks/notebook.ipynb'");
    }

}
