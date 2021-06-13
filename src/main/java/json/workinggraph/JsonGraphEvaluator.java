package json.workinggraph;

import antlr.GqlLexer;
import antlr.JsonGraphParser;
import exceptions.InvalidEdgeFormatException;
import exceptions.InvalidNodeFormatException;
import gql.expressions.GqlId;
import gql.graphs.GqlEdge;
import gql.graphs.GqlNode;
import gql.listeners.ErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class JsonGraphEvaluator {
    private File databaseDirectory;

    public JsonGraphEvaluator(File databaseDirectory) throws FileNotFoundException {
        if (!databaseDirectory.exists()) {
            throw new FileNotFoundException("There is no file with filepath " + databaseDirectory.getAbsolutePath());
        }

        this.databaseDirectory = databaseDirectory;
    }

    public HashMap<GqlId, GqlNode> getNodes() throws InvalidNodeFormatException {
        JsonGraphParser nodeParser = getNodeParser();
        return parseNodeFile(nodeParser);
    }

    public HashMap<GqlId, GqlEdge> getEdges(HashMap<GqlId, GqlNode> nodes) throws InvalidEdgeFormatException {
        JsonGraphParser edgeParser = getEdgeParser();
        return parseEdgeFile(edgeParser, nodes);
    }

    private JsonGraphParser getNodeParser() {
        return getParser("nodes.json");
    }

    private JsonGraphParser getEdgeParser() {
        return getParser("edges.json");
    }

    private JsonGraphParser getParser(String fileName) {
        JsonGraphParser parser = null;

        try {
            CharStream input = CharStreams.fromFileName(this.databaseDirectory.getAbsolutePath() + "/" + fileName);
            GqlLexer lexer = new GqlLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            parser = new JsonGraphParser(tokens);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return parser;
    }

    private HashMap<GqlId, GqlNode> parseNodeFile(JsonGraphParser parser) throws InvalidNodeFormatException {
        // Tell ANTLR to build a parse tree from start symbol 'query'
        ParseTree antlrAST = parser.jsonNodeFile();

        if (!ErrorListener.hasError) {
            return visitNodeParseTree(antlrAST);
        } else {
            throw new InvalidNodeFormatException("node.json contains a syntax error.");
        }
    }

    private HashMap<GqlId, GqlNode> visitNodeParseTree(ParseTree antlrAST) throws InvalidNodeFormatException {
        // Create a visitor for converting the parse tree into Query objects
        JsonGraphVisitor jsonGraphVisitor = new JsonGraphVisitor();
        HashMap<GqlId, GqlNode> nodes = (HashMap<GqlId, GqlNode>) jsonGraphVisitor.visit(antlrAST);

        if (hasSemanticErrors(jsonGraphVisitor)) {
            outputSemanticErrors(jsonGraphVisitor);
            throw new InvalidNodeFormatException("Semantic error");
        }

        return nodes;
    }

    private HashMap<GqlId, GqlEdge> parseEdgeFile(JsonGraphParser parser, HashMap<GqlId, GqlNode> nodes) throws InvalidEdgeFormatException {
        // Tell ANTLR to build a parse tree from start symbol 'query'
        ParseTree antlrAST = parser.jsonEdgeFile();

        if (!ErrorListener.hasError) {
            return visitEdgeParseTree(antlrAST, nodes);
        } else {
            throw new InvalidEdgeFormatException("edge.json contains a syntax error.");
        }
    }

    private HashMap<GqlId, GqlEdge> visitEdgeParseTree(ParseTree antlrAST, HashMap<GqlId, GqlNode> nodes) throws InvalidEdgeFormatException {
        // Create a visitor for converting the parse tree into Query objects
        JsonGraphVisitor jsonGraphVisitor = new JsonGraphVisitor(nodes);
        HashMap<GqlId, GqlEdge> edges = (HashMap<GqlId, GqlEdge>) jsonGraphVisitor.visit(antlrAST);

        if (hasSemanticErrors(jsonGraphVisitor)) {
            outputSemanticErrors(jsonGraphVisitor);
            throw new InvalidEdgeFormatException("Semantic error");
        }

        return edges;
    }

    private boolean hasSemanticErrors(JsonGraphVisitor jsonGraphVisitor) {
        return !jsonGraphVisitor.semanticErrors.isEmpty();
    }

    private void outputSemanticErrors(JsonGraphVisitor jsonGraphVisitor) {
        for (String err : jsonGraphVisitor.semanticErrors) {
            System.err.println("Semantic error: " + err);
        }
    }
}
