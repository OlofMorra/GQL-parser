package gql.patterns;

public abstract class Edge {
    ElementPatternFiller elementPatternFiller;

    public Edge(ElementPatternFiller elementPatternFiller) {
        this.elementPatternFiller = elementPatternFiller;
    }

    @Override
    public abstract String toString();
}
