package gql.tables;

import exceptions.InvalidEdgeFormatException;
import exceptions.InvalidNodeFormatException;
import gql.enums.BooleanComparator;
import gql.enums.EvaluationMode;
import gql.enums.ValueComparator;
import gql.expressions.filters.BooleanExpressionComparison;
import gql.expressions.filters.ValueComparison;
import gql.expressions.references.PropertyReference;
import gql.expressions.values.*;
import gql.graphs.WorkingGraph;
import gql.patterns.*;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class BindingTableTest {
    private BindingTable bindingTable;
    private Record record;
    private Record secondRecord;

    TruthValue TRUE = new TruthValue(true);
    TruthValue FALSE = new TruthValue(false);
    TruthValue UNKNOWN = new TruthValue(null);

    @Before
    public void setUp() {
        String[] columnNames = new String[]{"col1", "col2", "col3"};
        bindingTable = new BindingTable(false, false, columnNames);

        Value[] values = new Value[]{new GqlString("Tries"), new FixedPointNumber("1"), new TruthValue(true)};
        record = new Record(columnNames, values);
        values = new Value[]{new FloatingPointNumber("3E3"), new FixedPointNumber("1"), new TruthValue(false)};
        secondRecord = new Record(columnNames, values);
    }

    @Test
    public void testFilterWithTrue() {
        bindingTable.addRecord(record);
        bindingTable.addRecord(secondRecord);
        bindingTable.filter(TRUE);

        assertTrue(bindingTable.getRecords().contains(record));
        assertTrue(bindingTable.getRecords().contains(secondRecord));
        assertEquals(2, bindingTable.getRecords().size());
    }

    @Test
    public void testFilterWithFalse() {
        bindingTable.addRecord(record);
        bindingTable.filter(FALSE);

        assertFalse(bindingTable.getRecords().contains(record));
        assertEquals(0, bindingTable.getRecords().size());
    }

    @Test
    public void testFilterWithUnknown() {
        bindingTable.addRecord(record);
        bindingTable.filter(UNKNOWN);

        assertFalse(bindingTable.getRecords().contains(record));
        assertEquals(0, bindingTable.getRecords().size());
    }

    @Test
    public void testFilterWithSimpleComparisonExpression() {
        bindingTable.addRecord(record);
        bindingTable.addRecord(secondRecord);
        BooleanExpressionComparison expression = new BooleanExpressionComparison(TRUE, BooleanComparator.OR, FALSE);
        bindingTable.filter(expression);

        assertTrue(bindingTable.getRecords().contains(record));
        assertTrue(bindingTable.getRecords().contains(secondRecord));
        assertEquals(2, bindingTable.getRecords().size());
    }

    @Test
    public void testFilterWithComparisonExpression() {
        setWorkingGraphToSyntheticGraph();

        BindingTable expectedResult = new BindingTable(false, true, new String[]{"x"});
        expectedResult.addRecord(new Record(new String[]{"x"}, new Value[]{new GqlIdentifier("n1")}));
        expectedResult.addRecord(new Record(new String[]{"x"}, new Value[]{new GqlIdentifier("n2")}));
        expectedResult.addRecord(new Record(new String[]{"x"}, new Value[]{new GqlIdentifier("n3")}));

        NodePattern node = new NodePattern(new VariableName("x"), null, null);
        ArrayList<ElementPattern> sequence = new ArrayList<>();
        sequence.add(node);
        PathSequence pathSequence = new PathSequence(sequence);
        PathPattern path = new PathPattern(null, pathSequence);
        BindingTable table = path.match(EvaluationMode.WALK);

        BooleanExpressionComparison comparison = new BooleanExpressionComparison(TRUE, BooleanComparator.IS_NOT, FALSE);
        table.filter(comparison);
        bindingTablesAreEqual(expectedResult, table);
    }

    @Test
    public void testFilterWithPropertyReference() {
        setWorkingGraphToSyntheticGraph();

        BindingTable expectedResult = new BindingTable(false, true, new String[]{"x"});
        expectedResult.addRecord(new Record(new String[]{"x"}, new Value[]{new GqlIdentifier("n2")}));

        NodePattern node = new NodePattern(new VariableName("x"), null, null);
        ArrayList<ElementPattern> sequence = new ArrayList<>();
        sequence.add(node);
        PathSequence pathSequence = new PathSequence(sequence);
        PathPattern path = new PathPattern(null, pathSequence);
        BindingTable table = path.match(EvaluationMode.WALK);

        PropertyReference reference = new PropertyReference("x", "name");
        ValueComparison valueComparison = new ValueComparison(reference, ValueComparator.EQ, new GqlString("Olof Morra"));
        table.filter(valueComparison);
        bindingTablesAreEqual(expectedResult, table);
    }

    @Test
    public void testAddRecord() {
        bindingTable.addRecord(record);

        assertTrue(bindingTable.getRecords().contains(record));
        assertEquals(1, bindingTable.getRecords().size());
    }

    @Test
    public void testAddRecordMultipleTimes() {
        bindingTable.addRecordMultipleTimes(record, 2);

        assertTrue(bindingTable.getRecords().contains(record));
        assertEquals(2, bindingTable.getRecords().size());
        bindingTable.getRecords().remove(record);
        assertTrue(bindingTable.getRecords().contains(record));
        assertEquals(1, bindingTable.getRecords().size());
    }

    @Test
    public void testAddRecords() {
        ArrayList<Record> records = new ArrayList<>();
        records.add(record);
        records.add(record);
        bindingTable.addRecords(records);

        assertTrue(bindingTable.getRecords().contains(record));
        assertEquals(2, bindingTable.getRecords().size());
        bindingTable.getRecords().remove(record);
        assertTrue(bindingTable.getRecords().contains(record));
        assertEquals(1, bindingTable.getRecords().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRecordWithMoreColumnsThenTable() {
        String[] columnNames = new String[]{"col1", "col2"};
        bindingTable = new BindingTable(false, false, columnNames);

        bindingTable.addRecord(record);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRecordWithLessColumnsThenTable() {
        String[] columnNames = new String[]{"col1"};
        Value[] values = new Value[]{new GqlString("Tries")};
        record = new Record(columnNames, values);

        bindingTable.addRecord(record);
    }

    @Test
    public void testPrintToConsole() {
        bindingTable.addRecordMultipleTimes(record,5);

        bindingTable.printToConsole();
    }

    private void setWorkingGraphToSyntheticGraph() {
        try {
            WorkingGraph.getInstance().setToTestDirectory();
            WorkingGraph.getInstance().setLocalGraph("syntheticGraph");
        } catch (FileNotFoundException | InvalidNodeFormatException | InvalidEdgeFormatException exception) {
            exception.printStackTrace();
        }
    }

    private void bindingTablesAreEqual(BindingTable expectedResult, BindingTable actualResult) {
        System.out.println("Expected:");
        expectedResult.printToConsole();
        System.out.println("Actual:");
        actualResult.printToConsole();

        assertEquals(expectedResult, actualResult);
    }
}