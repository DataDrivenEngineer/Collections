package dbelousov.petprojects.algorithms.graph;

import dbelousov.petprojects.collections.graph.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StronglyConnectedComponentsTest {
    private Graph<Integer> g;
    private final StronglyConnectedComponents<Integer> stronglyConnectedComponents = new StronglyConnectedComponents<>();

    @BeforeEach
    void setUp() {
        var vertices = new Integer[]{1,2,3,4,5,6};
        var edges = new Integer[][]{
                {2,4}, {5}, {5,6}, {2}, {4}, {6}
        };
        g = GraphUtils.makeGraph(vertices, edges);
    }

    @Test
    void testSplit() {
        var out = stronglyConnectedComponents.split(g);
        assertEquals("[[1], [3], [6], [2, 4, 5]]", out.toString());
    }
}