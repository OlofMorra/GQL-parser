grammar GQLKeywords;

@header{
    package antlr;
}

/* Literals needed for case insensitivity */
fragment A : [aA]; // match either an 'a' or 'A'
fragment B : [bB];
fragment C : [cC];
fragment D : [dD];
fragment E : [eE];
fragment F : [fF];
fragment G : [gG];
fragment H : [hH];
fragment I : [iI];
fragment J : [jJ];
fragment K : [kK];
fragment L : [lL];
fragment M : [mM];
fragment N : [nN];
fragment O : [oO];
fragment P : [pP];
fragment Q : [qQ];
fragment R : [rR];
fragment S : [sS];
fragment T : [tT];
fragment U : [uU];
fragment V : [vV];
fragment W : [wW];
fragment X : [xX];
fragment Y : [yY];
fragment Z : [zZ];

/* Keywords */
graph_keywords
    : ('PROPERTY')? ('GRAPH' | 'GRAPHS')            # GraphKeywords // 15.6.1
    ;

MATCH : 'MATCH';

Keyword
    : ReservedWords
    | NonReservedWords
    ;

fragment
ReservedWords
    : CaseInsensitiveReservedWord
    | 'endNode'
    | 'inDegree'
    | 'lTrim'
    | 'outDegree'
    | 'percentileCont'
    | 'percentileDist'
    | 'rTrim'
    | 'startNode'
    | 'stDev'
    | 'stDevP'
    | 'tail'
    | 'toLower'
    | 'toUpper'
    ;

fragment
CaseInsensitiveReservedWord
    : A B S
    | A C O S
    | A D D
    | A G G R E G A T E
    | A L I A S
    | A L L
    | A N D
    | A N Y
    | A R R A Y
    | A S
    | A S C
    | A S C E N D I N G
    | A S I N
    | A T
    | A T A N
    | A V G
    | B I N A R Y
    | B O O L E A N
    | B O T H
    | B Y
    | C A L L
    | C A S E
    | C A T A L O G
    | C E I L
    | C E I L I N G
    | C H A R A C T E R
    | C H A R A C T E R UNDERSCORE L E N G T H
    | C L E A R
    | C L O N E
    | C L O S E
    | C O L L E C T
    | C O M M I T
    | C O N S T R A I N T
    | C O N S T A N T
    | C O N S T R U C T
    | C O P Y
    | C O S
    | C O S H
    | C O S T
    | C O T
    | C O U N T
    | C U R R E N T UNDERSCORE D A T E
    | C U R R E N T UNDERSCORE G R A P H
    | C U R R E N T UNDERSCORE P R O P E R T Y UNDERSCORE G R A P H
    | C U R R E N T UNDERSCORE R O L E
    | C U R R E N T UNDERSCORE S C H E M A
    | C U R R E N T UNDERSCORE T I M E
    | C U R R E N T UNDERSCORE T I M  E S T A M P
    | C U R R E N T UNDERSCORE U S E R
    | C R E A T E
    | D A T E
    | D A T E T I M E
    | D E C I M A L
    | D E F A U L T
    | D E G R E E S
    | D E L E T E
    | D E T A C H
    | D E S C
    | D E S C E N D I N G
    | D I R E C T O R I E S
    | D I R E C T O R Y
    | D I S T I N C T
    | D O
    | D R O P
    | D U R A T I O N
    | E L S E
    | E N D
    | E N D S
    | E M P T Y UNDERSCORE B I N D I N G UNDERSCORE T A B L E
    | E M P T Y UNDERSCORE G R A P H
    | E M P T Y UNDERSCORE P R O P E R T Y UNDERSCORE G R A P H
    | E M P T Y UNDERSCORE T A B L E
    | E X C E P T
    | E X I S T S
    | E X I S T I N G
    | E X P
    | E X P L A I N
    | F A L S E
    | F I L T E R
    | F L O A T
    | F L O A T '32'
    | F L O A T '64'
    | F L O A T '128'
    | F L O O R
    | F O R
    | F R O M
    | F U N C T I O N
    | F U N C T I O N S
    | G Q L S T A T U S
    | G R O U P
    | H A V I N G
    | H O M E UNDERSCORE G R A P H
    | H O M E UNDERSCORE P R O P E R T Y UNDERSCORE G R A P H
    | H O M E UNDERSCORE S C H E M A
    | I N
    | I N S E R T
    | I N T E G E R
    | I N T E G E R '8'
    | I N T E G E R '16'
    | I N T E G E R '32'
    | I N T E G E R '64'
    | I N T E G E R '128'
    | I N T E R S E C T
    | I F
    | I S
    | K E E P
    | L E A D I N G
    | L E F T
    | L E N G T H
    | L E T
    | L I K E
    | L I M I T
    | L I S T
    | L N
    | L O C A L D A T E T I M E
    | L O C A L T I M E
    | L O C A L T I M E S T A M P
    | L O G
    | L O G '10'
    | L O W E R
    | M A N D A T O R Y
    | M A P
    | M A T C H
    | M E R G E
    | M A X
    | M I N
    | M O D
    | M U L T I
    | M U L T I P L E
    | M U L T I S E T
    | N E W
    | N O T
    | N O R M A L I Z E
    | N O T H I N G
    | N U L L
    | O C T E T  UNDERSCORE  L E N G T H
    | O F
    | O F F S E T
    | O N
    | O P T I O N A L
    | O R
    | O R D E R
    | O R D E R E D
    | O T H E R W I S E
    | P A R A M E T E R
    | P A T H
    | P A T H S
    | P A R T I T I O N
    | P O W E R
    | P R O C E D U R E
    | P R O C E D U R E S
    | P R O D U C T
    | P R O F I L E
    | P R O J E C T
    | Q U E R I E S
    | Q U E R Y
    | R A D I A N S
    | R E C O R D
    | R E C O R D S
    | R E F E R E N C E
    | R E M O V E
    | R E N A M E
    | R E P L A C E
    | R E Q U I R E
    | R E S E T
    | R E S U L T
    | R E T U R N
    | R I G H T
    | R O L L B A C K
    | S C A L A R
    | S C H E M A
    | S C H E M A S
    | S C H E M A T A
    | S E L E C T
    | S E S S I O N
    | S E T
    | S K I P
    | S I N
    | S I N G L E
    | S I N H
    | S Q R T
    | S T A R T
    | S T A R T S
    | S T R I N G
    | S U B S T R I N G
    | S U M
    | T A N
    | T A N H
    | T H E N
    | T I M E
    | T I M E S T A M P
    | T R A I L I N G
    | T R I M
    | T R U E
    | T R U N C A T E
    | U N I O N
    | U N I T
    | U N I T  UNDERSCORE  B I N D I N G  UNDERSCORE  T A B L E
    | U N I T  UNDERSCORE  T A B L E
    | U N I Q U E
    | U N N E S T
    | U N K N O W N
    | U N W I N D
    | U P P E R
    | U S E
    | V A L U E
    | V A L U E S
    | W H E N
    | W H E R E
    | W I T H
    | W O R K I N G  UNDERSCORE  G R A P H
    | X O R
    | Y I E L D
    | Z E R O
    ;

fragment
NonReservedWords
    : CaseInsensitiveNonReservedWord
    ;

fragment
CaseInsensitiveNonReservedWord
    : A C Y C L I C
    | B I N D I N G
    | C L A S S UNDERSCORE O R I G I N
    | C O M M A N D  UNDERSCORE  F U N C T I O N
    | C O M M A N D  UNDERSCORE  F U N C T I O N  UNDERSCORE  C O D E
    | C O N D I T I O N  UNDERSCORE  N U M B E R
    | C O N N E C T I N G
    | D E S T I N A T I O N
    | D I R E C T E D
    | E D G E
    | E D G E S
    | F I N A L
    | G R A P H
    | G R A P H S
    | G R O U P S
    | I N D E X
    | L A B E L
    | L A B E L S
    | M E S S A G E  UNDERSCORE  T E X T
    | M O R E
    | M U T A B L E
    | N F C
    | N F D
    | N F K C
    | N F K D
    | N O D E
    | N O D E S
    | N O R M A L I Z E D
    | N U M B E R
    | O N L Y
    | O R D I N A L I T Y
    | P A T T E R N
    | P A T T E R N S
    | P R O P E R T Y
    | P R O P E R T I E S
    | R E A D
    | R E L A T I O N S H I P
    | R E L A T I O N S H I P S
    | R E T U R N E D  UNDERSCORE  G Q L S T A T U S
    | S H O R T E S T
    | S I M P L E
    | S U B C L A S S  UNDERSCORE  O R I G I N
    | T A B L E
    | T A B L E S
    | T I E S
    | T O
    | T R A I L
    | T R A N S A C T I O N
    | T Y P E
    | T Y P E S
    | U N D I R E C T E D
    | V E R T E X
    | V E R T I C E S
    | W A L K
    | W R I T E
    ;

fragment
EdgeSynonym
    : E D G E
    | R E L A T I O N S H I P
    ;

fragment
NodeSynonym
    : N O D E
    | V E R T E X
    ;

UNDERSCORE: '_';