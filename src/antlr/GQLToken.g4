grammar GQLIdentifier;

@header{
    package antlr;
}

import GQLKeywords;

/* Implementation of section 21.4 and 21.5 */
token
    : non_delimiter_token
    | delimiter_token                               # Token
    ;

non_delimiter_token
    : regular_identifier
    | parameter_name
    | Keyword
    | unsigned_numeric_literal
    | binary_string_literal
    | MULTISET_ALTERNATION                          # NonDelimiterToken
    ;

regular_identifier
    : identifier_body                               # RegularIdentifier
    ;

identifier_body
    : identifier_start (identifier_part)*           # IdentifierBody
    ;

identifier_part
    : identifier_start
    | identifier_extend                             # IdentifierPart
    ;

identifier_start
    : //TODO: syntax rules                          # IdentifierStart
    ;

identifier_extend
    : //TODO: syntax rules                          # IdentifierExtend
    ;

delimiter_token
    : date_string
    | time_string
    | datetime_string
    | duration_string
    | BRACKET_RIGHT_ARROW
    | CONCATENATION
    | delimited_identifier
    | GqlSpecialCharacter
    | GEQ
    | LEFT_ARROW
    | LEFT_ARROW_BRACKET
    | LEQ
    | MINUS_LEFT_BRACKET
    | NEQ
    | RIGHT_ARROW
    | RIGHT_BRACKET_MINUS
    | TILDE_LEFT_BRACKET
    | RIGHT_BRACKET_TILDE
    | BRACKET_TILDE_RIGHT_ARROW
    | LEFT_ARROW_TILDE_BRACKET
    | TILDE_RIGHT_ARROW
    | LEFT_MINUS_RIGHT
    | LEFT_ARROW_TILDE
    | MINUS_SLASH
    | SLASH_MINUS_RIGHT
    | LEFT_MINUS_SLASH
    | SLASH_MINUS
    | TILDE_SLASH
    | SLASH_TILDE
    | SLASH_TILDE_RIGHT
    | LEFT_TILDE_SLASH
    | LT
    | GT
    | DOUBLE_COLON
    | DOUBLE_MINUS_SIGN
    | DOUBLE_PERIOD
    | character_string_literal                      # DelimiterToken
    ;

date_string: ' '; // TODO: ADD

time_string: ' '; // TODO: ADD

datetime_string: ' '; // TODO: ADD

duration_string: ' '; // TODO: ADD

character_string_literal: ' '; // TODO: ADD

delimited_identifier
    : GRAVE_ACCENT delimited_identifier_body GRAVE_ACCENT   # DelimitedIdentifierBody
    ;

delimited_identifier_body
    : delimited_identifier_part                             # DelimitedIdentifierPart
    ;

delimited_identifier_part
    : // TODO: see syntax rules                             # DelimitedIdentifierPart
    ;

separator
    : (comment | WS)                                        # Separator
    ;

comment
    : simple_comment
    | bracketed_comment                                     # Comment
    ;

simple_comment
    : simple_comment_introducer (simple_comment_character)* new_line        # SimpleComment
    ;

simple_comment_introducer
    : DOUBLE_SOLIDUS
    | DOUBLE_MINUS_SIGN                                     # SimpleCommentIntroducer
    ;

simple_comment_character
    : //TODO: see syntax rules
    ;

bracketed_comment
    : BRACKETED_COMMENT_INTRODUCER bracketed_comment_contents BRACKETED_COMMENT_TERMINATOR      # BracketedComment
    ;

bracketed_comment_contents
    : //TODO: see syntax rules                              # BracketedCommentContents
    ;

escaped_grave_accent
    : REVERSE_SOLIDUS GRAVE_ACCENT
    | DOUBLED_GRAVE_ACCENT                                  # EscapedGraveAccent
    ;

gql_terminal_character
    : GqlLanguageCharacter
    | OtherLanguageCharacter                                # GqlTerminalCharacter
    ;

/* TOKENS */
fragment
GqlLanguageCharacter
    : SimpleLatinLetter
    | Digit
    | GqlSpecialCharacter
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

fragment
Digit
    : StandardDigit
    | OtherDigit
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

fragment
GqlSpecialCharacter
    : SPACE
    | AMPERSAND
    | ASTERISK
    | COLON
    | EQUALS
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

fragment
OtherLanguageCharacter
    : //TODO: see syntax rules
    ;

// 21.4
BRACKET_RIGHT_ARROW: ']->';
LEFT_ARROW_BRACKET: '<-[';
DOUBLE_COLON: '::';
DOUBLE_MINUS_SIGN: '--';
DOUBLE_PERIOD: '..';
DOUBLE_SOLIDUS: '//';
DOUBLED_GRAVE_ACCENT: '``';
LEFT_ARROW: '<-';
RIGHT_ARROW: '->';
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
REVERSE_SOLIDUS: '\\';
SEMICOLON: ';';
SOLIDUS: '/';
TILDE: '~';
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
EQUALS: '=';


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
WS: [ \t\n]+ -> skip;
SPACE: [\u0020];
BRACKETED_COMMENT_INTRODUCER: '/*';
BRACKETED_COMMENT_TERMINATOR: '*/';




