package src.java.gql.conjunctions;

import src.java.gql.QueryExpr;

public class Otherwise extends QueryConjunction {
    public Otherwise(QueryExpr left,
                     QueryExpr right) {
        super(left, right);
    }

    @Override
    public String toString() {
        return left.toString() + " OTHERWISE " + right.toString();
    }
}
