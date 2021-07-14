package exceptions;

public class SemanticErrorException extends IllegalStateException {
    public SemanticErrorException(String s){
        super(s);
    }

    @Override
    public String getMessage() {
        return "Semantic error: " + super.getMessage();
    }
}
