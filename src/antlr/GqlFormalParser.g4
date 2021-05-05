parser grammar GqlFormalParser;

options
{
    language=Java;
    tokenVocab=GqlLexer;
}

file
    : query EOF
    ;

query
    : query_expr (query_conjunction query)?
    ;

query_conjunction
    : set_operator
    | OTHERWISE
    ;

query_expr
    : focused_query_expr
    | ambient_query_expr
    ;

focused_query_expr
    : (FROM graph_name match_clause+)+ return_statement
    ;

ambient_query_expr
    : match_clause+ return_statement
    ;

match_clause
    : (OPTIONAL | MANDATORY)? MATCH path_pattern_list where_clause?
    ;

where_clause
    : WHERE expr
    ;

return_statement
    : RETURN set_quantifier? (ASTERISK | return_list)
    ;

path_pattern_list
    : path_pattern
    | path_pattern COMMA path_pattern_list
    ;

path_pattern
    : (path_variable EQ)? path_pattern_prefix? path_pattern_expression
    ;

path_pattern_prefix
    : WALK
    | TRAIL
    | ACYCLIC
    | SIMPLE
    ;

path_pattern_expression
    : path_term
    | path_pattern_union
    ;

path_pattern_union
    : path_term (VERTICAL_BAR path_term)+
    ;

path_term
    : node_pattern
    | node_pattern edge_pattern len? path_term
    | LEFT_PAREN path_pattern where_clause? RIGHT_PAREN len?
    ;

node_pattern
    : LEFT_PAREN element_pattern_filler RIGHT_PAREN
    ;

edge_pattern
    : full_edge_pointing_left
    | full_edge_undirected
    | full_edge_pointing_right
    ;

full_edge_pointing_left
    : LEFT_ARROW_BRACKET element_pattern_filler RIGHT_BRACKET_MINUS
    ;

full_edge_undirected
    : TILDE_LEFT_BRACKET element_pattern_filler RIGHT_BRACKET_TILDE
    ;

full_edge_pointing_right
    : MINUS_LEFT_BRACKET element_pattern_filler BRACKET_RIGHT_ARROW
    ;

element_pattern_filler
    : element_variable? is_label_expr? (LEFT_BRACE property_list LEFT_BRACE)?
    ;

property_list
    : key COLON expr
    | key COLON expr COMMA property_list
    ;

return_list
    : return_item
    | return_item COMMA return_list
    ;

return_item
    : expr (AS name)?
    ;

set_operator
    : union_operator
    | other_set_operator
    ;

union_operator
    : UNION (set_quantifier | MAX)?
    ;

other_set_operator
    : (EXCEPT | INTERSECT) set_quantifier?
    ;

set_quantifier
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
    | expr boolean_comparator truth_value
    | expr comp_op expr
    ;

is_label_expr
    : (IS | COLON) label_expression
    ;

label_expression
    : label_term
    | label_expression VERTICAL_BAR label_term
    ;

label_term
    : label_factor
    | label_term AMPERSAND label_factor
    ;

label_factor
    : label_primary
    | label_negation
    ;

label_negation
    : EXCLAMATION_MARK label_primary
    ;

label_primary
    : label
    | label_wildcard
    | parenthesized_label_expression
    ;

label
    : identifier
    ;

label_wildcard
    : PERCENT
    ;

parenthesized_label_expression
    : LEFT_PAREN label_expression RIGHT_PAREN
    | LEFT_BRACKET label_expression RIGHT_BRACKET
    ;

comparator
    : OR
    | AND
    | XOR
    ;

boolean_comparator
    : IS (NOT)?
    ;

comp_op
    : EQ
    | NEQ
    | LT
    | GT
    | LEQ
    | GEQ
    ;

graph_name
    : name
    ;

name
    : identifier
    ;

value
    : truth_value
    | UNSIGNED_INTEGER
    | WORD
    ;

truth_value
    : TRUE
    | FALSE
    | UNKNOWN
    | NULL
    ;

path_variable
    : identifier
    ;

element_variable
    : identifier
    ;

key
    : identifier
    ;

identifier
    : ID
    ;