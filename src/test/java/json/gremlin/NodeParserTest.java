package json.gremlin;

import exceptions.InvalidNodeFormatException;
import json.gremlin.JsonNode;
import json.gremlin.NodeParser;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/*
 * TODO:
 *  - Add workload tests, i.e. many nodes, labels, properties or combination
 */

public class NodeParserTest {
    private final String TEST_DIRECTORY = "/src/test/resources/parser/nodes/";

    // Test incorrect input
    @Test(expected = InvalidNodeFormatException.class)
    public void testNoIdentityInNode() throws FileNotFoundException, InvalidNodeFormatException {
        NodeParser parser = getNodeParser("no_identity.json");
        parser.getNodes();
    }

    // Test incorrect input
    @Test(expected = InvalidNodeFormatException.class)
    public void testDuplicateIdentityInNode() throws FileNotFoundException, InvalidNodeFormatException {
        NodeParser parser = getNodeParser("duplicate_identity.json");
        parser.getNodes();
    }

    @Test(expected = InvalidNodeFormatException.class)
    public void testIncorrectLabelsInFile() throws FileNotFoundException, InvalidNodeFormatException {
        NodeParser parser = getNodeParser("incorrect_labels.json");
        parser.getNodes();
    }

    @Test(expected = InvalidNodeFormatException.class)
    public void testIncorrectPropertiesInFile() throws FileNotFoundException, InvalidNodeFormatException {
        NodeParser parser = getNodeParser("incorrect_properties.json");
        parser.getNodes();
    }

    @Test(expected = InvalidNodeFormatException.class)
    public void testExtraFieldsInFile() throws FileNotFoundException, InvalidNodeFormatException {
        NodeParser parser = getNodeParser("extra_fields.json");
        parser.getNodes();
    }

    @Test(expected = InvalidNodeFormatException.class)
    public void testIncorrectJsonFile() throws FileNotFoundException, InvalidNodeFormatException {
        NodeParser parser = getNodeParser("incorrect_json.json");
        parser.getNodes();
    }

    @Test(expected = FileNotFoundException.class)
    public void testNotExistingFile() throws FileNotFoundException {
        NodeParser parser = getNodeParser("non_existing_file.json");
    }

    // Test correct input
    @Test
    public void testSimpleNodes() throws FileNotFoundException, InvalidNodeFormatException {
        NodeParser parser = getNodeParser("simple_nodes.json");
        ArrayList<JsonNode> actualNodes = parser.getNodes();

        ArrayList<JsonNode> expectedNodes = getExpectedSimpleNodes();

        assertEquals(actualNodes, expectedNodes);
    }

    @Test
    public void testCompleteNodes() throws FileNotFoundException, InvalidNodeFormatException {
        NodeParser parser = getNodeParser("complete_nodes.json");
        ArrayList<JsonNode> actualNodes = parser.getNodes();

        ArrayList<JsonNode> expectedNodes = getExpectedCompleteNodes();

        assertEquals(actualNodes, expectedNodes);
    }

    private ArrayList<JsonNode> getExpectedSimpleNodes() {
        ArrayList<JsonNode> expectedNodes = new ArrayList<>();
        expectedNodes.add(new JsonNode("1"));
        expectedNodes.add(new JsonNode("2"));
        expectedNodes.add(new JsonNode("3"));
        return expectedNodes;
    }

    private ArrayList<JsonNode> getExpectedCompleteNodes() {
        ArrayList personLabel = getLabels(new String[]{"Person"});
        ArrayList professorLabel = getLabels(new String[]{"Person", "Professor"});
        ArrayList internshipLabel = getLabels(new String[]{"Internship"});
        Map georgeProperties = new HashMap() {
            {
                put("name", "George Fletcher");
                put("employer", "TU/e");
            }
        };
        Map michaelProperties = new HashMap() {
            {
                put("name", "Michael Schmidt");
                put("employer", "Amazon");
            }
        };
        Map olofProperties = new HashMap() {
            {
                put("name", "Olof Morra");
                put("studies", "Data Science");
            }
        };

        ArrayList<JsonNode> expectedNodes = new ArrayList<>();
        expectedNodes.add(new JsonNode("5", internshipLabel, null));
        expectedNodes.add(new JsonNode("19", professorLabel, georgeProperties));
        expectedNodes.add(new JsonNode("29", personLabel, michaelProperties));
        expectedNodes.add(new JsonNode("85", personLabel, olofProperties));
        return expectedNodes;
    }

    private NodeParser getNodeParser(String fileName) throws FileNotFoundException {
        return new NodeParser(System.getProperty("user.dir") + TEST_DIRECTORY + fileName);
    }

    private ArrayList getLabels(String[] labels) {
        return new ArrayList(Arrays.asList(labels));
    }
}