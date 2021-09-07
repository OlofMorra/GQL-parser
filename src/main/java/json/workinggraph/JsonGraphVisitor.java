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

package json.workinggraph;

import antlr.JsonGraphParser;
import antlr.JsonGraphParser.*;
import antlr.JsonGraphParserBaseVisitor;
import exceptions.InvalidEdgeFormatException;
import exceptions.InvalidNodeFormatException;
import gql.expressions.values.*;
import gql.graphs.GqlEdge;
import gql.graphs.GqlNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonGraphVisitor extends JsonGraphParserBaseVisitor {
    public List<String> semanticErrors = new ArrayList<>();
    private HashMap<GqlIdentifier, GqlNode> nodes = new HashMap<>();

    public JsonGraphVisitor() {

    }

    public JsonGraphVisitor(HashMap<GqlIdentifier, GqlNode> nodes) {
        this.nodes = nodes;
    }

    @Override
    public HashMap<GqlIdentifier, GqlNode> visitJsonNodeFile(JsonNodeFileContext ctx) {
        HashMap<GqlIdentifier, GqlNode> nodes = new HashMap<>();

        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) instanceof NodeContext) {
                addNodeTo(nodes, ctx.node(nodes.size()));
            }
        }

        return nodes;
    }

    @Override
    public HashMap<GqlIdentifier, GqlEdge> visitJsonEdgeFile(JsonEdgeFileContext ctx) {
        HashMap<GqlIdentifier, GqlEdge> edges = new HashMap<>();

        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) instanceof EdgeContext) {
                addEdgeTo(edges, ctx.edge(edges.size()));
            }
        }

        return edges;
    }

    public void addNodeTo(HashMap<GqlIdentifier, GqlNode> nodes, NodeContext nodeContext) {
        try {
            NodeFillerContext nodeFillerContext = nodeContext.nodeFiller();

            GqlIdentifier id = visitIdentity(nodeFillerContext.identity());
            throwExceptionIfNodeIdAlreadyExists(nodes, id);

            ArrayList<Label> labels = getLabels(nodeFillerContext.labels());

            HashMap<GqlIdentifier, Value> properties = getProperties(nodeFillerContext.properties());

            GqlNode node = new GqlNode(id, labels, properties);

            nodes.put(id, node);
        } catch (InvalidNodeFormatException exception) {
            semanticErrors.add(exception.getMessage());
        }
    }

    private void throwExceptionIfNodeIdAlreadyExists(HashMap<GqlIdentifier, GqlNode> nodes, GqlIdentifier id) throws InvalidNodeFormatException {
        if (nodes.containsKey(id)) {
            throw new InvalidNodeFormatException("Id " + id + " is already used for another node.");
        }
    }

    public void addEdgeTo(HashMap<GqlIdentifier, GqlEdge> edges, EdgeContext edgeContext) {
        try {
            EdgeFillerContext edgeFillerContext = edgeContext.edgeFiller();

            GqlIdentifier id = visitIdentity(edgeFillerContext.identity());
            throwExceptionIfEdgeIdAlreadyExists(edges, id);

            GqlIdentifier startNode = visitStartNode(edgeFillerContext.startNode());
            GqlIdentifier endNode = visitEndNode(edgeFillerContext.endNode());
            throwExceptionIfIdDoesNotExist(startNode, endNode);

            boolean isDirected = getIsDirected(edgeFillerContext.isDirected());
            ArrayList<Label> labels = getLabels(edgeFillerContext.labels());
            HashMap<GqlIdentifier, Value> properties = getProperties(edgeFillerContext.properties());

            GqlEdge edge = new GqlEdge(id, startNode, endNode, isDirected, labels, properties);
            edges.put(id, edge);
        } catch (InvalidEdgeFormatException exception) {
            semanticErrors.add(exception.getMessage());
        }
    }

    private void throwExceptionIfEdgeIdAlreadyExists(HashMap<GqlIdentifier, GqlEdge> edges, GqlIdentifier id) throws InvalidEdgeFormatException {
        if (nodes.containsKey(id)) {
            throw new InvalidEdgeFormatException("Id " + id + " is already used for a node.");
        } else if (edges.containsKey(id)) {
            throw new InvalidEdgeFormatException("Id " + id + " is already used for another edge.");
        }
    }

    private void throwExceptionIfIdDoesNotExist(GqlIdentifier startNode, GqlIdentifier endNode) throws InvalidEdgeFormatException {
        if (!nodes.containsKey(startNode)) {
            throw new InvalidEdgeFormatException("Start node with id " + startNode + " does not exist.");
        } else if (!nodes.containsKey(endNode)) {
            throw new InvalidEdgeFormatException("End node with id " + endNode + " does not exist.");
        }
    }

    @Override
    public GqlIdentifier visitIdentity(IdentityContext ctx) {
        return visitQuotedId(ctx.quotedId());
    }

    @Override
    public GqlIdentifier visitStartNode(StartNodeContext ctx) {
        return visitQuotedId(ctx.quotedId());
    }

    @Override
    public GqlIdentifier visitEndNode(EndNodeContext ctx) {
        return visitQuotedId(ctx.quotedId());
    }

    private boolean getIsDirected(IsDirectedContext ctx) {
        boolean isDirected = true;

        if (!(ctx == null)) {
            isDirected = visitIsDirected(ctx);
        }

        return isDirected;
    }

    @Override
    public Boolean visitIsDirected(IsDirectedContext ctx) {
        if (Integer.parseInt(ctx.UNSIGNED_INTEGER().getText()) == 0) {
            return false;
        }

        return true;
    }

    private ArrayList<Label> getLabels (LabelsContext ctx) {
        ArrayList<Label> labels = new ArrayList<>();

        if (!(ctx == null)) {
            labels = visitLabels(ctx);
        }

        return labels;
    }

    @Override
    public ArrayList<Label> visitLabels(LabelsContext ctx) {
        ArrayList<Label> labels = new ArrayList<>();

        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) instanceof QuotedIdContext) {
                addLabel(ctx, labels);
            }
        }

        return labels;
    }

    private void addLabel(LabelsContext ctx, ArrayList<Label> labels) {
        GqlIdentifier labelId = visitQuotedId(ctx.quotedId(labels.size()));

        if (labels.contains(labelId)) {
            semanticErrors.add("Label " + labelId + " exists twice in a node or edge.");
        } else {
            labels.add(new Label(labelId.getId()));
        }
    }

    private HashMap<GqlIdentifier, Value> getProperties(PropertiesContext ctx) {
        HashMap<GqlIdentifier, Value> properties = new HashMap<>();

        if (!(ctx == null)) {
            properties = visitProperties(ctx);
        }

        return properties;
    }

    @Override
    public HashMap<GqlIdentifier, Value> visitProperties(PropertiesContext ctx) {
        HashMap<GqlIdentifier, Value> properties = new HashMap<>();

        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) instanceof PairContext) {
                addProperty(ctx, properties);
            }
        }

        return properties;
    }

    private void addProperty(PropertiesContext ctx, HashMap<GqlIdentifier, Value> properties) {
        GqlIdentifier propertyId = visitQuotedId(ctx.pair(properties.size()).quotedId());
        Value value = visitValue(ctx.pair(properties.size()).value());

        if (properties.containsKey(propertyId)) {
            semanticErrors.add("Property id " + propertyId + " exists twice in a node or edge.");
        } else {
            properties.put(propertyId, value);
        }
    }

    @Override
    public GqlIdentifier visitQuotedId(QuotedIdContext ctx) {
        String id = ctx.getText().replace("\"", "");

        Pattern pattern = Pattern.compile("[a-z][a-z0-9_]*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(id);
        boolean isValidGqlId = matcher.find();

        if(isValidGqlId) {
            return new GqlIdentifier(id);
        } else {
            semanticErrors.add("The identifier \"" + id + "\" is not a valid GQL identifier (node id, label, property key). " +
                    "A GQL identifier should start with a letter and only contain letters and numbers.");
        }

        return new GqlIdentifier("Invalid id");
    }

    @Override
    public Value visitValue(ValueContext ctx) {
        switch (ctx.getStart().getType()) {
            case JsonGraphParser.WORD:
                String word = ctx.getText().replace("\"", "");
                if (word.matches("[Tt][Rr][Uu][Ee]")) return new TruthValue(true);
                if (word.matches("[Ff][Aa][Ll][Ss][Ee]")) return new TruthValue(false);
                if (word.matches("[Uu][Nn][Kk][Nn][Oo][Ww][Nn]") ||
                        word.matches("[Nn][Uu][Ll][Ll]")) return new TruthValue(null);

                return new GqlString(word);
            case JsonGraphParser.TRUTH_VALUE:
                return getTruthValue(ctx.TRUTH_VALUE());
            case JsonGraphParser.UNSIGNED_INTEGER:
            case JsonGraphParser.SIGNED_INTEGER:
            case JsonGraphParser.SIGNED_FIXED_POINT:
                return new FixedPointNumber(ctx.getText().replace("\"", ""));
            default:
                return new FloatingPointNumber(ctx.getText().replace("\"", ""));
        }
    }

    private TruthValue getTruthValue(TerminalNode truthValue) {
        switch (truthValue.getText()) {
            case "TRUE":
                return new TruthValue(true);
            case "FALSE":
                return new TruthValue(false);
            default:
                return new TruthValue(null);
        }
    }
}
