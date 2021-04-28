package dbelousov.petprojects.algorithms.graph;

import dbelousov.petprojects.collections.graph.Graph;
import dbelousov.petprojects.collections.graph.Vertex;

import java.util.*;

public class StronglyConnectedComponents<T> {

    private int time = 1;
    private final ArrayDeque<Vertex<T>> stack = new ArrayDeque<>();
    private final Set<Set<Vertex<T>>> components = new HashSet<>();

    public Set<Set<Vertex<T>>> split(Graph<T> g) {
        dfs(g, true);
        var transposedGraph = GraphUtils.transposeGraph(g);
        dfs(transposedGraph, false);
        return components;
    }

    private void dfs(Graph<T> g, boolean isBasicDfs) {
        if (isBasicDfs) {
            for (var vertex : g.getVertices()) {
                dfsHelper(g, vertex, new HashSet<>(), true, null);
            }
        } else {
            for (var v : g.getVertices()) {
                v.setFinalized(false);
            }
            while (!stack.isEmpty()) {
                var vertex = stack.pop();
                var component = new HashSet<Vertex<T>>();
                dfsHelper(g, vertex, new HashSet<>(), false, component);
                if (!component.isEmpty()) {
                    components.add(component);
                }
            }
        }
    }

    private void dfsHelper(Graph<T> g, Vertex<T> v, Set<Vertex<T>> visited, boolean isBasicDfs, Set<Vertex<T>> component) {
        if (!visited.contains(v) && !v.isFinalized()) {
            if (isBasicDfs) {
                v.setDiscoveryTime(time);
                time += 1;
            }

            visited.add(v);

            if (!isBasicDfs) {
                component.add(v);
            }

            var adjacentEdges = g.getAdjacencyList().get(g.getVertices().indexOf(v));
            for (var adjacentEdge : adjacentEdges) {
                dfsHelper(g, adjacentEdge, visited, isBasicDfs, component);
            }
            v.setFinalized(true);

            if (isBasicDfs) {
                v.setFinalizationTime(time);
                /* Eventually, the stack will contain all vertices topologically sorted.
                 * This is a prerequisite for splitting the graph into strongly connected components
                 */
                stack.push(v);
                time += 1;
            }
        }
    }
}
