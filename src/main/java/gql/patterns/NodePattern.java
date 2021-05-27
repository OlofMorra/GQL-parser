package gql.patterns;

public class NodePattern {
    ElementPatternFiller elementPatternFiller;

    public NodePattern(ElementPatternFiller elementPatternFiller) {
        this.elementPatternFiller = elementPatternFiller;
    }

    @Override
    public String toString() {
        return "(" + elementPatternFiller + ")";
    }
}
