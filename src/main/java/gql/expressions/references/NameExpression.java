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

package gql.expressions.references;

import exceptions.SemanticErrorException;
import gql.expressions.Expression;
import gql.expressions.values.GqlIdentifier;
import gql.expressions.values.Value;
import gql.graphs.GqlGraphElement;
import gql.graphs.WorkingGraph;
import gql.patterns.VariableName;
import gql.tables.Record;
import org.apache.commons.lang.ArrayUtils;

public class NameExpression extends Expression {
    private VariableName name;

    public NameExpression(String name) {
        this.name = new VariableName(name);
    }

    public GqlGraphElement getGraphElementFrom(Record record) {
        if (!ArrayUtils.contains(record.getColumnNames(), name.getId())) throw new SemanticErrorException("Variable " + name.toString() + " is not defined in executed query.");
        Value reference = record.getValueFromColumn(name.getId());
        if (!(reference instanceof GqlIdentifier)) throw new SemanticErrorException("Field does not contain a reference.");;
        return getReferent((GqlIdentifier) reference);
    }

    private GqlGraphElement getReferent(GqlIdentifier reference) {
        return WorkingGraph.getGraphElementById(reference);
    }

    public VariableName getName() {
        return name;
    }

    @Override
    public String toString() {
        return name.toString();
    }

    @Override
    public String toLatex() {
        return toString();
    }
}
