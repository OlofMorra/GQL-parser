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

import exceptions.SemanticErrorException;

import java.util.ArrayList;

public class PathSequence {
    ArrayList<ElementPattern> pathSequence = new ArrayList<>();

    public PathSequence(ArrayList<ElementPattern> pathSequence) {
        if (pathSequence.size() % 2 == 0) {
            throw new SemanticErrorException("A path is an alternating sequence between nodes and edges, and must " +
                    "start and end with a node, hence, there must be an uneven number of element patterns in the list.");
        }

        for (int i = 0; i < pathSequence.size(); i++) {
            checkPatternTypeAtCorrectPosition(pathSequence.get(i), i);

            if (pathSequence.get(i) instanceof EdgePattern) {
                EdgePattern edgePattern = (EdgePattern) pathSequence.get(i);
                edgePattern.setPatternIndex(i);
                addTransformedEdgePattern(edgePattern);
            } else {
                NodePattern nodePattern = (NodePattern) pathSequence.get(i);
                nodePattern.setPatternIndex(i);
                this.pathSequence.add(nodePattern);
            }
        }
    }

    private void checkPatternTypeAtCorrectPosition(ElementPattern current, int position) {
        if (current instanceof NodePattern && !nodeIndex(position)) {
            throw new SemanticErrorException("The path does not alternate between nodes and edges.");
        } else if (current instanceof EdgePattern && !edgeIndex(position)) {
            throw new SemanticErrorException("The path does not alternate between nodes and edges.");
        }
    }

    private void addTransformedEdgePattern(EdgePattern edgePattern) {
        int quantifier = edgePattern.quantifier;

        this.pathSequence.add(edgePattern);

        NodePattern emptyNodePattern = new NodePattern(null, null, null);
        emptyNodePattern.setPatternIndex(edgePattern.patternIndex);

        for (int i = 1; i < quantifier; i++) {
            this.pathSequence.add(emptyNodePattern);
            this.pathSequence.add(edgePattern);
        }
    }

    private boolean nodeIndex(int index) {
        return index % 2 == 0;
    }

    private boolean edgeIndex(int index) {
        return index % 2 == 1;
    }

    public ElementPattern get(int index) {
        return this.pathSequence.get(index);
    }

    public int size() {
        return this.pathSequence.size();
    }

    public ArrayList<ElementPattern> getPathSequence() {
        return pathSequence;
    }
}
