package gql.patterns;

import gql.expressions.*;
import gql.graphs.WorkingGraph;
import gql.tables.BindingTable;
import gql.tables.Record;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class NodePatternTest {
    WorkingGraph graph = WorkingGraph.getInstance();
    Record[] records = new Record[4];

    @Before
    public void setGraph() {
        try {
            graph.setLocalGraph("g3");
        } catch (Exception e) {
            System.err.println("Exception raised when setting up working graph for node pattern tests.");
            e.printStackTrace();
        }

        records[0] = new Record(new String[]{"0"}, new Value[]{new GqlId("n5")});
        records[1] = new Record(new String[]{"0"}, new Value[]{new GqlId("n19")});
        records[2] = new Record(new String[]{"0"}, new Value[]{new GqlId("n29")});
        records[3] = new Record(new String[]{"0"}, new Value[]{new GqlId("n85")});
    }

    // match()
    @Test
    public void testMatchEmptyNodePattern() {
        NodePattern nodePattern = new NodePattern(null, null, null);
        BindingTable actualResult = nodePattern.match(0);
        BindingTable expectedResult = new BindingTable(false, true, new String[]{"0"});

        expectedResult.addRecords(records);

        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    @Test
    public void testMatchNodePatternWithId() {
        GqlId id = new GqlId("x");
        NodePattern nodePattern = new NodePattern(id, null, null);

        BindingTable actualResult = nodePattern.match(0);
        BindingTable expectedResult = new BindingTable(false, true, new String[]{"0"});

        expectedResult.addRecords(records);

        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    @Test
    public void testMatchNodePatternWithLabel() {
        ArrayList<ArrayList<Label>> label = new ArrayList<>();
        addLabelSetTo(label, new String[]{"Person"});
        NodePattern nodePattern = new NodePattern(null, label, null);

        BindingTable actualResult = nodePattern.match(0);
        BindingTable expectedResult = new BindingTable(false, true, new String[]{"0"});

        expectedResult.addRecord(records[1]);
        expectedResult.addRecord(records[2]);
        expectedResult.addRecord(records[3]);

        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    @Test
    public void testMatchNodePatternWithLabelConjunction() {
        ArrayList<ArrayList<Label>> labelSetList = new ArrayList<>();
        addLabelSetTo(labelSetList, new String[]{"Person", "Professor"});
        NodePattern nodePattern = new NodePattern(null, labelSetList, null);

        BindingTable actualResult = nodePattern.match(0);
        BindingTable expectedResult = new BindingTable(false, true, new String[]{"0"});

        expectedResult.addRecord(records[1]);

        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    @Test
    public void testMatchNodePatternWithLabelDisjunction() {
        ArrayList<ArrayList<Label>> labelSetList = new ArrayList<>();
        addLabelSetTo(labelSetList, new String[]{"Person", "Professor"});
        addLabelSetTo(labelSetList, new String[]{"Internship"});
        NodePattern nodePattern = new NodePattern(null, labelSetList, null);

        BindingTable actualResult = nodePattern.match(0);
        BindingTable expectedResult = new BindingTable(false, true, new String[]{"0"});

        expectedResult.addRecord(records[1]);
        expectedResult.addRecord(records[0]);

        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    @Test
    public void testMatchNodePatternWithWildCardLabel() {
        ArrayList<ArrayList<Label>> label = new ArrayList<>();
        addLabelSetTo(label, new String[]{"%"});
        NodePattern nodePattern = new NodePattern(null, label, null);

        BindingTable actualResult = nodePattern.match(0);
        BindingTable expectedResult = new BindingTable(false, true, new String[]{"0"});

        expectedResult.addRecord(records[0]);
        expectedResult.addRecord(records[1]);
        expectedResult.addRecord(records[2]);
        expectedResult.addRecord(records[3]);

        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    @Test
    public void testMatchNodePatternWithProperty() {
        HashMap<GqlId, Value> properties = new HashMap<>();
        properties.put(new GqlId("name"), new GqlString("Olof Morra"));
        NodePattern nodePattern = new NodePattern(null, null, properties);

        BindingTable actualResult = nodePattern.match(0);
        BindingTable expectedResult = new BindingTable(false, true, new String[]{"0"});

        expectedResult.addRecord(records[3]);

        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    @Test
    public void testMatchNodePatternWithProperties() {
        HashMap<GqlId, Value> properties = new HashMap<>();
        properties.put(new GqlId("name"), new GqlString("Olof Morra"));
        properties.put(new GqlId("studies"), new GqlString("Data Science"));
        NodePattern nodePattern = new NodePattern(null, null, properties);

        BindingTable actualResult = nodePattern.match(0);
        BindingTable expectedResult = new BindingTable(false, true, new String[]{"0"});

        expectedResult.addRecord(records[3]);

        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    @Test
    public void testMatchNodePatternWithIdAndLabelsAndProperties() {
        GqlId id = new GqlId("x");

        ArrayList<ArrayList<Label>> labelSetList = new ArrayList<>();
        addLabelSetTo(labelSetList, new String[]{"Person"});
        addLabelSetTo(labelSetList, new String[]{"Internship"});

        HashMap<GqlId, Value> properties = new HashMap<>();
        properties.put(new GqlId("name"), new GqlString("Olof Morra"));
        properties.put(new GqlId("studies"), new GqlString("Data Science"));

        NodePattern nodePattern = new NodePattern(id, labelSetList, properties);

        BindingTable actualResult = nodePattern.match(0);
        BindingTable expectedResult = new BindingTable(false, true, new String[]{"0"});

        expectedResult.addRecord(records[3]);

        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    @Test
    public void testMatchWithEmptyResult() {
        HashMap<GqlId, Value> properties = new HashMap<>();
        properties.put(new GqlId("NonexistingID"), new GqlString("Does not produce results"));
        NodePattern nodePattern = new NodePattern(null, null, properties);

        BindingTable actualResult = nodePattern.match(0);
        BindingTable expectedResult = new BindingTable(false, true, new String[]{"0"});

        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    private void checkIfBindingTablesAreEqual(BindingTable expectedResult, BindingTable actualResult) {
        System.out.println("Expected:");
        expectedResult.printToConsole();
        System.out.println("Actual:");
        actualResult.printToConsole();

        assertEquals(expectedResult, actualResult);
    }

    // toString()
    @Test
    public void testToStringEmptyNodePattern() {
        NodePattern nodePattern = new NodePattern(null, null, null);

        String expectedResult = "(nil, {}, {})";
        assertEquals(expectedResult, nodePattern.toString());
    }

    @Test
    public void testToStringNodePatternWithId() {
        GqlId id = new GqlId("x");
        NodePattern nodePattern = new NodePattern(id, null, null);

        String expectedResult = "(x, {}, {})";
        assertEquals(expectedResult, nodePattern.toString());
    }

    @Test
    public void testToStringNodePatternWithLabel() {
        ArrayList<ArrayList<Label>> label = new ArrayList<>();
        addLabelSetTo(label, new String[]{"Person"});
        NodePattern nodePattern = new NodePattern(null, label, null);

        String expectedResult = "(nil, {{Person}}, {})";
        assertEquals(expectedResult, nodePattern.toString());
    }

    @Test
    public void testToStringNodePatternWithLabelConjunction() {
        ArrayList<ArrayList<Label>> labelSetList = new ArrayList<>();
        addLabelSetTo(labelSetList, new String[]{"Person", "Professor"});
        NodePattern nodePattern = new NodePattern(null, labelSetList, null);

        String expectedResult = "(nil, {{Person, Professor}}, {})";
        assertEquals(expectedResult, nodePattern.toString());
    }

    @Test
    public void testToStringNodePatternWithLabelDisjunction() {
        ArrayList<ArrayList<Label>> labelSetList = new ArrayList<>();
        addLabelSetTo(labelSetList, new String[]{"Person", "Professor"});
        addLabelSetTo(labelSetList, new String[]{"Internship"});
        NodePattern nodePattern = new NodePattern(null, labelSetList, null);

        String expectedResult = "(nil, {{Person, Professor}, {Internship}}, {})";
        assertEquals(expectedResult, nodePattern.toString());
    }

    @Test
    public void testToStringNodePatternWithProperty() {
        HashMap<GqlId, Value> properties = new HashMap<>();
        properties.put(new GqlId("name"), new GqlString("Olof Morra"));
        NodePattern nodePattern = new NodePattern(null, null, properties);

        String expectedResult = "(nil, {}, {(name: \"Olof Morra\")})";
        assertEquals(expectedResult, nodePattern.toString());
    }

    @Test
    public void testToStringNodePatternWithProperties() {
        HashMap<GqlId, Value> properties = new HashMap<>();
        properties.put(new GqlId("name"), new GqlString("Olof Morra"));
        properties.put(new GqlId("studies"), new GqlString("Data Science"));
        NodePattern nodePattern = new NodePattern(null, null, properties);

        String expectedResult = "(nil, {}, {(studies: \"Data Science\"), (name: \"Olof Morra\")})";
        assertEquals(expectedResult, nodePattern.toString());
    }

    @Test
    public void testToStringNodePatternWithIdAndLabelsAndProperties() {
        GqlId id = new GqlId("x");

        ArrayList<ArrayList<Label>> labelSetList = new ArrayList<>();
        addLabelSetTo(labelSetList, new String[]{"Person", "Professor"});
        addLabelSetTo(labelSetList, new String[]{"Internship"});

        HashMap<GqlId, Value> properties = new HashMap<>();
        properties.put(new GqlId("name"), new GqlString("Olof Morra"));
        properties.put(new GqlId("studies"), new GqlString("Data Science"));

        NodePattern nodePattern = new NodePattern(id, labelSetList, properties);

        String expectedResult = "(x, {{Person, Professor}, {Internship}}, {(studies: \"Data Science\"), (name: \"Olof Morra\")})";
        assertEquals(expectedResult, nodePattern.toString());
    }

    // TODO: decide how to present wildcard in node pattern
    @Test
    public void testToStringNodePatternWithWildCardLabel() {
        ArrayList<ArrayList<Label>> label = new ArrayList<>();
        addLabelSetTo(label, new String[]{"%"});
        NodePattern nodePattern = new NodePattern(null, label, null);

        String expectedResult = "(nil, {{%}}, {})";
        assertEquals(expectedResult, nodePattern.toString());
    }

    private void addLabelSetTo(ArrayList<ArrayList<Label>> labelSetList, String[] labels) {
        ArrayList<Label> labelSet = new ArrayList<>();

        for (String label: labels) {
            if (label.equals("%")) {
                labelSet.add(new WildcardLabel());
            } else {
                labelSet.add(new Label(new GqlId(label)));
            }
        }

        labelSetList.add(labelSet);
    }
}