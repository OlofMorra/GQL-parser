grammar SomeLanguage ;

classDeclaration : 'class' className '{' (method)* '}';
className : ID ;
method : methodName '{' (instruction)+ '}' ;
methodName : ID ;
instruction : ID ;

ID : [a-zA-Z0-9]+ ;
WS: [ \t\n\r]+ -> skip ;