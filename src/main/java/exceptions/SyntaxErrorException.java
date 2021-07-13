package exceptions;

public class SyntaxErrorException extends IllegalStateException {
    public SyntaxErrorException(String s){
        super(s);
    }
}
