package dbelousov.petprojects.collections.binarytree;

import java.util.*;

public class TreeUtils {

    // region recursively

    public static <T> void preOrderTraverseRecursively(TreeNode<T> root) {
        System.out.println(root.getValue());

        for (TreeNode<T> child : root.getChildren()) {
            preOrderTraverseRecursively(child);
        }
    }

    public static <T> void inOrderTraverseRecursively(TreeNode<T> root) {
        List<TreeNode<T>> children = root.getChildren();

        if (!children.isEmpty() && children.get(0) != null) {
            inOrderTraverseRecursively(children.get(0));
        }

        System.out.println(root.getValue());

        if (!children.isEmpty() && children.get(1) != null) {
            inOrderTraverseRecursively(children.get(1));
        }
    }

    public static <T> void postOrderTraverseRecursively(TreeNode<T> root) {
        for (TreeNode<T> child : root.getChildren()) {
            postOrderTraverseRecursively(child);
        }

        System.out.println(root.getValue());
    }

    // endregion recursively

    // region iteratively

    public static <T> void preOrderTraverseIteratively(TreeNode<T> root) {
        Deque<TreeNode<T>> stack = new ArrayDeque<>();
        stack.push(root);

        while (stack.size() > 0) {
            TreeNode<T> node = stack.pop();
            System.out.println(node.getValue());
            for (TreeNode<T> child : reverse(node.getChildren())) {
                stack.push(child);
            }
        }
    }

    private static <T> List<TreeNode<T>> reverse(List<TreeNode<T>> in) {
        List<TreeNode<T>> out = new ArrayList<>();

        for (int i = in.size() - 1; i >= 0; i--) {
            out.add(in.get(i));
        }

        return out;
    }

    public static <T> void postOrderTraverseIteratively(TreeNode<T> root) {
        var stack = new ArrayDeque<TreeNode<T>>();
        stack.push(root);

        var visited = new HashMap<TreeNode<T>, Boolean>();

        while (stack.size() > 0) {
            var node = stack.peek();
            if (node.hasChildren() && !visited.containsKey(node)) {
                for (var child : reverse(node.getChildren())) {
                    stack.push(child);
                    visited.put(node, true);
                }
            } else {
                System.out.println(node.getValue());
                stack.pop();
            }
        }
    }

    public static <T> void inOrderTraverseIteratively(TreeNode<T> root) {
        var stack = new ArrayDeque<TreeNode<T>>();
        stack.push(root);

        var visited = new HashMap<TreeNode<T>, Boolean>();

        while (stack.size() > 0) {
            var node = stack.pop();
            if (node.hasChildren() && !visited.containsKey(node)) {
                var ch = node.getChildren();
                for (var child : reverse(getSecondHalf(ch))) {
                    stack.push(child);
                }

                visited.put(node, true);

                stack.push(node);
                for (var child : reverse(getFirstHalf(ch))) {
                    stack.push(child);
                }
            } else {
                System.out.println(node.getValue());
            }
        }
    }

    private static <T> List<TreeNode<T>> getFirstHalf(List<TreeNode<T>> in) {
        var out = new ArrayList<TreeNode<T>>();

        for (int i = 0; i < in.size() / 2; i++) {
            out.add(in.get(i));
        }

        return out;
    }

    private static <T> List<TreeNode<T>> getSecondHalf(List<TreeNode<T>> in) {
        var out = new ArrayList<TreeNode<T>>();

        for (int i = in.size() / 2; i < in.size(); i++) {
            out.add(in.get(i));
        }

        return out;
    }

    public static <T> void levelOrderTraverse(TreeNode<T> root) {
        var q = new ArrayDeque<TreeNode<T>>();
        q.add(root);

        while (q.size() > 0) {
            var node = q.poll();
            System.out.println(node.getValue());

            for (var child : node.getChildren()) {
                q.add(child);
            }
        }
    }

    // endregion iteratively
}
