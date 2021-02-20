package dbelousov.petprojects.challenges.binarysearchtree;

import dbelousov.petprojects.collections.binarytree.TreeUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTInsertSolutionTest {

    @Test
    void testBstInsertSuccess() {
        var bst = TreeUtils.parse(new Integer[]{ 4, 2, 7, 1, 3, null, null });
        var ret = BSTInsertSolution.bstInsert(bst, 5);
        System.out.println(ret);
    }

    @Test
    void testBstInsertAlreadyExists() {
        var bst = TreeUtils.parse(new Integer[]{ 4, 2, 7, 1, 3, null, null });
        var ret = BSTInsertSolution.bstInsert(bst, 3);
        System.out.println(ret);
    }
}