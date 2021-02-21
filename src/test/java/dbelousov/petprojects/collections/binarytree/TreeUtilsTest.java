package dbelousov.petprojects.collections.binarytree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class TreeUtilsTest {

    private TreeNode<Integer> treeInt;

    @BeforeEach
    void setUp() {
        ArrayList<TreeNode<Integer>> bottomLeft1 = new ArrayList<>();
        bottomLeft1.add(new TreeNode<>(6, Collections.emptyList()));
        bottomLeft1.add(new TreeNode<>(7, Collections.emptyList()));

        ArrayList<TreeNode<Integer>> bottomLeft2 = new ArrayList<>();
        bottomLeft2.add(new TreeNode<>(8, Collections.emptyList()));
        bottomLeft2.add(new TreeNode<>(9, Collections.emptyList()));

        ArrayList<TreeNode<Integer>> bottomLeft = new ArrayList<>();
        bottomLeft.add(new TreeNode<>(4, bottomLeft1));
        bottomLeft.add(new TreeNode<>(5, bottomLeft2));

        ArrayList<TreeNode<Integer>> bottomRight1 = new ArrayList<>();
        bottomRight1.add(new TreeNode<>(12, Collections.emptyList()));
        bottomRight1.add(new TreeNode<>(13, Collections.emptyList()));

        ArrayList<TreeNode<Integer>> bottomRight2 = new ArrayList<>();
        bottomRight2.add(new TreeNode<>(14, Collections.emptyList()));
        bottomRight2.add(new TreeNode<>(15, Collections.emptyList()));

        ArrayList<TreeNode<Integer>> bottomRight = new ArrayList<>();
        bottomRight.add(new TreeNode<>(10, bottomRight1));
        bottomRight.add(new TreeNode<>(11, bottomRight2));

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
    void testPreOrderTraverseIteratively() {
        TreeUtils.preOrderTraverseIteratively(treeInt);
    }

    @Test
    void testPostOrderTraverseIteratively() {
        TreeUtils.postOrderTraverseIteratively(treeInt);
    }

    @Test
    void testInOrderTraverseIteratively() {
        TreeUtils.inOrderTraverseIteratively(treeInt);
    }

    @Test
    void testLevelOrderTraverse() {
        TreeUtils.levelOrderTraverse(treeInt);
    }

    @Test
    void testToArray() {
        var inArr = new Integer[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        var tree = TreeUtils.toTree(inArr);
        var arr = TreeUtils.toArray(tree);
        assertArrayEquals(inArr, arr);
    }
}