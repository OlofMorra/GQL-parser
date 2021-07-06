package gql.clauses;

import gql.expressions.filters.ComparisonExpression;

public class WhereClause {
    ComparisonExpression expr;

    public WhereClause(ComparisonExpression expr) {
        this.expr = expr;
    }

    @Override
    public String toString() {
        return " WHERE " + expr.toString();
    }
}
