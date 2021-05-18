package src.java.gql.returns;

import src.java.gql.expr.Expression;

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
