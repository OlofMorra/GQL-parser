package gql.patterns;

public class LeftEdgePattern extends EdgePattern {
    public LeftEdgePattern(ElementPatternFiller elementPatternFiller) {
        super(elementPatternFiller);
    }

    @Override
    public String toString() {
        return "<-[" + elementPatternFiller.toString() + "]-";
    }
}
