package gql.patterns;

public class PathPatternUnion extends PathPatternExpression {
    PathPatternExpression left;
    PathPatternExpression right;

    public PathPatternUnion(PathPatternExpression left,
                            PathPatternExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return left.toString() + " | " + right.toString();
    }
}
