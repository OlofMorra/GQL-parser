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

package gql.returns;

import exceptions.InvalidEdgeFormatException;
import exceptions.InvalidNodeFormatException;
import gql.enums.BooleanComparator;
import gql.enums.SetQuantifier;
import gql.enums.ValueComparator;
import gql.expressions.filters.BooleanExpressionComparison;
import gql.expressions.filters.NegatedExpression;
import gql.expressions.filters.ValueComparison;
import gql.expressions.references.NameExpression;
import gql.expressions.references.PropertyReference;
import gql.expressions.values.*;
import gql.graphs.GqlEdge;
import gql.graphs.GqlNode;
import gql.graphs.WorkingGraph;
import gql.tables.BindingTable;
import gql.tables.BindingTableComparator;
import gql.tables.Record;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class ReturnStatementTest implements BindingTableComparator {
    private final SetQuantifier ALL = SetQuantifier.ALL;
    private final SetQuantifier DISTINCT = SetQuantifier.DISTINCT;

    GqlNode n1 = new GqlNode(new GqlIdentifier("n1"), new ArrayList<>(), new HashMap<>());
    GqlNode n2 = new GqlNode(new GqlIdentifier("n2"), new ArrayList<>(), new HashMap<>());
    GqlNode n3 = new GqlNode(new GqlIdentifier("n3"), new ArrayList<>(), new HashMap<>());
    GqlEdge e1 = new GqlEdge(new GqlIdentifier("e1"), new GqlIdentifier("n1"), new GqlIdentifier("n2"), false, new ArrayList<>(), new HashMap<>());
    GqlEdge e2 = new GqlEdge(new GqlIdentifier("e2"), new GqlIdentifier("n2"), new GqlIdentifier("n3"), false, new ArrayList<>(), new HashMap<>());
    GqlEdge e3 = new GqlEdge(new GqlIdentifier("e3"), new GqlIdentifier("n3"), new GqlIdentifier("n3"), false, new ArrayList<>(), new HashMap<>());


    @Before
    public void setUp() {
        HashMap<GqlIdentifier, Value> propertiesN1 = new HashMap<>();
        propertiesN1.put(new GqlIdentifier("booleanTest"), new TruthValue(true));
        n1.setProperties(propertiesN1);

        HashMap<GqlIdentifier, Value> propertiesN2 = new HashMap<>();
        propertiesN2.put(new GqlIdentifier("age"), new FixedPointNumber("25"));
        propertiesN2.put(new GqlIdentifier("name"), new GqlString("Olof Morra"));
        n2.setProperties(propertiesN2);

        HashMap<GqlIdentifier, Value> propertiesN3 = new HashMap<>();
        propertiesN3.put(new GqlIdentifier("approximate"), new FloatingPointNumber("3E3"));
        n3.setProperties(propertiesN3);

        setWorkingGraphToSyntheticGraph();
    }

    @Test
    public void testObtainResultFromReturnItemContainsValue() {
        BindingTable expectedResult = new BindingTable(true, new String[]{"literal"});
        expectedResult.addRecordMultipleTimes(new Record(new String[]{"literal"}, new Value[]{new GqlString("This is a literal in the return statement.")}), 3);

        BindingTable table = new BindingTable(true, new String[]{"x"});
        table.addRecordMultipleTimes(new Record(new String[]{"x"}, new Value[]{new GqlIdentifier("n1")}), 3);

        ArrayList<ReturnItem> returnItemList = new ArrayList<>();
        returnItemList.add(new ReturnExpression(new GqlString("This is a literal in the return statement."), "literal"));
        ReturnStatement returnStatement = new ReturnStatement(ALL, returnItemList);

        checkIfBindingTablesAreEqual(expectedResult, returnStatement.obtainResultFrom(table));
    }

    @Test
    public void testObtainResultFromReturnItemContainsPropertyReference() {
        BindingTable expectedResult = new BindingTable(true, new String[]{"name"});
        expectedResult.addRecord(new Record(new String[]{"name"}, new Value[]{new TruthValue(null)}));
        expectedResult.addRecord(new Record(new String[]{"name"}, new Value[]{new GqlString("Olof Morra")}));
        expectedResult.addRecord(new Record(new String[]{"name"}, new Value[]{new TruthValue(null)}));

        BindingTable table = new BindingTable(true, new String[]{"x"});
        table.addRecord(new Record(new String[]{"x"}, new Value[]{new GqlIdentifier("n1")}));
        table.addRecord(new Record(new String[]{"x"}, new Value[]{new GqlIdentifier("n2")}));
        table.addRecord(new Record(new String[]{"x"}, new Value[]{new GqlIdentifier("n3")}));

        ArrayList<ReturnItem> returnItemList = new ArrayList<>();
        returnItemList.add(new ReturnExpression(new PropertyReference("x", "name"), "name"));
        ReturnStatement returnStatement = new ReturnStatement(ALL, returnItemList);

        checkIfBindingTablesAreEqual(expectedResult, returnStatement.obtainResultFrom(table));
    }

    @Test
    public void testObtainResultFromReturnItemContainsNodeName() {
        BindingTable expectedResult = new BindingTable(true, new String[]{"x"});
        expectedResult.addRecord(new Record(new String[]{"x"}, new Value[]{n1}));
        expectedResult.addRecord(new Record(new String[]{"x"}, new Value[]{n2}));
        expectedResult.addRecord(new Record(new String[]{"x"}, new Value[]{n3}));

        BindingTable table = new BindingTable(true, new String[]{"x"});
        table.addRecord(new Record(new String[]{"x"}, new Value[]{new GqlIdentifier("n1")}));
        table.addRecord(new Record(new String[]{"x"}, new Value[]{new GqlIdentifier("n2")}));
        table.addRecord(new Record(new String[]{"x"}, new Value[]{new GqlIdentifier("n3")}));

        ArrayList<ReturnItem> returnItemList = new ArrayList<>();
        returnItemList.add(new ReturnExpression(new NameExpression("x")));
        ReturnStatement returnStatement = new ReturnStatement(ALL, returnItemList);

        checkIfBindingTablesAreEqual(expectedResult, returnStatement.obtainResultFrom(table));
    }

    @Test
    public void testObtainResultFromReturnItemContainsEdgeName() {
        BindingTable expectedResult = new BindingTable(true, new String[]{"y"});
        expectedResult.addRecord(new Record(new String[]{"y"}, new Value[]{e1}));
        expectedResult.addRecord(new Record(new String[]{"y"}, new Value[]{e2}));

        BindingTable table = new BindingTable(true, new String[]{"y"});
        table.addRecord(new Record(new String[]{"y"}, new Value[]{new GqlIdentifier("e1")}));
        table.addRecord(new Record(new String[]{"y"}, new Value[]{new GqlIdentifier("e2")}));

        ArrayList<ReturnItem> returnItemList = new ArrayList<>();
        returnItemList.add(new ReturnExpression(new NameExpression("y")));
        ReturnStatement returnStatement = new ReturnStatement(ALL, returnItemList);

        checkIfBindingTablesAreEqual(expectedResult, returnStatement.obtainResultFrom(table));
    }

    @Test
    public void testObtainResultFromReturnItemContainsNegatedExpression() {
        BindingTable expectedResult = new BindingTable(true, new String[]{"Negated expression"});
        expectedResult.addRecord(new Record(new String[]{"Negated expression"}, new Value[]{new TruthValue(true)}));

        BindingTable table = new BindingTable(true, new String[]{"x"});
        table.addRecord(new Record(new String[]{"x"}, new Value[]{new GqlIdentifier("n1")}));

        ArrayList<ReturnItem> returnItemList = new ArrayList<>();
        returnItemList.add(new ReturnExpression(new NegatedExpression(new TruthValue(false)), "Negated expression"));
        ReturnStatement returnStatement = new ReturnStatement(ALL, returnItemList);

        checkIfBindingTablesAreEqual(expectedResult, returnStatement.obtainResultFrom(table));
    }

    @Test
    public void testObtainResultFromReturnItemContainsBooleanExpressionComparison() {
        BindingTable expectedResult = new BindingTable(true, new String[]{"Boolean"});
        expectedResult.addRecord(new Record(new String[]{"Boolean"}, new Value[]{new TruthValue(false)}));

        BindingTable table = new BindingTable(true, new String[]{"x"});
        table.addRecord(new Record(new String[]{"x"}, new Value[]{new GqlIdentifier("n1")}));

        ArrayList<ReturnItem> returnItemList = new ArrayList<>();
        returnItemList.add(new ReturnExpression(new BooleanExpressionComparison(new TruthValue(false), BooleanComparator.AND, new TruthValue(true)), "Boolean"));
        ReturnStatement returnStatement = new ReturnStatement(ALL, returnItemList);

        checkIfBindingTablesAreEqual(expectedResult, returnStatement.obtainResultFrom(table));
    }

    @Test
    public void testObtainResultFromReturnItemContainsValueComparison() {
        BindingTable expectedResult = new BindingTable(true, new String[]{"Value comparison"});
        expectedResult.addRecord(new Record(new String[]{"Value comparison"}, new Value[]{new TruthValue(true)}));

        BindingTable table = new BindingTable(true, new String[]{"x"});
        table.addRecord(new Record(new String[]{"x"}, new Value[]{new GqlIdentifier("n1")}));

        ArrayList<ReturnItem> returnItemList = new ArrayList<>();
        returnItemList.add(new ReturnExpression(new ValueComparison(new FloatingPointNumber("3E3"), ValueComparator.GT, new FloatingPointNumber("3E-3")), "Value comparison"));
        ReturnStatement returnStatement = new ReturnStatement(ALL, returnItemList);

        checkIfBindingTablesAreEqual(expectedResult, returnStatement.obtainResultFrom(table));
    }

    @Test
    public void testObtainResultFromReturnStatementDistinct() {
        BindingTable expectedResult = new BindingTable(false, new String[]{"x"});
        expectedResult.addRecord(new Record(new String[]{"x"}, new Value[]{n1}));
        expectedResult.addRecord(new Record(new String[]{"x"}, new Value[]{n2}));
        expectedResult.addRecord(new Record(new String[]{"x"}, new Value[]{n3}));

        BindingTable table = new BindingTable(true, new String[]{"x"});
        table.addRecord(new Record(new String[]{"x"}, new Value[]{new GqlIdentifier("n1")}));
        table.addRecordMultipleTimes(new Record(new String[]{"x"}, new Value[]{new GqlIdentifier("n2")}), 2);
        table.addRecordMultipleTimes(new Record(new String[]{"x"}, new Value[]{new GqlIdentifier("n3")}), 3);

        ArrayList<ReturnItem> returnItemList = new ArrayList<>();
        returnItemList.add(new ReturnExpression(new NameExpression("x")));
        ReturnStatement returnStatement = new ReturnStatement(DISTINCT, returnItemList);

        checkIfBindingTablesAreEqual(expectedResult, returnStatement.obtainResultFrom(table));
    }

    @Test
    public void testObtainResultFromWithAlias() {
        BindingTable expectedResult = new BindingTable(true, new String[]{"edges"});
        expectedResult.addRecord(new Record(new String[]{"edges"}, new Value[]{e1}));
        expectedResult.addRecord(new Record(new String[]{"edges"}, new Value[]{e2}));

        BindingTable table = new BindingTable(true, new String[]{"y"});
        table.addRecord(new Record(new String[]{"y"}, new Value[]{new GqlIdentifier("e1")}));
        table.addRecord(new Record(new String[]{"y"}, new Value[]{new GqlIdentifier("e2")}));

        ArrayList<ReturnItem> returnItemList = new ArrayList<>();
        returnItemList.add(new ReturnExpression(new NameExpression("y"), "edges"));
        ReturnStatement returnStatement = new ReturnStatement(ALL, returnItemList);

        checkIfBindingTablesAreEqual(expectedResult, returnStatement.obtainResultFrom(table));
    }

    @Test
    public void testObtainResultFromReturnAsterisk() {
        BindingTable expectedResult = new BindingTable(true, new String[]{"y"});
        expectedResult.addRecord(new Record(new String[]{"y"}, new Value[]{e1}));
        expectedResult.addRecord(new Record(new String[]{"y"}, new Value[]{e2}));
        expectedResult.addRecord(new Record(new String[]{"y"}, new Value[]{e3}));

        BindingTable table = new BindingTable(true, new String[]{"y"});
        table.addRecord(new Record(new String[]{"y"}, new Value[]{new GqlIdentifier("e1")}));
        table.addRecord(new Record(new String[]{"y"}, new Value[]{new GqlIdentifier("e2")}));
        table.addRecord(new Record(new String[]{"y"}, new Value[]{new GqlIdentifier("e3")}));

        ArrayList<ReturnItem> returnItemList = new ArrayList<>();
        returnItemList.add(new Asterisk());
        ReturnStatement returnStatement = new ReturnStatement(ALL, returnItemList);

        checkIfBindingTablesAreEqual(expectedResult, returnStatement.obtainResultFrom(table));
    }

    @Test
    public void testObtainResultFromWithMultipleReturnItems() {
        BindingTable expectedResult = new BindingTable(true, new String[]{"nodes", "edges"});
        expectedResult.addRecord(new Record(new String[]{"nodes", "edges"}, new Value[]{n1, e1}));
        expectedResult.addRecord(new Record(new String[]{"nodes", "edges"}, new Value[]{n2, e2}));
        expectedResult.addRecord(new Record(new String[]{"nodes", "edges"}, new Value[]{n3, e3}));

        BindingTable table = new BindingTable(true, new String[]{"x", "y"});
        table.addRecord(new Record(new String[]{"x", "y"}, new Value[]{new GqlIdentifier("n1"), new GqlIdentifier("e1")}));
        table.addRecord(new Record(new String[]{"x", "y"}, new Value[]{new GqlIdentifier("n2"), new GqlIdentifier("e2")}));
        table.addRecord(new Record(new String[]{"x", "y"}, new Value[]{new GqlIdentifier("n3"), new GqlIdentifier("e3")}));

        ArrayList<ReturnItem> returnItemList = new ArrayList<>();
        returnItemList.add(new ReturnExpression(new NameExpression("x"), "nodes"));
        returnItemList.add(new ReturnExpression(new NameExpression("y"), "edges"));
        ReturnStatement returnStatement = new ReturnStatement(ALL, returnItemList);

        checkIfBindingTablesAreEqual(expectedResult, returnStatement.obtainResultFrom(table));
    }

    @Test
    public void testObtainResultFromWithMultipleReturnItemsUsingAsterisk() {
        BindingTable expectedResult = new BindingTable(true, new String[]{"x", "y"});
        expectedResult.addRecord(new Record(new String[]{"x", "y"}, new Value[]{n1, e1}));
        expectedResult.addRecord(new Record(new String[]{"x", "y"}, new Value[]{n2, e2}));
        expectedResult.addRecord(new Record(new String[]{"x", "y"}, new Value[]{n3, e3}));

        BindingTable table = new BindingTable(true, new String[]{"x", "y"});
        table.addRecord(new Record(new String[]{"x", "y"}, new Value[]{new GqlIdentifier("n1"), new GqlIdentifier("e1")}));
        table.addRecord(new Record(new String[]{"x", "y"}, new Value[]{new GqlIdentifier("n2"), new GqlIdentifier("e2")}));
        table.addRecord(new Record(new String[]{"x", "y"}, new Value[]{new GqlIdentifier("n3"), new GqlIdentifier("e3")}));

        ArrayList<ReturnItem> returnItemList = new ArrayList<>();
        returnItemList.add(new Asterisk());
        ReturnStatement returnStatement = new ReturnStatement(ALL, returnItemList);

        checkIfBindingTablesAreEqual(expectedResult, returnStatement.obtainResultFrom(table));
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