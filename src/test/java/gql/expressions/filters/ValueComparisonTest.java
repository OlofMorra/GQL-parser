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

package gql.expressions.filters;

import exceptions.InvalidEdgeFormatException;
import exceptions.InvalidNodeFormatException;
import exceptions.SemanticErrorException;
import gql.enums.ValueComparator;
import gql.expressions.references.NameExpression;
import gql.expressions.references.PropertyReference;
import gql.expressions.values.*;
import gql.graphs.WorkingGraph;
import gql.tables.Record;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class ValueComparisonTest {
    ValueComparator EQ = ValueComparator.EQ;
    ValueComparator NEQ = ValueComparator.NEQ;
    ValueComparator LT = ValueComparator.LT;
    ValueComparator GT = ValueComparator.GT;
    ValueComparator LEQ = ValueComparator.LEQ;
    ValueComparator GEQ = ValueComparator.GEQ;

    TruthValue TRUE = new TruthValue(true);
    TruthValue FALSE = new TruthValue(false);
    TruthValue UNKNOWN = new TruthValue(null);

    FixedPointNumber ONE = new FixedPointNumber("1");
    FixedPointNumber THREE = new FixedPointNumber("3");
    FixedPointNumber FOUR = new FixedPointNumber("4");


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testInitializationWithGqlStringAndFixedPointNumber() {
        thrown.expect(SemanticErrorException.class);
        thrown.expectMessage(containsString("Invalid comparison"));
        new ValueComparison(new GqlString("test"), EQ, THREE).evaluateOn(new Record(new String[]{}, new Value[]{}));
    }

    @Test
    public void testInitializationWithGqlStringAndFloatingPointNumber() {
        thrown.expect(SemanticErrorException.class);
        thrown.expectMessage(containsString("Invalid comparison"));
        new ValueComparison(new GqlString("test"), EQ, new FloatingPointNumber("3E3")).evaluateOn(new Record(new String[]{}, new Value[]{}));
    }

    @Test
    public void testInitializationWithFloatingPointNumberAndFixedPointNumber() {
        thrown.expect(SemanticErrorException.class);
        thrown.expectMessage(containsString("Invalid comparison"));
        new ValueComparison(new FloatingPointNumber("3E3"), EQ, THREE).evaluateOn(new Record(new String[]{}, new Value[]{}));
    }

    @Test
    public void testInitializationWithGqlStringAndTruthValue() {
        thrown.expect(SemanticErrorException.class);
        thrown.expectMessage(containsString("Invalid comparison"));
        new ValueComparison(new GqlString("TRUE"), EQ, TRUE).evaluateOn(new Record(new String[]{}, new Value[]{}));
    }

    @Test
    public void testInitializationWithTruthValueAndFloatingPointNumber() {
        thrown.expect(SemanticErrorException.class);
        thrown.expectMessage(containsString("Invalid comparison"));
        new ValueComparison(TRUE, EQ, new FloatingPointNumber("3E3")).evaluateOn(new Record(new String[]{}, new Value[]{}));
    }

    @Test
    public void testInitializationWithTruthValueAndFixedPointNumber() {
        thrown.expect(SemanticErrorException.class);
        thrown.expectMessage(containsString("Invalid comparison"));
        new ValueComparison(TRUE, EQ, ONE).evaluateOn(new Record(new String[]{}, new Value[]{}));
    }

    @Test
    public void testEvaluateEq() {
        assertEquals(TRUE, new ValueComparison(THREE, EQ, THREE).evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(FALSE, new ValueComparison(THREE, EQ, FOUR).evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(FALSE, new ValueComparison(THREE, EQ, ONE).evaluateOn(new Record(new String[]{}, new Value[]{})));
    }

    @Test
    public void testEvaluateNeq() {
        assertEquals(FALSE, new ValueComparison(THREE, NEQ, THREE).evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(TRUE, new ValueComparison(THREE, NEQ, FOUR).evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(TRUE, new ValueComparison(THREE, NEQ, ONE).evaluateOn(new Record(new String[]{}, new Value[]{})));
    }

    @Test
    public void testEvaluateLt() {
        assertEquals(FALSE, new ValueComparison(THREE, LT, THREE).evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(TRUE, new ValueComparison(THREE, LT, FOUR).evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(FALSE, new ValueComparison(THREE, LT, ONE).evaluateOn(new Record(new String[]{}, new Value[]{})));
    }

    @Test
    public void testEvaluateGt() {
        assertEquals(FALSE, new ValueComparison(THREE, GT, THREE).evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(FALSE, new ValueComparison(THREE, GT, FOUR).evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(TRUE, new ValueComparison(THREE, GT, ONE).evaluateOn(new Record(new String[]{}, new Value[]{})));
    }

    @Test
    public void testEvaluateLeq() {
        assertEquals(TRUE, new ValueComparison(THREE, LEQ, THREE).evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(TRUE, new ValueComparison(THREE, LEQ, FOUR).evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(FALSE, new ValueComparison(THREE, LEQ, ONE).evaluateOn(new Record(new String[]{}, new Value[]{})));
    }

    @Test
    public void testEvaluateGeq() {
        assertEquals(TRUE, new ValueComparison(THREE, GEQ, THREE).evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(FALSE, new ValueComparison(THREE, GEQ, FOUR).evaluateOn(new Record(new String[]{}, new Value[]{})));
        assertEquals(TRUE, new ValueComparison(THREE, GEQ, ONE).evaluateOn(new Record(new String[]{}, new Value[]{})));
    }

    @Test
    public void testEvaluateOnWithPropertyReferenceToGqlString() {
        try {
            WorkingGraph.getInstance().setToTestDirectory();
            WorkingGraph.getInstance().setLocalGraph("syntheticGraph");
        } catch (FileNotFoundException | InvalidNodeFormatException | InvalidEdgeFormatException exception) {
            exception.printStackTrace();
        }

        GqlString left = new GqlString("Olof Morra");
        Record record = new Record(new String[]{"x"}, new Value[]{new GqlIdentifier("n2")});
        PropertyReference propertyReference = new PropertyReference("x", "name");
        ValueComparison valueComparison = new ValueComparison(left, EQ, propertyReference);
        assertEquals(TRUE, valueComparison.evaluateOn(record));
    }

    @Test
    public void testEvaluateOnWithPropertyReferenceToFixedPointNumber() {
        try {
            WorkingGraph.getInstance().setToTestDirectory();
            WorkingGraph.getInstance().setLocalGraph("syntheticGraph");
        } catch (FileNotFoundException | InvalidNodeFormatException | InvalidEdgeFormatException exception) {
            exception.printStackTrace();
        }

        FixedPointNumber right = new FixedPointNumber("19", "85");
        Record record = new Record(new String[]{"x"}, new Value[]{new GqlIdentifier("n2")});
        PropertyReference propertyReference = new PropertyReference("x", "age");
        ValueComparison valueComparison = new ValueComparison(propertyReference, LEQ, right);
        assertEquals(FALSE, valueComparison.evaluateOn(record));
    }

    @Test
    public void testEvaluateOnWithPropertyReferenceToFloatingPointNumber() {
        try {
            WorkingGraph.getInstance().setToTestDirectory();
            WorkingGraph.getInstance().setLocalGraph("syntheticGraph");
        } catch (FileNotFoundException | InvalidNodeFormatException | InvalidEdgeFormatException exception) {
            exception.printStackTrace();
        }

        FloatingPointNumber right = new FloatingPointNumber("3E3");
        Record record = new Record(new String[]{"x"}, new Value[]{new GqlIdentifier("n3")});
        PropertyReference propertyReference = new PropertyReference("x", "approximate");
        ValueComparison valueComparison = new ValueComparison(propertyReference, LEQ, right);
        assertEquals(TRUE, valueComparison.evaluateOn(record));
    }

    @Test(expected = SemanticErrorException.class)
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
        ValueComparison valueComparison = new ValueComparison(left, EQ, propertyReference);
        valueComparison.evaluateOn(record);
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
        ValueComparison valueComparison = new ValueComparison(left, EQ, propertyReference);
        assertEquals(UNKNOWN, valueComparison.evaluateOn(record));
    }

    @Test
    public void testWithNameExpressions() {
        try {
            WorkingGraph.getInstance().setToTestDirectory();
            WorkingGraph.getInstance().setLocalGraph("syntheticGraph");
        } catch (FileNotFoundException | InvalidNodeFormatException | InvalidEdgeFormatException exception) {
            exception.printStackTrace();
        }

        Record record = new Record(new String[]{"x", "y"}, new Value[]{new GqlIdentifier("n1"), new GqlIdentifier("n1")});
        NameExpression left = new NameExpression("x");
        NameExpression right = new NameExpression("y");
        ValueComparison valueComparison = new ValueComparison(left, EQ, right);
        assertEquals(TRUE, valueComparison.evaluateOn(record));
    }
}