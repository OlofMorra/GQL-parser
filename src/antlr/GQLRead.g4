/* Grammar for GQL */
grammar GQLRead; // The grammar name and grammar filename must match

@header{
    package antlr;
}

import GQLtoken;

/* Start Variable */
prog
    : EOF                                                           # Program
    ;

nested_query_specification
    : LEFT_BRACE query_specification RIGHT_BRACE                    # NestedQuerySpecification // 9.2
    ;

query_specification
    : procedure_body                                                # QuerySpecification // 9.2
    ;

procedure_body
    : (definition_block)? statement_block                           # ProcedureBody // 9.4
    ;

definition_block
    : (static_variable_definition)+ (binding_variable_definition)+  # DefinitionBlock // 9.4
    ;

statement_block
    : statement ('THEN' statement)*                                 # StatementBlock // 9.4
    ;

// TODO: implement
static_variable_definition
    :                                                               # StaticVariableDefinition // 10.1
    ;

as_or_equals
    : 'AS' | EQ                                                     # AsOrEquals // 10.1
    ;

// TODO: uncomment
binding_variable_definition
    : graph_variable_definition
//    | binding_table_variable_definition
//    | value_variable_definition                                     # BindingVariableDefinition // 10.8
    ;

graph_variable_definition
    : ('PROPERTY')? 'GRAPH' graph_variable of_graph_type graph_initializer      # GraphVariableDefinition // 10.9
    ;

graph_variable
    : binding_variable_name                                         # GraphVariable // 10.9
    ;

// TODO: finish
graph_initializer
    : as_or_equals graph_expression                                 # GraphInitializer // 10.9
    ;

// TODO: uncomment
graph_expression
    : copy_graph_expression
    | graph_specification
//    | graph_reference                                               # GraphExpression // 11.3
    ;

copy_graph_expression
    : 'COPY OF' graph_expression                                    # CopyGraphExpression // 11.3
    ;

// TODO: finish
of_graph_type
    : like_graph_expression_shorthand                               # OfGraphType // 11.4
    ;

like_graph_expression_shorthand
    : 'LIKE' graph_expression                                       # LikeGraphExpressionShorthand
    ;

statement
    : (at_schema_clause)?
    ( catalog_modifying_statement
    | data_modifying_statement
    | query_statement )                                             # Statement // 12.1
    ;

// TODO: uncomment
catalog_modifying_statement
    //: linear_catalog_modifying_statement                            # CatalogModifyingStatement // 12.1
    :
    ;

// TODO: uncomment
data_modifying_statement
//    : conditional_data_modifying_statement
//    | linear_data_modifying_statement                               # DataModifyingStatement // 12.1
    :
    ;

query_statement
    : composite_query_statement
    | conditional_query_statement
    | select_statement                                              # QueryStatement // 12.1
    ;

statement_mode
    : 'OPTIONAL'
    | 'MANDATORY'                                                   # StatementMode // 12.2
    ;

// TODO: finish
simple_query_statement
    : simple_data_reading_statement                                 # SimpleQueryStatement // 12.3
    ;

// TODO: uncomment
simple_data_reading_statement
    : match_graph_statement
    | match_statement
    //| call_query_statement                                          # SimpleDataReadingStatement // 12.3
    ;

// TODO: finish
graph_specification
    : ('OPTIONAL')? 'GRAPH' nested_graph_query_specification        # GraphSpecification // 13.5
    ;

nested_graph_query_specification
    : nested_query_specification                                    # NestedGraphQuerySpecification // 13.5
    ;

when_clause
    : 'WHEN' search_condition                                       # WhenClause // 14.2
    ;

composite_query_statement
    : composite_query_expression                                    # CompositeQueryStatement // 15.1
    ;

conditional_query_statement
    : (when_then_linear_query_branch)+ (else_linear_query_branch)*  # ConditionalQueryStatement // 15.2
    ;

when_then_linear_query_branch
    : when_clause 'THEN' linear_query_expression
    | when_clause nested_query_specification                        # WhenThenLinearQueryBranch // 15.2
    ;

else_linear_query_branch
    : 'ELSE' linear_query_expression                                # ElseLinearQueryBranch // 15.2
    ;

composite_query_expression
    : composite_query_expression query_conjunction linear_query_expression
    | linear_query_expression                                       # CompositeQueryExpression // 15.3
    ;

query_conjunction
    : set_operator
    | 'OTHERWISE'                                                   # QueryConjunction // 15.3
    ;

set_operator
    : 'UNION' (set_operator_quantifier)?
    | 'EXCEPT' (set_operator_quantifier)?
    | 'INTERSECT' (set_operator_quantifier)?                        # SetOperator // 15.3
    ;

// TODO: uncomment
set_operator_quantifier
    //: set_quantifier
    : 'MAX'                                                         # SetOperatorQuantifier // 15.3
    ;

linear_query_expression
    : linear_query_statement                                        # LinearQueryExpression // 15.4
    ;

linear_query_statement
    : focused_linear_query_statement                                # LinearQueryStatement // 15.5
    //| ambient_linear_query_statement  TODO: implement
    ;

focused_linear_query_statement
    : from_graph_clause focused_linear_query_statement_body         # FocusedLinearQueryStatement // 15.5
    ;

focused_linear_query_statement_body
    : simple_linear_query_statement
      (from_graph_clause simple_linear_query_statement)*
      primitive_result_statement
    | nested_query_specification                                    # FocusedLinearQueryStatementBody // 15.5
    ;

simple_linear_query_statement
    : (simple_query_statement)*                                     # SimpleLinearQueryStatement // 15.5
    ;

match_graph_statement
    : (statement_mode)? 'MATCH' graph_keywords graph_object_pattern # MatchGraphStatement // 15.6.1
    ;

match_statement
    : (statement_mode)? 'MATCH' graph_pattern                      # MatchStatement // 15.6.2
    ;

primitive_result_statement
    : return_statement
    | project_statement
    | 'END'                                                         # PrimitiveResultStatement // 15.8.1
    ;

return_statement
    : 'RETURN' return_statement_body                                # ReturnStatement // 15.8.2
    ;

// TODO: finish
return_statement_body
    : (ASTERISK | return_item_list)                                 # ReturnStatementBody // 15.8.2
    ;

return_item_list
    : return_item (COMMA return_item)*                              # ReturnItemList // 15.8.2
    ;

return_item
    : value_expression (return_item_alias)?                         # ReturnItem // 15.8.2
    ;

return_item_alias
    : 'AS' identifier                                               # ReturnItemAlias // 15.8.2
    ;

// TODO: finish
select_statement
    : 'SELECT' select_item_list select_statement_body               # SelectStatement // 15.8.3
    ;

select_item_list
    : select_item (COMMA select_item)*                                    # SelectItemList // 15.8.3
    ;

select_item
    : value_expression (select_item_alias)                          # SelectItemAlias // 15.8.3
    ;

select_item_alias
    : 'AS' identifier                                               # SelectItemAlias // 15.8.3
    ;

select_statement_body
    : (select_graph_matches)+
    | select_query_specification                                    # SelectStatementBody // 15.8.3
    ;

select_graph_matches
    : from_graph_clause match_statement+                            # SelectGraphMatches // 15.8.3
    ;

select_query_specification
    : 'FROM' nested_query_specification
    | from_graph_clause nested_query_specification                  # SelectQuerySpecification // 15.8.3
    ;

project_statement
    : 'PROJECT' value_expression                                    # ProjectStatement // 15.8.4
    ;

from_graph_clause
    : 'FROM' graph_expression                                       # FromGraphClause // 16.1
    ;

at_schema_clause
    : 'AT' schema_reference                                         # AtSchemaClause // 16.3
    ;

static_variable
    : static_variable_name                                          # StaticVariable // 16.4
    ;

binding_variable
    : binding_variable_name                                         # BindingVariable // 16.4
    ;

label
    : label_name                                                    # Label // 16.4
    ;

// TODO: finish
graph_object_pattern
    : graph_object_pattern_variable_list                            # GraphObjectPattern // 16.6
    ;

graph_object_pattern_variable_list
    : graph_object_pattern_variable (COMMA graph_object_pattern_variable)*      # GraphObjectPatternVariableList // 16.6
    ;

// TODO: finish
graph_object_pattern_variable
    : graph_variable                                                # GraphObjectPatternVariable // 16.6
    ;

// TODO: finish
graph_pattern
    : path_pattern_list                                             # GraphPattern // 16.7
    ;

path_pattern_list
    : path_pattern (COMMA path_pattern)*                            # PathPatternList // 16.7
    ;

path_pattern
    : (path_variable EQ)? (path_pattern_prefix)? path_pattern_expression        # PathPattern // 16.7
    ;

// TODO: finish
path_pattern_expression
    : path_term                                                     # PathPatternExpression // 16.8
    ;

path_term
    : path_factor
    | path_concatenation                                            # PathTerm // 16.8
    ;

path_concatenation
    : path_term path_factor                                         # PathConcatenation // 16.8
    ;

// TODO: uncomment
path_factor
    : path_primary
//    | quantified_path_primary
    | questioned_path_primary                                       # PathFactor // 16.8
    ;

questioned_path_primary
    : path_primary QUESTION_MARK                                    # QuestionedPathPrimary // 16.8
    ;

// TODO: uncomment
//quantified_path_primary
//    : path_primary graph_pattern_quantifier                         # QuantifiedPathPrimary // 16.8
//    ;

// TODO: finish
path_primary
    : element_pattern                                               # PathPrimary // 16.8
    ;

element_pattern
    : node_pattern
    | edge_pattern                                                  # EdgePattern // 16.8
    ;

node_pattern
    : LEFT_PAREN element_pattern_filler RIGHT_PAREN                 # NodePattern // 16.8
    ;

element_pattern_filler
    : (element_variable_declaration)?
      (is_label_expression)?
      (element_pattern_where_clause)?
      (element_pattern_cost_clause)?                                # ElementPatternFiller // 16.8
     ;

element_variable_declaration
    : element_variable                                              # ElementVariableDeclaration // 16.8
    ;

is_label_expression
    : is_or_colon label_expression                                  # IsLabelExpression // 16.8
    ;

is_or_colon
    : 'IS'
    | COLON                                                         # IsOrColon // 16.8
    ;

element_pattern_where_clause
    : 'WHERE' search_condition                                      # ElementPatternWhereClause // 16.8
    ;

element_pattern_cost_clause
    : cost_clause                                                   # ElementPatternCostClause // 16.8
    ;

cost_clause
    : 'COST' value_expression ('DEFAULT' value_expression)?         # CostClause // 16.8
    ;

edge_pattern
    : full_edge_pattern
    | abbreviated_edge_pattern                                      # EdgePattern // 16.8
    ;

label_expression
    : label_term
    | label_disjunction                                             # LabelExpression // 16.11
    ;

label_disjunction
    : label_expression VERTICAL_BAR label_term                      # LabelDisjunction // 16.11
    ;

label_term
    : label_factor
    | label_conjunction                                             # LabelTerm // 16.11
    ;

label_conjunction
    : label_term AMPERSAND label_factor                             # LabelConjunction // 16.11
    ;

label_factor
    : label_primary
    | label_negation                                                # LabelFactor // 16.11
    ;

label_negation
    : EXCLAMATION_MARK label_primary                                # LabelNegation // 16.11
    ;

label_primary
    : label
    | wildcard_label
    | parenthesized_label_expression                                # LabelPrimary
    ;

wildcard_label
    : PERCENT                                                       # WildcardLabel // 16.11
    ;

parenthesized_label_expression
    : LEFT_PAREN label_expression RIGHT_PAREN
    | LEFT_BRACKET label_expression RIGHT_BRACKET                   # ParenthesizedLabelExpression // 16.11
    ;

schema_reference
    : schema_resolution_expression
    | local_schema_reference                                        # SchemaReference // 17.1
    ;

schema_resolution_expression
    : 'SCHEMA' catalog_schema_reference                             # SchemaResolutionExpression // 17.1
    ;

// TODO: uncomment
catalog_schema_reference
    : catalog_schema_parent_and_name
    //| predefined_schema_parameter
    //| external_object_reference                                     # CatalogSchemaReference // 17.1
    ;

// TODO: uncomment
catalog_schema_parent_and_name
    : schema_parent_specification catalog_schema_parent_and_name
    //| url_path_parameter                                            # CatalogSchemaParentAndName // 17.1
    ;

// TODO: uncomment
schema_parent_specification
    //: (parent_catalog_object_reference)+                            # SchemaParentSpecification // 17.1
    :
    ;

local_schema_reference
    : schema_name                                                   # LocalSchemaReference // 17.1
    ;

search_condition
    : boolean_value_expression                                      # SearchCondition // 19.1
    ;

// TODO: finish
predicate
    : comparison_predicate
    | null_predicate                                                # Predicate // 19.2
    ;

comparison_predicate
    : non_parenthesized_value_expression_primary comp_op non_parenthesized_value_expression_primary     # ComparisonPredicate // 19.3
    ;

comp_op
    : EQ | NEQ | LT | GT | LEQ | GEQ                                # ComparisonOperator // 19.3
    ;

null_predicate
    : 'IS' WS 'NULL'                                                # NullPredicate // 19.7
    ;

// TODO: implement correctly
value_expression
    : (Digit | SimpleLatinLetter)+                                  # ValueExpression // 20.2
    ;

// TODO: implement corrrectly
boolean_value_expression
    : boolean_term                                                  # BooleanValueExprression // 20.3
    ;

boolean_term
    : boolean_factor
    | boolean_term 'AND' boolean_factor                             # BooleanTerm // 20.3
    ;

boolean_factor
    : ('NOT')? boolean_test                                         # BooleanFactor // 20.3
    ;

boolean_test
    : boolean_primary
      ('IS' ('NOT')?
    | EQ
    | NEQ )? truth_value                                            # BooleanTest // 20.3
    ;

truth_value
    : 'TRUE'
    | 'FALSE'
    | 'UNKNOWN'
    | 'NULL'                                                        # TruthValue // 20.3
    ;

boolean_primary
    : predicate
    | boolean_predicand                                             # BooleanPrimary // 20.3
    ;

// TODO: finish
boolean_predicand
    : parenthesized_boolean_value_expression                        # BooleanPredicand // 20.3
    ;

parenthesized_boolean_value_expression
    : LEFT_PAREN boolean_value_expression RIGHT_PAREN               # ParenthesizedBooleanValueExpression // 20.3
    ;

// TODO: finish
non_parenthesized_value_expression_primary
    : binding_variable                                              # NonParenthesizedValueExpressionPrimary // 20.5
    ;

schema_name
    : identifier                                                    # SchemaName // 21.3
    ;

label_name
    : identifier
    ;

element_variable
    : identifier                                                    # ElementVariable // 21.3
    ;

path_variable
    : identifier                                                    # PathVariable // 21.3
    ;

static_variable_name
    : identifier                                                    # StaticVariableName // 21.3
    ;

binding_variable_name
    : identifier                                                    # BindingVariableName // 21.3
    ;

identifier
    : actual_identifier                                             # Identifier // 21.3
    ;

actual_identifier
    : regular_identifier
    | delimited_identifier                                          # ActualIdentifier // 21.3
    ;



/* Tokens */
// Examples
ID          : [a-z][a-zA-Z0-9_]*;
NUM         : '0' | '-'?[1-9][0-9]*;
INT_TYPE    : 'INT';
COMMENT     : '--' ~[\r\n]* -> skip;

// Necessary
