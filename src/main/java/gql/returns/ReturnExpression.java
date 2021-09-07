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

package gql.returns;

import exceptions.SemanticErrorException;
import gql.expressions.Expression;
import gql.expressions.filters.ComparisonExpression;
import gql.expressions.references.NameExpression;
import gql.expressions.references.PropertyReference;
import gql.expressions.values.Value;
import gql.patterns.VariableName;
import gql.tables.Record;

public class ReturnExpression extends ReturnItem {
    Expression expression;
    VariableName name = null;

    public ReturnExpression(Expression expression) {
        if (!(expression instanceof NameExpression)) throw new SemanticErrorException("Only a variable name is allowed without alias.");

        this.expression = expression;
    }

    public ReturnExpression(Expression expression,
                            String name) {
        this.expression = expression;
        this.name = new VariableName(name);
    }

    public VariableName getName() {
        if (name == null) return ((NameExpression) expression).getName();
        return name;
    }

    public Expression getExpression() {
        return expression;
    }

    public Value getValueFrom(Record record) {
        if (expression instanceof ComparisonExpression) return ((ComparisonExpression) expression).evaluateOn(record);
        if (expression instanceof PropertyReference) return ((PropertyReference) expression).getValueFrom(record);
        if (expression instanceof NameExpression) return ((NameExpression) expression).getGraphElementFrom(record);
        if (expression instanceof Value) return (Value) expression;

        throw new SemanticErrorException("Expression of invalid data type: " + expression.getClass());
    }

    @Override
    public String toString() {
        if (name == null) return expression.toString();
        return expression.toString() + " AS " + name;
    }

    @Override
    public String toLatex() {
        if (name == null) return expression.toLatex();
        return expression.toLatex() + "\\mathblue{ AS }" + name;
    }
}
