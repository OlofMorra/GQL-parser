package gql.visitors;

import antlr.GqlParser.WhereClauseContext;
import antlr.GqlParserBaseVisitor;
import gql.expressions.Expression;


public class WhereClauseVisitior extends GqlParserBaseVisitor<Expression> {
    ExpressionVisitor expressionVisitor = new ExpressionVisitor();

    @Override
    public Expression visitWhereClause(WhereClauseContext ctx) {
        return expressionVisitor.visitExpr(ctx.expr());
    }
}
