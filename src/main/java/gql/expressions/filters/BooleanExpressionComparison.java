package gql.expressions.filters;

import exceptions.SemanticErrorException;
import gql.enums.BooleanComparator;
import gql.expressions.Expression;
import gql.expressions.values.TruthValue;
import gql.tables.Record;

public class BooleanExpressionComparison extends ComparisonExpression {
    private final BooleanComparator comparator;
    private Expression left;
    private Expression right;

    private final TruthValue TRUE = new TruthValue(true);
    private final TruthValue FALSE = new TruthValue(false);
    private final TruthValue UNKNOWN = new TruthValue(null);


    public BooleanExpressionComparison(Expression left, BooleanComparator comparator, Expression right) {
        if (isNotBooleanExpression(left)) throw new SemanticErrorException("Invalid value type: left side " + left.toString() + " should evaluate to a truth value.");
        if (isNotBooleanExpression(right)) throw new SemanticErrorException("Invalid value type: right " + right.toString() + " side should evaluate to a truth value.");
        if (isNameExpression(left)) throw new SemanticErrorException("Name expression " + left.toString() + " can never refer to a boolean value.");
        if (isNameExpression(right)) throw new SemanticErrorException("Name expression " + right.toString() + " can never refer to a boolean value.");

        this.left = left;
        this.comparator = comparator;
        this.right = right;
    }

    @Override
    public TruthValue evaluateOn(Record record) {
        TruthValue leftEvaluation = getTruthValueFromExpression(this.left, record);
        TruthValue rightEvaluation = getTruthValueFromExpression(this.right, record);

        switch (comparator) {
            case IS: return evaluateIs(leftEvaluation, rightEvaluation);
            case IS_NOT: return evaluateIsNot(leftEvaluation, rightEvaluation);
            case AND: return evaluateAnd(leftEvaluation, rightEvaluation);
            case XOR: return evaluateXor(leftEvaluation, rightEvaluation);
            case OR: return evaluateOr(leftEvaluation, rightEvaluation);
            default: return new TruthValue(null);
        }
    }

    private TruthValue evaluateIs(TruthValue leftEvaluation, TruthValue rightEvaluation) {
        if (leftEvaluation.equals(rightEvaluation)) return TRUE;
        return FALSE;
    }

    private TruthValue evaluateIsNot(TruthValue leftEvaluation, TruthValue rightEvaluation) {
        return evaluateIs(leftEvaluation, rightEvaluation).getNegation();
    }

    private TruthValue evaluateAnd(TruthValue leftEvaluation, TruthValue rightEvaluation) {
        if (leftEvaluation.equals(FALSE) || rightEvaluation.equals(FALSE)) return FALSE;
        if (leftEvaluation.equals(rightEvaluation) && leftEvaluation.equals(TRUE)) return TRUE;
        return UNKNOWN;
    }

    private TruthValue evaluateXor(TruthValue leftEvaluation, TruthValue rightEvaluation) {
        if (leftEvaluation.equals(UNKNOWN) || rightEvaluation.equals(UNKNOWN)) return UNKNOWN;
        if (leftEvaluation.equals(rightEvaluation)) return FALSE;
        return TRUE;
    }

    private TruthValue evaluateOr(TruthValue leftEvaluation, TruthValue rightEvaluation) {
        if (leftEvaluation.equals(TRUE) || rightEvaluation.equals(TRUE)) return TRUE;
        if (leftEvaluation.equals(rightEvaluation) && leftEvaluation.equals(FALSE)) return FALSE;
        return UNKNOWN;
    }

    @Override
    public String toString() {
        return left.toString() + " " + comparator.toString() + " " + right.toString();
    }

    @Override
    public String toLatex() {
        return left.toLatex() + "\\mathblue{ " + comparator.toString() + " }" + right.toLatex();
    }
}
