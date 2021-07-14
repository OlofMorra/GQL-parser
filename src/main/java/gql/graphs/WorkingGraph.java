package gql.graphs;

import exceptions.InvalidEdgeFormatException;
import exceptions.InvalidNodeFormatException;
import exceptions.SemanticErrorException;
import gql.expressions.values.GqlIdentifier;
import json.workinggraph.JsonGraphEvaluator;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class WorkingGraph extends Graph {
    private static WorkingGraph instance;
    public HashMap<GqlIdentifier, GqlNode> nodes;
    public HashMap<GqlIdentifier, GqlEdge> edges;

    private WorkingGraph() {
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

    public static WorkingGraph getInstance() {
        if (instance == null) {
            instance = new WorkingGraph();
        }

        return instance;
    }

    public static GqlGraphElement getGraphElementById(GqlIdentifier identifier) {
        if (instance.nodes.containsKey(identifier)) {
            return instance.nodes.get(identifier);
        } else if (instance.edges.containsKey(identifier)) {
            return instance.edges.get(identifier);
        }

        throw new SemanticErrorException("There is no graph element with id " + identifier.getId() + ".");
    }

    public static String getCurrentGraphName() {
        return instance.currentGraphName;
    }

    @Override
    public void setRemoteGraph() {
        throw new UnsupportedOperationException("setRemoteGraph");
    }

    @Override
    protected void setEmptyGraph() {
        this.nodes = new HashMap<>();
        this.edges = new HashMap<>();
    }

    @Override
    protected void initializeNodes(String graphName) throws FileNotFoundException, InvalidNodeFormatException {
        JsonGraphEvaluator jsonGraphEvaluator = new JsonGraphEvaluator(getGraphDirectory(graphName));
        nodes = jsonGraphEvaluator.getNodes();
    }

    @Override
    protected void intializeEdges(String graphName) throws FileNotFoundException, InvalidEdgeFormatException {
        JsonGraphEvaluator jsonGraphEvaluator = new JsonGraphEvaluator(getGraphDirectory(graphName));
        edges = jsonGraphEvaluator.getEdges(nodes);
    }
}
