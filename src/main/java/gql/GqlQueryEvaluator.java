package gql;

import antlr.GqlLexer;
import antlr.GqlParser;
import exceptions.SemanticErrorException;
import exceptions.SyntaxErrorException;
import gql.visitors.GqlVisitor;
import gql.listeners.ErrorListener;
import gql.tables.BindingTable;
import gql.visitors.LatexVisitor;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public abstract class GqlQueryEvaluator {
    protected abstract GqlLexer getLexer();

    public BindingTable getEvaluationResult() {
        GqlParser parser = getParser();
        return parseQueryToBindingTable(parser);
    }

    public String getLatexResult() {
        GqlParser parser = getParser();
        return parseQueryToLatex(parser);
    }

    private GqlParser getParser() {
        GqlParser parser = null;

        GqlLexer lexer = getLexer();
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        parser = new GqlParser(tokens);

        setCustomErrorListener(parser);

        return parser;
    }

    private void setCustomErrorListener(GqlParser parser) {
        parser.removeErrorListeners();
        parser.addErrorListener(new ErrorListener());
    }

    private BindingTable parseQueryToBindingTable(GqlParser parser) {
        // Tell ANTLR to build a parse tree from start symbol 'query'
        ParseTree antlrAST = parser.query();

        if (parser.getNumberOfSyntaxErrors() == 0) {
            return visitParseTree(antlrAST);
        } else {
            throw new SyntaxErrorException("Query cannot be evaluated due to " + parser.getNumberOfSyntaxErrors() + " syntax errors.");
        }
    }

    private String parseQueryToLatex(GqlParser parser) {
        // Tell ANTLR to build a parse tree from start symbol 'query'
        ParseTree antlrAST = parser.query();

        if (parser.getNumberOfSyntaxErrors() == 0) {
            return visitParseTreeWithLatexVisitor(antlrAST);
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

    private String visitParseTreeWithLatexVisitor(ParseTree antlrAST) {
        // Create a visitor for converting the parse tree into Latex string
        LatexVisitor latexVisitor = new LatexVisitor();
        StringBuilder output = (StringBuilder) latexVisitor.visit(antlrAST);

        if (hasSemanticErrors(latexVisitor)) {
            outputSemanticErrors(latexVisitor);
            throw new SemanticErrorException("Query cannot be evaluated due to a semantic error.");
        } else {
            return output.toString();
        }
    }

    private boolean hasSemanticErrors(GqlVisitor gqlVisitor) {
        return !gqlVisitor.semanticErrors.isEmpty();
    }

    private boolean hasSemanticErrors(LatexVisitor latexVisitor) {
        return !latexVisitor.semanticErrors.isEmpty();
    }

    private void outputSemanticErrors(GqlVisitor gqlVisitor) {
        for (String err : gqlVisitor.semanticErrors) {
            System.err.println(err);
        }
    }

    private void outputSemanticErrors(LatexVisitor latexVisitor) {
        for (String err : latexVisitor.semanticErrors) {
            System.err.println(err);
        }
    }
}
