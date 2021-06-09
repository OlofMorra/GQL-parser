package gql.graphs;

import gql.expressions.GqlId;

import java.util.HashMap;

public class WorkingGraph extends Graph {
    private static WorkingGraph instance;
    public HashMap<GqlId, GqlNode> nodes;
    public HashMap<GqlId, GqlEdge> edges;

    private WorkingGraph() {
        String graphName = getFirstGraphName();
    }

    public static WorkingGraph getInstance() {
        if (instance == null) {
            instance = new WorkingGraph();
        }

        return instance;
    }
}
