package gql.patterns;

import exceptions.SemanticErrorException;
import gql.enums.Direction;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class PathSequenceTest {
    ArrayList<ElementPattern> pathSequenceList;

    @Before
    public void setPathSequence() {
        pathSequenceList = new ArrayList<>();
    }

    @Test(expected = SemanticErrorException.class)
    public void testEmptyPathSequence() {
        PathSequence pathSequence = new PathSequence(pathSequenceList);
        assertTrue(pathSequence.pathSequence.isEmpty());
        assertEquals(0, pathSequence.size());
    }

    @Test
    public void testPathSequenceLengthOne() {
        pathSequenceList.add(getEmptyNodePattern());
        PathSequence pathSequence = new PathSequence(pathSequenceList);
        assertEquals(1, pathSequence.size());
    }

    @Test
    public void testPathSequenceLengthThree() {
        pathSequenceList.add(getEmptyNodePattern());
        pathSequenceList.add(getEmptyLeftToRightEdgePattern());
        pathSequenceList.add(getEmptyNodePattern());
        PathSequence pathSequence = new PathSequence(pathSequenceList);

        assertEquals(3, pathSequence.size());
    }

    @Test
    public void testPathSequenceWithUndirectedQuantifiedEdge() {
        pathSequenceList.add(getEmptyNodePattern());
        pathSequenceList.add(getEmptyUndirectedEdgePatternWithQuantifier(3));
        pathSequenceList.add(getEmptyNodePattern());
        PathSequence pathSequence = new PathSequence(pathSequenceList);

        ArrayList<ElementPattern> expectedPathSequenceList = new ArrayList<>();
        expectedPathSequenceList.add(getEmptyNodePattern());
        expectedPathSequenceList.add(getEmptyUndirectedEdgePattern());
        expectedPathSequenceList.add(getEmptyNodePattern());
        expectedPathSequenceList.add(getEmptyUndirectedEdgePattern());
        expectedPathSequenceList.add(getEmptyNodePattern());
        expectedPathSequenceList.add(getEmptyUndirectedEdgePattern());
        expectedPathSequenceList.add(getEmptyNodePattern());

        assertEquals(7, pathSequence.size());
        assertEquals(expectedPathSequenceList, pathSequence.pathSequence);
    }

    @Test
    public void testPathSequenceWithLeftToRightQuantifiedEdge() {
        pathSequenceList.add(getEmptyNodePattern());
        pathSequenceList.add(getEmptyLeftToRightEdgePatternWithQuantifier(4));
        pathSequenceList.add(getEmptyNodePattern());
        PathSequence pathSequence = new PathSequence(pathSequenceList);

        ArrayList<ElementPattern> expectedPathSequenceList = new ArrayList<>();
        expectedPathSequenceList.add(getEmptyNodePattern());
        expectedPathSequenceList.add(getEmptyLeftToRightEdgePattern());
        expectedPathSequenceList.add(getEmptyNodePattern());
        expectedPathSequenceList.add(getEmptyLeftToRightEdgePattern());
        expectedPathSequenceList.add(getEmptyNodePattern());
        expectedPathSequenceList.add(getEmptyLeftToRightEdgePattern());
        expectedPathSequenceList.add(getEmptyNodePattern());
        expectedPathSequenceList.add(getEmptyLeftToRightEdgePattern());
        expectedPathSequenceList.add(getEmptyNodePattern());

        assertEquals(9, pathSequence.size());
        assertEquals(expectedPathSequenceList, pathSequence.pathSequence);
    }

    @Test
    public void testPathSequenceWithRightToLeftQuantifiedEdge() {
        pathSequenceList.add(getEmptyNodePattern());
        pathSequenceList.add(getEmptyRightToLeftEdgePatternWithQuantifier(5));
        pathSequenceList.add(getEmptyNodePattern());
        PathSequence pathSequence = new PathSequence(pathSequenceList);

        ArrayList<ElementPattern> expectedPathSequenceList = new ArrayList<>();
        expectedPathSequenceList.add(getEmptyNodePattern());
        expectedPathSequenceList.add(getEmptyRightToLeftEdgePattern());
        expectedPathSequenceList.add(getEmptyNodePattern());
        expectedPathSequenceList.add(getEmptyRightToLeftEdgePattern());
        expectedPathSequenceList.add(getEmptyNodePattern());
        expectedPathSequenceList.add(getEmptyRightToLeftEdgePattern());
        expectedPathSequenceList.add(getEmptyNodePattern());
        expectedPathSequenceList.add(getEmptyRightToLeftEdgePattern());
        expectedPathSequenceList.add(getEmptyNodePattern());
        expectedPathSequenceList.add(getEmptyRightToLeftEdgePattern());
        expectedPathSequenceList.add(getEmptyNodePattern());

        assertEquals(11, pathSequence.size());
        assertEquals(expectedPathSequenceList, pathSequence.pathSequence);
    }

    @Test(expected = SemanticErrorException.class)
    public void testPathSequenceStartingWithEdge() {
        pathSequenceList.add(getEmptyUndirectedEdgePattern());
        PathSequence pathSequence = new PathSequence(pathSequenceList);
    }

    @Test(expected = SemanticErrorException.class)
    public void testPathSequenceEndingWithEdge() {
        pathSequenceList.add(getEmptyNodePattern());
        pathSequenceList.add(getEmptyLeftToRightEdgePattern());
        pathSequenceList.add(getEmptyNodePattern());
        pathSequenceList.add(getEmptyRightToLeftEdgePattern());
        PathSequence pathSequence = new PathSequence(pathSequenceList);
    }

    @Test(expected = SemanticErrorException.class)
    public void testPathSequenceWithOnlyNodes() {
        pathSequenceList.add(getEmptyNodePattern());
        pathSequenceList.add(getEmptyNodePattern());
        pathSequenceList.add(getEmptyNodePattern());
        pathSequenceList.add(getEmptyNodePattern());
        pathSequenceList.add(getEmptyNodePattern());
        PathSequence pathSequence = new PathSequence(pathSequenceList);
    }

    @Test
    public void testGetWithNode() {
        pathSequenceList.add(getEmptyNodePattern());
        pathSequenceList.add(getEmptyLeftToRightEdgePattern());
        pathSequenceList.add(getEmptyNodePattern());
        PathSequence pathSequence = new PathSequence(pathSequenceList);

        assertEquals(getEmptyNodePattern(), pathSequence.get(0));
    }

    @Test
    public void testGetWithEdge() {
        pathSequenceList.add(getEmptyNodePattern());
        pathSequenceList.add(getEmptyLeftToRightEdgePattern());
        pathSequenceList.add(getEmptyNodePattern());
        PathSequence pathSequence = new PathSequence(pathSequenceList);

        assertEquals(getEmptyLeftToRightEdgePattern(), pathSequence.get(1));
    }

    private NodePattern getEmptyNodePattern() {
        return new NodePattern(null, null, null);
    }

    private EdgePattern getEmptyUndirectedEdgePattern() {
        return getEmptyUndirectedEdgePatternWithQuantifier(1);
    }

    private EdgePattern getEmptyLeftToRightEdgePattern() {
        return getEmptyLeftToRightEdgePatternWithQuantifier(1);
    }

    private EdgePattern getEmptyRightToLeftEdgePattern() {
        return getEmptyRightToLeftEdgePatternWithQuantifier(1);
    }

    private EdgePattern getEmptyUndirectedEdgePatternWithQuantifier(int quantifier) {
        return new EdgePattern(null, null, null, Direction.UNDIRECTED, quantifier);
    }

    private EdgePattern getEmptyLeftToRightEdgePatternWithQuantifier(int quantifier) {
        return new EdgePattern(null, null, null, Direction.LEFT_TO_RIGHT, quantifier);
    }

    private EdgePattern getEmptyRightToLeftEdgePatternWithQuantifier(int quantifier) {
        return new EdgePattern(null, null, null, Direction.RIGHT_TO_LEFT, quantifier);
    }
}
