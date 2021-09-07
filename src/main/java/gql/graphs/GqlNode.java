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

import exceptions.SemanticErrorException;
import gql.expressions.values.GqlIdentifier;
import gql.expressions.values.Label;
import gql.expressions.values.TruthValue;
import gql.expressions.values.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class GqlNode extends GqlGraphElement {
    public GqlNode(GqlIdentifier id, ArrayList<Label> labels, HashMap<GqlIdentifier, Value> properties) {
        if (id == null) throw new NullPointerException("Argument id cannot be null");
        if (labels == null) throw new NullPointerException("Argument labels cannot be null");
        if (properties == null) throw new NullPointerException("Argument properties cannot be null");

        this.id = id;
        this.labels = labels;
        this.properties = properties;
    }

    @Override
    public TruthValue isEqualTo(Value valueToCompareTo) {
        return new TruthValue(this.equals(valueToCompareTo));
    }

    @Override
    public TruthValue isSmallerThan(Value valueToCompareTo) {
        throw new SemanticErrorException("Invalid comparison: nodes cannot be used in an inequality.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GqlNode gqlNode = (GqlNode) o;
        return id.isEqualTo(gqlNode.getId()).equals(new TruthValue(true)) && labels.equals(gqlNode.getLabels()) && properties.equals(gqlNode.getProperties());
    }

    @Override
    public int hashCode() {
        return Objects.hash(labels, properties);
    }

    @Override
    public String toString() {
        return "{\"identity\": \"" + this.id + "\"" + getLabelString() + getPropertiesString() + "}";
    }
}
