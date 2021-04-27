package dbelousov.petprojects.algorithms.graph;

import dbelousov.petprojects.collections.graph.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphUtilsTest {
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
    void testTransposeGraph() {
        var bfsTraversal = new BfsTraversal<Integer>();
        var transposedGraph = GraphUtils.transposeGraph(g);
        var out = bfsTraversal.basicTraverse(transposedGraph);
        assertArrayEquals(new Integer[]{1,2,1,4,3,4,1,5,5,2,3,6,3,6}, out.toArray());
    }
}