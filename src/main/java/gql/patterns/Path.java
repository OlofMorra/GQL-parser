package gql.patterns;

import java.util.List;

public class Path extends PathPatternExpression {
    NodePattern startNodePattern;
    List<PathExtension> pathSequence;

    public Path(NodePattern startNodePattern,
                List<PathExtension> pathSequence) {
        this.startNodePattern = startNodePattern;
        this.pathSequence = pathSequence;
    }

    @Override
    public String toString() {
        return startNodePattern.toString() + pathSequence.toString();
    }
}
