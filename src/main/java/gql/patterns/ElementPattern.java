/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package gql.patterns;

import gql.expressions.values.GqlIdentifier;
import gql.expressions.values.Label;
import gql.expressions.values.Value;
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
    public abstract String toLatex();

    public void setVariableName(VariableName variableName) {
        this.variableName = variableName;
    }

    public void setLabels(ArrayList<ArrayList<Label>> labels) {
        this.labels = labels;
    }

    public void setProperties(HashMap<GqlIdentifier, Value> properties) {
        this.properties = properties;
    }

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

    protected String getIdLatex() {
        return getIdString();
    }

    protected String getLabelString() {
        if (this.labels == null || this.labels.isEmpty()) return "{}";

        String labelString = "{";

        for (ArrayList<Label> labelSet: this.labels) {
            labelString = labelString.concat(getLabelSetString(labelSet) + ", ");
        }

        return labelString.substring(0, labelString.length() - 2).concat("}");
    }

    protected String getLabelLatex() {
        if (this.labels == null || this.labels.isEmpty()) return "\\{\\}";

        String labelString = "\\{";

        for (ArrayList<Label> labelSet: this.labels) {
            labelString = labelString.concat(getLabelSetLatex(labelSet) + ", ");
        }

        return labelString.substring(0, labelString.length() - 2).concat("\\}");
    }

    protected String getLabelSetString(ArrayList<Label> labelSet) {
        if (labelSet == null || labelSet.isEmpty()) return "{}";

        String labelSetString = "{";

        for (Label label: labelSet) {
            labelSetString = labelSetString.concat(label + ", ");
        }

        return labelSetString.substring(0, labelSetString.length() - 2).concat("}");
    }

    protected String getLabelSetLatex(ArrayList<Label> labelSet) {
        if (labelSet == null || labelSet.isEmpty()) return "\\{\\}";

        String labelSetString = "\\{";

        for (Label label: labelSet) {
            labelSetString = labelSetString.concat(label.toLatex() + ", ");
        }

        return labelSetString.substring(0, labelSetString.length() - 2).concat("\\}");
    }

    protected String getPropertyString() {
        if (this.properties == null || this.properties.isEmpty()) return "{}";

        String propertyString = "{";

        for (GqlIdentifier key: this.properties.keySet()) {
            propertyString = propertyString.concat("(" + key + ": " + this.properties.get(key).toString() + "), ");
        }

        return propertyString.substring(0, propertyString.length() - 2).concat("}");
    }

    protected String getPropertyLatex() {
        if (this.properties == null || this.properties.isEmpty()) return "\\{\\}";

        String propertyString = "\\{";

        for (GqlIdentifier key: this.properties.keySet()) {
            propertyString = propertyString.concat("(" + key.toLatex() + ": " + this.properties.get(key).toLatex() + "), ");
        }

        return propertyString.substring(0, propertyString.length() - 2).concat("\\}");
    }

    public void setPatternIndex(int newPatternIndex) {
        this.patternIndex = newPatternIndex;
    }
}
