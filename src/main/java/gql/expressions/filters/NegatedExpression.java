package gql.expressions.filters;

import exceptions.SemanticErrorException;
import gql.expressions.Expression;
import gql.expressions.values.TruthValue;
import gql.tables.Record;

public class NegatedExpression extends ComparisonExpression {
    Expression expression;

    public NegatedExpression(Expression expression) {
        if (isNotBooleanExpression(expression)) throw new SemanticErrorException("Invalid value type: expression should evaluate to a truth value.");
        if (isNameExpression(expression)) throw new SemanticErrorException("Name expression " + expression.toString() + " can never refer to a boolean value.");

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
