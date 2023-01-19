# ANTLR

## Backus-Naur Form

### Grammaire

```
<root> ::= <description> <framework> <selection> <pre_processing> <transformation> <data_mining> <validation>

<description> ::= "description: " <STRING> <NL>

<framework> ::= "framework: " <FRAMEWORK> (", " <FRAMEWORK>)* <NL>

<selection> ::= "selection:" <NL> <source> <split>
<source> ::= <TAB> "source: " <STRING> <NL>
<split> ::= <TAB> "split:" <NL> (<split_detail>)+
<split_detail> ::= <TAB2> <STEP> " is " <FLOAT> <NL>

<pre_processing> ::= "pre_processing:" <NL> <processing_function>*
<processing_function> ::= <TAB> <FUNCTION> " " <DATA_TYPE> <NL>

<transformation> ::= "transformation:" <NL> <reshape> <normalization>
<reshape> ::= <TAB> "reshape TRAIN [" <INT> ", " <INT> "]" <NL>
<normalization> ::= <TAB> "normalization:" <NL> <normalization_step>+
<normalization_step> ::= <TAB2> <STEP> " " <INT> <NL>

<data_mining> ::= "data_mining:" <NL> <network> <params>
<network> ::= <TAB> "network:" <NL> <network_type>
/* TODO: to complete <network_type> rule */
<network_type> ::= <TAB2> "TODO" <NL>
/* TODO: to complete <params> rule */
<params> ::= <TAB> "params:" <NL>

<validation> ::= "validation:" <NL> <diagrams>*
<diagrams> ::= <TAB> "diagram: " ("loss_epoch_evolution" | "prediction") <NL>

/* Basic rules and constants  */
<STRING> ::= ([0-9] | [a-z] | [A-Z])+
<STEP> ::= ("TRAIN" | "TEST" | "VALIDATION")
<FRAMEWORK> ::= ("PYTORCH" | "KERAS")
<FUNCTION> ::= ("nan")
<DATA_TYPE> ::= ("int")
<INT> ::= ("0" |  [1-9] [0-9]*)
<FLOAT> ::= ("0" |  [1-9] [0-9]*) ("." [0-9]+ )?
<NL> ::= "\n"+
<TAB> ::= ("\t" | "    ")
<TAB2> ::= <TAB> <TAB>
```

### Ressource
Tester la grammaire BNF : [bnfplayground.pauliankline.com](https://bnfplayground.pauliankline.com/)
