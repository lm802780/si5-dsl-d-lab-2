grammar Arduinoml;


/******************
 ** Parser rules **
 ******************/

root            :   description framework? selection pre_processing transformation data_mining validation knowledge EOF;

description     :   'description' ':' detail=STRING; // TODO: accept spaces

framework     :   'framework' ':' frameworkType=FRAMEWORK;

selection       :   'selection' ':' source split;
    source      :   'source' ':'    sourceId=STRING; // TODO: csv or URL instead of basic STRING
    split       :   'split' ':'     (type=TYPE 'is' percentage=NUMBER)+;

pre_processing       :   'pre_processing' ':' (nan)*;
    nan         :   'nan' processing=PROCESSING;

transformation  :    'transformation' ':' reshape* normalization;
    reshape         :   'reshape' type=TYPE array_int;
        // TODO: implement the array of int.
        // See: https://stackoverflow.com/questions/49586618/antlr4-array-implementation-getting-values-of-elements
        array_int : NUMBER ( ',' NUMBER )*;
    normalization   :  'normalization' type=TYPE;

data_mining       :   'data_mining' ':';

validation       :   'validation' ':';
knowledge       :   'knowledge' ':';

/*****************
 ** Lexer rules **
 *****************/

PROCESSING  : ('int' | 'str' | 'DROP');
FRAMEWORK   : ('pytorch' | 'tensorflow');
TYPE        : ('train' | 'test' | 'validation');
STRING      :   [a-zA-Z_][a-zA-Z0-9_]* ;
NUMBER      :   [0-9]+;

/*************
 ** Helpers **
 *************/

fragment LOWERCASE  : [a-z];                                 // abstract rule, does not really exists
fragment UPPERCASE  : [A-Z];
NEWLINE             : ('\r'? '\n' | '\r')+      -> skip;
WS                  : ((' ' | '\t')+)           -> skip;     // who cares about whitespaces?
COMMENT             : '#' ~( '\r' | '\n' )*     -> skip;     // Single line comments, starting with a #
