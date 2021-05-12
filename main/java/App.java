import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import static org.apache.tinkerpop.gremlin.process.traversal.AnonymousTraversalSource.traversal;

import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.T;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph;

import java.util.Map;

public class App
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
        g.addE("Edge Label").from(g.V("CustomId1")).to(g.V("CustomId2")).iterate();

        // This gets the vertices, only.
        GraphTraversal<Vertex, Map<Object, Object>> t = g.V().limit(3).elementMap();
        t.forEachRemaining(e -> System.out.println(t.toList()));
        t.close();
    }

    public static Graph createLocalGraph() {
        return TinkerGraph.open();
    }
}