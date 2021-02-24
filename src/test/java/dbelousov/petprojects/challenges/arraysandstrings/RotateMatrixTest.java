package dbelousov.petprojects.challenges.arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateMatrixTest {

    @Test
    void testRotateN3() {
        var matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        var solution = new RotateMatrix(matrix, 3);

        solution.rotate();

        var expected = new int[][] { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } };
        assertArrayEquals(expected, matrix);
    }

    @Test
    void testRotateN4() {
        var matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        var solution = new RotateMatrix(matrix, 4);

        solution.rotate();

        var expected = new int[][] { { 13, 9, 5, 1 }, { 14, 10, 6, 2 }, { 15, 11, 7, 3 }, { 16, 12, 8, 4 } };
        assertArrayEquals(expected, matrix);
    }
}