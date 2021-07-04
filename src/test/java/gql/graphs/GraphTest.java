package gql.graphs;

import exceptions.InvalidEdgeFormatException;
import exceptions.InvalidNodeFormatException;
import gql.expressions.FixedPointNumber;
import gql.expressions.GqlIdentifier;
import gql.expressions.GqlString;
import groovy.lang.Tuple2;
import groovy.lang.Tuple5;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class GraphTest {
    protected final Boolean DIRECTED = true;
    protected final Boolean UNDIRECTED = false;
    protected Graph graph;
    protected GremlinGraph gremlinGraph;
    protected WorkingGraph workingGraph;

    protected abstract void setEmptyGraphAccessor() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
    protected abstract void initializeNodesAccessor(String graphName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;

    @Test(expected = IllegalArgumentException.class)
    public void testSetLocalGraphToNotExistingGraph() throws IllegalArgumentException, FileNotFoundException, InvalidEdgeFormatException, InvalidNodeFormatException {
        this.graph.setToTestDirectory();
        this.graph.setLocalGraph("notExistingGraph");
    }

    @Test(expected = FileNotFoundException.class)
    public void testSetLocalGraphToEmptyGraph() throws FileNotFoundException, InvalidEdgeFormatException, InvalidNodeFormatException {
        this.graph.setToTestDirectory();
        this.graph.setLocalGraph("graphEmpty");
    }

    @Test(expected = FileNotFoundException.class)
    public void testSetLocalGraphWithoutEdges() throws FileNotFoundException, InvalidEdgeFormatException, InvalidNodeFormatException {
        this.graph.setToTestDirectory();
        this.graph.setLocalGraph("graphWithoutEdges");
    }

    @Test(expected = FileNotFoundException.class)
    public void testSetLocalGraphWithoutNodes() throws FileNotFoundException, InvalidEdgeFormatException, InvalidNodeFormatException {
        this.graph.setToTestDirectory();
        this.graph.setLocalGraph("graphWithoutNodes");
    }

    @Test(expected = InvalidEdgeFormatException.class)
    public void testSetLocalGraphWithEdgeWithNotExistingStartNode() throws FileNotFoundException, InvalidEdgeFormatException, InvalidNodeFormatException {
        this.graph.setToTestDirectory();
        this.graph.setLocalGraph("edgeWithNotExistingStartNode");
    }

    @Test(expected = InvalidEdgeFormatException.class)
    public void testSetLocalGraphWithEdgeWithNotExistingEndNode() throws FileNotFoundException, InvalidEdgeFormatException, InvalidNodeFormatException {
        this.graph.setToTestDirectory();
        this.graph.setLocalGraph("edgeWithNotExistingEndNode");
    }

    protected void setGraph(String graphToCompareTo) throws InvalidEdgeFormatException, InvalidNodeFormatException {
        try {
            this.graph.setToMainDirectory();
            this.graph.setLocalGraph(graphToCompareTo);
        } catch (FileNotFoundException exception) {
            System.err.println("Graph " + graphToCompareTo + " was not complete, i.e. missing nodes.json or edges.json.");
        } catch (NullPointerException exception) {
            System.err.println("Error setting graph to " + graphToCompareTo +": " + exception.getMessage());
        }
    }

    protected Map<String, Tuple2<ArrayList, Map>> getNodesG1() {
        Map<String, Tuple2<ArrayList, Map>> nodes = new HashMap<>();
        nodes.put("n5", new Tuple2<>(null, new HashMap()));
        nodes.put("n19", new Tuple2<>(null, new HashMap()));
        nodes.put("n29", new Tuple2<>(null, new HashMap()));
        nodes.put("n85", new Tuple2<>(null, new HashMap()));

        return nodes;
    }

    protected Map<String, Tuple5<String, String, ArrayList, Map, Boolean>> getEdgesG1() {
        Map<String, Tuple5<String, String, ArrayList, Map, Boolean>> edges = new HashMap<>();
        edges.put("e2", new Tuple5<>("n85", "n5", null, new HashMap(), DIRECTED));
        edges.put("e3", new Tuple5<>("n85", "n19", null, new HashMap(), DIRECTED));
        edges.put("e12", new Tuple5<>("n19", "n85", null, new HashMap(), DIRECTED));
        edges.put("e21", new Tuple5<>("n29", "n19", null, new HashMap(), UNDIRECTED));
        edges.put("e86", new Tuple5<>("n19", "n5", null, new HashMap(), DIRECTED));

        return edges;
    }

    protected Map<String, Tuple2<ArrayList, Map>> getNodesG2() {
        ArrayList personLabel = getLabelsAsList(new String[]{"Person"});
        ArrayList internshipLabel = getLabelsAsList(new String[]{"Internship"});

        Map<String, Tuple2<ArrayList, Map>> nodes = new HashMap<>();
        nodes.put("n5", new Tuple2<>(internshipLabel, new HashMap()));
        nodes.put("n19", new Tuple2<>(personLabel, new HashMap()));
        nodes.put("n29", new Tuple2<>(personLabel, new HashMap()));
        nodes.put("n85", new Tuple2<>(personLabel, new HashMap()));

        return nodes;
    }

    protected Map<String, Tuple5<String, String, ArrayList, Map, Boolean>> getEdgesG2() {
        ArrayList doesLabel = getLabelsAsList(new String[]{"Does"});
        ArrayList learnsFromLabel = getLabelsAsList(new String[]{"LearnsFrom"});
        ArrayList teachesLabel = getLabelsAsList(new String[]{"Teaches"});
        ArrayList areColleaguesLabel = getLabelsAsList(new String[]{"AreColleagues"});
        ArrayList supervisesLabel = getLabelsAsList(new String[]{"Supervises"});

        Map<String, Tuple5<String, String, ArrayList, Map, Boolean>> edges = new HashMap<>();
        edges.put("e2", new Tuple5<>("n85", "n5", doesLabel, new HashMap(), DIRECTED));
        edges.put("e3", new Tuple5<>("n85", "n19", learnsFromLabel, new HashMap(), DIRECTED));
        edges.put("e12", new Tuple5<>("n19", "n85", teachesLabel, new HashMap(), DIRECTED));
        edges.put("e21", new Tuple5<>("n29", "n19", areColleaguesLabel, new HashMap(), UNDIRECTED));
        edges.put("e86", new Tuple5<>("n19", "n5", supervisesLabel, new HashMap(), DIRECTED));

        return edges;
    }

    protected Map<String, Tuple2<ArrayList, Map>> getNodesG3() {
        ArrayList personLabel = getLabelsAsList(new String[]{"Person"});
        ArrayList professorLabel = getLabelsAsList(new String[]{"Person", "Professor"});
        ArrayList internshipLabel = getLabelsAsList(new String[]{"Internship"});
        Map georgeProperties = new HashMap() {
            {
                put(new GqlIdentifier("name"), new GqlString("George Fletcher"));
                put(new GqlIdentifier("employer"), new GqlString("TU/e"));
            }
        };
        Map michaelProperties = new HashMap() {
            {
                put(new GqlIdentifier("name"), new GqlString("Michael Schmidt"));
                put(new GqlIdentifier("employer"), new GqlString("Amazon"));
            }
        };
        Map olofProperties = new HashMap() {
            {
                put(new GqlIdentifier("name"), new GqlString("Olof Morra"));
                put(new GqlIdentifier("studies"), new GqlString("Data Science"));
            }
        };

        Map<String, Tuple2<ArrayList, Map>> nodes = new HashMap<>();
        nodes.put("n5", new Tuple2<>(internshipLabel, new HashMap()));
        nodes.put("n19", new Tuple2<>(professorLabel, georgeProperties));
        nodes.put("n29", new Tuple2<>(personLabel, michaelProperties));
        nodes.put("n85", new Tuple2<>(personLabel, olofProperties));

        return nodes;
    }

    protected Map<String, Tuple5<String, String, ArrayList, Map, Boolean>> getEdgesG3() {
        ArrayList doesLabel = getLabelsAsList(new String[]{"Does"});
        ArrayList learnsFromLabel = getLabelsAsList(new String[]{"LearnsFrom"});
        ArrayList teachesLabel = getLabelsAsList(new String[]{"Teaches"});
        ArrayList areColleaguesLabel = getLabelsAsList(new String[]{"AreColleagues"});
        ArrayList supervisesLabel = getLabelsAsList(new String[]{"Supervises"});
        Map doesProperties = new HashMap() {
            {
                put(new GqlIdentifier("in_semester"), new FixedPointNumber("2"));
            }
        };

        Map<String, Tuple5<String, String, ArrayList, Map, Boolean>> edges = new HashMap<>();
        edges.put("e2", new Tuple5<>("n85", "n5", doesLabel, doesProperties, DIRECTED));
        edges.put("e3", new Tuple5<>("n85", "n19", learnsFromLabel, new HashMap(), DIRECTED));
        edges.put("e12", new Tuple5<>("n19", "n85", teachesLabel, new HashMap(), DIRECTED));
        edges.put("e21", new Tuple5<>("n29", "n19", areColleaguesLabel, new HashMap(), UNDIRECTED));
        edges.put("e86", new Tuple5<>("n19", "n5", supervisesLabel, new HashMap(), DIRECTED));

        return edges;
    }

    private ArrayList getLabelsAsList(String[] labels) {
        return new ArrayList(Arrays.asList(labels));
    }
}
