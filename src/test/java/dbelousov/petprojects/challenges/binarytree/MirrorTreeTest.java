package dbelousov.petprojects.challenges.binarytree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MirrorTreeTest {

    @Test
    void testIsMirrorTreeTrue() {
        assertTrue(MirrorTree.isMirrorTree(new Integer[] { 1, 2, 2, 3, 4, 4, 3 }));
    }

    @Test
    void testIsMirrorTreeFalse() {
        assertFalse(MirrorTree.isMirrorTree(new String[] { "1", "2", "2", "null", "3", "null", "3" }));
    }
}