package gql.returns;

import gql.expressions.filters.ComparisonExpression;

public class ReturnExpr extends ReturnItem {
    ComparisonExpression expr;
    String name;

    public ReturnExpr(ComparisonExpression expr,
                      String name) {
        this.expr = expr;
        this.name = name;
    }

    @Override
    public String toString() {
        return expr.toString() + " AS " + name;
    }
}
