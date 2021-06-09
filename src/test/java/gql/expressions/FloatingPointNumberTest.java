package gql.expressions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FloatingPointNumberTest {
    private final TruthValue TRUE = new TruthValue(true);
    private final TruthValue FALSE = new TruthValue(false);
    private final TruthValue UNKNOWN = new TruthValue(null);

    private FloatingPointNumber[] numbers;

    @Before
    public void setNumbers() {
        FloatingPointNumber number0 = new FloatingPointNumber("0");
        FloatingPointNumber number1 = new FloatingPointNumber("1.23E45");
        FloatingPointNumber number2 = new FloatingPointNumber("1.23E45");
        FloatingPointNumber number3 = new FloatingPointNumber("1.23E-45");
        FloatingPointNumber number4 = new FloatingPointNumber("1.23E-45");
        FloatingPointNumber number5 = new FloatingPointNumber("1.23E+45");
        FloatingPointNumber number6 = new FloatingPointNumber("1.23E+45");
        FloatingPointNumber number7 = new FloatingPointNumber("-1.23E45");
        FloatingPointNumber number8 = new FloatingPointNumber("-1.23E45");

        numbers = new FloatingPointNumber[]{number0, number1, number2, number3, number4,
            number5, number6, number7, number8};
    }

    @Test
    public void testIsSmallerOrEqualThan() {
        assertEquals(TRUE, numbers[1].isSmallerOrEqualThan(numbers[2]));
        assertEquals(TRUE, numbers[3].isSmallerOrEqualThan(numbers[4]));
        assertEquals(TRUE, numbers[5].isSmallerOrEqualThan(numbers[6]));
        assertEquals(TRUE, numbers[7].isSmallerOrEqualThan(numbers[8]));
        assertEquals(TRUE, numbers[1].isSmallerOrEqualThan(numbers[5]));
        assertEquals(TRUE, numbers[0].isSmallerOrEqualThan(numbers[1]));
        assertEquals(TRUE, numbers[3].isSmallerOrEqualThan(numbers[5]));

        assertEquals(FALSE, numbers[1].isSmallerOrEqualThan(numbers[3]));
        assertEquals(FALSE, numbers[1].isSmallerOrEqualThan(numbers[7]));
        assertEquals(FALSE, numbers[3].isSmallerOrEqualThan(numbers[7]));
        assertEquals(FALSE, numbers[5].isSmallerOrEqualThan(numbers[7]));
    }

    @Test
    public void testIsLargerThan() {
        assertEquals(FALSE, numbers[1].isLargerThan(numbers[2]));
        assertEquals(FALSE, numbers[3].isLargerThan(numbers[4]));
        assertEquals(FALSE, numbers[5].isLargerThan(numbers[6]));
        assertEquals(FALSE, numbers[7].isLargerThan(numbers[8]));
        assertEquals(FALSE, numbers[1].isLargerThan(numbers[5]));
        assertEquals(FALSE, numbers[0].isLargerThan(numbers[1]));
        assertEquals(FALSE, numbers[3].isLargerThan(numbers[5]));

        assertEquals(TRUE, numbers[1].isLargerThan(numbers[3]));
        assertEquals(TRUE, numbers[1].isLargerThan(numbers[7]));
        assertEquals(TRUE, numbers[3].isLargerThan(numbers[7]));
        assertEquals(TRUE, numbers[5].isLargerThan(numbers[7]));
    }

    @Test
    public void testIsLargerOrEqualThan() {
        assertEquals(TRUE, numbers[1].isLargerOrEqualThan(numbers[2]));
        assertEquals(TRUE, numbers[3].isLargerOrEqualThan(numbers[4]));
        assertEquals(TRUE, numbers[5].isLargerOrEqualThan(numbers[6]));
        assertEquals(TRUE, numbers[7].isLargerOrEqualThan(numbers[8]));
        assertEquals(TRUE, numbers[3].isLargerOrEqualThan(numbers[7]));
        assertEquals(TRUE, numbers[1].isLargerOrEqualThan(numbers[5]));
        assertEquals(TRUE, numbers[1].isLargerOrEqualThan(numbers[3]));
        assertEquals(TRUE, numbers[1].isLargerOrEqualThan(numbers[7]));
        assertEquals(TRUE, numbers[5].isLargerOrEqualThan(numbers[7]));

        assertEquals(FALSE, numbers[0].isLargerOrEqualThan(numbers[1]));
        assertEquals(FALSE, numbers[3].isLargerOrEqualThan(numbers[5]));
    }

    @Test
    public void testIsEqualTo() {
        assertEquals(TRUE, numbers[1].isEqualTo(numbers[2]));
        assertEquals(TRUE, numbers[3].isEqualTo(numbers[4]));
        assertEquals(TRUE, numbers[5].isEqualTo(numbers[6]));
        assertEquals(TRUE, numbers[7].isEqualTo(numbers[8]));
        assertEquals(TRUE, numbers[1].isEqualTo(numbers[5]));

        assertEquals(FALSE, numbers[0].isEqualTo(numbers[1]));
        assertEquals(FALSE, numbers[1].isEqualTo(numbers[3]));
        assertEquals(FALSE, numbers[1].isEqualTo(numbers[7]));
        assertEquals(FALSE, numbers[3].isEqualTo(numbers[5]));
        assertEquals(FALSE, numbers[3].isEqualTo(numbers[7]));
        assertEquals(FALSE, numbers[5].isEqualTo(numbers[7]));
    }

    @Test
    public void testIsSmallerThan() {
        assertEquals(FALSE, numbers[1].isSmallerThan(numbers[2]));
        assertEquals(FALSE, numbers[3].isSmallerThan(numbers[4]));
        assertEquals(FALSE, numbers[5].isSmallerThan(numbers[6]));
        assertEquals(FALSE, numbers[7].isSmallerThan(numbers[8]));
        assertEquals(FALSE, numbers[3].isSmallerThan(numbers[7]));
        assertEquals(FALSE, numbers[1].isSmallerThan(numbers[5]));
        assertEquals(FALSE, numbers[1].isSmallerThan(numbers[3]));
        assertEquals(FALSE, numbers[1].isSmallerThan(numbers[7]));
        assertEquals(FALSE, numbers[5].isSmallerThan(numbers[7]));

        assertEquals(TRUE, numbers[0].isSmallerThan(numbers[1]));
        assertEquals(TRUE, numbers[3].isSmallerThan(numbers[5]));
    }

    @Test
    public void testLength() {
        assertEquals(3, numbers[0].length());
        assertEquals(7, numbers[1].length());
        assertEquals(8, numbers[3].length());
        assertEquals(7, numbers[5].length());
        assertEquals(8, numbers[7].length());
    }

    @Test
    public void testToString() {
        assertEquals("0.0", numbers[0].toString());
        assertEquals("1.23E45", numbers[1].toString());
        assertEquals("1.23E-45", numbers[3].toString());
        assertEquals("1.23E45", numbers[5].toString());
        assertEquals("-1.23E45", numbers[7].toString());
    }
}