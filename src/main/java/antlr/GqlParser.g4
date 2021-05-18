parser grammar GqlParser;

@header {
    package antlr;
}

options
{
    language=Java;
    tokenVocab=GqlLexer;
}

query
    : queryExpression (queryConjunction queryExpression)* EOF
    ;

queryConjunction
    : setOperator
    | OTHERWISE
    ;

queryExpression
    : focusedQueryExpression
    | ambientQueryExpression
    ;

focusedQueryExpression
    : (FROM graphName matchClause+)+ returnStatement
    ;

ambientQueryExpression
    : matchClause+ returnStatement
    ;

matchClause
    : (OPTIONAL | MANDATORY)? MATCH pathPatternList whereClause?
    ;

whereClause
    : WHERE expr
    ;

returnStatement
    : RETURN setQuantifier? (ASTERISK | returnList)
    ;

pathPatternList
    : pathPattern
    | pathPattern COMMA pathPatternList
    ;

pathPattern
    : (pathVariable EQ)? pathPatternPrefix? pathPatternExpression
    ;

pathPatternPrefix
    : WALK
    | TRAIL
    | ACYCLIC
    | SIMPLE
    ;

pathPatternExpression
    : pathTerm
    | pathPatternUnion
    ;

pathPatternUnion
    : pathTerm (VERTICAL_BAR pathTerm)+
    ;

pathTerm
    : path
    | LEFT_PAREN pathPattern whereClause? RIGHT_PAREN len?
    ;

path
    : nodePattern
    | nodePattern edgePattern len? path
    ;

nodePattern
    : LEFT_PAREN elementPatternFiller RIGHT_PAREN
    ;

edgePattern
    : fullEdgePointingLeft
    | fullEdgeUndirected
    | fullEdgePointingRight
    ;

fullEdgePointingLeft
    : LEFT_ARROW_BRACKET elementPatternFiller RIGHT_BRACKET_MINUS
    ;

fullEdgeUndirected
    : TILDE_LEFT_BRACKET elementPatternFiller RIGHT_BRACKET_TILDE
    ;

fullEdgePointingRight
    : MINUS_LEFT_BRACKET elementPatternFiller BRACKET_RIGHT_ARROW
    ;

elementPatternFiller
    : elementVariable? isLabelExpr? (LEFT_BRACE propertyList LEFT_BRACE)?
    ;

propertyList
    : key COLON expr
    | key COLON expr COMMA propertyList
    ;

returnList
    : returnItem
    | returnItem COMMA returnList
    ;

returnItem
    : expr (AS name)?
    ;

setOperator
    : unionOperator
    | otherSetOperator
    ;

unionOperator
    : UNION (setQuantifier | MAX)?
    ;

otherSetOperator
    : (EXCEPT | INTERSECT) setQuantifier?
    ;

setQuantifier
    : DISTINCT
    | ALL
    ;

len
    : LEFT_BRACE quantifier RIGHT_BRACE
    ;

quantifier
    : UNSIGNED_INTEGER
    | UNSIGNED_INTEGER COMMA UNSIGNED_INTEGER
    ;

expr
    : value
    | name
    | expr PERIOD key
    | expr comparator expr
    | NOT expr
    | expr booleanComparator TRUTH_VALUE
    | expr compOp expr
    ;

isLabelExpr
    : (IS | COLON) labelExpression
    ;

labelExpression
    : labelTerm
    | labelExpression VERTICAL_BAR labelTerm
    ;

labelTerm
    : labelFactor
    | labelTerm AMPERSAND labelFactor
    ;

labelFactor
    : labelPrimary
    | labelNegation
    ;

labelNegation
    : EXCLAMATION_MARK labelPrimary
    ;

labelPrimary
    : label
    | labelWildcard
    | parenthesizedLabelExpression
    ;

label
    : ID
    ;

labelWildcard
    : PERCENT
    ;

parenthesizedLabelExpression
    : LEFT_PAREN labelExpression RIGHT_PAREN
    | LEFT_BRACKET labelExpression RIGHT_BRACKET
    ;

comparator
    : OR
    | AND
    | XOR
    ;

booleanComparator
    : IS (NOT)?
    ;

compOp
    : EQ
    | NEQ
    | LT
    | GT
    | LEQ
    | GEQ
    ;

graphName
    : name
    ;

name
    : ID
    ;

value
    : TRUTH_VALUE
    | UNSIGNED_INTEGER
    | WORD
    ;

pathVariable
    : ID
    ;

elementVariable
    : ID
    ;

key
    : ID
    ;