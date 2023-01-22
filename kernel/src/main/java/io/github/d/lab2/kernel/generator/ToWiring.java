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
import io.github.d.lab2.kernel.generator.visitor.strategy.factory.IStrategyFactory;
import io.github.d.lab2.kernel.generator.visitor.strategy.factory.StrategyFactory;
import io.github.d.lab2.kernel.mandatory.Description;
import io.github.d.lab2.kernel.mandatory.Framework;
import io.github.d.lab2.notebook.Notebook;

import java.util.Locale;

/**
 * Quick and dirty visitor to support the generation of Wiring code
 */
public class ToWiring extends AbstractStepVisitor {

    public ToWiring() {
        super(new Notebook());
    }

    @Override
    public void visit(App app) {
        IStrategyFactory strategyFactory = new StrategyFactory();
        int passCounter = 0;
        for (Framework appFramework : app.getFrameworks()) {
            setFramework(appFramework.getFramework());
            setFrameworkStrategy(strategyFactory.createStrategy(appFramework.getFramework(), notebook));
            if (passCounter == 0) {
                // these steps are done only one time
                app.getDescription().accept(this);
                app.getSelection().accept(this);
                app.getPreprocessing().accept(this);
            }
            app.getTransformation().accept(this);
            app.getDataMining().accept(this);
            passCounter++;
        }
        for (Framework appFramework : app.getFrameworks()) {
            setFramework(appFramework.getFramework());
            setFrameworkStrategy(strategyFactory.createStrategy(appFramework.getFramework(), notebook));
            app.getValidation().accept(this);
        }
        app.getKnowledge().accept(this);
        // Generate the code
        notebook.save("notebooks/notebook.ipynb");
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


        notebook.appendCode(String.format("label_colname = '%s'", selection.getLabel()));

        notebook.addCellCode();
        notebook.appendCode("data = pd.read_csv(source, encoding='utf_8', parse_dates=True)");

        notebook.addCellCode();
        notebook.appendCode("data.head()");

        notebook.addCellCode();
        notebook.appendCode(String.format("X, y = data.drop(['%s'], axis = 1), data['%s']%n", selection.getLabel(), selection.getLabel()));
        notebook.appendCode("X_train, X_test, y_train, y_test = train_test_split(X, y, train_size = split_train / 100, test_size = split_test / 100, random_state=42)");
    }

    @Override
    public void visit(Preprocessing preprocessing) {
        notebook.addCellCode("## Preprocessing step");
        notebook.appendCode("""
                from sklearn.preprocessing import LabelEncoder
                le = LabelEncoder()
                y, y_train, y_test = le.fit_transform(y), le.fit_transform(y_train), le.fit_transform(y_test)
                """);
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
                notebook.appendCode("target = torch.FloatTensor(y_train).view(-1,1)");
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
        notebook.addCellMarkdown();
        notebook.appendMarkdown("## Knowledge step");

        notebook.addCellMarkdown();
        notebook.appendMarkdown("Your knowledge here...");
    }
}
