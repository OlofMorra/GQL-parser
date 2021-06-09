package gql.expressions;

import org.junit.Test;

import static org.junit.Assert.*;

public class LabelTest {
    @Test
    public void testLabelEquality() {
        GqlId id1 = new GqlId("Test");
        Label label1 = new Label(id1);

        GqlId id2 = new GqlId("Test");
        Label label2 = new Label(id2);

        GqlId id3 = new GqlId("test");
        Label label3 = new Label(id3);

        GqlId id4 = new GqlId("Tést");
        Label label4 = new Label(id4);

        assertEquals(label1, label2);
        assertNotEquals(label1, label3);
        assertNotEquals(label1, label4);

        GqlId id5 = new GqlId("Test1");
        Label label5 = new Label(id5);

        GqlId id6 = new GqlId("Test1");
        Label label6 = new Label(id6);

        GqlId id7 = new GqlId("Test1");
        Label label7 = new Label(id7);

        assertEquals(label5, label6);
        assertNotEquals(label6, label7);
    }

    @Test
    public void testAnyLabelEqualToWildcardLabel() {
        GqlId id = new GqlId("Test");
        Label testLabel = new Label(id);

        WildcardLabel wildcardLabel = new WildcardLabel(new GqlId(""));

        assertTrue(testLabel.equals(wildcardLabel));
    }
}