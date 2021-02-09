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

    public void orderOddFirst() {
        int loi = getLastOddIndex();
        int numOfSwaps = 0;

        while (numOfSwaps < getLastOddIndex() / 2) {
            insertAfterFirst(getItemAtIndex(loi - 1), getItemAtIndex(loi));
            loi -= 1;
            numOfSwaps++;
        }
    }

    private int getLastOddIndex() {
        UnidirectionalNode<T> curr = this;
        int currIndex = 1;
        int loi = 1;

        while (curr != null) {
            if (isOdd(currIndex)) {
                loi = currIndex;
            }
            curr = curr.getNext();
            currIndex++;
        }

        return loi;
    }

    private boolean isOdd(int value) {
        return value % 2 != 0;
    }

    private UnidirectionalNode<T> getItemAtIndex(int ind) {
        int currInd = 1;
        UnidirectionalNode<T> curr = this;

        while (curr != null) {
            if (currInd == ind) {
                return curr;
            }
            curr = curr.getNext();
            currInd++;
        }

        return null;
    }

    private void insertAfterFirst(UnidirectionalNode<T> prev, UnidirectionalNode<T> curr) {
        prev.setNext(curr.getNext());
        curr.setNext(this.getNext());
        this.setNext(curr);
    }
}
