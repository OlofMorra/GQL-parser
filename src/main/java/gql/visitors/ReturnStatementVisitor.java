package gql.visitors;

import antlr.GqlParser.ReturnItemContext;
import antlr.GqlParser.ReturnListContext;
import antlr.GqlParser.ReturnStatementContext;
import antlr.GqlParser.SetQuantifierContext;
import antlr.GqlParserBaseVisitor;
import gql.enums.SetQuantifier;
import gql.expressions.Expression;
import gql.returns.Asterisk;
import gql.returns.ReturnExpression;
import gql.returns.ReturnItem;
import gql.returns.ReturnStatement;

import java.util.ArrayList;


public class ReturnStatementVisitor extends GqlParserBaseVisitor {
    ExpressionVisitor expressionVisitor = new ExpressionVisitor();

    @Override
    public ReturnStatement visitReturnStatement(ReturnStatementContext ctx) {
        ArrayList<ReturnItem> returnItems = new ArrayList<>();
        returnItems.add(new Asterisk());
        if (ctx.ASTERISK() != null) return new ReturnStatement(visitSetQuantifier(ctx.setQuantifier()), returnItems);

        returnItems = visitReturnList(ctx.returnList());
        return new ReturnStatement(visitSetQuantifier(ctx.setQuantifier()), returnItems);
    }

    @Override
    public SetQuantifier visitSetQuantifier(SetQuantifierContext ctx) {
        if (ctx == null) return SetQuantifier.ALL;
        if (ctx.ALL() != null) return SetQuantifier.ALL;
        return SetQuantifier.DISTINCT;
    }

    @Override
    public ArrayList<ReturnItem> visitReturnList(ReturnListContext ctx) {
        ArrayList<ReturnItem> returnItems = new ArrayList<>();

        for (ReturnItemContext returnItemContext: ctx.returnItem()) {
            returnItems.add(visitReturnItem(returnItemContext));
        }

        return returnItems;
    }

    @Override
    public ReturnExpression visitReturnItem(ReturnItemContext ctx) {
        Expression expr = expressionVisitor.visitExpr(ctx.expr());
        if (ctx.name() != null) return new ReturnExpression(expr, ctx.name().ID().getText());

        return new ReturnExpression(expr);
    }
}
