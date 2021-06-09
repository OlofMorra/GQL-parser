package json.gremlin;

import com.fasterxml.jackson.annotation.JsonProperty;
import exceptions.InvalidNodeFormatException;

import java.util.*;

public class JsonNodeList {
    public ArrayList<JsonNode> nodes = new ArrayList<>();
    public ArrayList<String> ids = new ArrayList<>();

    @SuppressWarnings("unchecked")
    @JsonProperty("n")
    private void unpackNested(Map<String,Object> node) throws InvalidNodeFormatException {
        checkNodeFormat(node);

        String identity = getIdentity(node);
        ArrayList<String> labels = getLabels(node);
        Map<String, Object> properties = getProperties(node);

        JsonNode jsonNode = new JsonNode(identity, labels, properties);

        this.nodes.add(jsonNode);
        this.ids.add(identity);
    }

    private void checkNodeFormat(Map<String, Object> node) throws InvalidNodeFormatException {
        if (!node.containsKey("identity")) {
            throw new InvalidNodeFormatException("A node does not have an identity.");
        } else if (ids.contains(node.get("identity").toString())) {
            throw new InvalidNodeFormatException("There are at least two nodes with key " + node.get("identity").toString() + ".");
        }

        Set keys = new TreeSet(node.keySet());
        keys.removeAll(Arrays.asList(new String[]{"identity", "labels", "properties"}));

        if (!keys.isEmpty()) {
            throw new InvalidNodeFormatException("A node n in node.json has more fields than identity, labels, or properties.");
        }
    }

    private String getIdentity(Map<String, Object> node) {
        return node.get("identity").toString();
    }

    private ArrayList<String> getLabels(Map<String, Object> node) {
        ArrayList<String> labels = null;
        if (node.containsKey("labels")) {
            labels = (ArrayList<String>) node.get("labels");
        }
        return labels;
    }

    private Map<String, Object> getProperties(Map<String, Object> node) {
        Map<String, Object> properties = null;
        if (node.containsKey("properties")) {
            properties = (Map<String, Object>) node.get("properties");
        }
        return properties;
    }

    @Override
    public String toString() {
        return nodes.toString();
    }
}
