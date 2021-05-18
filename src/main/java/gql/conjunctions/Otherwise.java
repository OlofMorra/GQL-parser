package gql.conjunctions;

import gql.queries.QueryExpression;

public class Otherwise extends QueryConjunction {
    public Otherwise(QueryExpression left,
                     QueryExpression right) {
        super(left, right);
    }

    @Override
    public String toString() {
        return left.toString() + " OTHERWISE " + right.toString();
    }
}
