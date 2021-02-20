package dbelousov.petprojects.challenges.binarysearchtree;

import dbelousov.petprojects.collections.binarytree.TreeNode;

public class BinarySearchSolution {

    public static <T extends Comparable<T>> TreeNode<T> binarySearch(TreeNode<T> root, T searchValue) {
        if (root == null) {
            return null;
        }

        if (searchValue.equals(root.getValue())) {
            return root;
        }

        if (searchValue.compareTo(root.getValue()) < 0) {
            return binarySearch(root.getChildren().get(0), searchValue);
        } else {
            return binarySearch(root.getChildren().get(1), searchValue);
        }
    }
}
