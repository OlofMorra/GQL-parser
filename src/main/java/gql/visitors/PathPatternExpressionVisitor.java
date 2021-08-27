package gql.visitors;

import antlr.GqlParser;
import antlr.GqlParser.*;
import antlr.GqlParserBaseVisitor;
import exceptions.SemanticErrorException;
import gql.enums.Direction;
import gql.expressions.values.GqlIdentifier;
import gql.expressions.values.Label;
import gql.expressions.values.Value;
import gql.expressions.values.WildcardLabel;
import gql.patterns.*;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang.NotImplementedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PathPatternExpressionVisitor extends GqlParserBaseVisitor {
    ExpressionVisitor expressionVisitor = new ExpressionVisitor();

    @Override
    public PathPattern visitPathPatternExpression(PathPatternExpressionContext ctx) {
        return visitPathTerm(ctx.pathTerm());
    }

    @Override
    public PathPattern visitPathTerm(PathTermContext ctx) {
        if (ctx.path() == null) throw new NotImplementedException("A parenthesized path pattern expression should be rewritten.");

        return visitPath(ctx.path());
    }

    @Override
    public PathPattern visitPath(PathContext ctx) {
        ArrayList<ElementPattern> pathSequence = new ArrayList<>();

        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) instanceof NodePatternContext) {
                pathSequence.add(visitNodePattern((NodePatternContext) ctx.getChild(i)));
            } else if (ctx.getChild(i) instanceof EdgePatternContext) {
                pathSequence.add(visitEdgePattern((EdgePatternContext) ctx.getChild(i)));
            }
        }

        // TODO: implement path variable name correctly
        return new PathPattern(null, new PathSequence(pathSequence));
    }

    @Override
    public NodePattern visitNodePattern(NodePatternContext ctx) {
        VariableName variableName = visitElementVariable(ctx.elementPatternFiller().elementVariable());
        ArrayList<ArrayList<Label>> labels = visitIsLabelExpr(ctx.elementPatternFiller().isLabelExpr());
        HashMap<GqlIdentifier, Value> properties = visitPropertyList(ctx.elementPatternFiller().propertyList());

        return new NodePattern(variableName, labels, properties);
    }

    @Override
    public EdgePattern visitEdgePattern(EdgePatternContext ctx) {
        EdgePattern edge = new EdgePattern(null, null, null, Direction.LEFT_TO_RIGHT, 1);

        if (ctx.getChild(0) instanceof FullEdgeUndirectedContext) {
            edge = visitFullEdgeUndirected((FullEdgeUndirectedContext) ctx.getChild(0));
        } else if (ctx.getChild(0) instanceof FullEdgePointingLeftContext) {
            edge = visitFullEdgePointingLeft((FullEdgePointingLeftContext) ctx.getChild(0));
        } else if (ctx.getChild(0) instanceof FullEdgePointingRightContext) {
            edge = visitFullEdgePointingRight((FullEdgePointingRightContext) ctx.getChild(0));
        }

        if (ctx.len() != null) edge.setQuantifier(visitQuantifier(ctx.len().quantifier()));

        return edge;
    }

    @Override
    public EdgePattern visitFullEdgePointingLeft(FullEdgePointingLeftContext ctx) {
        return getEdgePattern(ctx.elementPatternFiller(), Direction.RIGHT_TO_LEFT);
    }

    @Override
    public EdgePattern visitFullEdgePointingRight(FullEdgePointingRightContext ctx) {
        return getEdgePattern(ctx.elementPatternFiller(), Direction.LEFT_TO_RIGHT);
    }

    @Override
    public EdgePattern visitFullEdgeUndirected(FullEdgeUndirectedContext ctx) {
        return getEdgePattern(ctx.elementPatternFiller(), Direction.UNDIRECTED);
    }

    private EdgePattern getEdgePattern(ElementPatternFillerContext ctx, Direction direction) {
        VariableName variableName = visitElementVariable(ctx.elementVariable());
        ArrayList<ArrayList<Label>> labels = visitIsLabelExpr(ctx.isLabelExpr());
        HashMap<GqlIdentifier, Value> properties = visitPropertyList(ctx.propertyList());

        return new EdgePattern(variableName, labels, properties, direction, 1);
    }

    @Override
    public Integer visitQuantifier(QuantifierContext ctx) {
         List<TerminalNode> quantifier = ctx.UNSIGNED_INTEGER();
         if (quantifier.size() == 1)  return Integer.parseInt(quantifier.get(0).getText());
         if (quantifier.get(0).getText().equals(quantifier.get(1).getText())) return Integer.parseInt(quantifier.get(0).getText());

         throw new SemanticErrorException("A quantifier for an edge must be a single number or two numbers that are equal to each other.");
    }

    @Override
    public VariableName visitElementVariable(ElementVariableContext ctx) {
        if (ctx == null) return null;
        return new VariableName(ctx.ID().getText());
    }

    @Override
    public ArrayList<ArrayList<Label>> visitIsLabelExpr(GqlParser.IsLabelExprContext ctx) {
        if (ctx == null) return new ArrayList<>();

        return visitLabelExpression(ctx.labelExpression());
    }

    @Override
    public ArrayList<ArrayList<Label>> visitLabelExpression(LabelExpressionContext ctx) {
        ArrayList<ArrayList<Label>> labels = new ArrayList<>();
        if (ctx == null) return labels;

        for (LabelTermContext labelTermContext: ctx.labelTerm()) {
            labels.add(visitLabelTerm(labelTermContext));
        }

        return labels;
    }

    @Override
    public ArrayList<Label> visitLabelTerm(LabelTermContext ctx) {
        ArrayList<Label> labelTerm = new ArrayList<>();
        if (ctx == null) return labelTerm;

        for (LabelFactorContext labelFactorContext: ctx.labelFactor()) {
            labelTerm.add(visitLabelFactor(labelFactorContext));
        }

        return labelTerm;
    }

    @Override
    public Label visitLabelFactor(LabelFactorContext ctx) {
        if (ctx.labelPrimary() != null) return visitLabelPrimary(ctx.labelPrimary());

        throw new SemanticErrorException("Label negations are not implemented, hence, rewrite the query.");
    }

    @Override
    public Label visitLabelPrimary(LabelPrimaryContext ctx) {
        if (ctx.label() != null) return new Label(ctx.label().ID().getText());
        if (ctx.labelWildcard() != null) return new WildcardLabel();

        throw new SemanticErrorException("Parenthesized label expressions are not yet implemented, hence, rewrite the query.");
    }

    @Override
    public HashMap<GqlIdentifier, Value> visitPropertyList(PropertyListContext ctx) {
        HashMap<GqlIdentifier, Value> properties = new HashMap<>();
        if (ctx == null) return properties;

        List<KeyContext> keyContexts = ctx.key();
        List<ExprContext> exprContexts = ctx.expr();

        for (int i = 0; i < keyContexts.size(); i++) {
            GqlIdentifier key = new GqlIdentifier(keyContexts.get(i).ID().getText());
            Value value = expressionVisitor.visitPropertyExpr(exprContexts.get(i));
            properties.put(key, value);
        }

        return properties;
    }
}
