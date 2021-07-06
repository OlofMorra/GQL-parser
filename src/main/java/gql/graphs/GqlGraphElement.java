package gql.graphs;

import gql.expressions.values.GqlIdentifier;
import gql.expressions.values.Label;
import gql.expressions.values.TruthValue;
import gql.expressions.values.Value;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class GqlGraphElement extends Value {
    protected GqlIdentifier id;
    protected ArrayList<Label> labels;
    protected HashMap<GqlIdentifier, Value> properties;

    public GqlIdentifier getId() {
        return id;
    }

    public ArrayList<Label> getLabels() {
        return labels;
    }

    public HashMap<GqlIdentifier, Value> getProperties() {
        return properties;
    }
}
