package src.java.gql.expr;

public class Word extends Value {
    String word;

    public Word(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return word;
    }
}
