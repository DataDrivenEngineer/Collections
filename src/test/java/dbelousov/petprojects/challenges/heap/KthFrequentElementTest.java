package dbelousov.petprojects.challenges.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthFrequentElementTest {

    @Test
    void testKthFrequentElementMany() {
        var solution = new KthFrequentElement(2, new int[] { 1, 1, 1, 2, 2, 3 });
        assertArrayEquals(new int[] { 1, 2 }, solution.getKthFrequentElement());
    }

    @Test
    void testKthFrequentElementOne() {
        var solution = new KthFrequentElement(1, new int[] { 1 });
        assertArrayEquals(new int[] { 1 }, solution.getKthFrequentElement());
    }
}