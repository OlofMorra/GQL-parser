/* Grammar for GQL */
grammar GQLRead; // The grammar name and grammar filename must match

@header{
    package antlr;
}

import GQLtoken, GQLLiterals, GQLKeywords;

/* Start Variable */
prog
    : EOF                                                           
    ;

nested_query_specification
    : LEFT_BRACE query_specification RIGHT_BRACE                     // 9.2
    ;

query_specification
    : procedure_body                                                 // 9.2
    ;

procedure_body
    : (definition_block)? statement_block                            // 9.4
    ;

definition_block
    : (static_variable_definition)+ (binding_variable_definition)+   // 9.4
    ;

statement_block
    : statement ('THEN' statement)*                                  // 9.4
    ;

// TODO: implement
static_variable_definition
    : ' '                                                               // 10.1
    ;

as_or_equals
    : 'AS' | EQUALS                                                      // 10.1
    ;

// TODO: uncomment
binding_variable_definition
    : graph_variable_definition
//    | binding_table_variable_definition
//    | value_variable_definition                                      // 10.8
    ;

graph_variable_definition
    : ('PROPERTY')? 'GRAPH' graph_variable of_graph_type graph_initializer       // 10.9
    ;

graph_variable
    : binding_variable_name                                          // 10.9
    ;

// TODO: finish
graph_initializer
    : as_or_equals graph_expression                                  // 10.9
    ;

// TODO: uncomment
graph_expression
    : copy_graph_expression
    | graph_specification
//    | graph_reference                                                // 11.3
    ;

copy_graph_expression
    : 'COPY OF' graph_expression                                     // 11.3
    ;

// TODO: finish
of_graph_type
    : like_graph_expression_shorthand                                // 11.4
    ;

like_graph_expression_shorthand
    : 'LIKE' graph_expression                                       
    ;

statement
    : (at_schema_clause)?
    ( catalog_modifying_statement
    | data_modifying_statement
    | query_statement )                                              // 12.1
    ;

// TODO: uncomment
catalog_modifying_statement
    //: linear_catalog_modifying_statement                             // 12.1
    :
    ;

// TODO: uncomment
data_modifying_statement
//    : conditional_data_modifying_statement
//    | linear_data_modifying_statement                                // 12.1
    :
    ;

query_statement
    : composite_query_statement
    | conditional_query_statement
    | select_statement                                               // 12.1
    ;

statement_mode
    : 'OPTIONAL'
    | 'MANDATORY'                                                    // 12.2
    ;

// TODO: finish
simple_query_statement
    : simple_data_reading_statement                                  // 12.3
    ;

// TODO: uncomment
simple_data_reading_statement
    : match_graph_statement
    | match_statement
    //| call_query_statement                                           // 12.3
    ;

// TODO: finish
graph_specification
    : ('OPTIONAL')? 'GRAPH' nested_graph_query_specification         // 13.5
    ;

nested_graph_query_specification
    : nested_query_specification                                     // 13.5
    ;

when_clause
    : 'WHEN' search_condition                                        // 14.2
    ;

composite_query_statement
    : composite_query_expression                                     // 15.1
    ;

conditional_query_statement
    : (when_then_linear_query_branch)+ (else_linear_query_branch)*   // 15.2
    ;

when_then_linear_query_branch
    : when_clause  'THEN'  linear_query_expression
    | when_clause nested_query_specification                         // 15.2
    ;

else_linear_query_branch
    : 'ELSE'  linear_query_expression                                 // 15.2
    ;

composite_query_expression
    : composite_query_expression query_conjunction linear_query_expression
    | linear_query_expression                                        // 15.3
    ;

query_conjunction
    : set_operator
    | 'OTHERWISE'                                                    // 15.3
    ;

set_operator
    : 'UNION' ( set_operator_quantifier)?
    | 'EXCEPT' ( set_operator_quantifier)?
    | 'INTERSECT' ( set_operator_quantifier)?                         // 15.3
    ;

// TODO: uncomment
set_operator_quantifier
    //: set_quantifier
    : 'MAX'                                                          // 15.3
    ;

linear_query_expression
    : linear_query_statement                                         // 15.4
    ;

linear_query_statement
    : focused_linear_query_statement                                 // 15.5
    //| ambient_linear_query_statement  TODO: implement
    ;

focused_linear_query_statement
    : from_graph_clause focused_linear_query_statement_body          // 15.5
    ;

focused_linear_query_statement_body
    : simple_linear_query_statement
      (from_graph_clause simple_linear_query_statement)*
      primitive_result_statement
    | nested_query_specification                                     // 15.5
    ;

simple_linear_query_statement
    : (simple_query_statement)*                                      // 15.5
    ;

match_graph_statement
    : (statement_mode)? 'MATCH' graph_keywords graph_object_pattern  // 15.6.1
    ;

match_statement
    : (statement_mode)? 'MATCH' graph_pattern                       // 15.6.2
    ;

primitive_result_statement
    : return_statement
    | project_statement
    | 'END'                                                          // 15.8.1
    ;

return_statement
    : 'RETURN' return_statement_body                                 // 15.8.2
    ;

// TODO: finish
return_statement_body
    : (ASTERISK | return_item_list)                                  // 15.8.2
    ;

return_item_list
    : return_item (COMMA return_item)*                               // 15.8.2
    ;

return_item
    : value_expression (return_item_alias)?                          // 15.8.2
    ;

return_item_alias
    : 'AS'  identifier                                                // 15.8.2
    ;

// TODO: finish
select_statement
    : 'SELECT' select_item_list select_statement_body                // 15.8.3
    ;

select_item_list
    : select_item (COMMA select_item)*                                     // 15.8.3
    ;

select_item
    : value_expression (select_item_alias)?                          // 15.8.3
    ;

select_item_alias
    : 'AS' identifier                                                // 15.8.3
    ;

select_statement_body
    : (select_graph_matches)+
    | select_query_specification                                     // 15.8.3
    ;

select_graph_matches
    : from_graph_clause match_statement+                             // 15.8.3
    ;

select_query_specification
    : 'FROM' nested_query_specification
    | from_graph_clause nested_query_specification                   // 15.8.3
    ;

project_statement
    : 'PROJECT' value_expression                                     // 15.8.4
    ;

from_graph_clause
    : 'FROM' graph_expression                                        // 16.1
    ;

at_schema_clause
    : 'AT' schema_reference                                          // 16.3
    ;

static_variable
    : static_variable_name                                           // 16.4
    ;

binding_variable
    : binding_variable_name                                          // 16.4
    ;

label
    : label_name                                                     // 16.4
    ;

// TODO: finish
graph_object_pattern
    : graph_object_pattern_variable_list                             // 16.6
    ;

graph_object_pattern_variable_list
    : graph_object_pattern_variable (COMMA graph_object_pattern_variable)*       // 16.6
    ;

// TODO: finish
graph_object_pattern_variable
    : graph_variable                                                 // 16.6
    ;

// TODO: finish
graph_pattern
    : path_pattern_list                                              // 16.7
    ;

path_pattern_list
    : path_pattern (COMMA path_pattern)*                             // 16.7
    ;

path_pattern
    : (path_variable EQUALS)? (path_pattern_prefix)? path_pattern_expression         // 16.7
    ;

// TODO: finish
path_pattern_expression
    : path_term                                                      // 16.8
    ;

path_term
    : path_factor
    | path_term path_factor                                            // 16.8
    ;

// TODO: uncomment
path_factor
    : path_primary
//    | quantified_path_primary
    | questioned_path_primary                                        // 16.8
    ;

questioned_path_primary
    : path_primary QUESTION_MARK                                     // 16.8
    ;

// TODO: uncomment
//quantified_path_primary
//    : path_primary graph_pattern_quantifier                          // 16.8
//    ;

// TODO: finish
path_primary
    : element_pattern                                                // 16.8
    ;

element_pattern
    : node_pattern
    | edge_pattern                                                   // 16.8
    ;

node_pattern
    : LEFT_PAREN element_pattern_filler RIGHT_PAREN                  // 16.8
    ;

element_pattern_filler
    : (element_variable_declaration)?
      (is_label_expression)?
      (element_pattern_where_clause)?
      (element_pattern_cost_clause)?                                 // 16.8
     ;

element_variable_declaration
    : element_variable                                               // 16.8
    ;

is_label_expression
    : is_or_colon label_expression                                   // 16.8
    ;

is_or_colon
    : 'IS'
    | COLON                                                          // 16.8
    ;

element_pattern_where_clause
    : 'WHERE' search_condition                                       // 16.8
    ;

element_pattern_cost_clause
    : cost_clause                                                    // 16.8
    ;

cost_clause
    : 'COST' value_expression ('DEFAULT' value_expression)?          // 16.8
    ;

edge_pattern
    : full_edge_pattern
    | abbreviated_edge_pattern                                       // 16.8
    ;

full_edge_pattern
    : full_edge_pointing_left
    | full_edge_undirected
    | full_edge_pointing_right
    | full_edge_left_or_undirected
    | full_edge_undirected_or_right
    | full_edge_left_or_right
    | full_edge_any_direction                                        // 16.8
    ;

full_edge_pointing_left
    : LEFT_ARROW_BRACKET element_pattern_filler RIGHT_BRACKET_MINUS  // 16.8
    ;

full_edge_undirected
    : TILDE_LEFT_BRACKET element_pattern_filler RIGHT_BRACKET_TILDE  // 16.8
    ;

full_edge_pointing_right
    : MINUS_LEFT_BRACKET element_pattern_filler BRACKET_RIGHT_ARROW  // 16.8
    ;

full_edge_left_or_undirected
    : LEFT_ARROW_TILDE_BRACKET element_pattern_filler RIGHT_BRACKET_TILDE    // 16.8
    ;

full_edge_undirected_or_right
    : TILDE_LEFT_BRACKET element_pattern_filler BRACKET_TILDE_RIGHT_ARROW    // 16.8
    ;

full_edge_left_or_right
    : LEFT_ARROW_BRACKET element_pattern_filler BRACKET_RIGHT_ARROW  // 16.8
    ;

full_edge_any_direction
    : MINUS_LEFT_BRACKET element_pattern_filler RIGHT_BRACKET_MINUS  // 16.8
    ;

abbreviated_edge_pattern
    : LEFT_ARROW
    | TILDE
    | RIGHT_ARROW
    | LEFT_ARROW_TILDE
    | TILDE_RIGHT_ARROW
    | LEFT_MINUS_RIGHT
    | MINUS_SIGN                                                     // 16.8
    ;

graph_pattern_quantifier
    : ASTERISK
    | PLUS_SIGN
    | fixed_quantifier
    | general_quantifier                                             // 16.8
    ;

fixed_quantifier
    : LEFT_BRACE UnsignedInteger RIGHT_BRACE                        // 16.8
    ;

general_quantifier
    : LEFT_BRACE (lower_bound)? COMMA (upper_bound)? RIGHT_BRACE     // 16.8
    ;

lower_bound
    : UnsignedInteger                                                // 16.8
    ;

upper_bound
    : UnsignedInteger                                                // 16.8
    ;

path_pattern_prefix
    : PathMode (PathOrPaths)*
    | path_search_prefix                                             // 16.9
    ;

PathMode
    : 'WALK'
    | 'TRAIL'
    | 'SIMPLE'
    | 'ACYCLIC'                                                     // 16.9
    ;

path_search_prefix
    : all_path_search
    | any_path_search
    | shortest_path_search                                           // 16.9
    ;

all_path_search
    : 'ALL' (PathMode)? PathOrPaths                                  // 16.9
    ;

PathOrPaths
    : 'PATH'
    | 'PATHS'                                                       // 16.9
    ;

any_path_search
    : 'ANY' (number_of_paths)? PathMode PathOrPaths                  // 16.9
    ;

number_of_paths
    : simple_value_specification                                     // 16.9
    ;

// TODO: finish
shortest_path_search
    : all_shortest_path_search
    | any_shortest_path_search                                       // 16.9
    ;

all_shortest_path_search
    : 'ALL'  'SHORTEST' (PathMode)? PathOrPaths                    // 16.9
    ;

any_shortest_path_search
    : 'ANY'  'SHORTEST' (PathMode)? PathOrPaths                    // 16.9
    ;

label_expression
    : label_term
    | label_expression VERTICAL_BAR label_term                       // 16.11
    ;

label_term
    : label_factor
    | label_term AMPERSAND label_factor                              // 16.11
    ;

label_factor
    : label_primary
    | label_negation                                                 // 16.11
    ;

label_negation
    : EXCLAMATION_MARK label_primary                                 // 16.11
    ;

label_primary
    : label
    | wildcard_label
    | parenthesized_label_expression
    ;

wildcard_label
    : PERCENT                                                        // 16.11
    ;

parenthesized_label_expression
    : LEFT_PAREN label_expression RIGHT_PAREN
    | LEFT_BRACKET label_expression RIGHT_BRACKET                    // 16.11
    ;

schema_reference
    : schema_resolution_expression
    | local_schema_reference                                         // 17.1
    ;

schema_resolution_expression
    : 'SCHEMA' catalog_schema_reference                              // 17.1
    ;

// TODO: uncomment
catalog_schema_reference
    : catalog_schema_parent_and_name
    //| predefined_schema_parameter
    //| external_object_reference                                      // 17.1
    ;

// TODO: uncomment
catalog_schema_parent_and_name
    : schema_parent_specification catalog_schema_parent_and_name
    //| url_path_parameter                                             // 17.1
    ;

// TODO: uncomment
schema_parent_specification
    //: (parent_catalog_object_reference)+                             // 17.1
    : ' '
    ;

local_schema_reference
    : schema_name                                                    // 17.1
    ;

search_condition
    : boolean_value_expression                                       // 19.1
    ;

// TODO: finish
predicate
    : comparison_predicate
    | null_predicate                                                 // 19.2
    ;

comparison_predicate
    : non_parenthesized_value_expression_primary comp_op non_parenthesized_value_expression_primary      // 19.3
    ;

comp_op
    : EQ | NEQ | LT | GT | LEQ | GEQ                                 // 19.3
    ;

null_predicate
    : 'IS'  'NULL'                                                 // 19.7
    ;

// TODO: uncomment
simple_value_specification
    : UnsignedLiteral
//    | parameter                                                      // 20.1
    ;

// TODO: implement correctly
value_expression
    : (GqlLanguageCharacter)+                                   // 20.2
    ;

// TODO: implement corrrectly
boolean_value_expression
    : boolean_term                                                   // 20.3
    ;

boolean_term
    : boolean_factor
    | boolean_term 'AND' boolean_factor                              // 20.3
    ;

boolean_factor
    : ('NOT')? boolean_test                                          // 20.3
    ;

boolean_test
    : boolean_primary
      ('IS' ('NOT')?
    | EQUALS
    | NEQ )? truth_value                                             // 20.3
    ;

truth_value
    : 'TRUE'
    | 'FALSE'
    | 'UNKNOWN'
    | 'NULL'                                                         // 20.3
    ;

boolean_primary
    : predicate
    | boolean_predicand                                              // 20.3
    ;

// TODO: finish
boolean_predicand
    : parenthesized_boolean_value_expression                         // 20.3
    ;

parenthesized_boolean_value_expression
    : LEFT_PAREN boolean_value_expression RIGHT_PAREN                // 20.3
    ;

// TODO: finish
non_parenthesized_value_expression_primary
    : binding_variable                                               // 20.5
    ;

schema_name
    : identifier                                                     // 21.3
    ;

label_name
    : identifier
    ;

element_variable
    : identifier                                                     // 21.3
    ;

path_variable
    : identifier                                                     // 21.3
    ;

static_variable_name
    : identifier                                                     // 21.3
    ;

binding_variable_name
    : identifier                                                     // 21.3
    ;

identifier
    : actual_identifier                                              // 21.3
    ;

actual_identifier
    : regular_identifier
    | delimited_identifier                                           // 21.3
    ;

WS: [ \t\n]+ -> skip;