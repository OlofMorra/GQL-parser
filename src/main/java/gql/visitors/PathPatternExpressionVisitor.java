package gql.visitors;

import antlr.GqlParser;
import antlr.GqlParser.PathPatternExpressionContext;
import antlr.GqlParser.PathTermContext;
import antlr.GqlParser.PathContext;
import antlr.GqlParser.NodePatternContext;
import antlr.GqlParser.EdgePatternContext;
import antlr.GqlParser.ElementPatternFillerContext;
import antlr.GqlParserBaseVisitor;

public class PathPatternExpressionVisitor extends GqlParserBaseVisitor {
    @Override
    public Object visitPathPatternExpression(PathPatternExpressionContext ctx) {
        visitPathTerm(ctx.pathTerm(0));

        return null;
    }

    @Override
    public Object visitPathTerm(PathTermContext ctx) {
        visitPath(ctx.path());

        return null;
    }

    @Override
    public Object visitPath(PathContext ctx) {
        visitNodePattern(ctx.nodePattern(0));

        return null;
    }

    @Override
    public Object visitNodePattern(NodePatternContext ctx) {
        visitElementPatternFiller(ctx.elementPatternFiller());

        return null;
    }

    @Override
    public Object visitElementPatternFiller(ElementPatternFillerContext ctx) {
        String variableName = ctx.elementVariable().ID().getText();
        String labels = "";
        String properties = "";

        if (ctx.isLabelExpr() == null) {
            System.out.println("There are no labels");
        } else {
            labels = ctx.isLabelExpr().labelExpression().getText();
            System.out.println("There are labels");
        }

        if (ctx.propertyList() == null) {
            System.out.println("There are no properties");
        } else {
            properties = ctx.propertyList().getText();
            System.out.println("There are properties");
        }

        System.out.println("Node pattern: (" + variableName + ", {" + labels + "}, {" + properties + "})");

        return null;
    }
}
