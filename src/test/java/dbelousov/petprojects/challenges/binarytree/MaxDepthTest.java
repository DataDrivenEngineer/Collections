package dbelousov.petprojects.challenges.binarytree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxDepthTest {

    @Test
    void testGetMaxDepth() {
        assertEquals(5, MaxDepth.getDepth(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
                16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 }));
    }
}