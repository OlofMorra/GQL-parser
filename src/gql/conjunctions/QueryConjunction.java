package gql.conjunctions;

import gql.QueryExpr;

public abstract class QueryConjunction extends QueryExpr {
    QueryExpr left;
    QueryExpr right;

    public QueryConjunction(QueryExpr left,
                            QueryExpr right) {
        this.left = left;
        this.right = right;
    }
}
