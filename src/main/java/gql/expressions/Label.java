package gql.expressions;

import java.util.Objects;

public class Label {
    GqlIdentifier label;

    public Label(String label) {
        this.label = new GqlIdentifier(label);
    }

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
