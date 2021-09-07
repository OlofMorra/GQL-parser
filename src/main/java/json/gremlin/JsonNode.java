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

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class JsonNode {
    public String identity;
    public ArrayList<String> labels;
    public Map<String, Object> properties;

    public JsonNode(String identity) {
        this.identity = identity;
    }

    public JsonNode(String identity,
                    ArrayList<String> labels,
                    Map<String, Object> properties) {
        this.identity = identity;
        this.labels = labels;
        this.properties = properties;
    }

    @Override
    public String toString() {
        String labelString;
        if (labels == null) {
            labelString = "";
        } else {
            labelString = labels.toString();
        }

        String propertyString;
        if (properties == null) {
            propertyString = "";
        } else {
            propertyString = properties.toString();
        }

        return "Node " + identity + " with labels " + labelString
                + " and properties " + propertyString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonNode jsonNode = (JsonNode) o;
        return identity.equals(jsonNode.identity) && Objects.equals(labels, jsonNode.labels) && Objects.equals(properties, jsonNode.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identity, labels, properties);
    }
}
