package gql.returns;

import gql.expressions.unnecessary.Expression;

public class ReturnExpr extends ReturnItem {
    Expression expr;
    String name;

    public ReturnExpr(Expression expr,
                      String name) {
        this.expr = expr;
        this.name = name;
    }

    @Override
    public String toString() {
        return expr.toString() + " AS " + name;
    }
}
