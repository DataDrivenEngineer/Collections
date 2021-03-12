package dbelousov.petprojects.challenges.bitmanipulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindNonDuplicateNumberTest {

    @Test
    void testFindNonDuplicateNumber() {
        var in = new int[] {4, 3, 2, 4, 1, 3, 2};
        assertEquals(1, FindNonDuplicateNumber.findNonDuplicate(in));
    }
}