grammar Notebookml;


/******************
 ** Parser rules **
 ******************/

root            :   description frameworks workflow EOF;

description     :   detail=STRINGS;

frameworks     :   'framework' ':' framework* (',' framework)*;
    framework : frameworkType=FRAMEWORK ;

workflow: selection (preProcessing?) transformation data_mining validation;
    selection       :   'selection' ':' source split;
        source      :   'source' ':'    sourceId=(VALID_CSV|VALID_URL);
        split       :   'split' ':'     (split_list)+;
            split_list: type=TYPE 'is' percentage=NUMBER;
    preProcessing   :   'pre_processing' ':' nan;
        nan         :    'nan' (nan_processing=PROCESSING);

    transformation  :    'transformation' ':' (reshape|normalization)*;
            reshape         :   'reshape' type=TYPE '[' reshape_values* (',' reshape_values)* ']';
                reshape_values : reshape_value=NUMBER;
            normalization   :  'normalization:' normalization_elem+;
                normalization_elem: type=TYPE size=NUMBER;

    data_mining       :   'data_mining' ':' network params;
        network: 'network:' sequential;
            sequential: 'sequential:' (linear|tanh|softmax)+;
                linear: 'linear:' linear_in=NUMBER linear_out=NUMBER;
                tanh: 'tanh';
                softmax: 'softmax';
        params: 'params:' loss optimizers learningRate nbEpochs batchSize;
            loss: 'loss:' loss_type=LOSS;
            optimizers: 'optimizers:' optimizers_type=OPTIMIZERS;
            learningRate: 'learningRate:' learningRate_nb=DOUBLE;
            nbEpochs: 'nbEpochs:' nbEpochs_nb=NUMBER;
            batchSize: 'batchSize:' batchSize_nb=NUMBER;
    validation       :   'validation:' (diagram|score)+;
        diagram: 'diagram:' diagram_name=DIAGRAMS;
        score: score_type=SCORE_TYPE;

/*****************
 ** Lexer rules **
 *****************/

PROCESSING  : ('int' | 'str' | 'drop');
LOSS  : ('MSE');
OPTIMIZERS  : ('ADAM');
DIAGRAMS  : ('loss_epoch_evolution'|'prediction');
FRAMEWORK   : 'PYTORCH' | 'KERAS';
TYPE        : 'TRAIN' | 'TEST' | 'VALIDATION';
SCORE_TYPE  : 'R2' | 'MSE';
STRINGS      :   'description:' ~( '\r' | '\n' )*;
NUMBER      :   [0-9]+;
DOUBLE      :   [0-9.]+;
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
