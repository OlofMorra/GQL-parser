package gql.patterns;

import gql.expressions.values.*;
import gql.graphs.WorkingGraph;
import gql.tables.BindingTable;
import gql.tables.BindingTableComparator;
import gql.tables.Record;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class NodePatternTest implements BindingTableComparator {
    WorkingGraph graph = WorkingGraph.getInstance();
    ArrayList<Record> records = new ArrayList<>();

    @Before
    public void setGraph() {
        try {
            graph.setLocalGraph("g3");
        } catch (Exception e) {
            System.err.println("Exception raised when setting up working graph for node pattern tests.");
            e.printStackTrace();
        }

        records.add(new Record(new String[]{"0"}, new Value[]{new GqlIdentifier("n5")}));
        records.add(new Record(new String[]{"0"}, new Value[]{new GqlIdentifier("n19")}));
        records.add(new Record(new String[]{"0"}, new Value[]{new GqlIdentifier("n29")}));
        records.add(new Record(new String[]{"0"}, new Value[]{new GqlIdentifier("n85")}));
    }

    // match()
    @Test
    public void testMatchEmptyNodePattern() {
        NodePattern nodePattern = new NodePattern(null, null, null);
        BindingTable actualResult = nodePattern.match();
        BindingTable expectedResult = new BindingTable(true, new String[]{"0"});

        expectedResult.addRecords(records);

        System.out.println(nodePattern);
        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    @Test
    public void testMatchNodePatternWithId() {
        NodePattern nodePattern = new NodePattern(new VariableName("x"), null, null);

        BindingTable actualResult = nodePattern.match();
        BindingTable expectedResult = new BindingTable(true, new String[]{"0"});

        expectedResult.addRecords(records);

        System.out.println(nodePattern);
        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    @Test
    public void testMatchNodePatternWithLabel() {
        ArrayList<ArrayList<Label>> label = new ArrayList<>();
        addLabelSetTo(label, new String[]{"Person"});
        NodePattern nodePattern = new NodePattern(null, label, null);

        BindingTable actualResult = nodePattern.match();
        BindingTable expectedResult = new BindingTable(true, new String[]{"0"});

        expectedResult.addRecord(records.get(1));
        expectedResult.addRecord(records.get(2));
        expectedResult.addRecord(records.get(3));

        System.out.println(nodePattern);
        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    @Test
    public void testMatchNodePatternWithLabelConjunction() {
        ArrayList<ArrayList<Label>> labelSetList = new ArrayList<>();
        addLabelSetTo(labelSetList, new String[]{"Person", "Professor"});
        NodePattern nodePattern = new NodePattern(null, labelSetList, null);

        BindingTable actualResult = nodePattern.match();
        BindingTable expectedResult = new BindingTable(true, new String[]{"0"});

        expectedResult.addRecord(records.get(1));

        System.out.println(nodePattern);
        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    @Test
    public void testMatchNodePatternWithLabelDisjunction() {
        ArrayList<ArrayList<Label>> labelSetList = new ArrayList<>();
        addLabelSetTo(labelSetList, new String[]{"Person", "Professor"});
        addLabelSetTo(labelSetList, new String[]{"Internship"});
        NodePattern nodePattern = new NodePattern(null, labelSetList, null);

        BindingTable actualResult = nodePattern.match();
        BindingTable expectedResult = new BindingTable(true, new String[]{"0"});

        expectedResult.addRecord(records.get(1));
        expectedResult.addRecord(records.get(0));

        System.out.println(nodePattern);
        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    @Test
    public void testMatchNodePatternWithWildCardLabel() {
        ArrayList<ArrayList<Label>> label = new ArrayList<>();
        addLabelSetTo(label, new String[]{"%"});
        NodePattern nodePattern = new NodePattern(null, label, null);

        BindingTable actualResult = nodePattern.match();
        BindingTable expectedResult = new BindingTable(true, new String[]{"0"});

        expectedResult.addRecord(records.get(0));
        expectedResult.addRecord(records.get(1));
        expectedResult.addRecord(records.get(2));
        expectedResult.addRecord(records.get(3));

        System.out.println(nodePattern);
        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    @Test
    public void testMatchNodePatternWithProperty() {
        HashMap<GqlIdentifier, Value> properties = new HashMap<>();
        properties.put(new GqlIdentifier("name"), new GqlString("Olof Morra"));
        NodePattern nodePattern = new NodePattern(null, null, properties);

        BindingTable actualResult = nodePattern.match();
        BindingTable expectedResult = new BindingTable(true, new String[]{"0"});

        expectedResult.addRecord(records.get(3));

        System.out.println(nodePattern);
        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    @Test
    public void testMatchNodePatternWithProperties() {
        HashMap<GqlIdentifier, Value> properties = new HashMap<>();
        properties.put(new GqlIdentifier("name"), new GqlString("Olof Morra"));
        properties.put(new GqlIdentifier("studies"), new GqlString("Data Science"));
        NodePattern nodePattern = new NodePattern(null, null, properties);

        BindingTable actualResult = nodePattern.match();
        BindingTable expectedResult = new BindingTable(true, new String[]{"0"});

        expectedResult.addRecord(records.get(3));

        System.out.println(nodePattern);
        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    @Test
    public void testMatchNodePatternWithIdAndLabelsAndProperties() {
        ArrayList<ArrayList<Label>> labelSetList = new ArrayList<>();
        addLabelSetTo(labelSetList, new String[]{"Person"});
        addLabelSetTo(labelSetList, new String[]{"Internship"});

        HashMap<GqlIdentifier, Value> properties = new HashMap<>();
        properties.put(new GqlIdentifier("name"), new GqlString("Olof Morra"));
        properties.put(new GqlIdentifier("studies"), new GqlString("Data Science"));

        NodePattern nodePattern = new NodePattern(new VariableName("x"), labelSetList, properties);

        BindingTable actualResult = nodePattern.match();
        BindingTable expectedResult = new BindingTable(true, new String[]{"0"});

        expectedResult.addRecord(records.get(3));

        System.out.println(nodePattern);
        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    @Test
    public void testMatchWithEmptyResult() {
        HashMap<GqlIdentifier, Value> properties = new HashMap<>();
        properties.put(new GqlIdentifier("NonexistingID"), new GqlString("Does not produce results"));
        NodePattern nodePattern = new NodePattern(null, null, properties);

        BindingTable actualResult = nodePattern.match();
        BindingTable expectedResult = new BindingTable(true, new String[]{"0"});

        System.out.println(nodePattern);
        checkIfBindingTablesAreEqual(expectedResult, actualResult);
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
        NodePattern nodePattern = new NodePattern(new VariableName("x"), null, null);

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
        HashMap<GqlIdentifier, Value> properties = new HashMap<>();
        properties.put(new GqlIdentifier("name"), new GqlString("Olof Morra"));
        NodePattern nodePattern = new NodePattern(null, null, properties);

        String expectedResult = "(nil, {}, {(name: \"Olof Morra\")})";
        assertEquals(expectedResult, nodePattern.toString());
    }

    @Test
    public void testToStringNodePatternWithProperties() {
        HashMap<GqlIdentifier, Value> properties = new HashMap<>();
        properties.put(new GqlIdentifier("name"), new GqlString("Olof Morra"));
        properties.put(new GqlIdentifier("studies"), new GqlString("Data Science"));
        NodePattern nodePattern = new NodePattern(null, null, properties);

        String expectedResult = "(nil, {}, {(studies: \"Data Science\"), (name: \"Olof Morra\")})";
        assertEquals(expectedResult, nodePattern.toString());
    }

    @Test
    public void testToStringNodePatternWithIdAndLabelsAndProperties() {
        ArrayList<ArrayList<Label>> labelSetList = new ArrayList<>();
        addLabelSetTo(labelSetList, new String[]{"Person", "Professor"});
        addLabelSetTo(labelSetList, new String[]{"Internship"});

        HashMap<GqlIdentifier, Value> properties = new HashMap<>();
        properties.put(new GqlIdentifier("name"), new GqlString("Olof Morra"));
        properties.put(new GqlIdentifier("studies"), new GqlString("Data Science"));

        NodePattern nodePattern = new NodePattern(new VariableName("x"), labelSetList, properties);

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
                labelSet.add(new Label(label));
            }
        }

        labelSetList.add(labelSet);
    }
}