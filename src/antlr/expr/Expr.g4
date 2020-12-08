/* Grammar from tutorial */
grammar Expr;

/* The grammar name and grammar filename must match */

@header{
    package antlr;
}

/* Start Variable */
prog: (decl | expr)+ EOF        # Program
    ;

decl: ID ':' INT_TYPE '=' NUM   # Declaration
    ;

/* ANTLR resolves ambiguities in favor of the alternative given first. */
expr: expr '*' expr             # Multiplication
    | expr '+' expr             # Addition
    | ID                        # Variable
    | NUM                       # Number
    ;

/* Tokens */
ID          : [a-z][a-zA-Z0-9_]*;
NUM         : '0' | '-'?[1-9][0-9]*;
INT_TYPE    : 'INT';
COMMENT     : '--' ~[\r\n]* -> skip;
WS          : [ \t\n]+ -> skip;