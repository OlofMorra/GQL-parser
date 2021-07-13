package exceptions;

public class SemanticErrorException extends IllegalStateException {
    public SemanticErrorException(String s){
        super(s);
    }
}
