package dbelousov.petprojects.algorithms.graph;

import dbelousov.petprojects.collections.graph.Graph;
import dbelousov.petprojects.collections.graph.Vertex;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DfsTraversal<T> {

    public List<T> traverse(Graph<T> g) {
        var out = new ArrayList<T>();
        for (var vertex : g.getVertices()) {
            dfsHelper(out, g, vertex, new HashSet<>());
        }
        return out;
    }

    private void dfsHelper(List<T> out, Graph<T> g, Vertex<T> v, Set<Vertex<T>> visited) {
        if (!visited.contains(v)) {
            out.add(v.getVal());
            visited.add(v);
            var adjacentEdges = g.getAdjacencyList().get(g.getVertices().indexOf(v));
            for (var adjacentEdge : adjacentEdges) {
                dfsHelper(out, g, adjacentEdge, visited);
            }
        }
    }
}
