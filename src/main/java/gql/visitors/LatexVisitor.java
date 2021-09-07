/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package gql.visitors;

import antlr.GqlParser.*;
import antlr.GqlParserBaseVisitor;
import gql.enums.QueryConjunctor;
import gql.expressions.Expression;
import gql.expressions.values.TruthValue;
import gql.graphs.WorkingGraph;
import gql.patterns.EdgePattern;
import gql.patterns.ElementPattern;
import gql.patterns.NodePattern;
import gql.patterns.PathPattern;
import gql.returns.ReturnExpression;
import gql.returns.ReturnItem;
import gql.returns.ReturnStatement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class LatexVisitor extends GqlParserBaseVisitor {
    public List<String> semanticErrors;
    private final GqlVisitor gqlVisitor = new GqlVisitor();
    private final MatchClauseVisitor matchClauseVisitor = new MatchClauseVisitor();
    private final WhereClauseVisitior whereClauseVisitior = new WhereClauseVisitior();
    private final PathPatternExpressionVisitor pathPatternExpressionVisitor = new PathPatternExpressionVisitor();
    private final ReturnStatementVisitor returnStatementVisitor = new ReturnStatementVisitor();
    private StringBuilder latex;
    private final String NEW_LINE = " \\\\\n    ";

    // Counters for subscripts
    private int nodeCounter = 1;
    private int edgeCounter = 1;
    private int pathCounter = 1;
    private int graphCounter = 1;
    private int matchCounter = 1;
    private int queryCounter = 1;

    @Override
    public StringBuilder visitQuery(QueryContext ctx) {
        semanticErrors = new ArrayList<>();
        latex = new StringBuilder("\\begin{align*}\n    ");

        for (QueryExpressionContext queryExpressionContext: ctx.queryExpression()) {
            appendQueryExpression(queryExpressionContext);
            latex.append(NEW_LINE);
        }

        List<QueryConjunctionContext> list = ctx.queryConjunction();
        if (ctx.queryConjunction() != null && !ctx.queryConjunction().isEmpty()) {
            appendConjunctedQueryExpression(ctx.queryConjunction());
            latex.append(NEW_LINE);
        }

        removeIndent();
        return latex.append("\\end{align*}");
    }

    private void appendQueryExpression(QueryExpressionContext ctx) {
        if (ctx.focusedQueryExpression() != null) appendFocusedQueryExpression(ctx.focusedQueryExpression());
        if (ctx.ambientQueryExpression() != null) appendAmbientQueryExpression(ctx.ambientQueryExpression());
    }

    private void appendFocusedQueryExpression(FocusedQueryExpressionContext ctx) {
        for (FocusedMatchClauseContext focusedMatchClauseContext: ctx.focusedMatchClause()) {
            appendFocusedMatchClause(focusedMatchClauseContext);
        }

        appendReturnStatement(ctx.returnStatement());
    }

    private void appendAmbientQueryExpression(AmbientQueryExpressionContext ctx) {
        if (graphCounter == 1) {
            appendGraphName(WorkingGraph.getCurrentGraphName());
        }

        for (MatchClauseContext matchClauseContext: ctx.matchClause()) {
            appendMatchClause(matchClauseContext);
        }

        appendReturnStatement(ctx.returnStatement());
    }

    private void appendFocusedMatchClause(FocusedMatchClauseContext ctx) {
        appendGraphName(ctx.graphName().getText());

        for (MatchClauseContext matchClauseContext: ctx.matchClause()) {
            appendMatchClause(matchClauseContext);
        }
    }

    private void appendGraphName(String graphName) {
        latex.append("G &= ").append(graphName).append(NEW_LINE);
        graphCounter++;
    }

    private void appendMatchClause(MatchClauseContext ctx) {
        int pathStartIdx = pathCounter;

        for (PathPatternContext pathPatternContext: ctx.pathPatternList().pathPattern()) {
            appendPathPattern((PathPattern) pathPatternExpressionVisitor.visitPathPattern(pathPatternContext));
            latex.append("\\rel{").append(pathCounter).append("} &= ")
                    .append(matchClauseVisitor.getEvaluationMode(pathPatternContext.pathPatternPrefix()).toLatex())
                    .append(NEW_LINE);
            pathCounter++;
        }

        appendTuple("pi", pathStartIdx);
        appendTuple("rel", pathStartIdx);

        if (matchCounter == 1) latex.append("T &= \\{()\\}").append(NEW_LINE);

        String tableName = (matchCounter == 1) ? "T" : "M_{" + Integer.toString(matchCounter - 1) + "}";
        latex.append("M_{").append(matchCounter).append("} &= \\sem{\\mathblue{MATCH } \\Bar{\\pi}}(")
                .append(tableName).append(") = \\biguplus_{u \\in ").append(tableName)
                .append("} \\{u \\times u' \\mid u' \\in \\textsf{match}(\\Bar{\\pi}, G, u, \\rel{})\\}")
                .append(NEW_LINE);

        if (ctx.whereClause() != null) appendWhereClause(ctx.whereClause());

        if (ctx.OPTIONAL() != null) appendOptional(getQuery(ctx.whereClause()));
        if (ctx.MANDATORY() != null) appendMandatory(getQuery(ctx.whereClause()));

        matchCounter++;
    }

    private void appendWhereClause(WhereClauseContext ctx) {
        matchCounter++;

        Expression expression = whereClauseVisitior.visitWhereClause(ctx);
        String tableName = (matchCounter == 1) ? "T" : "M_{" + Integer.toString(matchCounter - 1) + "}";

        latex.append("M_{").append(matchCounter).append("} &= \\sem{\\mathblue{WHERE } \\texttt{")
                .append(expression.toLatex()).append("}}(").append(tableName)
                .append(") = \\{u \\in ").append(tableName).append(" \\mid \\semex{")
                .append(expression.toLatex()).append("} = \\mathblue{true}\\}").append(NEW_LINE);
    }

    private void appendOptional(String query) {
        matchCounter++;
        latex.append("M_{").append(matchCounter).append("} &= \\sem{\\mathblue{OPTIONAL ")
                .append(query).append("= ").append(NEW_LINE)
                .append(" & \\begin{cases}").append("\n        ")
                .append("\\sem{\\mathblue{").append(query)
                .append (" & \\text{if } \\sem{\\mathblue{").append(query).append(" \\neq \\emptyset")
                .append(NEW_LINE).append("    \\underset{u \\in T}{\\biguplus} (u, (\\textsf{free}")
                .append("(u, \\Bar{\\pi}): \\mathblue{null})) & \\text{otherwise}\n")
                .append("    \\end{cases}").append(NEW_LINE);
    }

    private void appendMandatory(String query) {
        matchCounter++;
        latex.append("M_{").append(matchCounter).append("} &= \\sem{\\mathblue{MANDATORY ")
                .append(query).append("= ").append(NEW_LINE)
                .append(" & \\begin{cases}").append("\n        ")
                .append("\\sem{\\mathblue{").append(query)
                .append (" & \\text{if } \\sem{\\mathblue{").append(query).append(" \\neq \\emptyset")
                .append(NEW_LINE).append("    \\text{Not valid} & \\text{otherwise}\n    \\end{cases}")
                .append(NEW_LINE);
    }

    private String getQuery(WhereClauseContext ctx) {
        StringBuilder query = new StringBuilder("MATCH } \\Bar{\\pi}");

        Expression expression = new TruthValue(true);

        if (ctx != null) {
            expression = whereClauseVisitior.visitWhereClause(ctx);
        }

        query.append("\\mathblue{ WHERE } \\texttt{").append(expression.toLatex())
                .append("}}(M_{").append(matchCounter).append("})");

        return query.toString();
    }

    private void appendTuple(String name, int pathStartIdx) {
        latex.append("\\").append((Objects.equals(name, "pi")) ? "Bar{\\" : "").append(name)
                .append((Objects.equals(name, "pi")) ? "}" : "").append(" &= (");

        for (int i = pathStartIdx; i < pathCounter; i++) {
            latex.append("\\").append(name).append((Objects.equals(name, "pi")) ? "_{" : "{")
                    .append(i).append("}, ");
        }

        removeComma();
        latex.append(")").append(NEW_LINE);
    }

    private void appendReturnStatement(ReturnStatementContext ctx) {
        ReturnStatement returnStatement = returnStatementVisitor.visitReturnStatement(ctx);

        latex.append("Q_").append(queryCounter).append(" &= \\sem{\\mathblue{RETURN ")
                .append(returnStatement.getSetQuantifier().toString()).append(" } ");

        for (ReturnItem returnItem: returnStatement.getReturnItems()) {
            latex.append(returnItem.toLatex()).append(", ");
        }
        removeComma();
        latex.append("}(M_{").append(matchCounter-1).append("}) = ");

        if (returnStatement.isDistinct()) latex.append("\\delta(");

        if (ctx.ASTERISK() != null) {
            latex.append("M_{").append(matchCounter-1).append("}");
        } else {
            latex.append("\\biguplus_{u \\in M_{").append(matchCounter-1).append("}} \\{(");
            appendReturnItems(returnStatement.getReturnItems());
            removeComma();
            latex.append(")\\}");
        }

        if (returnStatement.isDistinct()) latex.append(")");
        queryCounter++;
        matchCounter = 1;
    }

    private void appendConjunctedQueryExpression(List<QueryConjunctionContext> queryConjunctions) {
        for (int i = 0; i < queryConjunctions.size(); i++) {
            QueryConjunctor conjunctor = gqlVisitor.getQueryConjunctor(queryConjunctions.get(i));
            appendConjunction(conjunctor, i + 2);
        }
    }

    private void appendConjunction(QueryConjunctor conjunctor, int rightIndex) {
        latex.append(getQWithIndexUntil(rightIndex)).append(" &= \\sem{");
        String left = getQWithIndexUntil(rightIndex - 1).toString();
        String right = "Q_" + rightIndex;
        latex.append(left).append(" \\mathblue{ ").append(conjunctor.toString()).append(" }").append(right)
                .append("}(T) = ");

        switch (conjunctor) {
            case INTERSECT_ALL:
                latex.append(left).append(" \\bignplus ").append(right);
                break;
            case INTERSECT_DISTINCT:
                latex.append("\\delta(").append(left).append(" \\bignplus ").append(right).append(")");
                break;
            case UNION_ALL:
                latex.append(left).append(" \\biguplus ").append(right);
                break;
            case UNION_DISTINCT:
                latex.append("\\delta(").append(left).append(" \\biguplus ").append(right).append(")");
                break;
            case UNION_MAX:
                latex.append("(").append(left).append(" \\biguplus ").append(right).append(") - (")
                        .append(left).append(" \\bignplus ").append(right).append(")");
                break;
            case EXCEPT_ALL:
                latex.append(left).append(" - ").append(right);
                break;
            case EXCEPT_DISTINCT:
                latex.append("\\delta(").append(left).append(") - ").append(right);
                break;
            case OTHERWISE:
                latex.append("\\begin{cases}\n" + "  & \\text{if } \\sem{").append(left)
                        .append("}(T) \\\\\n").append("  \\sem{").append(left)
                        .append("}(T) & \\text{contains at least} \\\\\n")
                        .append("  & \\text{one record} \\\\\n").append("  \\sem{")
                        .append(right).append(" }(T) & \\text{otherwise}\n")
                        .append("\\end{cases}");
                break;
        }
    }

    private void appendPathPattern(PathPattern pathPattern) {
        int nodeStartIdx = nodeCounter;
        int edgeStartIdx = edgeCounter;

        for (ElementPattern elementPattern: pathPattern.getPathSequence()) {
            if (elementPattern instanceof NodePattern) appendNodePattern((NodePattern) elementPattern);
            if (elementPattern instanceof EdgePattern) appendEdgePattern((EdgePattern) elementPattern);
        }

        latex.append("\\pi_{").append(pathCounter).append("} &= ");

        for (int i = nodeStartIdx; i < nodeCounter; i++) {
            latex.append("\\chi_{").append(i).append("} ");
            if (edgeStartIdx != edgeCounter) latex.append("\\rho_{").append(edgeStartIdx).append("}");
            edgeStartIdx++;
        }

        latex.deleteCharAt(latex.length()-1).append(NEW_LINE);
    }

    private void appendNodePattern(NodePattern nodePattern) {
        latex.append("\\chi_{")
                .append(nodeCounter)
                .append("} &= ")
                .append(nodePattern.toLatex())
                .append(NEW_LINE);
        nodeCounter++;
    }

    private void appendEdgePattern(EdgePattern edgePattern) {
        latex.append("\\rho_{")
                .append(edgeCounter)
                .append("} &= ")
                .append(edgePattern.toLatex())
                .append(NEW_LINE);
        edgeCounter++;
    }

    private void appendReturnItems(ArrayList<ReturnItem> returnItems) {
        for (ReturnItem returnItem: returnItems) {
            latex.append(((ReturnExpression) returnItem).getName().toLatex()).append(": \\semex{")
                    .append(((ReturnExpression) returnItem).getExpression().toLatex()).append("}, ");
        }
    }

    private String getQWithIndexUntil(int rightIndex) {
        StringBuilder conjunction = new StringBuilder("Q_{1");

        for (int i = 2; i <= rightIndex; i++) {
            conjunction.append(", ").append(i);
        }

        return conjunction.append("}").toString();
    }

    private void removeIndent() {
        latex.delete(latex.length()-4, latex.length());
    }

    private void removeComma() {
        latex.delete(latex.length()-2, latex.length());
    }
}
