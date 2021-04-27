package dbelousov.petprojects.algorithms.graph;

import dbelousov.petprojects.collections.graph.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DfsTraversalTest {
    private Graph<Integer> g;

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
        var dfsTraversal = new DfsTraversal();
        var out = dfsTraversal.traverse(g);
        assertArrayEquals(new Integer[]{1, 2, 5, 4, 2, 5, 4, 3, 5, 4, 2, 6, 4, 2, 5, 5, 4, 2, 6}, out.toArray());
    }
}