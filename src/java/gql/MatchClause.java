package src.java.gql;

import gql.enums.StatementMode;
import gql.patterns.PathPattern;

import java.util.List;

public class MatchClause {
    StatementMode statementMode;
    List<PathPattern> pathPatternList;
    WhereClause whereClause;

    public MatchClause(StatementMode statementMode,
                       List<PathPattern> pathPatternList,
                       WhereClause whereClause) {
        this.statementMode = statementMode;
        this.pathPatternList = pathPatternList;
        this.whereClause = whereClause;
    }

    @Override
    public String toString() {
        return statementMode + " MATCH " + pathPatternList.toString() + whereClause.toString();
    }
}
