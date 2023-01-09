grammar Notebookml;


/******************
 ** Parser rules **
 ******************/

root            :   description framework workflow EOF;

description     :   detail=STRINGS;

framework     :   'framework' ':' frameworkType=FRAMEWORK;

workflow: selection preProcessing;
    selection       :   'selection' ':' source split;
        source      :   'source' ':'    sourceId=(VALID_CSV|VALID_URL);
        split       :   'split' ':'     (split_list)+;
            split_list: type=TYPE ':' percentage=NUMBER;
    preProcessing   :   'pre_processing' ':' nan;
        nan         :    'nan' (test=PROCESSING);



/*****************
 ** Lexer rules **
 *****************/

PROCESSING  : ('int' | 'str' | 'drop');
FRAMEWORK   : 'PYTORCH' | 'TENSORFLOW';
TYPE        : 'TRAIN' | 'TEST' | 'VALIDATION';
STRINGS      :   '#' ~( '\r' | '\n' )*;
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
