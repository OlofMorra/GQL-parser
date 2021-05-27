package gql.patterns;

public class RightEdgePattern extends EdgePattern {
    public RightEdgePattern(ElementPatternFiller elementPatternFiller) {
        super(elementPatternFiller);
    }

    @Override
    public String toString() {
        return "-[" + elementPatternFiller.toString() + "]->";
    }
}
