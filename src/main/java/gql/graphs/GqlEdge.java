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

public class GqlEdge extends GqlGraphElement {
    private final GqlIdentifier startNodeId;
    private final GqlIdentifier endNodeId;
    private boolean isDirected = true;

    public GqlEdge(GqlIdentifier id, GqlIdentifier startNodeId, GqlIdentifier endNodeId, boolean isDirected, ArrayList<Label> labels,
                   HashMap<GqlIdentifier, Value> properties) {
        if (id == null) throw new NullPointerException("Argument id cannot be null");
        if (labels == null) throw new NullPointerException("Argument labels cannot be null");
        if (properties == null) throw new NullPointerException("Argument properties cannot be null");
        if (startNodeId == null) throw new NullPointerException("Argument startNodeId cannot be null");
        if (endNodeId == null) throw new NullPointerException("Argument endNodeId cannot be null");

        this.id = id;
        this.labels = labels;
        this.properties = properties;
        this.startNodeId = startNodeId;
        this.endNodeId = endNodeId;
        this.isDirected = isDirected;
    }

    @Override
    public TruthValue isEqualTo(Value valueToCompareTo) {
        return new TruthValue(this.equals(valueToCompareTo));
    }

    @Override
    public TruthValue isSmallerThan(Value valueToCompareTo) {
        throw new SemanticErrorException("Invalid comparison: nodes cannot be used in an inequality.");
    }

    public GqlIdentifier getStartNodeId() {
        return startNodeId;
    }

    public GqlIdentifier getEndNodeId() {
        return endNodeId;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public boolean hasStartAndEndNode(GqlIdentifier startNodeId, GqlIdentifier endNodeId) {
        return this.startNodeId.equals(startNodeId) && this.endNodeId.equals(endNodeId);
    }

    public boolean hasEndpoints(GqlIdentifier startNodeId, GqlIdentifier endNodeId) {
        return this.hasStartAndEndNode(startNodeId, endNodeId) || this.hasStartAndEndNode(endNodeId, startNodeId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GqlEdge gqlEdge = (GqlEdge) o;
        if (isDirected) return equalsDirectedEdge(gqlEdge);
        return equalsUndirectedEdge(gqlEdge);
    }

    private boolean equalsDirectedEdge(GqlEdge gqlEdge) {
        return isDirected == gqlEdge.isDirected && id.equals(gqlEdge.id)
                && this.hasStartAndEndNode(gqlEdge.getStartNodeId(), gqlEdge.getEndNodeId())
                && Objects.equals(labels, gqlEdge.labels)
                && Objects.equals(properties, gqlEdge.properties);
    }

    private boolean equalsUndirectedEdge(GqlEdge gqlEdge) {
        return isDirected == gqlEdge.isDirected && id.equals(gqlEdge.id)
                && this.hasEndpoints(gqlEdge.getStartNodeId(), gqlEdge.getEndNodeId())
                && Objects.equals(labels, gqlEdge.labels)
                && Objects.equals(properties, gqlEdge.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startNodeId, endNodeId, isDirected, labels, properties);
    }

    @Override
    public String toString() {
        return "{\"identity\": \"" + this.id + "\", \"start\": \"" + this.startNodeId.toString() + "\", \"end\": \"" +
                this.endNodeId.toString() + "\"" + getLabelString() + getPropertiesString() + ", \"isDirected\": " +
                ((this.isDirected) ? 1 : 0) + "}";
    }

    private String getEndpointsString() {
        if (isDirected) return getDirectedEndpointsString();
        return getUndirectedEndpointsString();
    }

    private String getDirectedEndpointsString() {
        return "From[" + this.startNodeId.toString() + "] To[" + this.endNodeId.toString() + "]";
    }

    private String getUndirectedEndpointsString() {
        return "Endpoints{" + this.startNodeId.toString() + ", " + this.endNodeId.toString() + "}";
    }
}
