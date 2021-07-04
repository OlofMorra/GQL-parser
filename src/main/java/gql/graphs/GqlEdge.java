package gql.graphs;

import gql.expressions.GqlIdentifier;
import gql.expressions.Label;
import gql.expressions.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class GqlEdge {
    private final GqlIdentifier id;
    private final GqlIdentifier startNodeId;
    private final GqlIdentifier endNodeId;
    private boolean isDirected = true;
    private ArrayList<Label> labels;
    private HashMap<GqlIdentifier, Value> properties;

    public GqlEdge(GqlIdentifier id, GqlIdentifier startNodeId, GqlIdentifier endNodeId, boolean isDirected, ArrayList<Label> labels,
                   HashMap<GqlIdentifier, Value> properties) {
        this.id = id;
        this.labels = labels;
        this.properties = properties;
        this.startNodeId = startNodeId;
        this.endNodeId = endNodeId;
        this.isDirected = isDirected;
    }

    public GqlIdentifier getId() {
        return id;
    }

    public GqlIdentifier getStartNodeId() {
        return startNodeId;
    }

    public GqlIdentifier getEndNodeId() {
        return endNodeId;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public ArrayList<Label> getLabels() {
        return labels;
    }

    public HashMap<GqlIdentifier, Value> getProperties() {
        return properties;
    }

    public boolean hasStartAndEndNode(GqlIdentifier startNodeId, GqlIdentifier endNodeId) {
        return this.startNodeId.equals(startNodeId) && this.endNodeId.equals(endNodeId);
    }

    public boolean hasEndpoints(GqlIdentifier startNodeId, GqlIdentifier endNodeId) {
        return this.hasStartAndEndNode(startNodeId, endNodeId) || this.hasStartAndEndNode(endNodeId, startNodeId);
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
