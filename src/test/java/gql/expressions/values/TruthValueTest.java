package gql.expressions.values;

import gql.expressions.values.TruthValue;
import org.junit.Test;

import static org.junit.Assert.*;

public class TruthValueTest {
    private final TruthValue TRUE = new TruthValue(true);
    private final TruthValue FALSE = new TruthValue(false);
    private final TruthValue UNKNOWN = new TruthValue(null);

    @Test
    public void testIsTrue() {
        assertTrue(TRUE.isTrue());
        assertFalse(FALSE.isTrue());
        assertFalse(UNKNOWN.isTrue());
    }

    @Test
    public void testIsFalse() {
        assertFalse(TRUE.isFalse());
        assertTrue(FALSE.isFalse());
        assertFalse(UNKNOWN.isFalse());
    }

    @Test
    public void testIsSmallerOrEqualThan() {
        assertEquals(TRUE, FALSE.isSmallerOrEqualThan(TRUE));
        assertEquals(TRUE, FALSE.isSmallerOrEqualThan(FALSE));
        assertEquals(TRUE, TRUE.isSmallerOrEqualThan(TRUE));
        assertEquals(FALSE, TRUE.isSmallerOrEqualThan(FALSE));
        assertEquals(UNKNOWN, TRUE.isSmallerOrEqualThan(UNKNOWN));
        assertEquals(UNKNOWN, FALSE.isSmallerOrEqualThan(UNKNOWN));
    }

    @Test
    public void testIsLargerThan() {
        assertEquals(FALSE, FALSE.isLargerThan(TRUE));
        assertEquals(FALSE, FALSE.isLargerThan(FALSE));
        assertEquals(FALSE, TRUE.isLargerThan(TRUE));
        assertEquals(TRUE, TRUE.isLargerThan(FALSE));
        assertEquals(UNKNOWN, TRUE.isLargerThan(UNKNOWN));
        assertEquals(UNKNOWN, FALSE.isLargerThan(UNKNOWN));
    }

    @Test
    public void testIsLargerOrEqualThan() {
        assertEquals(FALSE, FALSE.isLargerOrEqualThan(TRUE));
        assertEquals(TRUE, FALSE.isLargerOrEqualThan(FALSE));
        assertEquals(TRUE, TRUE.isLargerOrEqualThan(TRUE));
        assertEquals(TRUE, TRUE.isLargerOrEqualThan(FALSE));
        assertEquals(UNKNOWN, TRUE.isLargerOrEqualThan(UNKNOWN));
        assertEquals(UNKNOWN, FALSE.isLargerOrEqualThan(UNKNOWN));
    }

    @Test
    public void getNegation() {
        assertEquals(TRUE, FALSE.getNegation());
        assertEquals(FALSE, TRUE.getNegation());
        assertEquals(UNKNOWN, UNKNOWN.getNegation());
    }

    @Test
    public void isEqualTo() {
        assertEquals(TRUE, TRUE.isEqualTo(TRUE));
        assertEquals(TRUE, FALSE.isEqualTo(FALSE));
        assertEquals(FALSE, TRUE.isEqualTo(FALSE));
        assertEquals(FALSE, FALSE.isEqualTo(TRUE));
        assertEquals(UNKNOWN, TRUE.isEqualTo(UNKNOWN));
        assertEquals(UNKNOWN, FALSE.isEqualTo(UNKNOWN));
    }

    @Test
    public void isSmallerThan() {
        assertEquals(TRUE, FALSE.isSmallerThan(TRUE));
        assertEquals(FALSE, FALSE.isSmallerThan(FALSE));
        assertEquals(FALSE, TRUE.isSmallerThan(TRUE));
        assertEquals(FALSE, TRUE.isSmallerThan(FALSE));
        assertEquals(UNKNOWN, TRUE.isSmallerThan(UNKNOWN));
        assertEquals(UNKNOWN, FALSE.isSmallerThan(UNKNOWN));
    }

    @Test
    public void testLength() {
        assertEquals(4, TRUE.length());
        assertEquals(5, FALSE.length());
        assertEquals(7, UNKNOWN.length());
    }

    @Test
    public void testEquals() {
        assertTrue(new TruthValue(false).equals(new TruthValue(false)));
        assertTrue(new TruthValue(true).equals(new TruthValue(true)));
        assertTrue(new TruthValue(null).equals(new TruthValue(null)));

        assertFalse(new TruthValue(true).equals(new TruthValue(false)));
        assertFalse(new TruthValue(true).equals(new TruthValue(null)));
        assertFalse(new TruthValue(false).equals(new TruthValue(true)));
        assertFalse(new TruthValue(false).equals(new TruthValue(null)));
        assertFalse(new TruthValue(null).equals(new TruthValue(true)));
        assertFalse(new TruthValue(null).equals(new TruthValue(false)));
    }

    @Test
    public void testHashCode() {
        assertEquals(FALSE.hashCode(), new TruthValue(false).hashCode());
        assertEquals(TRUE.hashCode(), new TruthValue(true).hashCode());
        assertEquals(UNKNOWN.hashCode(), new TruthValue(null).hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("TRUE", TRUE.toString());
        assertEquals("FALSE", FALSE.toString());
        assertEquals("UNKNOWN", UNKNOWN.toString());
    }
}