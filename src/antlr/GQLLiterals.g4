grammar GQLLiterals;

@header{
    package antlr;
}

import GQLtoken;

/* Implementation of 21.1 */
// TODO: finish
UnsignedInteger
    : UnsignedDecimalInteger
    ;

UnsignedDecimalInteger
    : Digit ((UNDERSCORE)* Digit)*
    ;

// TODO: finish
UnsignedLiteral
    : UnsignedNumericLiteral
//    | GeneralLiteral
    ;

// TODO: finish
UnsignedNumericLiteral
    : ExactNumericLiteral
    ;

// TODO: finish
ExactNumericLiteral
    : UnsignedInteger
    ;

//literal
//    : SignedNumericLiteral
//    | GeneralLiteral
//    ;
//
//
//
//fragment
//SqlIntervalLiteral
//    : ' ' // TODO: See syntax 21.1
//    ;
//
//fragment
//NullLiteral
//    : 'NULL'
//    ;

// TODO: Implement constructors
//fragment
//SetLiteral
//    : ListValueConstructorByEnumeration
//    ;
//
//fragment
//MultisetLiteral
//    : MultisetValueConstructorByEnumeration
//    ;
//
//fragment
//OrderedSetLiteral
//    : OrderedSetValueConstructorByEnumeration
//    ;
//
//fragment
//MapLiteral
//    : MapValueconstructorByEnumeration
//    ;
//
//fragment
//RecordLiteral
//    : RecordValueConstructorByEnumeration
//    ;