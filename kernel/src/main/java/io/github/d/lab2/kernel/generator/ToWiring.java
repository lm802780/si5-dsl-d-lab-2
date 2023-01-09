package io.github.d.lab2.kernel.generator;

import io.github.d.lab2.kernel.App;
import io.github.d.lab2.kernel.categories.datamining.DataMining;
import io.github.d.lab2.kernel.categories.datamining.network.KerasNetwork;
import io.github.d.lab2.kernel.categories.datamining.network.PytorchNetwork;
import io.github.d.lab2.kernel.categories.datamining.predict.KerasPredict;
import io.github.d.lab2.kernel.categories.datamining.predict.PytorchPredict;
import io.github.d.lab2.kernel.categories.datamining.training.KerasTraining;
import io.github.d.lab2.kernel.categories.datamining.training.PytorchTraining;
import io.github.d.lab2.kernel.categories.knowledge.Knowledge;
import io.github.d.lab2.kernel.categories.preprocessing.DropNa;
import io.github.d.lab2.kernel.categories.preprocessing.Preprocessing;
import io.github.d.lab2.kernel.categories.preprocessing.ReplaceBy;
import io.github.d.lab2.kernel.categories.selection.Selection;
import io.github.d.lab2.kernel.categories.transformation.Normalization;
import io.github.d.lab2.kernel.categories.transformation.Reshape;
import io.github.d.lab2.kernel.categories.transformation.Transformation;
import io.github.d.lab2.kernel.categories.validation.Validation;
import io.github.d.lab2.kernel.enums.TypeEnum;
import io.github.d.lab2.kernel.mandatory.Description;
import io.github.d.lab2.notebook.Notebook;

/**
 * Quick and dirty visitor to support the generation of Wiring code
 */
public class ToWiring extends Visitor<Notebook> {
    public ToWiring() {
        this.notebook = new Notebook();
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

        notebook.save("result.ipynb");
    }

    @Override
    public void visit(Description description) {
        if (context.get("pass") == Pass.ONE) {
            notebook.addCellMarkdown();
            notebook.appendMarkdown(String.format("# %s", description.getDetail()));
        }
    }

    @Override
    public void visit(Selection selection) {
        notebook.addCellCode("## Selection step");
        if (context.get("pass") == Pass.ONE) {
            notebook.appendCode("# setting\n");
            notebook.appendCode(String.format("source = '%s'%n", selection.getSource().getSourceId()));

            notebook.appendCode(String.format("split_train, split_test, split_validation = %.2f, %.2f, %.2f%n",
                    selection.getSplit().get(TypeEnum.TRAIN), selection.getSplit().get(TypeEnum.TEST),
                    selection.getSplit().get(TypeEnum.VALIDATION)));

            // TODO: customize the label name (put it in the Selection object).
            notebook.appendCode(String.format("label_colname = '%s'", "label"));
        }
    }

    @Override
    public void visit(Preprocessing preprocessing) {
        notebook.addCellCode("## Preprocessing step");
        if (context.get("pass") == Pass.ONE) {
            preprocessing.getElements().forEach(element -> element.accept(this));
            notebook.appendCode((String.format("# Preprocessing: %s", preprocessing.toString())));
        }
    }

    @Override
    public void visit(Transformation transformation) {
        notebook.addCellCode("## Transformation step");
        if (context.get("pass") == Pass.ONE) {
            transformation.getElements().forEach(element -> element.accept(this));
            notebook.appendCode(String.format("# Transformation: %s", transformation.toString()));
        }
    }

    @Override
    public void visit(DataMining dataMining) {
        notebook.addCellCode("## Data mining step");
        if (context.get("pass") == Pass.ONE) {
            notebook.appendCode(String.format("# DataMining: %s", dataMining.toString()));
        }
    }

    @Override
    public void visit(Validation validation) {
        notebook.addCellCode("## Validation step");
        if (context.get("pass") == Pass.ONE) {
            notebook.appendCode(String.format("# Validation: %s", validation.toString()));
        }
    }

    @Override
    public void visit(Knowledge knowledge) {
        notebook.addCellCode("## Knowledge step");
        if (context.get("pass") == Pass.ONE) {
            notebook.appendCode(String.format("# nKnowledge: %s", knowledge.toString()));
        }
    }

    @Override
    public void visit(DropNa dropNa) {

    }

    @Override
    public void visit(ReplaceBy replaceBy) {

    }

    @Override
    public void visit(KerasNetwork kerasNetwork) {

    }

    @Override
    public void visit(PytorchNetwork pytorchNetwork) {

    }

    @Override
    public void visit(PytorchPredict pytorchPredict) {

    }

    @Override
    public void visit(KerasPredict kerasPredict) {

    }

    @Override
    public void visit(PytorchTraining pytorchTraining) {

    }

    @Override
    public void visit(KerasTraining kerasTraining) {

    }

    @Override
    public void visit(Reshape reshape) {

    }

    @Override
    public void visit(Normalization normalization) {

    }
}
