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

import gql.expressions.Expression;
import gql.expressions.values.GqlIdentifier;
import gql.expressions.values.TruthValue;
import gql.expressions.values.Value;
import gql.graphs.GqlGraphElement;
import gql.tables.Record;

public class PropertyReference extends Expression {
    NameExpression name;
    GqlIdentifier key;

    public PropertyReference(String name, String key) {
        this.name = new NameExpression(name);
        this.key = new GqlIdentifier(key);
    }

    public Value getValueFrom(Record record) {
        GqlGraphElement referent = name.getGraphElementFrom(record);
        return getPropertyFrom(referent);
    }

    private Value getPropertyFrom(GqlGraphElement referent) {
        if (referent == null) return new TruthValue(null);
        if (referent.getProperties().containsKey(key)) return referent.getProperties().get(key);
        if (key.equals(new GqlIdentifier("id")) || key.equals(new GqlIdentifier("identity"))) return referent.getId();
        return new TruthValue(null);
    }

    @Override
    public String toString() {
        return name.toString() + "." + key.toString();
    }

    @Override
    public String toLatex() {
        return toString();
    }
}
