package dbelousov.petprojects.challenges.linkedlist;

import dbelousov.petprojects.collections.linkedlist.UnidirectionalNode;

import java.util.ArrayDeque;

public class SinglyLinkedListOperations {

    public UnidirectionalNode<?> reverseLinkedListRecursively(UnidirectionalNode<?> head) {
        return reverseLinkedListRecursivelyHelper(head);
    }

    private <T> UnidirectionalNode<T> reverseLinkedListRecursivelyHelper(UnidirectionalNode<T> head) {
        if (head != null) {
            return reverseLinkedListRecursivelyImpl(head, head, head.getNext());
        }

        return null;
    }

    private <T> UnidirectionalNode<T> reverseLinkedListRecursivelyImpl(UnidirectionalNode<T> oldHead, UnidirectionalNode<T> curr, UnidirectionalNode<T> next) {
        // base case
        if (next == null) {
            oldHead.setNext(null);
            return curr;
        }

        UnidirectionalNode<T> oldNext = next.getNext();
        next.setNext(curr);

        return reverseLinkedListRecursivelyImpl(oldHead, next, oldNext);
    }

    public UnidirectionalNode<?> reverseLinkedListIteratively(UnidirectionalNode<?> head) {
        return reverseLinkedListIterativelyHelper(head);
    }

    private <T> UnidirectionalNode<T> reverseLinkedListIterativelyHelper(UnidirectionalNode<T> head) {
        if (head != null) {
            return reverseLinkedListIterativelyImpl(head, head.getNext());
        }

        return null;
    }

    private <T> UnidirectionalNode<T> reverseLinkedListIterativelyImpl(UnidirectionalNode<T> curr, UnidirectionalNode<T> next) {
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

    public String listToString(UnidirectionalNode<?> head) {
        StringBuilder sb = new StringBuilder();

        sb.append("[ ");
        sb.append(head.getValue());

        UnidirectionalNode<?> next = head.getNext();

        while (next != null) {
            sb.append(" ");
            sb.append(next.getValue());
            next = next.getNext();
        }

        sb.append(" ]");
        return sb.toString();
    }
}
