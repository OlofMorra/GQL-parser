package gql.expressions.values;

public class WildcardLabel extends Label {
    public WildcardLabel() {
        super("%");
    }

    @Override
    public String toString() {
        return "%";
    }

    @Override
    public String toLatex() {
        return "\\%";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o.getClass() == Label.class) return true;
        return false;
    }
}
