package dbelousov.petprojects.challenges.arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortListWithThreeUniqueNumbersTest {

    @Test
    void testSort() {
        var in = new int[] {3, 3, 2, 1, 3, 2, 1};
        var out = SortListWithThreeUniqueNumbers.sort(in);
        assertArrayEquals(new int[] {1, 1, 2, 2, 3, 3, 3}, out);
    }
}