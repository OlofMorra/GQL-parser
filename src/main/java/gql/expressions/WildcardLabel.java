package gql.expressions;

import gql.expressions.unnecessary.LabelFactor;

public class WildcardLabel extends Label {
    public WildcardLabel(GqlId label) {
        super(label);
    }

    @Override
    public String toString() {
        return "%";
    }
}
