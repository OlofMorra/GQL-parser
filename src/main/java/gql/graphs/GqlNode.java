package gql.graphs;

import gql.expressions.values.GqlIdentifier;
import gql.expressions.values.Label;
import gql.expressions.values.TruthValue;
import gql.expressions.values.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class GqlNode extends GqlGraphElement {
    public GqlNode(GqlIdentifier id, ArrayList<Label> labels, HashMap<GqlIdentifier, Value> properties) {
        if (id == null) throw new NullPointerException("Argument id cannot be null");
        if (labels == null) throw new NullPointerException("Argument labels cannot be null");
        if (properties == null) throw new NullPointerException("Argument properties cannot be null");

        this.id = id;
        this.labels = labels;
        this.properties = properties;
    }

    @Override
    public TruthValue isEqualTo(Value valueToCompareTo) {
        return new TruthValue(this.equals(valueToCompareTo));
    }

    @Override
    public TruthValue isSmallerThan(Value valueToCompareTo) {
        throw new IllegalArgumentException("Invalid comparison: nodes cannot be used in an inequality.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GqlNode gqlNode = (GqlNode) o;
        return id.isEqualTo(gqlNode.getId()).equals(new TruthValue(true)) && labels.equals(gqlNode.getLabels()) && properties.equals(gqlNode.getProperties());
    }

    @Override
    public int hashCode() {
        return Objects.hash(labels, properties);
    }

    @Override
    public String toString() {
        return "{\"identity\": \"" + this.id + "\"" + getLabelString() + getPropertiesString() + "}";
    }
}
