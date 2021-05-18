package gql.listeners;

import org.antlr.v4.runtime.*;

import java.util.Collections;
import java.util.List;

public class ErrorListener extends BaseErrorListener {
    public static boolean hasError = false;

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line,
                            int charPositionInLine,
                            String msg,
                            RecognitionException e) {
        hasError = true;

        List<String> stack = ((Parser) recognizer).getRuleInvocationStack();
        Collections.reverse(stack);

        System.err.println("Syntax error.");
        System.err.println("Token " + "\"" + ((Token) offendingSymbol).getText() + "\"" +
                " (line " + line + ", column " + charPositionInLine + ")" +
                ": " + msg);
        System.err.println("Rule stack: " + stack);
    }
}
