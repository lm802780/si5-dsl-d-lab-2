package io.github.d.lab2.kernel.generator;

import io.github.d.lab2.kernel.App;
import io.github.d.lab2.kernel.categories.datamining.DataMining;
import io.github.d.lab2.kernel.categories.datamining.network.KerasNetwork;
import io.github.d.lab2.kernel.categories.datamining.network.PytorchNetwork;
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
import io.github.d.lab2.kernel.categories.validation.MSEFunction;
import io.github.d.lab2.kernel.categories.validation.R2Function;
import io.github.d.lab2.kernel.categories.validation.Validation;
import io.github.d.lab2.kernel.categories.validation.predict.KerasPredict;
import io.github.d.lab2.kernel.categories.validation.predict.PytorchPredict;
import io.github.d.lab2.kernel.enums.TypeEnum;
import io.github.d.lab2.kernel.mandatory.Description;
import io.github.d.lab2.notebook.Notebook;

import java.util.Locale;

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
        notebook.addCellCode();
        notebook.appendCode("import pandas as pd\n");
        notebook.appendCode("import matplotlib.pyplot as plt\n");
        notebook.appendCode("import numpy as np\n");
        notebook.appendCode("from sklearn.model_selection import train_test_split");

        notebook.addCellCode("## Selection step");
        if (context.get("pass") == Pass.ONE) {
            notebook.appendCode("# setting\n");
            notebook.appendCode(String.format("source = '%s'%n", selection.getSource().getSourceId()));

            // Locale.US in order to print dot instead of comma for digit decimal.
            notebook.appendCode(String.format(Locale.US, "split_train, split_test, split_validation = %.2f, %.2f, %.2f%n",
                    selection.getSplit().get(TypeEnum.TRAIN), selection.getSplit().get(TypeEnum.TEST),
                    selection.getSplit().get(TypeEnum.VALIDATION)));

            // TODO: customize the label name (put it in the Selection object).
            notebook.appendCode(String.format("label_colname = '%s'", "label"));

            notebook.addCellCode();
            notebook.appendCode("data = pd.read_csv(source, encoding='utf_8', parse_dates=True)");

            notebook.addCellCode();
            notebook.appendCode("data.head()");
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
        notebook.addCellMarkdown();
        notebook.appendMarkdown("## Validation step");
        if (context.get("pass") == Pass.ONE) {
            // TODO: print this code only if "diagram: loss_epoch_evolution".
            notebook.addCellCode();
            notebook.appendCode("fig, ax = plt.subplots()");
            // FIXME: tensorflow version does not use the variable "items".
            notebook.appendCode("x = np.arange(len(items))\n");
            notebook.appendCode("ax.plot(x, items)\n");
            notebook.appendCode("ax.set(xlabel='number of epochs', ylabel='loss', title='Evolution')\n");
            notebook.appendCode("plt.show()");

            // TODO: print this code only if "diagram: prediction  (\n)    size: 50"
            notebook.addCellCode();
            notebook.appendCode("ax = plt.gca()\n");
            // TODO: parametrized the size from ANTLR.
            int size = 50;
            notebook.appendCode(String.format("plt.plot(np.arange(y_train.values[:%d].size), " +
                    "y_train.values[:%d], '-', label='True data', color='b')%n", size, size));
            notebook.appendCode(String.format("np.arange(output.detach().numpy()[:%d].size), " +
                    "output.detach().numpy()[:%d], '--', label='Predictions', color='r')%n", size, size));
            notebook.appendCode("plt.gcf().autofmt_xdate()");
            notebook.appendCode("plt.show()");
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

    @Override
    public void visit(MSEFunction mseFunction) {

    }

    @Override
    public void visit(R2Function r2Function) {

    }
}
