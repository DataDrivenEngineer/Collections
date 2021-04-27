package dbelousov.petprojects.algorithms.graph;

import dbelousov.petprojects.collections.graph.Graph;
import dbelousov.petprojects.collections.graph.Vertex;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DfsTraversal<T> {

    // region basic dfs

    public List<T> basicTraverse(Graph<T> g) {
        var out = new ArrayList<T>();
        for (var vertex : g.getVertices()) {
            basicTraverseHelper(out, g, vertex, new HashSet<>());
        }
        return out;
    }

    private void basicTraverseHelper(List<T> out, Graph<T> g, Vertex<T> v, Set<Vertex<T>> visited) {
        if (!visited.contains(v)) {
            out.add(v.getVal());
            visited.add(v);
            var adjacentEdges = g.getAdjacencyList().get(g.getVertices().indexOf(v));
            for (var adjacentEdge : adjacentEdges) {
                basicTraverseHelper(out, g, adjacentEdge, visited);
            }
        }
    }

    // endregion basic dfs

    // region dfs with discovery/finalization times

    private int time = 1;

    public Graph<T> traverseWithDiscoveryAndFinalizationTimes(Graph<T> g) {
        for (var vertex : g.getVertices()) {
            traverseWithDiscoveryAndFinalizationTimesHelper(g, vertex, new HashSet<>());
        }
        return g;
    }

    private void traverseWithDiscoveryAndFinalizationTimesHelper(Graph<T> g, Vertex<T> v, Set<Vertex<T>> visited) {
        if (!visited.contains(v) && !v.isFinalized()) {
            v.setDiscoveryTime(time);
            time += 1;
            visited.add(v);
            var adjacentEdges = g.getAdjacencyList().get(g.getVertices().indexOf(v));
            for (var adjacentEdge : adjacentEdges) {
                traverseWithDiscoveryAndFinalizationTimesHelper(g, adjacentEdge, visited);
            }
            v.setFinalizationTime(time);
            v.setFinalized(true);
            time += 1;
        }
    }

    // endregion dfs with discovery/finalization times
}
