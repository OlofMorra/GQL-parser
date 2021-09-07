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

import exceptions.InvalidEdgeFormatException;
import exceptions.InvalidNodeFormatException;
import gql.expressions.values.GqlIdentifier;
import gql.expressions.values.Label;
import gql.expressions.values.Value;
import groovy.lang.Tuple2;
import groovy.lang.Tuple5;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class WorkingGraphTest extends GraphTest{
    @Before
    public void setUpWorkingGraph() {
        this.workingGraph = WorkingGraph.getInstance();
        this.graph = this.workingGraph;
    }

    @Test
    public void testSetEmptyGraph() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        this.workingGraph.setToMainDirectory();
        setEmptyGraphAccessor();

        assertTrue(nodesAreEmpty(this.workingGraph.nodes));
        assertTrue(edgesAreEmpty(this.workingGraph.edges));
    }

    @Test
    public void testSetWorkingGraphToG1() throws InvalidEdgeFormatException, InvalidNodeFormatException {
        this.workingGraph.setToMainDirectory();
        testSetWorkingGraph(transformNodes(getNodesG1()), transformEdges(getEdgesG1()), "g1");
    }

    @Test
    public void testSetWorkingGraphToG2() throws InvalidEdgeFormatException, InvalidNodeFormatException {
        this.workingGraph.setToMainDirectory();
        testSetWorkingGraph(transformNodes(getNodesG2()), transformEdges(getEdgesG2()), "g2");
    }

    @Test
    public void testSetWorkingGraphToG3() throws InvalidEdgeFormatException, InvalidNodeFormatException {
        this.workingGraph.setToMainDirectory();
        testSetWorkingGraph(transformNodes(getNodesG3()), transformEdges(getEdgesG3()), "g3");
    }

    @Test
    public void testInitializeNodesToG1() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        this.workingGraph.setToMainDirectory();
        setEmptyGraphAccessor();
        initializeNodesAccessor("g1");

        isEqualGraph(this.workingGraph, "g1", transformNodes(getNodesG1()), new HashMap<>());
    }

    @Test
    public void testUnequalGraphs() throws InvalidEdgeFormatException, InvalidNodeFormatException {
        this.workingGraph.setToMainDirectory();

        setGraph("g1");
        assertFalse("g1 is equal to g2.", isEqualGraph(this.workingGraph, "g2", transformNodes(getNodesG2()), transformEdges(getEdgesG2())));
        assertFalse("g1 is equal to g3.", isEqualGraph(this.workingGraph, "g3", transformNodes(getNodesG3()), transformEdges(getEdgesG3())));

        setGraph("g2");
        assertFalse("g2 is equal to g1.", isEqualGraph(this.workingGraph, "g1", transformNodes(getNodesG1()), transformEdges(getEdgesG1())));
        assertFalse("g2 is equal to g3.", isEqualGraph(this.workingGraph, "g3", transformNodes(getNodesG3()), transformEdges(getEdgesG3())));

        setGraph("g3");
        assertFalse("g3 is equal to g1.", isEqualGraph(this.workingGraph, "g1", transformNodes(getNodesG1()), transformEdges(getEdgesG1())));
        assertFalse("g3 is equal to g2.", isEqualGraph(this.workingGraph, "g2", transformNodes(getNodesG2()), transformEdges(getEdgesG2())));

        HashMap<GqlIdentifier, GqlNode> g3WithExtraNode = transformNodes(getNodesG3());
        g3WithExtraNode.put(new GqlIdentifier("test"), new GqlNode(new GqlIdentifier("test"), new ArrayList<>(), new HashMap<>()));
        assertFalse("g3 is equal to g3 with an extra node.", isEqualGraph(this.workingGraph, "g3", g3WithExtraNode, transformEdges(getEdgesG3())));

        HashMap<GqlIdentifier, GqlEdge> g3WithExtraEdge = transformEdges(getEdgesG3());
        g3WithExtraEdge.put(new GqlIdentifier("test"), new GqlEdge(new GqlIdentifier("test"), new GqlIdentifier("n19"), new GqlIdentifier("n85"), true, new ArrayList<>(), new HashMap<>()));
        assertFalse("g3 is equal to g3 with an extra edge.", isEqualGraph(this.workingGraph, "g3", transformNodes(getNodesG3()), g3WithExtraEdge));
    }

    @Override
    protected void setEmptyGraphAccessor() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method setEmptyGraph = this.workingGraph.getClass().getDeclaredMethod("setEmptyGraph");
        setEmptyGraph.setAccessible(true);
        setEmptyGraph.invoke(this.workingGraph);
    }

    @Override
    protected void initializeNodesAccessor(String graphName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method initializeNodes = this.workingGraph.getClass().getDeclaredMethod("initializeNodes", String.class);
        initializeNodes.setAccessible(true);
        initializeNodes.invoke(this.workingGraph, new String[]{graphName});
    }

    private boolean nodesAreEmpty(HashMap<GqlIdentifier, GqlNode> nodes) {
        return nodes.equals(new HashMap<GqlIdentifier, GqlNode>());
    }

    private boolean edgesAreEmpty(HashMap<GqlIdentifier, GqlEdge> edges) {
        return edges.equals(new HashMap<GqlIdentifier, GqlEdge>());
    }

    private HashMap<GqlIdentifier, GqlNode> transformNodes(Map<String, Tuple2<ArrayList, Map>> nodes) {
         HashMap<GqlIdentifier, GqlNode> transformedNodes = new HashMap<GqlIdentifier, GqlNode>();

         nodes.forEach((id, values) -> {
             transformNode(transformedNodes, id, values);
         });

         return transformedNodes;
    }

    private void transformNode(HashMap<GqlIdentifier, GqlNode> transformedNodes, String id, Tuple2<ArrayList, Map> values) {
        GqlIdentifier gqlIdentifier = new GqlIdentifier(id);
        ArrayList<Label> labels = transformLabels(values.getFirst());
        HashMap<GqlIdentifier, Value> properties = (HashMap<GqlIdentifier, Value>) values.getSecond();
        GqlNode node = new GqlNode(gqlIdentifier, labels, properties);

        transformedNodes.put(gqlIdentifier, node);
    }

    private HashMap<GqlIdentifier, GqlEdge> transformEdges(Map<String, Tuple5<String, String, ArrayList, Map, Boolean>> edges) {
        HashMap<GqlIdentifier, GqlEdge> transformedEdges = new HashMap<GqlIdentifier, GqlEdge>();

        edges.forEach((id, values) -> {
            transformEdge(transformedEdges, id, values);
        });

        return transformedEdges;
    }

    private void transformEdge(HashMap<GqlIdentifier, GqlEdge> transformedEdges, String id, Tuple5<String, String, ArrayList, Map, Boolean> values) {
        GqlIdentifier gqlIdentifier = new GqlIdentifier(id);
        GqlIdentifier startNode = new GqlIdentifier(values.getFirst());
        GqlIdentifier endNode = new GqlIdentifier(values.getSecond());
        ArrayList<Label> labels = transformLabels(values.getThird());
        HashMap<GqlIdentifier, Value> properties = (HashMap<GqlIdentifier, Value>) values.getFourth();
        GqlEdge edge = new GqlEdge(gqlIdentifier, startNode, endNode, values.getFifth(), labels, properties);

        transformedEdges.put(gqlIdentifier, edge);
    }

    private ArrayList<Label> transformLabels(ArrayList labels) {
        ArrayList<Label> transformedLabels = new ArrayList<>();


        if (labels != null) {
            for (Object label: labels) {
                transformedLabels.add(new Label((String) label));
            }
        }

        return transformedLabels;
    }

    private void testSetWorkingGraph(HashMap<GqlIdentifier, GqlNode> nodes, HashMap<GqlIdentifier, GqlEdge> edges, String graphToCompareTo) throws InvalidEdgeFormatException, InvalidNodeFormatException {
        setGraph(graphToCompareTo);

        assertTrue("Graph " + graphToCompareTo + " is not properly set as working graph.",
                isEqualGraph(this.workingGraph, graphToCompareTo, nodes, edges));
    }

    private boolean isEqualGraph(WorkingGraph workingGraph, String graphName, HashMap<GqlIdentifier, GqlNode> nodes, HashMap<GqlIdentifier, GqlEdge> edges) {
        boolean hasEqualGraphName = workingGraph.currentGraphName.equals(graphName);
        boolean hasEqualNodes = workingGraph.nodes.equals(nodes);
        boolean hasEqualEdges = workingGraph.edges.equals(edges);

        return hasEqualGraphName && hasEqualNodes && hasEqualEdges;
    }

}