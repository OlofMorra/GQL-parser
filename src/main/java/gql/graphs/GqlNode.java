package gql.graphs;

import gql.expressions.GqlIdentifier;
import gql.expressions.Label;
import gql.expressions.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class GqlNode {
    private GqlIdentifier id;
    private ArrayList<Label> labels;
    private HashMap<GqlIdentifier, Value> properties;

    public GqlNode(GqlIdentifier id, ArrayList<Label> labels, HashMap<GqlIdentifier, Value> properties) {
        this.id = id;
        this.labels = labels;
        this.properties = properties;
    }

    public GqlIdentifier getId() {
        return id;
    }

    public ArrayList<Label> getLabels() {
        return labels;
    }

    public HashMap<GqlIdentifier, Value> getProperties() {
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
