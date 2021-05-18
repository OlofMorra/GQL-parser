package gql;

import gql.queries.QueryExpression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GqlProcessor {
    List<QueryExpression> list;
    public Map<String, Integer> values; /* Symbol table for storing values of variables */

    public GqlProcessor(List<QueryExpression> list) {
        this.list = list;
        values = new HashMap<>();
    }

    public List<String> getEvaluationResults() {
        List<String> evaluations = new ArrayList<>();

        for (QueryExpression query: list) {
            String input = query.toString();
            evaluations.add(input);
//            if (query instanceof AmbientQueryExpression) {
//                // do something for ambient query expressions
//            }
        }

        return evaluations;
    }
}
