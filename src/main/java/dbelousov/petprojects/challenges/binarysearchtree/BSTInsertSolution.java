package dbelousov.petprojects.challenges.binarysearchtree;

import dbelousov.petprojects.collections.binarytree.TreeNode;

import java.util.ArrayList;

public class BSTInsertSolution {

    public static <T extends Comparable<T>> TreeNode<T> bstInsert(TreeNode<T> root, T toInsert) {
        if (root == null) {
            return null;
        }
        bstInsertInternal(root, toInsert);
        return root;
    }

    private static <T extends Comparable<T>> void bstInsertInternal(TreeNode<T> root, T toInsert) {
        if (toInsert.compareTo(root.getValue()) < 0) {
            var leftChild = root.getChildren().get(0);

            if (leftChild.getValue() == null) {
                root.getChildren().remove(0);
                root.getChildren().add(0, new TreeNode<>(toInsert, new ArrayList<>(2)));
                return;
            }

            bstInsertInternal(root.getChildren().get(0), toInsert);
        } else if (toInsert.compareTo(root.getValue()) > 0) {
            var rightChild = root.getChildren().get(1);

            if (rightChild.getValue() == null) {
                root.getChildren().remove(1);
                root.getChildren().add(1, new TreeNode<>(toInsert, new ArrayList<>(2)));
                return;
            }

            bstInsertInternal(root.getChildren().get(1), toInsert);
        }
    }
}
