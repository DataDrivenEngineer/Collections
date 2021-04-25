package dbelousov.petprojects.collections.graph;

import java.util.LinkedList;
import java.util.List;

public class Graph {

    private Integer vertices;
    private final List<LinkedList<Integer>> adjacencyList;

    public Graph(Integer vertices, List<LinkedList<Integer>> adjacencyList) {
        this.vertices = vertices;
        this.adjacencyList = new LinkedList<>();
        for (var adjEdges : adjacencyList) {
            var list = new LinkedList<>(adjEdges);
            this.adjacencyList.add(list);
        }
    }

    public Integer getVertices() {
        return vertices;
    }

    public List<LinkedList<Integer>> getAdjacencyList() {
        return adjacencyList;
    }
}
