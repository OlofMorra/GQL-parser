package gql.clauses;

import java.util.List;

public class FocusedMatchClause {
    String graphName;
    List<MatchClause> matchClauseList;

    public FocusedMatchClause(String graphName,
                              List<MatchClause> matchClauseList) {
        this.graphName = graphName;
        this.matchClauseList = matchClauseList;
    }

    @Override
    public String toString() {
        return "FROM " + graphName.toString() + "\n" + matchClauseList.toString();
    }
}
