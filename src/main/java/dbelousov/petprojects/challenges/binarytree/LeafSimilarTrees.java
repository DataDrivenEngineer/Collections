package dbelousov.petprojects.challenges.binarytree;

import dbelousov.petprojects.collections.binarytree.TreeNode;

import java.util.ArrayList;

public class LeafSimilarTrees {

    public static <T> boolean areLeafSimilar(TreeNode<T> root1, TreeNode<T> root2) {
        var leavesOne = getLeaves(root1);
        var leavesTwo = getLeaves(root2);
        return leavesOne.equals(leavesTwo);
    }

    private static <T>ArrayList<T> getLeaves(TreeNode<T> root) {
        var leaves = getLeavesHelper(root, new ArrayList<T>());
        return leaves;
    }

    private static <T> ArrayList<T> getLeavesHelper(TreeNode<T> root, ArrayList<T> leaves) {
        if (root.hasChildren()) {
            for (var child : root.getChildren()) {
                getLeavesHelper(child, leaves);
            }
        } else {
            leaves.add(root.getValue());
        }
        return leaves;
    }
}
