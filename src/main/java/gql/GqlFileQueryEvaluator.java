package gql;

import antlr.GqlLexer;
import antlr.GqlParser;
import gql.tables.BindingTable;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class GqlFileQueryEvaluator extends GqlQueryEvaluator {
    private String filePath;

    public GqlFileQueryEvaluator(String filePath) {
        this.filePath = filePath;
    }

    protected GqlLexer getLexer() {
        return new GqlLexer(getInputFromFile());
    }

    private CharStream getInputFromFile() {
        CharStream input = null;

        try {
            input = CharStreams.fromFileName(this.filePath);
        } catch (NoSuchFileException exception) {
            try {
                input = CharStreams.fromFileName(System.getProperty("user.dir") + this.filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }
}
