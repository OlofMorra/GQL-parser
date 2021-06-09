package gql.expressions;

import java.text.Collator;
import java.util.Locale;

public class GqlString extends Value {
    String gqlString;
    Collator collator = Collator.getInstance(Locale.getDefault());

    public GqlString(String gqlString) {
        this.gqlString = gqlString;
    }

    @Override
    public TruthValue isEqualTo(Value valueToCompareTo) {
        if (valueToCompareTo.equals(new TruthValue(null))) {
            return new TruthValue(null);
        } else if (valueToCompareTo instanceof GqlString) {
            return new TruthValue(collator.compare(gqlString, ((GqlString) valueToCompareTo).gqlString) == 0);
        }

        throw new IllegalArgumentException("Cannot compare type GqlString to type " + valueToCompareTo.getClass() + ".");
    }

    @Override
    public TruthValue isSmallerThan(Value valueToCompareTo) {
        if (valueToCompareTo.equals(new TruthValue(null))) {
            return new TruthValue(null);
        } else if (valueToCompareTo instanceof GqlString) {
            return new TruthValue(collator.compare(gqlString, ((GqlString) valueToCompareTo).gqlString) < 0);
        }

        throw new IllegalArgumentException("Cannot compare type GqlString to type " + valueToCompareTo.getClass() + ".");
    }

    @Override
    public String toString() {
        return gqlString;
    }
}
