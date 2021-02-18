package dbelousov.petprojects.challenges.binarytree;

import dbelousov.petprojects.collections.binarytree.TreeNode;
import dbelousov.petprojects.collections.binarytree.TreeUtils;

public class MaxDepth {
    private static int depth = 0;

    public static <T> int getDepth(T[] input) {
        depth = 0;

        var root = TreeUtils.parse(input);
        if (root != null) {
            preOrderTraverse(root);
        }

        return (int) (Math.log((depth + 1) * 2) / Math.log(2));
    }

    private static <T> void preOrderTraverse(TreeNode<T> root) {
        if (root.hasChildren()) {
            depth++;
        }

        for (var child : root.getChildren()) {
            preOrderTraverse(child);
        }
    }
}
