package gql.expressions.filters;

import exceptions.InvalidEdgeFormatException;
import exceptions.InvalidNodeFormatException;
import gql.enums.BooleanComparator;
import gql.expressions.references.NameExpression;
import gql.expressions.references.PropertyReference;
import gql.expressions.values.GqlIdentifier;
import gql.expressions.values.GqlString;
import gql.expressions.values.TruthValue;
import gql.expressions.values.Value;
import gql.graphs.WorkingGraph;
import gql.tables.Record;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class BooleanExpressionComparisonTest {
    BooleanComparator OR = BooleanComparator.OR;
    BooleanComparator XOR = BooleanComparator.XOR;
    BooleanComparator AND = BooleanComparator.AND;
    BooleanComparator IS = BooleanComparator.IS;
    BooleanComparator IS_NOT = BooleanComparator.IS_NOT;

    TruthValue TRUE = new TruthValue(true);
    TruthValue FALSE = new TruthValue(false);
    TruthValue UNKNOWN = new TruthValue(null);

    @Test
    public void testEvaluateOr() {
        BooleanExpressionComparison trueOrTrue = new BooleanExpressionComparison(TRUE, OR, TRUE);
        BooleanExpressionComparison trueOrFalse = new BooleanExpressionComparison(TRUE, OR, FALSE);
        BooleanExpressionComparison trueOrUnknown = new BooleanExpressionComparison(TRUE, OR, UNKNOWN);
        BooleanExpressionComparison falseOrFalse = new BooleanExpressionComparison(FALSE, OR, FALSE);
        BooleanExpressionComparison falseOrUnknown = new BooleanExpressionComparison(FALSE, OR, UNKNOWN);
        BooleanExpressionComparison unknownOrUnknown = new BooleanExpressionComparison(UNKNOWN, OR, UNKNOWN);

        assertEquals(TRUE, trueOrTrue.evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(TRUE, trueOrFalse.evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(TRUE, trueOrUnknown.evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(FALSE, falseOrFalse.evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(UNKNOWN, falseOrUnknown.evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(UNKNOWN, unknownOrUnknown.evaluateOn(new Record(new String[]{}, new Value[]{})));
    }

    @Test
    public void testEvaluateXor() {
        BooleanExpressionComparison trueXorTrue = new BooleanExpressionComparison(TRUE, XOR, TRUE);
        BooleanExpressionComparison trueXorFalse = new BooleanExpressionComparison(TRUE, XOR, FALSE);
        BooleanExpressionComparison trueXorUnknown = new BooleanExpressionComparison(TRUE, XOR, UNKNOWN);
        BooleanExpressionComparison falseXorFalse = new BooleanExpressionComparison(FALSE, XOR, FALSE);
        BooleanExpressionComparison falseXorUnknown = new BooleanExpressionComparison(FALSE, XOR, UNKNOWN);
        BooleanExpressionComparison unknownXorUnknown = new BooleanExpressionComparison(UNKNOWN, XOR, UNKNOWN);

        assertEquals(FALSE, trueXorTrue.evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(TRUE, trueXorFalse.evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(UNKNOWN, trueXorUnknown.evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(FALSE, falseXorFalse.evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(UNKNOWN, falseXorUnknown.evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(UNKNOWN, unknownXorUnknown.evaluateOn(new Record(new String[]{}, new Value[]{})));
    }

    @Test
    public void testEvaluateAnd() {
        BooleanExpressionComparison trueAndTrue = new BooleanExpressionComparison(TRUE, AND, TRUE);
        BooleanExpressionComparison trueAndFalse = new BooleanExpressionComparison(TRUE, AND, FALSE);
        BooleanExpressionComparison trueAndUnknown = new BooleanExpressionComparison(TRUE, AND, UNKNOWN);
        BooleanExpressionComparison falseAndFalse = new BooleanExpressionComparison(FALSE, AND, FALSE);
        BooleanExpressionComparison falseAndUnknown = new BooleanExpressionComparison(FALSE, AND, UNKNOWN);
        BooleanExpressionComparison unknownAndUnknown = new BooleanExpressionComparison(UNKNOWN, AND, UNKNOWN);

        assertEquals(TRUE, trueAndTrue.evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(FALSE, trueAndFalse.evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(UNKNOWN, trueAndUnknown.evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(FALSE, falseAndFalse.evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(FALSE, falseAndUnknown.evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(UNKNOWN, unknownAndUnknown.evaluateOn(new Record(new String[]{}, new Value[]{})));
    }

    @Test
    public void testEvaluateIs() {
        BooleanExpressionComparison trueIsTrue = new BooleanExpressionComparison(TRUE, IS, TRUE);
        BooleanExpressionComparison trueIsFalse = new BooleanExpressionComparison(TRUE, IS, FALSE);
        BooleanExpressionComparison trueIsUnknown = new BooleanExpressionComparison(TRUE, IS, UNKNOWN);
        BooleanExpressionComparison falseIsFalse = new BooleanExpressionComparison(FALSE, IS, FALSE);
        BooleanExpressionComparison falseIsUnknown = new BooleanExpressionComparison(FALSE, IS, UNKNOWN);
        BooleanExpressionComparison unknownIsUnknown = new BooleanExpressionComparison(UNKNOWN, IS, UNKNOWN);

        assertEquals(TRUE, trueIsTrue.evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(FALSE, trueIsFalse.evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(FALSE, trueIsUnknown.evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(TRUE, falseIsFalse.evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(FALSE, falseIsUnknown.evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(TRUE, unknownIsUnknown.evaluateOn(new Record(new String[]{}, new Value[]{})));
    }

    @Test
    public void testEvaluateIsNot() {
        BooleanExpressionComparison trueIsNotTrue = new BooleanExpressionComparison(TRUE, IS_NOT, TRUE);
        BooleanExpressionComparison trueIsNotFalse = new BooleanExpressionComparison(TRUE, IS_NOT, FALSE);
        BooleanExpressionComparison trueIsNotUnknown = new BooleanExpressionComparison(TRUE, IS_NOT, UNKNOWN);
        BooleanExpressionComparison falseIsNotFalse = new BooleanExpressionComparison(FALSE, IS_NOT, FALSE);
        BooleanExpressionComparison falseIsNotUnknown = new BooleanExpressionComparison(FALSE, IS_NOT, UNKNOWN);
        BooleanExpressionComparison unknownIsNotUnknown = new BooleanExpressionComparison(UNKNOWN, IS_NOT, UNKNOWN);

        assertEquals(FALSE, trueIsNotTrue.evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(TRUE, trueIsNotFalse.evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(TRUE, trueIsNotUnknown.evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(FALSE, falseIsNotFalse.evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(TRUE, falseIsNotUnknown.evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(FALSE, unknownIsNotUnknown.evaluateOn(new Record(new String[]{}, new Value[]{})));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLeftSideNotBooleanExpression() {
        new BooleanExpressionComparison(new GqlString("test"), OR, TRUE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRightSideNotBooleanExpression() {
        new BooleanExpressionComparison(TRUE, OR, new GqlString("test"));
    }

    @Test
    public void testBooleanExpressionComparisonOnLeftSide() {
        BooleanExpressionComparison left = new BooleanExpressionComparison(TRUE, OR, FALSE);
        TruthValue right = TRUE;
        BooleanExpressionComparison full = new BooleanExpressionComparison(left, AND, right);
        assertEquals(TRUE, full.evaluateOn(new Record(new String[]{}, new Value[]{})));
    }

    @Test
    public void testBooleanExpressionComparisonOnRightSide() {
        TruthValue left = FALSE;
        BooleanExpressionComparison right = new BooleanExpressionComparison(TRUE, OR, FALSE);
        BooleanExpressionComparison full = new BooleanExpressionComparison(left, OR, right);
        assertEquals(TRUE, full.evaluateOn(new Record(new String[]{}, new Value[]{})));
    }

    @Test
    public void testWithPropertyReferenceToTruthValue() {
        try {
            WorkingGraph.getInstance().setToTestDirectory();
            WorkingGraph.getInstance().setLocalGraph("syntheticGraph");
        } catch (FileNotFoundException | InvalidNodeFormatException | InvalidEdgeFormatException exception) {
            exception.printStackTrace();
        }

        TruthValue left = FALSE;
        Record record = new Record(new String[]{"x"}, new Value[]{new GqlIdentifier("n1")});
        PropertyReference propertyReference = new PropertyReference("x", "booleanTest");
        BooleanExpressionComparison booleanExpressionComparison = new BooleanExpressionComparison(left, OR, propertyReference);
        assertEquals(TRUE, booleanExpressionComparison.evaluateOn(record));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithPropertyReferenceToNonExistingId() {
        try {
            WorkingGraph.getInstance().setToTestDirectory();
            WorkingGraph.getInstance().setLocalGraph("syntheticGraph");
        } catch (FileNotFoundException | InvalidNodeFormatException | InvalidEdgeFormatException exception) {
            exception.printStackTrace();
        }

        TruthValue left = FALSE;
        Record record = new Record(new String[]{"x"}, new Value[]{new GqlIdentifier("n85")});
        PropertyReference propertyReference = new PropertyReference("x", "true");
        BooleanExpressionComparison booleanExpressionComparison = new BooleanExpressionComparison(left, OR, propertyReference);
        booleanExpressionComparison.evaluateOn(record);
    }

    @Test
    public void testWithPropertyReferenceToNonExistingProperty() {
        try {
            WorkingGraph.getInstance().setToTestDirectory();
            WorkingGraph.getInstance().setLocalGraph("syntheticGraph");
        } catch (FileNotFoundException | InvalidNodeFormatException | InvalidEdgeFormatException exception) {
            exception.printStackTrace();
        }

        TruthValue left = FALSE;
        Record record = new Record(new String[]{"x"}, new Value[]{new GqlIdentifier("n1")});
        PropertyReference propertyReference = new PropertyReference("x", "false");
        BooleanExpressionComparison booleanExpressionComparison = new BooleanExpressionComparison(left, OR, propertyReference);
        assertEquals(UNKNOWN, booleanExpressionComparison.evaluateOn(record));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNameExpressions() {
        try {
            WorkingGraph.getInstance().setToTestDirectory();
            WorkingGraph.getInstance().setLocalGraph("syntheticGraph");
        } catch (FileNotFoundException | InvalidNodeFormatException | InvalidEdgeFormatException exception) {
            exception.printStackTrace();
        }

        Record record = new Record(new String[]{"x", "y"}, new Value[]{new GqlIdentifier("n1"), new GqlIdentifier("n1")});
        NameExpression left = new NameExpression("x");
        NameExpression right = new NameExpression("Y");
        BooleanExpressionComparison booleanExpressionComparison = new BooleanExpressionComparison(left, OR, right);
    }
}