import antlr.GqlLexer;
import antlr.GqlParser;
import gql.GqlVisitor;
import gql.GqlProcessor;
import gql.listeners.ErrorListener;
import gql.queries.Query;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class GqlApp
{
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: file name");
        } else {
            String fileName = args[0];
            GqlParser parser = getParser("src/main/resources/queries/gql/tests/syntax_errors/" + fileName);

            // Tell ANTLR to build a parse tree from start symbol 'query'
            ParseTree antlrAST = parser.query();

            if (ErrorListener.hasError) {
                return;
            }

            // Create a visitor for converting the parse tree into Query objects
            GqlVisitor gqlVisitor = new GqlVisitor();
            Query query = gqlVisitor.visit(antlrAST);

            if (gqlVisitor.semanticErrors.isEmpty()) {
                GqlProcessor gqlProcessor = new GqlProcessor(query.queryExpressions);
                for (String evaluation: gqlProcessor.getEvaluationResults()) {
                    System.out.println(evaluation);
                }
            } else {
                for (String err: gqlVisitor.semanticErrors) {
                    System.err.println(err);
                }
            }
        }
    }

    private static GqlParser getParser(String fileName) {
        GqlParser parser = null;

        try {
            CharStream input = CharStreams.fromFileName(fileName);
            GqlLexer lexer = new GqlLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            parser = new GqlParser(tokens);

            setCustomErrorListener(parser);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return parser;
    }

    private static void setCustomErrorListener(GqlParser parser) {
        parser.removeErrorListeners();
        parser.addErrorListener(new ErrorListener());
    }
}