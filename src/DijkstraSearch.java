import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private Map<Vertex<V>, Double> distTo = new HashMap<>();
    private Map<Vertex<V>, Vertex<V>> edgeTo = new HashMap<>();
    private PriorityQueue<Vertex<V>> pq;

    public DijkstraSearch(WeightedGraph<V> graph, Vertex<V> startVertex) {
        super(graph, startVertex);
        pq = new PriorityQueue<>(Comparator.comparingDouble(distTo::get));
        for (Vertex<V> vertex : graph.getMap().keySet()) {
            distTo.put(vertex, Double.POSITIVE_INFINITY);
        }
        distTo.put(startVertex, 0.0);
        pq.add(startVertex);
        dijkstra();
    }

    private void dijkstra() {
        while (!pq.isEmpty()) {
            Vertex<V> v = pq.poll();
            for (Edge<V> edge : graph.getMap().get(v)) {
                relax(edge);
            }
        }
    }

    private void relax(Edge<V> edge) {
        Vertex<V> v = edge.getSource();
        Vertex<V> w = edge.getDest();
        double weight = edge.getWeight();
        if (distTo.get(w) > distTo.get(v) + weight) {
            distTo.put(w, distTo.get(v) + weight);
            edgeTo.put(w, v);
            pq.add(w);
        }
    }

    @Override
    public List<Vertex<V>> getPath(Vertex<V> endVertex) {
        List<Vertex<V>> path = new LinkedList<>();
        if (!edgeTo.containsKey(endVertex)) return path; // no path

        for (Vertex<V> x = endVertex; x != startVertex; x = edgeTo.get(x)) {
            path.add(x);
        }
        path.add(startVertex);
        Collections.reverse(path);
        return path;
    }
}
