package dbelousov.petprojects.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortUtilsTest {

    @Test
    void testQuickSort() {
        var in = new Integer[] { 7, 5, 1, 5, 4, 6, 3, 5, 17, 85, -76 };
        SortUtils.quickSort(in);
        System.out.println(Arrays.toString(in));
    }
}