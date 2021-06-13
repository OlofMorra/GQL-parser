parser grammar JsonGraphParser;

@header {
    package antlr;
}

options
{
    language=Java;
    tokenVocab=GqlLexer;
}

jsonFile
    : jsonNodeFile
    | jsonEdgeFile
    ;

jsonNodeFile
    : LEFT_BRACE node (COMMA node)* RIGHT_BRACE EOF
    | LEFT_BRACE RIGHT_BRACE EOF
    ;

jsonEdgeFile
    : LEFT_BRACE edge (COMMA edge)* RIGHT_BRACE EOF
    | LEFT_BRACE RIGHT_BRACE EOF
    ;

node
    : WORD COLON LEFT_BRACE nodeFiller RIGHT_BRACE
    ;

edge
    : WORD COLON LEFT_BRACE edgeFiller RIGHT_BRACE
    ;

nodeFiller
    : WORD COLON identity (COMMA labels)? (COMMA properties)?
    ;

edgeFiller
    : WORD COLON identity COMMA WORD COLON startNode COMMA WORD COLON endNode (COMMA labels)? (COMMA properties)? (isDirected)?
    ;

identity
    : quotedId
    ;

startNode
    : quotedId
    ;

endNode
    : quotedId
    ;

isDirected
    : COMMA WORD COLON SIGNED_INTEGER
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