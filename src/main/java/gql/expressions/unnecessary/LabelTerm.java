package gql.expressions.unnecessary;

import java.util.List;

public class LabelTerm {
    List<LabelFactor> labelFactors;

    public LabelTerm(List<LabelFactor> labelFactors) {
        this.labelFactors = labelFactors;
    }

    @Override
    public String toString() {
        return labelFactors.toString();
    }
}
