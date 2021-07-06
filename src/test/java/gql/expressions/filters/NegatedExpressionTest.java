package gql.expressions.filters;

import exceptions.InvalidEdgeFormatException;
import exceptions.InvalidNodeFormatException;
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

public class NegatedExpressionTest {
    TruthValue TRUE = new TruthValue(true);
    TruthValue FALSE = new TruthValue(false);
    TruthValue UNKNOWN = new TruthValue(null);

    @Test
    public void testEvaluate() {
        NegatedExpression notTrue = new NegatedExpression(TRUE);
        NegatedExpression notFalse = new NegatedExpression(FALSE);
        NegatedExpression notUnknown = new NegatedExpression(UNKNOWN);

        assertEquals(FALSE, notTrue.evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(TRUE, notFalse.evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(UNKNOWN, notUnknown.evaluateOn(new Record(new String[]{}, new Value[]{})));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExpressionNotBooleanExpression() {
        new NegatedExpression(new GqlString("test"));
    }

    @Test
    public void testWithPropertyReferenceToTruthValue() {
        try {
            WorkingGraph.getInstance().setToTestDirectory();
            WorkingGraph.getInstance().setLocalGraph("syntheticGraph");
        } catch (FileNotFoundException | InvalidNodeFormatException | InvalidEdgeFormatException exception) {
            exception.printStackTrace();
        }

        Record record = new Record(new String[]{"x"}, new Value[]{new GqlIdentifier("n1")});
        PropertyReference propertyReference = new PropertyReference("x", "true");
        NegatedExpression negatedExpression = new NegatedExpression(propertyReference);
        assertEquals(FALSE, negatedExpression.evaluateOn(record));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithPropertyReferenceToGqlString() {
        try {
            WorkingGraph.getInstance().setToTestDirectory();
            WorkingGraph.getInstance().setLocalGraph("syntheticGraph");
        } catch (FileNotFoundException | InvalidNodeFormatException | InvalidEdgeFormatException exception) {
            exception.printStackTrace();
        }

        Record record = new Record(new String[]{"x"}, new Value[]{new GqlIdentifier("n2")});
        PropertyReference propertyReference = new PropertyReference("x", "name");
        NegatedExpression negatedExpression = new NegatedExpression(propertyReference);
        assertEquals(FALSE, negatedExpression.evaluateOn(record));
    }
}