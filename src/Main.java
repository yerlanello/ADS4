public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "C", 5);
        graph.addEdge("B", "D", 10);
        graph.addEdge("C", "E", 3);
        graph.addEdge("D", "E", 4);

        Vertex<String> startVertex = graph.getVertex("A");
        Vertex<String> endVertex = graph.getVertex("E");

        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, startVertex);
        System.out.println("BFS path: " + bfs.getPath(endVertex));

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, startVertex);
        System.out.println("Dijkstra path: " + dijkstra.getPath(endVertex));
    }
}
