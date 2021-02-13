package dbelousov.petprojects.collections.binarytree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

class TreeUtilsTest {

    private TreeNode<Integer> treeInt;

    @BeforeEach
    void setUp() {
        ArrayList<TreeNode<Integer>> bottomLeft = new ArrayList<>();
        bottomLeft.add(new TreeNode<>(4, Collections.emptyList()));
        bottomLeft.add(new TreeNode<>(5, Collections.emptyList()));

        ArrayList<TreeNode<Integer>> bottomRight = new ArrayList<>();
        bottomRight.add(new TreeNode<>(6, Collections.emptyList()));
        bottomRight.add(new TreeNode<>(7, Collections.emptyList()));

        ArrayList<TreeNode<Integer>> mid = new ArrayList<>();
        mid.add(new TreeNode<>(2, new ArrayList<>(bottomLeft)));
        mid.add(new TreeNode<>(3, new ArrayList<>(bottomRight)));

        treeInt = new TreeNode<>(1, new ArrayList<>(mid));
    }

    @Test
    void testPreOrderTraverseRecursively() {
        TreeUtils.preOrderTraverseRecursively(treeInt);
    }

    @Test
    void testInOrderTraverseRecursively() {
        TreeUtils.inOrderTraverseRecursively(treeInt);
    }

    @Test
    void testPostOrderTraverseRecursively() {
        TreeUtils.postOrderTraverseRecursively(treeInt);
    }

    @Test
    void testLevelOrderTraverseRecursively() {
        TreeUtils.levelOrderTraverseRecursively(treeInt);
    }
}