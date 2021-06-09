package json.gremlin;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class JsonEdge {
    public String identity;
    public String start;
    public String end;
    public ArrayList<String> labels;
    public Map<String, Object> properties;
    public Boolean isDirected;

    public JsonEdge(String identity,
                    String start,
                    String end,
                    ArrayList<String> labels,
                    Map<String, Object> properties,
                    Boolean isDirected) {
        this.identity = identity;
        this.start = start;
        this.end = end;
        this.labels = labels;
        this.properties = properties;
        this.isDirected = isDirected;
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

        return (isDirected ? "Directed" : "Undirected") + " edge "
                + identity + " from " + start + " to "
                + end + " with labels " + labelString
                + " and properties " + propertyString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonEdge jsonEdge = (JsonEdge) o;
        return identity.equals(jsonEdge.identity) && start.equals(jsonEdge.start) && end.equals(jsonEdge.end) && Objects.equals(labels, jsonEdge.labels) && Objects.equals(properties, jsonEdge.properties) && isDirected.equals(jsonEdge.isDirected);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identity, start, end, labels, properties, isDirected);
    }
}
