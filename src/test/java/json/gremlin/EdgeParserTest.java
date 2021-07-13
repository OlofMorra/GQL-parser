package json.gremlin;

import exceptions.InvalidEdgeFormatException;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/*
 * TODO:
 *  - Add workload tests, i.e. many edges, labels, properties or combination
 */

public class EdgeParserTest {
    private final String TEST_DIRECTORY = "/src/test/resources/parser/edges/";
    private final Boolean DIRECTED = true;
    private final Boolean UNDIRECTED = false;

    // Test incorrect input
    @Test(expected = InvalidEdgeFormatException.class)
    public void testNoIdentityInEdge() throws FileNotFoundException, InvalidEdgeFormatException {
        EdgeParser parser = getEdgeParser("no_identity.json");
        parser.getEdges();
    }

    @Test(expected = InvalidEdgeFormatException.class)
    public void testDuplicateIdentityInEdge() throws FileNotFoundException, InvalidEdgeFormatException {
        EdgeParser parser = getEdgeParser("duplicate_identity.json");
        parser.getEdges();
    }

    @Test(expected = InvalidEdgeFormatException.class)
    public void testNoStartNodeInEdge() throws FileNotFoundException, InvalidEdgeFormatException {
        EdgeParser parser = getEdgeParser("no_start_node.json");
        parser.getEdges();
    }

    @Test(expected = InvalidEdgeFormatException.class)
    public void testNoEndNodeInEdge() throws FileNotFoundException, InvalidEdgeFormatException {
        EdgeParser parser = getEdgeParser("no_end_node.json");
        parser.getEdges();
    }

    @Test(expected = InvalidEdgeFormatException.class)
    public void testIncorrectLabelsInFile() throws FileNotFoundException, InvalidEdgeFormatException {
        EdgeParser parser = getEdgeParser("incorrect_labels.json");
        parser.getEdges();
    }

    @Test(expected = InvalidEdgeFormatException.class)
    public void testIncorrectPropertiesInFile() throws FileNotFoundException, InvalidEdgeFormatException {
        EdgeParser parser = getEdgeParser("incorrect_properties.json");
        parser.getEdges();
    }

    @Test(expected = InvalidEdgeFormatException.class)
    public void testExtraFieldsInFile() throws FileNotFoundException, InvalidEdgeFormatException {
        EdgeParser parser = getEdgeParser("extra_fields.json");
        parser.getEdges();
    }

    @Test(expected = InvalidEdgeFormatException.class)
    public void testIncorrectJsonFile() throws FileNotFoundException, InvalidEdgeFormatException {
        EdgeParser parser = getEdgeParser("incorrect_json.json");
        parser.getEdges();
    }

    @Test(expected = FileNotFoundException.class)
    public void testNotExistingFile() throws FileNotFoundException {
        EdgeParser parser = getEdgeParser("non_existing_file.json");
    }

    // Test correct input
    @Test
    public void testSimpleEdges() throws FileNotFoundException, InvalidEdgeFormatException {
        EdgeParser parser = getEdgeParser("simple_edges.json");
        ArrayList<JsonEdge> actualEdges = parser.getEdges();

        ArrayList<JsonEdge> expectedEdges = getExpectedSimpleEdges();

        assertEquals(actualEdges, expectedEdges);
    }

    @Test
    public void testCompleteEdges() throws FileNotFoundException, InvalidEdgeFormatException {
        EdgeParser parser = getEdgeParser("complete_edges.json");
        ArrayList<JsonEdge> actualEdges = parser.getEdges();

        ArrayList<JsonEdge> expectedEdges = getExpectedCompleteEdges();

        assertEquals(actualEdges, expectedEdges);
    }

    @Test
    public void testCompleteEdgesWithoutIsDirected() throws FileNotFoundException, InvalidEdgeFormatException {
        EdgeParser parser = getEdgeParser("complete_edges_without_is_directed.json");
        ArrayList<JsonEdge> actualEdges = parser.getEdges();

        ArrayList<JsonEdge> expectedEdges = getExpectedCompleteEdges();

        assertEquals(actualEdges, expectedEdges);
    }

    private ArrayList<JsonEdge> getExpectedSimpleEdges() {
        ArrayList<JsonEdge> expectedEdges = new ArrayList<>();
        expectedEdges.add(new JsonEdge("1", "1", "2", null, null, UNDIRECTED));
        expectedEdges.add(new JsonEdge("2", "2", "3", null, null, UNDIRECTED));
        expectedEdges.add(new JsonEdge("3", "3", "3", null, null, UNDIRECTED));
        return expectedEdges;
    }

    private ArrayList<JsonEdge> getExpectedCompleteEdges() {
        ArrayList doesLabel = getLabels(new String[]{"Does"});
        ArrayList learnsFromLabel = getLabels(new String[]{"LearnsFrom"});
        ArrayList teachesLabel = getLabels(new String[]{"Teaches"});
        ArrayList areColleaguesLabel = getLabels(new String[]{"AreColleagues"});
        ArrayList supervisesLabel = getLabels(new String[]{"Supervises"});
        Map doesProperties = new HashMap() {
            {
                put("in_semester", 2);
            }
        };

        ArrayList<JsonEdge> expectedEdges = new ArrayList<>();
        expectedEdges.add(new JsonEdge("2", "85", "5", doesLabel, doesProperties, DIRECTED));
        expectedEdges.add(new JsonEdge("3", "85", "19", learnsFromLabel, null, DIRECTED));
        expectedEdges.add(new JsonEdge("12", "19", "85", teachesLabel, null, DIRECTED));
        expectedEdges.add(new JsonEdge("21", "29", "19", areColleaguesLabel, null, UNDIRECTED));
        expectedEdges.add(new JsonEdge("86", "19", "5", supervisesLabel, null, DIRECTED));
        return expectedEdges;
    }

    private EdgeParser getEdgeParser(String fileName) throws FileNotFoundException {
        return new EdgeParser(System.getProperty("user.dir") + TEST_DIRECTORY + fileName);
    }

    private ArrayList getLabels(String[] labels) {
        return new ArrayList(Arrays.asList(labels));
    }
}