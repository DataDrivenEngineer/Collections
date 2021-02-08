package dbelousov.petprojects.collections;

public class UnidirectionalNode<T> {

    private T value;
    private UnidirectionalNode<T> next;

    public UnidirectionalNode(T value, UnidirectionalNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public UnidirectionalNode<T> getNext() {
        return next;
    }

    public void setNext(UnidirectionalNode<T> next) {
        this.next = next;
    }
}
