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

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static org.apache.tinkerpop.gremlin.process.traversal.AnonymousTraversalSource.traversal;
import static org.junit.Assert.*;

public class GremlinGraphTest {
    protected GremlinGraph gremlinGraph;
    private final Boolean DIRECTED = true;
    private final Boolean UNDIRECTED = false;

    @Before
    public void setUp() {
        this.gremlinGraph = GremlinGraph.getInstance();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetLocalGraphToNotExistingGraph() throws IllegalArgumentException, FileNotFoundException, InvalidEdgeFormatException, InvalidNodeFormatException {
        this.gremlinGraph.setToTestDirectory();
        this.gremlinGraph.setLocalGraph("notExistingGraph");
    }

    @Test(expected = FileNotFoundException.class)
    public void testSetLocalGraphToEmptyGraph() throws FileNotFoundException, InvalidEdgeFormatException, InvalidNodeFormatException {
        this.gremlinGraph.setToTestDirectory();
        this.gremlinGraph.setLocalGraph("graphEmpty");
    }

    @Test(expected = FileNotFoundException.class)
    public void testSetLocalGraphWithoutEdges() throws FileNotFoundException, InvalidEdgeFormatException, InvalidNodeFormatException {
        this.gremlinGraph.setToTestDirectory();
        this.gremlinGraph.setLocalGraph("graphWithoutEdges");
    }

    @Test(expected = FileNotFoundException.class)
    public void testSetLocalGraphWithoutNodes() throws FileNotFoundException, InvalidEdgeFormatException, InvalidNodeFormatException {
        this.gremlinGraph.setToTestDirectory();
        this.gremlinGraph.setLocalGraph("graphWithoutNodes");
    }

    @Test(expected = InvalidEdgeFormatException.class)
    public void testSetLocalGraphWithEdgeWithNotExistingStartNode() throws FileNotFoundException, InvalidEdgeFormatException, InvalidNodeFormatException {
        this.gremlinGraph.setToTestDirectory();
        this.gremlinGraph.setLocalGraph("edgeWithNotExistingStartNode");
    }

    @Test(expected = InvalidEdgeFormatException.class)
    public void testSetLocalGraphWithEdgeWithNotExistingEndNode() throws FileNotFoundException, InvalidEdgeFormatException, InvalidNodeFormatException {
        this.gremlinGraph.setToTestDirectory();
        this.gremlinGraph.setLocalGraph("edgeWithNotExistingEndNode");
    }

    @Test
    public void testSetEmptyGraph() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        this.gremlinGraph.setToMainDirectory();
        setEmptyGraphAccessor();

        GraphTraversalSource testGraph = getEmptyGraph();

        isEqualGraph(this.gremlinGraph.currentGraph, testGraph);
    }

    @Test
    public void testSetWorkingGraphToG1() throws InvalidEdgeFormatException, InvalidNodeFormatException {
        this.gremlinGraph.setToMainDirectory();
        testSetWorkingGraph(getGraphG1(), "g1");
    }

    @Test
    public void testSetWorkingGraphToG2() throws InvalidEdgeFormatException, InvalidNodeFormatException {
        this.gremlinGraph.setToMainDirectory();
        testSetWorkingGraph(getGraphG2(), "g2");
    }

    @Test
    public void testSetWorkingGraphToG3() throws InvalidEdgeFormatException, InvalidNodeFormatException {
        this.gremlinGraph.setToMainDirectory();
        testSetWorkingGraph(getGraphG3(), "g3");
    }

    @Test
    public void testInitializeNodesToG1() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        this.gremlinGraph.setToMainDirectory();
        setEmptyGraphAccessor();
        initializeNodesAccessor("g1");

        GraphTraversalSource testGraph = getEmptyGraph();
        addNodesG1(testGraph);

        isEqualGraph(this.gremlinGraph.currentGraph, testGraph);
    }

    @Test
    public void testUnequalGraphs() throws InvalidEdgeFormatException, InvalidNodeFormatException {
        this.gremlinGraph.setToMainDirectory();

        setWorkingGraph("g1");
        assertFalse("g1 is equal to g2.", isEqualGraph(this.gremlinGraph.currentGraph, getGraphG2()));
        assertFalse("g1 is equal to g3.", isEqualGraph(this.gremlinGraph.currentGraph, getGraphG3()));

        setWorkingGraph("g2");
        assertFalse("g2 is equal to g1.", isEqualGraph(this.gremlinGraph.currentGraph, getGraphG1()));
        assertFalse("g2 is equal to g3.", isEqualGraph(this.gremlinGraph.currentGraph, getGraphG3()));

        setWorkingGraph("g3");
        assertFalse("g3 is equal to g1.", isEqualGraph(this.gremlinGraph.currentGraph, getGraphG1()));
        assertFalse("g3 is equal to g2.", isEqualGraph(this.gremlinGraph.currentGraph, getGraphG2()));

        GraphTraversalSource g3WithExtraNode = getGraphG3();
        g3WithExtraNode.addV("test").iterate();
        assertFalse("g3 is equal to g3 with an extra node.", isEqualGraph(this.gremlinGraph.currentGraph, g3WithExtraNode));

        GraphTraversalSource g3WithExtraEdge = getGraphG3();
        g3WithExtraEdge.addE("test").from(g3WithExtraEdge.V("n19")).to(g3WithExtraEdge.V("n85")).iterate();
        assertFalse("g3 is equal to g3 with an extra edge.", isEqualGraph(this.gremlinGraph.currentGraph, g3WithExtraEdge));
    }

    private void testSetWorkingGraph(GraphTraversalSource testGraph, String graphToCompareTo) throws InvalidEdgeFormatException, InvalidNodeFormatException {
        setWorkingGraph(graphToCompareTo);

        assertTrue("Graph " + graphToCompareTo + " is not properly set as working graph.",
                isEqualGraph(this.gremlinGraph.currentGraph, testGraph));
    }

    private void setEmptyGraphAccessor() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method setEmptyGraph = this.gremlinGraph.getClass().getDeclaredMethod("setEmptyGraph");
        setEmptyGraph.setAccessible(true);
        setEmptyGraph.invoke(this.gremlinGraph);
    }

    private void initializeNodesAccessor(String graphName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method initializeNodes = this.gremlinGraph.getClass().getDeclaredMethod("initializeNodes", String.class);
        initializeNodes.setAccessible(true);
        initializeNodes.invoke(this.gremlinGraph, new String[]{graphName});
    }

    private void setWorkingGraph(String graphToCompareTo) throws InvalidEdgeFormatException, InvalidNodeFormatException {
        try {
            this.gremlinGraph.setLocalGraph(graphToCompareTo);
        } catch (FileNotFoundException exception) {
            System.err.println("Graph " + graphToCompareTo + " was not complete, i.e. missing nodes.json or edges.json.");
        } catch (NullPointerException exception) {
            System.err.println(exception.getMessage());
        }
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

        addNodesG1(testGraph);

        Map<String, Tuple5<String, String, ArrayList, Map, Boolean>> edges = new HashMap<>();
        edges.put("e2", new Tuple5<>("n85", "n5", null, new HashMap(), DIRECTED));
        edges.put("e3", new Tuple5<>("n85", "n19", null, new HashMap(), DIRECTED));
        edges.put("e12", new Tuple5<>("n19", "n85", null, new HashMap(), DIRECTED));
        edges.put("e21", new Tuple5<>("n29", "n19", null, new HashMap(), UNDIRECTED));
        edges.put("e86", new Tuple5<>("n19", "n5", null, new HashMap(), DIRECTED));

        addEdgesToGraph(testGraph, edges);

        return testGraph;
    }

    private void addNodesG1(GraphTraversalSource testGraph) {
        Map<String, Tuple2<ArrayList, Map>> nodes = new HashMap<>();
        nodes.put("n5", new Tuple2<>(null, new HashMap()));
        nodes.put("n19", new Tuple2<>(null, new HashMap()));
        nodes.put("n29", new Tuple2<>(null, new HashMap()));
        nodes.put("n85", new Tuple2<>(null, new HashMap()));

        addNodesToGraph(testGraph, nodes);
    }

    private GraphTraversalSource getGraphG2() {
        GraphTraversalSource testGraph = getEmptyGraph();

        ArrayList personLabel = getLabels(new String[]{"Person"});
        ArrayList internshipLabel = getLabels(new String[]{"Internship"});

        Map<String, Tuple2<ArrayList, Map>> nodes = new HashMap<>();
        nodes.put("n5", new Tuple2<>(internshipLabel, new HashMap()));
        nodes.put("n19", new Tuple2<>(personLabel, new HashMap()));
        nodes.put("n29", new Tuple2<>(personLabel, new HashMap()));
        nodes.put("n85", new Tuple2<>(personLabel, new HashMap()));

        addNodesToGraph(testGraph, nodes);

        ArrayList doesLabel = getLabels(new String[]{"Does"});
        ArrayList learnsFromLabel = getLabels(new String[]{"LearnsFrom"});
        ArrayList teachesLabel = getLabels(new String[]{"Teaches"});
        ArrayList areColleaguesLabel = getLabels(new String[]{"AreColleagues"});
        ArrayList supervisesLabel = getLabels(new String[]{"Supervises"});

        Map<String, Tuple5<String, String, ArrayList, Map, Boolean>> edges = new HashMap<>();
        edges.put("e2", new Tuple5<>("n85", "n5", doesLabel, new HashMap(), DIRECTED));
        edges.put("e3", new Tuple5<>("n85", "n19", learnsFromLabel, new HashMap(), DIRECTED));
        edges.put("e12", new Tuple5<>("n19", "n85", teachesLabel, new HashMap(), DIRECTED));
        edges.put("e21", new Tuple5<>("n29", "n19", areColleaguesLabel, new HashMap(), UNDIRECTED));
        edges.put("e86", new Tuple5<>("n19", "n5", supervisesLabel, new HashMap(), DIRECTED));

        addEdgesToGraph(testGraph, edges);

        return testGraph;
    }

    private GraphTraversalSource getGraphG3() {
        GraphTraversalSource testGraph = getEmptyGraph();

        ArrayList personLabel = getLabels(new String[]{"Person"});
        ArrayList professorLabel = getLabels(new String[]{"Person", "Professor"});
        ArrayList internshipLabel = getLabels(new String[]{"Internship"});
        Map georgeProperties = new HashMap() {
            {
                put("name", "George Fletcher");
                put("employer", "TU/e");
            }
        };
        Map michaelProperties = new HashMap() {
            {
                put("name", "Michael Schmidt");
                put("employer", "Amazon");
            }
        };
        Map olofProperties = new HashMap() {
            {
                put("name", "Olof Morra");
                put("studies", "Data Science");
            }
        };

        Map<String, Tuple2<ArrayList, Map>> nodes = new HashMap<>();
        nodes.put("n5", new Tuple2<>(internshipLabel, new HashMap()));
        nodes.put("n19", new Tuple2<>(professorLabel, georgeProperties));
        nodes.put("n29", new Tuple2<>(personLabel, michaelProperties));
        nodes.put("n85", new Tuple2<>(personLabel, olofProperties));

        addNodesToGraph(testGraph, nodes);

        ArrayList doesLabel = getLabels(new String[]{"Does"});
        ArrayList learnsFromLabel = getLabels(new String[]{"LearnsFrom"});
        ArrayList teachesLabel = getLabels(new String[]{"Teaches"});
        ArrayList areColleaguesLabel = getLabels(new String[]{"AreColleagues"});
        ArrayList supervisesLabel = getLabels(new String[]{"Supervises"});
        Map doesProperties = new HashMap() {
            {
                put("in_semester", 2);
            }
        };

        Map<String, Tuple5<String, String, ArrayList, Map, Boolean>> edges = new HashMap<>();
        edges.put("e2", new Tuple5<>("n85", "n5", doesLabel, doesProperties, DIRECTED));
        edges.put("e3", new Tuple5<>("n85", "n19", learnsFromLabel, new HashMap(), DIRECTED));
        edges.put("e12", new Tuple5<>("n19", "n85", teachesLabel, new HashMap(), DIRECTED));
        edges.put("e21", new Tuple5<>("n29", "n19", areColleaguesLabel, new HashMap(), UNDIRECTED));
        edges.put("e86", new Tuple5<>("n19", "n5", supervisesLabel, new HashMap(), DIRECTED));
        addEdgesToGraph(testGraph, edges);

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
        properties.forEach(pipe::property);

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
        properties.forEach(pipe::property);

        Boolean isDirected = values.getFifth();
        pipe.property("isDirected", isDirected);

        pipe.iterate();
    }

    private ArrayList getLabels(String[] labels) {
        return new ArrayList(Arrays.asList(labels));
    }
}