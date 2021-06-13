package gql.graphs;

import gql.expressions.GqlId;
import gql.expressions.Label;
import gql.expressions.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class GqlEdge {
    private final GqlId id;
    private final GqlId startNodeId;
    private final GqlId endNodeId;
    private boolean isDirected = true;
    private ArrayList<Label> labels;
    private HashMap<GqlId, Value> properties;

    public GqlEdge(GqlId id, GqlId startNodeId, GqlId endNodeId, boolean isDirected, ArrayList<Label> labels,
                   HashMap<GqlId, Value> properties) {
        this.id = id;
        this.labels = labels;
        this.properties = properties;
        this.startNodeId = startNodeId;
        this.endNodeId = endNodeId;
        this.isDirected = isDirected;
    }

    public GqlId getId() {
        return id;
    }

    public GqlId getStartNodeId() {
        return startNodeId;
    }

    public GqlId getEndNodeId() {
        return endNodeId;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public ArrayList<Label> getLabels() {
        return labels;
    }

    public HashMap<GqlId, Value> getProperties() {
        return properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GqlEdge gqlEdge = (GqlEdge) o;
        return isDirected == gqlEdge.isDirected && id.equals(gqlEdge.id) && startNodeId.equals(gqlEdge.startNodeId)
                && endNodeId.equals(gqlEdge.endNodeId) && Objects.equals(labels, gqlEdge.labels)
                && Objects.equals(properties, gqlEdge.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startNodeId, endNodeId, isDirected, labels, properties);
    }
}
