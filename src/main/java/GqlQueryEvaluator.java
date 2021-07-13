import antlr.GqlLexer;
import antlr.GqlParser;
import exceptions.SemanticErrorException;
import exceptions.SyntaxErrorException;
import gql.visitors.GqlVisitor;
import gql.listeners.ErrorListener;
import gql.tables.BindingTable;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class GqlQueryEvaluator {
    private String filePath;

    public GqlQueryEvaluator(String filePath) {
        this.filePath = filePath;
    }

    public BindingTable getEvaluationResult() {
        GqlParser parser = getParser();

        return parseQuery(parser);
    }

    private GqlParser getParser() {
        GqlParser parser = null;

        GqlLexer lexer = new GqlLexer(getInput());
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        parser = new GqlParser(tokens);

        setCustomErrorListener(parser);

        return parser;
    }

    private CharStream getInput() {
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

    private void setCustomErrorListener(GqlParser parser) {
        parser.removeErrorListeners();
        parser.addErrorListener(new ErrorListener());
    }

    private BindingTable parseQuery(GqlParser parser) {
        // Tell ANTLR to build a parse tree from start symbol 'query'
        ParseTree antlrAST = parser.query();

        if (parser.getNumberOfSyntaxErrors() == 0) {
            return visitParseTree(antlrAST);
        } else {
            throw new SyntaxErrorException("Query cannot be evaluated due to " + parser.getNumberOfSyntaxErrors() + " syntax errors.");
        }
    }

    private BindingTable visitParseTree(ParseTree antlrAST) {
        // Create a visitor for converting the parse tree into Query objects
        GqlVisitor gqlVisitor = new GqlVisitor();
        BindingTable output = gqlVisitor.visit(antlrAST);

        if (hasSemanticErrors(gqlVisitor)) {
            outputSemanticErrors(gqlVisitor);
            throw new SemanticErrorException("Query cannot be evaluated due to a semantic error.");
        } else {
            return output;
        }
    }

    private boolean hasSemanticErrors(GqlVisitor gqlVisitor) {
        return !gqlVisitor.semanticErrors.isEmpty();
    }

    private void outputSemanticErrors(GqlVisitor gqlVisitor) {
        for (String err : gqlVisitor.semanticErrors) {
            System.err.println(err);
        }
    }
}
