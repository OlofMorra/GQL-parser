package gql.expressions.values;

import java.util.Objects;

public class FixedPointNumber extends Value {
    private final int digitsBeforeRadixPoint;
    private final String digitsAfterRadixPoint;

    public FixedPointNumber(String digitString) {
        String[] split = digitString.split("[.]", 0);

        this.digitsBeforeRadixPoint = Integer.parseInt(split[0]);

        if (split.length == 2) {
            this.digitsAfterRadixPoint = split[1];
        } else {
            this.digitsAfterRadixPoint = "";
        }
    }

    public FixedPointNumber(String digitsBeforeRadixPoint, String digitsAfterRadixPoint) {
        if (Integer.parseInt(digitsAfterRadixPoint) < 0) {
            throw new IllegalArgumentException("Cannot have negative numbers after the radix point.");
        }

        this.digitsBeforeRadixPoint = Integer.parseInt(digitsBeforeRadixPoint);
        this.digitsAfterRadixPoint = digitsAfterRadixPoint;
    }

    @Override
    public TruthValue isEqualTo(Value valueToCompareTo) {
        if (valueToCompareTo.equals(new TruthValue(null))) {
            return new TruthValue(null);
        } else if (valueToCompareTo instanceof FixedPointNumber) {
            return new TruthValue(compareTo((FixedPointNumber) valueToCompareTo));
        }

        throw new IllegalArgumentException("Cannot compare type Number to type " + valueToCompareTo.getClass() + ".");
    }

    private Boolean compareTo(FixedPointNumber fixedPointNumber) {
        Boolean isEqualBeforeRadixPoint = digitsBeforeRadixPoint == fixedPointNumber.digitsBeforeRadixPoint;
        Boolean isEqualAfterRadixPoint = compareAfterRadixPoint(fixedPointNumber.digitsAfterRadixPoint);

        return isEqualBeforeRadixPoint && isEqualAfterRadixPoint;
    }

    private Boolean compareAfterRadixPoint(String digitsAfterRadixPointToCompareTo) {
        String digitsAfterRadixPointObject = this.digitsAfterRadixPoint;

        if (digitsAfterRadixPointObject.length() < digitsAfterRadixPointToCompareTo.length()) {
            digitsAfterRadixPointObject = padZeroesToRight(digitsAfterRadixPointObject, digitsAfterRadixPointToCompareTo.length());
        } else if (digitsAfterRadixPointObject.length() > digitsAfterRadixPointToCompareTo.length()) {
            digitsAfterRadixPointToCompareTo = padZeroesToRight(digitsAfterRadixPointToCompareTo, digitsAfterRadixPointObject.length());
        }

        return digitsAfterRadixPointObject.equals(digitsAfterRadixPointToCompareTo);
    }

    private String padZeroesToRight(String toPad, int length) {
        return String.format("%1$-" + length + "s", toPad).replace(' ', '0');
    }

    @Override
    public TruthValue isSmallerThan(Value valueToCompareTo) {
        if (valueToCompareTo.equals(new TruthValue(null))) {
            return new TruthValue(null);
        } else if (valueToCompareTo instanceof FixedPointNumber) {
            return new TruthValue(compareIsSmallerThan((FixedPointNumber) valueToCompareTo));
        }

        throw new IllegalArgumentException("Cannot compare type Number to type " + valueToCompareTo.getClass() + ".");
    }

    private Boolean compareIsSmallerThan(FixedPointNumber fixedPointNumber) {
        if (isSmallerThanBeforeRadixPoint(fixedPointNumber.digitsBeforeRadixPoint)) {
            return true;
        } else if (isEqualBeforeRadixPoint(fixedPointNumber.digitsBeforeRadixPoint)) {
            return isSmallerThanAfterRadixPoint(fixedPointNumber.digitsAfterRadixPoint);
        }

        return false;
    }

    private Boolean isSmallerThanBeforeRadixPoint(int digitsBeforeRadixPointToCompareTo) {
        return digitsBeforeRadixPoint < digitsBeforeRadixPointToCompareTo;
    }

    private Boolean isEqualBeforeRadixPoint(int digitsBeforeRadixPointToCompareTo) {
        return digitsBeforeRadixPoint == digitsBeforeRadixPointToCompareTo;
    }

    private Boolean isSmallerThanAfterRadixPoint(String digitsAfterRadixPointToCompareTo) {
        String digitsAfterRadixPointObject = this.digitsAfterRadixPoint;

        if (digitsAfterRadixPointObject.length() < digitsAfterRadixPointToCompareTo.length()) {
            digitsAfterRadixPointObject = padZeroesToRight(digitsAfterRadixPointObject, digitsAfterRadixPointToCompareTo.length());
        } else if (digitsAfterRadixPointObject.length() > digitsAfterRadixPointToCompareTo.length()) {
            digitsAfterRadixPointToCompareTo = padZeroesToRight(digitsAfterRadixPointToCompareTo, digitsAfterRadixPointObject.length());
        }

        int numberOfDigits = digitsAfterRadixPointObject.length();

        // If there are no digits after radix point, we have two equal numbers without digits before decimal point.
        // Hence, they are equal and not smaller than, so return false.
        if (numberOfDigits == 0) {
            return false;
        }

        // If a digit before the last digit is larger, than we must return false as it cannot be smaller anymore
        // If a digit before the last digit is smaller, than we must return true as it cannot be larger anymore
        // If all digits before the last digit are equal, than the last digit must be smaller than
        for (int i = 0; i < numberOfDigits; i++) {
            if (digitIsLarger(digitsAfterRadixPointObject.charAt(i), digitsAfterRadixPointToCompareTo.charAt(i))) {
                return false;
            } else if (digitIsSmaller(digitsAfterRadixPointObject.charAt(i), digitsAfterRadixPointToCompareTo.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    private boolean digitIsLarger(char firstDigit, char secondDigit) {
        return Integer.parseInt(String.valueOf(firstDigit)) > Integer.parseInt(String.valueOf(secondDigit));
    }

    private boolean digitIsSmaller(char firstDigit, char secondDigit) {
        return Integer.parseInt(String.valueOf(firstDigit)) < Integer.parseInt(String.valueOf(secondDigit));
    }

    @Override
    public String toString() {
        if (this.digitsAfterRadixPoint.equals("")) {
            return String.valueOf(this.digitsBeforeRadixPoint);
        }

        return this.digitsBeforeRadixPoint + "." + this.digitsAfterRadixPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FixedPointNumber that = (FixedPointNumber) o;
        return this.isEqualTo(that).equals(new TruthValue(true));
    }

    @Override
    public int hashCode() {
        return Objects.hash(digitsBeforeRadixPoint, digitsAfterRadixPoint);
    }
}
