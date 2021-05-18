package src.java.gql.patterns;

import java.util.List;

public class Path extends PathPatternExpression {
    Node startNode;
    List<PathExtension> pathSequence;

    public Path(Node startNode,
                List<PathExtension> pathSequence) {
        this.startNode = startNode;
        this.pathSequence = pathSequence;
    }

    @Override
    public String toString() {
        return startNode.toString() + pathSequence.toString();
    }
}
