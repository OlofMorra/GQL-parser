package gql.expressions.filters;

import gql.expressions.Expression;
import gql.expressions.references.PropertyReference;
import gql.expressions.values.TruthValue;
import gql.expressions.values.Value;
import gql.tables.Record;

public class NegatedExpression extends ComparisonExpression {
    Expression expression;

    public NegatedExpression(Expression expression) {
        if (isNotBooleanExpression(expression)) throw new IllegalArgumentException("Invalid value type: expression should evaluate to a truth value.");
        if (isNameExpression(expression)) throw new IllegalArgumentException("Name expression " + expression.toString() + " can never refer to a boolean value.");

        this.expression = expression;
    }

    @Override
    public TruthValue evaluateOn(Record record) {
        expression = getTruthValueFromExpression(expression, record);

        return ((TruthValue) expression).getNegation();
    }

    @Override
    public String toString() {
        return "NOT " + expression.toString();
    }
}
