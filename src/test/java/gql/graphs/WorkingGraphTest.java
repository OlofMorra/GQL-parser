package gql.graphs;

import exceptions.InvalidEdgeFormatException;
import exceptions.InvalidNodeFormatException;
import gql.expressions.GqlId;
import gql.expressions.Label;
import gql.expressions.Value;
import groovy.lang.Tuple2;
import groovy.lang.Tuple5;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
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

        HashMap<GqlId, GqlNode> g3WithExtraNode = transformNodes(getNodesG3());
        g3WithExtraNode.put(new GqlId("test"), new GqlNode(new GqlId("test"), new ArrayList<>(), new HashMap<>()));
        assertFalse("g3 is equal to g3 with an extra node.", isEqualGraph(this.workingGraph, "g3", g3WithExtraNode, transformEdges(getEdgesG3())));

        HashMap<GqlId, GqlEdge> g3WithExtraEdge = transformEdges(getEdgesG3());
        g3WithExtraEdge.put(new GqlId("test"), new GqlEdge(new GqlId("test"), new GqlId("n19"), new GqlId("n85"), true, new ArrayList<>(), new HashMap<>()));
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

    private boolean nodesAreEmpty(HashMap<GqlId, GqlNode> nodes) {
        return nodes.equals(new HashMap<GqlId, GqlNode>());
    }

    private boolean edgesAreEmpty(HashMap<GqlId, GqlEdge> edges) {
        return edges.equals(new HashMap<GqlId, GqlEdge>());
    }

    private HashMap<GqlId, GqlNode> transformNodes(Map<String, Tuple2<ArrayList, Map>> nodes) {
         HashMap<GqlId, GqlNode> transformedNodes = new HashMap<GqlId, GqlNode>();

         nodes.forEach((id, values) -> {
             transformNode(transformedNodes, id, values);
         });

         return transformedNodes;
    }

    private void transformNode(HashMap<GqlId, GqlNode> transformedNodes, String id, Tuple2<ArrayList, Map> values) {
        GqlId gqlId = new GqlId(id);
        ArrayList<Label> labels = transformLabels(values.getFirst());
        HashMap<GqlId, Value> properties = (HashMap<GqlId, Value>) values.getSecond();
        GqlNode node = new GqlNode(gqlId, labels, properties);

        transformedNodes.put(gqlId, node);
    }

    private HashMap<GqlId, GqlEdge> transformEdges(Map<String, Tuple5<String, String, ArrayList, Map, Boolean>> edges) {
        HashMap<GqlId, GqlEdge> transformedEdges = new HashMap<GqlId, GqlEdge>();

        edges.forEach((id, values) -> {
            transformEdge(transformedEdges, id, values);
        });

        return transformedEdges;
    }

    private void transformEdge(HashMap<GqlId, GqlEdge> transformedEdges, String id, Tuple5<String, String, ArrayList, Map, Boolean> values) {
        GqlId gqlId = new GqlId(id);
        GqlId startNode = new GqlId(values.getFirst());
        GqlId endNode = new GqlId(values.getSecond());
        ArrayList<Label> labels = transformLabels(values.getThird());
        HashMap<GqlId, Value> properties = (HashMap<GqlId, Value>) values.getFourth();
        GqlEdge edge = new GqlEdge(gqlId, startNode, endNode, values.getFifth(), labels, properties);

        transformedEdges.put(gqlId, edge);
    }

    private ArrayList<Label> transformLabels(ArrayList labels) {
        ArrayList<Label> transformedLabels = new ArrayList<>();


        if (labels != null) {
            for (Object label: labels) {
                transformedLabels.add(new Label(new GqlId((String) label)));
            }
        }

        return transformedLabels;
    }

    private void testSetWorkingGraph(HashMap<GqlId, GqlNode> nodes, HashMap<GqlId, GqlEdge> edges, String graphToCompareTo) throws InvalidEdgeFormatException, InvalidNodeFormatException {
        setGraph(graphToCompareTo);

        assertTrue("Graph " + graphToCompareTo + " is not properly set as working graph.",
                isEqualGraph(this.workingGraph, graphToCompareTo, nodes, edges));
    }

    private boolean isEqualGraph(WorkingGraph workingGraph, String graphName, HashMap<GqlId, GqlNode> nodes, HashMap<GqlId, GqlEdge> edges) {
        boolean hasEqualGraphName = workingGraph.currentGraphName.equals(graphName);
        boolean hasEqualNodes = workingGraph.nodes.equals(nodes);
        boolean hasEqualEdges = workingGraph.edges.equals(edges);

        return hasEqualGraphName && hasEqualNodes && hasEqualEdges;
    }

}