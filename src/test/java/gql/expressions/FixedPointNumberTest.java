package gql.expressions;

import org.junit.Test;

import static org.junit.Assert.*;

public class FixedPointNumberTest {
    private final TruthValue TRUE = new TruthValue(true);
    private final TruthValue FALSE = new TruthValue(false);
    private final TruthValue UNKNOWN = new TruthValue(null);
    
    
    @Test
    public void testLengthOnInteger() {
        FixedPointNumber testFixedPointNumber = new FixedPointNumber("12345", "1");
        assertEquals("Length of " + testFixedPointNumber.toString() + " was not equal to 7.", 7, testFixedPointNumber.length());
    }

    @Test
    public void testLengthOnSingleDigitInteger() {
        FixedPointNumber testFixedPointNumber = new FixedPointNumber("1");
        assertEquals("Length of " + testFixedPointNumber.toString() + " was not equal to 1.", 1, testFixedPointNumber.length());
    }

    @Test
    public void testEqualIntegers() {
        FixedPointNumber testFixedPointNumber1 = new FixedPointNumber("85");
        FixedPointNumber testFixedPointNumber2 = new FixedPointNumber("85");
        assertEquals(testFixedPointNumber1.isEqualTo(testFixedPointNumber2), TRUE);
    }

    @Test
    public void testUnequalIntegers() {
        FixedPointNumber testFixedPointNumber1 = new FixedPointNumber("19");
        FixedPointNumber testFixedPointNumber2 = new FixedPointNumber("85");
        assertEquals(testFixedPointNumber1.isEqualTo(testFixedPointNumber2), FALSE);
    }

    @Test
    public void testEqualDecimals() {
        FixedPointNumber testFixedPointNumber1 = new FixedPointNumber("19", "085");
        FixedPointNumber testFixedPointNumber2 = new FixedPointNumber("19", "08500");
        assertEquals(testFixedPointNumber1.isEqualTo(testFixedPointNumber2), TRUE);
    }

    @Test
    public void testUnequalDecimals() {
        FixedPointNumber testFixedPointNumber1 = new FixedPointNumber("19", "85");
        FixedPointNumber testFixedPointNumber2 = new FixedPointNumber("19", "085");
        assertEquals(testFixedPointNumber1.isEqualTo(testFixedPointNumber2), FALSE);
    }

    @Test
    public void testSmallerThanOnIntegers() {
        FixedPointNumber testFixedPointNumber1 = new FixedPointNumber("19");
        FixedPointNumber testFixedPointNumber2 = new FixedPointNumber("85");
        FixedPointNumber testFixedPointNumber3 = new FixedPointNumber("85");

        assertEquals(testFixedPointNumber1.isSmallerThan(testFixedPointNumber2), TRUE);
        assertEquals(testFixedPointNumber2.isSmallerThan(testFixedPointNumber1), FALSE);
        assertEquals(testFixedPointNumber3.isSmallerThan(testFixedPointNumber2), FALSE);
    }

    @Test
    public void testSmallerThanOnDecimals() {
        FixedPointNumber testFixedPointNumber1 = new FixedPointNumber("19", "85000");
        FixedPointNumber testFixedPointNumber2 = new FixedPointNumber("85", "19");
        FixedPointNumber testFixedPointNumber3 = new FixedPointNumber("85", "1");
        FixedPointNumber testFixedPointNumber4 = new FixedPointNumber("85", "19");

        assertEquals(testFixedPointNumber1.isSmallerThan(testFixedPointNumber2), TRUE);
        assertEquals(testFixedPointNumber2.isSmallerThan(testFixedPointNumber1), FALSE);
        assertEquals(testFixedPointNumber3.isSmallerThan(testFixedPointNumber2), TRUE);
        assertEquals(testFixedPointNumber2.isSmallerThan(testFixedPointNumber3), FALSE);
        assertEquals(testFixedPointNumber2.isSmallerThan(testFixedPointNumber4), FALSE);
    }

    @Test
    public void testSmallerThanOrEqualsOnIntegers() {
        FixedPointNumber testFixedPointNumber1 = new FixedPointNumber("1985");
        FixedPointNumber testFixedPointNumber2 = new FixedPointNumber("1985");
        FixedPointNumber testFixedPointNumber3 = new FixedPointNumber("85");

        assertEquals(testFixedPointNumber1.isSmallerOrEqualThan(testFixedPointNumber2), TRUE);
        assertEquals(testFixedPointNumber2.isSmallerOrEqualThan(testFixedPointNumber1), TRUE);
        assertEquals(testFixedPointNumber3.isSmallerOrEqualThan(testFixedPointNumber1), TRUE);
        assertEquals(testFixedPointNumber1.isSmallerOrEqualThan(testFixedPointNumber3), FALSE);
    }

    @Test
    public void testSmallerThanOrEqualsOnDecimals() {
        FixedPointNumber testFixedPointNumber1 = new FixedPointNumber("1985", "19");
        FixedPointNumber testFixedPointNumber2 = new FixedPointNumber("1985", "190");
        FixedPointNumber testFixedPointNumber3 = new FixedPointNumber("1985", "123458");

        assertEquals(testFixedPointNumber1.isSmallerOrEqualThan(testFixedPointNumber2), TRUE);
        assertEquals(testFixedPointNumber2.isSmallerOrEqualThan(testFixedPointNumber1), TRUE);
        assertEquals(testFixedPointNumber3.isSmallerOrEqualThan(testFixedPointNumber1), TRUE);
        assertEquals(testFixedPointNumber1.isSmallerOrEqualThan(testFixedPointNumber3), FALSE);
    }

    @Test
    public void testLargerThanOnIntegers() {
        FixedPointNumber testFixedPointNumber1 = new FixedPointNumber("85");
        FixedPointNumber testFixedPointNumber2 = new FixedPointNumber("19");
        FixedPointNumber testFixedPointNumber3 = new FixedPointNumber("19");

        assertEquals(testFixedPointNumber1.isLargerThan(testFixedPointNumber2), TRUE);
        assertEquals(testFixedPointNumber2.isLargerThan(testFixedPointNumber1), FALSE);
        assertEquals(testFixedPointNumber3.isLargerThan(testFixedPointNumber2), FALSE);
    }

    @Test
    public void testLargerThanOnDecimals() {
        FixedPointNumber testFixedPointNumber1 = new FixedPointNumber("19", "85000");
        FixedPointNumber testFixedPointNumber2 = new FixedPointNumber("85", "19");
        FixedPointNumber testFixedPointNumber3 = new FixedPointNumber("85", "1");
        FixedPointNumber testFixedPointNumber4 = new FixedPointNumber("85", "19");

        assertEquals(testFixedPointNumber1.isLargerThan(testFixedPointNumber2), FALSE);
        assertEquals(testFixedPointNumber2.isLargerThan(testFixedPointNumber1), TRUE);
        assertEquals(testFixedPointNumber3.isLargerThan(testFixedPointNumber2), FALSE);
        assertEquals(testFixedPointNumber2.isLargerThan(testFixedPointNumber3), TRUE);
        assertEquals(testFixedPointNumber2.isLargerThan(testFixedPointNumber4), FALSE);
    }

    @Test
    public void testLargerThanOrEqualsOnIntegers() {
        FixedPointNumber testFixedPointNumber1 = new FixedPointNumber("1985");
        FixedPointNumber testFixedPointNumber2 = new FixedPointNumber("1985");
        FixedPointNumber testFixedPointNumber3 = new FixedPointNumber("1996");

        assertEquals(testFixedPointNumber1.isLargerOrEqualThan(testFixedPointNumber2), TRUE);
        assertEquals(testFixedPointNumber2.isLargerOrEqualThan(testFixedPointNumber1), TRUE);
        assertEquals(testFixedPointNumber3.isLargerOrEqualThan(testFixedPointNumber1), TRUE);
        assertEquals(testFixedPointNumber1.isLargerOrEqualThan(testFixedPointNumber3), FALSE);
    }

    @Test
    public void testLargerThanOrEqualsOnDecimals() {
        FixedPointNumber testFixedPointNumber1 = new FixedPointNumber("1985", "19");
        FixedPointNumber testFixedPointNumber2 = new FixedPointNumber("1985", "190");
        FixedPointNumber testFixedPointNumber3 = new FixedPointNumber("1985", "123458");

        assertEquals(testFixedPointNumber1.isLargerOrEqualThan(testFixedPointNumber2), TRUE);
        assertEquals(testFixedPointNumber2.isLargerOrEqualThan(testFixedPointNumber1), TRUE);
        assertEquals(testFixedPointNumber3.isLargerOrEqualThan(testFixedPointNumber1), FALSE);
        assertEquals(testFixedPointNumber1.isLargerOrEqualThan(testFixedPointNumber3), TRUE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNumberToGqlStringComparison() {
        FixedPointNumber fixedPointNumber = new FixedPointNumber("85");
        GqlString gqlString = new GqlString("test");

        fixedPointNumber.isEqualTo(gqlString);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNumberToTrueComparison() {
        FixedPointNumber fixedPointNumber = new FixedPointNumber("85");

        fixedPointNumber.isEqualTo(TRUE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNumberToFalseComparison() {
        FixedPointNumber fixedPointNumber = new FixedPointNumber("85");

        fixedPointNumber.isEqualTo(FALSE);
    }

    @Test
    public void testNumberToUnknownComparison() {
        FixedPointNumber fixedPointNumber = new FixedPointNumber("85");

        assertEquals(fixedPointNumber.isEqualTo(UNKNOWN), UNKNOWN);
    }
}