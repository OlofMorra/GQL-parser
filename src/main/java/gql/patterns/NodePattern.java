package gql.patterns;

import gql.expressions.GqlId;
import gql.expressions.Label;
import gql.expressions.Value;
import gql.graphs.GqlNode;
import gql.graphs.WorkingGraph;
import gql.tables.BindingTable;

import java.util.ArrayList;
import java.util.HashMap;

public class NodePattern extends ElementPattern {
    public NodePattern(GqlId id, ArrayList<ArrayList<Label>> labels, HashMap<GqlId, Value> properties) {
        this.id = id;
        this.labels = labels;
        this.properties = properties;
    }

    @Override
    public BindingTable match(int patternIndex) {
        this.patternIndex = patternIndex;
        BindingTable result = new BindingTable(false, true, new String[]{String.valueOf(this.patternIndex)});
        HashMap<GqlId, GqlNode> possibleMatches = WorkingGraph.getInstance().nodes;

        if (isEmptyNodePattern()) {
            addIdsTo(result, new ArrayList<>(possibleMatches.keySet()));
        } else {
            evaluateMatchAndAddTo(result, possibleMatches);
        }

        return result;
    }

    private boolean isEmptyNodePattern() {
        return !hasLabels() && !hasProperties();
    }

    private void evaluateMatchAndAddTo(BindingTable result, HashMap<GqlId, GqlNode> possibleMatches) {
        for (GqlNode node: possibleMatches.values()) {
            if (isMatch(node)) {
                addIdTo(result, node.getId());
            }
        }
    }

    private boolean isMatch(GqlNode node) {
        boolean labelsMatch = true;
        boolean propertiesMatch = true;

        if (hasLabels()) {
            labelsMatch = matchLabels(node.getLabels());
        }

        if (hasProperties()) {
            propertiesMatch = matchProperties(node.getProperties());
        }

        return labelsMatch && propertiesMatch;
    }

    @Override
    public String toString() {
        String id = getIdString();
        String labels = getLabelString();
        String properties = getPropertyString();

        return "(" + id + ", " + labels + ", " + properties + ")";
    }
}
