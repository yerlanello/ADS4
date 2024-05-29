import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class WeightedGraph<V> {
    private Map<Vertex<V>, List<Edge<V>>> map = new HashMap<>();

    public void addVertex(V data) {
        map.putIfAbsent(new Vertex<>(data), new ArrayList<>());
    }

    public void addEdge(V source, V dest, double weight) {
        Vertex<V> srcVertex = getVertex(source);
        Vertex<V> destVertex = getVertex(dest);
        Edge<V> edge = new Edge<>(srcVertex, destVertex, weight);
        map.get(srcVertex).add(edge);
        srcVertex.addAdjacentVertex(destVertex, weight);
    }

    private Vertex<V> getVertex(V data) {
        return map.keySet().stream()
                .filter(vertex -> vertex.getData().equals(data))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Vertex not found"));
    }

    public Map<Vertex<V>, List<Edge<V>>> getMap() {
        return map;
    }
}
