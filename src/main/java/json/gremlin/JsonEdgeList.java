package json.gremlin;

import com.fasterxml.jackson.annotation.JsonProperty;
import exceptions.InvalidEdgeFormatException;

import java.util.*;

public class JsonEdgeList {
    private final Boolean DIRECTED = true;
    private final Boolean UNDIRECTED = false;
    public ArrayList<JsonEdge> edges = new ArrayList<>();
    public ArrayList<String> ids = new ArrayList<>();

    @SuppressWarnings("unchecked")
    @JsonProperty("e")
    private void unpackNested(Map<String,Object> edge) throws InvalidEdgeFormatException {
        checkNodeFormat(edge);

        String identity = getIdentity(edge);
        String start = getStart(edge);
        String end = getEnd(edge);
        ArrayList<String> labels = getLabels(edge);
        Map<String, Object> properties = getProperties(edge);
        Boolean isDirected = getIsDirected(edge);

        JsonEdge jsonNode = new JsonEdge(identity, start, end, labels, properties, isDirected);

        this.edges.add(jsonNode);
        this.ids.add(identity);
    }

    private void checkNodeFormat(Map<String, Object> edge) throws InvalidEdgeFormatException {
        if (!edge.containsKey("identity")) {
            throw new InvalidEdgeFormatException("An edge does not have an identity.");
        } else if (ids.contains(edge.get("identity").toString())) {
            throw new InvalidEdgeFormatException("There are at least two edges with key " + edge.get("identity").toString() + ".");
        }
        
        if (!edge.containsKey("start")) {
            throw new InvalidEdgeFormatException("An edge does not have a start node.");
        }

        if (!edge.containsKey("end")) {
            throw new InvalidEdgeFormatException("An edge does not have an end node.");
        }

        Set keys = new TreeSet(edge.keySet());
        keys.removeAll(Arrays.asList(new String[]{"identity", "start", "end", "labels", "properties", "isDirected"}));

        if (!keys.isEmpty()) {
            throw new InvalidEdgeFormatException("An edge e in edge.json has more fields than identity, start, " +
                    "end, labels, properties or isDirected.");
        }
    }

    private String getIdentity(Map<String, Object> edge) {
        return edge.get("identity").toString();
    }

    private String getStart(Map<String, Object> edge) {
        return edge.get("start").toString();
    }

    private String getEnd(Map<String, Object> edge) {
        return edge.get("end").toString();
    }

    private ArrayList<String> getLabels(Map<String, Object> edge) {
        ArrayList<String> labels = null;
        if (edge.containsKey("labels")) {
            labels = (ArrayList<String>) edge.get("labels");
        }
        return labels;
    }

    private Map<String, Object> getProperties(Map<String, Object> edge) {
        Map<String, Object> properties = null;
        if (edge.containsKey("properties")) {
            properties = (Map<String, Object>) edge.get("properties");
        }
        return properties;
    }
    
    private Boolean getIsDirected(Map<String, Object> edge) {
        Boolean isDirected = DIRECTED;

        if (edge.containsKey("isDirected")) {
            isDirected = getIsDirectedBoolean(edge);
        }

        return isDirected;
    }

    private Boolean getIsDirectedBoolean(Map<String, Object> edge) {
        int isDirectedInt = (int) edge.get("isDirected");

        if (isDirectedInt == 0) {
            return UNDIRECTED;
        }

        return DIRECTED;
    }

    @Override
    public String toString() {
        return edges.toString();
    }
}
