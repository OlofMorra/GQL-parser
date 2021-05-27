package gql.patterns;

public abstract class EdgePattern {
    ElementPatternFiller elementPatternFiller;

    public EdgePattern(ElementPatternFiller elementPatternFiller) {
        this.elementPatternFiller = elementPatternFiller;
    }

    @Override
    public abstract String toString();
}
