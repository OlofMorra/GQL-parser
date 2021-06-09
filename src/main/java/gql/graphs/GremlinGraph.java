package gql.graphs;

import exceptions.InvalidEdgeFormatException;
import exceptions.InvalidNodeFormatException;
import json.gremlin.EdgeParser;
import json.gremlin.JsonEdge;
import json.gremlin.JsonNode;
import json.gremlin.NodeParser;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Edge;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.T;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import static org.apache.tinkerpop.gremlin.process.traversal.AnonymousTraversalSource.traversal;

public class GremlinGraph extends gql.graphs.Graph {
    private static GremlinGraph instance;
    public GraphTraversalSource currentGraph;

    private GremlinGraph() {
        String graphName = getFirstGraphName();
        try {
            setLocalGraph(graphName);
            currentGraphName = graphName;
        } catch (FileNotFoundException | InvalidEdgeFormatException | InvalidNodeFormatException exception) {
            setEmptyGraph();
            currentGraphName = "The empty graph";
            System.out.println("First graph is not complete, so initialize to an empty graph");
        }
    }

    public static GremlinGraph getInstance() {
        if (instance == null) {
            instance = new GremlinGraph();
        }

        return instance;
    }

    public void setLocalGraph(String graphName) throws IllegalArgumentException, FileNotFoundException, InvalidNodeFormatException, InvalidEdgeFormatException {
        if (graphNotExists(graphName)) {
            throw new IllegalArgumentException("There is no graph directory \"" + graphName + "\".");
        } else if (graphNotComplete(graphName)) {
            throw new FileNotFoundException("Directory database/" + graphName + " needs to have a node.json and edgePattern.json file.");
        }

        setEmptyGraph();

        initializeNodes(graphName);
        intializeEdges(graphName);

        currentGraphName = graphName;
    }

    public void setRemoteGraph() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void setEmptyGraph() {
        Graph graph = TinkerGraph.open();
        this.currentGraph = traversal().withEmbedded(graph);
    }

    private boolean graphNotExists(String graphName) {
        ArrayList<String> graphDirectories = getAvailableGraphNames();

        return !graphDirectories.contains(graphName);
    }

    private boolean graphNotComplete(String graphName) {
        File graphDirectory = getGraphDirectory(graphName);
        ArrayList<String> graphFileNames = new ArrayList<>(Arrays.asList(graphDirectory.list()));

        return !(graphFileNames.contains("nodes.json") && graphFileNames.contains("edges.json"));
    }

    private void initializeNodes(String graphName) throws InvalidNodeFormatException, FileNotFoundException {
        NodeParser nodeParser = new NodeParser(getGraphDirectory(graphName) + "/nodes.json");
        ArrayList<JsonNode> jsonNodes = nodeParser.getNodes();

        for (JsonNode node:jsonNodes) {
            addNodeToCurrentGraph(node);
        }
    }

    private void intializeEdges(String graphName) throws FileNotFoundException, InvalidEdgeFormatException {
        EdgeParser edgeParser = new EdgeParser(getGraphDirectory(graphName) + "/edges.json");
        ArrayList<JsonEdge> jsonEdges = edgeParser.getEdges();

        for (JsonEdge edge: jsonEdges) {
            checkIfEdgeIsConnected(edge);
        }

        jsonEdges.forEach(this::addEdgeToCurrentGraph);
    }

    private void addNodeToCurrentGraph(JsonNode node) {
        String id = node.identity;
        GraphTraversal<Vertex, Vertex> pipe = this.currentGraph.addV().property(T.id, id);

        if (!(node.labels == null)) {
            pipe.property("labels", node.labels.clone());
        }

        if (!(node.properties == null)) {
            Map<String, Object> properties = node.properties;
            properties.forEach(pipe::property);
        }

        pipe.iterate();
    }

    private void checkIfEdgeIsConnected(JsonEdge edge) throws InvalidEdgeFormatException {
        if (nodeDoesNotExist(edge.start)) {
            throw new InvalidEdgeFormatException("Edge " + edge.identity + " start node does not exist.");
        } else if (nodeDoesNotExist(edge.end)) {
            throw new InvalidEdgeFormatException("Edge " + edge.identity + " start node does not exist.");
        }
    }

    private boolean nodeDoesNotExist(String start) {
        return !this.currentGraph.V(start).hasNext();
    }

    private void addEdgeToCurrentGraph(JsonEdge edge) {
        String id = edge.identity;
        GraphTraversal<Edge, Edge> pipe = this.currentGraph.addE("edge").property(T.id, id);

        String sourceNodeId = edge.start;
        String targetNodeId = edge.end;
        pipe.from(this.currentGraph.V(sourceNodeId)).to(this.currentGraph.V(targetNodeId));

        if (!(edge.labels == null)) {
            pipe.property("labels", edge.labels.clone());
        }

        if (!(edge.properties == null)) {
            Map<String, Object> properties = edge.properties;
            properties.forEach(pipe::property);
        }

        pipe.property("isDirected", edge.isDirected);

        pipe.iterate();
    }
}
