package dbelousov.petprojects.challenges.binarysearchtree;

import dbelousov.petprojects.collections.binarytree.TreeNode;
import dbelousov.petprojects.collections.binarytree.TreeUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class KthLargest {
    private int k;
    private final TreeNode<Integer> root;
    private TreeNode<Integer> previousNode;
    private int firstLargest = Integer.MIN_VALUE;
    private int kthLargest = Integer.MIN_VALUE;

    public KthLargest(int k, Integer[] nums) {
        this.k = k;
        Arrays.sort(nums);
        this.root = TreeUtils.toBst(nums);
    }

    public int add(int num) {
        var isAdded = addToBst(num);
        if (!isAdded) {
            k--;
        }
        getFirstLargest(root);
        kthLargest = firstLargest;
        for (var i = 1; i < k; i++) {
            inOrderTraverse(root);
        }
        if (!isAdded) {
            k++;
        }
        return kthLargest;
    }

    private void inOrderTraverse(TreeNode<Integer> root) {
        var children = root.getChildren();
        if (!children.isEmpty() && children.get(0) != null) {
            inOrderTraverse(children.get(0));
        }
        if (root.getValue() == kthLargest) {
            kthLargest = previousNode.getValue();
        }
        previousNode = root;
        if (children.size() > 1 && children.get(1) != null) {
            inOrderTraverse(children.get(1));
        }
    }

    private boolean addToBst(int num) {
        return addToBstInternal(root, num);
    }

    private boolean addToBstInternal(TreeNode<Integer> root, int num) {
        if (num < root.getValue()) {
            var hasLeftChild = root.getChildren().size() > 0;
            if (!hasLeftChild) {
                var node = new TreeNode<>(num, new ArrayList<>(2));
                root.getChildren().add(0, node);
            } else {
                addToBstInternal(root.getChildren().get(0), num);
            }
        } else if (num > root.getValue()) {
            var hasRightChild = root.getChildren().size() > 1;
            if (!hasRightChild) {
                var node = new TreeNode<>(num, new ArrayList<>(2));
                root.getChildren().add(0, null);
                root.getChildren().add(1, node);
            } else {
                addToBstInternal(root.getChildren().get(1), num);
            }
        } else {
            return false;
        }
        return true;
    }

    private void getFirstLargest(TreeNode<Integer> root) {
        var children = root.getChildren();

        if (!children.isEmpty() && children.get(0) != null) {
            getFirstLargest(children.get(0));
        }
        firstLargest = root.getValue();
        if (children.size() > 1 && children.get(1) != null) {
            getFirstLargest(children.get(1));
        }
    }
}
