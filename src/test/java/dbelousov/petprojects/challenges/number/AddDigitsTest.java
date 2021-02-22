package dbelousov.petprojects.challenges.number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddDigitsTest {

    @Test
    void testAddDigitsLow() {
        var num = 38;
        assertEquals(11, AddDigits.addDigits(num));
    }

    @Test
    void testAddDigitsHigh() {
        var num = 382635;
        assertEquals(27, AddDigits.addDigits(num));
    }
}