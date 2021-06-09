parser grammar JsonNodeParser;

@header {
    package antlr;
}

options
{
    language=Java;
    tokenVocab=GqlLexer;
}

jsonNodeFile
    : LEFT_BRACE node (COMMA node)* RIGHT_BRACE EOF
    | LEFT_BRACE RIGHT_BRACE EOF
    ;

node
    : WORD COLON LEFT_BRACE nodeFiller RIGHT_BRACE
    ;

nodeFiller
    : WORD COLON identity (COMMA labels)? (COMMA properties)?
    ;

identity
    : quotedId
    ;

labels
    :   WORD COLON '[' quotedId (',' quotedId)* ']'
    |   WORD COLON '[' ']'
    ;

properties
    :   WORD COLON '{' pair (',' pair)* '}'
    |   WORD COLON '{' '}'
    ;

pair
    : quotedId ':' (value)
    ;

quotedId
    : WORD
    ;

value
    : WORD
    | TRUTH_VALUE
    | SIGNED_INTEGER
    | SIGNED_FIXED_POINT
    | SIGNED_FLOAT
    ;