# 🌟 Edge-Weighted Graph Algorithms 🌟

## 📋 Overview

This project implements **Breadth-First Search (BFS)** and **Dijkstra's algorithm** for an edge-weighted graph using vertices as objects. The graph is represented with the `WeightedGraph` class, and each vertex is an instance of the `Vertex` class. The search algorithms are encapsulated in the `BreadthFirstSearch` and `DijkstraSearch` classes.

## 🛠️ Implementation

### Vertex Class

The `Vertex` class models a vertex in the graph with a data element and a map of adjacent vertices along with their edge weights.

#### Methods:
- **`Vertex(V data)`**: Constructor to initialize the vertex with data.
- **`V getData()`**: Returns the data of the vertex.
- **`Map<Vertex<V>, Double> getAdjacentVertices()`**: Returns adjacent vertices and their weights.
- **`void addAdjacentVertex(Vertex<V> destination, double weight)`**: Adds an adjacent vertex with a specific weight.
- **`boolean equals(Object o)`**: Checks equality based on vertex data.
- **`int hashCode()`**: Generates the hash code for the vertex.
- **`String toString()`**: Returns the string representation of the vertex.

### Edge Class

The `Edge` class represents a directed, weighted edge between two vertices.

#### Methods:
- **`Edge(Vertex<V> source, Vertex<V> dest, Double weight)`**: Constructor to initialize the edge.
- **`Vertex<V> getSource()`**: Returns the source vertex.
- **`Vertex<V> getDest()`**: Returns the destination vertex.
- **`Double getWeight()`**: Returns the edge weight.

### WeightedGraph Class

The `WeightedGraph` class models the graph using a map from vertices to lists of edges.

#### Methods:
- **`void addVertex(V data)`**: Adds a new vertex.
- **`void addEdge(V source, V dest, double weight)`**: Adds a directed, weighted edge.
- **`Map<Vertex<V>, List<Edge<V>>> getMap()`**: Returns the graph's internal map.

### Search Class

The `Search` class is an abstract base class for search algorithms.

#### Methods:
- **`Search(WeightedGraph<V> graph, Vertex<V> startVertex)`**: Constructor for initializing the search.
- **`abstract List<Vertex<V>> getPath(Vertex<V> endVertex)`**: Abstract method to get the path to the end vertex.

### BreadthFirstSearch Class

The `BreadthFirstSearch` class implements BFS for pathfinding.

#### Methods:
- **`BreadthFirstSearch(WeightedGraph<V> graph, Vertex<V> startVertex)`**: Initializes BFS.
- **`List<Vertex<V>> getPath(Vertex<V> endVertex)`**: Returns the path using BFS.

### DijkstraSearch Class

The `DijkstraSearch` class implements Dijkstra's algorithm for shortest paths.

#### Methods:
- **`DijkstraSearch(WeightedGraph<V> graph, Vertex<V> startVertex)`**: Initializes Dijkstra's algorithm.
- **`List<Vertex<V>> getPath(Vertex<V> endVertex)`**: Returns the shortest path.

### Main Class

The `Main` class demonstrates the usage of the graph and search algorithms.

#### Methods:
- **`public static void main(String[] args)`**: Main method to create a graph, add vertices and edges, and perform searches.

## 🚀 Getting Started

### Prerequisites

Ensure you have the following installed:
- Java Development Kit (JDK)

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/your-username/edge-weighted-graph.git
    cd edge-weighted-graph
    ```

2. Compile the project:
    ```bash
    javac Main.java
    ```

3. Run the project:
    ```bash
    java Main
    ```

## 🎮 Example

Here’s a quick example to get you started:

```java
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
