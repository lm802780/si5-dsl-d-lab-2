# ANTLR

## Backus-Naur Form

### Grammaire

```
<root> ::= <description> <framework> <selection> <pre_processing> <transformation> <data_mining> <validation>

<description> ::= "description: " <STRING> <NL>

<framework> ::= "framework: " <FRAMEWORK> (", " <FRAMEWORK>)* <NL>

<selection> ::= "selection:" <NL> <source> <label_name>? <split>?
<source> ::= <TAB> "source: " <STRING> <NL>
<label_name> ::= <TAB> "label_name is " <STRING> <NL>
<split> ::= <TAB> "split:" <NL> (<split_detail>)*
<split_detail> ::= <TAB2> <STEP> " is " <FLOAT> <NL>

<pre_processing> ::= "pre_processing:" <NL> <processing_function>*
<processing_function> ::= <TAB> <FUNCTION> " " <DATA_TYPE> <NL>

<transformation> ::= "transformation:" <NL> <reshape> <normalization>
<reshape> ::= <TAB> "reshape TRAIN [" <INT> ", " <INT> "]" <NL>
<normalization> ::= <TAB> "normalization:" <NL> <normalization_step>+
<normalization_step> ::= <TAB2> <STEP> " " <INT> <NL>

<data_mining> ::= "data_mining:" <NL> <network> <params>

/* Data mining - Network part */
<network> ::= <TAB> "network:" <NL> <network_type>
/* <network_type> future-proof, in case the DSL supports more than one network type */
<network_type> ::= <sequential>
<sequential> ::= <TAB2> "sequential:" <NL> (<linear> | <tanh> | <elu> | <selu> | <sigmoid> | <softmax> | <softplus> | <softsign>)+
<linear> ::= <TAB3> "linear: " <INT> " " <INT> <NL>
<tanh> ::= <TAB3> "tanh" <NL>
<elu> ::= <TAB3> "elu" <NL>
<selu> ::= <TAB3> "selu" <NL>
<sigmoid> ::= <TAB3> "sigmoid" <NL>
<softmax> ::= <TAB3> "softmax" <NL>
<softplus> ::= <TAB3> "softplus" <NL>
<softsign> ::= <TAB3> "softsign" <NL>

/* Data mining - Params part */
<params> ::= <TAB> "params:" <NL> <loss> <optimizers> <learningRate> <nbEpochs> <batchSize>
<loss> ::= <TAB2> "loss: " <LOSS_TYPE> <NL>
<optimizers> ::= <TAB2> "optimizers: " <OPTIMIZERS_TYPE> <NL>
<learningRate> ::= <TAB2> "learningRate: " <FLOAT> <NL>
<nbEpochs> ::= <TAB2> "nbEpochs: " <INT> <NL>
<batchSize> ::= <TAB2> "batchSize: " <INT> <NL>

<validation> ::= "validation:" <NL> <diagrams>*
<diagrams> ::= <TAB> "diagram: " ("loss_epoch_evolution" | "prediction" | "confusion") <NL>

/* Basic rules and constants  */
<STRING> ::= (([0-9] | [a-z] | [A-Z]) | " " | "." | ":" | "/")+
<STEP> ::= ("TRAIN" | "TEST" | "VALIDATION")
<FRAMEWORK> ::= ("PYTORCH" | "KERAS")
<FUNCTION> ::= ("nan")
<DATA_TYPE> ::= ("int")
<LOSS_TYPE> ::= ("MSE")
<OPTIMIZERS_TYPE> ::= ("ADAM")
<INT> ::= ("0" |  [1-9] [0-9]*)
<FLOAT> ::= ("0" |  [1-9] [0-9]*) ("." [0-9]+ )?
<NL> ::= "\n"+
<TAB> ::= ("\t" | "    ")
<TAB2> ::= <TAB> <TAB>
<TAB3> ::= <TAB2> <TAB>
```

### Ressource
Tester la grammaire BNF : [bnfplayground.pauliankline.com](https://bnfplayground.pauliankline.com/)
