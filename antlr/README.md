# ANTLR

## Backus-Naur Form

### Grammaire

```
<root> ::= <description> <framework> <selection> <pre_processing> <transformation> <data_mining> <validation>

<description> ::= "description: " <STRING> <NL>

<framework> ::= "framework: " ("PYTORCH" | "TENSORFLOW") <NL>

<selection> ::= "selection:" <NL> <source> <split>
<source> ::= <TAB> "source: " <STRING> <NL>
<split> ::= <TAB> "split:" <NL> (<split_detail>)+ <NL>
<split_detail> ::= <TAB2> <STEP> " is " <FLOAT> <NL>

<pre_processing> ::= "pre_processing:" <NL> <processing_function>*
<processing_function> ::= <TAB> <FUNCTION> <DATA_TYPE> <NL>

<transformation> ::= "transformation:" <NL> <reshape> <normalization>
<reshape> ::= <TAB> "TRAIN" "[" <INT> "," <INT> "]" <NL>
<normalization> ::= "normalization: " <NL> <normalization_step>
<normalization_step> ::= <TAB2> <STEP> <INT> <NL>

<data_mining> ::= "data_mining:" <NL> <network> <params>
<network> ::= <TAB> "network:" <NL> <network_type>
/* TODO: to complete <network_type> rule */
<network_type> ::= <TAB2> "TODO" <NL>
/* TODO: to complete <params> rule */
<params> ::= <TAB> "params:" <NL>

<validation> ::= "validation:" <NL> <diagrams>*
<diagrams> ::= <TAB> "diagram: " (<loss_epoch_evolution> | <prediction>)
<loss_epoch_evolution> ::= "loss_epoch_evolution"
<prediction> ::= "prediction" <NL> <TAB2> "size: " <INT>

/* Basic rules and constants  */
<STRING> ::= ([0-9] | [a-z] | [A-Z])+
<STEP> ::= ("TRAIN" | "TEST" | "VALIDATION")
<FUNCTION> ::= ("nan")
<DATA_TYPE> ::= ("int")
<INT> ::= ("0" |  [1-9] [0-9]*)
<FLOAT> ::= ("0" |  [1-9] [0-9]*) ("." [0-9]+ )?
<NL> ::= "\n"+
<TAB> ::= "\t"
<TAB2> ::= <TAB> <TAB>
<TAB3> ::= <TAB> <TAB>
```

### Ressource
Tester la grammaire BNF : [bnfplayground.pauliankline.com](https://bnfplayground.pauliankline.com/)
