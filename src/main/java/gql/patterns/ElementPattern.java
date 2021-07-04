package gql.patterns;

import gql.expressions.GqlIdentifier;
import gql.expressions.Label;
import gql.expressions.Value;
import gql.tables.BindingTable;
import gql.tables.Record;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class ElementPattern {
    VariableName variableName;
    ArrayList<ArrayList<Label>> labels;
    HashMap<GqlIdentifier, Value> properties;
    int patternIndex = 0;

    public abstract BindingTable match();

    protected void addIdsTo(BindingTable result, ArrayList<GqlIdentifier> ids) {
        for (GqlIdentifier id: ids) {
            addIdTo(result, id);
        }
    }

    protected void addIdTo(BindingTable result, GqlIdentifier id) {
        Record record = new Record(new String[]{String.valueOf(this.patternIndex)}, new Value[]{id});
        result.addRecord(record);
    }

    protected boolean hasLabels() {
        return !(this.labels == null || this.labels.isEmpty());
    }

    protected boolean hasProperties() {
        return !(this.properties == null || this.properties.isEmpty());
    }

    protected boolean matchLabels(ArrayList<Label> labels) {
        for (ArrayList<Label> labelSet: this.labels) {
            if (labels.containsAll(labelSet)) {
                return true;
            }
        }

        return false;
    }

    protected boolean matchProperties(HashMap<GqlIdentifier, Value> properties) {
        for (GqlIdentifier propertyIdToMatch: this.properties.keySet()) {
            if (!containsKey(properties, propertyIdToMatch) || !hasEqualValues(properties, propertyIdToMatch)) {
                return false;
            }
        }

        return true;
    }

    protected boolean hasEqualValues(HashMap<GqlIdentifier, Value> properties, GqlIdentifier propertyIdToMatch) {
        return properties.get(propertyIdToMatch).equals(this.properties.get(propertyIdToMatch));
    }

    protected boolean containsKey(HashMap<GqlIdentifier, Value> properties, GqlIdentifier propertyIdToMatch) {
        return properties.containsKey(propertyIdToMatch);
    }

    protected String getIdString() {
        if (this.variableName == null) {
            return "nil";
        }

        return this.variableName.toString();
    }

    protected String getLabelString() {
        String labelString = "{}";

        if (this.labels == null || this.labels.isEmpty()) {
            return labelString;
        }

        labelString = "{";
        for (ArrayList<Label> labelSet: this.labels) {
            labelString = labelString.concat(getLabelSetString(labelSet) + ", ");
        }
        labelString = labelString.substring(0, labelString.length() - 2).concat("}");

        return labelString;
    }

    protected String getLabelSetString(ArrayList<Label> labelSet) {
        String labelSetString = "{}";

        if (labelSet == null || labelSet.isEmpty()) {
            return labelSetString;
        }

        labelSetString = "{";
        for (Label label: labelSet) {
            labelSetString = labelSetString.concat(label + ", ");
        }
        labelSetString = labelSetString.substring(0, labelSetString.length() - 2).concat("}");

        return labelSetString;
    }

    protected String getPropertyString() {
        String propertyString = "{}";

        if (this.properties == null || this.properties.isEmpty()) {
            return propertyString;
        }

        propertyString = "{";
        for (GqlIdentifier key: this.properties.keySet()) {
            propertyString = propertyString.concat("(" + key + ": " + this.properties.get(key).toString() + "), ");
        }
        propertyString = propertyString.substring(0, propertyString.length() - 2).concat("}");

        return propertyString;
    }

    public void setPatternIndex(int newPatternIndex) {
        this.patternIndex = newPatternIndex;
    }
}
