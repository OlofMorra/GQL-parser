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

package gql;

import exceptions.InvalidEdgeFormatException;
import exceptions.InvalidNodeFormatException;
import exceptions.SemanticErrorException;
import exceptions.SyntaxErrorException;
import gql.expressions.values.*;
import gql.graphs.GqlEdge;
import gql.graphs.GqlNode;
import gql.graphs.WorkingGraph;
import gql.tables.BindingTable;
import gql.tables.BindingTableComparator;
import gql.tables.Record;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class GqlFileQueryEvaluatorTest implements BindingTableComparator {
    private final String queryTestsFolder = "src/test/resources/queries/gql/tests";

    /**
     * Make sure that no exceptions are thrown and caught during evaluation.
     */
    @Rule
    public ExpectedException exception = ExpectedException.none();

    /**
     * Make sure that all ambient queries (without FROM clause) are tested on the synthetic graph.
     * That way testing stays stable.
     */
    @Before
    public void setWorkingGraph() {
        try {
            WorkingGraph graph = WorkingGraph.getInstance();
            graph.setToTestDirectory();
            graph.setLocalGraph("syntheticGraph");
        } catch (FileNotFoundException | InvalidNodeFormatException | InvalidEdgeFormatException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Comparison operators
     */
    @Test
    public void testEqualsOperator() {
        String[] expectedColumnNames = new String[]{"x"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN2FromSyntheticGraph()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/comparison_operators/equals_op.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("syntheticGraph", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testEqualsOperatorOnNulls() {
        String[] expectedColumnNames = new String[]{"x"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/comparison_operators/equals_op_on_nulls.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("syntheticGraph", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testEqualsOrLargerThanOperator() {
        String[] expectedColumnNames = new String[]{"x"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN2FromSyntheticGraph()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/comparison_operators/equals_or_larger_than_op.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("syntheticGraph", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testEqualsOrSmallerThanOperator() {
        String[] expectedColumnNames = new String[]{"x"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN2FromSyntheticGraph()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/comparison_operators/equals_or_smaller_than_op.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("syntheticGraph", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testLargerThanOperator() {
        String[] expectedColumnNames = new String[]{"x"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN2FromSyntheticGraph()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/comparison_operators/larger_than_op.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("syntheticGraph", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testSmallerThanOperator() {
        String[] expectedColumnNames = new String[]{"x"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN2FromSyntheticGraph()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/comparison_operators/smaller_than_op.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("syntheticGraph", WorkingGraph.getCurrentGraphName());
    }

    /**
     * Complex
     */
    @Test
    public void testUnionAllTwice() {
        String[] expectedColumnNames = new String[]{"x"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN19FromG3()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN29FromG3()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN85FromG3()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN19FromG3()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN5FromG3()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/complex/union_all_twice.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("g3", WorkingGraph.getCurrentGraphName());
    }

    /**
     * Conjunctions
     */
    @Test
    public void testExceptAll() {
        String[] expectedColumnNames = new String[]{"x"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN5FromG3()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN29FromG3()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN85FromG3()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/conjunctions/except_all.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("g3", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testExceptDistinct() {
        String[] expectedColumnNames = new String[]{"x"};
        BindingTable expectedResult = new BindingTable(false, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN85FromG3()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/conjunctions/except_distinct.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("g3", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testIntersectAll() {
        String[] expectedColumnNames = new String[]{"x"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN19FromG3()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN19FromG3()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/conjunctions/intersect_all.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("g3", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testIntersectDistinct() {
        String[] expectedColumnNames = new String[]{"x"};
        BindingTable expectedResult = new BindingTable(false, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN19FromG3()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/conjunctions/intersect_distinct.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("g3", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testOtherwise() {
        String[] expectedColumnNames = new String[]{"x"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN5FromG3()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/conjunctions/otherwise.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("g3", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testUnionAll() {
        String[] expectedColumnNames = new String[]{"x"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN19FromG3()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN19FromG3()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN29FromG3()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN85FromG3()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/conjunctions/union_all.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("g3", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testUnionDistinct() {
        String[] expectedColumnNames = new String[]{"x"};
        BindingTable expectedResult = new BindingTable(false, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN19FromG3()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN29FromG3()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN85FromG3()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/conjunctions/union_distinct.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("g3", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testUnionMax() {
        String[] expectedColumnNames = new String[]{"x"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN19FromG3()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN19FromG3()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN85FromG3()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN85FromG3()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/conjunctions/union_max.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("g3", WorkingGraph.getCurrentGraphName());
    }

    /**
     * Label expressions
     */
    @Test
    public void testLabelWildcard() {
        String[] expectedColumnNames = new String[]{"x"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getE21FromG3()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getE21FromG3()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/label_expressions/label_wildcard.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("g3", WorkingGraph.getCurrentGraphName());
    }

    @Test(expected = SemanticErrorException.class)
    public void testParenthesizedLabels() {
        String[] expectedColumnNames = new String[]{"x"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN19FromG3()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN29FromG3()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN85FromG3()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/label_expressions/parenthesized_labels.gql");
        queryEvaluator.getEvaluationResult();
    }

    /**
     * Logic
     */
    @Test
    public void testAnd() {
        String[] expectedColumnNames = new String[]{"x"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN1FromSyntheticGraph()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/logic/AND.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("syntheticGraph", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testNot() {
        String[] expectedColumnNames = new String[]{"x"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/logic/NOT.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("syntheticGraph", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testOr() {
        String[] expectedColumnNames = new String[]{"x"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN1FromSyntheticGraph()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/logic/OR.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("syntheticGraph", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testXor() {
        String[] expectedColumnNames = new String[]{"x"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN1FromSyntheticGraph()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/logic/XOR.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("syntheticGraph", WorkingGraph.getCurrentGraphName());
    }

    /**
     * Path patterns
     */
    @Test
    public void testFilledPathPattern() {
        String[] expectedColumnNames = new String[]{"x", "name", "y"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN85FromG3(), new GqlString("Olof Morra"), getN5FromG3()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/path_patterns/filled_path_pattern.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("g3", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testMultiplePathPatternsDifferentVariableNames() {
        String[] expectedColumnNames = new String[]{"a", "b", "c", "x", "y", "z"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN1FromG(), getN2FromG(), getN3FromG(), getN1FromG(), getN2FromG(), getN3FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN1FromG(), getN2FromG(), getN3FromG(), getN2FromG(), getN3FromG(), getN3FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN1FromG(), getN2FromG(), getN3FromG(), getN3FromG(), getN2FromG(), getN1FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN1FromG(), getN2FromG(), getN3FromG(), getN3FromG(), getN3FromG(), getN2FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN3FromG(), getN2FromG(), getN1FromG(), getN1FromG(), getN2FromG(), getN3FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN3FromG(), getN2FromG(), getN1FromG(), getN2FromG(), getN3FromG(), getN3FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN3FromG(), getN2FromG(), getN1FromG(), getN3FromG(), getN2FromG(), getN1FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN3FromG(), getN2FromG(), getN1FromG(), getN3FromG(), getN3FromG(), getN2FromG()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/path_patterns/multiple_path_patterns_different_variable_names.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("g", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testMultiplePathPatternsSameVariableNames() {
        String[] expectedColumnNames = new String[]{"x", "y", "z"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN1FromG(), getN2FromG(), getN3FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN3FromG(), getN2FromG(), getN1FromG()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/path_patterns/multiple_path_patterns_same_variable_names.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("g", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testPathAcyclic() {
        String[] expectedColumnNames = new String[]{"x", "y", "z"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN1FromG(), getN2FromG(), getN3FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN3FromG(), getN2FromG(), getN1FromG()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/path_patterns/path_acyclic.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("g", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testPathTrail() {
        String[] expectedColumnNames = new String[]{"x", "y", "z"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN1FromG(), getN2FromG(), getN3FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN2FromG(), getN3FromG(), getN3FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN3FromG(), getN2FromG(), getN1FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN3FromG(), getN3FromG(), getN2FromG()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/path_patterns/path_trail.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("g", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testPathSimple() {
        String[] expectedColumnNames = new String[]{"x", "y", "z"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN1FromG(), getN2FromG(), getN1FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN1FromG(), getN2FromG(), getN3FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN2FromG(), getN1FromG(), getN2FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN2FromG(), getN3FromG(), getN2FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN3FromG(), getN2FromG(), getN1FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN3FromG(), getN2FromG(), getN3FromG()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/path_patterns/path_simple.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("g", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testPathWalk() {
        String[] expectedColumnNames = new String[]{"x", "y", "z"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN1FromG(), getN2FromG(), getN1FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN1FromG(), getN2FromG(), getN3FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN2FromG(), getN1FromG(), getN2FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN2FromG(), getN3FromG(), getN2FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN2FromG(), getN3FromG(), getN3FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN3FromG(), getN2FromG(), getN1FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN3FromG(), getN2FromG(), getN3FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN3FromG(), getN3FromG(), getN2FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN3FromG(), getN3FromG(), getN3FromG()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/path_patterns/path_walk.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("g", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testPathQuantifier() {
        String[] expectedColumnNames = new String[]{"x", "y"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN1FromG(), getN1FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN1FromG(), getN3FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN2FromG(), getN2FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN2FromG(), getN2FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN2FromG(), getN3FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN3FromG(), getN1FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN3FromG(), getN3FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN3FromG(), getN2FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN3FromG(), getN3FromG()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/path_patterns/path_quantifier.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("g", WorkingGraph.getCurrentGraphName());
    }

    /**
     * Value comparison
     */
    @Test
    public void testIsFalse() {
        String[] expectedColumnNames = new String[]{"x"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/value_comparisons/IS_FALSE.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("syntheticGraph", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testIsNotFalse() {
        String[] expectedColumnNames = new String[]{"x"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN1FromSyntheticGraph()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN2FromSyntheticGraph()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN3FromSyntheticGraph()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/value_comparisons/IS_NOT_FALSE.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("syntheticGraph", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testIsNotTrue() {
        String[] expectedColumnNames = new String[]{"x"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN2FromSyntheticGraph()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN3FromSyntheticGraph()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/value_comparisons/IS_NOT_TRUE.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("syntheticGraph", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testIsNotUnknown() {
        String[] expectedColumnNames = new String[]{"x"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN1FromSyntheticGraph()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/value_comparisons/IS_NOT_UNKNOWN.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("syntheticGraph", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testIsTrue() {
        String[] expectedColumnNames = new String[]{"x"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN1FromSyntheticGraph()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/value_comparisons/IS_TRUE.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("syntheticGraph", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testIsUnknown() {
        String[] expectedColumnNames = new String[]{"x"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN2FromSyntheticGraph()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN3FromSyntheticGraph()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/value_comparisons/IS_UNKNOWN.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("syntheticGraph", WorkingGraph.getCurrentGraphName());
    }

    /**
     * Return statements
     */
    @Test
    public void testReturnAsteriskMultipleVariables() {
        String[] expectedColumnNames = new String[]{"x", "y", "z"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN1FromG(), getE1FromG(), getN2FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN2FromG(), getE1FromG(), getN1FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN2FromG(), getE2FromG(), getN3FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN3FromG(), getE2FromG(), getN2FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN3FromG(), getE3FromG(), getN3FromG()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/return_statements/return_asterisk_multiple_variables.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("g", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testReturnAsteriskSingleVariable() {
        String[] expectedColumnNames = new String[]{"x"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN1FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN2FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN3FromG()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/return_statements/return_asterisk_single_variable.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("g", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testReturnId() {
        String[] expectedColumnNames = new String[]{"x_id"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{new GqlIdentifier("n1")}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{new GqlIdentifier("n2")}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{new GqlIdentifier("n3")}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/return_statements/return_id.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("g", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testReturnPropertyReference() {
        String[] expectedColumnNames = new String[]{"name"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{new GqlString("George Fletcher")}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/return_statements/return_property_reference.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("g3", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testReturnVariableName() {
        String[] expectedColumnNames = new String[]{"x"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN1FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN2FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN3FromG()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/return_statements/return_variable_name.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("g", WorkingGraph.getCurrentGraphName());
    }

    @Test
    public void testReturnVariableNames() {
        String[] expectedColumnNames = new String[]{"x", "y", "z"};
        BindingTable expectedResult = new BindingTable(true, expectedColumnNames);
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN1FromG(), getE1FromG(), getN2FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN2FromG(), getE1FromG(), getN1FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN2FromG(), getE2FromG(), getN3FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN3FromG(), getE2FromG(), getN2FromG()}));
        expectedResult.addRecord(new Record(expectedColumnNames, new Value[]{getN3FromG(), getE3FromG(), getN3FromG()}));

        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/return_statements/return_variable_names.gql");

        checkIfBindingTablesAreEqual(expectedResult, queryEvaluator.getEvaluationResult());
        assertEquals("g", WorkingGraph.getCurrentGraphName());
    }

    /**
     * Syntax error
     */
    @Test
    public void testSyntaxErrorAnd() {
        exception.expect(SyntaxErrorException.class);
        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/syntax_errors/AND.gql");
        queryEvaluator.getEvaluationResult();
    }

    /**
     * Semantic error
     */
    @Test(expected = SemanticErrorException.class)
    public void testSemanticErrorAnd() {
        GqlFileQueryEvaluator queryEvaluator = new GqlFileQueryEvaluator(queryTestsFolder + "/semantic_errors/AND.gql");
        queryEvaluator.getEvaluationResult();
    }

    /**
     * Helper methods
     */
    private GqlNode getN1FromSyntheticGraph() {
        GqlIdentifier id = new GqlIdentifier("n1");
        ArrayList<Label> labels = new ArrayList<>();
        HashMap<GqlIdentifier, Value> properties = new HashMap<>();
        properties.put(new GqlIdentifier("booleanTest"), new TruthValue(true));

        return new GqlNode(id, labels, properties);
    }

    private GqlNode getN2FromSyntheticGraph() {
        GqlIdentifier id = new GqlIdentifier("n2");
        ArrayList<Label> labels = new ArrayList<>();
        HashMap<GqlIdentifier, Value> properties = new HashMap<>();
        properties.put(new GqlIdentifier("name"), new GqlString("Olof Morra"));
        properties.put(new GqlIdentifier("age"), new FixedPointNumber("25"));

        return new GqlNode(id, labels, properties);
    }

    private GqlNode getN3FromSyntheticGraph() {
        GqlIdentifier id = new GqlIdentifier("n3");
        ArrayList<Label> labels = new ArrayList<>();
        HashMap<GqlIdentifier, Value> properties = new HashMap<>();
        properties.put(new GqlIdentifier("approximate"), new FloatingPointNumber("3E3"));

        return new GqlNode(id, labels, properties);
    }

    private GqlNode getN5FromG3() {
        GqlIdentifier id = new GqlIdentifier("n5");
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Internship"));
        HashMap<GqlIdentifier, Value> properties = new HashMap<>();

        return new GqlNode(id, labels, properties);
    }

    private GqlNode getN19FromG3() {
        GqlIdentifier id = new GqlIdentifier("n19");
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Person"));
        labels.add(new Label("Professor"));
        HashMap<GqlIdentifier, Value> properties = new HashMap<>();
        properties.put(new GqlIdentifier("name"), new GqlString("George Fletcher"));
        properties.put(new GqlIdentifier("employer"), new GqlString("TU/e"));

        return new GqlNode(id, labels, properties);
    }

    private GqlNode getN29FromG3() {
        GqlIdentifier id = new GqlIdentifier("n29");
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Person"));
        HashMap<GqlIdentifier, Value> properties = new HashMap<>();
        properties.put(new GqlIdentifier("name"), new GqlString("Michael Schmidt"));
        properties.put(new GqlIdentifier("employer"), new GqlString("Amazon"));

        return new GqlNode(id, labels, properties);
    }

    private GqlNode getN85FromG3() {
        GqlIdentifier id = new GqlIdentifier("n85");
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Person"));
        HashMap<GqlIdentifier, Value> properties = new HashMap<>();
        properties.put(new GqlIdentifier("name"), new GqlString("Olof Morra"));
        properties.put(new GqlIdentifier("studies"), new GqlString("Data Science"));

        return new GqlNode(id, labels, properties);
    }

    private GqlEdge getE2FromG3() {
        GqlIdentifier id = new GqlIdentifier("e2");
        GqlIdentifier startNodeId = new GqlIdentifier("n85");
        GqlIdentifier endNodeId = new GqlIdentifier("n5");
        boolean isDirected = true;
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("Does"));
        HashMap<GqlIdentifier, Value> properties = new HashMap<>();
        properties.put(new GqlIdentifier("in_semester"), new FixedPointNumber("2"));

        return new GqlEdge(id, startNodeId, endNodeId, isDirected, labels, properties);
    }

    private GqlEdge getE21FromG3() {
        GqlIdentifier id = new GqlIdentifier("e21");
        GqlIdentifier startNodeId = new GqlIdentifier("n19");
        GqlIdentifier endNodeId = new GqlIdentifier("n29");
        boolean isDirected = false;
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("AreColleagues"));
        HashMap<GqlIdentifier, Value> properties = new HashMap<>();

        return new GqlEdge(id, startNodeId, endNodeId, isDirected, labels, properties);
    }

    private GqlNode getN1FromG() {
        return getNodeFromG("n1");
    }

    private GqlNode getN2FromG() {
        return getNodeFromG("n2");
    }

    private GqlNode getN3FromG() {
        return getNodeFromG("n3");
    }

    private GqlNode getNodeFromG(String id) {
        GqlIdentifier identifier = new GqlIdentifier(id);
        ArrayList<Label> labels = new ArrayList<>();
        HashMap<GqlIdentifier, Value> properties = new HashMap<>();

        return new GqlNode(identifier, labels, properties);
    }

    private GqlEdge getE1FromG() {
        return getEdgeFromG("e1", "n1", "n2");
    }

    private GqlEdge getE2FromG() {
        return getEdgeFromG("e2", "n2", "n3");
    }

    private GqlEdge getE3FromG() {
        return getEdgeFromG("e3", "n3", "n3");
    }

    private GqlEdge getEdgeFromG(String id, String startNode, String endNode) {
        GqlIdentifier identifier = new GqlIdentifier(id);
        GqlIdentifier startNodeId = new GqlIdentifier(startNode);
        GqlIdentifier endNodeId = new GqlIdentifier(endNode);
        boolean isDirected = false;
        ArrayList<Label> labels = new ArrayList<>();
        HashMap<GqlIdentifier, Value> properties = new HashMap<>();

        return new GqlEdge(identifier, startNodeId, endNodeId, isDirected, labels, properties);
    }
}