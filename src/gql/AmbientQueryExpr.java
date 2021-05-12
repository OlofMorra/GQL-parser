package gql;

import gql.returns.ReturnStatement;

import java.util.List;

public class AmbientQueryExpr extends QueryExpr {
    List<MatchClause> matchClauses;
    ReturnStatement returnStatement;

    public AmbientQueryExpr(List<MatchClause> matchClauses,
                            ReturnStatement returnStatement) {
        this.matchClauses = matchClauses;
        this.returnStatement = returnStatement;
    }

    @Override
    public String toString() {
        return matchClauses.toString() + returnStatement.toString();
    }
}
