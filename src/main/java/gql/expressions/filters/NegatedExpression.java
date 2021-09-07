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
import gql.expressions.Expression;
import gql.expressions.values.TruthValue;
import gql.tables.Record;

public class NegatedExpression extends ComparisonExpression {
    Expression expression;

    public NegatedExpression(Expression expression) {
        if (isNotBooleanExpression(expression)) throw new SemanticErrorException("Invalid value type: expression should evaluate to a truth value.");
        if (isNameExpression(expression)) throw new SemanticErrorException("Name expression " + expression.toString() + " can never refer to a boolean value.");

        this.expression = expression;
    }

    @Override
    public TruthValue evaluateOn(Record record) {
        expression = getTruthValueFromExpression(expression, record);

        return ((TruthValue) expression).getNegation();
    }

    @Override
    public String toString() {
        return "NOT " + expression.toString();
    }

    @Override
    public String toLatex() {
        return "\\mathblue{NOT }" + expression.toLatex();
    }
}
