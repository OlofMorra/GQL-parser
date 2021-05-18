package src.java.gql.patterns;

public class RightEdge extends Edge {
    public RightEdge(ElementPatternFiller elementPatternFiller) {
        super(elementPatternFiller);
    }

    @Override
    public String toString() {
        return "-[" + elementPatternFiller.toString() + "]->";
    }
}
