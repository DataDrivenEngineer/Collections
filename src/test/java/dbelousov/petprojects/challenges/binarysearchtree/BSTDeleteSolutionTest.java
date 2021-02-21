package dbelousov.petprojects.challenges.binarysearchtree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTDeleteSolutionTest {

    @Test
    void testDeleteSimple() {
        var inArr = new Integer[]{ 5, 3, 6, 2, 4, null, 7 };
        var outArr = BSTDeleteSolution.remove(inArr, 3);
        assertArrayEquals(new Integer[]{ 5, 4, 6, 2, null, 7 }, outArr);
    }

    @Test
    void testDeleteComplex() {
        var inArr = new Integer[]{ 15, 10, 25, 7, 12, 19, 36, 4, 8, 11, 13, null, null, null, null };
        var outArr = BSTDeleteSolution.remove(inArr, 10);
        assertArrayEquals(new Integer[]{ 15, 12, 25, 11, 13, 19, 36, 7, null, null, null, null, 4, 8 }, outArr);
    }
}