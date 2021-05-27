package gql.patterns;

public class UndirectedEdgePattern extends EdgePattern {
    public UndirectedEdgePattern(ElementPatternFiller elementPatternFiller) {
        super(elementPatternFiller);
    }

    @Override
    public String toString() {
        return "~[" + elementPatternFiller.toString() + "]~";
    }
}
