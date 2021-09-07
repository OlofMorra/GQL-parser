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

package gql.expressions.filters;

import exceptions.SemanticErrorException;
import gql.enums.ValueComparator;
import gql.expressions.Expression;
import gql.expressions.references.NameExpression;
import gql.expressions.references.PropertyReference;
import gql.expressions.values.*;
import gql.tables.Record;

public class ValueComparison extends ComparisonExpression {
    ValueComparator comparator;
    Expression left;
    Expression right;

    public ValueComparison(Expression left, ValueComparator comparator, Expression right) {
        this.left = left;
        this.comparator = comparator;
        this.right = right;
    }

    @Override
    public TruthValue evaluateOn(Record record) {
        Value leftEvaluation = getValueFromExpression(left, record);
        Value rightEvaluation = getValueFromExpression(right, record);

        if (leftEvaluation.equals(new TruthValue(null)) || rightEvaluation.equals(new TruthValue(null))) return new TruthValue(null);
        if (leftEvaluation.getClass() != rightEvaluation.getClass() && isNotIdentifierComparison(leftEvaluation, rightEvaluation)) throw new SemanticErrorException("Invalid comparison: values in expression " + this.toString() + " are not of the same data type.");

        switch(comparator) {
            case EQ: return evaluateEq(leftEvaluation, rightEvaluation);
            case NEQ: return evaluateNeq(leftEvaluation, rightEvaluation);
            case LT: return evaluateLt(leftEvaluation, rightEvaluation);
            case GT: return evaluateGt(leftEvaluation, rightEvaluation);
            case LEQ: return evaluateLeq(leftEvaluation, rightEvaluation);
            case GEQ: return evaluateGeq(leftEvaluation, rightEvaluation);
            default: return new TruthValue(null);
        }
    }

    private boolean isNotIdentifierComparison(Value left, Value right) {
        return !((left instanceof GqlIdentifier && right instanceof GqlString) || (left instanceof GqlString && right instanceof GqlIdentifier));
    }

    private Value getValueFromExpression(Expression expression, Record record) {
        if (isComparisonExpression(expression)) return ((ComparisonExpression) expression).evaluateOn(record);
        if (isNameExpression(expression)) return ((NameExpression) expression).getGraphElementFrom(record);
        if (isPropertyReference(expression)) return ((PropertyReference) expression).getValueFrom(record);
        if (isTruthValue(expression)) return (TruthValue) expression;
        if (isFixedPointNumber(expression)) return (FixedPointNumber) expression;
        if (isFloatingPointNumber(expression)) return (FloatingPointNumber) expression;
        if (isGqlString(expression)) return (GqlString) expression;

        throw new SemanticErrorException("Expression " + this.toString() + " does not evaluate to a valid data type.");
    }

    private TruthValue evaluateEq(Value leftEvaluation, Value rightEvaluation) {
        return leftEvaluation.isEqualTo(rightEvaluation);
    }

    private TruthValue evaluateNeq(Value leftEvaluation, Value rightEvaluation) {
        return leftEvaluation.isEqualTo(rightEvaluation).getNegation();
    }

    private TruthValue evaluateLt(Value leftEvaluation, Value rightEvaluation) {
        return leftEvaluation.isSmallerThan(rightEvaluation);
    }

    private TruthValue evaluateGt(Value leftEvaluation, Value rightEvaluation) {
        return leftEvaluation.isLargerThan(rightEvaluation);
    }

    private TruthValue evaluateLeq(Value leftEvaluation, Value rightEvaluation) {
        return leftEvaluation.isSmallerOrEqualThan(rightEvaluation);
    }

    private TruthValue evaluateGeq(Value leftEvaluation, Value rightEvaluation) {
        return leftEvaluation.isLargerOrEqualThan(rightEvaluation);
    }

    @Override
    public String toString() {
        return left.toString() + " " + comparator.toString() + " " + right.toString();
    }

    @Override
    public String toLatex() {
        return left.toLatex() + " " + comparator.toString() + " " + right.toLatex();
    }
}
