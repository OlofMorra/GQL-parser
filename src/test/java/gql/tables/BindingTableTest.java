/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package gql.tables;

import exceptions.InvalidEdgeFormatException;
import exceptions.InvalidNodeFormatException;
import exceptions.SemanticErrorException;
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

public class BindingTableTest implements BindingTableComparator {
    private BindingTable bindingTable;
    private Record record;
    private Record secondRecord;
    private String[] columnNames = new String[]{"col1", "col2", "col3"};


    TruthValue TRUE = new TruthValue(true);
    TruthValue FALSE = new TruthValue(false);
    TruthValue UNKNOWN = new TruthValue(null);

    @Before
    public void setUp() {
        bindingTable = new BindingTable(true, columnNames);

        Value[] values = new Value[]{new GqlString("Tries"), new FixedPointNumber("1"), new TruthValue(true)};
        record = new Record(columnNames, values);
        values = new Value[]{new FloatingPointNumber("3E3"), new FixedPointNumber("1"), new TruthValue(false)};
        secondRecord = new Record(columnNames, values);
    }

    @Test
    public void testIsOptionalWithEmptyTable() {
        BindingTable expectedResult = new BindingTable(true, columnNames);
        expectedResult.addRecord(new Record(columnNames, new Value[]{new TruthValue(null), new TruthValue(null), new TruthValue(null)}));

        bindingTable.isOptional();

        checkIfBindingTablesAreEqual(expectedResult, bindingTable);
    }

    @Test
    public void testIsOptionalWithTableWithRecords() {
        BindingTable expectedResult = new BindingTable(true, columnNames);
        expectedResult.addRecord(record);

        bindingTable.addRecord(record);
        bindingTable.isOptional();

        checkIfBindingTablesAreEqual(expectedResult, bindingTable);
    }

    @Test(expected = IllegalStateException.class)
    public void testIsMandatoryWithEmptyTable() {
        bindingTable.isMandatory();
    }

    @Test
    public void testIsMandatoryWithTableWithRecords() {
        BindingTable expectedResult = new BindingTable(true, columnNames);
        expectedResult.addRecord(record);

        bindingTable.addRecord(record);
        bindingTable.isMandatory();

        checkIfBindingTablesAreEqual(expectedResult, bindingTable);
    }

    @Test
    public void testMakeDistinctWithoutDuplicates() {
        BindingTable expectedResult = new BindingTable(false, columnNames);
        expectedResult.addRecord(record);
        expectedResult.addRecord(secondRecord);

        bindingTable.addRecord(record);
        bindingTable.addRecord(secondRecord);
        bindingTable.makeDistinct();

        checkIfBindingTablesAreEqual(expectedResult, bindingTable);
    }

    @Test
    public void testMakeDistinctWithDuplicates() {
        BindingTable expectedResult = new BindingTable(false, columnNames);
        expectedResult.addRecord(record);
        expectedResult.addRecord(secondRecord);

        bindingTable.addRecord(record);
        bindingTable.addRecord(record);
        bindingTable.addRecord(record);
        bindingTable.addRecord(record);
        bindingTable.addRecord(record);
        bindingTable.addRecord(record);
        bindingTable.addRecord(secondRecord);
        bindingTable.addRecord(secondRecord);
        bindingTable.addRecord(secondRecord);
        bindingTable.makeDistinct();

        checkIfBindingTablesAreEqual(expectedResult, bindingTable);
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

        BindingTable expectedResult = new BindingTable(true, new String[]{"x"});
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
        checkIfBindingTablesAreEqual(expectedResult, table);
    }

    @Test
    public void testFilterWithPropertyReference() {
        setWorkingGraphToSyntheticGraph();

        BindingTable expectedResult = new BindingTable(true, new String[]{"x"});
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
        checkIfBindingTablesAreEqual(expectedResult, table);
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
        bindingTable.removeRecord(record);
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
        bindingTable.removeRecord(record);
        assertTrue(bindingTable.getRecords().contains(record));
        assertEquals(1, bindingTable.getRecords().size());
    }

    @Test(expected = SemanticErrorException.class)
    public void testAddRecordWithMoreColumnsThenTable() {
        String[] columnNames = new String[]{"col1", "col2"};
        bindingTable = new BindingTable(false, columnNames);

        bindingTable.addRecord(record);
    }

    @Test(expected = SemanticErrorException.class)
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
}