package gql.patterns;

import gql.expr.LabelExpression;
import gql.expr.Value;

import java.util.Map;

public class ElementPatternFiller {
    String elementVariableName;
    LabelExpression labelExpression;
    Map<String, Value> propertyList;

    public ElementPatternFiller(String elementVariableName,
                                LabelExpression labelExpression,
                                Map<String, Value> propertyList) {
        this.elementVariableName = elementVariableName;
        this.labelExpression = labelExpression;
        this.propertyList = propertyList;
    }

    @Override
    public String toString() {
        return elementVariableName + labelExpression.toString() + propertyList.toString();
    }
}
