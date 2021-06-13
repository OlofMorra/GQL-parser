package json.workinggraph;

import antlr.JsonGraphParserBaseVisitor;
import antlr.JsonGraphParser;
import antlr.JsonGraphParser.*;
import exceptions.InvalidEdgeFormatException;
import exceptions.InvalidNodeFormatException;
import gql.expressions.*;
import gql.graphs.GqlEdge;
import gql.graphs.GqlNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonGraphVisitor extends JsonGraphParserBaseVisitor {
    public List<String> semanticErrors = new ArrayList<>();
    private HashMap<GqlId, GqlNode> nodes = new HashMap<>();

    public JsonGraphVisitor() {

    }

    public JsonGraphVisitor(HashMap<GqlId, GqlNode> nodes) {
        this.nodes = nodes;
    }

    @Override
    public HashMap<GqlId, GqlNode> visitJsonNodeFile(JsonNodeFileContext ctx) {
        HashMap<GqlId, GqlNode> nodes = new HashMap<>();

        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) instanceof NodeContext) {
                addNodeTo(nodes, ctx.node(nodes.size()));
            }
        }

        return nodes;
    }

    @Override
    public HashMap<GqlId, GqlEdge> visitJsonEdgeFile(JsonEdgeFileContext ctx) {
        HashMap<GqlId, GqlEdge> edges = new HashMap<>();

        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) instanceof EdgeContext) {
                addEdgeTo(edges, ctx.edge(edges.size()));
            }
        }

        return edges;
    }

    public void addNodeTo(HashMap<GqlId, GqlNode> nodes, NodeContext nodeContext) {
        try {
            NodeFillerContext nodeFillerContext = nodeContext.nodeFiller();

            GqlId id = visitIdentity(nodeFillerContext.identity());
            throwExceptionIfNodeIdAlreadyExists(nodes, id);

            ArrayList<Label> labels = getLabels(nodeFillerContext.labels());

            HashMap<GqlId, Value> properties = getProperties(nodeFillerContext.properties());

            GqlNode node = new GqlNode(id, labels, properties);

            nodes.put(id, node);
        } catch (InvalidNodeFormatException exception) {
            semanticErrors.add(exception.getMessage());
        }
    }

    private void throwExceptionIfNodeIdAlreadyExists(HashMap<GqlId, GqlNode> nodes, GqlId id) throws InvalidNodeFormatException {
        if (nodes.containsKey(id)) {
            throw new InvalidNodeFormatException("Id " + id + " is already used for another node.");
        }
    }

    public void addEdgeTo(HashMap<GqlId, GqlEdge> edges, EdgeContext edgeContext) {
        try {
            EdgeFillerContext edgeFillerContext = edgeContext.edgeFiller();

            GqlId id = visitIdentity(edgeFillerContext.identity());
            throwExceptionIfEdgeIdAlreadyExists(edges, id);

            GqlId startNode = visitStartNode(edgeFillerContext.startNode());
            GqlId endNode = visitEndNode(edgeFillerContext.endNode());
            throwExceptionIfIdDoesNotExist(startNode, endNode);

            boolean isDirected = getIsDirected(edgeFillerContext.isDirected());
            ArrayList<Label> labels = getLabels(edgeFillerContext.labels());
            HashMap<GqlId, Value> properties = getProperties(edgeFillerContext.properties());

            GqlEdge edge = new GqlEdge(id, startNode, endNode, isDirected, labels, properties);
            edges.put(id, edge);
        } catch (InvalidEdgeFormatException exception) {
            semanticErrors.add(exception.getMessage());
        }
    }

    private void throwExceptionIfEdgeIdAlreadyExists(HashMap<GqlId, GqlEdge> edges, GqlId id) throws InvalidEdgeFormatException {
        if (nodes.containsKey(id)) {
            throw new InvalidEdgeFormatException("Id " + id + " is already used for a node.");
        } else if (edges.containsKey(id)) {
            throw new InvalidEdgeFormatException("Id " + id + " is already used for another edge.");
        }
    }

    private void throwExceptionIfIdDoesNotExist(GqlId startNode, GqlId endNode) throws InvalidEdgeFormatException {
        if (!nodes.containsKey(startNode)) {
            throw new InvalidEdgeFormatException("Start node with id " + startNode + " does not exist.");
        } else if (!nodes.containsKey(endNode)) {
            throw new InvalidEdgeFormatException("End node with id " + endNode + " does not exist.");
        }
    }

    @Override
    public GqlId visitIdentity(IdentityContext ctx) {
        return visitQuotedId(ctx.quotedId());
    }

    @Override
    public GqlId visitStartNode(StartNodeContext ctx) {
        return visitQuotedId(ctx.quotedId());
    }

    @Override
    public GqlId visitEndNode(EndNodeContext ctx) {
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
        if (Integer.parseInt(ctx.SIGNED_INTEGER().getText()) == 0) {
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
        GqlId labelId = visitQuotedId(ctx.quotedId(labels.size()));

        if (labels.contains(labelId)) {
            semanticErrors.add("Label " + labelId + " exists twice in a node or edge.");
        } else {
            labels.add(new Label(labelId));
        }
    }

    private HashMap<GqlId, Value> getProperties(PropertiesContext ctx) {
        HashMap<GqlId, Value> properties = new HashMap<>();

        if (!(ctx == null)) {
            properties = visitProperties(ctx);
        }

        return properties;
    }

    @Override
    public HashMap<GqlId, Value> visitProperties(PropertiesContext ctx) {
        HashMap<GqlId, Value> properties = new HashMap<>();

        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) instanceof PairContext) {
                addProperty(ctx, properties);
            }
        }

        return properties;
    }

    private void addProperty(PropertiesContext ctx, HashMap<GqlId, Value> properties) {
        GqlId propertyId = visitQuotedId(ctx.pair(properties.size()).quotedId());
        Value value = visitValue(ctx.pair(properties.size()).value());

        if (properties.containsKey(propertyId)) {
            semanticErrors.add("Property id " + propertyId + " exists twice in a node or edge.");
        } else {
            properties.put(propertyId, value);
        }
    }

    @Override
    public GqlId visitQuotedId(QuotedIdContext ctx) {
        String id = ctx.getText().replace("\"", "");

        Pattern pattern = Pattern.compile("[a-z][a-z0-9_]*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(id);
        boolean isValidGqlId = matcher.find();

        if(isValidGqlId) {
            return new GqlId(id);
        } else {
            semanticErrors.add("The identifier \"" + id + "\" is not a valid GQL identifier (node id, label, property key). " +
                    "A GQL identifier should start with a letter and only contain letters and numbers.");
        }

        return new GqlId("Invalid id");
    }

    @Override
    public Value visitValue(ValueContext ctx) {
        switch (ctx.start.getType()) {
            case JsonGraphParser.WORD:
                return new GqlString(ctx.getText().replace("\"", ""));
            case JsonGraphParser.TRUTH_VALUE:
                return getTruthValue(ctx);
            case JsonGraphParser.SIGNED_INTEGER:
            case JsonGraphParser.SIGNED_FIXED_POINT:
                return new FixedPointNumber(ctx.getText().replace("\"", ""));
            default:
                return new FloatingPointNumber(ctx.getText().replace("\"", ""));
        }
    }

    private TruthValue getTruthValue(ValueContext ctx) {
        switch (ctx.TRUTH_VALUE().getText()) {
            case "TRUE":
                return new TruthValue(true);
            case "FALSE":
                return new TruthValue(false);
            default:
                return new TruthValue(null);
        }
    }
}
