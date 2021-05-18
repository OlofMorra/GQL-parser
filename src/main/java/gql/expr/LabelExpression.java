package gql.expr;

import java.util.List;

// Extend with LabelFactor to allow the parenthesizedLabelExpression
// in the grammar.
public class LabelExpression extends LabelFactor {
    List<LabelTerm> labelTerms;

    public LabelExpression(List<LabelTerm> labelTerms) {
        this.labelTerms = labelTerms;
    }

    @Override
    public String toString() {
        return labelTerms.toString();
    }
}
