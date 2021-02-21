package dbelousov.petprojects.collections.binarytree;

import java.lang.reflect.Array;
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

    // region helpers

    public static <T> TreeNode<T> toTree(T[] in) {
        var nodes = new HashMap<Integer, TreeNode<T>>();
        createNodes(in, nodes);
        createHierarchy(in, nodes);
        return nodes.get(0);
    }

    private static <T> void createNodes(T[] in, HashMap<Integer, TreeNode<T>> nodes) {
        for (var i = 0; i< in.length; i++) {
            var node = new TreeNode<>(in[i], new ArrayList<>(2));
            nodes.put(i, node);
        }
    }

    private static <T> void createHierarchy(T[] in, HashMap<Integer, TreeNode<T>> nodes) {
        var shiftToChildren = 1;
        for (var i = 0; i < in.length; i++) {
            if (in[i] != null) {
                var node = nodes.get(i);
                var firstChildIndex = i + shiftToChildren;
                if (firstChildIndex < in.length) {
                    var children = node.getChildren();
                    var firstChild = nodes.get(firstChildIndex);
                    var secondChild = nodes.get(firstChildIndex + 1);
                    children.add(firstChild);
                    children.add(secondChild);
                    shiftToChildren++;
                } else {
                    return;
                }
            }
        }
    }

    public static <T> T[] toArray(TreeNode<T> root) {
        if (root == null) {
            return null;
        }

        var arrSize = getTotalNodes(root);
        var arr = new ArrayList<T>(arrSize);

        var queue = new ArrayDeque<TreeNode<T>>();
        queue.add(root);
        while (queue.size() > 0) {
            var node = queue.poll();
            arr.add(node.getValue());
            for (var child : node.getChildren()) {
                queue.add(child);
            }
        }

        var retArr = (T[]) Array.newInstance(arr.get(0).getClass(), arr.size());
        return arr.toArray(retArr);
    }

    private static <T> int getTotalNodes(TreeNode<T> root) {
        var totalNodes = 0;
        return countByPreOrderTraverse(root, totalNodes);
    }

    private static <T> int countByPreOrderTraverse(TreeNode<T> root, int totalNodes) {
        if (root != null) {
            totalNodes++;
            for (var child : root.getChildren()) {
                countByPreOrderTraverse(child, totalNodes);
            }
        }
        return totalNodes;
    }

    public static <T extends Comparable<T>> TreeNode<T> toBst(T[] in) {
        if (in == null || in.length == 0) {
            return null;
        }
        return toBstInternal(in, null, 0, in.length);
    }

    private static <T extends Comparable<T>> TreeNode<T> toBstInternal(T[] in, TreeNode<T> root, int start, int end) {
        if (end - start > 2) {
            var mid = (end + start) / 2;
            root = new TreeNode<>(in[mid], new ArrayList<>(2));
            var leftChild = toBstInternal(in, root, start, mid);
            var rightChild = toBstInternal(in, root, mid + 1, end);
            root.getChildren().addAll(Arrays.asList(leftChild, rightChild));
            return root;
        } else if (end - start == 2) {
            var localChild = new TreeNode<>(in[start], new ArrayList<>(2));
            var localRoot = new TreeNode<>(in[end - 1], new ArrayList<>(2));
            localRoot.getChildren().add(0, localChild);
            return localRoot;
        } else {
            var localRoot = new TreeNode<>(in[start], new ArrayList<>(2));
            return localRoot;
        }
    }

    // endregion helpers
}
