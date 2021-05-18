package gql.expr;

public class Label extends LabelFactor {
    String label;

    public Label(String label) {
        this.label = label;
    }

    // TODO: When label is equal to %, all labels are valid
    // At least one label must exist

    @Override
    public String toString() {
        return label;
    }
}
