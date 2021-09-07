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

// Generated from JsonGraphParser.g4 by ANTLR 4.9.1

    package antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JsonGraphParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JsonGraphParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JsonGraphParser#jsonFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonFile(JsonGraphParser.JsonFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonGraphParser#jsonNodeFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonNodeFile(JsonGraphParser.JsonNodeFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonGraphParser#jsonEdgeFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonEdgeFile(JsonGraphParser.JsonEdgeFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonGraphParser#node}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNode(JsonGraphParser.NodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonGraphParser#edge}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEdge(JsonGraphParser.EdgeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonGraphParser#nodeFiller}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodeFiller(JsonGraphParser.NodeFillerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonGraphParser#edgeFiller}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEdgeFiller(JsonGraphParser.EdgeFillerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonGraphParser#identity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentity(JsonGraphParser.IdentityContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonGraphParser#startNode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartNode(JsonGraphParser.StartNodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonGraphParser#endNode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndNode(JsonGraphParser.EndNodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonGraphParser#isDirected}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsDirected(JsonGraphParser.IsDirectedContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonGraphParser#labels}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabels(JsonGraphParser.LabelsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonGraphParser#properties}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperties(JsonGraphParser.PropertiesContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonGraphParser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair(JsonGraphParser.PairContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonGraphParser#quotedId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuotedId(JsonGraphParser.QuotedIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonGraphParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(JsonGraphParser.ValueContext ctx);
}