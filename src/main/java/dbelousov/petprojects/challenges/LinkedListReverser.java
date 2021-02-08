package dbelousov.petprojects.challenges;

import dbelousov.petprojects.collections.UnidirectionalNode;

import java.util.ArrayDeque;

public class LinkedListReverser<T> {

    public UnidirectionalNode<T> reverseLinkedListRecursively(UnidirectionalNode<T> head) {
        if (head != null) {
            return reverseLinkedListRecursivelyHelper(head, head, head.getNext());
        }

        return null;
    }

    private UnidirectionalNode<T> reverseLinkedListRecursivelyHelper(UnidirectionalNode<T> oldHead, UnidirectionalNode<T> curr, UnidirectionalNode<T> next) {
        // base case
        if (next == null) {
            oldHead.setNext(null);
            return curr;
        }

        UnidirectionalNode<T> oldNext = next.getNext();
        next.setNext(curr);

        return reverseLinkedListRecursivelyHelper(oldHead, next, oldNext);
    }

    public UnidirectionalNode<T> reverseLinkedListIteratively(UnidirectionalNode<T> head) {
        if (head != null) {
            return reverseLinkedListIterativelyHelper(head, head.getNext());
        }

        return null;
    }

    private UnidirectionalNode<T> reverseLinkedListIterativelyHelper(UnidirectionalNode<T> curr, UnidirectionalNode<T> next) {
        ArrayDeque<UnidirectionalNode<T>> stack = new ArrayDeque<>();
        stack.push(curr);

        UnidirectionalNode<T> runningNext = next;

        while (runningNext != null) {
            stack.push(runningNext);
            runningNext = runningNext.getNext();
        }

        UnidirectionalNode<T> newHead = null;

        while (!stack.isEmpty()) {
            UnidirectionalNode<T> currentFrame = stack.pop();

            if (newHead == null) {
                newHead = currentFrame;

            }

            UnidirectionalNode<T> nextFrame = stack.peek();
            currentFrame.setNext(nextFrame);
        }

        return newHead;
    }

    public String listToString(UnidirectionalNode<T> head) {
        StringBuilder sb = new StringBuilder();

        sb.append("[ ");
        sb.append(head.getValue());

        UnidirectionalNode<T> next = head.getNext();

        while (next != null) {
            sb.append(" ");
            sb.append(next.getValue());
            next = next.getNext();
        }

        sb.append(" ]");
        return sb.toString();
    }
}
