package dbelousov.petprojects.challenges.binarysearchtree;

import dbelousov.petprojects.collections.binarytree.TreeUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchSolutionTest {

    @Test
    void testBinarySearch() {
        var bst = TreeUtils.parse(new String[]{ "4", "2", "6", "1", "3", "null", "null" });
        var found = BinarySearchSolution.binarySearch(bst, "2");
        System.out.println(found);
    }
}