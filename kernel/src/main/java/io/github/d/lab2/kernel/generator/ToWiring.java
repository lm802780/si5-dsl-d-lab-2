package io.github.d.lab2.kernel.generator;

import io.github.d.lab2.kernel.App;
import io.github.d.lab2.kernel.categories.datamining.DataMining;
import io.github.d.lab2.kernel.mandatory.Description;
import io.github.d.lab2.kernel.categories.knowledge.Knowledge;
import io.github.d.lab2.kernel.categories.preprocessing.Preprocessing;
import io.github.d.lab2.kernel.categories.selection.Selection;
import io.github.d.lab2.kernel.categories.transformation.Transformation;
import io.github.d.lab2.kernel.categories.validation.Validation;

/**
 * Quick and dirty visitor to support the generation of Wiring code
 */
public class ToWiring extends Visitor<StringBuffer> {
    public ToWiring() {
        this.result = new StringBuffer(1024);
    }

    private void w(String s) {
        result.append(String.format("%s", s));
    }

    private String tab(int number) {
        return "\t".repeat(number);
    }

    @Override
    public void visit(App app) {
        // Initialize global variables
        context.put("pass", Pass.ONE);
        app.getDescription().accept(this);
        app.getSelection().accept(this);
        //app.getPreprocessing().accept(this);
        //app.getTransformation().accept(this);
        //app.getDataMining().accept(this);
        //app.getValidation().accept(this);
        //app.getKnowledge().accept(this);

        // Generate the code.
        context.put("pass", Pass.TWO);
    }

    @Override
    public void visit(Description description) {
        if (context.get("pass") == Pass.ONE) {
            w(String.format("# %s", description.getDetail()));
        }
    }

    @Override
    public void visit(Selection selection) {
        if (context.get("pass") == Pass.ONE) {
            w(String.format("%nSELECTION: %s", selection.toString()));
        }
    }

    @Override
    public void visit(Preprocessing preprocessing) {
        if (context.get("pass") == Pass.ONE) {
            w(String.format("%nPreprocessing: %s", preprocessing.toString()));
        }
    }

    @Override
    public void visit(Transformation transformation) {
        if (context.get("pass") == Pass.ONE) {
            w(String.format("%nTransformation: %s", transformation.toString()));
        }
    }

    @Override
    public void visit(DataMining dataMining) {
        if (context.get("pass") == Pass.ONE) {
            w(String.format("%nDataMining: %s", dataMining.toString()));
        }
    }

    @Override
    public void visit(Validation validation) {
        if (context.get("pass") == Pass.ONE) {
            w(String.format("%nDataMining: %s", validation.toString()));
        }
    }

    @Override
    public void visit(Knowledge knowledge) {
        if (context.get("pass") == Pass.ONE) {
            w(String.format("%nKnowledge: %s", knowledge.toString()));
        }
    }
}
