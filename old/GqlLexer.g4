lexer grammar GqlLexer;

tokens
{
    ON
}
//-------------------------------------------------------------------------
//
//  Lexer Rules
//
//-------------------------------------------------------------------------

// Comment Tokens
fragment
BRACKETED_COMMENT_INTRODUCER: '/*';

fragment
BRACKETED_COMMENT_TERMINATOR: '*/';

fragment
LineComment: '//';

COMMENT
    :   (BRACKETED_COMMENT_INTRODUCER (GqlLanguageCharacter)* BRACKETED_COMMENT_TERMINATOR)+ -> skip
    ;

LINE_COMMENT
    : 	((LineComment | '--') ~('\n'|'\r')* '\r'? '\n')+ -> skip
    ;

WS: [ \t\r\n]+ -> skip;

fragment A : [aA]; // match either an 'a' or 'A'
fragment B : [bB];
fragment C : [cC];
fragment D : [dD];
fragment E : [eE];
fragment F : [fF];
fragment G : [gG];
fragment H : [hH];
fragment I : [iI];
fragment J : [jJ];
fragment K : [kK];
fragment L : [lL];
fragment M : [mM];
fragment N : [nN];
fragment O : [oO];
fragment P : [pP];
fragment Q : [qQ];
fragment R : [rR];
fragment S : [sS];
fragment T : [tT];
fragment U : [uU];
fragment V : [vV];
fragment W : [wW];
fragment X : [xX];
fragment Y : [yY];
fragment Z : [zZ];

fragment
GqlLanguageCharacter
    : SimpleLatinLetter
    | Digit
    | UNDERSCORE
    ;

fragment
SimpleLatinLetter
    : SimpleLatinLowercase
    | SimpleLatinUppercase
    ;

fragment
SimpleLatinLowercase
   : [a-z]
   ;

fragment
SimpleLatinUppercase
    : [A-Z]
    ;

fragment
HexDigit
	:	StandardDigit | [a-fA-F]
	;

UNSIGNED_INTEGER
    : [1-9][0-9]*
    | [0]
    ;

// TODO: finish
fragment
Digit
    : StandardDigit
    ;

fragment
StandardDigit
    : OctalDigit | [89]
    ;

fragment
OctalDigit
    : BinaryDigit | [2-7]
    ;

fragment
BinaryDigit
    : [01]
    ;

fragment
OtherDigit
    : ' ' // TODO: see syntax rules
    ;

// Keywords
KEYWORD
    : ReservedWords
    ;

fragment
ReservedWords
    : CaseInsensitiveReservedWord
    | 'endNode'
    | 'inDegree'
    | 'lTrim'
    | 'outDegree'
    | 'percentileCont'
    | 'percentileDist'
    | 'rTrim'
    | 'startNode'
    | 'stDev'
    | 'stDevP'
    | 'tail'
    | 'toLower'
    | 'toUpper'
    ;

fragment
CaseInsensitiveReservedWord
    : ABS
    ;

ABS         : A B S;
ACOS        : A C O S;
ADD         : A D D;
AGGREGATE   : A G G R E G A T E;
ALIAS       : A L I A S;
ALL         : A L L;
AND         : A N D;
ANY         : A N Y;
ARRAY       : A R R A Y;
AS          : A S;
ASC         : A S C;
ASCENDING   : A S C E N D I N G;
ASIN        : A S I N;
AT          : A T;
ATAN        : A T A N;
AVG         : A V G;
BINARY      : B I N A R Y;
BOOLEAN     : B O O L E A N;
BOTH        : B O T H;
BY          : B Y;
CALL        : C A L L;
CASE        : C A S E;
CATALOG     : C A T A L O G;
CEIL        : C E I L;
CEILING     : C E I L I N G;
CHARACHTER  : C H A R A C T E R;
CHARACTER_LENGTH    : C H A R A C T E R UNDERSCORE L E N G T H;
CLEAR       : C L E A R;
CLONE       : C L O N E;
CLOSE       : C L O S E;
COLLECT     : C O L L E C T;
COMMIT      : C O M M I T;
CONSTRAINT  : C O N S T R A I N T;
CONSTANT    : C O N S T A N T;
CONSTRCUT   : C O N S T R U C T;
COPY        : C O P Y;
COS         : C O S;
COSH        : C O S H;
COST        : C O S T;
COT         : C O T;
COUNT       : C O U N T;
CURRENT_DATE: C U R R E N T UNDERSCORE D A T E;
CURRENT_GRAPH   : C U R R E N T UNDERSCORE G R A P H;
CURRENT_PROPERTY_GRAPH  : C U R R E N T UNDERSCORE P R O P E R T Y UNDERSCORE G R A P H;
CURRENT_ROLE    : C U R R E N T UNDERSCORE R O L E;
CURRENT_SCHEMA  : C U R R E N T UNDERSCORE S C H E M A;
CURRENT_TIME    : C U R R E N T UNDERSCORE T I M E;
CURRENT_TIMESTAMP   : C U R R E N T UNDERSCORE T I M  E S T A M P;
CURRENT_USER    : C U R R E N T UNDERSCORE U S E R;
CREATE      : C R E A T E;
DATE        : D A T E;
DATETIME    : D A T E T I M E;
DECIMAL     : D E C I M A L;
DEFAULT     : D E F A U L T;
DEGREES     : D E G R E E S;
DELETE      : D E L E T E;
DETACH      : D E T A C H;
DESC        : D E S C;
DESCENDING  : D E S C E N D I N G;
DIRECTORIES : D I R E C T O R I E S;
DIRECTORY   : D I R E C T O R Y;
DISTINCT    : D I S T I N C T;
DO          : D O;
DROP        : D R O P;
DURATION    : D U R A T I O N;
ELSE        : E L S E;
END         : E N D;
ENDS        : E N D S;
EMPTY_BINDING_TABLE : E M P T Y UNDERSCORE B I N D I N G UNDERSCORE T A B L E;
EMPTY_GRAPH         : E M P T Y UNDERSCORE G R A P H;
EMPTY_PROPERTY_GRAPH    : E M P T Y UNDERSCORE P R O P E R T Y UNDERSCORE G R A P H;
EMPTY_TABLE : E M P T Y UNDERSCORE T A B L E;
EXCEPT      : E X C E P T;
EXISTS      : E X I S T S;
EXISTING    : E X I S T I N G;
EXP         : E X P;
EXPLAIN     : E X P L A I N;
FALSE       : F A L S E;
FILTER      : F I L T E R;
FLOAT       : F L O A T;
FLOAT32     : F L O A T '32';
FLOAT64     : F L O A T '64';
FLOAT128    : F L O A T '128';
FLOOR       : F L O O R;
FOR         : F O R;
FROM        : F R O M;
FUNCTOPM    : F U N C T I O N;
FUNCTIONS   : F U N C T I O N S;
GQLSTATUS   : G Q L S T A T U S;
GROUP       : G R O U P;
HAVING      : H A V I N G;
HOME_GRAPH  : H O M E UNDERSCORE G R A P H;
HOME_PROPERTY_GRAPH : H O M E UNDERSCORE P R O P E R T Y UNDERSCORE G R A P H;
HOME_SCHEMA : H O M E UNDERSCORE S C H E M A;
IN          : I N;
INSERT      : I N S E R T;
INTEGER     : I N T E G E R;
INTEGER8    : I N T E G E R '8';
INTEGER16   : I N T E G E R '16';
INTEGER32   : I N T E G E R '32';
INTEGER64   : I N T E G E R '64';
INTEGER128  : I N T E G E R '128';
INTERSECT   : I N T E R S E C T;
IF          : I F;
IS          : I S;
KEEP        : K E E P;
LEADING     : L E A D I N G;
LEFT        : L E F T;
LENGTH      : L E N G T H;
LET         : L E T;
LIKE        : L I K E;
LIMIT       : L I M I T;
LIST        : L I S T;
LN          : L N;
LOCALDATETIME   : L O C A L D A T E T I M E;
LOCALTIME   : L O C A L T I M E;
LOCALTIMESTAMP  : L O C A L T I M E S T A M P;
LOG         : L O G;
LOG10       : L O G '10';
LOWER       : L O W E R;
MANDATORY   : M A N D A T O R Y;
MAP         : M A P;
MATCH       : M A T C H;
MERGE       : M E R G E;
MAX         : M A X;
MIN         : M I N;
MOD         : M O D;
MULTI       : M U L T I;
MULTIPLE    : M U L T I P L E;
MULTISET    : M U L T I S E T;
NEW         : N E W;
NOT         : N O T;
NORMALIZE   : N O R M A L I Z E;
NOTHING     : N O T H I N G;
NULL        : N U L L;
OCTET_LENGTH    : O C T E T  UNDERSCORE  L E N G T H;
OF          : O F;
OFFSET      : O F F S E T;
ON          : O N;
OPTIONAL    : O P T I O N A L;
OR          : O R;
ORDER       : O R D E R;
ORDERED     : O R D E R E D;
OTHERWISE   : O T H E R W I S E;
PARAMETER   : P A R A M E T E R;
PATH        : P A T H;
PATHS       : P A T H S;
PARTITION   : P A R T I T I O N;
POWER       : P O W E R;
PROCEDURE   : P R O C E D U R E;
PROCEDURES  : P R O C E D U R E S;
PRODUCT     : P R O D U C T;
PROFILE     : P R O F I L E;
PROJECT     : P R O J E C T;
QUERIES     : Q U E R I E S;
QUERY       : Q U E R Y;
RADIANS     : R A D I A N S;
RCORD       : R E C O R D;
RECORDS     : R E C O R D S;
REFERENCE   : R E F E R E N C E;
REMOVE      : R E M O V E;
RENAME      : R E N A M E;
REPLACE     : R E P L A C E;
REQUIRE     : R E Q U I R E;
RESET       : R E S E T;
RESULT      : R E S U L T;
RETURN      : R E T U R N;
RIGHT       : R I G H T;
ROLLBACK    : R O L L B A C K;
SCALAR      : S C A L A R;
SCHEMA      : S C H E M A;
SCHEMAS     : S C H E M A S;
SCHEMATA    : S C H E M A T A;
SELECT      : S E L E C T;
SESSION     : S E S S I O N;
SET         : S E T;
SIN         : S I N;
SINGLE      : S I N G L E;
SINH        : S I N H;
SQRT        : S Q R T;
START       : S T A R T;
STARTS      : S T A R T S;
STRING      : S T R I N G;
SUBSTRING   : S U B S T R I N G;
SUM         : S U M;
TAN         : T A N;
TANH        : T A N H;
THEN        : T H E N;
TIME        : T I M E;
TIMESTAMP   : T I M E S T A M P;
TRAILING    : T R A I L I N G;
TRIM        : T R I M;
TRUE        : T R U E;
TRUNCATE    : T R U N C A T E;
UNION       : U N I O N;
UNIT        : U N I T;
UNIT_BINDING_TABLE  : U N I T UNDERSCORE  B I N D I N G  UNDERSCORE  T A B L E;
UNIT_TABLE  : U N I T  UNDERSCORE  T A B L E;
UNIQUE      : U N I Q U E;
UNNEST      : U N N E S T;
UNKNOWN     : U N K N O W N;
UNWIND      : U N W I N D;
UPPER       : U P P E R;
USE         : U S E;
VALUE       : V A L U E;
VALUES      : V A L U E S;
WHEN        : W H E N;
WHERE       : W H E R E;
WITH        : W I T H;
WORKING_GRAPH   : W O R K I N G  UNDERSCORE  G R A P H;
XOR         : X O R;
YIELD       : Y I E L D;
ZERO        : Z E R O;

ACYCLIC                 : A C Y C L I C;
BINDING                 : B I N D I N G;
CLASS_ORIGIN            : C L A S S UNDERSCORE O R I G I N;
COMMAND_FUNCTION        : C O M M A N D  UNDERSCORE  F U N C T I O N;
COMMAND_FUNCTION_CODE   : C O M M A N D  UNDERSCORE  F U N C T I O N  UNDERSCORE  C O D E;
CONDITION_NUMBER        : C O N D I T I O N  UNDERSCORE  N U M B E R;
CONNECTING              : C O N N E C T I N G;
DESTINATION             : D E S T I N A T I O N;
DIRECTED                : D I R E C T E D;
EDGE                    : E D G E;
EDGES                   : E D G E S;
FINAL                   : F I N A L;
GRAPH                   : G R A P H;
GRAPHS                  : G R A P H S;
GROUPS                  : G R O U P S;
INDEX                   : I N D E X;
LABEL                   : L A B E L;
LABELS                  : L A B E L S;
MESSAGE_TEXT            : M E S S A G E  UNDERSCORE  T E X T;
MUTABLE                 : M U T A B L E;
NFC                     : N F C;
NFD                     : N F D;
NFKC                    : N F K C;
NFKD                    : N F K D;
NODE                    : N O D E;
NODES                   : N O D E S;
NORMALIZED              : N O R M A L I Z E D;
NUMBER                  : N U M B E R;
ONLY                    : O N L Y;
ORDINALITY              : O R D I N A L I T Y;
PATTERN                 : P A T T E R N;
PATTERNS                : P A T T E R N S;
PROPERTY                : P R O P E R T Y;
PROPERTIES              : P R O P E R T I E S;
READ                    : R E A D;
RELATIONSHIP            : R E L A T I O N S H I P;
RELATIONSHIPS           : R E L A T I O N S H I P S;
RETURNED_GQLSTATUS      : R E T U R N E D  UNDERSCORE  G Q L S T A T U S;
SHORTEST                : S H O R T E S T;
SIMPLE                  : S I M P L E;
SUBCLASS_ORIGIN         : S U B C L A S S  UNDERSCORE  O R I G I N;
TABLE                   : T A B L E;
TABLES                  : T A B L E S;
TIES                    : T I E S;
TO                      : T O;
TRAIL                   : T R A I L;
TRANSACTION             : T R A N S A C T I O N;
TYPE                    : T Y P E;
TYPES                   : T Y P E S;
UNDIRECTED              : U N D I R E C T E D;
VERTEX                  : V E R T E X;
VERTICES                : V E R T I C E S;
WALK                    : W A L K;
WRITE                   : W R I T E;

fragment
EdgeSynonym
    : E D G E
    | R E L A T I O N S H I P
    ;

fragment
NodeSynonym
    : N O D E
    | V E R T E X
    ;

fragment
PathMode
    : 'WALK'
    | 'TRAIL'
    | 'SIMPLE'
    | 'ACYCLIC'                                                     // 16.9
    ;

fragment
PathOrPaths
    : 'PATH'
    | 'PATHS'                                                       // 16.9
    ;

// Tokens
// 21.4
LEFT_ARROW: '<-';
RIGHT_ARROW: '->';
BRACKET_RIGHT_ARROW: ']->';
LEFT_ARROW_BRACKET: '<-[';
DOUBLE_COLON: '::';
DOUBLE_MINUS_SIGN: '--';
DOUBLE_PERIOD: '..';
DOUBLE_SOLIDUS: '//';
DOUBLED_GRAVE_ACCENT: '``';
MINUS_LEFT_BRACKET: '-[';
RIGHT_BRACKET_MINUS: ']-';
TILDE_LEFT_BRACKET: '~[';
RIGHT_BRACKET_TILDE: ']~';
BRACKET_TILDE_RIGHT_ARROW: ']~>';
LEFT_ARROW_TILDE_BRACKET: '<~[';
TILDE_RIGHT_ARROW: '~>';
LEFT_ARROW_TILDE: '<~';
LEFT_MINUS_RIGHT: '<->';
MINUS_SLASH: '-/';
SLASH_MINUS: '/-';
SLASH_MINUS_RIGHT: '/->';
LEFT_MINUS_SLASH: '<-/';
TILDE_SLASH: '~/';
SLASH_TILDE: '/~';
SLASH_TILDE_RIGHT: '/~>';
LEFT_TILDE_SLASH: '<~/';

// 21.5
AMPERSAND: '&';
ASTERISK: '*';
CIRCUMFLEX: '^';
COLON: ':';
COMMA: ',';
DOLLAR_SIGN: '$';
DOUBLE_QUOTE: '"';
EXCLAMATION_MARK: '!';
GRAVE_ACCENT: '`';
MINUS_SIGN: '-';
PERCENT: '%';
PERIOD: '.';
PLUS_SIGN: '+';
QUESTION_MARK: '?';
QUOTE: '\'';
fragment
REVERSE_SOLIDUS: '\\';
SEMICOLON: ';';
SOLIDUS: '/';
TILDE: '~';
fragment
UNDERSCORE: '_';
VERTICAL_BAR: '|';

// OPERATORS
// 21.4
CONCATENATION: '||';
MULTISET_ALTERNATION: '|+|';
GEQ: '>=';
LEQ: '<=';
NEQ: '<>';
LT: LEFT_ANGLE_BRACKET;
GT: RIGHT_ANGLE_BRACKET;

// 21.5
EQ: '=';


// Separators
LEFT_BRACE: '{';
RIGHT_BRACE: '}';
LEFT_BRACKET: '[';
RIGHT_BRACKET: ']';
LEFT_ANGLE_BRACKET: '<';
RIGHT_ANGLE_BRACKET: '>';
LEFT_PAREN: '(';
RIGHT_PAREN: ')';


// Whitespace and comments
NEWLINE: [\u000A\u000D];

fragment
GqlSpecialCharacter
    : AMPERSAND
    | ASTERISK
    | COLON
    | EQ
    | COMMA
    | DOLLAR_SIGN
    | DOUBLE_QUOTE
    | EXCLAMATION_MARK
    | GRAVE_ACCENT
    | RIGHT_ANGLE_BRACKET
    | LEFT_BRACE
    | LEFT_BRACKET
    | LEFT_PAREN
    | LEFT_ANGLE_BRACKET
    | MINUS_SIGN
    | PERIOD
    | PLUS_SIGN
    | QUESTION_MARK
    | QUOTE
    | REVERSE_SOLIDUS
    | RIGHT_BRACE
    | RIGHT_BRACKET
    | RIGHT_PAREN
    | SEMICOLON
    | SOLIDUS
    | UNDERSCORE
    | VERTICAL_BAR
    | PERCENT
    | CIRCUMFLEX
    | TILDE
    ;

ID
    : SimpleLatinLetter GqlLanguageCharacter*
    ;

WORD
    : (QUOTE | DOUBLE_QUOTE) GqlLanguageCharacter* (QUOTE | DOUBLE_QUOTE)
    ;