package dbelousov.petprojects.challenges.arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsPermutationTest {

    public static final String string1 = "sbcaxab";
    public static final String string2 = "acbxsba";
    public static final String string3 = "ncabxbs";

    @Test
    void testIsPermutation() {
        assertFalse(IsPermutation.isPermutation(string1, string3));
        assertTrue(IsPermutation.isPermutation(string1, string2));
    }
}