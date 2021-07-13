package gql.expressions.values;

import org.junit.Test;

import static org.junit.Assert.*;

public class LabelTest {
    @Test
    public void testLabelEquality() {
        Label label1 = new Label("Test");
        Label label2 = new Label("Test");
        Label label3 = new Label("test");
        Label label4 = new Label("Tést");

        assertEquals(label1, label2);
        assertNotEquals(label1, label3);
        assertNotEquals(label1, label4);

        Label label5 = new Label("Test1");
        Label label6 = new Label("Test1");
        Label label7 = new Label("Test2");

        assertEquals(label5, label6);
        assertNotEquals(label6, label7);
    }

    @Test
    public void testAnyLabelEqualToWildcardLabel() {
        Label testLabel = new Label("Test");

        WildcardLabel wildcardLabel = new WildcardLabel();

        assertTrue(testLabel.equals(wildcardLabel));
    }
}