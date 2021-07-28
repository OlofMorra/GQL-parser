package gql.tables;

import gql.expressions.values.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class BindingTableConjuctorTest implements BindingTableComparator {

    @Test
    public void testUnionDistinctWithSameRecord() {
        testWithSameRecord("uniondistinct", 5, 2, 1, false);
    }

    @Test
    public void testUnionAllWithSameRecord() {
        testWithSameRecord("unionall", 5, 2, 7, true);
    }

    @Test
    public void testUnionMaxWithSameRecord() {
        testWithSameRecord("unionmax", 5,2,5, true);
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
        testWithSameRecord("exceptdistinct", 4, 2, 0, false);
    }

    @Test
    public void testExceptAllWithSameRecord() {
        testWithSameRecord("exceptall", 4, 2, 2, true);
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
        testWithSameRecord("intersectdistinct", 5,2, 1, false);
    }

    @Test
    public void testIntersectAllWithSameRecord() {
        testWithSameRecord("intersectall", 5, 3, 3, true);
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
        testWithSameRecord("otherwise", 3, 2, 3, true);
    }

    @Test
    public void testOtherwiseWithoutRecordsInFirstBindingTable() {
        testWithSameRecord("otherwise", 0, 2, 2, true);
    }

    @Test
    public void testOtherwiseWithoutRecords() {
        testWithSameRecord("otherwise", 0, 0, 0, true);
    }

    // Example 2.4 query 1
    @Test
    public void testCrossProductWithEqualColumnNames() {
        String[] columnNames = new String[]{"x", "y", "z"};

        BindingTable left = getAcyclicOutput(columnNames);
        BindingTable right = getTrailOutput(columnNames);

        BindingTable expectedResult = getAcyclicOutput(columnNames);

        BindingTableConjuctor bindingTableConjuctor = new BindingTableConjuctor();
        checkIfBindingTablesAreEqual(expectedResult, bindingTableConjuctor.crossProduct(left, right));
    }

    @Test
    public void testCrossProductWithIntersectingColumnNames() {
        String[] columnNamesLeft = new String[]{"x", "y", "z"};
        String[] columnNamesRight = new String[]{"x", "y", "a"};
        String[] expectedColumnNames = new String[]{"x", "y", "z", "a"};

        BindingTable left = getAcyclicOutput(columnNamesLeft);
        BindingTable right = getTrailOutput(columnNamesRight);

        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(getFourNodeIdentifiersRecord(expectedColumnNames, "n1", "n2", "n3", "n3"));
        expectedResult.addRecord(getFourNodeIdentifiersRecord(expectedColumnNames, "n3", "n2", "n1", "n1"));

        BindingTableConjuctor bindingTableConjuctor = new BindingTableConjuctor();
        checkIfBindingTablesAreEqual(expectedResult, bindingTableConjuctor.crossProduct(left, right));
    }

    // Example 2.4 query 2
    @Test
    public void testCrossProductWithDistinctColumnNames() {
        String[] columnNamesLeft = new String[]{"a", "b", "c"};
        String[] columnNamesRight = new String[]{"x", "y", "z"};
        String[] expectedColumnNames = new String[]{"a", "b", "c", "x", "y", "z"};

        BindingTable left = getAcyclicOutput(columnNamesLeft);
        BindingTable right = getTrailOutput(columnNamesRight);

        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(getSixNodeIdentifiersRecord(expectedColumnNames, "n1", "n2", "n3", "n1", "n2", "n3"));
        expectedResult.addRecord(getSixNodeIdentifiersRecord(expectedColumnNames, "n1", "n2", "n3", "n2", "n3", "n3"));
        expectedResult.addRecord(getSixNodeIdentifiersRecord(expectedColumnNames, "n1", "n2", "n3", "n3", "n2", "n1"));
        expectedResult.addRecord(getSixNodeIdentifiersRecord(expectedColumnNames, "n1", "n2", "n3", "n3", "n3", "n2"));
        expectedResult.addRecord(getSixNodeIdentifiersRecord(expectedColumnNames, "n3", "n2", "n1", "n1", "n2", "n3"));
        expectedResult.addRecord(getSixNodeIdentifiersRecord(expectedColumnNames, "n3", "n2", "n1", "n2", "n3", "n3"));
        expectedResult.addRecord(getSixNodeIdentifiersRecord(expectedColumnNames, "n3", "n2", "n1", "n3", "n2", "n1"));
        expectedResult.addRecord(getSixNodeIdentifiersRecord(expectedColumnNames, "n3", "n2", "n1", "n3", "n3", "n2"));

        BindingTableConjuctor bindingTableConjuctor = new BindingTableConjuctor();
        checkIfBindingTablesAreEqual(expectedResult, bindingTableConjuctor.crossProduct(left, right));
    }

    @Test
    public void testDifferentSetsOfColumnNames() {
        String[] columnNamesLeft = new String[]{"testLeft", "testRight"};
        String[] columnNamesRight = new String[]{"testRight", "testRight"};

        BindingTableConjuctor bindingTableConjuctor = new BindingTableConjuctor();
        assertFalse(bindingTableConjuctor.haveEqualColumnNames(columnNamesLeft, columnNamesRight));
    }

    @Test
    public void testSameSetsOfColumnNames() {
        String[] columnNamesLeft = new String[]{"testLeft", "testRight"};

        String[] columnNamesRight = new String[]{"testRight", "testLeft"};

        BindingTableConjuctor bindingTableConjuctor = new BindingTableConjuctor();
        assertTrue(bindingTableConjuctor.haveEqualColumnNames(columnNamesLeft, columnNamesRight));
    }


    private void testWithSameRecord(String conjunctionType, int leftNumberOfRecords, int rightNumberOfRecords, int expectedNumberOfRecords, boolean hasDuplicates) {
        BindingTable left = getBindingTableWithSameRecords(leftNumberOfRecords, true);
        BindingTable right = getBindingTableWithSameRecords(rightNumberOfRecords, true);
        BindingTable expectedResult = getBindingTableWithSameRecords(expectedNumberOfRecords, hasDuplicates);

        BindingTable actualResult = getConjunction(conjunctionType, left, right);

        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    private void testUnionWithDifferentRecords(String setOperator) {
        BindingTable left = getBindingTableWithDifferentRecords(2,2,1, true);
        BindingTable right = getBindingTableWithDifferentRecords(1,0,2, true);
        BindingTable expectedResult;

        switch (setOperator) {
            case "all":
                expectedResult = getBindingTableWithDifferentRecords(3,2,3, true);
                break;
            case "distinct":
                expectedResult = getBindingTableWithDifferentRecords(1,1,1, false);
                break;
            case "max":
                expectedResult = getBindingTableWithDifferentRecords(2,2,2, true);
                break;
            default:
                throw new IllegalArgumentException("Type was not one of all, distinct or max");
        }

        BindingTable actualResult = getConjunction("union" + setOperator, left, right);

        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    private void testExceptWithDifferentRecords(String setOperator) {
        BindingTable left = getBindingTableWithDifferentRecords(2,2,1, true);
        BindingTable right = getBindingTableWithDifferentRecords(1,0,2, true);
        BindingTable expectedResult;

        switch (setOperator) {
            case "all":
                expectedResult = getBindingTableWithDifferentRecords(1,2,0, true);
                break;
            case "distinct":
                expectedResult = getBindingTableWithDifferentRecords(0,1,0, false);
                break;
            default:
                throw new IllegalArgumentException("Type was not one of all or distinct");
        }

        BindingTable actualResult = getConjunction("except" + setOperator, left, right);

        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    private void testIntersectWithDifferentRecords(String setOperator) {
        BindingTable left = getBindingTableWithDifferentRecords(3,2,1, true);
        BindingTable right = getBindingTableWithDifferentRecords(2,0,2, true);
        BindingTable expectedResult;

        switch (setOperator) {
            case "all":
                expectedResult = getBindingTableWithDifferentRecords(2,0,1, true);
                break;
            case "distinct":
                expectedResult = getBindingTableWithDifferentRecords(1,0,1, false);
                break;
            default:
                throw new IllegalArgumentException("Type was not one of all or distinct");
        }

        BindingTable actualResult = getConjunction("intersect" + setOperator, left, right);

        checkIfBindingTablesAreEqual(expectedResult, actualResult);
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

    private BindingTable getBindingTableWithSameRecords(int numberOfRecords, boolean hasDuplicates) {
        if (numberOfRecords < 0) {
            throw new IllegalArgumentException("Number of records should be 0 or higher.");
        }

        return getBindingTableWithDifferentRecords(numberOfRecords, 0, 0, hasDuplicates);
    }

    private BindingTable getBindingTableWithDifferentRecords(int numberOfFirstRecord, int numberOfSecondRecord, int numberOfThirdRecord, boolean hasDuplicates) {
        if (numberOfFirstRecord < 0 || numberOfSecondRecord < 0 || numberOfThirdRecord < 0) {
            throw new IllegalArgumentException("Number of records should be 0 or higher.");
        }

        String[] columnNames = new String[]{"firstColumn"};
        BindingTable bindingTable = new BindingTable(hasDuplicates, columnNames);

        addRecordsToBindingTable(bindingTable, columnNames, numberOfSecondRecord, numberOfThirdRecord, numberOfFirstRecord);

        return bindingTable;
    }

    // Table 3c in report
    private BindingTable getAcyclicOutput(String[] columnNames) {
        BindingTable output = new BindingTable(true, columnNames);

        output.addRecord(getThreeNodeIdentifiersRecord(columnNames,"n1", "n2", "n3"));
        output.addRecord(getThreeNodeIdentifiersRecord(columnNames,"n3", "n2", "n1"));

        return output;
    }

    // Table 3d in report
    private BindingTable getTrailOutput(String[] columnNames) {
        BindingTable output = new BindingTable(true, columnNames);

        output.addRecord(getThreeNodeIdentifiersRecord(columnNames,"n1", "n2", "n3"));
        output.addRecord(getThreeNodeIdentifiersRecord(columnNames,"n2", "n3", "n3"));
        output.addRecord(getThreeNodeIdentifiersRecord(columnNames,"n3", "n2", "n1"));
        output.addRecord(getThreeNodeIdentifiersRecord(columnNames,"n3", "n3", "n2"));

        return output;
    }

    private Record getThreeNodeIdentifiersRecord(String[] columnNames, String id1, String id2, String id3) {
        return new Record(columnNames, new Value[]{new GqlIdentifier(id1), new GqlIdentifier(id2), new GqlIdentifier(id3)});
    }

    private Record getFourNodeIdentifiersRecord(String[] columnNames, String id1, String id2, String id3, String id4) {
        return new Record(columnNames, new Value[]{new GqlIdentifier(id1), new GqlIdentifier(id2), new GqlIdentifier(id3), new GqlIdentifier(id4)});
    }

    private Record getSixNodeIdentifiersRecord(String[] columnNames, String id1, String id2, String id3, String id4, String id5, String id6) {
        return new Record(columnNames, new Value[]{new GqlIdentifier(id1), new GqlIdentifier(id2), new GqlIdentifier(id3),
                new GqlIdentifier(id4), new GqlIdentifier(id5), new GqlIdentifier(id6)});
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