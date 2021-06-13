package gql.patterns;

import gql.enums.Direction;
import gql.expressions.GqlId;
import gql.expressions.Label;
import gql.expressions.Value;
import gql.graphs.GqlEdge;
import gql.graphs.WorkingGraph;
import gql.tables.BindingTable;

import java.util.ArrayList;
import java.util.HashMap;

public class EdgePattern extends ElementPattern {
    Direction direction;
    int quantifier;

    public EdgePattern(GqlId id, ArrayList<ArrayList<Label>> labels, HashMap<GqlId, Value> properties, Direction direction, int quantifier) {
        this.id = id;
        this.labels = labels;
        this.properties = properties;
        this.direction = direction;
        this.quantifier = quantifier;
    }

    @Override
    public BindingTable match(int patternIndex) {
        this.patternIndex = patternIndex;
        BindingTable result = new BindingTable(false, true, new String[]{String.valueOf(this.patternIndex)});
        HashMap<GqlId, GqlEdge> possibleMatches = WorkingGraph.getInstance().edges;

        evaluateMatchAndAddTo(result, possibleMatches);

        return result;
    }

    private void evaluateMatchAndAddTo(BindingTable result, HashMap<GqlId, GqlEdge> possibleMatches) {
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
}
