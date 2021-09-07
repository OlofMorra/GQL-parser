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
import gql.expressions.references.PropertyReference;
import gql.expressions.values.TruthValue;
import gql.expressions.values.Value;
import gql.tables.Record;

public abstract class ComparisonExpression extends Expression {
    public abstract TruthValue evaluateOn(Record record);

    protected TruthValue getTruthValueFromExpression(Expression expression, Record record) {
        if (isTruthValue(expression)) return (TruthValue) expression;
        if (isComparisonExpression(expression)) return ((ComparisonExpression) expression).evaluateOn(record);

        if (isPropertyReference(expression)) {
            Value expressionValue = ((PropertyReference) expression).getValueFrom(record);
            if (!isTruthValue(expressionValue)) throw new SemanticErrorException("Property reference " + expression.toString() + " does not refer to a boolean value.");
            return (TruthValue) expressionValue;
        }

        throw new SemanticErrorException("Expression " + expression.toString() + " cannot be evaluated to a boolean value.");
    }
}
