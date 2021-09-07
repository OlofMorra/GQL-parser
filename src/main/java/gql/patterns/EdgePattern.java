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

import gql.enums.Direction;
import gql.expressions.values.GqlIdentifier;
import gql.expressions.values.Label;
import gql.expressions.values.Value;
import gql.graphs.GqlEdge;
import gql.graphs.WorkingGraph;
import gql.tables.BindingTable;

import java.util.ArrayList;
import java.util.HashMap;

public class EdgePattern extends ElementPattern {
    Direction direction;
    int quantifier;

    public EdgePattern(VariableName id, ArrayList<ArrayList<Label>> labels, HashMap<GqlIdentifier, Value> properties, Direction direction, int quantifier) {
        this.variableName = id;
        this.labels = labels;
        this.properties = properties;
        this.direction = direction;
        this.quantifier = quantifier;
        this.patternIndex = 1;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setQuantifier(int quantifier) {
        this.quantifier = quantifier;
    }

    @Override
    public BindingTable match() {
        BindingTable result = new BindingTable(true, new String[]{String.valueOf(this.patternIndex)});
        HashMap<GqlIdentifier, GqlEdge> possibleMatches = WorkingGraph.getInstance().edges;

        evaluateMatchAndAddTo(result, possibleMatches);

        return result;
    }

    private void evaluateMatchAndAddTo(BindingTable result, HashMap<GqlIdentifier, GqlEdge> possibleMatches) {
        for (GqlEdge edge: possibleMatches.values()) {
            if (isMatch(edge)) {
                addIdTo(result, edge.getId());
            }
        }
    }

    private boolean isMatch(GqlEdge edge) {
        boolean labelsMatch = true;
        boolean propertiesMatch = true;

        if (this.isDirected() != edge.isDirected()) return false;
        if (hasLabels()) labelsMatch = matchLabels(edge.getLabels());
        if (hasProperties()) propertiesMatch = matchProperties(edge.getProperties());

        return labelsMatch && propertiesMatch;
    }

    private boolean isDirected() {
        return this.direction != Direction.UNDIRECTED;
    }

    @Override
    public String toString() {
        String direction = this.direction.toString();
        String id = getIdString();
        String labels = getLabelString();
        String properties = getPropertyString();
        String quantifier = getQuantifierString();

        return "(" + direction + ", " + id + ", " + labels + ", " + properties + ", " + quantifier + ")";
    }

    @Override
    public String toLatex() {
        String direction = this.direction.toLatex();
        String id = getIdLatex();
        String labels = getLabelLatex();
        String properties = getPropertyLatex();
        String quantifier = getQuantifierString();

        if (labels.equals("\\{\\}")) labels = "\\emptyset";
        if (properties.equals("\\{\\}")) properties = "\\emptyset";

        return "(" + direction + ", " + id + ", " + labels + ", " + properties + ", " + quantifier + ")";
    }

    private String getQuantifierString() {
        return "(" + this.quantifier + ", " + this.quantifier + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof EdgePattern)) return false;
        EdgePattern edgePatternToCompareTo = (EdgePattern) obj;
        if (this.variableName != edgePatternToCompareTo.variableName) return false;
        if (this.direction != edgePatternToCompareTo.direction) return false;

        if (this.hasLabels() != edgePatternToCompareTo.hasLabels()) return false;
        if (this.hasProperties() != edgePatternToCompareTo.hasProperties()) return false;

        if (this.hasLabels()) {
            if (!this.labels.equals(edgePatternToCompareTo.labels)) return false;
        }

        if (this.hasProperties()) {
            if (!this.properties.equals(edgePatternToCompareTo.properties)) return false;
        }

        // Quantifier does not have to be equal, that information should be kept in an edge
        // and does not influence equality in this project.

        return true;
    }
}
