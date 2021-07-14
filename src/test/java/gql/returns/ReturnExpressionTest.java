package gql.returns;

import exceptions.SemanticErrorException;
import gql.enums.BooleanComparator;
import gql.enums.ValueComparator;
import gql.expressions.filters.BooleanExpressionComparison;
import gql.expressions.filters.NegatedExpression;
import gql.expressions.filters.ValueComparison;
import gql.expressions.references.NameExpression;
import gql.expressions.references.PropertyReference;
import gql.expressions.values.FixedPointNumber;
import gql.expressions.values.GqlString;
import gql.expressions.values.TruthValue;
import org.junit.Test;

public class ReturnExpressionTest {

    @Test(expected = SemanticErrorException.class)
    public void testPropertyReferenceWithoutAlias() {
        new ReturnExpression(new PropertyReference("x", "not"));
    }

    @Test(expected = SemanticErrorException.class)
    public void testNegatedExpressionWithoutAlias() {
        new ReturnExpression(new NegatedExpression(new TruthValue(true)));
    }

    @Test(expected = SemanticErrorException.class)
    public void testValueWithoutAlias() {
        new ReturnExpression(new FixedPointNumber("3"));
    }

    @Test(expected = SemanticErrorException.class)
    public void testBooleanExpressionComparisonWithoutAlias() {
        new ReturnExpression(new BooleanExpressionComparison(new TruthValue(true), BooleanComparator.OR, new TruthValue(true)));
    }

    @Test(expected = SemanticErrorException.class)
    public void testValueComparisonWithoutAlias() {
        new ReturnExpression(new ValueComparison(new GqlString("test"), ValueComparator.EQ, new GqlString("test")));
    }

    @Test
    public void testNameExpressionWithoutAlias() {
        new ReturnExpression(new NameExpression("x"));
    }
}