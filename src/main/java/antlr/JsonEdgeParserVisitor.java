// Generated from JsonEdgeParser.g4 by ANTLR 4.9.1

    package antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JsonEdgeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JsonEdgeParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JsonEdgeParser#jsonEdgeFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonEdgeFile(JsonEdgeParser.JsonEdgeFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonEdgeParser#edge}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEdge(JsonEdgeParser.EdgeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonEdgeParser#edgeFiller}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEdgeFiller(JsonEdgeParser.EdgeFillerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonEdgeParser#identity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentity(JsonEdgeParser.IdentityContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonEdgeParser#startNode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartNode(JsonEdgeParser.StartNodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonEdgeParser#endNode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndNode(JsonEdgeParser.EndNodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonEdgeParser#labels}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabels(JsonEdgeParser.LabelsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonEdgeParser#properties}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperties(JsonEdgeParser.PropertiesContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonEdgeParser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair(JsonEdgeParser.PairContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonEdgeParser#quotedId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuotedId(JsonEdgeParser.QuotedIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonEdgeParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(JsonEdgeParser.ValueContext ctx);
}