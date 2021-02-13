package dbelousov.petprojects.collections.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

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

    public static <T> void levelOrderTraverseRecursively(TreeNode<T> root) {
        ArrayDeque<T> queue = new ArrayDeque<>();
        queue.add(root.getValue());
        traverse(root, queue);
        printQueue(queue);
    }

    private static <T> void traverse(TreeNode<T> root, ArrayDeque<T> q) {
        List<TreeNode<T>> children = root.getChildren();

        for (TreeNode<T> child : children) {
            q.add(child.getValue());
        }

        for (TreeNode<T> child : children) {
            traverse(child, q);
        }
    }

    private static <T> void printQueue(ArrayDeque<T> q) {
        while (q.peek() != null) {
            System.out.println(q.poll());
        }
    }

    // endregion recursively

    // region iteratively

    public static <T> void inOrderTraverseIteratively(TreeNode<T> root) {
        Deque<TreeNode<T>> stack = new ArrayDeque<>();
        stack.push(root);

        // Traverse and print left branch
        traverseBranch(stack);
        printBranch(stack);

        // Traverse and print right branch
        traverseBranch(stack);
        printBranch(stack);
        // Print last node
        System.out.println(stack.pop().getValue());
    }

    private static <T> void traverseBranch(Deque<TreeNode<T>> stack) {
        TreeNode<T> node = null;

        do {
            node = stack.pop();
            if (node.hasChildren()) {
                List<TreeNode<T>> children = node.getChildren();
                stack.push(children.get(1));
                stack.push(node);
                stack.push(children.get(0));
            } else {
                stack.push(node);
            }
        } while (node.hasChildren());
    }

    private static <T> void printBranch(Deque<TreeNode<T>> stack) {
        while (stack.size() > 1) {
            TreeNode<T> node = stack.pop();
            System.out.println(node.getValue());
        }
    }

    // endregion iteratively
}
