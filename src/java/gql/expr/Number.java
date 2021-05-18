package src.java.gql.expr;

public class Number extends Value {
    int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
