package gql.expressions.values;

import gql.enums.TruthValueEnum;

import java.util.Objects;

public class TruthValue extends Value {
    TruthValueEnum truthValue;

    public TruthValue(Boolean truthValue) {
        if (truthValue == null) {
            this.truthValue = TruthValueEnum.UNKNOWN;
        } else if (truthValue == true) {
            this.truthValue = TruthValueEnum.TRUE;
        } else if (truthValue == false) {
            this.truthValue = TruthValueEnum.FALSE;
        }
    }

    public TruthValue getNegation() {
        if (truthValue == TruthValueEnum.TRUE) {
            return new TruthValue(false);
        } else if (truthValue == TruthValueEnum.FALSE) {
            return new TruthValue(true);
        }

        return new TruthValue(null);
    }

    public boolean isTrue() {
        return truthValue == TruthValueEnum.TRUE;
    }

    public boolean isFalse() {
        return truthValue == TruthValueEnum.FALSE;
    }

    @Override
    public TruthValue isEqualTo(Value valueToCompareTo) {
        if (valueToCompareTo.equals(new TruthValue(null))) {
            return new TruthValue(null);
        } else if (valueToCompareTo instanceof TruthValue) {
            return new TruthValue(truthValue == ((TruthValue) valueToCompareTo).truthValue);
        }

        throw new IllegalArgumentException("Cannot compare TruthValue to type " + valueToCompareTo.getClass() + ".");
    }

    @Override
    public TruthValue isSmallerThan(Value valueToCompareTo) {
        if (valueToCompareTo.equals(new TruthValue(null))) {
            return new TruthValue(null);
        } else if (valueToCompareTo instanceof TruthValue) {
            if (truthValue == TruthValueEnum.FALSE && ((TruthValue) valueToCompareTo).truthValue == TruthValueEnum.TRUE) {
                return new TruthValue(true);
            }
            return new TruthValue(false);
        }

        throw new IllegalArgumentException("Cannot compare TruthValue to type " + valueToCompareTo.getClass() + ".");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TruthValue that = (TruthValue) o;
        return this.truthValue == that.truthValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(truthValue);
    }

    @Override
    public String toString() {
        return truthValue.name();
    }
}
