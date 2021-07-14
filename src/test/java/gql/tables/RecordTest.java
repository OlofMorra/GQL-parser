package gql.tables;

import exceptions.SemanticErrorException;
import gql.expressions.values.GqlString;
import gql.expressions.values.FixedPointNumber;
import gql.expressions.values.Value;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecordTest {

    @Test(expected = SemanticErrorException.class)
    public void testInvalidInitializationWithLessColumns() {
        Record testRecord = new Record(new String[]{"Test"}, new Value[]{new GqlString("Test"), new FixedPointNumber("1")});
    }

    @Test(expected = SemanticErrorException.class)
    public void testInvalidInitializationWithLessValues() {
        Record testRecord = new Record(new String[]{"Test"}, new Value[]{});
    }

    @Test
    public void testInitializationWithoutColumns() {
        Record testRecord = getEmptyRecord();
    }

    @Test
    public void testGetNrOfCharactersPerValueOnEmptyRecord() {
        Record testRecord = getEmptyRecord();

        assertArrayEquals(new int[]{}, testRecord.getNrOfCharactersPerValue());
    }

    @Test
    public void testGetNrOfCharactersPerValue() {
        Record testRecord = getValidTestRecord();
        assertArrayEquals(new int[]{6,1}, testRecord.getNrOfCharactersPerValue());
    }

    @Test
    public void testIsEqualToWithEqualRecords() {
        Record record1 = getValidTestRecord();
        Record record2 = getValidTestRecord();

        assertEquals("Record 1 is not equal to record 2", record1, record2);
        assertEquals("Record 2 is not equal to record 1", record2, record1);
    }

    @Test
    public void testIsEqualToWithUnequalWidthRecords() {
        Record record1 = getValidTestRecord();
        Record record2 = getEmptyRecord();

        assertNotEquals("Record 1 is not equal to record 2", record1, record2);
        assertNotEquals("Record 2 is not equal to record 1", record2, record1);
    }

    @Test
    public void testIsEqualToWithUnequalColumnsRecords() {
        Record record1 = getValidTestRecord();
        Record record2 = new Record(new String[]{"Test", "This"}, new Value[]{new GqlString("Test"), new FixedPointNumber("1")});

        assertNotEquals("Record 1 is not equal to record 2", record1, record2);
        assertNotEquals("Record 2 is not equal to record 1", record2, record1);
    }

    @Test
    public void testIsEqualToWithUnequalValuesRecords() {
        Record record1 = getValidTestRecord();
        Record record2 = new Record(new String[]{"Test", "this"}, new Value[]{new GqlString("test"), new FixedPointNumber("1")});

        assertNotEquals("Record 1 is not equal to record 2", record1, record2);
        assertNotEquals("Record 2 is not equal to record 1", record2, record1);
    }

    public Record getEmptyRecord() {
        return new Record(new String[]{}, new Value[]{});
    }

    public Record getValidTestRecord() {
        return new Record(new String[]{"Test", "this"}, new Value[]{new GqlString("Test"), new FixedPointNumber("1")});
    }
}