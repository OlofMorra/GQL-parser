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
		ON=1, COMMENT=2, LINE_COMMENT=3, WS=4, SIGNED_INTEGER=5, UNSIGNED_INTEGER=6, 
		SIGNED_FIXED_POINT=7, SIGNED_FLOAT=8, KEYWORD=9, ABS=10, ACOS=11, ADD=12, 
		AGGREGATE=13, ALIAS=14, ALL=15, AND=16, ANY=17, ARRAY=18, AS=19, ASC=20, 
		ASCENDING=21, ASIN=22, AT=23, ATAN=24, AVG=25, BINARY=26, BOOLEAN=27, 
		BOTH=28, BY=29, CALL=30, CASE=31, CATALOG=32, CEIL=33, CEILING=34, CHARACHTER=35, 
		CHARACTER_LENGTH=36, CLEAR=37, CLONE=38, CLOSE=39, COLLECT=40, COMMIT=41, 
		CONSTRAINT=42, CONSTANT=43, CONSTRCUT=44, COPY=45, COS=46, COSH=47, COST=48, 
		COT=49, COUNT=50, CURRENT_DATE=51, CURRENT_GRAPH=52, CURRENT_PROPERTY_GRAPH=53, 
		CURRENT_ROLE=54, CURRENT_SCHEMA=55, CURRENT_TIME=56, CURRENT_TIMESTAMP=57, 
		CURRENT_USER=58, CREATE=59, DATE=60, DATETIME=61, DECIMAL=62, DEFAULT=63, 
		DEGREES=64, DELETE=65, DETACH=66, DESC=67, DESCENDING=68, DIRECTORIES=69, 
		DIRECTORY=70, DISTINCT=71, DO=72, DROP=73, DURATION=74, ELSE=75, END=76, 
		ENDS=77, EMPTY_BINDING_TABLE=78, EMPTY_GRAPH=79, EMPTY_PROPERTY_GRAPH=80, 
		EMPTY_TABLE=81, EXCEPT=82, EXISTS=83, EXISTING=84, EXP=85, EXPLAIN=86, 
		FALSE=87, FILTER=88, FLOAT=89, FLOAT32=90, FLOAT64=91, FLOAT128=92, FLOOR=93, 
		FOR=94, FROM=95, FUNCTOPM=96, FUNCTIONS=97, GQLSTATUS=98, GROUP=99, HAVING=100, 
		HOME_GRAPH=101, HOME_PROPERTY_GRAPH=102, HOME_SCHEMA=103, IN=104, INSERT=105, 
		INTEGER=106, INTEGER8=107, INTEGER16=108, INTEGER32=109, INTEGER64=110, 
		INTEGER128=111, INTERSECT=112, IF=113, IS=114, KEEP=115, LEADING=116, 
		LEFT=117, LENGTH=118, LET=119, LIKE=120, LIMIT=121, LIST=122, LN=123, 
		LOCALDATETIME=124, LOCALTIME=125, LOCALTIMESTAMP=126, LOG=127, LOG10=128, 
		LOWER=129, MANDATORY=130, MAP=131, MATCH=132, MERGE=133, MAX=134, MIN=135, 
		MOD=136, MULTI=137, MULTIPLE=138, MULTISET=139, NEW=140, NOT=141, NORMALIZE=142, 
		NOTHING=143, NULL=144, OCTET_LENGTH=145, OF=146, OFFSET=147, OPTIONAL=148, 
		OR=149, ORDER=150, ORDERED=151, OTHERWISE=152, PARAMETER=153, PATH=154, 
		PATHS=155, PARTITION=156, POWER=157, PROCEDURE=158, PROCEDURES=159, PRODUCT=160, 
		PROFILE=161, PROJECT=162, QUERIES=163, QUERY=164, RADIANS=165, RCORD=166, 
		RECORDS=167, REFERENCE=168, REMOVE=169, RENAME=170, REPLACE=171, REQUIRE=172, 
		RESET=173, RESULT=174, RETURN=175, RIGHT=176, ROLLBACK=177, SCALAR=178, 
		SCHEMA=179, SCHEMAS=180, SCHEMATA=181, SELECT=182, SESSION=183, SET=184, 
		SIN=185, SINGLE=186, SINH=187, SQRT=188, START=189, STARTS=190, STRING=191, 
		SUBSTRING=192, SUM=193, TAN=194, TANH=195, THEN=196, TIME=197, TIMESTAMP=198, 
		TRAILING=199, TRIM=200, TRUE=201, TRUNCATE=202, UNION=203, UNIT=204, UNIT_BINDING_TABLE=205, 
		UNIT_TABLE=206, UNIQUE=207, UNNEST=208, UNKNOWN=209, UNWIND=210, UPPER=211, 
		USE=212, VALUE=213, VALUES=214, WHEN=215, WHERE=216, WITH=217, WORKING_GRAPH=218, 
		XOR=219, YIELD=220, ZERO=221, ACYCLIC=222, BINDING=223, CLASS_ORIGIN=224, 
		COMMAND_FUNCTION=225, COMMAND_FUNCTION_CODE=226, CONDITION_NUMBER=227, 
		CONNECTING=228, DESTINATION=229, DIRECTED=230, EDGE=231, EDGES=232, FINAL=233, 
		GRAPH=234, GRAPHS=235, GROUPS=236, INDEX=237, LABEL=238, LABELS=239, MESSAGE_TEXT=240, 
		MUTABLE=241, NFC=242, NFD=243, NFKC=244, NFKD=245, NODE=246, NODES=247, 
		NORMALIZED=248, NUMBER=249, ONLY=250, ORDINALITY=251, PATTERN=252, PATTERNS=253, 
		PROPERTY=254, PROPERTIES=255, READ=256, RELATIONSHIP=257, RELATIONSHIPS=258, 
		RETURNED_GQLSTATUS=259, SHORTEST=260, SIMPLE=261, SUBCLASS_ORIGIN=262, 
		TABLE=263, TABLES=264, TIES=265, TO=266, TRAIL=267, TRANSACTION=268, TYPE=269, 
		TYPES=270, UNDIRECTED=271, VERTEX=272, VERTICES=273, WALK=274, WRITE=275, 
		TRUTH_VALUE=276, LEFT_ARROW=277, RIGHT_ARROW=278, BRACKET_RIGHT_ARROW=279, 
		LEFT_ARROW_BRACKET=280, DOUBLE_COLON=281, DOUBLE_MINUS_SIGN=282, DOUBLE_PERIOD=283, 
		DOUBLE_SOLIDUS=284, DOUBLED_GRAVE_ACCENT=285, MINUS_LEFT_BRACKET=286, 
		RIGHT_BRACKET_MINUS=287, TILDE_LEFT_BRACKET=288, RIGHT_BRACKET_TILDE=289, 
		BRACKET_TILDE_RIGHT_ARROW=290, LEFT_ARROW_TILDE_BRACKET=291, TILDE_RIGHT_ARROW=292, 
		LEFT_ARROW_TILDE=293, LEFT_MINUS_RIGHT=294, MINUS_SLASH=295, SLASH_MINUS=296, 
		SLASH_MINUS_RIGHT=297, LEFT_MINUS_SLASH=298, TILDE_SLASH=299, SLASH_TILDE=300, 
		SLASH_TILDE_RIGHT=301, LEFT_TILDE_SLASH=302, AMPERSAND=303, ASTERISK=304, 
		CIRCUMFLEX=305, COLON=306, COMMA=307, DOLLAR_SIGN=308, DOUBLE_QUOTE=309, 
		EXCLAMATION_MARK=310, GRAVE_ACCENT=311, MINUS_SIGN=312, PERCENT=313, PERIOD=314, 
		PLUS_SIGN=315, QUESTION_MARK=316, QUOTE=317, SEMICOLON=318, SOLIDUS=319, 
		TILDE=320, VERTICAL_BAR=321, CONCATENATION=322, MULTISET_ALTERNATION=323, 
		GEQ=324, LEQ=325, NEQ=326, LT=327, GT=328, EQ=329, LEFT_BRACE=330, RIGHT_BRACE=331, 
		LEFT_BRACKET=332, RIGHT_BRACKET=333, LEFT_ANGLE_BRACKET=334, RIGHT_ANGLE_BRACKET=335, 
		LEFT_PAREN=336, RIGHT_PAREN=337, NEWLINE=338, ID=339, WORD=340;
	public static final int
		RULE_query = 0, RULE_queryConjunction = 1, RULE_queryExpression = 2, RULE_focusedQueryExpression = 3, 
		RULE_ambientQueryExpression = 4, RULE_matchClause = 5, RULE_whereClause = 6, 
		RULE_returnStatement = 7, RULE_pathPatternList = 8, RULE_pathPattern = 9, 
		RULE_pathPatternPrefix = 10, RULE_pathPatternExpression = 11, RULE_pathTerm = 12, 
		RULE_path = 13, RULE_nodePattern = 14, RULE_edgePattern = 15, RULE_fullEdgePointingLeft = 16, 
		RULE_fullEdgeUndirected = 17, RULE_fullEdgePointingRight = 18, RULE_elementPatternFiller = 19, 
		RULE_propertyList = 20, RULE_returnList = 21, RULE_returnItem = 22, RULE_setOperator = 23, 
		RULE_unionOperator = 24, RULE_otherSetOperator = 25, RULE_setQuantifier = 26, 
		RULE_len = 27, RULE_quantifier = 28, RULE_expr = 29, RULE_isLabelExpr = 30, 
		RULE_labelExpression = 31, RULE_labelTerm = 32, RULE_labelFactor = 33, 
		RULE_labelNegation = 34, RULE_labelPrimary = 35, RULE_label = 36, RULE_labelWildcard = 37, 
		RULE_parenthesizedLabelExpression = 38, RULE_comparator = 39, RULE_booleanComparator = 40, 
		RULE_compOp = 41, RULE_graphName = 42, RULE_name = 43, RULE_value = 44, 
		RULE_pathVariable = 45, RULE_elementVariable = 46, RULE_key = 47;
	private static String[] makeRuleNames() {
		return new String[] {
			"query", "queryConjunction", "queryExpression", "focusedQueryExpression", 
			"ambientQueryExpression", "matchClause", "whereClause", "returnStatement", 
			"pathPatternList", "pathPattern", "pathPatternPrefix", "pathPatternExpression", 
			"pathTerm", "path", "nodePattern", "edgePattern", "fullEdgePointingLeft", 
			"fullEdgeUndirected", "fullEdgePointingRight", "elementPatternFiller", 
			"propertyList", "returnList", "returnItem", "setOperator", "unionOperator", 
			"otherSetOperator", "setQuantifier", "len", "quantifier", "expr", "isLabelExpr", 
			"labelExpression", "labelTerm", "labelFactor", "labelNegation", "labelPrimary", 
			"label", "labelWildcard", "parenthesizedLabelExpression", "comparator", 
			"booleanComparator", "compOp", "graphName", "name", "value", "pathVariable", 
			"elementVariable", "key"
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
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "'<-'", "'->'", "']->'", "'<-['", "'::'", "'--'", "'..'", "'//'", 
			"'``'", "'-['", "']-'", "'~['", "']~'", "']~>'", "'<~['", "'~>'", "'<~'", 
			"'<->'", "'-/'", "'/-'", "'/->'", "'<-/'", "'~/'", "'/~'", "'/~>'", "'<~/'", 
			"'&'", "'*'", "'^'", "':'", "','", "'$'", "'\"'", "'!'", "'`'", "'-'", 
			"'%'", "'.'", "'+'", "'?'", "'''", "';'", "'/'", "'~'", "'|'", "'||'", 
			"'|+|'", "'>='", "'<='", "'<>'", null, null, "'='", "'{'", "'}'", "'['", 
			"']'", "'<'", "'>'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ON", "COMMENT", "LINE_COMMENT", "WS", "SIGNED_INTEGER", "UNSIGNED_INTEGER", 
			"SIGNED_FIXED_POINT", "SIGNED_FLOAT", "KEYWORD", "ABS", "ACOS", "ADD", 
			"AGGREGATE", "ALIAS", "ALL", "AND", "ANY", "ARRAY", "AS", "ASC", "ASCENDING", 
			"ASIN", "AT", "ATAN", "AVG", "BINARY", "BOOLEAN", "BOTH", "BY", "CALL", 
			"CASE", "CATALOG", "CEIL", "CEILING", "CHARACHTER", "CHARACTER_LENGTH", 
			"CLEAR", "CLONE", "CLOSE", "COLLECT", "COMMIT", "CONSTRAINT", "CONSTANT", 
			"CONSTRCUT", "COPY", "COS", "COSH", "COST", "COT", "COUNT", "CURRENT_DATE", 
			"CURRENT_GRAPH", "CURRENT_PROPERTY_GRAPH", "CURRENT_ROLE", "CURRENT_SCHEMA", 
			"CURRENT_TIME", "CURRENT_TIMESTAMP", "CURRENT_USER", "CREATE", "DATE", 
			"DATETIME", "DECIMAL", "DEFAULT", "DEGREES", "DELETE", "DETACH", "DESC", 
			"DESCENDING", "DIRECTORIES", "DIRECTORY", "DISTINCT", "DO", "DROP", "DURATION", 
			"ELSE", "END", "ENDS", "EMPTY_BINDING_TABLE", "EMPTY_GRAPH", "EMPTY_PROPERTY_GRAPH", 
			"EMPTY_TABLE", "EXCEPT", "EXISTS", "EXISTING", "EXP", "EXPLAIN", "FALSE", 
			"FILTER", "FLOAT", "FLOAT32", "FLOAT64", "FLOAT128", "FLOOR", "FOR", 
			"FROM", "FUNCTOPM", "FUNCTIONS", "GQLSTATUS", "GROUP", "HAVING", "HOME_GRAPH", 
			"HOME_PROPERTY_GRAPH", "HOME_SCHEMA", "IN", "INSERT", "INTEGER", "INTEGER8", 
			"INTEGER16", "INTEGER32", "INTEGER64", "INTEGER128", "INTERSECT", "IF", 
			"IS", "KEEP", "LEADING", "LEFT", "LENGTH", "LET", "LIKE", "LIMIT", "LIST", 
			"LN", "LOCALDATETIME", "LOCALTIME", "LOCALTIMESTAMP", "LOG", "LOG10", 
			"LOWER", "MANDATORY", "MAP", "MATCH", "MERGE", "MAX", "MIN", "MOD", "MULTI", 
			"MULTIPLE", "MULTISET", "NEW", "NOT", "NORMALIZE", "NOTHING", "NULL", 
			"OCTET_LENGTH", "OF", "OFFSET", "OPTIONAL", "OR", "ORDER", "ORDERED", 
			"OTHERWISE", "PARAMETER", "PATH", "PATHS", "PARTITION", "POWER", "PROCEDURE", 
			"PROCEDURES", "PRODUCT", "PROFILE", "PROJECT", "QUERIES", "QUERY", "RADIANS", 
			"RCORD", "RECORDS", "REFERENCE", "REMOVE", "RENAME", "REPLACE", "REQUIRE", 
			"RESET", "RESULT", "RETURN", "RIGHT", "ROLLBACK", "SCALAR", "SCHEMA", 
			"SCHEMAS", "SCHEMATA", "SELECT", "SESSION", "SET", "SIN", "SINGLE", "SINH", 
			"SQRT", "START", "STARTS", "STRING", "SUBSTRING", "SUM", "TAN", "TANH", 
			"THEN", "TIME", "TIMESTAMP", "TRAILING", "TRIM", "TRUE", "TRUNCATE", 
			"UNION", "UNIT", "UNIT_BINDING_TABLE", "UNIT_TABLE", "UNIQUE", "UNNEST", 
			"UNKNOWN", "UNWIND", "UPPER", "USE", "VALUE", "VALUES", "WHEN", "WHERE", 
			"WITH", "WORKING_GRAPH", "XOR", "YIELD", "ZERO", "ACYCLIC", "BINDING", 
			"CLASS_ORIGIN", "COMMAND_FUNCTION", "COMMAND_FUNCTION_CODE", "CONDITION_NUMBER", 
			"CONNECTING", "DESTINATION", "DIRECTED", "EDGE", "EDGES", "FINAL", "GRAPH", 
			"GRAPHS", "GROUPS", "INDEX", "LABEL", "LABELS", "MESSAGE_TEXT", "MUTABLE", 
			"NFC", "NFD", "NFKC", "NFKD", "NODE", "NODES", "NORMALIZED", "NUMBER", 
			"ONLY", "ORDINALITY", "PATTERN", "PATTERNS", "PROPERTY", "PROPERTIES", 
			"READ", "RELATIONSHIP", "RELATIONSHIPS", "RETURNED_GQLSTATUS", "SHORTEST", 
			"SIMPLE", "SUBCLASS_ORIGIN", "TABLE", "TABLES", "TIES", "TO", "TRAIL", 
			"TRANSACTION", "TYPE", "TYPES", "UNDIRECTED", "VERTEX", "VERTICES", "WALK", 
			"WRITE", "TRUTH_VALUE", "LEFT_ARROW", "RIGHT_ARROW", "BRACKET_RIGHT_ARROW", 
			"LEFT_ARROW_BRACKET", "DOUBLE_COLON", "DOUBLE_MINUS_SIGN", "DOUBLE_PERIOD", 
			"DOUBLE_SOLIDUS", "DOUBLED_GRAVE_ACCENT", "MINUS_LEFT_BRACKET", "RIGHT_BRACKET_MINUS", 
			"TILDE_LEFT_BRACKET", "RIGHT_BRACKET_TILDE", "BRACKET_TILDE_RIGHT_ARROW", 
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
			setState(96);
			queryExpression();
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXCEPT || _la==INTERSECT || _la==OTHERWISE || _la==UNION) {
				{
				{
				setState(97);
				queryConjunction();
				setState(98);
				queryExpression();
				}
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(105);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitQueryConjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryConjunctionContext queryConjunction() throws RecognitionException {
		QueryConjunctionContext _localctx = new QueryConjunctionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_queryConjunction);
		try {
			setState(109);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXCEPT:
			case INTERSECT:
			case UNION:
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				setOperator();
				}
				break;
			case OTHERWISE:
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitQueryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryExpressionContext queryExpression() throws RecognitionException {
		QueryExpressionContext _localctx = new QueryExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_queryExpression);
		try {
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FROM:
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				focusedQueryExpression();
				}
				break;
			case MANDATORY:
			case MATCH:
			case OPTIONAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
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
			setState(122); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(115);
				match(FROM);
				setState(116);
				graphName();
				setState(118); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(117);
					matchClause();
					}
					}
					setState(120); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (MANDATORY - 130)) | (1L << (MATCH - 130)) | (1L << (OPTIONAL - 130)))) != 0) );
				}
				}
				setState(124); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==FROM );
			setState(126);
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
			setState(129); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(128);
				matchClause();
				}
				}
				setState(131); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & ((1L << (MANDATORY - 130)) | (1L << (MATCH - 130)) | (1L << (OPTIONAL - 130)))) != 0) );
			setState(133);
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
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MANDATORY || _la==OPTIONAL) {
				{
				setState(135);
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

			setState(138);
			match(MATCH);
			setState(139);
			pathPatternList();
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(140);
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
			setState(143);
			match(WHERE);
			setState(144);
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
			setState(146);
			match(RETURN);
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(147);
				setQuantifier();
				}
			}

			setState(152);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASTERISK:
				{
				setState(150);
				match(ASTERISK);
				}
				break;
			case SIGNED_INTEGER:
			case SIGNED_FIXED_POINT:
			case SIGNED_FLOAT:
			case NOT:
			case TRUTH_VALUE:
			case ID:
			case WORD:
				{
				setState(151);
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
		public List<PathPatternContext> pathPattern() {
			return getRuleContexts(PathPatternContext.class);
		}
		public PathPatternContext pathPattern(int i) {
			return getRuleContext(PathPatternContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GqlParser.COMMA, i);
		}
		public PathPatternListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathPatternList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitPathPatternList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathPatternListContext pathPatternList() throws RecognitionException {
		PathPatternListContext _localctx = new PathPatternListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_pathPatternList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			pathPattern();
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(155);
				match(COMMA);
				setState(156);
				pathPattern();
				}
				}
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(162);
				pathVariable();
				setState(163);
				match(EQ);
				}
			}

			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 222)) & ~0x3f) == 0 && ((1L << (_la - 222)) & ((1L << (ACYCLIC - 222)) | (1L << (SIMPLE - 222)) | (1L << (TRAIL - 222)) | (1L << (WALK - 222)))) != 0)) {
				{
				setState(167);
				pathPatternPrefix();
				}
			}

			setState(170);
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
			setState(172);
			_la = _input.LA(1);
			if ( !(((((_la - 222)) & ~0x3f) == 0 && ((1L << (_la - 222)) & ((1L << (ACYCLIC - 222)) | (1L << (SIMPLE - 222)) | (1L << (TRAIL - 222)) | (1L << (WALK - 222)))) != 0)) ) {
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
		public PathPatternExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathPatternExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitPathPatternExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathPatternExpressionContext pathPatternExpression() throws RecognitionException {
		PathPatternExpressionContext _localctx = new PathPatternExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_pathPatternExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			pathTerm();
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VERTICAL_BAR) {
				{
				{
				setState(175);
				match(VERTICAL_BAR);
				setState(176);
				pathTerm();
				}
				}
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitPathTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathTermContext pathTerm() throws RecognitionException {
		PathTermContext _localctx = new PathTermContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_pathTerm);
		int _la;
		try {
			setState(192);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				path();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				match(LEFT_PAREN);
				setState(184);
				pathPattern();
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(185);
					whereClause();
					}
				}

				setState(188);
				match(RIGHT_PAREN);
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_BRACE) {
					{
					setState(189);
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
		public List<NodePatternContext> nodePattern() {
			return getRuleContexts(NodePatternContext.class);
		}
		public NodePatternContext nodePattern(int i) {
			return getRuleContext(NodePatternContext.class,i);
		}
		public List<EdgePatternContext> edgePattern() {
			return getRuleContexts(EdgePatternContext.class);
		}
		public EdgePatternContext edgePattern(int i) {
			return getRuleContext(EdgePatternContext.class,i);
		}
		public List<LenContext> len() {
			return getRuleContexts(LenContext.class);
		}
		public LenContext len(int i) {
			return getRuleContext(LenContext.class,i);
		}
		public PathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		PathContext _localctx = new PathContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_path);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			nodePattern();
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 280)) & ~0x3f) == 0 && ((1L << (_la - 280)) & ((1L << (LEFT_ARROW_BRACKET - 280)) | (1L << (MINUS_LEFT_BRACKET - 280)) | (1L << (TILDE_LEFT_BRACKET - 280)))) != 0)) {
				{
				{
				setState(195);
				edgePattern();
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_BRACE) {
					{
					setState(196);
					len();
					}
				}

				setState(199);
				nodePattern();
				}
				}
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitNodePattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NodePatternContext nodePattern() throws RecognitionException {
		NodePatternContext _localctx = new NodePatternContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_nodePattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(LEFT_PAREN);
			setState(207);
			elementPatternFiller();
			setState(208);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitEdgePattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EdgePatternContext edgePattern() throws RecognitionException {
		EdgePatternContext _localctx = new EdgePatternContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_edgePattern);
		try {
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_ARROW_BRACKET:
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				fullEdgePointingLeft();
				}
				break;
			case TILDE_LEFT_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
				fullEdgeUndirected();
				}
				break;
			case MINUS_LEFT_BRACKET:
				enterOuterAlt(_localctx, 3);
				{
				setState(212);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitFullEdgePointingLeft(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FullEdgePointingLeftContext fullEdgePointingLeft() throws RecognitionException {
		FullEdgePointingLeftContext _localctx = new FullEdgePointingLeftContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_fullEdgePointingLeft);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(LEFT_ARROW_BRACKET);
			setState(216);
			elementPatternFiller();
			setState(217);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitFullEdgeUndirected(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FullEdgeUndirectedContext fullEdgeUndirected() throws RecognitionException {
		FullEdgeUndirectedContext _localctx = new FullEdgeUndirectedContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_fullEdgeUndirected);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(TILDE_LEFT_BRACKET);
			setState(220);
			elementPatternFiller();
			setState(221);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitFullEdgePointingRight(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FullEdgePointingRightContext fullEdgePointingRight() throws RecognitionException {
		FullEdgePointingRightContext _localctx = new FullEdgePointingRightContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_fullEdgePointingRight);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(MINUS_LEFT_BRACKET);
			setState(224);
			elementPatternFiller();
			setState(225);
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
		public TerminalNode LEFT_BRACE() { return getToken(GqlParser.LEFT_BRACE, 0); }
		public PropertyListContext propertyList() {
			return getRuleContext(PropertyListContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(GqlParser.RIGHT_BRACE, 0); }
		public ElementPatternFillerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementPatternFiller; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitElementPatternFiller(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementPatternFillerContext elementPatternFiller() throws RecognitionException {
		ElementPatternFillerContext _localctx = new ElementPatternFillerContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_elementPatternFiller);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(227);
				elementVariable();
				}
			}

			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IS || _la==COLON) {
				{
				setState(230);
				isLabelExpr();
				}
			}

			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LEFT_BRACE) {
				{
				setState(233);
				match(LEFT_BRACE);
				setState(234);
				propertyList();
				setState(235);
				match(RIGHT_BRACE);
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
		public List<KeyContext> key() {
			return getRuleContexts(KeyContext.class);
		}
		public KeyContext key(int i) {
			return getRuleContext(KeyContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(GqlParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(GqlParser.COLON, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GqlParser.COMMA, i);
		}
		public PropertyListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitPropertyList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyListContext propertyList() throws RecognitionException {
		PropertyListContext _localctx = new PropertyListContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_propertyList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			key();
			setState(240);
			match(COLON);
			setState(241);
			expr(0);
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(242);
				match(COMMA);
				setState(243);
				key();
				setState(244);
				match(COLON);
				setState(245);
				expr(0);
				}
				}
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ReturnListContext extends ParserRuleContext {
		public List<ReturnItemContext> returnItem() {
			return getRuleContexts(ReturnItemContext.class);
		}
		public ReturnItemContext returnItem(int i) {
			return getRuleContext(ReturnItemContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GqlParser.COMMA, i);
		}
		public ReturnListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitReturnList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnListContext returnList() throws RecognitionException {
		ReturnListContext _localctx = new ReturnListContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_returnList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			returnItem();
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(253);
				match(COMMA);
				setState(254);
				returnItem();
				}
				}
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitReturnItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnItemContext returnItem() throws RecognitionException {
		ReturnItemContext _localctx = new ReturnItemContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_returnItem);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitSetOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetOperatorContext setOperator() throws RecognitionException {
		SetOperatorContext _localctx = new SetOperatorContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_setOperator);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitUnionOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnionOperatorContext unionOperator() throws RecognitionException {
		UnionOperatorContext _localctx = new UnionOperatorContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_unionOperator);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitOtherSetOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OtherSetOperatorContext otherSetOperator() throws RecognitionException {
		OtherSetOperatorContext _localctx = new OtherSetOperatorContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_otherSetOperator);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitSetQuantifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetQuantifierContext setQuantifier() throws RecognitionException {
		SetQuantifierContext _localctx = new SetQuantifierContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_setQuantifier);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitLen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LenContext len() throws RecognitionException {
		LenContext _localctx = new LenContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_len);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitQuantifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantifierContext quantifier() throws RecognitionException {
		QuantifierContext _localctx = new QuantifierContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_quantifier);
		try {
			setState(288);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
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
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SIGNED_INTEGER:
			case SIGNED_FIXED_POINT:
			case SIGNED_FLOAT:
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
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(312);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
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
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitIsLabelExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IsLabelExprContext isLabelExpr() throws RecognitionException {
		IsLabelExprContext _localctx = new IsLabelExprContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_isLabelExpr);
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
			labelExpression();
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
		public List<LabelTermContext> labelTerm() {
			return getRuleContexts(LabelTermContext.class);
		}
		public LabelTermContext labelTerm(int i) {
			return getRuleContext(LabelTermContext.class,i);
		}
		public List<TerminalNode> VERTICAL_BAR() { return getTokens(GqlParser.VERTICAL_BAR); }
		public TerminalNode VERTICAL_BAR(int i) {
			return getToken(GqlParser.VERTICAL_BAR, i);
		}
		public LabelExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitLabelExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelExpressionContext labelExpression() throws RecognitionException {
		LabelExpressionContext _localctx = new LabelExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_labelExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			labelTerm();
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VERTICAL_BAR) {
				{
				{
				setState(321);
				match(VERTICAL_BAR);
				setState(322);
				labelTerm();
				}
				}
				setState(327);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class LabelTermContext extends ParserRuleContext {
		public List<LabelFactorContext> labelFactor() {
			return getRuleContexts(LabelFactorContext.class);
		}
		public LabelFactorContext labelFactor(int i) {
			return getRuleContext(LabelFactorContext.class,i);
		}
		public List<TerminalNode> AMPERSAND() { return getTokens(GqlParser.AMPERSAND); }
		public TerminalNode AMPERSAND(int i) {
			return getToken(GqlParser.AMPERSAND, i);
		}
		public LabelTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelTerm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitLabelTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelTermContext labelTerm() throws RecognitionException {
		LabelTermContext _localctx = new LabelTermContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_labelTerm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			labelFactor();
			setState(333);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AMPERSAND) {
				{
				{
				setState(329);
				match(AMPERSAND);
				setState(330);
				labelFactor();
				}
				}
				setState(335);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitLabelFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelFactorContext labelFactor() throws RecognitionException {
		LabelFactorContext _localctx = new LabelFactorContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_labelFactor);
		try {
			setState(338);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PERCENT:
			case LEFT_BRACKET:
			case LEFT_PAREN:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(336);
				labelPrimary();
				}
				break;
			case EXCLAMATION_MARK:
				enterOuterAlt(_localctx, 2);
				{
				setState(337);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitLabelNegation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelNegationContext labelNegation() throws RecognitionException {
		LabelNegationContext _localctx = new LabelNegationContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_labelNegation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			match(EXCLAMATION_MARK);
			setState(341);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitLabelPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelPrimaryContext labelPrimary() throws RecognitionException {
		LabelPrimaryContext _localctx = new LabelPrimaryContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_labelPrimary);
		try {
			setState(346);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(343);
				label();
				}
				break;
			case PERCENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(344);
				labelWildcard();
				}
				break;
			case LEFT_BRACKET:
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(345);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitLabelWildcard(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelWildcardContext labelWildcard() throws RecognitionException {
		LabelWildcardContext _localctx = new LabelWildcardContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_labelWildcard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitParenthesizedLabelExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenthesizedLabelExpressionContext parenthesizedLabelExpression() throws RecognitionException {
		ParenthesizedLabelExpressionContext _localctx = new ParenthesizedLabelExpressionContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_parenthesizedLabelExpression);
		try {
			setState(360);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(352);
				match(LEFT_PAREN);
				setState(353);
				labelExpression();
				setState(354);
				match(RIGHT_PAREN);
				}
				break;
			case LEFT_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(356);
				match(LEFT_BRACKET);
				setState(357);
				labelExpression();
				setState(358);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitComparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparatorContext comparator() throws RecognitionException {
		ComparatorContext _localctx = new ComparatorContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_comparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitBooleanComparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanComparatorContext booleanComparator() throws RecognitionException {
		BooleanComparatorContext _localctx = new BooleanComparatorContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_booleanComparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			match(IS);
			setState(366);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(365);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitCompOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompOpContext compOp() throws RecognitionException {
		CompOpContext _localctx = new CompOpContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_compOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			_la = _input.LA(1);
			if ( !(((((_la - 324)) & ~0x3f) == 0 && ((1L << (_la - 324)) & ((1L << (GEQ - 324)) | (1L << (LEQ - 324)) | (1L << (NEQ - 324)) | (1L << (LT - 324)) | (1L << (GT - 324)) | (1L << (EQ - 324)))) != 0)) ) {
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitGraphName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GraphNameContext graphName() throws RecognitionException {
		GraphNameContext _localctx = new GraphNameContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_graphName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
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
		public TerminalNode SIGNED_INTEGER() { return getToken(GqlParser.SIGNED_INTEGER, 0); }
		public TerminalNode SIGNED_FIXED_POINT() { return getToken(GqlParser.SIGNED_FIXED_POINT, 0); }
		public TerminalNode SIGNED_FLOAT() { return getToken(GqlParser.SIGNED_FLOAT, 0); }
		public TerminalNode WORD() { return getToken(GqlParser.WORD, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SIGNED_INTEGER) | (1L << SIGNED_FIXED_POINT) | (1L << SIGNED_FLOAT))) != 0) || _la==TRUTH_VALUE || _la==WORD) ) {
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitPathVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathVariableContext pathVariable() throws RecognitionException {
		PathVariableContext _localctx = new PathVariableContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_pathVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitElementVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementVariableContext elementVariable() throws RecognitionException {
		ElementVariableContext _localctx = new ElementVariableContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_elementVariable);
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

	public static class KeyContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GqlParser.ID, 0); }
		public KeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GqlParserVisitor ) return ((GqlParserVisitor<? extends T>)visitor).visitKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyContext key() throws RecognitionException {
		KeyContext _localctx = new KeyContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_key);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
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
		case 29:
			return expr_sempred((ExprContext)_localctx, predIndex);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u0156\u0181\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\3\2\3\2\3\2\7\2g\n\2\f"+
		"\2\16\2j\13\2\3\2\3\2\3\3\3\3\5\3p\n\3\3\4\3\4\5\4t\n\4\3\5\3\5\3\5\6"+
		"\5y\n\5\r\5\16\5z\6\5}\n\5\r\5\16\5~\3\5\3\5\3\6\6\6\u0084\n\6\r\6\16"+
		"\6\u0085\3\6\3\6\3\7\5\7\u008b\n\7\3\7\3\7\3\7\5\7\u0090\n\7\3\b\3\b\3"+
		"\b\3\t\3\t\5\t\u0097\n\t\3\t\3\t\5\t\u009b\n\t\3\n\3\n\3\n\7\n\u00a0\n"+
		"\n\f\n\16\n\u00a3\13\n\3\13\3\13\3\13\5\13\u00a8\n\13\3\13\5\13\u00ab"+
		"\n\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\7\r\u00b4\n\r\f\r\16\r\u00b7\13\r"+
		"\3\16\3\16\3\16\3\16\5\16\u00bd\n\16\3\16\3\16\5\16\u00c1\n\16\5\16\u00c3"+
		"\n\16\3\17\3\17\3\17\5\17\u00c8\n\17\3\17\3\17\7\17\u00cc\n\17\f\17\16"+
		"\17\u00cf\13\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\5\21\u00d8\n\21\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\5\25\u00e7"+
		"\n\25\3\25\5\25\u00ea\n\25\3\25\3\25\3\25\3\25\5\25\u00f0\n\25\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u00fa\n\26\f\26\16\26\u00fd\13"+
		"\26\3\27\3\27\3\27\7\27\u0102\n\27\f\27\16\27\u0105\13\27\3\30\3\30\3"+
		"\30\5\30\u010a\n\30\3\31\3\31\5\31\u010e\n\31\3\32\3\32\3\32\5\32\u0113"+
		"\n\32\3\33\3\33\5\33\u0117\n\33\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36"+
		"\3\36\3\36\5\36\u0123\n\36\3\37\3\37\3\37\3\37\3\37\5\37\u012a\n\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\7\37\u013b\n\37\f\37\16\37\u013e\13\37\3 \3 \3 \3!\3!\3!\7!\u0146"+
		"\n!\f!\16!\u0149\13!\3\"\3\"\3\"\7\"\u014e\n\"\f\"\16\"\u0151\13\"\3#"+
		"\3#\5#\u0155\n#\3$\3$\3$\3%\3%\3%\5%\u015d\n%\3&\3&\3\'\3\'\3(\3(\3(\3"+
		"(\3(\3(\3(\3(\5(\u016b\n(\3)\3)\3*\3*\5*\u0171\n*\3+\3+\3,\3,\3-\3-\3"+
		".\3.\3/\3/\3\60\3\60\3\61\3\61\3\61\2\3<\62\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`\2\n\4\2\u0084"+
		"\u0084\u0096\u0096\6\2\u00e0\u00e0\u0107\u0107\u010d\u010d\u0114\u0114"+
		"\4\2TTrr\4\2\21\21II\4\2tt\u0134\u0134\5\2\22\22\u0097\u0097\u00dd\u00dd"+
		"\3\2\u0146\u014b\6\2\7\7\t\n\u0116\u0116\u0156\u0156\2\u017d\2b\3\2\2"+
		"\2\4o\3\2\2\2\6s\3\2\2\2\b|\3\2\2\2\n\u0083\3\2\2\2\f\u008a\3\2\2\2\16"+
		"\u0091\3\2\2\2\20\u0094\3\2\2\2\22\u009c\3\2\2\2\24\u00a7\3\2\2\2\26\u00ae"+
		"\3\2\2\2\30\u00b0\3\2\2\2\32\u00c2\3\2\2\2\34\u00c4\3\2\2\2\36\u00d0\3"+
		"\2\2\2 \u00d7\3\2\2\2\"\u00d9\3\2\2\2$\u00dd\3\2\2\2&\u00e1\3\2\2\2(\u00e6"+
		"\3\2\2\2*\u00f1\3\2\2\2,\u00fe\3\2\2\2.\u0106\3\2\2\2\60\u010d\3\2\2\2"+
		"\62\u010f\3\2\2\2\64\u0114\3\2\2\2\66\u0118\3\2\2\28\u011a\3\2\2\2:\u0122"+
		"\3\2\2\2<\u0129\3\2\2\2>\u013f\3\2\2\2@\u0142\3\2\2\2B\u014a\3\2\2\2D"+
		"\u0154\3\2\2\2F\u0156\3\2\2\2H\u015c\3\2\2\2J\u015e\3\2\2\2L\u0160\3\2"+
		"\2\2N\u016a\3\2\2\2P\u016c\3\2\2\2R\u016e\3\2\2\2T\u0172\3\2\2\2V\u0174"+
		"\3\2\2\2X\u0176\3\2\2\2Z\u0178\3\2\2\2\\\u017a\3\2\2\2^\u017c\3\2\2\2"+
		"`\u017e\3\2\2\2bh\5\6\4\2cd\5\4\3\2de\5\6\4\2eg\3\2\2\2fc\3\2\2\2gj\3"+
		"\2\2\2hf\3\2\2\2hi\3\2\2\2ik\3\2\2\2jh\3\2\2\2kl\7\2\2\3l\3\3\2\2\2mp"+
		"\5\60\31\2np\7\u009a\2\2om\3\2\2\2on\3\2\2\2p\5\3\2\2\2qt\5\b\5\2rt\5"+
		"\n\6\2sq\3\2\2\2sr\3\2\2\2t\7\3\2\2\2uv\7a\2\2vx\5V,\2wy\5\f\7\2xw\3\2"+
		"\2\2yz\3\2\2\2zx\3\2\2\2z{\3\2\2\2{}\3\2\2\2|u\3\2\2\2}~\3\2\2\2~|\3\2"+
		"\2\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\5\20\t\2\u0081\t\3\2\2"+
		"\2\u0082\u0084\5\f\7\2\u0083\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0083"+
		"\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\5\20\t\2"+
		"\u0088\13\3\2\2\2\u0089\u008b\t\2\2\2\u008a\u0089\3\2\2\2\u008a\u008b"+
		"\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\7\u0086\2\2\u008d\u008f\5\22"+
		"\n\2\u008e\u0090\5\16\b\2\u008f\u008e\3\2\2\2\u008f\u0090\3\2\2\2\u0090"+
		"\r\3\2\2\2\u0091\u0092\7\u00da\2\2\u0092\u0093\5<\37\2\u0093\17\3\2\2"+
		"\2\u0094\u0096\7\u00b1\2\2\u0095\u0097\5\66\34\2\u0096\u0095\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u009b\7\u0132\2\2\u0099\u009b"+
		"\5,\27\2\u009a\u0098\3\2\2\2\u009a\u0099\3\2\2\2\u009b\21\3\2\2\2\u009c"+
		"\u00a1\5\24\13\2\u009d\u009e\7\u0135\2\2\u009e\u00a0\5\24\13\2\u009f\u009d"+
		"\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\23\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a5\5\\/\2\u00a5\u00a6\7\u014b"+
		"\2\2\u00a6\u00a8\3\2\2\2\u00a7\u00a4\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8"+
		"\u00aa\3\2\2\2\u00a9\u00ab\5\26\f\2\u00aa\u00a9\3\2\2\2\u00aa\u00ab\3"+
		"\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\5\30\r\2\u00ad\25\3\2\2\2\u00ae"+
		"\u00af\t\3\2\2\u00af\27\3\2\2\2\u00b0\u00b5\5\32\16\2\u00b1\u00b2\7\u0143"+
		"\2\2\u00b2\u00b4\5\32\16\2\u00b3\u00b1\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5"+
		"\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\31\3\2\2\2\u00b7\u00b5\3\2\2"+
		"\2\u00b8\u00c3\5\34\17\2\u00b9\u00ba\7\u0152\2\2\u00ba\u00bc\5\24\13\2"+
		"\u00bb\u00bd\5\16\b\2\u00bc\u00bb\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be"+
		"\3\2\2\2\u00be\u00c0\7\u0153\2\2\u00bf\u00c1\58\35\2\u00c0\u00bf\3\2\2"+
		"\2\u00c0\u00c1\3\2\2\2\u00c1\u00c3\3\2\2\2\u00c2\u00b8\3\2\2\2\u00c2\u00b9"+
		"\3\2\2\2\u00c3\33\3\2\2\2\u00c4\u00cd\5\36\20\2\u00c5\u00c7\5 \21\2\u00c6"+
		"\u00c8\58\35\2\u00c7\u00c6\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\3\2"+
		"\2\2\u00c9\u00ca\5\36\20\2\u00ca\u00cc\3\2\2\2\u00cb\u00c5\3\2\2\2\u00cc"+
		"\u00cf\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\35\3\2\2"+
		"\2\u00cf\u00cd\3\2\2\2\u00d0\u00d1\7\u0152\2\2\u00d1\u00d2\5(\25\2\u00d2"+
		"\u00d3\7\u0153\2\2\u00d3\37\3\2\2\2\u00d4\u00d8\5\"\22\2\u00d5\u00d8\5"+
		"$\23\2\u00d6\u00d8\5&\24\2\u00d7\u00d4\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7"+
		"\u00d6\3\2\2\2\u00d8!\3\2\2\2\u00d9\u00da\7\u011a\2\2\u00da\u00db\5(\25"+
		"\2\u00db\u00dc\7\u0121\2\2\u00dc#\3\2\2\2\u00dd\u00de\7\u0122\2\2\u00de"+
		"\u00df\5(\25\2\u00df\u00e0\7\u0123\2\2\u00e0%\3\2\2\2\u00e1\u00e2\7\u0120"+
		"\2\2\u00e2\u00e3\5(\25\2\u00e3\u00e4\7\u0119\2\2\u00e4\'\3\2\2\2\u00e5"+
		"\u00e7\5^\60\2\u00e6\u00e5\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e9\3\2"+
		"\2\2\u00e8\u00ea\5> \2\u00e9\u00e8\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ef"+
		"\3\2\2\2\u00eb\u00ec\7\u014c\2\2\u00ec\u00ed\5*\26\2\u00ed\u00ee\7\u014d"+
		"\2\2\u00ee\u00f0\3\2\2\2\u00ef\u00eb\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0"+
		")\3\2\2\2\u00f1\u00f2\5`\61\2\u00f2\u00f3\7\u0134\2\2\u00f3\u00fb\5<\37"+
		"\2\u00f4\u00f5\7\u0135\2\2\u00f5\u00f6\5`\61\2\u00f6\u00f7\7\u0134\2\2"+
		"\u00f7\u00f8\5<\37\2\u00f8\u00fa\3\2\2\2\u00f9\u00f4\3\2\2\2\u00fa\u00fd"+
		"\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc+\3\2\2\2\u00fd"+
		"\u00fb\3\2\2\2\u00fe\u0103\5.\30\2\u00ff\u0100\7\u0135\2\2\u0100\u0102"+
		"\5.\30\2\u0101\u00ff\3\2\2\2\u0102\u0105\3\2\2\2\u0103\u0101\3\2\2\2\u0103"+
		"\u0104\3\2\2\2\u0104-\3\2\2\2\u0105\u0103\3\2\2\2\u0106\u0109\5<\37\2"+
		"\u0107\u0108\7\25\2\2\u0108\u010a\5X-\2\u0109\u0107\3\2\2\2\u0109\u010a"+
		"\3\2\2\2\u010a/\3\2\2\2\u010b\u010e\5\62\32\2\u010c\u010e\5\64\33\2\u010d"+
		"\u010b\3\2\2\2\u010d\u010c\3\2\2\2\u010e\61\3\2\2\2\u010f\u0112\7\u00cd"+
		"\2\2\u0110\u0113\5\66\34\2\u0111\u0113\7\u0088\2\2\u0112\u0110\3\2\2\2"+
		"\u0112\u0111\3\2\2\2\u0112\u0113\3\2\2\2\u0113\63\3\2\2\2\u0114\u0116"+
		"\t\4\2\2\u0115\u0117\5\66\34\2\u0116\u0115\3\2\2\2\u0116\u0117\3\2\2\2"+
		"\u0117\65\3\2\2\2\u0118\u0119\t\5\2\2\u0119\67\3\2\2\2\u011a\u011b\7\u014c"+
		"\2\2\u011b\u011c\5:\36\2\u011c\u011d\7\u014d\2\2\u011d9\3\2\2\2\u011e"+
		"\u0123\7\b\2\2\u011f\u0120\7\b\2\2\u0120\u0121\7\u0135\2\2\u0121\u0123"+
		"\7\b\2\2\u0122\u011e\3\2\2\2\u0122\u011f\3\2\2\2\u0123;\3\2\2\2\u0124"+
		"\u0125\b\37\1\2\u0125\u012a\5Z.\2\u0126\u012a\5X-\2\u0127\u0128\7\u008f"+
		"\2\2\u0128\u012a\5<\37\5\u0129\u0124\3\2\2\2\u0129\u0126\3\2\2\2\u0129"+
		"\u0127\3\2\2\2\u012a\u013c\3\2\2\2\u012b\u012c\f\6\2\2\u012c\u012d\5P"+
		")\2\u012d\u012e\5<\37\7\u012e\u013b\3\2\2\2\u012f\u0130\f\3\2\2\u0130"+
		"\u0131\5T+\2\u0131\u0132\5<\37\4\u0132\u013b\3\2\2\2\u0133\u0134\f\7\2"+
		"\2\u0134\u0135\7\u013c\2\2\u0135\u013b\5`\61\2\u0136\u0137\f\4\2\2\u0137"+
		"\u0138\5R*\2\u0138\u0139\7\u0116\2\2\u0139\u013b\3\2\2\2\u013a\u012b\3"+
		"\2\2\2\u013a\u012f\3\2\2\2\u013a\u0133\3\2\2\2\u013a\u0136\3\2\2\2\u013b"+
		"\u013e\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d=\3\2\2\2"+
		"\u013e\u013c\3\2\2\2\u013f\u0140\t\6\2\2\u0140\u0141\5@!\2\u0141?\3\2"+
		"\2\2\u0142\u0147\5B\"\2\u0143\u0144\7\u0143\2\2\u0144\u0146\5B\"\2\u0145"+
		"\u0143\3\2\2\2\u0146\u0149\3\2\2\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2"+
		"\2\2\u0148A\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u014f\5D#\2\u014b\u014c"+
		"\7\u0131\2\2\u014c\u014e\5D#\2\u014d\u014b\3\2\2\2\u014e\u0151\3\2\2\2"+
		"\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150C\3\2\2\2\u0151\u014f\3"+
		"\2\2\2\u0152\u0155\5H%\2\u0153\u0155\5F$\2\u0154\u0152\3\2\2\2\u0154\u0153"+
		"\3\2\2\2\u0155E\3\2\2\2\u0156\u0157\7\u0138\2\2\u0157\u0158\5H%\2\u0158"+
		"G\3\2\2\2\u0159\u015d\5J&\2\u015a\u015d\5L\'\2\u015b\u015d\5N(\2\u015c"+
		"\u0159\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015b\3\2\2\2\u015dI\3\2\2\2"+
		"\u015e\u015f\7\u0155\2\2\u015fK\3\2\2\2\u0160\u0161\7\u013b\2\2\u0161"+
		"M\3\2\2\2\u0162\u0163\7\u0152\2\2\u0163\u0164\5@!\2\u0164\u0165\7\u0153"+
		"\2\2\u0165\u016b\3\2\2\2\u0166\u0167\7\u014e\2\2\u0167\u0168\5@!\2\u0168"+
		"\u0169\7\u014f\2\2\u0169\u016b\3\2\2\2\u016a\u0162\3\2\2\2\u016a\u0166"+
		"\3\2\2\2\u016bO\3\2\2\2\u016c\u016d\t\7\2\2\u016dQ\3\2\2\2\u016e\u0170"+
		"\7t\2\2\u016f\u0171\7\u008f\2\2\u0170\u016f\3\2\2\2\u0170\u0171\3\2\2"+
		"\2\u0171S\3\2\2\2\u0172\u0173\t\b\2\2\u0173U\3\2\2\2\u0174\u0175\5X-\2"+
		"\u0175W\3\2\2\2\u0176\u0177\7\u0155\2\2\u0177Y\3\2\2\2\u0178\u0179\t\t"+
		"\2\2\u0179[\3\2\2\2\u017a\u017b\7\u0155\2\2\u017b]\3\2\2\2\u017c\u017d"+
		"\7\u0155\2\2\u017d_\3\2\2\2\u017e\u017f\7\u0155\2\2\u017fa\3\2\2\2)ho"+
		"sz~\u0085\u008a\u008f\u0096\u009a\u00a1\u00a7\u00aa\u00b5\u00bc\u00c0"+
		"\u00c2\u00c7\u00cd\u00d7\u00e6\u00e9\u00ef\u00fb\u0103\u0109\u010d\u0112"+
		"\u0116\u0122\u0129\u013a\u013c\u0147\u014f\u0154\u015c\u016a\u0170";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}