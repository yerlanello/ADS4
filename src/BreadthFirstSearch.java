import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {
    private Map<Vertex<V>, Vertex<V>> edgeTo = new HashMap<>();
    private Set<Vertex<V>> marked = new HashSet<>();

    public BreadthFirstSearch(WeightedGraph<V> graph, Vertex<V> startVertex) {
        super(graph, startVertex);
        bfs(startVertex);
    }

    private void bfs(Vertex<V> startVertex) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        marked.add(startVertex);
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            Vertex<V> v = queue.remove();
            for (Edge<V> edge : graph.getMap().get(v)) {
                Vertex<V> w = edge.getDest();
                if (!marked.contains(w)) {
                    edgeTo.put(w, v);
                    marked.add(w);
                    queue.add(w);
                }
            }
        }
    }

    @Override
    public List<Vertex<V>> getPath(Vertex<V> endVertex) {
        List<Vertex<V>> path = new LinkedList<>();
        if (!marked.contains(endVertex)) return path; // no path

        for (Vertex<V> x = endVertex; x != startVertex; x = edgeTo.get(x)) {
            path.add(x);
        }
        path.add(startVertex);
        Collections.reverse(path);
        return path;
    }
}
