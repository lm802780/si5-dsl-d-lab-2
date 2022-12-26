package io.github.mosser.arduinoml.externals.antlr;

import io.github.mosser.arduinoml.externals.antlr.grammar.ArduinomlBaseListener;
import io.github.mosser.arduinoml.externals.antlr.grammar.ArduinomlParser;
import io.github.mosser.arduinoml.kernel.App;

public class ModelBuilder extends ArduinomlBaseListener {

    /********************
     ** Business Logic **
     ********************/

    private App theApp;
    private boolean built = false;

    public App retrieve() {
        if (built) {
            return theApp;
        }
        throw new RuntimeException("Cannot retrieve a model that was not created!");
    }

    /*******************
     ** Symbol tables **
     *******************/
    // TODO: to complete

    /**************************
     ** Listening mechanisms **
     **************************/

    @Override
    public void enterRoot(ArduinomlParser.RootContext ctx) {
        built = false;
        theApp = new App();
    }

    @Override
    public void exitRoot(ArduinomlParser.RootContext ctx) {
        // Resolving states in transitions
        // TODO: to complete
        this.built = true;
    }
}

