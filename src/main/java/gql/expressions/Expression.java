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

package gql.expressions;

import gql.expressions.filters.ComparisonExpression;
import gql.expressions.references.NameExpression;
import gql.expressions.references.PropertyReference;
import gql.expressions.values.FixedPointNumber;
import gql.expressions.values.FloatingPointNumber;
import gql.expressions.values.GqlString;
import gql.expressions.values.TruthValue;

public abstract class Expression {
    public abstract String toString();
    public abstract String toLatex();

    protected boolean isNotBooleanExpression(Expression expression) {
        return !isComparisonExpression(expression) && !isTruthValue(expression) && !isPropertyReference(expression);
    }

    protected boolean isComparisonExpression(Expression expression) {
        return expression instanceof ComparisonExpression;
    }

    protected boolean isNameExpression(Expression expression) {
        return expression instanceof NameExpression;
    }

    protected boolean isPropertyReference(Expression expression) {
        return expression instanceof PropertyReference;
    }

    protected boolean isTruthValue(Expression expression) {
        return expression instanceof TruthValue;
    }

    protected boolean isGqlString(Expression expression) {
        return expression instanceof GqlString;
    }

    protected boolean isFixedPointNumber(Expression expression) {
        return expression instanceof FixedPointNumber;
    }

    protected boolean isFloatingPointNumber(Expression expression) {
        return expression instanceof FloatingPointNumber;
    }
}
