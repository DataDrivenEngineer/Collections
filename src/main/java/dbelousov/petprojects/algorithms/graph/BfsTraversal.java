package dbelousov.petprojects.algorithms.graph;

import dbelousov.petprojects.collections.graph.Graph;

import java.util.ArrayDeque;
import java.util.List;

public class BfsTraversal {

    public void traverse(Graph g) {
        var q = new ArrayDeque<List<Integer>>();
        q.addAll(g.getAdjacencyList());
        var currVertice = 1;
        while (!q.isEmpty()) {
            System.out.println(currVertice);
            var edges = q.poll();
            for (var edge : edges) {
                System.out.println(edge);
            }
            currVertice++;
        }
    }
}
