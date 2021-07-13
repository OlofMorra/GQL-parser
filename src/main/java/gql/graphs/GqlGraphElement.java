package gql.graphs;

import gql.expressions.values.GqlIdentifier;
import gql.expressions.values.Label;
import gql.expressions.values.Value;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class GqlGraphElement extends Value {
    protected GqlIdentifier id;
    protected ArrayList<Label> labels;
    protected HashMap<GqlIdentifier, Value> properties;

    public void setProperties(HashMap<GqlIdentifier, Value> properties) {
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

    protected String getLabelString() {
        if (this.labels == null || this.labels.isEmpty()) return "";

        String labelString = ", \"labels\": [";

        for (Label label: this.labels) {
            labelString = labelString.concat("\"" + label.toString() + "\", ");
        }

        labelString = labelString.substring(0, labelString.length()-2);

        return labelString.concat("]");
    }

    protected String getPropertiesString() {
        if (this.properties == null || this.properties.isEmpty()) return "";

        String propertyString = ", \"properties\": {";

        for (GqlIdentifier id: properties.keySet()) {
            propertyString = propertyString.concat("\"" + id.toString() + "\": " + properties.get(id).toString() + ", ");
        }

        propertyString = propertyString.substring(0, propertyString.length()-2);

        return propertyString.concat("}");
    }
}
