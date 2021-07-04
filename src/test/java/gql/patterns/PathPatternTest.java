package gql.patterns;

import exceptions.InvalidEdgeFormatException;
import exceptions.InvalidNodeFormatException;
import gql.enums.Direction;
import gql.enums.EvaluationMode;
import gql.expressions.GqlIdentifier;
import gql.expressions.Label;
import gql.expressions.Value;
import gql.graphs.WorkingGraph;
import gql.tables.BindingTable;
import gql.tables.Record;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class PathPatternTest {
    WorkingGraph graph = WorkingGraph.getInstance();
    ArrayList<ElementPattern> pathSequence = new ArrayList<>();
    ArrayList<Record> records = new ArrayList<>();
    BindingTable expectedResult;

    @Before
    public void setUp() {
        try {
            graph.setLocalGraph("g3");
        } catch (Exception e) {
            System.err.println("Exception raised when setting up working graph for node pattern tests.");
            e.printStackTrace();
        }

        pathSequence = new ArrayList<>();
        records = new ArrayList<>();
        expectedResult = null;
    }

    @Test
    public void testEvaluateOnSingleNodePattern() {
        pathSequence.add(getEmptyNodePattern("a"));
        PathPattern pathPattern = new PathPattern(null, new PathSequence(pathSequence));

        String[] columnNames = new String[]{"a"};
        expectedResult = getBindingTable(columnNames);
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n5"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n19"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n29"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n85"}));

        checkIfBindingTablesAreEqual(expectedResult, pathPattern.match(EvaluationMode.WALK));
    }

    @Test
    public void testEvaluateOnEmptyNodeToUndirectedEdgeToEmptyNode() {
        pathSequence.add(getEmptyNodePattern("a"));
        pathSequence.add(getEmptyUndirectedEdgePattern("b"));
        pathSequence.add(getEmptyNodePattern("c"));
        PathPattern pathPattern = new PathPattern(null, new PathSequence(pathSequence));

        String[] columnNames = new String[]{"a", "b", "c"};
        expectedResult = getBindingTable(columnNames);
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n29", "e21", "n19"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n19", "e21", "n29"}));

        checkIfBindingTablesAreEqual(expectedResult, pathPattern.match(EvaluationMode.WALK));
    }

    @Test
    public void testEvaluateOnEmptyUndirectedPathThatAlternatesBetweenTwoNodes() {
        pathSequence.add(getEmptyNodePattern("a"));
        pathSequence.add(getEmptyUndirectedEdgePattern("b"));
        pathSequence.add(getEmptyNodePattern("c"));
        pathSequence.add(getEmptyUndirectedEdgePattern("d"));
        pathSequence.add(getEmptyNodePattern("e"));
        pathSequence.add(getEmptyUndirectedEdgePattern("f"));
        pathSequence.add(getEmptyNodePattern("g"));
        PathPattern pathPattern = new PathPattern(null, new PathSequence(pathSequence));

        String[] columnNames = new String[]{"a", "b", "c", "d", "e", "f", "g"};
        expectedResult = getBindingTable(columnNames);
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n29", "e21", "n19", "e21", "n29", "e21", "n19"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n19", "e21", "n29", "e21", "n19", "e21", "n29"}));

        checkIfBindingTablesAreEqual(expectedResult, pathPattern.match(EvaluationMode.WALK));
    }

    @Test
    public void testEvaluateOnEmptyUndirectedPathThatAlternatesBetweenTwoNodesWithQuantifier() {
        pathSequence.add(getEmptyNodePattern("a"));
        EdgePattern emptyEdgePattern = getEmptyUndirectedEdgePattern("b");
        emptyEdgePattern.quantifier = 3;
        pathSequence.add(emptyEdgePattern);
        pathSequence.add(getEmptyNodePattern("c"));
        PathPattern pathPattern = new PathPattern(null, new PathSequence(pathSequence));

        String[] columnNames = new String[]{"a", "b", "b", "b", "b", "b", "c"};
        expectedResult = getBindingTable(columnNames);
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n29", "e21", "n19", "e21", "n29", "e21", "n19"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n19", "e21", "n29", "e21", "n19", "e21", "n29"}));

        checkIfBindingTablesAreEqual(expectedResult, pathPattern.match(EvaluationMode.WALK));
    }

    @Test
    public void testEvaluateOnEmptyNodeToLeftToRightEdgeToEmptyNode() {
        pathSequence.add(getEmptyNodePattern("a"));
        pathSequence.add(getEmptyLeftToRightEdgePattern("b"));
        pathSequence.add(getEmptyNodePattern("c"));
        PathPattern pathPattern = new PathPattern(null, new PathSequence(pathSequence));

        String[] columnNames = new String[]{"a", "b", "c"};
        expectedResult = getBindingTable(columnNames);
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n85", "e2", "n5"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n19", "e86", "n5"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n85", "e3", "n19"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n19", "e12", "n85"}));

        checkIfBindingTablesAreEqual(expectedResult, pathPattern.match(EvaluationMode.WALK));
    }

    @Test
    public void testEvaluateOnEmptyNodeToRightToLeftEdgeToEmptyNode() {
        pathSequence.add(getEmptyNodePattern("a"));
        pathSequence.add(getEmptyRightToLeftEdgePattern("b"));
        pathSequence.add(getEmptyNodePattern("c"));
        PathPattern pathPattern = new PathPattern(null, new PathSequence(pathSequence));

        String[] columnNames = new String[]{"a", "b", "c"};
        expectedResult = getBindingTable(columnNames);
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n5", "e2", "n85"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n5", "e86", "n19"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n85", "e12", "n19"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n19", "e3", "n85"}));

        checkIfBindingTablesAreEqual(expectedResult, pathPattern.match(EvaluationMode.WALK));
    }

    @Test
    public void testEvaluateOnNotExistingPath() {
        ArrayList<ArrayList<Label>> labels = new ArrayList<>();
        ArrayList<Label> labelSet = new ArrayList<>();
        labelSet.add(new Label("notExistingId"));
        labels.add(labelSet);

        pathSequence.add(new NodePattern(new VariableName("a"), labels, null));
        pathSequence.add(getEmptyLeftToRightEdgePattern("b"));
        pathSequence.add(getEmptyNodePattern("c"));
        PathPattern pathPattern = new PathPattern(null, new PathSequence(pathSequence));

        String[] columnNames = new String[]{"a", "b", "c"};
        expectedResult = getBindingTable(columnNames);

        checkIfBindingTablesAreEqual(expectedResult, pathPattern.match(EvaluationMode.WALK));
    }

    @Test
    public void testEvaluateOnLongEmptyPath() {
        pathSequence.add(getEmptyNodePattern("a"));
        pathSequence.add(getEmptyLeftToRightEdgePattern("b"));
        pathSequence.add(getEmptyNodePattern("c"));
        pathSequence.add(getEmptyLeftToRightEdgePattern("d"));
        pathSequence.add(getEmptyNodePattern("e"));
        pathSequence.add(getEmptyLeftToRightEdgePattern("f"));
        pathSequence.add(getEmptyNodePattern("g"));
        pathSequence.add(getEmptyLeftToRightEdgePattern("h"));
        pathSequence.add(getEmptyNodePattern("i"));
        pathSequence.add(getEmptyLeftToRightEdgePattern("j"));
        pathSequence.add(getEmptyNodePattern("k"));
        pathSequence.add(getEmptyLeftToRightEdgePattern("l"));
        pathSequence.add(getEmptyNodePattern("m"));
        pathSequence.add(getEmptyLeftToRightEdgePattern("n"));
        pathSequence.add(getEmptyNodePattern("o"));
        pathSequence.add(getEmptyLeftToRightEdgePattern("p"));
        pathSequence.add(getEmptyNodePattern("q"));
        pathSequence.add(getEmptyLeftToRightEdgePattern("r"));
        pathSequence.add(getEmptyNodePattern("s"));
        PathPattern pathPattern = new PathPattern(null, new PathSequence(pathSequence));

        String[] columnNames = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
                                            "l", "m", "n", "o", "p", "q", "r", "s"};
        expectedResult = getBindingTable(columnNames);
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n85", "e3", "n19", "e12", "n85", "e3", "n19", "e12", "n85", "e3", "n19", "e12", "n85", "e3", "n19", "e12", "n85", "e3", "n19"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n19", "e12", "n85", "e3", "n19", "e12", "n85", "e3", "n19", "e12", "n85", "e3", "n19", "e12", "n85", "e3", "n19", "e12", "n85"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n85", "e3", "n19", "e12", "n85", "e3", "n19", "e12", "n85", "e3", "n19", "e12", "n85", "e3", "n19", "e12", "n85", "e2", "n5"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n19", "e12", "n85", "e3", "n19", "e12", "n85", "e3", "n19", "e12", "n85", "e3", "n19", "e12", "n85", "e3", "n19", "e86", "n5"}));

        checkIfBindingTablesAreEqual(expectedResult, pathPattern.match(EvaluationMode.WALK));
    }

    @Test
    public void testWalkExample2_3() throws InvalidEdgeFormatException, FileNotFoundException, InvalidNodeFormatException {
        WorkingGraph.getInstance().setLocalGraph("g");
        pathSequence.add(getEmptyNodePattern("x"));
        pathSequence.add(getEmptyUndirectedEdgePattern());
        pathSequence.add(getEmptyNodePattern("y"));
        pathSequence.add(getEmptyUndirectedEdgePattern());
        pathSequence.add(getEmptyNodePattern("z"));
        PathPattern pathPattern = new PathPattern(null, new PathSequence(pathSequence));

        String[] columnNames = new String[]{"x", "y", "z"};
        expectedResult = getBindingTable(columnNames);
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n1","n2","n1"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n1","n2","n3"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n2","n1","n2"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n2","n3","n2"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n2","n3","n3"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n3","n2","n1"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n3","n2","n3"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n3","n3","n2"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n3","n3","n3"}));

        checkIfBindingTablesAreEqual(expectedResult, pathPattern.match(EvaluationMode.WALK));
    }

    @Test
    public void testTrailExample2_3() throws InvalidEdgeFormatException, FileNotFoundException, InvalidNodeFormatException {
        WorkingGraph.getInstance().setLocalGraph("g");
        pathSequence.add(getEmptyNodePattern("x"));
        pathSequence.add(getEmptyUndirectedEdgePattern());
        pathSequence.add(getEmptyNodePattern("y"));
        pathSequence.add(getEmptyUndirectedEdgePattern());
        pathSequence.add(getEmptyNodePattern("z"));
        PathPattern pathPattern = new PathPattern(null, new PathSequence(pathSequence));

        String[] columnNames = new String[]{"x", "y", "z"};
        expectedResult = getBindingTable(columnNames);
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n1","n2","n3"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n2","n3","n3"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n3","n2","n1"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n3","n3","n2"}));

        checkIfBindingTablesAreEqual(expectedResult, pathPattern.match(EvaluationMode.TRAIL));
    }

    @Test
    public void testSimpleExample2_3() throws InvalidEdgeFormatException, FileNotFoundException, InvalidNodeFormatException {
        WorkingGraph.getInstance().setLocalGraph("g");
        pathSequence.add(getEmptyNodePattern("x"));
        pathSequence.add(getEmptyUndirectedEdgePattern());
        pathSequence.add(getEmptyNodePattern("y"));
        pathSequence.add(getEmptyUndirectedEdgePattern());
        pathSequence.add(getEmptyNodePattern("z"));
        PathPattern pathPattern = new PathPattern(null, new PathSequence(pathSequence));

        String[] columnNames = new String[]{"x", "y", "z"};
        expectedResult = getBindingTable(columnNames);
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n1","n2","n1"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n1","n2","n3"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n2","n1","n2"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n2","n3","n2"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n3","n2","n1"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n3","n2","n3"}));

        checkIfBindingTablesAreEqual(expectedResult, pathPattern.match(EvaluationMode.SIMPLE));
    }

    @Test
    public void testAcyclicExample2_3() throws InvalidEdgeFormatException, FileNotFoundException, InvalidNodeFormatException {
        WorkingGraph.getInstance().setLocalGraph("g");
        pathSequence.add(getEmptyNodePattern("x"));
        pathSequence.add(getEmptyUndirectedEdgePattern());
        pathSequence.add(getEmptyNodePattern("y"));
        pathSequence.add(getEmptyUndirectedEdgePattern());
        pathSequence.add(getEmptyNodePattern("z"));
        PathPattern pathPattern = new PathPattern(null, new PathSequence(pathSequence));

        String[] columnNames = new String[]{"x", "y", "z"};
        expectedResult = getBindingTable(columnNames);
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n1","n2","n3"}));
        addRecordToExpectedResult(getRecord(columnNames, new String[]{"n3","n2","n1"}));

        checkIfBindingTablesAreEqual(expectedResult, pathPattern.match(EvaluationMode.ACYCLIC));
    }

    private void checkIfBindingTablesAreEqual(BindingTable expectedResult, BindingTable actualResult) {
        for (ElementPattern elementPattern: pathSequence) {
            System.out.println(elementPattern.toString());
        }
        System.out.println("Expected:");
        expectedResult.printToConsole();
        System.out.println("Actual:");
        actualResult.printToConsole();

        assertEquals(expectedResult, actualResult);
    }

    private NodePattern getEmptyNodePattern(String variableName) {
        return new NodePattern(new VariableName(variableName), null, null);
    }

    private EdgePattern getEmptyUndirectedEdgePattern(String variableName) {
        return new EdgePattern(new VariableName(variableName), null, null, Direction.UNDIRECTED, 1);
    }

    private EdgePattern getEmptyLeftToRightEdgePattern(String variableName) {
        return new EdgePattern(new VariableName(variableName), null, null, Direction.LEFT_TO_RIGHT, 1);
    }

    private EdgePattern getEmptyRightToLeftEdgePattern(String variableName) {
        return new EdgePattern(new VariableName(variableName), null, null, Direction.RIGHT_TO_LEFT, 1);
    }

    private NodePattern getEmptyNodePattern() {
        return new NodePattern(null, null, null);
    }

    private EdgePattern getEmptyUndirectedEdgePattern() {
        return new EdgePattern(null, null, null, Direction.UNDIRECTED, 1);
    }

    private EdgePattern getEmptyLeftToRightEdgePattern() {
        return new EdgePattern(null, null, null, Direction.LEFT_TO_RIGHT, 1);
    }

    private EdgePattern getEmptyRightToLeftEdgePattern() {
        return new EdgePattern(null, null, null, Direction.RIGHT_TO_LEFT, 1);
    }

    private BindingTable getBindingTable(String[] columnNames) {
        return new BindingTable(false, true, columnNames);
    }

    private void addRecordToExpectedResult(Record record) {
        this.expectedResult.addRecord(record);
    }

    private Record getRecord(String[] columnNames, String[] ids) {
        Value[] values = new Value[ids.length];

        for (int i = 0; i < ids.length; i++) {
            values[i] = new GqlIdentifier(ids[i]);
        }

        return new Record(columnNames, values);
    }
}