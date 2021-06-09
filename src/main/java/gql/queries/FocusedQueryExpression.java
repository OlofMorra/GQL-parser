package gql.queries;

import gql.clauses.FocusedMatchClause;
import gql.returns.ReturnStatement;

import java.util.List;

public class FocusedQueryExpression extends QueryExpression {
    List<FocusedMatchClause> focusedMatchClauseList;
    ReturnStatement returnStatement;

    public FocusedQueryExpression(List<FocusedMatchClause> focusedMatchClauseList,
                                  ReturnStatement returnStatement) {
        this.focusedMatchClauseList = focusedMatchClauseList;
        this.returnStatement = returnStatement;
    }

    @Override
    public String toString() {
        return focusedMatchClauseList.toString() + returnStatement.toString();
    }
}
