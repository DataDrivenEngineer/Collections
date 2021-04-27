package dbelousov.petprojects.algorithms.graph;

import dbelousov.petprojects.collections.graph.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DfsTraversalTest {
    private Graph<Integer> g;
    private final DfsTraversal<Integer> dfsTraversal = new DfsTraversal<>();

    @BeforeEach
    void setUp() {
        var vertices = new Integer[]{1,2,3,4,5,6};
        var edges = new Integer[][]{
                {2,4}, {5}, {5,6}, {2}, {4}, {6}
        };
        g = GraphUtils.makeGraph(vertices, edges);
    }

    @Test
    void testBfsTraversal() {
        var out = dfsTraversal.basicTraverse(g);
        assertArrayEquals(new Integer[]{1, 2, 5, 4, 2, 5, 4, 3, 5, 4, 2, 6, 4, 2, 5, 5, 4, 2, 6}, out.toArray());
    }

    @Test
    void testTraverseWithDiscoveryAndFinalizationTimes() {
        var out = dfsTraversal.traverseWithDiscoveryAndFinalizationTimes(g);
        var numOfVertices = out.getVertices().size();
        var discoveryTimes = new int[numOfVertices];
        var finalizationTimes = new int[numOfVertices];
        var vertices = out.getVertices();
        for (var i = 0; i < numOfVertices; i++) {
            discoveryTimes[i] = vertices.get(i).getDiscoveryTime();
            finalizationTimes[i] = vertices.get(i).getFinalizationTime();
        }
        assertArrayEquals(new int[]{1, 2, 9, 4, 3, 10}, discoveryTimes);
        assertArrayEquals(new int[]{8, 7, 12, 5, 6, 11}, finalizationTimes);
    }
}