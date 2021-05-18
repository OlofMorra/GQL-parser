package src.java.gql.patterns;

public class LeftEdge extends Edge {
    public LeftEdge(ElementPatternFiller elementPatternFiller) {
        super(elementPatternFiller);
    }

    @Override
    public String toString() {
        return "<-[" + elementPatternFiller.toString() + "]-";
    }
}
