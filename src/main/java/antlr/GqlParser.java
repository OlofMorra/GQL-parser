// Generated from GqlParser.g4 by ANTLR 4.9.1

    package antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GqlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ON=1, COMMENT=2, LINE_COMMENT=3, WS=4, UNSIGNED_INTEGER=5, KEYWORD=6, 
		ABS=7, ACOS=8, ADD=9, AGGREGATE=10, ALIAS=11, ALL=12, AND=13, ANY=14, 
		ARRAY=15, AS=16, ASC=17, ASCENDING=18, ASIN=19, AT=20, ATAN=21, AVG=22, 
		BINARY=23, BOOLEAN=24, BOTH=25, BY=26, CALL=27, CASE=28, CATALOG=29, CEIL=30, 
		CEILING=31, CHARACHTER=32, CHARACTER_LENGTH=33, CLEAR=34, CLONE=35, CLOSE=36, 
		COLLECT=37, COMMIT=38, CONSTRAINT=39, CONSTANT=40, CONSTRCUT=41, COPY=42, 
		COS=43, COSH=44, COST=45, COT=46, COUNT=47, CURRENT_DATE=48, CURRENT_GRAPH=49, 
		CURRENT_PROPERTY_GRAPH=50, CURRENT_ROLE=51, CURRENT_SCHEMA=52, CURRENT_TIME=53, 
		CURRENT_TIMESTAMP=54, CURRENT_USER=55, CREATE=56, DATE=57, DATETIME=58, 
		DECIMAL=59, DEFAULT=60, DEGREES=61, DELETE=62, DETACH=63, DESC=64, DESCENDING=65, 
		DIRECTORIES=66, DIRECTORY=67, DISTINCT=68, DO=69, DROP=70, DURATION=71, 
		ELSE=72, END=73, ENDS=74, EMPTY_BINDING_TABLE=75, EMPTY_GRAPH=76, EMPTY_PROPERTY_GRAPH=77, 
		EMPTY_TABLE=78, EXCEPT=79, EXISTS=80, EXISTING=81, EXP=82, EXPLAIN=83, 
		FALSE=84, FILTER=85, FLOAT=86, FLOAT32=87, FLOAT64=88, FLOAT128=89, FLOOR=90, 
		FOR=91, FROM=92, FUNCTOPM=93, FUNCTIONS=94, GQLSTATUS=95, GROUP=96, HAVING=97, 
		HOME_GRAPH=98, HOME_PROPERTY_GRAPH=99, HOME_SCHEMA=100, IN=101, INSERT=102, 
		INTEGER=103, INTEGER8=104, INTEGER16=105, INTEGER32=106, INTEGER64=107, 
		INTEGER128=108, INTERSECT=109, IF=110, IS=111, KEEP=112, LEADING=113, 
		LEFT=114, LENGTH=115, LET=116, LIKE=117, LIMIT=118, LIST=119, LN=120, 
		LOCALDATETIME=121, LOCALTIME=122, LOCALTIMESTAMP=123, LOG=124, LOG10=125, 
		LOWER=126, MANDATORY=127, MAP=128, MATCH=129, MERGE=130, MAX=131, MIN=132, 
		MOD=133, MULTI=134, MULTIPLE=135, MULTISET=136, NEW=137, NOT=138, NORMALIZE=139, 
		NOTHING=140, NULL=141, OCTET_LENGTH=142, OF=143, OFFSET=144, OPTIONAL=145, 
		OR=146, ORDER=147, ORDERED=148, OTHERWISE=149, PARAMETER=150, PATH=151, 
		PATHS=152, PARTITION=153, POWER=154, PROCEDURE=155, PROCEDURES=156, PRODUCT=157, 
		PROFILE=158, PROJECT=159, QUERIES=160, QUERY=161, RADIANS=162, RCORD=163, 
		RECORDS=164, REFERENCE=165, REMOVE=166, RENAME=167, REPLACE=168, REQUIRE=169, 
		RESET=170, RESULT=171, RETURN=172, RIGHT=173, ROLLBACK=174, SCALAR=175, 
		SCHEMA=176, SCHEMAS=177, SCHEMATA=178, SELECT=179, SESSION=180, SET=181, 
		SIN=182, SINGLE=183, SINH=184, SQRT=185, START=186, STARTS=187, STRING=188, 
		SUBSTRING=189, SUM=190, TAN=191, TANH=192, THEN=193, TIME=194, TIMESTAMP=195, 
		TRAILING=196, TRIM=197, TRUE=198, TRUNCATE=199, UNION=200, UNIT=201, UNIT_BINDING_TABLE=202, 
		UNIT_TABLE=203, UNIQUE=204, UNNEST=205, UNKNOWN=206, UNWIND=207, UPPER=208, 
		USE=209, VALUE=210, VALUES=211, WHEN=212, WHERE=213, WITH=214, WORKING_GRAPH=215, 
		XOR=216, YIELD=217, ZERO=218, ACYCLIC=219, BINDING=220, CLASS_ORIGIN=221, 
		COMMAND_FUNCTION=222, COMMAND_FUNCTION_CODE=223, CONDITION_NUMBER=224, 
		CONNECTING=225, DESTINATION=226, DIRECTED=227, EDGE=228, EDGES=229, FINAL=230, 
		GRAPH=231, GRAPHS=232, GROUPS=233, INDEX=234, LABEL=235, LABELS=236, MESSAGE_TEXT=237, 
		MUTABLE=238, NFC=239, NFD=240, NFKC=241, NFKD=242, NODE=243, NODES=244, 
		NORMALIZED=245, NUMBER=246, ONLY=247, ORDINALITY=248, PATTERN=249, PATTERNS=250, 
		PROPERTY=251, PROPERTIES=252, READ=253, RELATIONSHIP=254, RELATIONSHIPS=255, 
		RETURNED_GQLSTATUS=256, SHORTEST=257, SIMPLE=258, SUBCLASS_ORIGIN=259, 
		TABLE=260, TABLES=261, TIES=262, TO=263, TRAIL=264, TRANSACTION=265, TYPE=266, 
		TYPES=267, UNDIRECTED=268, VERTEX=269, VERTICES=270, WALK=271, WRITE=272, 
		TRUTH_VALUE=273, LEFT_ARROW=274, RIGHT_ARROW=275, BRACKET_RIGHT_ARROW=276, 
		LEFT_ARROW_BRACKET=277, DOUBLE_COLON=278, DOUBLE_MINUS_SIGN=279, DOUBLE_PERIOD=280, 
		DOUBLE_SOLIDUS=281, DOUBLED_GRAVE_ACCENT=282, MINUS_LEFT_BRACKET=283, 
		RIGHT_BRACKET_MINUS=284, TILDE_LEFT_BRACKET=285, RIGHT_BRACKET_TILDE=286, 
		BRACKET_TILDE_RIGHT_ARROW=287, LEFT_ARROW_TILDE_BRACKET=288, TILDE_RIGHT_ARROW=289, 
		LEFT_ARROW_TILDE=290, LEFT_MINUS_RIGHT=291, MINUS_SLASH=292, SLASH_MINUS=293, 
		SLASH_MINUS_RIGHT=294, LEFT_MINUS_SLASH=295, TILDE_SLASH=296, SLASH_TILDE=297, 
		SLASH_TILDE_RIGHT=298, LEFT_TILDE_SLASH=299, AMPERSAND=300, ASTERISK=301, 
		CIRCUMFLEX=302, COLON=303, COMMA=304, DOLLAR_SIGN=305, DOUBLE_QUOTE=306, 
		EXCLAMATION_MARK=307, GRAVE_ACCENT=308, MINUS_SIGN=309, PERCENT=310, PERIOD=311, 
		PLUS_SIGN=312, QUESTION_MARK=313, QUOTE=314, SEMICOLON=315, SOLIDUS=316, 
		TILDE=317, VERTICAL_BAR=318, CONCATENATION=319, MULTISET_ALTERNATION=320, 
		GEQ=321, LEQ=322, NEQ=323, LT=324, GT=325, EQ=326, LEFT_BRACE=327, RIGHT_BRACE=328, 
		LEFT_BRACKET=329, RIGHT_BRACKET=330, LEFT_ANGLE_BRACKET=331, RIGHT_ANGLE_BRACKET=332, 
		LEFT_PAREN=333, RIGHT_PAREN=334, NEWLINE=335, ID=336, WORD=337;
	public static final int
		RULE_query = 0, RULE_queryConjunction = 1, RULE_queryExpression = 2, RULE_focusedQueryExpression = 3, 
		RULE_ambientQueryExpression = 4, RULE_matchClause = 5, RULE_whereClause = 6, 
		RULE_returnStatement = 7, RULE_pathPatternList = 8, RULE_pathPattern = 9, 
		RULE_pathPatternPrefix = 10, RULE_pathPatternExpression = 11, RULE_pathPatternUnion = 12, 
		RULE_pathTerm = 13, RULE_path = 14, RULE_nodePattern = 15, RULE_edgePattern = 16, 
		RULE_fullEdgePointingLeft = 17, RULE_fullEdgeUndirected = 18, RULE_fullEdgePointingRight = 19, 
		RULE_elementPatternFiller = 20, RULE_propertyList = 21, RULE_returnList = 22, 
		RULE_returnItem = 23, RULE_setOperator = 24, RULE_unionOperator = 25, 
		RULE_otherSetOperator = 26, RULE_setQuantifier = 27, RULE_len = 28, RULE_quantifier = 29, 
		RULE_expr = 30, RULE_isLabelExpr = 31, RULE_labelExpression = 32, RULE_labelTerm = 33, 
		RULE_labelFactor = 34, RULE_labelNegation = 35, RULE_labelPrimary = 36, 
		RULE_label = 37, RULE_labelWildcard = 38, RULE_parenthesizedLabelExpression = 39, 
		RULE_comparator = 40, RULE_booleanComparator = 41, RULE_compOp = 42, RULE_graphName = 43, 
		RULE_name = 44, RULE_value = 45, RULE_pathVariable = 46, RULE_elementVariable = 47, 
		RULE_key = 48;
	private static String[] makeRuleNames() {
		return new String[] {
			"query", "queryConjunction", "queryExpression", "focusedQueryExpression", 
			"ambientQueryExpression", "matchClause", "whereClause", "returnStatement", 
			"pathPatternList", "pathPattern", "pathPatternPrefix", "pathPatternExpression", 
			"pathPatternUnion", "pathTerm", "path", "nodePattern", "edgePattern", 
			"fullEdgePointingLeft", "fullEdgeUndirected", "fullEdgePointingRight", 
			"elementPatternFiller", "propertyList", "returnList", "returnItem", "setOperator", 
			"unionOperator", "otherSetOperator", "setQuantifier", "len", "quantifier", 
			"expr", "isLabelExpr", "labelExpression", "labelTerm", "labelFactor", 
			"labelNegation", "labelPrimary", "label", "labelWildcard", "parenthesizedLabelExpression", 
			"comparator", "booleanComparator", "compOp", "graphName", "name", "value", 
			"pathVariable", "elementVariable", "key"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "'<-'", "'->'", 
			"']->'", "'<-['", "'::'", "'--'", "'..'", "'//'", "'``'", "'-['", "']-'", 
			"'~['", "']~'", "']~>'", "'<~['", "'~>'", "'<~'", "'<->'", "'-/'", "'/-'", 
			"'/->'", "'<-/'", "'~/'", "'/~'", "'/~>'", "'<~/'", "'&'", "'*'", "'^'", 
			"':'", "','", "'$'", "'\"'", "'!'", "'`'", "'-'", "'%'", "'.'", "'+'", 
			"'?'", "'''", "';'", "'/'", "'~'", "'|'", "'||'", "'|+|'", "'>='", "'<='", 
			"'<>'", null, null, "'='", "'{'", "'}'", "'['", "']'", "'<'", "'>'", 
			"'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ON", "COMMENT", "LINE_COMMENT", "WS", "UNSIGNED_INTEGER", "KEYWORD", 
			"ABS", "ACOS", "ADD", "AGGREGATE", "ALIAS", "ALL", "AND", "ANY", "ARRAY", 
			"AS", "ASC", "ASCENDING", "ASIN", "AT", "ATAN", "AVG", "BINARY", "BOOLEAN", 
			"BOTH", "BY", "CALL", "CASE", "CATALOG", "CEIL", "CEILING", "CHARACHTER", 
			"CHARACTER_LENGTH", "CLEAR", "CLONE", "CLOSE", "COLLECT", "COMMIT", "CONSTRAINT", 
			"CONSTANT", "CONSTRCUT", "COPY", "COS", "COSH", "COST", "COT", "COUNT", 
			"CURRENT_DATE", "CURRENT_GRAPH", "CURRENT_PROPERTY_GRAPH", "CURRENT_ROLE", 
			"CURRENT_SCHEMA", "CURRENT_TIME", "CURRENT_TIMESTAMP", "CURRENT_USER", 
			"CREATE", "DATE", "DATETIME", "DECIMAL", "DEFAULT", "DEGREES", "DELETE", 
			"DETACH", "DESC", "DESCENDING", "DIRECTORIES", "DIRECTORY", "DISTINCT", 
			"DO", "DROP", "DURATION", "ELSE", "END", "ENDS", "EMPTY_BINDING_TABLE", 
			"EMPTY_GRAPH", "EMPTY_PROPERTY_GRAPH", "EMPTY_TABLE", "EXCEPT", "EXISTS", 
			"EXISTING", "EXP", "EXPLAIN", "FALSE", "FILTER", "FLOAT", "FLOAT32", 
			"FLOAT64", "FLOAT128", "FLOOR", "FOR", "FROM", "FUNCTOPM", "FUNCTIONS", 
			"GQLSTATUS", "GROUP", "HAVING", "HOME_GRAPH", "HOME_PROPERTY_GRAPH", 
			"HOME_SCHEMA", "IN", "INSERT", "INTEGER", "INTEGER8", "INTEGER16", "INTEGER32", 
			"INTEGER64", "INTEGER128", "INTERSECT", "IF", "IS", "KEEP", "LEADING", 
			"LEFT", "LENGTH", "LET", "LIKE", "LIMIT", "LIST", "LN", "LOCALDATETIME", 
			"LOCALTIME", "LOCALTIMESTAMP", "LOG", "LOG10", "LOWER", "MANDATORY", 
			"MAP", "MATCH", "MERGE", "MAX", "MIN", "MOD", "MULTI", "MULTIPLE", "MULTISET", 
			"NEW", "NOT", "NORMALIZE", "NOTHING", "NULL", "OCTET_LENGTH", "OF", "OFFSET", 
			"OPTIONAL", "OR", "ORDER", "ORDERED", "OTHERWISE", "PARAMETER", "PATH", 
			"PATHS", "PARTITION", "POWER", "PROCEDURE", "PROCEDURES", "PRODUCT", 
			"PROFILE", "PROJECT", "QUERIES", "QUERY", "RADIANS", "RCORD", "RECORDS", 
			"REFERENCE", "REMOVE", "RENAME", "REPLACE", "REQUIRE", "RESET", "RESULT", 
			"RETURN", "RIGHT", "ROLLBACK", "SCALAR", "SCHEMA", "SCHEMAS", "SCHEMATA", 
			"SELECT", "SESSION", "SET", "SIN", "SINGLE", "SINH", "SQRT", "START", 
			"STARTS", "STRING", "SUBSTRING", "SUM", "TAN", "TANH", "THEN", "TIME", 
			"TIMESTAMP", "TRAILING", "TRIM", "TRUE", "TRUNCATE", "UNION", "UNIT", 
			"UNIT_BINDING_TABLE", "UNIT_TABLE", "UNIQUE", "UNNEST", "UNKNOWN", "UNWIND", 
			"UPPER", "USE", "VALUE", "VALUES", "WHEN", "WHERE", "WITH", "WORKING_GRAPH", 
			"XOR", "YIELD", "ZERO", "ACYCLIC", "BINDING", "CLASS_ORIGIN", "COMMAND_FUNCTION", 
			"COMMAND_FUNCTION_CODE", "CONDITION_NUMBER", "CONNECTING", "DESTINATION", 
			"DIRECTED", "EDGE", "EDGES", "FINAL", "GRAPH", "GRAPHS", "GROUPS", "INDEX", 
			"LABEL", "LABELS", "MESSAGE_TEXT", "MUTABLE", "NFC", "NFD", "NFKC", "NFKD", 
			"NODE", "NODES", "NORMALIZED", "NUMBER", "ONLY", "ORDINALITY", "PATTERN", 
			"PATTERNS", "PROPERTY", "PROPERTIES", "READ", "RELATIONSHIP", "RELATIONSHIPS", 
			"RETURNED_GQLSTATUS", "SHORTEST", "SIMPLE", "SUBCLASS_ORIGIN", "TABLE", 
			"TABLES", "TIES", "TO", "TRAIL", "TRANSACTION", "TYPE", "TYPES", "UNDIRECTED", 
			"VERTEX", "VERTICES", "WALK", "WRITE", "TRUTH_VALUE", "LEFT_ARROW", "RIGHT_ARROW", 
			"BRACKET_RIGHT_ARROW", "LEFT_ARROW_BRACKET", "DOUBLE_COLON", "DOUBLE_MINUS_SIGN", 
			"DOUBLE_PERIOD", "DOUBLE_SOLIDUS", "DOUBLED_GRAVE_ACCENT", "MINUS_LEFT_BRACKET", 
			"RIGHT_BRACKET_MINUS", "TILDE_LEFT_BRACKET", "RIGHT_BRACKET_TILDE", "BRACKET_TILDE_RIGHT_ARROW", 
			"LEFT_ARROW_TILDE_BRACKET", "TILDE_RIGHT_ARROW", "LEFT_ARROW_TILDE", 
			"LEFT_MINUS_RIGHT", "MINUS_SLASH", "SLASH_MINUS", "SLASH_MINUS_RIGHT", 
			"LEFT_MINUS_SLASH", "TILDE_SLASH", "SLASH_TILDE", "SLASH_TILDE_RIGHT", 
			"LEFT_TILDE_SLASH", "AMPERSAND", "ASTERISK", "CIRCUMFLEX", "COLON", "COMMA", 
			"DOLLAR_SIGN", "DOUBLE_QUOTE", "EXCLAMATION_MARK", "GRAVE_ACCENT", "MINUS_SIGN", 
			"PERCENT", "PERIOD", "PLUS_SIGN", "QUESTION_MARK", "QUOTE", "SEMICOLON", 
			"SOLIDUS", "TILDE", "VERTICAL_BAR", "CONCATENATION", "MULTISET_ALTERNATION", 
			"GEQ", "LEQ", "NEQ", "LT", "GT", "EQ", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_BRACKET", 
			"RIGHT_BRACKET", "LEFT_ANGLE_BRACKET", "RIGHT_ANGLE_BRACKET", "LEFT_PAREN", 
			"RIGHT_PAREN", "NEWLINE", "ID", "WORD"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "GqlParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GqlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class QueryContext extends ParserRuleContext {
		public List<QueryExpressionContext> queryExpression() {
			return getRuleContexts(QueryExpressionContext.class);
		}
		public QueryExpressionContext queryExpression(int i) {
			return getRuleContext(QueryExpressionContext.class,i);
		}
		public TerminalNode EOF() { return getToken(GqlParser.EOF, 0); }
		public List<QueryConjunctionContext> queryConjunction() {
			return getRuleContexts(QueryConjunctionContext.class);
		}
		public QueryConjunctionContext queryConjunction(int i) {
			return getRuleContext(QueryConjunctionContext.class,i);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_query);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			queryExpression();
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXCEPT || _la==INTERSECT || _la==OTHERWISE || _la==UNION) {
				{
				{
				setState(99);
				queryConjunction();
				setState(100);
				queryExpression();
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryConjunctionContext extends ParserRuleContext {
		public SetOperatorContext setOperator() {
			return getRuleContext(SetOperatorContext.class,0);
		}
		public TerminalNode OTHERWISE() { return getToken(GqlParser.OTHERWISE, 0); }
		public QueryConjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryConjunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterQueryConjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitQueryConjunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitQueryConjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryConjunctionContext queryConjunction() throws RecognitionException {
		QueryConjunctionContext _localctx = new QueryConjunctionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_queryConjunction);
		try {
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXCEPT:
			case INTERSECT:
			case UNION:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				setOperator();
				}
				break;
			case OTHERWISE:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				match(OTHERWISE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryExpressionContext extends ParserRuleContext {
		public FocusedQueryExpressionContext focusedQueryExpression() {
			return getRuleContext(FocusedQueryExpressionContext.class,0);
		}
		public AmbientQueryExpressionContext ambientQueryExpression() {
			return getRuleContext(AmbientQueryExpressionContext.class,0);
		}
		public QueryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterQueryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitQueryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitQueryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryExpressionContext queryExpression() throws RecognitionException {
		QueryExpressionContext _localctx = new QueryExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_queryExpression);
		try {
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FROM:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				focusedQueryExpression();
				}
				break;
			case MANDATORY:
			case MATCH:
			case OPTIONAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				ambientQueryExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FocusedQueryExpressionContext extends ParserRuleContext {
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public List<TerminalNode> FROM() { return getTokens(GqlParser.FROM); }
		public TerminalNode FROM(int i) {
			return getToken(GqlParser.FROM, i);
		}
		public List<GraphNameContext> graphName() {
			return getRuleContexts(GraphNameContext.class);
		}
		public GraphNameContext graphName(int i) {
			return getRuleContext(GraphNameContext.class,i);
		}
		public List<MatchClauseContext> matchClause() {
			return getRuleContexts(MatchClauseContext.class);
		}
		public MatchClauseContext matchClause(int i) {
			return getRuleContext(MatchClauseContext.class,i);
		}
		public FocusedQueryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_focusedQueryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterFocusedQueryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitFocusedQueryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitFocusedQueryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FocusedQueryExpressionContext focusedQueryExpression() throws RecognitionException {
		FocusedQueryExpressionContext _localctx = new FocusedQueryExpressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_focusedQueryExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(117);
				match(FROM);
				setState(118);
				graphName();
				setState(120); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(119);
					matchClause();
					}
					}
					setState(122); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & ((1L << (MANDATORY - 127)) | (1L << (MATCH - 127)) | (1L << (OPTIONAL - 127)))) != 0) );
				}
				}
				setState(126); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==FROM );
			setState(128);
			returnStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AmbientQueryExpressionContext extends ParserRuleContext {
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public List<MatchClauseContext> matchClause() {
			return getRuleContexts(MatchClauseContext.class);
		}
		public MatchClauseContext matchClause(int i) {
			return getRuleContext(MatchClauseContext.class,i);
		}
		public AmbientQueryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ambientQueryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterAmbientQueryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitAmbientQueryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitAmbientQueryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AmbientQueryExpressionContext ambientQueryExpression() throws RecognitionException {
		AmbientQueryExpressionContext _localctx = new AmbientQueryExpressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ambientQueryExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(130);
				matchClause();
				}
				}
				setState(133); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 127)) & ~0x3f) == 0 && ((1L << (_la - 127)) & ((1L << (MANDATORY - 127)) | (1L << (MATCH - 127)) | (1L << (OPTIONAL - 127)))) != 0) );
			setState(135);
			returnStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MatchClauseContext extends ParserRuleContext {
		public TerminalNode MATCH() { return getToken(GqlParser.MATCH, 0); }
		public PathPatternListContext pathPatternList() {
			return getRuleContext(PathPatternListContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public TerminalNode OPTIONAL() { return getToken(GqlParser.OPTIONAL, 0); }
		public TerminalNode MANDATORY() { return getToken(GqlParser.MANDATORY, 0); }
		public MatchClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterMatchClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitMatchClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitMatchClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchClauseContext matchClause() throws RecognitionException {
		MatchClauseContext _localctx = new MatchClauseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_matchClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MANDATORY || _la==OPTIONAL) {
				{
				setState(137);
				_la = _input.LA(1);
				if ( !(_la==MANDATORY || _la==OPTIONAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(140);
			match(MATCH);
			setState(141);
			pathPatternList();
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(142);
				whereClause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhereClauseContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(GqlParser.WHERE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitWhereClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitWhereClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(WHERE);
			setState(146);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(GqlParser.RETURN, 0); }
		public TerminalNode ASTERISK() { return getToken(GqlParser.ASTERISK, 0); }
		public ReturnListContext returnList() {
			return getRuleContext(ReturnListContext.class,0);
		}
		public SetQuantifierContext setQuantifier() {
			return getRuleContext(SetQuantifierContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(RETURN);
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(149);
				setQuantifier();
				}
			}

			setState(154);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASTERISK:
				{
				setState(152);
				match(ASTERISK);
				}
				break;
			case UNSIGNED_INTEGER:
			case NOT:
			case TRUTH_VALUE:
			case ID:
			case WORD:
				{
				setState(153);
				returnList();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathPatternListContext extends ParserRuleContext {
		public PathPatternContext pathPattern() {
			return getRuleContext(PathPatternContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(GqlParser.COMMA, 0); }
		public PathPatternListContext pathPatternList() {
			return getRuleContext(PathPatternListContext.class,0);
		}
		public PathPatternListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathPatternList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterPathPatternList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitPathPatternList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitPathPatternList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathPatternListContext pathPatternList() throws RecognitionException {
		PathPatternListContext _localctx = new PathPatternListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_pathPatternList);
		try {
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				pathPattern();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				pathPattern();
				setState(158);
				match(COMMA);
				setState(159);
				pathPatternList();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathPatternContext extends ParserRuleContext {
		public PathPatternExpressionContext pathPatternExpression() {
			return getRuleContext(PathPatternExpressionContext.class,0);
		}
		public PathVariableContext pathVariable() {
			return getRuleContext(PathVariableContext.class,0);
		}
		public TerminalNode EQ() { return getToken(GqlParser.EQ, 0); }
		public PathPatternPrefixContext pathPatternPrefix() {
			return getRuleContext(PathPatternPrefixContext.class,0);
		}
		public PathPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterPathPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitPathPattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitPathPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathPatternContext pathPattern() throws RecognitionException {
		PathPatternContext _localctx = new PathPatternContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_pathPattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(163);
				pathVariable();
				setState(164);
				match(EQ);
				}
			}

			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 219)) & ~0x3f) == 0 && ((1L << (_la - 219)) & ((1L << (ACYCLIC - 219)) | (1L << (SIMPLE - 219)) | (1L << (TRAIL - 219)) | (1L << (WALK - 219)))) != 0)) {
				{
				setState(168);
				pathPatternPrefix();
				}
			}

			setState(171);
			pathPatternExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathPatternPrefixContext extends ParserRuleContext {
		public TerminalNode WALK() { return getToken(GqlParser.WALK, 0); }
		public TerminalNode TRAIL() { return getToken(GqlParser.TRAIL, 0); }
		public TerminalNode ACYCLIC() { return getToken(GqlParser.ACYCLIC, 0); }
		public TerminalNode SIMPLE() { return getToken(GqlParser.SIMPLE, 0); }
		public PathPatternPrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathPatternPrefix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterPathPatternPrefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitPathPatternPrefix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitPathPatternPrefix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathPatternPrefixContext pathPatternPrefix() throws RecognitionException {
		PathPatternPrefixContext _localctx = new PathPatternPrefixContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_pathPatternPrefix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			_la = _input.LA(1);
			if ( !(((((_la - 219)) & ~0x3f) == 0 && ((1L << (_la - 219)) & ((1L << (ACYCLIC - 219)) | (1L << (SIMPLE - 219)) | (1L << (TRAIL - 219)) | (1L << (WALK - 219)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathPatternExpressionContext extends ParserRuleContext {
		public PathTermContext pathTerm() {
			return getRuleContext(PathTermContext.class,0);
		}
		public PathPatternUnionContext pathPatternUnion() {
			return getRuleContext(PathPatternUnionContext.class,0);
		}
		public PathPatternExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathPatternExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterPathPatternExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitPathPatternExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitPathPatternExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathPatternExpressionContext pathPatternExpression() throws RecognitionException {
		PathPatternExpressionContext _localctx = new PathPatternExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_pathPatternExpression);
		try {
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				pathTerm();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				pathPatternUnion();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathPatternUnionContext extends ParserRuleContext {
		public List<PathTermContext> pathTerm() {
			return getRuleContexts(PathTermContext.class);
		}
		public PathTermContext pathTerm(int i) {
			return getRuleContext(PathTermContext.class,i);
		}
		public List<TerminalNode> VERTICAL_BAR() { return getTokens(GqlParser.VERTICAL_BAR); }
		public TerminalNode VERTICAL_BAR(int i) {
			return getToken(GqlParser.VERTICAL_BAR, i);
		}
		public PathPatternUnionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathPatternUnion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterPathPatternUnion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitPathPatternUnion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitPathPatternUnion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathPatternUnionContext pathPatternUnion() throws RecognitionException {
		PathPatternUnionContext _localctx = new PathPatternUnionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_pathPatternUnion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			pathTerm();
			setState(182); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(180);
				match(VERTICAL_BAR);
				setState(181);
				pathTerm();
				}
				}
				setState(184); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==VERTICAL_BAR );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathTermContext extends ParserRuleContext {
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(GqlParser.LEFT_PAREN, 0); }
		public PathPatternContext pathPattern() {
			return getRuleContext(PathPatternContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(GqlParser.RIGHT_PAREN, 0); }
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public LenContext len() {
			return getRuleContext(LenContext.class,0);
		}
		public PathTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterPathTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitPathTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitPathTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathTermContext pathTerm() throws RecognitionException {
		PathTermContext _localctx = new PathTermContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pathTerm);
		int _la;
		try {
			setState(196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				path();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(187);
				match(LEFT_PAREN);
				setState(188);
				pathPattern();
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(189);
					whereClause();
					}
				}

				setState(192);
				match(RIGHT_PAREN);
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_BRACE) {
					{
					setState(193);
					len();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathContext extends ParserRuleContext {
		public NodePatternContext nodePattern() {
			return getRuleContext(NodePatternContext.class,0);
		}
		public EdgePatternContext edgePattern() {
			return getRuleContext(EdgePatternContext.class,0);
		}
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public LenContext len() {
			return getRuleContext(LenContext.class,0);
		}
		public PathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		PathContext _localctx = new PathContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_path);
		int _la;
		try {
			setState(206);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				nodePattern();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				nodePattern();
				setState(200);
				edgePattern();
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_BRACE) {
					{
					setState(201);
					len();
					}
				}

				setState(204);
				path();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NodePatternContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(GqlParser.LEFT_PAREN, 0); }
		public ElementPatternFillerContext elementPatternFiller() {
			return getRuleContext(ElementPatternFillerContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(GqlParser.RIGHT_PAREN, 0); }
		public NodePatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nodePattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterNodePattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitNodePattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitNodePattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NodePatternContext nodePattern() throws RecognitionException {
		NodePatternContext _localctx = new NodePatternContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_nodePattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(LEFT_PAREN);
			setState(209);
			elementPatternFiller();
			setState(210);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EdgePatternContext extends ParserRuleContext {
		public FullEdgePointingLeftContext fullEdgePointingLeft() {
			return getRuleContext(FullEdgePointingLeftContext.class,0);
		}
		public FullEdgeUndirectedContext fullEdgeUndirected() {
			return getRuleContext(FullEdgeUndirectedContext.class,0);
		}
		public FullEdgePointingRightContext fullEdgePointingRight() {
			return getRuleContext(FullEdgePointingRightContext.class,0);
		}
		public EdgePatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edgePattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterEdgePattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitEdgePattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitEdgePattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EdgePatternContext edgePattern() throws RecognitionException {
		EdgePatternContext _localctx = new EdgePatternContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_edgePattern);
		try {
			setState(215);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_ARROW_BRACKET:
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				fullEdgePointingLeft();
				}
				break;
			case TILDE_LEFT_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(213);
				fullEdgeUndirected();
				}
				break;
			case MINUS_LEFT_BRACKET:
				enterOuterAlt(_localctx, 3);
				{
				setState(214);
				fullEdgePointingRight();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FullEdgePointingLeftContext extends ParserRuleContext {
		public TerminalNode LEFT_ARROW_BRACKET() { return getToken(GqlParser.LEFT_ARROW_BRACKET, 0); }
		public ElementPatternFillerContext elementPatternFiller() {
			return getRuleContext(ElementPatternFillerContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET_MINUS() { return getToken(GqlParser.RIGHT_BRACKET_MINUS, 0); }
		public FullEdgePointingLeftContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fullEdgePointingLeft; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterFullEdgePointingLeft(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitFullEdgePointingLeft(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitFullEdgePointingLeft(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FullEdgePointingLeftContext fullEdgePointingLeft() throws RecognitionException {
		FullEdgePointingLeftContext _localctx = new FullEdgePointingLeftContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_fullEdgePointingLeft);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(LEFT_ARROW_BRACKET);
			setState(218);
			elementPatternFiller();
			setState(219);
			match(RIGHT_BRACKET_MINUS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FullEdgeUndirectedContext extends ParserRuleContext {
		public TerminalNode TILDE_LEFT_BRACKET() { return getToken(GqlParser.TILDE_LEFT_BRACKET, 0); }
		public ElementPatternFillerContext elementPatternFiller() {
			return getRuleContext(ElementPatternFillerContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET_TILDE() { return getToken(GqlParser.RIGHT_BRACKET_TILDE, 0); }
		public FullEdgeUndirectedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fullEdgeUndirected; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterFullEdgeUndirected(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitFullEdgeUndirected(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitFullEdgeUndirected(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FullEdgeUndirectedContext fullEdgeUndirected() throws RecognitionException {
		FullEdgeUndirectedContext _localctx = new FullEdgeUndirectedContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_fullEdgeUndirected);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(TILDE_LEFT_BRACKET);
			setState(222);
			elementPatternFiller();
			setState(223);
			match(RIGHT_BRACKET_TILDE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FullEdgePointingRightContext extends ParserRuleContext {
		public TerminalNode MINUS_LEFT_BRACKET() { return getToken(GqlParser.MINUS_LEFT_BRACKET, 0); }
		public ElementPatternFillerContext elementPatternFiller() {
			return getRuleContext(ElementPatternFillerContext.class,0);
		}
		public TerminalNode BRACKET_RIGHT_ARROW() { return getToken(GqlParser.BRACKET_RIGHT_ARROW, 0); }
		public FullEdgePointingRightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fullEdgePointingRight; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterFullEdgePointingRight(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitFullEdgePointingRight(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitFullEdgePointingRight(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FullEdgePointingRightContext fullEdgePointingRight() throws RecognitionException {
		FullEdgePointingRightContext _localctx = new FullEdgePointingRightContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_fullEdgePointingRight);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(MINUS_LEFT_BRACKET);
			setState(226);
			elementPatternFiller();
			setState(227);
			match(BRACKET_RIGHT_ARROW);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementPatternFillerContext extends ParserRuleContext {
		public ElementVariableContext elementVariable() {
			return getRuleContext(ElementVariableContext.class,0);
		}
		public IsLabelExprContext isLabelExpr() {
			return getRuleContext(IsLabelExprContext.class,0);
		}
		public List<TerminalNode> LEFT_BRACE() { return getTokens(GqlParser.LEFT_BRACE); }
		public TerminalNode LEFT_BRACE(int i) {
			return getToken(GqlParser.LEFT_BRACE, i);
		}
		public PropertyListContext propertyList() {
			return getRuleContext(PropertyListContext.class,0);
		}
		public ElementPatternFillerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementPatternFiller; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterElementPatternFiller(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitElementPatternFiller(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitElementPatternFiller(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementPatternFillerContext elementPatternFiller() throws RecognitionException {
		ElementPatternFillerContext _localctx = new ElementPatternFillerContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_elementPatternFiller);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(229);
				elementVariable();
				}
			}

			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IS || _la==COLON) {
				{
				setState(232);
				isLabelExpr();
				}
			}

			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LEFT_BRACE) {
				{
				setState(235);
				match(LEFT_BRACE);
				setState(236);
				propertyList();
				setState(237);
				match(LEFT_BRACE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyListContext extends ParserRuleContext {
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public TerminalNode COLON() { return getToken(GqlParser.COLON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(GqlParser.COMMA, 0); }
		public PropertyListContext propertyList() {
			return getRuleContext(PropertyListContext.class,0);
		}
		public PropertyListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterPropertyList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitPropertyList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitPropertyList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyListContext propertyList() throws RecognitionException {
		PropertyListContext _localctx = new PropertyListContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_propertyList);
		try {
			setState(251);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(241);
				key();
				setState(242);
				match(COLON);
				setState(243);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(245);
				key();
				setState(246);
				match(COLON);
				setState(247);
				expr(0);
				setState(248);
				match(COMMA);
				setState(249);
				propertyList();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnListContext extends ParserRuleContext {
		public ReturnItemContext returnItem() {
			return getRuleContext(ReturnItemContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(GqlParser.COMMA, 0); }
		public ReturnListContext returnList() {
			return getRuleContext(ReturnListContext.class,0);
		}
		public ReturnListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterReturnList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitReturnList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitReturnList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnListContext returnList() throws RecognitionException {
		ReturnListContext _localctx = new ReturnListContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_returnList);
		try {
			setState(258);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(253);
				returnItem();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(254);
				returnItem();
				setState(255);
				match(COMMA);
				setState(256);
				returnList();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnItemContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode AS() { return getToken(GqlParser.AS, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public ReturnItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterReturnItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitReturnItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitReturnItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnItemContext returnItem() throws RecognitionException {
		ReturnItemContext _localctx = new ReturnItemContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_returnItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			expr(0);
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(261);
				match(AS);
				setState(262);
				name();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetOperatorContext extends ParserRuleContext {
		public UnionOperatorContext unionOperator() {
			return getRuleContext(UnionOperatorContext.class,0);
		}
		public OtherSetOperatorContext otherSetOperator() {
			return getRuleContext(OtherSetOperatorContext.class,0);
		}
		public SetOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterSetOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitSetOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitSetOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetOperatorContext setOperator() throws RecognitionException {
		SetOperatorContext _localctx = new SetOperatorContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_setOperator);
		try {
			setState(267);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNION:
				enterOuterAlt(_localctx, 1);
				{
				setState(265);
				unionOperator();
				}
				break;
			case EXCEPT:
			case INTERSECT:
				enterOuterAlt(_localctx, 2);
				{
				setState(266);
				otherSetOperator();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnionOperatorContext extends ParserRuleContext {
		public TerminalNode UNION() { return getToken(GqlParser.UNION, 0); }
		public SetQuantifierContext setQuantifier() {
			return getRuleContext(SetQuantifierContext.class,0);
		}
		public TerminalNode MAX() { return getToken(GqlParser.MAX, 0); }
		public UnionOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unionOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterUnionOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitUnionOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitUnionOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnionOperatorContext unionOperator() throws RecognitionException {
		UnionOperatorContext _localctx = new UnionOperatorContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_unionOperator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(UNION);
			setState(272);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALL:
			case DISTINCT:
				{
				setState(270);
				setQuantifier();
				}
				break;
			case MAX:
				{
				setState(271);
				match(MAX);
				}
				break;
			case FROM:
			case MANDATORY:
			case MATCH:
			case OPTIONAL:
				break;
			default:
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OtherSetOperatorContext extends ParserRuleContext {
		public TerminalNode EXCEPT() { return getToken(GqlParser.EXCEPT, 0); }
		public TerminalNode INTERSECT() { return getToken(GqlParser.INTERSECT, 0); }
		public SetQuantifierContext setQuantifier() {
			return getRuleContext(SetQuantifierContext.class,0);
		}
		public OtherSetOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_otherSetOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterOtherSetOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitOtherSetOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitOtherSetOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OtherSetOperatorContext otherSetOperator() throws RecognitionException {
		OtherSetOperatorContext _localctx = new OtherSetOperatorContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_otherSetOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			_la = _input.LA(1);
			if ( !(_la==EXCEPT || _la==INTERSECT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(276);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(275);
				setQuantifier();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetQuantifierContext extends ParserRuleContext {
		public TerminalNode DISTINCT() { return getToken(GqlParser.DISTINCT, 0); }
		public TerminalNode ALL() { return getToken(GqlParser.ALL, 0); }
		public SetQuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setQuantifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterSetQuantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitSetQuantifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitSetQuantifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetQuantifierContext setQuantifier() throws RecognitionException {
		SetQuantifierContext _localctx = new SetQuantifierContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_setQuantifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			_la = _input.LA(1);
			if ( !(_la==ALL || _la==DISTINCT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LenContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(GqlParser.LEFT_BRACE, 0); }
		public QuantifierContext quantifier() {
			return getRuleContext(QuantifierContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(GqlParser.RIGHT_BRACE, 0); }
		public LenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_len; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterLen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitLen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitLen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LenContext len() throws RecognitionException {
		LenContext _localctx = new LenContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_len);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(LEFT_BRACE);
			setState(281);
			quantifier();
			setState(282);
			match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantifierContext extends ParserRuleContext {
		public List<TerminalNode> UNSIGNED_INTEGER() { return getTokens(GqlParser.UNSIGNED_INTEGER); }
		public TerminalNode UNSIGNED_INTEGER(int i) {
			return getToken(GqlParser.UNSIGNED_INTEGER, i);
		}
		public TerminalNode COMMA() { return getToken(GqlParser.COMMA, 0); }
		public QuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterQuantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitQuantifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitQuantifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantifierContext quantifier() throws RecognitionException {
		QuantifierContext _localctx = new QuantifierContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_quantifier);
		try {
			setState(288);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(284);
				match(UNSIGNED_INTEGER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
				match(UNSIGNED_INTEGER);
				setState(286);
				match(COMMA);
				setState(287);
				match(UNSIGNED_INTEGER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode NOT() { return getToken(GqlParser.NOT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ComparatorContext comparator() {
			return getRuleContext(ComparatorContext.class,0);
		}
		public CompOpContext compOp() {
			return getRuleContext(CompOpContext.class,0);
		}
		public TerminalNode PERIOD() { return getToken(GqlParser.PERIOD, 0); }
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public BooleanComparatorContext booleanComparator() {
			return getRuleContext(BooleanComparatorContext.class,0);
		}
		public TerminalNode TRUTH_VALUE() { return getToken(GqlParser.TRUTH_VALUE, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNSIGNED_INTEGER:
			case TRUTH_VALUE:
			case WORD:
				{
				setState(291);
				value();
				}
				break;
			case ID:
				{
				setState(292);
				name();
				}
				break;
			case NOT:
				{
				setState(293);
				match(NOT);
				setState(294);
				expr(3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(314);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(312);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(297);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(298);
						comparator();
						setState(299);
						expr(5);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(301);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(302);
						compOp();
						setState(303);
						expr(2);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(305);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(306);
						match(PERIOD);
						setState(307);
						key();
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(308);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(309);
						booleanComparator();
						setState(310);
						match(TRUTH_VALUE);
						}
						break;
					}
					} 
				}
				setState(316);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class IsLabelExprContext extends ParserRuleContext {
		public LabelExpressionContext labelExpression() {
			return getRuleContext(LabelExpressionContext.class,0);
		}
		public TerminalNode IS() { return getToken(GqlParser.IS, 0); }
		public TerminalNode COLON() { return getToken(GqlParser.COLON, 0); }
		public IsLabelExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_isLabelExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterIsLabelExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitIsLabelExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitIsLabelExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IsLabelExprContext isLabelExpr() throws RecognitionException {
		IsLabelExprContext _localctx = new IsLabelExprContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_isLabelExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			_la = _input.LA(1);
			if ( !(_la==IS || _la==COLON) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(318);
			labelExpression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelExpressionContext extends ParserRuleContext {
		public LabelTermContext labelTerm() {
			return getRuleContext(LabelTermContext.class,0);
		}
		public LabelExpressionContext labelExpression() {
			return getRuleContext(LabelExpressionContext.class,0);
		}
		public TerminalNode VERTICAL_BAR() { return getToken(GqlParser.VERTICAL_BAR, 0); }
		public LabelExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterLabelExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitLabelExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitLabelExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelExpressionContext labelExpression() throws RecognitionException {
		return labelExpression(0);
	}

	private LabelExpressionContext labelExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LabelExpressionContext _localctx = new LabelExpressionContext(_ctx, _parentState);
		LabelExpressionContext _prevctx = _localctx;
		int _startState = 64;
		enterRecursionRule(_localctx, 64, RULE_labelExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(321);
			labelTerm(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(328);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LabelExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_labelExpression);
					setState(323);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(324);
					match(VERTICAL_BAR);
					setState(325);
					labelTerm(0);
					}
					} 
				}
				setState(330);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LabelTermContext extends ParserRuleContext {
		public LabelFactorContext labelFactor() {
			return getRuleContext(LabelFactorContext.class,0);
		}
		public LabelTermContext labelTerm() {
			return getRuleContext(LabelTermContext.class,0);
		}
		public TerminalNode AMPERSAND() { return getToken(GqlParser.AMPERSAND, 0); }
		public LabelTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterLabelTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitLabelTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitLabelTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelTermContext labelTerm() throws RecognitionException {
		return labelTerm(0);
	}

	private LabelTermContext labelTerm(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LabelTermContext _localctx = new LabelTermContext(_ctx, _parentState);
		LabelTermContext _prevctx = _localctx;
		int _startState = 66;
		enterRecursionRule(_localctx, 66, RULE_labelTerm, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(332);
			labelFactor();
			}
			_ctx.stop = _input.LT(-1);
			setState(339);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LabelTermContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_labelTerm);
					setState(334);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(335);
					match(AMPERSAND);
					setState(336);
					labelFactor();
					}
					} 
				}
				setState(341);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LabelFactorContext extends ParserRuleContext {
		public LabelPrimaryContext labelPrimary() {
			return getRuleContext(LabelPrimaryContext.class,0);
		}
		public LabelNegationContext labelNegation() {
			return getRuleContext(LabelNegationContext.class,0);
		}
		public LabelFactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelFactor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterLabelFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitLabelFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitLabelFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelFactorContext labelFactor() throws RecognitionException {
		LabelFactorContext _localctx = new LabelFactorContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_labelFactor);
		try {
			setState(344);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PERCENT:
			case LEFT_BRACKET:
			case LEFT_PAREN:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(342);
				labelPrimary();
				}
				break;
			case EXCLAMATION_MARK:
				enterOuterAlt(_localctx, 2);
				{
				setState(343);
				labelNegation();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelNegationContext extends ParserRuleContext {
		public TerminalNode EXCLAMATION_MARK() { return getToken(GqlParser.EXCLAMATION_MARK, 0); }
		public LabelPrimaryContext labelPrimary() {
			return getRuleContext(LabelPrimaryContext.class,0);
		}
		public LabelNegationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelNegation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterLabelNegation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitLabelNegation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitLabelNegation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelNegationContext labelNegation() throws RecognitionException {
		LabelNegationContext _localctx = new LabelNegationContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_labelNegation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			match(EXCLAMATION_MARK);
			setState(347);
			labelPrimary();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelPrimaryContext extends ParserRuleContext {
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public LabelWildcardContext labelWildcard() {
			return getRuleContext(LabelWildcardContext.class,0);
		}
		public ParenthesizedLabelExpressionContext parenthesizedLabelExpression() {
			return getRuleContext(ParenthesizedLabelExpressionContext.class,0);
		}
		public LabelPrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelPrimary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterLabelPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitLabelPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitLabelPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelPrimaryContext labelPrimary() throws RecognitionException {
		LabelPrimaryContext _localctx = new LabelPrimaryContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_labelPrimary);
		try {
			setState(352);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(349);
				label();
				}
				break;
			case PERCENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(350);
				labelWildcard();
				}
				break;
			case LEFT_BRACKET:
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(351);
				parenthesizedLabelExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GqlParser.ID, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelWildcardContext extends ParserRuleContext {
		public TerminalNode PERCENT() { return getToken(GqlParser.PERCENT, 0); }
		public LabelWildcardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelWildcard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterLabelWildcard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitLabelWildcard(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitLabelWildcard(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelWildcardContext labelWildcard() throws RecognitionException {
		LabelWildcardContext _localctx = new LabelWildcardContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_labelWildcard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			match(PERCENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParenthesizedLabelExpressionContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(GqlParser.LEFT_PAREN, 0); }
		public LabelExpressionContext labelExpression() {
			return getRuleContext(LabelExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(GqlParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(GqlParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(GqlParser.RIGHT_BRACKET, 0); }
		public ParenthesizedLabelExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenthesizedLabelExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterParenthesizedLabelExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitParenthesizedLabelExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitParenthesizedLabelExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenthesizedLabelExpressionContext parenthesizedLabelExpression() throws RecognitionException {
		ParenthesizedLabelExpressionContext _localctx = new ParenthesizedLabelExpressionContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_parenthesizedLabelExpression);
		try {
			setState(366);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(358);
				match(LEFT_PAREN);
				setState(359);
				labelExpression(0);
				setState(360);
				match(RIGHT_PAREN);
				}
				break;
			case LEFT_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(362);
				match(LEFT_BRACKET);
				setState(363);
				labelExpression(0);
				setState(364);
				match(RIGHT_BRACKET);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparatorContext extends ParserRuleContext {
		public TerminalNode OR() { return getToken(GqlParser.OR, 0); }
		public TerminalNode AND() { return getToken(GqlParser.AND, 0); }
		public TerminalNode XOR() { return getToken(GqlParser.XOR, 0); }
		public ComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterComparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitComparator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitComparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparatorContext comparator() throws RecognitionException {
		ComparatorContext _localctx = new ComparatorContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_comparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR || _la==XOR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanComparatorContext extends ParserRuleContext {
		public TerminalNode IS() { return getToken(GqlParser.IS, 0); }
		public TerminalNode NOT() { return getToken(GqlParser.NOT, 0); }
		public BooleanComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanComparator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterBooleanComparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitBooleanComparator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitBooleanComparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanComparatorContext booleanComparator() throws RecognitionException {
		BooleanComparatorContext _localctx = new BooleanComparatorContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_booleanComparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			match(IS);
			setState(372);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(371);
				match(NOT);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompOpContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(GqlParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(GqlParser.NEQ, 0); }
		public TerminalNode LT() { return getToken(GqlParser.LT, 0); }
		public TerminalNode GT() { return getToken(GqlParser.GT, 0); }
		public TerminalNode LEQ() { return getToken(GqlParser.LEQ, 0); }
		public TerminalNode GEQ() { return getToken(GqlParser.GEQ, 0); }
		public CompOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterCompOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitCompOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitCompOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompOpContext compOp() throws RecognitionException {
		CompOpContext _localctx = new CompOpContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_compOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			_la = _input.LA(1);
			if ( !(((((_la - 321)) & ~0x3f) == 0 && ((1L << (_la - 321)) & ((1L << (GEQ - 321)) | (1L << (LEQ - 321)) | (1L << (NEQ - 321)) | (1L << (LT - 321)) | (1L << (GT - 321)) | (1L << (EQ - 321)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GraphNameContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public GraphNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graphName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterGraphName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitGraphName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitGraphName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GraphNameContext graphName() throws RecognitionException {
		GraphNameContext _localctx = new GraphNameContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_graphName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GqlParser.ID, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode TRUTH_VALUE() { return getToken(GqlParser.TRUTH_VALUE, 0); }
		public TerminalNode UNSIGNED_INTEGER() { return getToken(GqlParser.UNSIGNED_INTEGER, 0); }
		public TerminalNode WORD() { return getToken(GqlParser.WORD, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			_la = _input.LA(1);
			if ( !(_la==UNSIGNED_INTEGER || _la==TRUTH_VALUE || _la==WORD) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathVariableContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GqlParser.ID, 0); }
		public PathVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterPathVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitPathVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitPathVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathVariableContext pathVariable() throws RecognitionException {
		PathVariableContext _localctx = new PathVariableContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_pathVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementVariableContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GqlParser.ID, 0); }
		public ElementVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterElementVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitElementVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitElementVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementVariableContext elementVariable() throws RecognitionException {
		ElementVariableContext _localctx = new ElementVariableContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_elementVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeyContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GqlParser.ID, 0); }
		public KeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).enterKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GqlParserListener ) ((GqlParserListener)listener).exitKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyContext key() throws RecognitionException {
		KeyContext _localctx = new KeyContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_key);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(386);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 30:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 32:
			return labelExpression_sempred((LabelExpressionContext)_localctx, predIndex);
		case 33:
			return labelTerm_sempred((LabelTermContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 1);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean labelExpression_sempred(LabelExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean labelTerm_sempred(LabelTermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u0153\u0187\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\2\3\2\7"+
		"\2i\n\2\f\2\16\2l\13\2\3\2\3\2\3\3\3\3\5\3r\n\3\3\4\3\4\5\4v\n\4\3\5\3"+
		"\5\3\5\6\5{\n\5\r\5\16\5|\6\5\177\n\5\r\5\16\5\u0080\3\5\3\5\3\6\6\6\u0086"+
		"\n\6\r\6\16\6\u0087\3\6\3\6\3\7\5\7\u008d\n\7\3\7\3\7\3\7\5\7\u0092\n"+
		"\7\3\b\3\b\3\b\3\t\3\t\5\t\u0099\n\t\3\t\3\t\5\t\u009d\n\t\3\n\3\n\3\n"+
		"\3\n\3\n\5\n\u00a4\n\n\3\13\3\13\3\13\5\13\u00a9\n\13\3\13\5\13\u00ac"+
		"\n\13\3\13\3\13\3\f\3\f\3\r\3\r\5\r\u00b4\n\r\3\16\3\16\3\16\6\16\u00b9"+
		"\n\16\r\16\16\16\u00ba\3\17\3\17\3\17\3\17\5\17\u00c1\n\17\3\17\3\17\5"+
		"\17\u00c5\n\17\5\17\u00c7\n\17\3\20\3\20\3\20\3\20\5\20\u00cd\n\20\3\20"+
		"\3\20\5\20\u00d1\n\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\5\22\u00da\n"+
		"\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\5"+
		"\26\u00e9\n\26\3\26\5\26\u00ec\n\26\3\26\3\26\3\26\3\26\5\26\u00f2\n\26"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00fe\n\27\3\30"+
		"\3\30\3\30\3\30\3\30\5\30\u0105\n\30\3\31\3\31\3\31\5\31\u010a\n\31\3"+
		"\32\3\32\5\32\u010e\n\32\3\33\3\33\3\33\5\33\u0113\n\33\3\34\3\34\5\34"+
		"\u0117\n\34\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\5\37\u0123"+
		"\n\37\3 \3 \3 \3 \3 \5 \u012a\n \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3"+
		" \3 \3 \7 \u013b\n \f \16 \u013e\13 \3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\""+
		"\7\"\u0149\n\"\f\"\16\"\u014c\13\"\3#\3#\3#\3#\3#\3#\7#\u0154\n#\f#\16"+
		"#\u0157\13#\3$\3$\5$\u015b\n$\3%\3%\3%\3&\3&\3&\5&\u0163\n&\3\'\3\'\3"+
		"(\3(\3)\3)\3)\3)\3)\3)\3)\3)\5)\u0171\n)\3*\3*\3+\3+\5+\u0177\n+\3,\3"+
		",\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\62\2\5>BD\63\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRT"+
		"VXZ\\^`b\2\n\4\2\u0081\u0081\u0093\u0093\6\2\u00dd\u00dd\u0104\u0104\u010a"+
		"\u010a\u0111\u0111\4\2QQoo\4\2\16\16FF\4\2qq\u0131\u0131\5\2\17\17\u0094"+
		"\u0094\u00da\u00da\3\2\u0143\u0148\5\2\7\7\u0113\u0113\u0153\u0153\2\u0183"+
		"\2d\3\2\2\2\4q\3\2\2\2\6u\3\2\2\2\b~\3\2\2\2\n\u0085\3\2\2\2\f\u008c\3"+
		"\2\2\2\16\u0093\3\2\2\2\20\u0096\3\2\2\2\22\u00a3\3\2\2\2\24\u00a8\3\2"+
		"\2\2\26\u00af\3\2\2\2\30\u00b3\3\2\2\2\32\u00b5\3\2\2\2\34\u00c6\3\2\2"+
		"\2\36\u00d0\3\2\2\2 \u00d2\3\2\2\2\"\u00d9\3\2\2\2$\u00db\3\2\2\2&\u00df"+
		"\3\2\2\2(\u00e3\3\2\2\2*\u00e8\3\2\2\2,\u00fd\3\2\2\2.\u0104\3\2\2\2\60"+
		"\u0106\3\2\2\2\62\u010d\3\2\2\2\64\u010f\3\2\2\2\66\u0114\3\2\2\28\u0118"+
		"\3\2\2\2:\u011a\3\2\2\2<\u0122\3\2\2\2>\u0129\3\2\2\2@\u013f\3\2\2\2B"+
		"\u0142\3\2\2\2D\u014d\3\2\2\2F\u015a\3\2\2\2H\u015c\3\2\2\2J\u0162\3\2"+
		"\2\2L\u0164\3\2\2\2N\u0166\3\2\2\2P\u0170\3\2\2\2R\u0172\3\2\2\2T\u0174"+
		"\3\2\2\2V\u0178\3\2\2\2X\u017a\3\2\2\2Z\u017c\3\2\2\2\\\u017e\3\2\2\2"+
		"^\u0180\3\2\2\2`\u0182\3\2\2\2b\u0184\3\2\2\2dj\5\6\4\2ef\5\4\3\2fg\5"+
		"\6\4\2gi\3\2\2\2he\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2km\3\2\2\2lj\3"+
		"\2\2\2mn\7\2\2\3n\3\3\2\2\2or\5\62\32\2pr\7\u0097\2\2qo\3\2\2\2qp\3\2"+
		"\2\2r\5\3\2\2\2sv\5\b\5\2tv\5\n\6\2us\3\2\2\2ut\3\2\2\2v\7\3\2\2\2wx\7"+
		"^\2\2xz\5X-\2y{\5\f\7\2zy\3\2\2\2{|\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\177\3"+
		"\2\2\2~w\3\2\2\2\177\u0080\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2"+
		"\u0081\u0082\3\2\2\2\u0082\u0083\5\20\t\2\u0083\t\3\2\2\2\u0084\u0086"+
		"\5\f\7\2\u0085\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0085\3\2\2\2\u0087"+
		"\u0088\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\5\20\t\2\u008a\13\3\2\2"+
		"\2\u008b\u008d\t\2\2\2\u008c\u008b\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e"+
		"\3\2\2\2\u008e\u008f\7\u0083\2\2\u008f\u0091\5\22\n\2\u0090\u0092\5\16"+
		"\b\2\u0091\u0090\3\2\2\2\u0091\u0092\3\2\2\2\u0092\r\3\2\2\2\u0093\u0094"+
		"\7\u00d7\2\2\u0094\u0095\5> \2\u0095\17\3\2\2\2\u0096\u0098\7\u00ae\2"+
		"\2\u0097\u0099\58\35\2\u0098\u0097\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009c"+
		"\3\2\2\2\u009a\u009d\7\u012f\2\2\u009b\u009d\5.\30\2\u009c\u009a\3\2\2"+
		"\2\u009c\u009b\3\2\2\2\u009d\21\3\2\2\2\u009e\u00a4\5\24\13\2\u009f\u00a0"+
		"\5\24\13\2\u00a0\u00a1\7\u0132\2\2\u00a1\u00a2\5\22\n\2\u00a2\u00a4\3"+
		"\2\2\2\u00a3\u009e\3\2\2\2\u00a3\u009f\3\2\2\2\u00a4\23\3\2\2\2\u00a5"+
		"\u00a6\5^\60\2\u00a6\u00a7\7\u0148\2\2\u00a7\u00a9\3\2\2\2\u00a8\u00a5"+
		"\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00ac\5\26\f\2"+
		"\u00ab\u00aa\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae"+
		"\5\30\r\2\u00ae\25\3\2\2\2\u00af\u00b0\t\3\2\2\u00b0\27\3\2\2\2\u00b1"+
		"\u00b4\5\34\17\2\u00b2\u00b4\5\32\16\2\u00b3\u00b1\3\2\2\2\u00b3\u00b2"+
		"\3\2\2\2\u00b4\31\3\2\2\2\u00b5\u00b8\5\34\17\2\u00b6\u00b7\7\u0140\2"+
		"\2\u00b7\u00b9\5\34\17\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba"+
		"\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\33\3\2\2\2\u00bc\u00c7\5\36\20"+
		"\2\u00bd\u00be\7\u014f\2\2\u00be\u00c0\5\24\13\2\u00bf\u00c1\5\16\b\2"+
		"\u00c0\u00bf\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c4"+
		"\7\u0150\2\2\u00c3\u00c5\5:\36\2\u00c4\u00c3\3\2\2\2\u00c4\u00c5\3\2\2"+
		"\2\u00c5\u00c7\3\2\2\2\u00c6\u00bc\3\2\2\2\u00c6\u00bd\3\2\2\2\u00c7\35"+
		"\3\2\2\2\u00c8\u00d1\5 \21\2\u00c9\u00ca\5 \21\2\u00ca\u00cc\5\"\22\2"+
		"\u00cb\u00cd\5:\36\2\u00cc\u00cb\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce"+
		"\3\2\2\2\u00ce\u00cf\5\36\20\2\u00cf\u00d1\3\2\2\2\u00d0\u00c8\3\2\2\2"+
		"\u00d0\u00c9\3\2\2\2\u00d1\37\3\2\2\2\u00d2\u00d3\7\u014f\2\2\u00d3\u00d4"+
		"\5*\26\2\u00d4\u00d5\7\u0150\2\2\u00d5!\3\2\2\2\u00d6\u00da\5$\23\2\u00d7"+
		"\u00da\5&\24\2\u00d8\u00da\5(\25\2\u00d9\u00d6\3\2\2\2\u00d9\u00d7\3\2"+
		"\2\2\u00d9\u00d8\3\2\2\2\u00da#\3\2\2\2\u00db\u00dc\7\u0117\2\2\u00dc"+
		"\u00dd\5*\26\2\u00dd\u00de\7\u011e\2\2\u00de%\3\2\2\2\u00df\u00e0\7\u011f"+
		"\2\2\u00e0\u00e1\5*\26\2\u00e1\u00e2\7\u0120\2\2\u00e2\'\3\2\2\2\u00e3"+
		"\u00e4\7\u011d\2\2\u00e4\u00e5\5*\26\2\u00e5\u00e6\7\u0116\2\2\u00e6)"+
		"\3\2\2\2\u00e7\u00e9\5`\61\2\u00e8\u00e7\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9"+
		"\u00eb\3\2\2\2\u00ea\u00ec\5@!\2\u00eb\u00ea\3\2\2\2\u00eb\u00ec\3\2\2"+
		"\2\u00ec\u00f1\3\2\2\2\u00ed\u00ee\7\u0149\2\2\u00ee\u00ef\5,\27\2\u00ef"+
		"\u00f0\7\u0149\2\2\u00f0\u00f2\3\2\2\2\u00f1\u00ed\3\2\2\2\u00f1\u00f2"+
		"\3\2\2\2\u00f2+\3\2\2\2\u00f3\u00f4\5b\62\2\u00f4\u00f5\7\u0131\2\2\u00f5"+
		"\u00f6\5> \2\u00f6\u00fe\3\2\2\2\u00f7\u00f8\5b\62\2\u00f8\u00f9\7\u0131"+
		"\2\2\u00f9\u00fa\5> \2\u00fa\u00fb\7\u0132\2\2\u00fb\u00fc\5,\27\2\u00fc"+
		"\u00fe\3\2\2\2\u00fd\u00f3\3\2\2\2\u00fd\u00f7\3\2\2\2\u00fe-\3\2\2\2"+
		"\u00ff\u0105\5\60\31\2\u0100\u0101\5\60\31\2\u0101\u0102\7\u0132\2\2\u0102"+
		"\u0103\5.\30\2\u0103\u0105\3\2\2\2\u0104\u00ff\3\2\2\2\u0104\u0100\3\2"+
		"\2\2\u0105/\3\2\2\2\u0106\u0109\5> \2\u0107\u0108\7\22\2\2\u0108\u010a"+
		"\5Z.\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a\61\3\2\2\2\u010b"+
		"\u010e\5\64\33\2\u010c\u010e\5\66\34\2\u010d\u010b\3\2\2\2\u010d\u010c"+
		"\3\2\2\2\u010e\63\3\2\2\2\u010f\u0112\7\u00ca\2\2\u0110\u0113\58\35\2"+
		"\u0111\u0113\7\u0085\2\2\u0112\u0110\3\2\2\2\u0112\u0111\3\2\2\2\u0112"+
		"\u0113\3\2\2\2\u0113\65\3\2\2\2\u0114\u0116\t\4\2\2\u0115\u0117\58\35"+
		"\2\u0116\u0115\3\2\2\2\u0116\u0117\3\2\2\2\u0117\67\3\2\2\2\u0118\u0119"+
		"\t\5\2\2\u01199\3\2\2\2\u011a\u011b\7\u0149\2\2\u011b\u011c\5<\37\2\u011c"+
		"\u011d\7\u014a\2\2\u011d;\3\2\2\2\u011e\u0123\7\7\2\2\u011f\u0120\7\7"+
		"\2\2\u0120\u0121\7\u0132\2\2\u0121\u0123\7\7\2\2\u0122\u011e\3\2\2\2\u0122"+
		"\u011f\3\2\2\2\u0123=\3\2\2\2\u0124\u0125\b \1\2\u0125\u012a\5\\/\2\u0126"+
		"\u012a\5Z.\2\u0127\u0128\7\u008c\2\2\u0128\u012a\5> \5\u0129\u0124\3\2"+
		"\2\2\u0129\u0126\3\2\2\2\u0129\u0127\3\2\2\2\u012a\u013c\3\2\2\2\u012b"+
		"\u012c\f\6\2\2\u012c\u012d\5R*\2\u012d\u012e\5> \7\u012e\u013b\3\2\2\2"+
		"\u012f\u0130\f\3\2\2\u0130\u0131\5V,\2\u0131\u0132\5> \4\u0132\u013b\3"+
		"\2\2\2\u0133\u0134\f\7\2\2\u0134\u0135\7\u0139\2\2\u0135\u013b\5b\62\2"+
		"\u0136\u0137\f\4\2\2\u0137\u0138\5T+\2\u0138\u0139\7\u0113\2\2\u0139\u013b"+
		"\3\2\2\2\u013a\u012b\3\2\2\2\u013a\u012f\3\2\2\2\u013a\u0133\3\2\2\2\u013a"+
		"\u0136\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2"+
		"\2\2\u013d?\3\2\2\2\u013e\u013c\3\2\2\2\u013f\u0140\t\6\2\2\u0140\u0141"+
		"\5B\"\2\u0141A\3\2\2\2\u0142\u0143\b\"\1\2\u0143\u0144\5D#\2\u0144\u014a"+
		"\3\2\2\2\u0145\u0146\f\3\2\2\u0146\u0147\7\u0140\2\2\u0147\u0149\5D#\2"+
		"\u0148\u0145\3\2\2\2\u0149\u014c\3\2\2\2\u014a\u0148\3\2\2\2\u014a\u014b"+
		"\3\2\2\2\u014bC\3\2\2\2\u014c\u014a\3\2\2\2\u014d\u014e\b#\1\2\u014e\u014f"+
		"\5F$\2\u014f\u0155\3\2\2\2\u0150\u0151\f\3\2\2\u0151\u0152\7\u012e\2\2"+
		"\u0152\u0154\5F$\2\u0153\u0150\3\2\2\2\u0154\u0157\3\2\2\2\u0155\u0153"+
		"\3\2\2\2\u0155\u0156\3\2\2\2\u0156E\3\2\2\2\u0157\u0155\3\2\2\2\u0158"+
		"\u015b\5J&\2\u0159\u015b\5H%\2\u015a\u0158\3\2\2\2\u015a\u0159\3\2\2\2"+
		"\u015bG\3\2\2\2\u015c\u015d\7\u0135\2\2\u015d\u015e\5J&\2\u015eI\3\2\2"+
		"\2\u015f\u0163\5L\'\2\u0160\u0163\5N(\2\u0161\u0163\5P)\2\u0162\u015f"+
		"\3\2\2\2\u0162\u0160\3\2\2\2\u0162\u0161\3\2\2\2\u0163K\3\2\2\2\u0164"+
		"\u0165\7\u0152\2\2\u0165M\3\2\2\2\u0166\u0167\7\u0138\2\2\u0167O\3\2\2"+
		"\2\u0168\u0169\7\u014f\2\2\u0169\u016a\5B\"\2\u016a\u016b\7\u0150\2\2"+
		"\u016b\u0171\3\2\2\2\u016c\u016d\7\u014b\2\2\u016d\u016e\5B\"\2\u016e"+
		"\u016f\7\u014c\2\2\u016f\u0171\3\2\2\2\u0170\u0168\3\2\2\2\u0170\u016c"+
		"\3\2\2\2\u0171Q\3\2\2\2\u0172\u0173\t\7\2\2\u0173S\3\2\2\2\u0174\u0176"+
		"\7q\2\2\u0175\u0177\7\u008c\2\2\u0176\u0175\3\2\2\2\u0176\u0177\3\2\2"+
		"\2\u0177U\3\2\2\2\u0178\u0179\t\b\2\2\u0179W\3\2\2\2\u017a\u017b\5Z.\2"+
		"\u017bY\3\2\2\2\u017c\u017d\7\u0152\2\2\u017d[\3\2\2\2\u017e\u017f\t\t"+
		"\2\2\u017f]\3\2\2\2\u0180\u0181\7\u0152\2\2\u0181_\3\2\2\2\u0182\u0183"+
		"\7\u0152\2\2\u0183a\3\2\2\2\u0184\u0185\7\u0152\2\2\u0185c\3\2\2\2*jq"+
		"u|\u0080\u0087\u008c\u0091\u0098\u009c\u00a3\u00a8\u00ab\u00b3\u00ba\u00c0"+
		"\u00c4\u00c6\u00cc\u00d0\u00d9\u00e8\u00eb\u00f1\u00fd\u0104\u0109\u010d"+
		"\u0112\u0116\u0122\u0129\u013a\u013c\u014a\u0155\u015a\u0162\u0170\u0176";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}