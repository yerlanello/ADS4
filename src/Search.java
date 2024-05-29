import java.util.List;

public abstract class Search<V> {
    protected WeightedGraph<V> graph;
    protected Vertex<V> startVertex;

    public Search(WeightedGraph<V> graph, Vertex<V> startVertex) {
        this.graph = graph;
        this.startVertex = startVertex;
    }

    public abstract List<Vertex<V>> getPath(Vertex<V> endVertex);
}
