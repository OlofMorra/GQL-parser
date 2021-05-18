package gql.queries;

import gql.conjunctions.QueryConjunction;
import gql.queries.QueryExpression;

import java.util.ArrayList;
import java.util.List;

public class Query {
    public List<QueryExpression> queryExpressions;
    public List<QueryConjunction> queryConjunctions;

    public Query() {
        this.queryExpressions = new ArrayList<>();
        this.queryConjunctions = new ArrayList<>();
    }

    public void addQueryExpression(QueryExpression queryExpression) {
        queryExpressions.add(queryExpression);
    }

    public void addQueryConjunction(QueryConjunction queryConjunction) {
        queryConjunctions.add(queryConjunction);
    }
}
