package dbelousov.petprojects.algorithms.graph;

import dbelousov.petprojects.collections.graph.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BfsTraversalTest {
    private Graph g;

    @BeforeEach
    void setUp() {
        var numOfVertices = 6;
        var firstV = new LinkedList<>(Arrays.asList(2, 4));
        var secondV = new LinkedList<>(Arrays.asList(5));
        var thirdV = new LinkedList<>(Arrays.asList(5, 6));
        var fourthV = new LinkedList<>(Arrays.asList(2));
        var fifthV = new LinkedList<>(Arrays.asList(4));
        var sixthV = new LinkedList<>(Arrays.asList(6));
        var adjacencyList = new LinkedList<LinkedList<Integer>>();
        adjacencyList.add(firstV);
        adjacencyList.add(secondV);
        adjacencyList.add(thirdV);
        adjacencyList.add(fourthV);
        adjacencyList.add(fifthV);
        adjacencyList.add(sixthV);
        g = new Graph(numOfVertices, adjacencyList);
    }

    @Test
    void testBfsTraversal() {
        var bfsTraversal = new BfsTraversal();
        bfsTraversal.traverse(g);
    }
}