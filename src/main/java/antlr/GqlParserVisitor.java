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

// Generated from GqlParser.g4 by ANTLR 4.9.1

    package antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GqlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GqlParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GqlParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(GqlParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#queryConjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryConjunction(GqlParser.QueryConjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#queryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryExpression(GqlParser.QueryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#focusedQueryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFocusedQueryExpression(GqlParser.FocusedQueryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#ambientQueryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAmbientQueryExpression(GqlParser.AmbientQueryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#focusedMatchClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFocusedMatchClause(GqlParser.FocusedMatchClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#matchClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchClause(GqlParser.MatchClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(GqlParser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(GqlParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#pathPatternList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathPatternList(GqlParser.PathPatternListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#pathPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathPattern(GqlParser.PathPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#pathPatternPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathPatternPrefix(GqlParser.PathPatternPrefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#pathPatternExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathPatternExpression(GqlParser.PathPatternExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#pathTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathTerm(GqlParser.PathTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPath(GqlParser.PathContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#nodePattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodePattern(GqlParser.NodePatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#edgePattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEdgePattern(GqlParser.EdgePatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#fullEdgePointingLeft}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFullEdgePointingLeft(GqlParser.FullEdgePointingLeftContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#fullEdgeUndirected}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFullEdgeUndirected(GqlParser.FullEdgeUndirectedContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#fullEdgePointingRight}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFullEdgePointingRight(GqlParser.FullEdgePointingRightContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#elementPatternFiller}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementPatternFiller(GqlParser.ElementPatternFillerContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#propertyList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyList(GqlParser.PropertyListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#returnList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnList(GqlParser.ReturnListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#returnItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnItem(GqlParser.ReturnItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#setOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetOperator(GqlParser.SetOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#unionOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnionOperator(GqlParser.UnionOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#otherSetOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOtherSetOperator(GqlParser.OtherSetOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#setQuantifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetQuantifier(GqlParser.SetQuantifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#len}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLen(GqlParser.LenContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#quantifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifier(GqlParser.QuantifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanComparison}
	 * labeled alternative in {@link GqlParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanComparison(GqlParser.BooleanComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PropertyReference}
	 * labeled alternative in {@link GqlParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyReference(GqlParser.PropertyReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueExpression}
	 * labeled alternative in {@link GqlParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueExpression(GqlParser.ValueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NameExpression}
	 * labeled alternative in {@link GqlParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameExpression(GqlParser.NameExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueComparison}
	 * labeled alternative in {@link GqlParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueComparison(GqlParser.ValueComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionComparison}
	 * labeled alternative in {@link GqlParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionComparison(GqlParser.ExpressionComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NegatedExpression}
	 * labeled alternative in {@link GqlParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegatedExpression(GqlParser.NegatedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#isLabelExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsLabelExpr(GqlParser.IsLabelExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#labelExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelExpression(GqlParser.LabelExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#labelTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelTerm(GqlParser.LabelTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#labelFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelFactor(GqlParser.LabelFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#labelNegation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelNegation(GqlParser.LabelNegationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#labelPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelPrimary(GqlParser.LabelPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel(GqlParser.LabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#labelWildcard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelWildcard(GqlParser.LabelWildcardContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#parenthesizedLabelExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedLabelExpression(GqlParser.ParenthesizedLabelExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#comparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparator(GqlParser.ComparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#booleanComparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanComparator(GqlParser.BooleanComparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompOp(GqlParser.CompOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#graphName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraphName(GqlParser.GraphNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(GqlParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(GqlParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#pathVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathVariable(GqlParser.PathVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#elementVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementVariable(GqlParser.ElementVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link GqlParser#key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKey(GqlParser.KeyContext ctx);
}