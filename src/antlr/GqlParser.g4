parser grammar GqlParser;

options
{
    language=Java;
    tokenVocab=GqlLexer;
}

file
    : query_statement EOF
    ;

query_statement
    : composite_query_statement
    ;

composite_query_statement
    : composite_query_expression                                     // 15.1
    ;

composite_query_expression
    : composite_query_expression query_conjunction linear_query_expression
    | linear_query_expression                                        // 15.3
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
//    | nested_query_specification                                     // 15.5
    ;

simple_linear_query_statement
    : (simple_query_statement)*                                      // 15.5
    ;


from_graph_clause
    : FROM graph_reference                                        // 16.1
    ;

primitive_result_statement
    : return_statement
    | project_statement
    | END                                                          // 15.8.1
    ;

return_statement
    : RETURN return_statement_body                                 // 15.8.2
    ;

project_statement
    : PROJECT value_expression                                 // 15.8.2
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
    : AS  identifier                                                // 15.8.2
    ;

// TODO: uncomment
graph_reference
//    : copy_graph_expression
    : graph_resolution_reference
//    | graph_reference                                                // 17.2
    ;

graph_resolution_reference
    : (GRAPH | PROPERTY GRAPH) catalog_graph_reference         // 17.2
    ;

catalog_graph_reference
    : catalog_graph_parent_and_name
    ;

catalog_graph_parent_and_name
    : graph_name             // 17.2
    ;

query_conjunction
    : set_operator
    | OTHERWISE                                                    // 15.3
    ;

// TODO: finish
simple_query_statement
    : simple_data_reading_statement                                  // 12.3
    ;

// TODO: uncomment
simple_data_reading_statement
    : match_statement
    //| call_query_statement                                           // 12.3
    ;


graph_keywords
    : (PROPERTY)? (GRAPH | GRAPHS)                            // 15.6.1
    ;

match_statement
    : (statement_mode)? MATCH graph_pattern
    ;

graph_pattern
    : path_pattern_list
    ;

path_pattern_list
    : path_pattern (COMMA path_pattern)*
    ;

path_pattern
    : path_pattern_expression
    ;

path_pattern_expression
    : path_term
    ;

path_term
    : path_factor
    | path_term path_factor
    ;

path_factor
    : path_primary
    ;

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

element_pattern_filler
    : (element_variable_declaration)? (is_label_expression)?                                 // 16.8
    ;

element_variable_declaration
    : element_variable                                               // 16.8
    ;

is_label_expression
    : is_or_colon label_expression                                   // 16.8
    ;

is_or_colon
    : IS
    | COLON                                                          // 16.8
    ;

set_operator
    : UNION ( set_operator_quantifier)?
    | EXCEPT ( set_operator_quantifier)?
    | INTERSECT ( set_operator_quantifier)?                         // 15.3
    ;

// TODO: uncomment
set_operator_quantifier
    //: set_quantifier
    : MAX                                                          // 15.3
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

// TODO: implement correctly, this is just simply returning the entire graph
value_expression
    : graph_reference
    ;

statement_mode
    : OPTIONAL
    | MANDATORY                                                   // 12.2
    ;

label
    : label_name                                                     // 16.4
    ;

element_variable
    : identifier                                                             // 21.3
    ;

label_name
    : identifier
    ;

graph_name
    : identifier
    ;

identifier
    : actual_identifier                                              // 21.3
    ;

actual_identifier
    : regular_identifier                                           // 21.3
    ;

regular_identifier
    : ID                                     # RegularIdentifier
    ;