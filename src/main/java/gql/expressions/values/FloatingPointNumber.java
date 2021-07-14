package gql.expressions.values;

import exceptions.SemanticErrorException;

import java.util.Objects;

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

        throw new SemanticErrorException("Cannot compare type FloatingPoint to type " + valueToCompareTo.getClass() + ".");
    }

    @Override
    public TruthValue isSmallerThan(Value valueToCompareTo) {
        if (valueToCompareTo.equals(new TruthValue(null))) {
            return new TruthValue(null);
        } else if (valueToCompareTo instanceof FloatingPointNumber) {
            return new TruthValue(floatingPointNumber < ((FloatingPointNumber) valueToCompareTo).floatingPointNumber);
        }

        throw new SemanticErrorException("Cannot compare type FloatingPoint to type " + valueToCompareTo.getClass() + ".");
    }

    @Override
    public String toString() {
        return Double.toString(floatingPointNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FloatingPointNumber that = (FloatingPointNumber) o;
        return this.isEqualTo(that).equals(new TruthValue(true));
    }

    @Override
    public int hashCode() {
        return Objects.hash(floatingPointNumber);
    }
}
