package gql;

import gql.returns.ReturnStatement;

import java.util.List;

public class FocusedQueryExpr extends QueryExpr {
    List<FocusedMatchClauses> focusedMatchClausesList;
    ReturnStatement returnStatement;

    public FocusedQueryExpr(List<FocusedMatchClauses> focusedMatchClausesList,
                            ReturnStatement returnStatement) {
        this.focusedMatchClausesList = focusedMatchClausesList;
        this.returnStatement = returnStatement;
    }

    @Override
    public String toString() {
        return focusedMatchClausesList.toString() + returnStatement.toString();
    }
}
