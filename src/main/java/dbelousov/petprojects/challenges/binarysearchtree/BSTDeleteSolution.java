package dbelousov.petprojects.challenges.binarysearchtree;

import dbelousov.petprojects.collections.binarytree.TreeNode;
import dbelousov.petprojects.collections.binarytree.TreeUtils;

import java.util.ArrayList;

public class BSTDeleteSolution {

    public static <T extends Comparable<T>> T[] remove(T[] in, T toRemove) {
        var root = TreeUtils.toTree(in);
        var found = binarySearch(root, root, toRemove);
        var toRemoveNode = found.get(0);
        var toRemoveParent = found.get(1);
        var newLocalParent = updateChildrenAndGetNewParent(toRemoveNode);
        toRemoveParent.getChildren().replaceAll(ch -> {
            if (ch.equals(toRemoveNode)) {
                return newLocalParent;
            }
            return ch;
        });
        return TreeUtils.toArray(root);
    }

    private static <T extends Comparable<T>>TreeNode<T> updateChildrenAndGetNewParent(TreeNode<T> node) {
        if (!node.hasChildren()) {
            return null;
        }

        var leftChild = node.getChildren().get(0);
        var rightChild = node.getChildren().get(1);
        if (rightChild != null) {
            if (rightChild.hasChildren()) {
                var ch = rightChild.getChildren();
                var leftmostChild = ch.get(0);
                while (ch.size() > 0) {
                    leftmostChild = ch.get(0);
                    ch = leftmostChild.getChildren();
                }
                if (leftmostChild != null) {
                    leftmostChild.getChildren().add(0, leftChild);
                }
            } else {
                rightChild.getChildren().add(0, leftChild);
            }
            return rightChild;
        }
        return leftChild;
    }

    private static <T extends Comparable<T>> ArrayList<TreeNode<T>> binarySearch(TreeNode<T> root, TreeNode<T> rootParent, T toRemove) {
        if (root == null) {
            return null;
        }

        var ret = new ArrayList<TreeNode<T>>(2);

        if (root.getValue().equals(toRemove)) {
            ret.add(0, root);
            ret.add(1, rootParent);
            return ret;
        }

        if (toRemove.compareTo(root.getValue()) < 0) {
            return binarySearch(root.getChildren().get(0), root, toRemove);
        } else {
            return binarySearch(root.getChildren().get(1), root, toRemove);
        }
    }


}
