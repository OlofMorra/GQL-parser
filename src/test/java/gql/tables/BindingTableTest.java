package gql.tables;

import gql.expressions.FixedPointNumber;
import gql.expressions.TruthValue;
import gql.expressions.Value;
import gql.expressions.GqlString;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BindingTableTest {
    private BindingTable bindingTable;
    private Record record;

    @Before
    public void setUp() {
        String[] columnNames = new String[]{"col1", "col2", "col3"};
        bindingTable = new BindingTable(false, false, columnNames);

        Value[] values = new Value[]{new GqlString("Tries"), new FixedPointNumber("1"), new TruthValue(true)};
        record = new Record(columnNames, values);
    }

    @Test
    public void testAddRecord() {
        bindingTable.addRecord(record);

        assertTrue(bindingTable.records.contains(record));
        assertEquals(1, bindingTable.records.size());
    }

    @Test
    public void testAddRecordMultipleTimes() {
        bindingTable.addRecordMultipleTimes(record, 2);

        assertTrue(bindingTable.records.contains(record));
        assertEquals(2, bindingTable.records.size());
        bindingTable.records.remove(record);
        assertTrue(bindingTable.records.contains(record));
        assertEquals(1, bindingTable.records.size());
    }

    @Test
    public void testAddRecords() {
        bindingTable.addRecords(new Record[]{record, record});

        assertTrue(bindingTable.records.contains(record));
        assertEquals(2, bindingTable.records.size());
        bindingTable.records.remove(record);
        assertTrue(bindingTable.records.contains(record));
        assertEquals(1, bindingTable.records.size());
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
}