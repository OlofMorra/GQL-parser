package exceptions;

public class SyntaxErrorException extends IllegalStateException {
    public SyntaxErrorException(String s){
        super(s);
    }

    @Override
    public String getMessage() {
        return "Syntax error: " + super.getMessage();
    }
}
