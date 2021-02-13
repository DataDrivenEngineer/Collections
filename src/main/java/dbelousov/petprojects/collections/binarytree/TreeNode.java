package dbelousov.petprojects.collections.binarytree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {

    private T value;
    private final List<TreeNode<T>> children;

    public TreeNode(T value, List<TreeNode<T>> children) {
        this.value = value;
        this.children = new ArrayList<>(children);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    public boolean hasChildren() {
        return !children.isEmpty();
    }
}
