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

import static org.junit.Assert.assertEquals;

public class GqlNodeTest {
    ArrayList<Label> labels = new ArrayList<Label>(Arrays.asList(
            new Label("Test"),
            new Label("Labels")
    ));

    HashMap<GqlIdentifier, Value> properties = new HashMap<>();

    GqlNode nodeWithoutLabelsAndProperties = new GqlNode(new GqlIdentifier("n1"), new ArrayList<>(), new HashMap<>());
    GqlNode nodeWithoutLabelsAndProperties2 = new GqlNode(new GqlIdentifier("n1"), new ArrayList<>(), new HashMap<>());
    GqlNode nodeWithLabels = new GqlNode(new GqlIdentifier("n1"), labels, new HashMap<>());
    GqlNode nodeWithProperties = new GqlNode(new GqlIdentifier("n1"), new ArrayList<>(), new HashMap<>());
    GqlNode nodeWithLabelsAndProperties = new GqlNode(new GqlIdentifier("n1"), labels, new HashMap<>());


    @Before
    public void setUp() {
        properties.put(new GqlIdentifier("age"), new FixedPointNumber("25"));
        properties.put(new GqlIdentifier("name"), new GqlString("Olof"));

        nodeWithProperties.properties = properties;
        nodeWithLabelsAndProperties.properties = properties;
    }

    @Test(expected = SemanticErrorException.class)
    public void testIsSmallerOrEqualThan() {
        nodeWithProperties.isSmallerOrEqualThan(nodeWithLabels);
    }

    @Test(expected = SemanticErrorException.class)
    public void testIsLargerThan() {
        nodeWithProperties.isLargerThan(nodeWithLabels);
    }

    @Test(expected = SemanticErrorException.class)
    public void testIsLargerOrEqualThan() {
        nodeWithProperties.isLargerOrEqualThan(nodeWithLabels);
    }

    @Test
    public void testIsEqualTo() {
        assertEquals(new TruthValue(true), nodeWithoutLabelsAndProperties.isEqualTo(nodeWithoutLabelsAndProperties2));
        assertEquals(new TruthValue(false), nodeWithoutLabelsAndProperties.isEqualTo(nodeWithLabels));
        assertEquals(new TruthValue(false), nodeWithoutLabelsAndProperties.isEqualTo(nodeWithProperties));
        assertEquals(new TruthValue(false), nodeWithoutLabelsAndProperties.isEqualTo(nodeWithLabelsAndProperties));
    }

    @Test(expected = SemanticErrorException.class)
    public void testIsSmallerThan() {
        nodeWithProperties.isSmallerThan(nodeWithLabels);
    }

    @Test
    public void testNodeWithoutLabelsAndPropertiesToString() {
        String expected = "{\"identity\": \"n1\"}";
        assertEquals(expected, nodeWithoutLabelsAndProperties.toString());
    }

    @Test
    public void testNodeWithPropertiesToString() {
        String expected = "{\"identity\": \"n1\", \"properties\": {\"age\": 25, \"name\": \"Olof\"}}";
        assertEquals(expected, nodeWithProperties.toString());
    }

    @Test
    public void testNodeWithLabelsToString() {
        String expected = "{\"identity\": \"n1\", \"labels\": [\"Test\", \"Labels\"]}";
        assertEquals(expected, nodeWithLabels.toString());
    }

    @Test
    public void testNodeWithLabelsAndPropertiesToString() {
        String expected = "{\"identity\": \"n1\", \"labels\": [\"Test\", \"Labels\"], \"properties\": {\"age\": 25, \"name\": \"Olof\"}}";
        assertEquals(expected, nodeWithLabelsAndProperties.toString());
    }
}