package dbelousov.petprojects.challenges.arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PerfectNumberTest {

    @Test
    void testIsPerfectNumber() {
        var in = 28;
        assertTrue(PerfectNumber.isPerfectNumber(in));
    }

    @Test
    void testIsNotPerfectNumber() {
        var in = 29;
        assertFalse(PerfectNumber.isPerfectNumber(in));
    }
}