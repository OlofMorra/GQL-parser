package json.gremlin;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class JsonNode {
    public String identity;
    public ArrayList<String> labels;
    public Map<String, Object> properties;

    public JsonNode(String identity) {
        this.identity = identity;
    }

    public JsonNode(String identity,
                    ArrayList<String> labels,
                    Map<String, Object> properties) {
        this.identity = identity;
        this.labels = labels;
        this.properties = properties;
    }

    @Override
    public String toString() {
        String labelString;
        if (labels == null) {
            labelString = "";
        } else {
            labelString = labels.toString();
        }

        String propertyString;
        if (properties == null) {
            propertyString = "";
        } else {
            propertyString = properties.toString();
        }

        return "Node " + identity + " with labels " + labelString
                + " and properties " + propertyString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonNode jsonNode = (JsonNode) o;
        return identity.equals(jsonNode.identity) && Objects.equals(labels, jsonNode.labels) && Objects.equals(properties, jsonNode.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identity, labels, properties);
    }
}
