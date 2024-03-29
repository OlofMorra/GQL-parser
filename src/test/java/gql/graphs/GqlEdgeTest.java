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

package gql.graphs;

import exceptions.SemanticErrorException;
import gql.expressions.values.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.*;

public class GqlEdgeTest {
    ArrayList<Label> labels = new ArrayList<Label>(Arrays.asList(
            new Label("Test"),
            new Label("Labels")
    ));

    HashMap<GqlIdentifier, Value> properties = new HashMap<>();

    GqlEdge directedEdge = new GqlEdge(new GqlIdentifier("test"), new GqlIdentifier("n1"), new GqlIdentifier("n2"), true, new ArrayList<>(), new HashMap<>());
    GqlEdge directedEdgeWithLabels = new GqlEdge(new GqlIdentifier("test"), new GqlIdentifier("n1"), new GqlIdentifier("n2"), true, labels, new HashMap<>());
    GqlEdge directedEdgeWithProperties = new GqlEdge(new GqlIdentifier("test"), new GqlIdentifier("n1"), new GqlIdentifier("n2"), true, new ArrayList<>(), new HashMap<>());
    GqlEdge directedEdgeWithLabelsAndProperties = new GqlEdge(new GqlIdentifier("test"), new GqlIdentifier("n1"), new GqlIdentifier("n2"), true, labels, new HashMap<>());
    GqlEdge undirectedEdge = new GqlEdge(new GqlIdentifier("test"), new GqlIdentifier("n1"), new GqlIdentifier("n2"), false, new ArrayList<>(), new HashMap<>());

    @Before
    public void setUp() {
        properties.put(new GqlIdentifier("age"), new FixedPointNumber("25"));
        properties.put(new GqlIdentifier("name"), new GqlString("Olof"));

        directedEdgeWithProperties.properties = properties;
        directedEdgeWithLabelsAndProperties.properties = properties;
    }

    @Test(expected = SemanticErrorException.class)
    public void testIsSmallerOrEqualThan() {
        directedEdge.isSmallerOrEqualThan(undirectedEdge);
    }

    @Test(expected = SemanticErrorException.class)
    public void testIsLargerThan() {
        directedEdge.isLargerThan(undirectedEdge);
    }

    @Test(expected = SemanticErrorException.class)
    public void testIsLargerOrEqualThan() {
        directedEdge.isLargerOrEqualThan(undirectedEdge);
    }

    @Test
    public void testIsEqualTo() {
        assertEquals(new TruthValue(true), directedEdge.isEqualTo(directedEdge));
        assertEquals(new TruthValue(false), directedEdge.isEqualTo(undirectedEdge));
    }

    @Test(expected = SemanticErrorException.class)
    public void testIsSmallerThan() {
        directedEdge.isSmallerThan(undirectedEdge);
    }

    @Test
    public void testHasStartAndEndNode() {
        assertTrue(directedEdge.hasStartAndEndNode(new GqlIdentifier("n1"), new GqlIdentifier("n2")));
        assertFalse(directedEdge.hasStartAndEndNode(new GqlIdentifier("n2"), new GqlIdentifier("n1")));
        assertTrue(undirectedEdge.hasStartAndEndNode(new GqlIdentifier("n1"), new GqlIdentifier("n2")));
        assertFalse(undirectedEdge.hasStartAndEndNode(new GqlIdentifier("n2"), new GqlIdentifier("n1")));
    }

    @Test
    public void testHasEndpoints() {
        assertTrue(directedEdge.hasEndpoints(new GqlIdentifier("n1"), new GqlIdentifier("n2")));
        assertTrue(directedEdge.hasEndpoints(new GqlIdentifier("n1"), new GqlIdentifier("n2")));
        assertTrue(undirectedEdge.hasEndpoints(new GqlIdentifier("n1"), new GqlIdentifier("n2")));
        assertTrue(undirectedEdge.hasEndpoints(new GqlIdentifier("n2"), new GqlIdentifier("n1")));
        assertFalse(directedEdge.hasEndpoints(new GqlIdentifier("n3"), new GqlIdentifier("n2")));
        assertFalse(undirectedEdge.hasEndpoints(new GqlIdentifier("n3"), new GqlIdentifier("n2")));
    }

    @Test
    public void testDirectedEdgeToString() {
        String expected = "{\"identity\": \"test\", \"start\": \"n1\", \"end\": \"n2\", \"isDirected\": 1}";
        assertEquals(expected, directedEdge.toString());
    }

    @Test
    public void testDirectedEdgeWithLabelsToString() {
        String expected = "{\"identity\": \"test\", \"start\": \"n1\", \"end\": \"n2\", \"labels\": [\"Test\", \"Labels\"], \"isDirected\": 1}";
        assertEquals(expected, directedEdgeWithLabels.toString());
    }

    @Test
    public void testDirectedEdgeWithPropertiesToString() {
        String expected = "{\"identity\": \"test\", \"start\": \"n1\", \"end\": \"n2\", \"properties\": {\"age\": 25, \"name\": \"Olof\"}, \"isDirected\": 1}";
        assertEquals(expected, directedEdgeWithProperties.toString());
    }

    @Test
    public void testDirectedEdgeWithLabelsAndPropertiesToString() {
        String expected = "{\"identity\": \"test\", \"start\": \"n1\", \"end\": \"n2\", \"labels\": [\"Test\", \"Labels\"], \"properties\": {\"age\": 25, \"name\": \"Olof\"}, \"isDirected\": 1}";
        assertEquals(expected, directedEdgeWithLabelsAndProperties.toString());
    }

    @Test
    public void testUndirectedEdgeToString() {
        String expected = "{\"identity\": \"test\", \"start\": \"n1\", \"end\": \"n2\", \"isDirected\": 0}";
        assertEquals(expected, undirectedEdge.toString());
    }
}