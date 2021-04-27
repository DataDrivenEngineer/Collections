package dbelousov.petprojects.algorithms.graph;

import dbelousov.petprojects.collections.graph.Graph;
import dbelousov.petprojects.collections.graph.Vertex;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BfsTraversal<T> {

    public List<T> traverse(Graph<T> g) {
        var out = new ArrayList<T>();
        var q = new ArrayDeque<List<Vertex<T>>>();
        q.addAll(g.getAdjacencyList());
        var sourceVertexIndex = 0;
        while (!q.isEmpty()) {
            out.add(g.getVertices().get(sourceVertexIndex).getVal());
            var adjacentVertices = q.poll();
            for (var adjacentVertex : adjacentVertices) {
                out.add(adjacentVertex.getVal());
            }
            sourceVertexIndex++;
        }
        return out;
    }
}
