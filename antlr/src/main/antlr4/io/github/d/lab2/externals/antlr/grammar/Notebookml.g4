grammar Notebookml;


/******************
 ** Parser rules **
 ******************/

root            :   description framework workflow EOF;

description     :   'description' ':' detail=STRING+;

framework     :   'framework' ':' frameworkType=FRAMEWORK;

workflow: (selection);
    selection       :   'selection' ':' source split;
        source      :   'source' ':'    sourceId=(VALID_CSV|VALID_URL);
        split       :   'split' ':'     (split_list)+;
            split_list: type=TYPE ':' percentage=NUMBER;

    preProcessing       :   'pre_processing' ':' (nan)*;
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

PROCESSING  : 'int' | 'str' | 'DROP';
FRAMEWORK   : 'PYTORCH' | 'TENSORFLOW';
TYPE        : 'TRAIN' | 'TEST' | 'VALIDATION';
STRING      :   [a-zA-Z_][a-zA-Z0-9_ ]*;
NUMBER      :   [0-9]+;

VALID_CSV      :   [a-zA-Z_/][a-zA-Z0-9/_ ]*'.csv';
VALID_URL      :   ([A-Za-z]+':')?'/'?('/'?[-_.A-Za-z0-9%]+)+;

/*************
 ** Helpers **
 *************/

fragment LOWERCASE  : [a-z];                                 // abstract rule, does not really exists
fragment UPPERCASE  : [A-Z];
NEWLINE             : ('\r'? '\n' | '\r')+      -> skip;
WS                  : ((' ' | '\t')+)           -> skip;     // who cares about whitespaces?
COMMENT             : '#' ~( '\r' | '\n' )*     -> skip;     // Single line comments, starting with a #
