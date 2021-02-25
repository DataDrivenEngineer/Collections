package dbelousov.petprojects.challenges.binarytree;

import dbelousov.petprojects.collections.binarytree.TreeUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeafSimilarTreesTest {

    @Test
    void testAreLeafSimilar() {
        var treeArr1 = new Integer[] { 3, 5, 1, 6, 2, 9, 8 };
        var root1 = TreeUtils.toTree(treeArr1);

        var treeArr2 = new Integer[] { 3, 4, 1, 6, 2, 9, 8 };
        var root2 = TreeUtils.toTree(treeArr2);

        assertTrue(LeafSimilarTrees.areLeafSimilar(root1, root2));
    }
}