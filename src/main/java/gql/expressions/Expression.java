package gql.expressions;

import gql.expressions.filters.ComparisonExpression;
import gql.expressions.references.NameExpression;
import gql.expressions.references.PropertyReference;
import gql.expressions.values.FixedPointNumber;
import gql.expressions.values.FloatingPointNumber;
import gql.expressions.values.GqlString;
import gql.expressions.values.TruthValue;

public abstract class Expression {
    public abstract String toString();
    public abstract String toLatex();

    protected boolean isNotBooleanExpression(Expression expression) {
        return !isComparisonExpression(expression) && !isTruthValue(expression) && !isPropertyReference(expression);
    }

    protected boolean isComparisonExpression(Expression expression) {
        return expression instanceof ComparisonExpression;
    }

    protected boolean isNameExpression(Expression expression) {
        return expression instanceof NameExpression;
    }

    protected boolean isPropertyReference(Expression expression) {
        return expression instanceof PropertyReference;
    }

    protected boolean isTruthValue(Expression expression) {
        return expression instanceof TruthValue;
    }

    protected boolean isGqlString(Expression expression) {
        return expression instanceof GqlString;
    }

    protected boolean isFixedPointNumber(Expression expression) {
        return expression instanceof FixedPointNumber;
    }

    protected boolean isFloatingPointNumber(Expression expression) {
        return expression instanceof FloatingPointNumber;
    }
}
