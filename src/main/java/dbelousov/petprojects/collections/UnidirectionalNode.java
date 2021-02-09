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

    public UnidirectionalNode<T> remove(T value) {
        if (isValid(value)) {
            if (this.getValue().equals(value)) {
                return this.getNext(); // remove 1st
            } else {
                UnidirectionalNode<T> curr = this;
                while (curr.getNext() != null) {
                    if (curr.getNext().getValue().equals(value)) {
                        curr.setNext(curr.getNext().getNext());
                    } else {
                        curr = curr.getNext();
                    }
                }
            }
        }
        return this;
    }

    private boolean isValid(T value) {
        return value != null;
    }
}
