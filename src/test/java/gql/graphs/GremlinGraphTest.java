package gql.graphs;

import exceptions.InvalidEdgeFormatException;
import exceptions.InvalidNodeFormatException;
import groovy.lang.Tuple2;
import groovy.lang.Tuple5;
import org.apache.commons.collections.CollectionUtils;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Edge;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.T;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static org.apache.tinkerpop.gremlin.process.traversal.AnonymousTraversalSource.traversal;
import static org.junit.Assert.*;

public class GremlinGraphTest extends GraphTest {
    @Before
    public void setUpGremlingGraph() {
        this.gremlinGraph = GremlinGraph.getInstance();
        this.graph = this.gremlinGraph;
    }

    @Test
    public void testSetEmptyGraph() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        this.gremlinGraph.setToMainDirectory();
        setEmptyGraphAccessor();

        GraphTraversalSource testGraph = getEmptyGraph();

        isEqualGraph(this.gremlinGraph.currentGraph, testGraph);
    }

    @Test
    public void testSetGremlinGraphToG1() throws InvalidEdgeFormatException, InvalidNodeFormatException {
        this.gremlinGraph.setToMainDirectory();
        testSetGremlinGraph(getGraphG1(), "g1");
    }

    @Test
    public void testSetGremlinGraphToG2() throws InvalidEdgeFormatException, InvalidNodeFormatException {
        this.gremlinGraph.setToMainDirectory();
        testSetGremlinGraph(getGraphG2(), "g2");
    }

    @Test
    public void testSetGremlinGraphToG3() throws InvalidEdgeFormatException, InvalidNodeFormatException {
        this.gremlinGraph.setToMainDirectory();
        testSetGremlinGraph(getGraphG3(), "g3");
    }

    @Test
    public void testInitializeNodesToG1() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        this.gremlinGraph.setToMainDirectory();
        setEmptyGraphAccessor();
        initializeNodesAccessor("g1");

        GraphTraversalSource testGraph = getEmptyGraph();
        addNodesToGraph(testGraph, getNodesG1());

        isEqualGraph(this.gremlinGraph.currentGraph, testGraph);
    }

    @Test
    public void testUnequalGraphs() throws InvalidEdgeFormatException, InvalidNodeFormatException {
        this.gremlinGraph.setToMainDirectory();

        setGraph("g1");
        assertFalse("g1 is equal to g2.", isEqualGraph(this.gremlinGraph.currentGraph, getGraphG2()));
        assertFalse("g1 is equal to g3.", isEqualGraph(this.gremlinGraph.currentGraph, getGraphG3()));

        setGraph("g2");
        assertFalse("g2 is equal to g1.", isEqualGraph(this.gremlinGraph.currentGraph, getGraphG1()));
        assertFalse("g2 is equal to g3.", isEqualGraph(this.gremlinGraph.currentGraph, getGraphG3()));

        setGraph("g3");
        assertFalse("g3 is equal to g1.", isEqualGraph(this.gremlinGraph.currentGraph, getGraphG1()));
        assertFalse("g3 is equal to g2.", isEqualGraph(this.gremlinGraph.currentGraph, getGraphG2()));

        GraphTraversalSource g3WithExtraNode = getGraphG3();
        g3WithExtraNode.addV("test").iterate();
        assertFalse("g3 is equal to g3 with an extra node.", isEqualGraph(this.gremlinGraph.currentGraph, g3WithExtraNode));

        GraphTraversalSource g3WithExtraEdge = getGraphG3();
        g3WithExtraEdge.addE("test").from(g3WithExtraEdge.V("n19")).to(g3WithExtraEdge.V("n85")).iterate();
        assertFalse("g3 is equal to g3 with an extra edge.", isEqualGraph(this.gremlinGraph.currentGraph, g3WithExtraEdge));
    }

    @Override
    protected void setEmptyGraphAccessor() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method setEmptyGraph = this.gremlinGraph.getClass().getDeclaredMethod("setEmptyGraph");
        setEmptyGraph.setAccessible(true);
        setEmptyGraph.invoke(this.gremlinGraph);
    }

    @Override
    protected void initializeNodesAccessor(String graphName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method initializeNodes = this.gremlinGraph.getClass().getDeclaredMethod("initializeNodes", String.class);
        initializeNodes.setAccessible(true);
        initializeNodes.invoke(this.gremlinGraph, new String[]{graphName});
    }

    private void testSetGremlinGraph(GraphTraversalSource testGraph, String graphToCompareTo) throws InvalidEdgeFormatException, InvalidNodeFormatException {
        setGraph(graphToCompareTo);

        assertTrue("Graph " + graphToCompareTo + " is not properly set as GremlinGraph.",
                isEqualGraph(this.gremlinGraph.currentGraph, testGraph));
    }

    private boolean isEqualGraph(GraphTraversalSource firstGraph, GraphTraversalSource secondGraph) {
        List<Map<Object, Object>> firstGraphNodes = firstGraph.V().elementMap().toList();
        List<Map<Object, Object>> secondGraphNodes = secondGraph.V().elementMap().toList();
        List<Map<Object, Object>> firstGraphEdges = firstGraph.E().elementMap().toList();
        List<Map<Object, Object>> secondGraphEdges = secondGraph.E().elementMap().toList();

        return CollectionUtils.isEqualCollection(firstGraphNodes, secondGraphNodes)
                && CollectionUtils.isEqualCollection(firstGraphEdges, secondGraphEdges);
    }

    private GraphTraversalSource getGraphG1() {
        GraphTraversalSource testGraph = getEmptyGraph();

        addNodesToGraph(testGraph, getNodesG1());
        addEdgesToGraph(testGraph, getEdgesG1());

        return testGraph;
    }

    private GraphTraversalSource getGraphG2() {
        GraphTraversalSource testGraph = getEmptyGraph();

        addNodesToGraph(testGraph, getNodesG2());
        addEdgesToGraph(testGraph, getEdgesG2());

        return testGraph;
    }

    private GraphTraversalSource getGraphG3() {
        GraphTraversalSource testGraph = getEmptyGraph();

        addNodesToGraph(testGraph, getNodesG3());
        addEdgesToGraph(testGraph, getEdgesG3());

        return testGraph;
    }

    private GraphTraversalSource getEmptyGraph() {
        Graph graph = TinkerGraph.open();
        return traversal().withEmbedded(graph);
    }

    private void addNodesToGraph(GraphTraversalSource graph, Map<String, Tuple2<ArrayList, Map>> nodes) {
        nodes.forEach((id, values) -> {
            addNode(graph, id, values);
        });
    }

    private void addNode(GraphTraversalSource graph, String id, Tuple2<ArrayList, Map> values) {
        GraphTraversal<Vertex, Vertex> pipe = graph.addV().property(T.id, id);

        ArrayList labels = values.getFirst();
        pipe.property("labels", labels);

        Map properties = values.getSecond();
        properties.forEach((propertyId, value) -> {
            pipe.property(propertyId.toString(), value.toString());
        });

        pipe.iterate();
    }

    private void addEdgesToGraph(GraphTraversalSource graph, Map<String, Tuple5<String, String, ArrayList, Map, Boolean>> edges) {
        edges.forEach((id, values) -> {
            addEdge(graph, id, values);
        });
    }

    private void addEdge(GraphTraversalSource graph, String id, Tuple5<String, String, ArrayList, Map, Boolean> values) {
        GraphTraversal<Edge, Edge> pipe = graph.addE("edge").property(T.id, id);

        String sourceNodeId = values.getFirst();
        String targetNodeId = values.getSecond();
        pipe.from(graph.V(sourceNodeId)).to(graph.V(targetNodeId));

        ArrayList labels = values.getThird();
        pipe.property("labels", labels);

        Map properties = values.getFourth();
        properties.forEach((propertyId, value) -> {
            pipe.property(propertyId.toString(), value.toString());
        });

        Boolean isDirected = values.getFifth();
        pipe.property("isDirected", isDirected);

        pipe.iterate();
    }
}