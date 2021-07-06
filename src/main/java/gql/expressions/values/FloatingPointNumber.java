package gql.expressions.values;

public class FloatingPointNumber extends Value {
    final double floatingPointNumber;

    public FloatingPointNumber(String floatingPointNumber) {
        this.floatingPointNumber = Double.parseDouble(floatingPointNumber);
    }

    @Override
    public TruthValue isEqualTo(Value valueToCompareTo) {
        if (valueToCompareTo.equals(new TruthValue(null))) {
            return new TruthValue(null);
        } else if (valueToCompareTo instanceof FloatingPointNumber) {
            return new TruthValue(floatingPointNumber == ((FloatingPointNumber) valueToCompareTo).floatingPointNumber);
        }

        throw new IllegalArgumentException("Cannot compare type FloatingPoint to type " + valueToCompareTo.getClass() + ".");
    }

    @Override
    public TruthValue isSmallerThan(Value valueToCompareTo) {
        if (valueToCompareTo.equals(new TruthValue(null))) {
            return new TruthValue(null);
        } else if (valueToCompareTo instanceof FloatingPointNumber) {
            return new TruthValue(floatingPointNumber < ((FloatingPointNumber) valueToCompareTo).floatingPointNumber);
        }

        throw new IllegalArgumentException("Cannot compare type FloatingPoint to type " + valueToCompareTo.getClass() + ".");
    }

    @Override
    public String toString() {
        return Double.toString(floatingPointNumber);
    }
}
