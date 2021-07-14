package gql.expressions.filters;

import exceptions.SemanticErrorException;
import gql.expressions.Expression;
import gql.expressions.references.PropertyReference;
import gql.expressions.values.TruthValue;
import gql.expressions.values.Value;
import gql.tables.Record;

public abstract class ComparisonExpression extends Expression {
    public abstract TruthValue evaluateOn(Record record);

    protected TruthValue getTruthValueFromExpression(Expression expression, Record record) {
        if (isTruthValue(expression)) return (TruthValue) expression;
        if (isComparisonExpression(expression)) return ((ComparisonExpression) expression).evaluateOn(record);

        if (isPropertyReference(expression)) {
            Value expressionValue = ((PropertyReference) expression).getValueFrom(record);
            if (!isTruthValue(expressionValue)) throw new SemanticErrorException("Property reference " + expression.toString() + " does not refer to a boolean value.");
            return (TruthValue) expressionValue;
        }

        throw new SemanticErrorException("Expression " + expression.toString() + " cannot be evaluated to a boolean value.");
    }
}
