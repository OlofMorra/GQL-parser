import antlr.GqlLexer;
import antlr.GqlParser;
import gql.GqlProcessor;
import gql.GqlVisitor;
import gql.listeners.ErrorListener;
import gql.queries.Query;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.List;

public class GqlQueryEvaluator {
    private String filePath;

    public GqlQueryEvaluator(String filePath) {
        this.filePath = filePath;
    }

    public void execute() {
        GqlParser parser = getParser();

        parseQuery(parser);
    }

    private GqlParser getParser() {
        GqlParser parser = null;

        try {
            CharStream input = CharStreams.fromFileName(this.filePath);
            GqlLexer lexer = new GqlLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            parser = new GqlParser(tokens);

            setCustomErrorListener(parser);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return parser;
    }

    private void setCustomErrorListener(GqlParser parser) {
        parser.removeErrorListeners();
        parser.addErrorListener(new ErrorListener());
    }

    private void parseQuery(GqlParser parser) {
        // Tell ANTLR to build a parse tree from start symbol 'query'
        ParseTree antlrAST = parser.query();

        if (!ErrorListener.hasError) {
            visitParseTree(antlrAST);
        }
    }

    private void visitParseTree(ParseTree antlrAST) {
        // Create a visitor for converting the parse tree into Query objects
        GqlVisitor gqlVisitor = new GqlVisitor();
        Query query = gqlVisitor.visit(antlrAST);

        if (hasSemanticErrors(gqlVisitor)) {
            outputSemanticErrors(gqlVisitor.semanticErrors);
        } else {
            outputQueryEvaluation(query);
        }
    }

    private boolean hasSemanticErrors(GqlVisitor gqlVisitor) {
        return !gqlVisitor.semanticErrors.isEmpty();
    }

    private void outputSemanticErrors(List<String> semanticErrors) {
        for (String err : semanticErrors) {
            System.err.println(err);
        }
    }

    private void outputQueryEvaluation(Query query) {
        GqlProcessor gqlProcessor = new GqlProcessor(query.queryExpressions);

        for (String evaluation : gqlProcessor.getEvaluationResults()) {
            System.out.println(evaluation);
        }
    }
}
