package gql.patterns;

import gql.expressions.GqlIdentifier;
import gql.expressions.Label;
import gql.expressions.Value;
import gql.graphs.GqlNode;
import gql.graphs.WorkingGraph;
import gql.tables.BindingTable;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.HashMap;

public class NodePattern extends ElementPattern {
    public NodePattern(VariableName variableName, ArrayList<ArrayList<Label>> labels, HashMap<GqlIdentifier, Value> properties) {
        this.variableName = variableName;
        this.labels = labels;
        this.properties = properties;
        this.patternIndex = 0;
    }

    @Override
    public BindingTable match() {
        BindingTable result = new BindingTable(false, true, new String[]{String.valueOf(this.patternIndex)});
        HashMap<GqlIdentifier, GqlNode> possibleMatches = WorkingGraph.getInstance().nodes;

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

    private void evaluateMatchAndAddTo(BindingTable result, HashMap<GqlIdentifier, GqlNode> possibleMatches) {
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof NodePattern)) return false;
        NodePattern nodePatternToCompareTo = (NodePattern) obj;
        if (this.variableName != nodePatternToCompareTo.variableName) return false;

        if (this.hasLabels() != nodePatternToCompareTo.hasLabels()) return false;
        if (this.hasProperties() != nodePatternToCompareTo.hasProperties()) return false;

        if (this.hasLabels()) {
            if (!this.labels.equals(nodePatternToCompareTo.labels)) return false;
        }

        if (this.hasProperties()) {
            if (!this.properties.equals(nodePatternToCompareTo.properties)) return false;
        }

        return true;
    }
}
