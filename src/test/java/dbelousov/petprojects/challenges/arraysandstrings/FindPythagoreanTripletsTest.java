package dbelousov.petprojects.challenges.arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindPythagoreanTripletsTest {

    @Test
    void testFindTriplets() {
        var in = new int[]{ 3, 5, 5, 6, 7, 12, 13, 13 };
        var out = FindPythagoreanTriplets.findTriplets(in);
        var firstTriplet = out.get(0);
        assertArrayEquals(new Integer[]{ 5, 12, 13 }, firstTriplet.toArray());
    }
}