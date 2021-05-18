package gql.visitors;

import antlr.GqlParser.QueryExpressionContext;
import antlr.GqlParserBaseVisitor;
import gql.enums.SetQuantifier;
import gql.queries.FocusedQueryExpression;
import gql.queries.QueryExpression;
import gql.returns.ReturnStatement;

import java.util.Collections;

public class QueryExpressionVisitor extends GqlParserBaseVisitor<QueryExpression> {
    @Override
    public QueryExpression visitQueryExpression(QueryExpressionContext ctx) {

        System.out.println("Query expr:" + ctx.getChild(0).getChild(0).getText());

        return new FocusedQueryExpression(Collections.emptyList(), new ReturnStatement(SetQuantifier.ALL, Collections.emptyList()));
    }
}
