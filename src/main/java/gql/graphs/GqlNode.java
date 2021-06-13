package gql.graphs;

import gql.expressions.GqlId;
import gql.expressions.Label;
import gql.expressions.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class GqlNode {
    private GqlId id;
    private ArrayList<Label> labels;
    private HashMap<GqlId, Value> properties;

    public GqlNode(GqlId id, ArrayList<Label> labels, HashMap<GqlId, Value> properties) {
        this.id = id;
        this.labels = labels;
        this.properties = properties;
    }

    public GqlId getId() {
        return id;
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
        GqlNode gqlNode = (GqlNode) o;
        return Objects.equals(labels, gqlNode.labels) && Objects.equals(properties, gqlNode.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(labels, properties);
    }
}
