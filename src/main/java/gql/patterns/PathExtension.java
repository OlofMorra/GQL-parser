package gql.patterns;

public class PathExtension {
    EdgePattern edgePattern;
    int quantifier;
    NodePattern nodePattern;

    public PathExtension(EdgePattern edgePattern,
                         int quantifier,
                         NodePattern nodePattern) {
        this.edgePattern = edgePattern;
        this.quantifier = quantifier;
        this.nodePattern = nodePattern;
    }

    @Override
    public String toString() {
        return edgePattern.toString() + quantifier + nodePattern.toString();
    }
}
