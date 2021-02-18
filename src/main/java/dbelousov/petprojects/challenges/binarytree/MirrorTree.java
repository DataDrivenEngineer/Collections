package dbelousov.petprojects.challenges.binarytree;

import dbelousov.petprojects.collections.binarytree.TreeNode;
import dbelousov.petprojects.collections.binarytree.TreeUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class MirrorTree {

    public static <T> boolean isMirrorTree(T[] in) {
        var root = TreeUtils.parse(in);

        var q = new ArrayDeque<TreeNode<T>>();
        if (root != null) {
            q.add(root);
            return levelOrderTraverse(root, q);
        }

        return false;
    }

    private static <T> boolean levelOrderTraverse(TreeNode<T> root, Deque<TreeNode<T>> q) {
        while (q.size() > 0) {
            var curLevel = new ArrayList<TreeNode<T>>();
            while (q.size() > 0) {
                curLevel.add(q.poll());
            }

            if (isSymmetric(root, curLevel)) {
                for (var node : curLevel) {
                    var ch = node.getChildren();
                    for (var child : ch) {
                        q.add(child);
                    }
                }
            } else {
                return false;
            }
        }

        return true;
    }

    private static <T> boolean isSymmetric(TreeNode<T> root, ArrayList<TreeNode<T>> in) {
        if (in.get(0).equals(root)) {
            return true;
        }

        if (in.size() % 2 != 0) {
            return false;
        }

        var mid = in.size() / 2;
        var stack = new ArrayDeque<TreeNode<T>>();

        for (var i = 0; i < mid; i++) {
            stack.push(in.get(i));
        }

        for (var i = mid; i < in.size(); i++) {
            var fromStack = stack.pop();
            if (!fromStack.getValue().equals(in.get(i).getValue())) {
                return false;
            }
        }

        return true;
    }
}
