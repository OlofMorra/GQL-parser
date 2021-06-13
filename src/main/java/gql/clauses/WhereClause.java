package gql.clauses;

import gql.expressions.unnecessary.Expression;

public class WhereClause {
    Expression expr;

    public WhereClause(Expression expr) {
        this.expr = expr;
    }

    @Override
    public String toString() {
        return " WHERE " + expr.toString();
    }
}