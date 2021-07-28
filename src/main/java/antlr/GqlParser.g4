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
    : (focusedMatchClause)+ returnStatement
    ;

ambientQueryExpression
    : matchClause+ returnStatement
    ;

focusedMatchClause
    : FROM graphName matchClause+
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
    : pathPattern (COMMA pathPattern)*
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
    : pathTerm //(VERTICAL_BAR pathTerm)*
    ;

pathTerm
    : path
//    | LEFT_PAREN pathPattern whereClause? RIGHT_PAREN len?
    ;

path
    : nodePattern (edgePattern nodePattern)*
    ;

nodePattern
    : LEFT_PAREN elementPatternFiller RIGHT_PAREN
    ;

edgePattern
    : (fullEdgePointingLeft | fullEdgeUndirected | fullEdgePointingRight) len?
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

// TODO: change to syntax in report
elementPatternFiller
    : elementVariable? isLabelExpr? (LEFT_BRACE propertyList RIGHT_BRACE)?
    ;

propertyList
    : key COLON expr (COMMA key COLON expr)*
    ;

returnList
    : returnItem (COMMA returnItem)*
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
    : UNSIGNED_INTEGER COMMA UNSIGNED_INTEGER
    | UNSIGNED_INTEGER
    ;

expr
    : value                                 # ValueExpression
    | name                                  # NameExpression
    | name PERIOD key                       # PropertyReference
    | expr comparator expr                  # ExpressionComparison
    | NOT expr                              # NegatedExpression
    | expr booleanComparator TRUTH_VALUE    # BooleanComparison
    | expr compOp expr                      # ValueComparison
    ;

isLabelExpr
    : (IS | COLON) labelExpression
    ;

labelExpression
    : labelTerm (VERTICAL_BAR labelTerm)*
    ;

labelTerm
    : labelFactor (AMPERSAND labelFactor)*
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
    | SIGNED_INTEGER
    | SIGNED_FIXED_POINT
    | SIGNED_FLOAT
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