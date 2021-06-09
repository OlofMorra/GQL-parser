// Generated from JsonNodeParser.g4 by ANTLR 4.9.1

    package antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JsonNodeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JsonNodeParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JsonNodeParser#jsonNodeFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonNodeFile(JsonNodeParser.JsonNodeFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonNodeParser#node}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNode(JsonNodeParser.NodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonNodeParser#nodeFiller}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodeFiller(JsonNodeParser.NodeFillerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonNodeParser#identity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentity(JsonNodeParser.IdentityContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonNodeParser#labels}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabels(JsonNodeParser.LabelsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonNodeParser#properties}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperties(JsonNodeParser.PropertiesContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonNodeParser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair(JsonNodeParser.PairContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonNodeParser#quotedId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuotedId(JsonNodeParser.QuotedIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonNodeParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(JsonNodeParser.ValueContext ctx);
}