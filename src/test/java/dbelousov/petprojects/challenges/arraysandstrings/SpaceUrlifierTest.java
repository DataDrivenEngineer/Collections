package dbelousov.petprojects.challenges.arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpaceUrlifierTest {

    @Test
    void testUrlify() {
        char[] testString = "Mr John Smith    ".toCharArray();
        char[] urlifiedString = SpaceUrlifier.urlify(testString, 13);
        for (int i = 0; i < testString.length; i++) {
            assertEquals(testString[i], urlifiedString[i]);
        }
    }
}