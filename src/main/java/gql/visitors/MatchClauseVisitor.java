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
