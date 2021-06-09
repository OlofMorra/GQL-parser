package gql.patterns;

import gql.expressions.unnecessary.LabelExpression;
import gql.expressions.Value;

import java.util.Map;

public class ElementPatternFiller {
    String elementVariableName;
    LabelExpression labelExpression;
    Map<String, Value> properties;

    public ElementPatternFiller(String elementVariableName,
                                LabelExpression labelExpression,
                                Map<String, Value> propertyList) {
        this.elementVariableName = elementVariableName;
        this.labelExpression = labelExpression;
        this.properties = propertyList;
    }

    @Override
    public String toString() {
        return elementVariableName + labelExpression.toString() + properties.toString();
    }
}
