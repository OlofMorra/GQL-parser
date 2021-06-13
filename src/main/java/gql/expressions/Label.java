package gql.expressions;

import java.util.Objects;

public class Label {
    GqlId label;

    public Label(GqlId label) {
        this.label = label;
    }

    // TODO: When label is equal to %, all labels are valid
    //  At least one label must exist
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o.getClass() == WildcardLabel.class) return true;
        if (getClass() != o.getClass()) return false;
        Label label1 = (Label) o;
        return label.equals(label1.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return this.label.toString();
    }
}
