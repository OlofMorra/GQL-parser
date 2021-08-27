package gql.visitors;

import antlr.GqlParser.MatchClauseContext;
import antlr.GqlParser.PathPatternContext;
import antlr.GqlParser.PathPatternListContext;
import antlr.GqlParser.PathPatternPrefixContext;
import antlr.GqlParserBaseVisitor;
import gql.enums.EvaluationMode;
import gql.expressions.Expression;
import gql.patterns.PathPattern;
import gql.tables.BindingTable;
import gql.tables.BindingTableConjuctor;

import java.util.List;


public class MatchClauseVisitor extends GqlParserBaseVisitor<BindingTable> {
    private final BindingTableConjuctor conjunctor = new BindingTableConjuctor();
    private final WhereClauseVisitior whereClauseVisitior = new WhereClauseVisitior();
    private final PathPatternExpressionVisitor pathPatternExpressionVisitor = new PathPatternExpressionVisitor();

    @Override
    public BindingTable visitMatchClause(MatchClauseContext ctx) {
        BindingTable matches = visitPathPatternList(ctx.pathPatternList());

        if (ctx.MANDATORY() != null) {
            matches.isMandatory();
        } else if (ctx.OPTIONAL() != null) {
            matches.isMandatory();
        }

        if (ctx.whereClause() != null) {
            Expression whereClauseExpression = whereClauseVisitior.visitWhereClause(ctx.whereClause());
            matches.filter(whereClauseExpression);
        }

        return matches;
    }

    @Override
    public BindingTable visitPathPatternList(PathPatternListContext ctx) {
        List<PathPatternContext> pathPatterns = ctx.pathPattern();

        BindingTable matches = visitPathPattern(pathPatterns.get(0));

        for (int i = 1; i < pathPatterns.size(); i++) {
            matches = conjunctor.crossProduct(matches, visitPathPattern(pathPatterns.get(i)));
        }

        return matches;
    }

    @Override
    public BindingTable visitPathPattern(PathPatternContext ctx) {
        // TODO: implement path variables correctly
        PathPattern pathPattern = pathPatternExpressionVisitor.visitPathPatternExpression(ctx.pathPatternExpression());
        return pathPattern.match(getEvaluationMode(ctx.pathPatternPrefix()));
    }

    public EvaluationMode getEvaluationMode(PathPatternPrefixContext ctx) {
        if (ctx == null) return EvaluationMode.WALK;

        if (ctx.ACYCLIC() != null) {
            return EvaluationMode.ACYCLIC;
        } else if (ctx.TRAIL() != null) {
            return EvaluationMode.TRAIL;
        } else if (ctx.SIMPLE() != null) {
            return EvaluationMode.SIMPLE;
        }

        return EvaluationMode.WALK;
    }
}
