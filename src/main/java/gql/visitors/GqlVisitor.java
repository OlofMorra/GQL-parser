package gql.visitors;

import antlr.GqlParser.*;
import antlr.GqlParserBaseVisitor;
import exceptions.InvalidEdgeFormatException;
import exceptions.InvalidNodeFormatException;
import exceptions.SemanticErrorException;
import gql.enums.QueryConjunctor;
import gql.graphs.WorkingGraph;
import gql.returns.ReturnStatement;
import gql.tables.BindingTable;
import gql.tables.BindingTableConjuctor;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class GqlVisitor extends GqlParserBaseVisitor<BindingTable> {
    public List<String> semanticErrors;
    private final BindingTableConjuctor conjunctor = new BindingTableConjuctor();
    private final MatchClauseVisitor matchClauseVisitor = new MatchClauseVisitor();
    private final ReturnStatementVisitor returnStatementVisitor = new ReturnStatementVisitor();

    @Override
    public BindingTable visitQuery(QueryContext ctx) {
        BindingTable output = new BindingTable(false, new String[]{});
        semanticErrors = new ArrayList<>();

        for (int i = 0; i < ctx.getChildCount() - 1; i++) {
            if (isQueryExpression(i)) {
                output = visitQueryExpression((QueryExpressionContext) ctx.getChild(i));
            } else {
                BindingTable right = visitQueryExpression((QueryExpressionContext) ctx.getChild(i+1));
                output = conjunct(output, getQueryConjunctor((QueryConjunctionContext) ctx.getChild(i)), right);
                i = i+1;
            }
        }

        return output;
    }

    @Override
    public BindingTable visitQueryExpression(QueryExpressionContext ctx) {
        BindingTable output = new BindingTable(true, new String[]{});

        if (ctx.getChild(0) instanceof FocusedQueryExpressionContext) {
            output = visitFocusedQueryExpression(ctx.focusedQueryExpression());
        } else if (ctx.getChild(0) instanceof AmbientQueryExpressionContext) {
            output = visitAmbientQueryExpression(ctx.ambientQueryExpression());
        }

        return output;
    }

    @Override
    public BindingTable visitFocusedQueryExpression(FocusedQueryExpressionContext ctx) {
        List<FocusedMatchClauseContext> focusedMatchClauses = ctx.focusedMatchClause();
        BindingTable matches = visitFocusedMatchClause(focusedMatchClauses.get(0));

        for (int i = 1; i < focusedMatchClauses.size(); i++) {
            matches = conjunctor.crossProduct(matches, visitFocusedMatchClause(focusedMatchClauses.get(i)));
        }

        return getOutput(ctx.returnStatement(), matches);
    }

    @Override
    public BindingTable visitFocusedMatchClause(FocusedMatchClauseContext ctx) {
        setWorkingGraphTo(ctx.graphName().getText());

        return evaluateMatchClauses(ctx.matchClause());
    }

    @Override
    public BindingTable visitAmbientQueryExpression(AmbientQueryExpressionContext ctx) {
        BindingTable matches = evaluateMatchClauses(ctx.matchClause());

        return getOutput(ctx.returnStatement(), matches);
    }

    private BindingTable evaluateMatchClauses(List<MatchClauseContext> matchClauses) {
        BindingTable matches = matchClauseVisitor.visitMatchClause(matchClauses.get(0));

        for (int i = 1; i < matchClauses.size(); i++) {
            matches = conjunctor.crossProduct(matches, matchClauseVisitor.visit(matchClauses.get(i)));
        }

        return matches;
    }

    private boolean isQueryExpression(int i) {
        return i % 2 == 0;
    }

    private BindingTable conjunct(BindingTable left, QueryConjunctor conjunctionMethod, BindingTable right) {
        switch (conjunctionMethod) {
            case UNION_ALL: return conjunctor.unionAll(left, right);
            case UNION_DISTINCT: return conjunctor.unionDistinct(left, right);
            case UNION_MAX: return conjunctor.unionMax(left, right);
            case EXCEPT_ALL: return conjunctor.exceptAll(left, right);
            case EXCEPT_DISTINCT: return conjunctor.exceptDistinct(left, right);
            case INTERSECT_ALL: return conjunctor.intersectAll(left, right);
            case INTERSECT_DISTINCT: return conjunctor.intersectDistinct(left, right);
            case OTHERWISE: return conjunctor.otherwise(left, right);
        }

        throw new SemanticErrorException("Conjunction method " + conjunctionMethod + " does not exist.");
    }

    public QueryConjunctor getQueryConjunctor(QueryConjunctionContext ctx) {
        if (ctx.OTHERWISE() != null) return QueryConjunctor.OTHERWISE;

        if (ctx.setOperator().unionOperator() != null) {
            return getUnionConjunctor(ctx.setOperator().unionOperator());
        }

        if (ctx.setOperator().otherSetOperator().EXCEPT() != null) {
            return getExceptConjunctor(ctx.setOperator().otherSetOperator());
        }

        if (ctx.setOperator().otherSetOperator().INTERSECT() != null) {
            return getIntersectConjunctor(ctx.setOperator().otherSetOperator());
        }

        throw new SemanticErrorException("No such conjunction method: " + ctx.getText());
    }

    private QueryConjunctor getUnionConjunctor(UnionOperatorContext union) {
        if (union.MAX() != null) return QueryConjunctor.UNION_MAX;
        if (union.setQuantifier().ALL() != null) return QueryConjunctor.UNION_ALL;
        return QueryConjunctor.UNION_DISTINCT;
    }

    private QueryConjunctor getExceptConjunctor(OtherSetOperatorContext except) {
        if (except.setQuantifier() != null && except.setQuantifier().ALL() != null) return QueryConjunctor.EXCEPT_ALL;
        return QueryConjunctor.EXCEPT_DISTINCT;
    }

    private QueryConjunctor getIntersectConjunctor(OtherSetOperatorContext intersect) {
        if (intersect.setQuantifier() != null && intersect.setQuantifier().ALL() != null) return QueryConjunctor.INTERSECT_ALL;
        return QueryConjunctor.INTERSECT_DISTINCT;
    }

    private void setWorkingGraphTo(String graphName) {
        try {
            WorkingGraph.getInstance().setToMainDirectory();
            WorkingGraph.getInstance().setLocalGraph(graphName);
        } catch (FileNotFoundException exception) {
            semanticErrors.add("Graph with graphname " + graphName + " is not found");
            exception.printStackTrace();
        } catch (InvalidEdgeFormatException exception) {
            semanticErrors.add("Graph with graphname " + graphName + " has an invalid edges.json file.");
            exception.printStackTrace();
        } catch (InvalidNodeFormatException exception) {
            semanticErrors.add("Graph with graphname " + graphName + " has an invalid nodes.json file.");
            exception.printStackTrace();
        }
    }

    private BindingTable getOutput(ReturnStatementContext returnStatementContext, BindingTable matches) {
        ReturnStatement returnStatement = returnStatementVisitor.visitReturnStatement(returnStatementContext);

        if (returnStatement == null) return matches;
        return returnStatement.obtainResultFrom(matches);
    }
}