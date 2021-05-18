package gql.clauses;

import java.util.List;

public class FocusedMatchClauses {
    String graphName;
    List<MatchClause> matchClauseList;

    public FocusedMatchClauses(String graphName,
                               List<MatchClause> matchClauseList) {
        this.graphName = graphName;
        this.matchClauseList = matchClauseList;
    }

    @Override
    public String toString() {
        return "FROM " + graphName.toString() + matchClauseList.toString();
    }
}
