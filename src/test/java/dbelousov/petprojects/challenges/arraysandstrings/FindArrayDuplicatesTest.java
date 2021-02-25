package dbelousov.petprojects.challenges.arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindArrayDuplicatesTest {

    @Test
    void testFindArrayDuplicates() {
        var in = new Integer[] { 4, 3, 2, 7, 8, 2, 3, 1 };
        var out = FindArrayDuplicates.findDuplicates(in);
        assertArrayEquals(new Integer [] { 3, 2 }, out);
    }
}