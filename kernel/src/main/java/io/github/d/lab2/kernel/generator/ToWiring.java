package io.github.d.lab2.kernel.generator;

import io.github.d.lab2.kernel.App;
import io.github.d.lab2.kernel.categories.datamining.DataMining;
import io.github.d.lab2.kernel.categories.knowledge.Knowledge;
import io.github.d.lab2.kernel.categories.preprocessing.Preprocessing;
import io.github.d.lab2.kernel.categories.selection.Selection;
import io.github.d.lab2.kernel.categories.transformation.Transformation;
import io.github.d.lab2.kernel.categories.validation.Validation;
import io.github.d.lab2.kernel.enums.TypeEnum;
import io.github.d.lab2.kernel.generator.visitor.AbstractStepVisitor;
import io.github.d.lab2.kernel.generator.visitor.strategy.impl.DefaultStrategy;
import io.github.d.lab2.kernel.generator.visitor.strategy.factory.StrategyFactory;
import io.github.d.lab2.kernel.mandatory.Description;
import io.github.d.lab2.notebook.Notebook;

/**
 * Quick and dirty visitor to support the generation of Wiring code
 */
public class ToWiring extends AbstractStepVisitor<Notebook> {

    public ToWiring() {
        super(new Notebook(), new DefaultStrategy());
    }

    private String tab(int number) {
        return "\t".repeat(number);
    }

    @Override
    public void visit(App app) {
        // Initialize global variables
        context.put("pass", Pass.ONE);
        setFrameworkStrategy(new StrategyFactory().createStrategy("TODO")); // TODO
        app.getDescription().accept(this);
        app.getSelection().accept(this);

        app.getPreprocessing().accept(this);
        app.getTransformation().accept(this);
        app.getDataMining().accept(this);
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

            notebook.appendCode(String.format("split_train, split_test, split_validation = %.2f, %.2f, %.2f%n",
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
            notebook.appendCode("# TODO: Preprocessing");
        }
    }

    @Override
    public void visit(Transformation transformation) {
        notebook.addCellCode("## Transformation step");
        if (context.get("pass") == Pass.ONE) {
            transformation.getElements().forEach(element -> element.accept(this));
            notebook.appendCode("# TODO: Transformation");
        }
    }

    @Override
    public void visit(DataMining dataMining) {
        notebook.addCellCode("## Data mining step");
        if (context.get("pass") == Pass.ONE) {
            dataMining.getElements().forEach((e) -> e.accept(this));
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
}
