package gql.expressions;

import org.junit.Test;

import static org.junit.Assert.*;

public class GqlStringTest {
    private final TruthValue TRUE = new TruthValue(true);
    private final TruthValue FALSE = new TruthValue(false);
    private final TruthValue UNKNOWN = new TruthValue(null);

    @Test
    public void testGqlStringEquals() {
        GqlString first = new GqlString("test");
        GqlString second = new GqlString("test");

        assertEquals(first.isEqualTo(second), TRUE);
    }

    @Test
    public void testGqlStringNotEquals() {
        GqlString first = new GqlString("definitely");
        GqlString second = new GqlString("not equal");

        assertEquals(first.isEqualTo(second), FALSE);
    }

    @Test
    public void testGqlStringNotEqualsOnCapitals() {
        GqlString first = new GqlString("test");
        GqlString second = new GqlString("Test");

        assertEquals(first.isEqualTo(second), FALSE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGqlStringToNumberComparison() {
        GqlString gqlString = new GqlString("test");
        FixedPointNumber fixedPointNumber = new FixedPointNumber("85");

        gqlString.isEqualTo(fixedPointNumber);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGqlStringToTrueComparison() {
        GqlString gqlString = new GqlString("test");

        gqlString.isEqualTo(TRUE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGqlStringToFalseComparison() {
        GqlString gqlString = new GqlString("test");

        gqlString.isEqualTo(FALSE);
    }

    @Test
    public void testGqlStringToUnknownComparison() {
        GqlString gqlString = new GqlString("test");

        assertEquals(gqlString.isEqualTo(UNKNOWN), UNKNOWN);
    }

    // TODO: Do I want to add test cases for inequalities as they
    //  depend on the strength of the collator.
}