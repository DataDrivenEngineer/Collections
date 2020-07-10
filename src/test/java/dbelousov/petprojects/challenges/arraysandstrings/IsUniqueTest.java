package dbelousov.petprojects.challenges.arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsUniqueTest {

    private static final String nullString = null;
    private static final String emptyString = "";
    private static final String simpleString = "abcdefgh";
    private static final String trickyString = "abcdefghh";

    @Test
    void testIsUniqueWithHashMap() {
        assertFalse(IsUnique.isUniqueWithHashMap(nullString));
        assertFalse(IsUnique.isUniqueWithHashMap(emptyString));
        assertTrue(IsUnique.isUniqueWithHashMap(simpleString));
        assertFalse(IsUnique.isUniqueWithHashMap(trickyString));
    }

    @Test
    void testIsUniqueWithArray() {
        assertFalse(IsUnique.isUniqueWithHashMap(nullString));
        assertFalse(IsUnique.isUniqueWithHashMap(emptyString));
        assertTrue(IsUnique.isUniqueWithArray(simpleString));
        assertFalse(IsUnique.isUniqueWithArray(trickyString));
    }
}