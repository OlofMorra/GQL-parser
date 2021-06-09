package gql.queries;

import gql.clauses.MatchClause;
import gql.returns.ReturnStatement;

import java.util.List;

public class AmbientQueryExpression extends QueryExpression {
    List<MatchClause> matchClauses;
    ReturnStatement returnStatement;

    public AmbientQueryExpression(List<MatchClause> matchClauses,
                                  ReturnStatement returnStatement) {
        this.matchClauses = matchClauses;
        this.returnStatement = returnStatement;
    }

    @Override
    public String toString() {
        return matchClauses.toString() + "\n" + returnStatement.toString();
    }
}
