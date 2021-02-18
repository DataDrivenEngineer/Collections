package dbelousov.petprojects.collections.linkedlist;

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

    // region remove

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

    // endregion remove

    // region orderOddFirst

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

    // endregion orderOddFirst

    // region isPalindrome

    public boolean isPalindrome() {
        int size = getListSize();
        if (isOdd(size)) {
            return false;
        }

        int midIndex = size / 2;
        UnidirectionalNode<T> midItem = getItemAtIndex(midIndex);
        UnidirectionalNode<T> secondHead = midItem.getNext();
        midItem.setNext(null);

        UnidirectionalNode<T> reversedHead = reverse(); // reverse left half
        boolean isPalindrome = compareLists(reversedHead, secondHead);
        reverse(); // reverse left half back, restoring original list
        midItem.setNext(secondHead);

        return isPalindrome;
    }

    private int getListSize() {
        int size = 0;
        UnidirectionalNode<T> curr = this;

        while (curr != null) {
            size++;
            curr = curr.getNext();
        }

        return size;
    }

    private boolean compareLists(UnidirectionalNode<T> one, UnidirectionalNode<T> two) {
        UnidirectionalNode<T> currOne = one;
        UnidirectionalNode<T> currTwo = two;

        while (currOne != null && currTwo != null) {
            if (currOne.getValue() != currTwo.getValue()) {
                return false;
            } else {
                currOne = currOne.getNext();
                currTwo = currTwo.getNext();
            }
        }

        return true;
    }

    private UnidirectionalNode<T> reverse() {
        UnidirectionalNode<T> prev = null;
        UnidirectionalNode<T> curr = this;
        UnidirectionalNode<T> next = null;
        UnidirectionalNode<T> reversedHead = null;

        while (curr != null) {
            next = curr.getNext();
            if (next == null) {
                reversedHead = curr;
            }
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }

        return reversedHead;
    }

    // endregion isPalindrome
}
