package gql.patterns;

import gql.enums.PathPatternPrefix;
import gql.patterns.PathPatternExpression;

public class PathPattern {
    String pathVariableName;
    PathPatternPrefix pathPatternPrefix;
    PathPatternExpression pathPatternExpression;

    public PathPattern(String pathVariableName,
                       PathPatternPrefix pathPatternPrefix,
                       PathPatternExpression pathPatternExpression) {
        this.pathVariableName = pathVariableName;
        this.pathPatternPrefix = pathPatternPrefix;
        this.pathPatternExpression = pathPatternExpression;
    }

    @Override
    public String toString() {
        return pathVariableName + " = " + pathPatternPrefix.toString() + " " + pathPatternPrefix.toString();
    }
}
