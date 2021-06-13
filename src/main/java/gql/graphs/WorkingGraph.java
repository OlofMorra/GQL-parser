package gql.graphs;

import exceptions.InvalidEdgeFormatException;
import exceptions.InvalidNodeFormatException;
import gql.expressions.GqlId;
import json.workinggraph.JsonGraphEvaluator;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class WorkingGraph extends Graph {
    private static WorkingGraph instance;
    public HashMap<GqlId, GqlNode> nodes;
    public HashMap<GqlId, GqlEdge> edges;

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
