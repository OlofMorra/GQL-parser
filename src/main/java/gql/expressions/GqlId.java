package gql.expressions;

import java.text.Normalizer;
import java.util.Objects;

public class GqlId extends Value{
    private GqlString id;

    public GqlId(String id) {
        this.id = new GqlString(Normalizer.normalize(id, Normalizer.Form.NFKC));
    }

    public String getId() {
        return id.gqlString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GqlId gqlId = (GqlId) o;
        return id.equals(gqlId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public TruthValue isEqualTo(Value valueToCompareTo) {
        return new TruthValue(this.equals(valueToCompareTo));
    }

    @Override
    public TruthValue isSmallerThan(Value valueToCompareTo) {
        return new TruthValue(null);
    }

    @Override
    public String toString() {
        if (this.id == null) {
            return "nil";
        }

        return this.id.gqlString;
    }
}
