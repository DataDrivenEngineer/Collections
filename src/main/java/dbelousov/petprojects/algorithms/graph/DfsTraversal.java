package dbelousov.petprojects.algorithms.graph;

import dbelousov.petprojects.collections.graph.Graph;

import java.util.HashSet;
import java.util.Set;

public class DfsTraversal {

    public void traverse(Graph g) {
        for (var i = 1; i <= g.getVertices(); i++) {
            dfsHelper(g, i, new HashSet<>());
        }
    }

    private void dfsHelper(Graph g, int v, Set<Integer> visited) {
        if (!visited.contains(v)) {
            System.out.println(v);
            visited.add(v);
            var adjacentEdges = g.getAdjacencyList().get(v - 1);
            for (var adjacentEdge : adjacentEdges) {
                dfsHelper(g, adjacentEdge, visited);
            }
        }
    }
}
