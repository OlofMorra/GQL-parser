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

package gql.graphs;

import gql.expressions.values.GqlIdentifier;
import gql.expressions.values.Label;
import gql.expressions.values.Value;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class GqlGraphElement extends Value {
    protected GqlIdentifier id;
    protected ArrayList<Label> labels;
    protected HashMap<GqlIdentifier, Value> properties;

    public void setProperties(HashMap<GqlIdentifier, Value> properties) {
        this.properties = properties;
    }

    public GqlIdentifier getId() {
        return id;
    }

    public ArrayList<Label> getLabels() {
        return labels;
    }

    public HashMap<GqlIdentifier, Value> getProperties() {
        return properties;
    }

    protected String getLabelString() {
        if (this.labels == null || this.labels.isEmpty()) return "";

        String labelString = ", \"labels\": [";

        for (Label label: this.labels) {
            labelString = labelString.concat("\"" + label.toString() + "\", ");
        }

        labelString = labelString.substring(0, labelString.length()-2);

        return labelString.concat("]");
    }

    protected String getPropertiesString() {
        if (this.properties == null || this.properties.isEmpty()) return "";

        String propertyString = ", \"properties\": {";

        for (GqlIdentifier id: properties.keySet()) {
            propertyString = propertyString.concat("\"" + id.toString() + "\": " + properties.get(id).toString() + ", ");
        }

        propertyString = propertyString.substring(0, propertyString.length()-2);

        return propertyString.concat("}");
    }
}
