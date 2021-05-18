package gql.queries;

import gql.clauses.FocusedMatchClauses;
import gql.returns.ReturnStatement;

import java.util.List;

public class FocusedQueryExpression extends QueryExpression {
    List<FocusedMatchClauses> focusedMatchClausesList;
    ReturnStatement returnStatement;

    public FocusedQueryExpression(List<FocusedMatchClauses> focusedMatchClausesList,
                                  ReturnStatement returnStatement) {
        this.focusedMatchClausesList = focusedMatchClausesList;
        this.returnStatement = returnStatement;
    }

    @Override
    public String toString() {
        return "FROM" +  focusedMatchClausesList.toString() + returnStatement.toString();
    }
}
