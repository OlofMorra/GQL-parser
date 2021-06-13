package gql.visitors;

import antlr.GqlParser.QueryExpressionContext;
import antlr.GqlParser.FocusedQueryExpressionContext;
import antlr.GqlParser.AmbientQueryExpressionContext;
import antlr.GqlParserBaseVisitor;
import exceptions.InvalidEdgeFormatException;
import exceptions.InvalidNodeFormatException;
import gql.graphs.GremlinGraph;
import gql.graphs.WorkingGraph;
import gql.tables.BindingTable;

import java.io.FileNotFoundException;

public class QueryExpressionVisitor extends GqlParserBaseVisitor<BindingTable> {
    @Override
    public BindingTable visitQueryExpression(QueryExpressionContext ctx) {
        BindingTable output = new BindingTable(true, true, new String[]{});

        if (ctx.getChild(0) instanceof FocusedQueryExpressionContext) {
            output = visitFocusedQueryExpression(ctx.focusedQueryExpression());
        } else if (ctx.getChild(0) instanceof AmbientQueryExpressionContext) {
            output = visitAmbientQueryExpression(ctx.ambientQueryExpression());
        }

        return output;
    }

    @Override
    public BindingTable visitFocusedQueryExpression(FocusedQueryExpressionContext ctx) {
        BindingTable output = new BindingTable(true, true, new String[]{});

        for (int i = 0; i < ctx.getChildCount(); i++) {
            System.out.println(i + ": " + ctx.getChild(i).getText());
        }

        String graphName = ctx.getChild(1).getText();

        try {
            WorkingGraph.getInstance().setLocalGraph(graphName);
        } catch (FileNotFoundException | InvalidEdgeFormatException | InvalidNodeFormatException exception) {
            exception.printStackTrace();
        }

        MatchClauseVisitor matchClauseVisitor = new MatchClauseVisitor();

        for (int i = 2; i < ctx.getChildCount()-1; i++) {
            System.out.println(i + ": " + ctx.getChild(i).getText());
            output = matchClauseVisitor.visit(ctx.matchClause(i-2));
        }

        return output;
    }

    @Override
    public BindingTable visitAmbientQueryExpression(AmbientQueryExpressionContext ctx) {
        BindingTable output = new BindingTable(true, true, new String[]{});

        MatchClauseVisitor matchClauseVisitor = new MatchClauseVisitor();

        for (int i = 0; i < ctx.getChildCount()-1; i++) {
            System.out.println(i + ": " + ctx.getChild(i).getText());
            output = matchClauseVisitor.visit(ctx.matchClause(i));
        }

        return output;
    }
}
