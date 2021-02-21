package dbelousov.petprojects.challenges.binarysearchtree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthLargestTest {

    @Test
    void testAdd1() {
        int k = 3;
        var nums = new Integer[]{ 4, 5, 8, 2 };
        var kthLargest = new KthLargest(k, nums);
        assertEquals(4, kthLargest.add(3));
        assertEquals(5, kthLargest.add(5));
        assertEquals(5, kthLargest.add(10));
        assertEquals(8, kthLargest.add(9));
        assertEquals(8, kthLargest.add(4));
    }
}