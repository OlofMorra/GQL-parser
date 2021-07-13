package gql.graphs;

import gql.expressions.values.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.*;

public class GqlNodeTest {
    ArrayList<Label> labels = new ArrayList<Label>(Arrays.asList(
            new Label("Test"),
            new Label("Labels")
    ));

    HashMap<GqlIdentifier, Value> properties = new HashMap<>();

    GqlNode nodeWithoutLabelsAndProperties = new GqlNode(new GqlIdentifier("n1"), new ArrayList<>(), new HashMap<>());
    GqlNode nodeWithoutLabelsAndProperties2 = new GqlNode(new GqlIdentifier("n1"), new ArrayList<>(), new HashMap<>());
    GqlNode nodeWithLabels = new GqlNode(new GqlIdentifier("n1"), labels, new HashMap<>());
    GqlNode nodeWithProperties = new GqlNode(new GqlIdentifier("n1"), new ArrayList<>(), new HashMap<>());
    GqlNode nodeWithLabelsAndProperties = new GqlNode(new GqlIdentifier("n1"), labels, new HashMap<>());


    @Before
    public void setUp() {
        properties.put(new GqlIdentifier("age"), new FixedPointNumber("25"));
        properties.put(new GqlIdentifier("name"), new GqlString("Olof"));

        nodeWithProperties.properties = properties;
        nodeWithLabelsAndProperties.properties = properties;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsSmallerOrEqualThan() {
        nodeWithProperties.isSmallerOrEqualThan(nodeWithLabels);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsLargerThan() {
        nodeWithProperties.isLargerThan(nodeWithLabels);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsLargerOrEqualThan() {
        nodeWithProperties.isLargerOrEqualThan(nodeWithLabels);
    }

    @Test
    public void testIsEqualTo() {
        assertEquals(new TruthValue(true), nodeWithoutLabelsAndProperties.isEqualTo(nodeWithoutLabelsAndProperties2));
        assertEquals(new TruthValue(false), nodeWithoutLabelsAndProperties.isEqualTo(nodeWithLabels));
        assertEquals(new TruthValue(false), nodeWithoutLabelsAndProperties.isEqualTo(nodeWithProperties));
        assertEquals(new TruthValue(false), nodeWithoutLabelsAndProperties.isEqualTo(nodeWithLabelsAndProperties));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsSmallerThan() {
        nodeWithProperties.isSmallerThan(nodeWithLabels);
    }

    @Test
    public void testNodeWithoutLabelsAndPropertiesToString() {
        String expected = "{\"identity\": \"n1\"}";
        assertEquals(expected, nodeWithoutLabelsAndProperties.toString());
    }

    @Test
    public void testNodeWithPropertiesToString() {
        String expected = "{\"identity\": \"n1\", \"properties\": {\"age\": 25, \"name\": \"Olof\"}}";
        assertEquals(expected, nodeWithProperties.toString());
    }

    @Test
    public void testNodeWithLabelsToString() {
        String expected = "{\"identity\": \"n1\", \"labels\": [\"Test\", \"Labels\"]}";
        assertEquals(expected, nodeWithLabels.toString());
    }

    @Test
    public void testNodeWithLabelsAndPropertiesToString() {
        String expected = "{\"identity\": \"n1\", \"labels\": [\"Test\", \"Labels\"], \"properties\": {\"age\": 25, \"name\": \"Olof\"}}";
        assertEquals(expected, nodeWithLabelsAndProperties.toString());
    }
}