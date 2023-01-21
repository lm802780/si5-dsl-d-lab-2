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
import io.github.d.lab2.kernel.generator.visitor.strategy.factory.StrategyFactory;
import io.github.d.lab2.kernel.mandatory.Description;
import io.github.d.lab2.notebook.Notebook;

import java.util.Locale;

/**
 * Quick and dirty visitor to support the generation of Wiring code
 */
public class ToWiring extends AbstractStepVisitor {

    public ToWiring() {
        super(new Notebook());
    }

    private void initStrategy(App app) {
        setFramework(app.getFramework().getFramework());
        if (app.getFramework() == null || app.getFramework().getFramework() == null) {
            setFrameworkStrategy(new StrategyFactory().createStrategy(null, notebook));
        } else {
            setFrameworkStrategy(new StrategyFactory().createStrategy(app.getFramework().getFramework(), notebook));
        }
    }

    @Override
    public void visit(App app) {
        initStrategy(app);

        app.getDescription().accept(this);
        app.getSelection().accept(this);

        app.getPreprocessing().accept(this);

        app.getTransformation().accept(this);
        app.getDataMining().accept(this);
        app.getValidation().accept(this);
        //app.getKnowledge().accept(this);

        // Generate the code.
        notebook.save("results/notebook.ipynb");
    }

    @Override
    public void visit(Description description) {

        notebook.addCellMarkdown();
        notebook.appendMarkdown(String.format("# %s", description.getDetail()));

    }

    @Override
    public void visit(Selection selection) {
        notebook.addCellCode();
        notebook.appendCode("import pandas as pd\n");
        notebook.appendCode("import matplotlib.pyplot as plt\n");
        notebook.appendCode("import numpy as np\n");
        notebook.appendCode("from sklearn.model_selection import train_test_split");

        notebook.addCellCode("## Selection step");


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

    @Override
    public void visit(Preprocessing preprocessing) {
        notebook.addCellCode("## Preprocessing step");

        preprocessing.getElements().forEach(element -> element.accept(this));
    }

    @Override
    public void visit(Transformation transformation) {
        notebook.addCellMarkdown();
        notebook.appendMarkdown("## Transformation step");

        transformation.getElements().forEach(element -> element.accept(this));
        switch (this.framework) {
            case PYTORCH -> {
                notebook.addCellCode();
                notebook.appendCode("import torch\n");
                notebook.appendCode("# converting data (to pytorch tensor)\n");
                notebook.appendCode("input_data = torch.FloatTensor(X_train.select_dtypes(include=['int', 'float']).values)\n");
                notebook.appendCode("target = torch.FloatTensor(y_train.values).view(-1,1)");
            }
        }
    }

    @Override
    public void visit(DataMining dataMining) {
        notebook.addCellMarkdown();
        notebook.appendMarkdown("# Data Mining step");
        notebook.addCellCode();
        switch (this.framework) {
            case PYTORCH -> {
                notebook.appendCode("import torch\n");
                notebook.appendCode("import torch.nn as nn\n");
                notebook.appendCode("from torch.utils.data import DataLoader, TensorDataset");
            }
            case KERAS -> {
                notebook.appendCode("import keras.models as km\n");
                notebook.appendCode("import keras.layers as kl");
            }
        }

        dataMining.getNetwork().accept(this);
        dataMining.getTraining().accept(this);
    }

    @Override
    public void visit(Validation validation) {
        notebook.addCellMarkdown();
        notebook.appendMarkdown("## Validation step");

        validation.getValidationElement().forEach(e -> e.accept(this));
    }

    @Override
    public void visit(Knowledge knowledge) {
        notebook.addCellCode("## Knowledge step");

        notebook.appendCode(String.format("# nKnowledge: %s", knowledge.toString()));
    }
}
