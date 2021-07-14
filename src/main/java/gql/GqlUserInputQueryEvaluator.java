package gql;

import antlr.GqlLexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class GqlUserInputQueryEvaluator extends GqlQueryEvaluator {
    private String query;

    public GqlUserInputQueryEvaluator(String query) {
        this.query = query;
    }

    protected GqlLexer getLexer() {
        return new GqlLexer(getInputFromString());
    }

    private CharStream getInputFromString() {
        return CharStreams.fromString(this.query);
    }
}
