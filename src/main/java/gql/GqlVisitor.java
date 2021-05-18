package gql;

import antlr.GqlParser;
import antlr.GqlParserBaseVisitor;
import gql.queries.Query;
import gql.visitors.QueryExpressionVisitor;

import java.util.ArrayList;
import java.util.List;

public class GqlVisitor extends GqlParserBaseVisitor<Query> {
    public List<String> semanticErrors;

    @Override
    public Query visitQuery(GqlParser.QueryContext ctx) {
        Query query = new Query();
        semanticErrors = new ArrayList<>();

        QueryExpressionVisitor queryExpressionVisitor = new QueryExpressionVisitor();
        int nrOfChildren = ctx.getChildCount();

        for (int i = 0; i < nrOfChildren; i++) {
            if (isEndOfFile(nrOfChildren, i)) {
                /* Last child of start symbol query is EOF */
                // Do nothing
                System.out.println("End of query");
            } else if (isQueryExpression(i)) {
                query.addQueryExpression(queryExpressionVisitor.visit(ctx.getChild(i)));
                System.out.println("Query expression: " + ctx.getChild(i).getText());
            } else {
//                query.addQueryConjunction(ctx.getChild(i));
                System.out.println("Query conjunction: " + ctx.getChild(i).getText());
            }
        }

        return query;
    }

    private boolean isEndOfFile(int nrOfChildren, int i) {
        return i == nrOfChildren - 1;
    }

    private boolean isQueryExpression(int i) {
        return i % 2 == 0;
    }
}