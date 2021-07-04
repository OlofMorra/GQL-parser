package gql.visitors;

import antlr.GqlParser;
import antlr.GqlParserBaseVisitor;
import antlr.GqlParser.MatchClauseContext;
import antlr.GqlParser.PathPatternListContext;
import gql.patterns.PathPattern;
import gql.tables.BindingTable;
import org.apache.tinkerpop.gremlin.structure.Vertex;


public class MatchClauseVisitor extends GqlParserBaseVisitor<BindingTable> {
    @Override
    public BindingTable visitMatchClause(MatchClauseContext ctx) {
        BindingTable output = new BindingTable(true, true, new String[]{});

        System.out.println("Match clause:");
        for (int i = 0; i < ctx.getChildCount(); i++) {
            System.out.println(i + ": " + ctx.getChild(i).getText());
        }

        output = visitPathPatternList(ctx.pathPatternList());

        return output;
    }

    @Override
    public BindingTable visitPathPatternList(PathPatternListContext ctx) {
        BindingTable output = new BindingTable(true, true, new String[]{});

        output = visitPath(ctx.path(0));

        return output;
    }

    @Override
    public BindingTable visitPath(GqlParser.PathContext ctx) {
        BindingTable output = new BindingTable(true, true, new String[]{});

        PathPatternExpressionVisitor pathPatternExpressionVisitor = new PathPatternExpressionVisitor();

        pathPatternExpressionVisitor.visitPathPatternExpression(ctx.pathPatternExpression());

        return output;
    }
}
