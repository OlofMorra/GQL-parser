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

    @Override
    public BindingTable match() {
        BindingTable result = new BindingTable(false, true, new String[]{String.valueOf(this.patternIndex)});
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

        if (this.isDirected() != edge.isDirected()) {
            return false;
        }

        if (hasLabels()) {
            labelsMatch = matchLabels(edge.getLabels());
        }

        if (hasProperties()) {
            propertiesMatch = matchProperties(edge.getProperties());
        }

        return labelsMatch && propertiesMatch;
    }

    private boolean isDirected() {
        return this.direction != Direction.UNDIRECTED;
    }

    @Override
    public String toString() {
        String direction = getDirectionString();
        String id = getIdString();
        String labels = getLabelString();
        String properties = getPropertyString();
        String quantifier = getQuantifierString();

        return "(" + direction + ", " + id + ", " + labels + ", " + properties + ", " + quantifier + ")";
    }

    private String getDirectionString() {
        switch (this.direction) {
            case UNDIRECTED:
                return "-";
            case LEFT_TO_RIGHT:
                return "->";
            case RIGHT_TO_LEFT:
                return "<-";
            default:
                return "";
        }
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
