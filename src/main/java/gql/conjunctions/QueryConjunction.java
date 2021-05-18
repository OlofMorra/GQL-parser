package gql.conjunctions;

import gql.queries.QueryExpression;

public abstract class QueryConjunction extends QueryExpression {
    QueryExpression left;
    QueryExpression right;

    public QueryConjunction(QueryExpression left,
                            QueryExpression right) {
        this.left = left;
        this.right = right;
    }
}
