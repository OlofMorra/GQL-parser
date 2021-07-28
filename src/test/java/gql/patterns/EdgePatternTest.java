package gql.patterns;

import gql.enums.Direction;
import gql.expressions.values.*;
import gql.graphs.WorkingGraph;
import gql.tables.BindingTable;
import gql.tables.BindingTableComparator;
import gql.tables.Record;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class EdgePatternTest implements BindingTableComparator {
    WorkingGraph graph = WorkingGraph.getInstance();
    Record[] records = new Record[5];

    @Before
    public void setGraph() {
        try {
            graph.setToMainDirectory();
            graph.setLocalGraph("g3");
        } catch (Exception e) {
            System.err.println("Exception raised when setting up working graph for edge pattern tests.");
            e.printStackTrace();
        }

        records[0] = new Record(new String[]{"1"}, new Value[]{new GqlIdentifier("e2")});
        records[1] = new Record(new String[]{"1"}, new Value[]{new GqlIdentifier("e3")});
        records[2] = new Record(new String[]{"1"}, new Value[]{new GqlIdentifier("e12")});
        records[3] = new Record(new String[]{"1"}, new Value[]{new GqlIdentifier("e21")});
        records[4] = new Record(new String[]{"1"}, new Value[]{new GqlIdentifier("e86")});
    }

    // match()
    @Test
    public void testMatchEmptyEdgePatternBothDirections() {
        EdgePattern edgePatternLeftToRight = new EdgePattern(null, null, null, Direction.LEFT_TO_RIGHT, 1);
        EdgePattern edgePatternRightToLeft = new EdgePattern(null, null, null, Direction.RIGHT_TO_LEFT, 1);

        BindingTable leftToRight = edgePatternLeftToRight.match();
        BindingTable rightToLeft = edgePatternRightToLeft.match();

        checkIfBindingTablesAreEqual(leftToRight, rightToLeft);
    }

    @Test
    public void testMatchEmptyEdgePatternUndirected() {
        EdgePattern edgePattern = new EdgePattern(null, null, null, Direction.UNDIRECTED, 1);
        BindingTable actualResult = edgePattern.match();
        BindingTable expectedResult = new BindingTable(true, new String[]{"1"});

        expectedResult.addRecord(records[3]);

        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    @Test
    public void testMatchEmptyEdgePattern() {
        EdgePattern edgePattern = new EdgePattern(null, null, null, Direction.LEFT_TO_RIGHT, 1);
        BindingTable actualResult = edgePattern.match();
        BindingTable expectedResult = new BindingTable(true, new String[]{"1"});

        expectedResult.addRecord(records[0]);
        expectedResult.addRecord(records[1]);
        expectedResult.addRecord(records[2]);
        expectedResult.addRecord(records[4]);

        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    @Test
    public void testMatchEdgePatternWithId() {
        EdgePattern edgePattern = new EdgePattern(new VariableName("x"), null, null, Direction.LEFT_TO_RIGHT, 1);

        BindingTable actualResult = edgePattern.match();
        BindingTable expectedResult = new BindingTable(true, new String[]{"1"});

        expectedResult.addRecord(records[0]);
        expectedResult.addRecord(records[1]);
        expectedResult.addRecord(records[2]);
        expectedResult.addRecord(records[4]);

        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    @Test
    public void testMatchEdgePatternWithLabel() {
        ArrayList<ArrayList<Label>> label = new ArrayList<>();
        addLabelSetTo(label, new String[]{"Does"});
        EdgePattern edgePattern = new EdgePattern(null, label, null, Direction.LEFT_TO_RIGHT, 1);

        BindingTable actualResult = edgePattern.match();
        BindingTable expectedResult = new BindingTable(true, new String[]{"1"});

        expectedResult.addRecord(records[0]);

        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    @Test
    public void testMatchEdgePatternWithLabelConjunction() {
        ArrayList<ArrayList<Label>> labelSetList = new ArrayList<>();
        addLabelSetTo(labelSetList, new String[]{"Does", "Teaches"});
        EdgePattern edgePattern = new EdgePattern(null, labelSetList, null, Direction.LEFT_TO_RIGHT, 1);

        BindingTable actualResult = edgePattern.match();
        BindingTable expectedResult = new BindingTable(true, new String[]{"1"});

        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    @Test
    public void testMatchEdgePatternWithLabelDisjunction() {
        ArrayList<ArrayList<Label>> labelSetList = new ArrayList<>();
        addLabelSetTo(labelSetList, new String[]{"Does"});
        addLabelSetTo(labelSetList, new String[]{"Supervises"});
        EdgePattern edgePattern = new EdgePattern(null, labelSetList, null, Direction.LEFT_TO_RIGHT, 1);

        BindingTable actualResult = edgePattern.match();
        BindingTable expectedResult = new BindingTable(true, new String[]{"1"});

        expectedResult.addRecord(records[0]);
        expectedResult.addRecord(records[4]);

        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    @Test
    public void testMatchEdgePatternWithProperty() {
        HashMap<GqlIdentifier, Value> properties = new HashMap<>();
        properties.put(new GqlIdentifier("in_semester"), new FixedPointNumber("2"));
        EdgePattern edgePattern = new EdgePattern(null, null, properties, Direction.LEFT_TO_RIGHT, 1);

        BindingTable actualResult = edgePattern.match();
        BindingTable expectedResult = new BindingTable(true, new String[]{"1"});

        expectedResult.addRecord(records[0]);

        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    @Test
    public void testMatchEdgePatternWithProperties() {
        HashMap<GqlIdentifier, Value> properties = new HashMap<>();
        properties.put(new GqlIdentifier("in_semester"), new FixedPointNumber("2"));
        properties.put(new GqlIdentifier("id"), new GqlString(""));
        EdgePattern edgePattern = new EdgePattern(null, null, properties, Direction.LEFT_TO_RIGHT, 1);

        BindingTable actualResult = edgePattern.match();
        BindingTable expectedResult = new BindingTable(true, new String[]{"1"});

        System.out.println(edgePattern);
        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    @Test
    public void testMatchEdgePatternWithIdAndLabelsAndProperty() {
        ArrayList<ArrayList<Label>> labelSetList = new ArrayList<>();
        addLabelSetTo(labelSetList, new String[]{"Does"});
        addLabelSetTo(labelSetList, new String[]{"Supervises"});

        HashMap<GqlIdentifier, Value> properties = new HashMap<>();
        properties.put(new GqlIdentifier("in_semester"), new FixedPointNumber("2"));

        EdgePattern edgePattern = new EdgePattern(new VariableName("x"), labelSetList, properties, Direction.LEFT_TO_RIGHT, 1);

        BindingTable actualResult = edgePattern.match();
        BindingTable expectedResult = new BindingTable(true, new String[]{"1"});

        expectedResult.addRecord(records[0]);

        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    @Test
    public void testMatchWithEmptyResult() {
        HashMap<GqlIdentifier, Value> properties = new HashMap<>();
        properties.put(new GqlIdentifier("NonexistingID"), new GqlString("Does not produce results"));
        EdgePattern edgePattern = new EdgePattern(null, null, properties, Direction.LEFT_TO_RIGHT, 1);

        BindingTable actualResult = edgePattern.match();
        BindingTable expectedResult = new BindingTable(true, new String[]{"1"});

        checkIfBindingTablesAreEqual(expectedResult, actualResult);
    }

    // toString()
    @Test
    public void testToStringEmptyEdgePattern() {
        EdgePattern edgePattern = new EdgePattern(null, null, null, Direction.LEFT_TO_RIGHT, 1);

        String expectedResult = "(->, nil, {}, {}, (1, 1))";
        assertEquals(expectedResult, edgePattern.toString());
    }

    @Test
    public void testToStringEdgePatternWithId() {
        EdgePattern edgePattern = new EdgePattern(new VariableName("x"), null, null, Direction.RIGHT_TO_LEFT, 1);

        String expectedResult = "(<-, x, {}, {}, (1, 1))";
        assertEquals(expectedResult, edgePattern.toString());
    }

    @Test
    public void testToStringEdgePatternWithLabel() {
        ArrayList<ArrayList<Label>> label = new ArrayList<>();
        addLabelSetTo(label, new String[]{"Does"});
        EdgePattern edgePattern = new EdgePattern(null, label, null, Direction.LEFT_TO_RIGHT, 1);

        String expectedResult = "(->, nil, {{Does}}, {}, (1, 1))";
        assertEquals(expectedResult, edgePattern.toString());
    }

    @Test
    public void testToStringEdgePatternWithLabelConjunction() {
        ArrayList<ArrayList<Label>> labelSetList = new ArrayList<>();
        addLabelSetTo(labelSetList, new String[]{"Does", "AreColleagues"});
        EdgePattern edgePattern = new EdgePattern(null, labelSetList, null, Direction.UNDIRECTED, 1);

        String expectedResult = "(-, nil, {{Does, AreColleagues}}, {}, (1, 1))";
        assertEquals(expectedResult, edgePattern.toString());
    }

    @Test
    public void testToStringEdgePatternWithLabelDisjunction() {
        ArrayList<ArrayList<Label>> labelSetList = new ArrayList<>();
        addLabelSetTo(labelSetList, new String[]{"AreColleagues"});
        addLabelSetTo(labelSetList, new String[]{"Does"});
        EdgePattern edgePattern = new EdgePattern(null, labelSetList, null, Direction.LEFT_TO_RIGHT, 1);

        String expectedResult = "(->, nil, {{AreColleagues}, {Does}}, {}, (1, 1))";
        assertEquals(expectedResult, edgePattern.toString());
    }

    @Test
    public void testToStringEdgePatternWithProperty() {
        HashMap<GqlIdentifier, Value> properties = new HashMap<>();
        properties.put(new GqlIdentifier("in_semester"), new FixedPointNumber("2"));
        EdgePattern edgePattern = new EdgePattern(null, null, properties, Direction.RIGHT_TO_LEFT, 1);

        String expectedResult = "(<-, nil, {}, {(in_semester: 2)}, (1, 1))";
        assertEquals(expectedResult, edgePattern.toString());
    }

    @Test
    public void testToStringEdgePatternWithIdAndLabelsAndProperty() {
        ArrayList<ArrayList<Label>> labelSetList = new ArrayList<>();
        addLabelSetTo(labelSetList, new String[]{"AreColleagues"});
        addLabelSetTo(labelSetList, new String[]{"Does"});

        HashMap<GqlIdentifier, Value> properties = new HashMap<>();
        properties.put(new GqlIdentifier("in_semester"), new FixedPointNumber("2"));

        EdgePattern edgePattern = new EdgePattern(new VariableName("x"), labelSetList, properties, Direction.RIGHT_TO_LEFT, 1);

        String expectedResult = "(<-, x, {{AreColleagues}, {Does}}, {(in_semester: 2)}, (1, 1))";
        assertEquals(expectedResult, edgePattern.toString());
    }

    @Test
    public void testToStringEdgePatternWithQuantifier() {
        EdgePattern edgePattern = new EdgePattern(null, null, null, Direction.LEFT_TO_RIGHT, 1985);

        String expectedResult = "(->, nil, {}, {}, (1985, 1985))";
        assertEquals(expectedResult, edgePattern.toString());
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