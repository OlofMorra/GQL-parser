package src.java.gql.patterns;

public class Node {
    ElementPatternFiller elementPatternFiller;

    public Node(ElementPatternFiller elementPatternFiller) {
        this.elementPatternFiller = elementPatternFiller;
    }

    @Override
    public String toString() {
        return "(" + elementPatternFiller + ")";
    }
}
