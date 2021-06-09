package gql.tables;

import gql.expressions.GqlString;
import gql.expressions.FixedPointNumber;
import gql.expressions.TruthValue;
import gql.expressions.Value;
import org.junit.Test;

import static org.junit.Assert.*;

public class BindingTableConjuctorTest {

    @Test
    public void testUnionDistinctWithSameRecord() {
        testWithSameRecord("uniondistinct", 5, 2, 1);
    }

    @Test
    public void testUnionAllWithSameRecord() {
        testWithSameRecord("unionall", 5, 2, 7);
    }

    @Test
    public void testUnionMaxWithSameRecord() {
        testWithSameRecord("unionmax", 5,2,5);
    }

    @Test
    public void testUnionDistinctWithDifferentRecords() {
        testUnionWithDifferentRecords("distinct");
    }

    @Test
    public void testUnionAllWithDifferentRecords() {
        testUnionWithDifferentRecords("all");
    }

    @Test
    public void testUnionMaxWithDifferentRecords() {
        testUnionWithDifferentRecords("max");
    }

    @Test
    public void testExceptDistinctWithSameRecord() {
        testWithSameRecord("exceptdistinct", 4, 2, 0);
    }

    @Test
    public void testExceptAllWithSameRecord() {
        testWithSameRecord("exceptall", 4, 2, 1);
    }

    @Test
    public void testExceptDistinctWithDifferentRecords() {
        testExceptWithDifferentRecords("distinct");
    }

    @Test
    public void testExceptAllWithDifferentRecords() {
        testExceptWithDifferentRecords("all");
    }

    @Test
    public void testIntersectDistinctWithSameRecord() {
        testWithSameRecord("intersectdistinct", 5,2, 1);
    }

    @Test
    public void testIntersectAllWithSameRecord() {
        testWithSameRecord("intersectall", 5, 3, 2);
    }

    @Test
    public void testIntersectDistinctWithDifferentRecords() {
        testIntersectWithDifferentRecords("distinct");
    }

    @Test
    public void testIntersectAllWithDifferentRecords() {
        testIntersectWithDifferentRecords("all");
    }

    @Test
    public void testOtherwiseWithRecordsInFirstBindingTable() {
        testWithSameRecord("otherwise", 3, 2, 3);
    }

    @Test
    public void testOtherwiseWithoutRecordsInFirstBindingTable() {
        testWithSameRecord("otherwise", 0, 2, 2);
    }

    @Test
    public void testOtherwiseWithoutRecords() {
        testWithSameRecord("otherwise", 0, 0, 0);
    }

    @Test
    public void testDifferentSetsOfColumnNames() {
        String[] columnNamesLeft = new String[]{"testLeft"};

        String[] columnNamesRight = new String[]{"testRight"};

        BindingTableConjuctor bindingTableConjuctor = new BindingTableConjuctor();
        assertFalse(bindingTableConjuctor.haveEqualColumnNames(columnNamesLeft, columnNamesRight));
    }


    private void testWithSameRecord(String conjunctionType, int leftNumberOfRecords, int rightNumberOfRecords, int expectedNumberOfRecords) {
        BindingTable left = getBindingTableWithSameRecords(leftNumberOfRecords);
        BindingTable right = getBindingTableWithSameRecords(rightNumberOfRecords);
        BindingTable expectedResult = getBindingTableWithSameRecords(expectedNumberOfRecords);

        BindingTable actualResult = getConjunction(conjunctionType, left, right);

        assertEquals(expectedResult, actualResult);
    }

    private void testUnionWithDifferentRecords(String setOperator) {
        BindingTable left = getBindingTableWithDifferentRecords(2,2,1);
        BindingTable right = getBindingTableWithDifferentRecords(1,0,2);
        BindingTable expectedResult;

        switch (setOperator) {
            case "all":
                expectedResult = getBindingTableWithDifferentRecords(3,2,3);
                break;
            case "distinct":
                expectedResult = getBindingTableWithDifferentRecords(1,1,1);
                break;
            case "max":
                expectedResult = getBindingTableWithDifferentRecords(2,2,2);
                break;
            default:
                throw new IllegalArgumentException("Type was not one of all, distinct or max");
        }

        BindingTable actualResult = getConjunction("union" + setOperator, left, right);

        assertEquals(expectedResult, actualResult);
    }

    private void testExceptWithDifferentRecords(String setOperator) {
        BindingTable left = getBindingTableWithDifferentRecords(2,2,1);
        BindingTable right = getBindingTableWithDifferentRecords(1,0,2);
        BindingTable expectedResult;

        switch (setOperator) {
            case "all":
                expectedResult = getBindingTableWithDifferentRecords(1,2,0);
                break;
            case "distinct":
                expectedResult = getBindingTableWithDifferentRecords(0,1,0);
                break;
            default:
                throw new IllegalArgumentException("Type was not one of all or distinct");
        }

        BindingTable actualResult = getConjunction("except" + setOperator, left, right);

        assertEquals(expectedResult, actualResult);
    }

    private void testIntersectWithDifferentRecords(String setOperator) {
        BindingTable left = getBindingTableWithDifferentRecords(3,2,1);
        BindingTable right = getBindingTableWithDifferentRecords(2,0,2);
        BindingTable expectedResult;

        switch (setOperator) {
            case "all":
                expectedResult = getBindingTableWithDifferentRecords(2,0,1);
                break;
            case "distinct":
                expectedResult = getBindingTableWithDifferentRecords(1,0,1);
                break;
            default:
                throw new IllegalArgumentException("Type was not one of all or distinct");
        }

        BindingTable actualResult = getConjunction("intersect" + setOperator, left, right);

        assertEquals(expectedResult, actualResult);
    }

    private BindingTable getConjunction(String conjunctionType, BindingTable left, BindingTable right) {
        BindingTableConjuctor bindingTableConjuctor = new BindingTableConjuctor();
        BindingTable actualResult;

        switch (conjunctionType) {
            case "unionall":
                actualResult = bindingTableConjuctor.unionAll(left, right);
                break;
            case "uniondistinct":
                actualResult = bindingTableConjuctor.unionDistinct(left, right);
                break;
            case "unionmax":
                actualResult = bindingTableConjuctor.unionMax(left, right);
                break;
            case "exceptall":
                actualResult = bindingTableConjuctor.exceptAll(left, right);
                break;
            case "exceptdistinct":
                actualResult = bindingTableConjuctor.exceptDistinct(left, right);
                break;
            case "intersectall":
                actualResult = bindingTableConjuctor.intersectAll(left, right);
                break;
            case "intersectdistinct":
                actualResult = bindingTableConjuctor.intersectDistinct(left, right);
                break;
            case "otherwise":
                actualResult = bindingTableConjuctor.otherwise(left, right);
                break;
            default:
                throw new IllegalStateException("Type was not one of unionall, uniondistinct, unionmax, " +
                        "intersectall, intersectdistinct or otherwise");
        }

        return actualResult;
    }

    private BindingTable getBindingTableWithSameRecords(int numberOfRecords) {
        if (numberOfRecords < 0) {
            throw new IllegalArgumentException("Number of records should be 0 or higher.");
        }

        return getBindingTableWithDifferentRecords(numberOfRecords, 0, 0);
    }

    private BindingTable getBindingTableWithDifferentRecords(int numberOfFirstRecord, int numberOfSecondRecord, int numberOfThirdRecord) {
        if (numberOfFirstRecord < 0 || numberOfSecondRecord < 0 || numberOfThirdRecord < 0) {
            throw new IllegalArgumentException("Number of records should be 0 or higher.");
        }

        String[] columnNames = new String[]{"firstColumn"};
        BindingTable bindingTable = new BindingTable(false, false, columnNames);

        addRecordsToBindingTable(bindingTable, columnNames, numberOfSecondRecord, numberOfThirdRecord, numberOfFirstRecord);

        return bindingTable;
    }

    private void addRecordsToBindingTable(BindingTable bindingTable, String[] columnNames, int numberOfSecondRecord, int numberOfThirdRecord, int numberOfFirstRecord) {
        Value[] firstValues = new Value[]{new GqlString("test value")};
        Record firstRecord = new Record(columnNames, firstValues);

        Value[] secondValues = new Value[]{new TruthValue(true)};
        Record secondRecord = new Record(columnNames, secondValues);

        Value[] thirdValues = new Value[]{new FixedPointNumber("1")};
        Record thirdRecord = new Record(columnNames, thirdValues);

        bindingTable.addRecordMultipleTimes(firstRecord, numberOfFirstRecord);
        bindingTable.addRecordMultipleTimes(secondRecord, numberOfSecondRecord);
        bindingTable.addRecordMultipleTimes(thirdRecord, numberOfThirdRecord);
    }
}