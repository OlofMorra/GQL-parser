package src.java.gql;

import antlr.GqlParser;
import antlr.GqlParserBaseVisitor;

import java.util.List;

public class Gql extends GqlParserBaseVisitor<Query> {
    public List<String> semanticErrors;


}