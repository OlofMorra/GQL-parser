package src.java.gql.patterns;

public class PathExtension {
    Edge edge;
    int quantifier;
    Node node;

    public PathExtension(Edge edge,
                         int quantifier,
                         Node node) {
        this.edge = edge;
        this.quantifier = quantifier;
        this.node = node;
    }

    @Override
    public String toString() {
        return edge.toString() + quantifier + node.toString();
    }
}
