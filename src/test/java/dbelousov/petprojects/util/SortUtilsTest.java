package dbelousov.petprojects.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortUtilsTest {

    @Test
    void testQuickSort() {
        var in = new Integer[] { 7, 5, 1, 5, 4, 6, 3, 5, 17, 85, -76 };
        SortUtils.quickSort(in);
        assertEquals("[-76, 1, 3, 4, 5, 5, 5, 6, 7, 17, 85]", Arrays.toString(in));
    }
}