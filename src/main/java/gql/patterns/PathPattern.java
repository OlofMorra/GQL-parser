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

package gql.patterns;

import com.google.common.collect.HashMultiset;
import gql.enums.Direction;
import gql.enums.EvaluationMode;
import gql.expressions.values.GqlIdentifier;
import gql.graphs.WorkingGraph;
import gql.tables.BindingTable;
import gql.tables.Record;
import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class PathPattern {
    VariableName variableName;
    PathSequence pathSequence;
    EvaluationMode evaluationMode = EvaluationMode.WALK;

    public PathPattern(VariableName variableName, PathSequence pathSequence) {
        this.variableName = variableName;
        this.pathSequence = pathSequence;
    }

    public BindingTable match(EvaluationMode evaluationMode) {
        this.evaluationMode = evaluationMode;

        BindingTable result = new BindingTable(true, new String[]{});

        if (pathSequence.size() == 0) {
            return result;
        }

        result = getLeftToRightEvaluationResult();
        HashMap<Integer, GqlIdentifier> domain = getDomain();
        result.updateDomain(domain);

        return result;
    }

    private BindingTable getLeftToRightEvaluationResult() {
        BindingTable result = pathSequence.get(0).match();

        for (int i = 1; i < pathSequence.size(); i += 2) {
            EdgePattern edgePattern = (EdgePattern) pathSequence.get(i);
            NodePattern nodePattern = (NodePattern) pathSequence.get(i+1);
            result = join(result, edgePattern.match(), nodePattern.match(), edgePattern.getDirection());
        }

        return result;
    }

    private HashMap<Integer, GqlIdentifier> getDomain() {
        HashMap<Integer, GqlIdentifier> domain = new HashMap<>();

        for (ElementPattern elementPattern: pathSequence.pathSequence) {
            if (elementPattern.variableName != null) {
                domain.put(elementPattern.patternIndex, elementPattern.variableName);
            }
        }

        return domain;
    }

    private BindingTable join(BindingTable startNodeIds, BindingTable edgeIds, BindingTable endNodeIds, Direction edgeDirection) {
        if (startNodeIds == null) {
            throw new NullPointerException("The table for start node ids is not initialized.");
        } else if (edgeIds == null) {
            throw new NullPointerException("The table for edge ids is not initialized.");
        } else if (endNodeIds == null) {
            throw new NullPointerException("The table for end node ids is not initialized.");
        }

        if (isEmptyBindingTable(startNodeIds, edgeIds, endNodeIds)) {
            return getEmptyResultTable(startNodeIds.width() + edgeIds.width() + endNodeIds.width());
        }

        return joinBindingTables(startNodeIds, edgeIds, endNodeIds, edgeDirection);
    }

    private BindingTable joinBindingTables(BindingTable startNodeIds, BindingTable edgeIds, BindingTable endNodeIds, Direction edgeDirection) {
        String[] columnNames = getConcatenatedColumnNames(startNodeIds.getColumnNames(), edgeIds.getColumnNames());
        columnNames = getConcatenatedColumnNames(columnNames, endNodeIds.getColumnNames());
        BindingTable result = getResultTable(columnNames);

        for (Record startNodeIdRecord: startNodeIds.getRecords()) {
            for (Record endNodeIdRecord: endNodeIds.getRecords()) {
                ArrayList<Record> joinedRecords = getJoinedRecords(startNodeIdRecord, edgeIds.getRecords(), endNodeIdRecord, edgeDirection);
                result.addRecords(joinedRecords);
            }
        }

        return result;
    }

    private ArrayList<Record> getJoinedRecords(Record startNodeIdRecord, HashMultiset<Record> edgeIdRecords, Record endNodeIdRecord, Direction edgeDirection) {
        ArrayList<Record> joinedRecords = new ArrayList<>();
        GqlIdentifier startNodeId = (GqlIdentifier) startNodeIdRecord.getValues()[startNodeIdRecord.getValues().length-1];
        GqlIdentifier endNodeId = (GqlIdentifier) endNodeIdRecord.getValues()[0];
        WorkingGraph graph = WorkingGraph.getInstance();

        for (Record edgeIdRecord: edgeIdRecords) {
            GqlIdentifier edgeId = (GqlIdentifier) edgeIdRecord.getValues()[0];
            if (isLeftToRightMatch(edgeDirection, startNodeId, endNodeId, graph, edgeId)
                    || isRightToLeftMatch(edgeDirection, startNodeId, endNodeId, graph, edgeId)
                    || isUndirectedMatch(edgeDirection, startNodeId, endNodeId, graph, edgeId)) {
                Record joinedRecord = startNodeIdRecord.patternJoin(edgeIdRecord).patternJoin(endNodeIdRecord);

                if (joinedRecord.isCorrectIn(evaluationMode)) {
                    joinedRecords.add(joinedRecord);
                }
            }
        }

        return joinedRecords;
    }

    private boolean isUndirectedMatch(Direction edgeDirection, GqlIdentifier startNodeId, GqlIdentifier endNodeId, WorkingGraph graph, GqlIdentifier edgeId) {
        return edgeDirection == Direction.UNDIRECTED && graph.edges.get(edgeId).hasEndpoints(startNodeId, endNodeId);
    }

    private boolean isRightToLeftMatch(Direction edgeDirection, GqlIdentifier startNodeId, GqlIdentifier endNodeId, WorkingGraph graph, GqlIdentifier edgeId) {
        return edgeDirection == Direction.RIGHT_TO_LEFT && graph.edges.get(edgeId).hasStartAndEndNode(endNodeId, startNodeId);
    }

    private boolean isLeftToRightMatch(Direction edgeDirection, GqlIdentifier startNodeId, GqlIdentifier endNodeId, WorkingGraph graph, GqlIdentifier edgeId) {
        return edgeDirection == Direction.LEFT_TO_RIGHT && graph.edges.get(edgeId).hasStartAndEndNode(startNodeId, endNodeId);
    }

    private boolean isEmptyBindingTable(BindingTable startNodeIds, BindingTable edgeIds, BindingTable endNodeIds) {
        return !startNodeIds.hasRecords() || !edgeIds.hasRecords() || !endNodeIds.hasRecords();
    }

    private BindingTable getEmptyResultTable(int numberOfColumns) {
        String[] columnNames = new String[numberOfColumns];

        for (int i = 0; i < numberOfColumns; i++) {
            columnNames[i] = String.valueOf(i);
        }

        return new BindingTable(true, columnNames);
    }

    private BindingTable getResultTable(String[] columnNames) {
        return new BindingTable(true, columnNames);
    }

    private String[] getConcatenatedColumnNames(String[] leftColumnNames, String[] rightColumnNames) {
        return (String[]) ArrayUtils.addAll(leftColumnNames, rightColumnNames);
    }

    public ArrayList<ElementPattern> getPathSequence() {
        return pathSequence.getPathSequence();
    }

    @Override
    public String toString() {
        return pathSequence.toString();
    }
}
