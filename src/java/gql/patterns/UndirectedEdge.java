package src.java.gql.patterns;

public class UndirectedEdge extends Edge {
    public UndirectedEdge(ElementPatternFiller elementPatternFiller) {
        super(elementPatternFiller);
    }

    @Override
    public String toString() {
        return "~[" + elementPatternFiller.toString() + "]~";
    }
}
