package src.java.gql;

import java.util.ArrayList;
import java.util.List;

public class Query {
    public List<QueryExpr> queryExprList;

    public Query() {
        this.queryExprList = new ArrayList<>();
    }

    public void addQueryExpr(QueryExpr queryExpr) {
        queryExprList.add(queryExpr);
    }
}
