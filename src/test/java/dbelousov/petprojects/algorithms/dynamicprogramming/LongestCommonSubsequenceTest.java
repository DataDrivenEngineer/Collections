package dbelousov.petprojects.algorithms.dynamicprogramming;

import dbelousov.petprojects.algorithms.dynamicprogramming.LongestCommonSubsequence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonSubsequenceTest {

    private LongestCommonSubsequence lcs;

    @BeforeEach
    void setUp() {
        lcs = new LongestCommonSubsequence();
    }

    @Test
    void test() {
        var s1 = "abcbdab";
        var s2 = "bdcaba";
        assertEquals("bcba", lcs.calculateLcs(s1, s2));
    }

    @Test
    void testMemoized() {
        var s1 = "abcbdab";
        var s2 = "bdcaba";
        assertEquals("bcba", lcs.calculateLcsMemoized(s1, s2));
    }
}