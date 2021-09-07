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

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.Property;
import org.apache.tinkerpop.gremlin.structure.T;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph;

import java.util.Iterator;
import java.util.Map;

import static org.apache.tinkerpop.gremlin.process.traversal.AnonymousTraversalSource.traversal;

public class GremlinApp
{
    public static void main(String[] args) throws Exception {
        // Connection to a Gremlin server
        // GraphTraversalSource g = traversal().withRemote(DriverRemoteConnection.using("localhost",8182,"g"));

        // Connection to local graph
        Graph graph = createLocalGraph();
        GraphTraversalSource g = traversal().withEmbedded(graph);

        g.addV("Person").property("Name", "Justin").iterate();
        // Add a vertex with a user-supplied ID.
        g.addV("Custom Label").property(T.id, "CustomId1").property("name", "Custom id vertex 1").iterate();
        g.addV("Custom Label").property(T.id, "CustomId2").property("name", "Custom id vertex 2").iterate();
        g.addE("Edge Label").from(g.V("CustomId1")).to(g.V("CustomId2"))
                .property("name", "olof").property("test", "Does it work").iterate();

        // This gets the vertices, only.
        Iterator<Property<Object>> list = g.E().hasLabel("Edge Label").toList().get(0).properties();
        list.forEachRemaining(e -> System.out.println(e.toString()));
        GraphTraversal<Vertex, Map<Object, Object>> t = g.V("CustomId1").limit(3).elementMap();
        t.forEachRemaining(e -> System.out.println(t.toList()));
        t.close();
    }

    public static Graph createLocalGraph() {
        return TinkerGraph.open();
    }
}