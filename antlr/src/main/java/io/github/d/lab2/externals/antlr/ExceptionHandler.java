package io.github.d.lab2.externals.antlr;

public class ExceptionHandler {

    public static void exit(String message) {
        System.err.println(message);
        System.exit(-1);
    }
}
