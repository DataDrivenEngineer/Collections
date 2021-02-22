package dbelousov.petprojects.challenges.arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySubarraysWithSumTest {

    @Test
    void testBinarySubarraysWithSum() {
        var solution = new BinarySubarraysWithSum(new int[] { 1, 0, 1, 0, 1 }, 2);
        assertEquals(4, solution.countSubarrays());
    }

    @Test
    void testBinarySubarraysWithEdge() {
        var solution = new BinarySubarraysWithSum(new int[] { 1 }, 2);
        assertEquals(0, solution.countSubarrays());
    }
}