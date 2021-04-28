package dbelousov.petprojects.collections.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Graph<T> {

    private List<Vertex<T>> vertices;
    private final List<LinkedList<Vertex<T>>> adjacencyList;

    public Graph(List<Vertex<T>> vertices, List<LinkedList<Vertex<T>>> adjacencyList) {
        this.vertices = new ArrayList<>(vertices);
        this.adjacencyList = new LinkedList<>();
        for (var adjEdges : adjacencyList) {
            var list = new LinkedList<>(adjEdges);
            this.adjacencyList.add(list);
        }
    }

    public List<Vertex<T>> getVertices() {
        return Collections.unmodifiableList(vertices);
    }

    public void setVertices(List<Vertex<T>> vertices) {
        this.vertices = new ArrayList<>(vertices);
    }

    public List<LinkedList<Vertex<T>>> getAdjacencyList() {
        return Collections.unmodifiableList(adjacencyList);
    }
}
