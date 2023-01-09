package io.github.d.lab2.externals.antlr;

public class ExceptionHandler {

    private ExceptionHandler() {
        // Unsupported operation.
    }

    /**
     * Print an error message and exit the program with a code status -1.
     *
     * @param message the error message.
     */
    public static void exit(String message) {
        System.err.println(message);
        System.exit(-1);
    }
}
