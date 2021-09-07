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
import gql.enums.SetQuantifier;
import gql.expressions.values.GqlIdentifier;
import gql.expressions.values.Value;
import gql.graphs.WorkingGraph;
import gql.tables.BindingTable;
import gql.tables.Record;

import java.util.ArrayList;

public class ReturnStatement {
    private SetQuantifier setQuantifier;
    private ArrayList<ReturnItem> returnItems;
    private boolean returnAll = false;

    public ReturnStatement(SetQuantifier setQuantifier,
                           ArrayList<ReturnItem> returnItemList) {
        if (returnItemList.size() < 1) throw new SemanticErrorException("There must be at least one expression that must be returned.");
        if (returnItemList.size() == 1 && returnItemList.get(0) instanceof Asterisk) this.returnAll = true;
        if (returnItemList.contains(new Asterisk())) throw new SemanticErrorException("If an asterisk is in the return statement, no other return items may be present.");

        this.setQuantifier = setQuantifier;
        this.returnItems = returnItemList;
    }

    public BindingTable obtainResultFrom(BindingTable input) {
        if (setQuantifier.equals(SetQuantifier.DISTINCT)) input.makeDistinct();

        String[] columnNames = (returnAll) ? input.getColumnNames() : getNewDomain();
        BindingTable output = new BindingTable(input.hasDuplicates(), columnNames);

        for (Record record: input.getRecords()) {
            output.addRecord(new Record(columnNames, getNewValues(record)));
        }

        return output;
    }

    private String[] getNewDomain() {
        String[] columnNames = new String[returnItems.size()];

        for (int i = 0; i < returnItems.size(); i++) {
            columnNames[i] = ((ReturnExpression) returnItems.get(i)).getName().toString();
        }

        return columnNames;
    }

    private Value[] getNewValues(Record record) {
        if (returnAll) return getReferredGraphElements(record);

        return getReferredValues(record);
    }

    private Value[] getReferredGraphElements(Record record) {
        Value[] values = new Value[record.getColumnNames().length];

        for (int i = 0; i < record.getColumnNames().length; i++) {
            GqlIdentifier identifier = (GqlIdentifier) record.getValueFromColumn(record.getColumnNames()[i]);
            values[i] = WorkingGraph.getGraphElementById(identifier);
        }

        return values;
    }

    private Value[] getReferredValues(Record record) {
        Value[] values = new Value[returnItems.size()];

        for (int i = 0; i < returnItems.size(); i++) {
            ReturnExpression returnExpression = (ReturnExpression) returnItems.get(i);
            values[i] = returnExpression.getValueFrom(record);
        }

        return values;
    }

    public SetQuantifier getSetQuantifier() {
        return setQuantifier;
    }

    public boolean isDistinct() {
        return setQuantifier == SetQuantifier.DISTINCT;
    }

    public ArrayList<ReturnItem> getReturnItems() {
        return returnItems;
    }

    @Override
    public String toString() {
        return " RETURN " + setQuantifier.toString() + " " + returnItems.toString();
    }
}
