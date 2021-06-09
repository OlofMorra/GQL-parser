// Generated from JsonEdgeParser.g4 by ANTLR 4.9.1

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
public class JsonEdgeParser extends Parser {
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
		RULE_jsonEdgeFile = 0, RULE_edge = 1, RULE_edgeFiller = 2, RULE_identity = 3, 
		RULE_startNode = 4, RULE_endNode = 5, RULE_labels = 6, RULE_properties = 7, 
		RULE_pair = 8, RULE_quotedId = 9, RULE_value = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"jsonEdgeFile", "edge", "edgeFiller", "identity", "startNode", "endNode", 
			"labels", "properties", "pair", "quotedId", "value"
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
	public String getGrammarFileName() { return "JsonEdgeParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JsonEdgeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class JsonEdgeFileContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(JsonEdgeParser.LEFT_BRACE, 0); }
		public List<EdgeContext> edge() {
			return getRuleContexts(EdgeContext.class);
		}
		public EdgeContext edge(int i) {
			return getRuleContext(EdgeContext.class,i);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(JsonEdgeParser.RIGHT_BRACE, 0); }
		public TerminalNode EOF() { return getToken(JsonEdgeParser.EOF, 0); }
		public List<TerminalNode> COMMA() { return getTokens(JsonEdgeParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JsonEdgeParser.COMMA, i);
		}
		public JsonEdgeFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jsonEdgeFile; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JsonEdgeParserVisitor ) return ((JsonEdgeParserVisitor<? extends T>)visitor).visitJsonEdgeFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JsonEdgeFileContext jsonEdgeFile() throws RecognitionException {
		JsonEdgeFileContext _localctx = new JsonEdgeFileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_jsonEdgeFile);
		int _la;
		try {
			setState(37);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(22);
				match(LEFT_BRACE);
				setState(23);
				edge();
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(24);
					match(COMMA);
					setState(25);
					edge();
					}
					}
					setState(30);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(31);
				match(RIGHT_BRACE);
				setState(32);
				match(EOF);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(34);
				match(LEFT_BRACE);
				setState(35);
				match(RIGHT_BRACE);
				setState(36);
				match(EOF);
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

	public static class EdgeContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(JsonEdgeParser.WORD, 0); }
		public TerminalNode COLON() { return getToken(JsonEdgeParser.COLON, 0); }
		public TerminalNode LEFT_BRACE() { return getToken(JsonEdgeParser.LEFT_BRACE, 0); }
		public EdgeFillerContext edgeFiller() {
			return getRuleContext(EdgeFillerContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(JsonEdgeParser.RIGHT_BRACE, 0); }
		public EdgeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edge; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JsonEdgeParserVisitor ) return ((JsonEdgeParserVisitor<? extends T>)visitor).visitEdge(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EdgeContext edge() throws RecognitionException {
		EdgeContext _localctx = new EdgeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_edge);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(WORD);
			setState(40);
			match(COLON);
			setState(41);
			match(LEFT_BRACE);
			setState(42);
			edgeFiller();
			setState(43);
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

	public static class EdgeFillerContext extends ParserRuleContext {
		public List<TerminalNode> WORD() { return getTokens(JsonEdgeParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(JsonEdgeParser.WORD, i);
		}
		public List<TerminalNode> COLON() { return getTokens(JsonEdgeParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(JsonEdgeParser.COLON, i);
		}
		public IdentityContext identity() {
			return getRuleContext(IdentityContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(JsonEdgeParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JsonEdgeParser.COMMA, i);
		}
		public StartNodeContext startNode() {
			return getRuleContext(StartNodeContext.class,0);
		}
		public EndNodeContext endNode() {
			return getRuleContext(EndNodeContext.class,0);
		}
		public TerminalNode SIGNED_INTEGER() { return getToken(JsonEdgeParser.SIGNED_INTEGER, 0); }
		public LabelsContext labels() {
			return getRuleContext(LabelsContext.class,0);
		}
		public PropertiesContext properties() {
			return getRuleContext(PropertiesContext.class,0);
		}
		public EdgeFillerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edgeFiller; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JsonEdgeParserVisitor ) return ((JsonEdgeParserVisitor<? extends T>)visitor).visitEdgeFiller(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EdgeFillerContext edgeFiller() throws RecognitionException {
		EdgeFillerContext _localctx = new EdgeFillerContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_edgeFiller);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(WORD);
			setState(46);
			match(COLON);
			setState(47);
			identity();
			setState(48);
			match(COMMA);
			setState(49);
			match(WORD);
			setState(50);
			match(COLON);
			setState(51);
			startNode();
			setState(52);
			match(COMMA);
			setState(53);
			match(WORD);
			setState(54);
			match(COLON);
			setState(55);
			endNode();
			setState(58);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(56);
				match(COMMA);
				setState(57);
				labels();
				}
				break;
			}
			setState(62);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(60);
				match(COMMA);
				setState(61);
				properties();
				}
				break;
			}
			setState(64);
			match(COMMA);
			setState(65);
			match(WORD);
			setState(66);
			match(COLON);
			setState(67);
			match(SIGNED_INTEGER);
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

	public static class IdentityContext extends ParserRuleContext {
		public QuotedIdContext quotedId() {
			return getRuleContext(QuotedIdContext.class,0);
		}
		public IdentityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identity; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JsonEdgeParserVisitor ) return ((JsonEdgeParserVisitor<? extends T>)visitor).visitIdentity(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentityContext identity() throws RecognitionException {
		IdentityContext _localctx = new IdentityContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_identity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			quotedId();
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

	public static class StartNodeContext extends ParserRuleContext {
		public QuotedIdContext quotedId() {
			return getRuleContext(QuotedIdContext.class,0);
		}
		public StartNodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startNode; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JsonEdgeParserVisitor ) return ((JsonEdgeParserVisitor<? extends T>)visitor).visitStartNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartNodeContext startNode() throws RecognitionException {
		StartNodeContext _localctx = new StartNodeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_startNode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			quotedId();
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

	public static class EndNodeContext extends ParserRuleContext {
		public QuotedIdContext quotedId() {
			return getRuleContext(QuotedIdContext.class,0);
		}
		public EndNodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endNode; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JsonEdgeParserVisitor ) return ((JsonEdgeParserVisitor<? extends T>)visitor).visitEndNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EndNodeContext endNode() throws RecognitionException {
		EndNodeContext _localctx = new EndNodeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_endNode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			quotedId();
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

	public static class LabelsContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(JsonEdgeParser.WORD, 0); }
		public TerminalNode COLON() { return getToken(JsonEdgeParser.COLON, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(JsonEdgeParser.LEFT_BRACKET, 0); }
		public List<QuotedIdContext> quotedId() {
			return getRuleContexts(QuotedIdContext.class);
		}
		public QuotedIdContext quotedId(int i) {
			return getRuleContext(QuotedIdContext.class,i);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(JsonEdgeParser.RIGHT_BRACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(JsonEdgeParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JsonEdgeParser.COMMA, i);
		}
		public LabelsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labels; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JsonEdgeParserVisitor ) return ((JsonEdgeParserVisitor<? extends T>)visitor).visitLabels(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelsContext labels() throws RecognitionException {
		LabelsContext _localctx = new LabelsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_labels);
		int _la;
		try {
			setState(92);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				match(WORD);
				setState(76);
				match(COLON);
				setState(77);
				match(LEFT_BRACKET);
				setState(78);
				quotedId();
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(79);
					match(COMMA);
					setState(80);
					quotedId();
					}
					}
					setState(85);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(86);
				match(RIGHT_BRACKET);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				match(WORD);
				setState(89);
				match(COLON);
				setState(90);
				match(LEFT_BRACKET);
				setState(91);
				match(RIGHT_BRACKET);
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

	public static class PropertiesContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(JsonEdgeParser.WORD, 0); }
		public TerminalNode COLON() { return getToken(JsonEdgeParser.COLON, 0); }
		public TerminalNode LEFT_BRACE() { return getToken(JsonEdgeParser.LEFT_BRACE, 0); }
		public List<PairContext> pair() {
			return getRuleContexts(PairContext.class);
		}
		public PairContext pair(int i) {
			return getRuleContext(PairContext.class,i);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(JsonEdgeParser.RIGHT_BRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(JsonEdgeParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JsonEdgeParser.COMMA, i);
		}
		public PropertiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_properties; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JsonEdgeParserVisitor ) return ((JsonEdgeParserVisitor<? extends T>)visitor).visitProperties(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertiesContext properties() throws RecognitionException {
		PropertiesContext _localctx = new PropertiesContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_properties);
		int _la;
		try {
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				match(WORD);
				setState(95);
				match(COLON);
				setState(96);
				match(LEFT_BRACE);
				setState(97);
				pair();
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(98);
					match(COMMA);
					setState(99);
					pair();
					}
					}
					setState(104);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(105);
				match(RIGHT_BRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				match(WORD);
				setState(108);
				match(COLON);
				setState(109);
				match(LEFT_BRACE);
				setState(110);
				match(RIGHT_BRACE);
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

	public static class PairContext extends ParserRuleContext {
		public QuotedIdContext quotedId() {
			return getRuleContext(QuotedIdContext.class,0);
		}
		public TerminalNode COLON() { return getToken(JsonEdgeParser.COLON, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public PairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JsonEdgeParserVisitor ) return ((JsonEdgeParserVisitor<? extends T>)visitor).visitPair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairContext pair() throws RecognitionException {
		PairContext _localctx = new PairContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_pair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			quotedId();
			setState(114);
			match(COLON);
			{
			setState(115);
			value();
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

	public static class QuotedIdContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(JsonEdgeParser.WORD, 0); }
		public QuotedIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quotedId; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JsonEdgeParserVisitor ) return ((JsonEdgeParserVisitor<? extends T>)visitor).visitQuotedId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuotedIdContext quotedId() throws RecognitionException {
		QuotedIdContext _localctx = new QuotedIdContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_quotedId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(WORD);
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
		public TerminalNode WORD() { return getToken(JsonEdgeParser.WORD, 0); }
		public TerminalNode TRUTH_VALUE() { return getToken(JsonEdgeParser.TRUTH_VALUE, 0); }
		public TerminalNode SIGNED_INTEGER() { return getToken(JsonEdgeParser.SIGNED_INTEGER, 0); }
		public TerminalNode SIGNED_FIXED_POINT() { return getToken(JsonEdgeParser.SIGNED_FIXED_POINT, 0); }
		public TerminalNode SIGNED_FLOAT() { return getToken(JsonEdgeParser.SIGNED_FLOAT, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JsonEdgeParserVisitor ) return ((JsonEdgeParserVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u0156|\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\2\3\2\7\2\35\n\2\f\2\16\2 \13\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\5\2(\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\5\4=\n\4\3\4\3\4\5\4A\n\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7\bT\n\b\f\b\16\bW\13"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b_\n\b\3\t\3\t\3\t\3\t\3\t\3\t\7\tg\n\t\f"+
		"\t\16\tj\13\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tr\n\t\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\f\3\f\3\f\2\2\r\2\4\6\b\n\f\16\20\22\24\26\2\3\6\2\7\7\t\n\u0116"+
		"\u0116\u0156\u0156\2x\2\'\3\2\2\2\4)\3\2\2\2\6/\3\2\2\2\bG\3\2\2\2\nI"+
		"\3\2\2\2\fK\3\2\2\2\16^\3\2\2\2\20q\3\2\2\2\22s\3\2\2\2\24w\3\2\2\2\26"+
		"y\3\2\2\2\30\31\7\u014c\2\2\31\36\5\4\3\2\32\33\7\u0135\2\2\33\35\5\4"+
		"\3\2\34\32\3\2\2\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37!\3\2\2\2"+
		" \36\3\2\2\2!\"\7\u014d\2\2\"#\7\2\2\3#(\3\2\2\2$%\7\u014c\2\2%&\7\u014d"+
		"\2\2&(\7\2\2\3\'\30\3\2\2\2\'$\3\2\2\2(\3\3\2\2\2)*\7\u0156\2\2*+\7\u0134"+
		"\2\2+,\7\u014c\2\2,-\5\6\4\2-.\7\u014d\2\2.\5\3\2\2\2/\60\7\u0156\2\2"+
		"\60\61\7\u0134\2\2\61\62\5\b\5\2\62\63\7\u0135\2\2\63\64\7\u0156\2\2\64"+
		"\65\7\u0134\2\2\65\66\5\n\6\2\66\67\7\u0135\2\2\678\7\u0156\2\289\7\u0134"+
		"\2\29<\5\f\7\2:;\7\u0135\2\2;=\5\16\b\2<:\3\2\2\2<=\3\2\2\2=@\3\2\2\2"+
		">?\7\u0135\2\2?A\5\20\t\2@>\3\2\2\2@A\3\2\2\2AB\3\2\2\2BC\7\u0135\2\2"+
		"CD\7\u0156\2\2DE\7\u0134\2\2EF\7\7\2\2F\7\3\2\2\2GH\5\24\13\2H\t\3\2\2"+
		"\2IJ\5\24\13\2J\13\3\2\2\2KL\5\24\13\2L\r\3\2\2\2MN\7\u0156\2\2NO\7\u0134"+
		"\2\2OP\7\u014e\2\2PU\5\24\13\2QR\7\u0135\2\2RT\5\24\13\2SQ\3\2\2\2TW\3"+
		"\2\2\2US\3\2\2\2UV\3\2\2\2VX\3\2\2\2WU\3\2\2\2XY\7\u014f\2\2Y_\3\2\2\2"+
		"Z[\7\u0156\2\2[\\\7\u0134\2\2\\]\7\u014e\2\2]_\7\u014f\2\2^M\3\2\2\2^"+
		"Z\3\2\2\2_\17\3\2\2\2`a\7\u0156\2\2ab\7\u0134\2\2bc\7\u014c\2\2ch\5\22"+
		"\n\2de\7\u0135\2\2eg\5\22\n\2fd\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2"+
		"ik\3\2\2\2jh\3\2\2\2kl\7\u014d\2\2lr\3\2\2\2mn\7\u0156\2\2no\7\u0134\2"+
		"\2op\7\u014c\2\2pr\7\u014d\2\2q`\3\2\2\2qm\3\2\2\2r\21\3\2\2\2st\5\24"+
		"\13\2tu\7\u0134\2\2uv\5\26\f\2v\23\3\2\2\2wx\7\u0156\2\2x\25\3\2\2\2y"+
		"z\t\2\2\2z\27\3\2\2\2\n\36\'<@U^hq";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}