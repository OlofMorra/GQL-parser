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

package json.gremlin;

import com.fasterxml.jackson.annotation.JsonProperty;
import exceptions.InvalidNodeFormatException;

import java.util.*;

public class JsonNodeList {
    public ArrayList<JsonNode> nodes = new ArrayList<>();
    public ArrayList<String> ids = new ArrayList<>();

    @SuppressWarnings("unchecked")
    @JsonProperty("n")
    private void unpackNested(Map<String,Object> node) throws InvalidNodeFormatException {
        checkNodeFormat(node);

        String identity = getIdentity(node);
        ArrayList<String> labels = getLabels(node);
        Map<String, Object> properties = getProperties(node);

        JsonNode jsonNode = new JsonNode(identity, labels, properties);

        this.nodes.add(jsonNode);
        this.ids.add(identity);
    }

    private void checkNodeFormat(Map<String, Object> node) throws InvalidNodeFormatException {
        if (!node.containsKey("identity")) {
            throw new InvalidNodeFormatException("A node does not have an identity.");
        } else if (ids.contains(node.get("identity").toString())) {
            throw new InvalidNodeFormatException("There are at least two nodes with key " + node.get("identity").toString() + ".");
        }

        Set keys = new TreeSet(node.keySet());
        keys.removeAll(Arrays.asList(new String[]{"identity", "labels", "properties"}));

        if (!keys.isEmpty()) {
            throw new InvalidNodeFormatException("A node n in node.json has more fields than identity, labels, or properties.");
        }
    }

    private String getIdentity(Map<String, Object> node) {
        return node.get("identity").toString();
    }

    private ArrayList<String> getLabels(Map<String, Object> node) {
        ArrayList<String> labels = null;
        if (node.containsKey("labels")) {
            labels = (ArrayList<String>) node.get("labels");
        }
        return labels;
    }

    private Map<String, Object> getProperties(Map<String, Object> node) {
        Map<String, Object> properties = null;
        if (node.containsKey("properties")) {
            properties = (Map<String, Object>) node.get("properties");
        }
        return properties;
    }

    @Override
    public String toString() {
        return nodes.toString();
    }
}
