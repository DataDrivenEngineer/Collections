package dbelousov.petprojects.collections.stack;

public class MaxStack {

    private class StackNode {
        private int val = Integer.MIN_VALUE;
        private StackNode next = null;

        private StackNode() {}

        private StackNode(int val) {
            this();
            this.val = val;
        }
    }

    private StackNode head = null;

    /** initialize your data structure here. */
    public MaxStack() {

    }

    public void push(int x) {
        var node = new StackNode(x);
        if (head == null) {
            head = node;
        } else {
            var oldHead = head;
            head = node;
            head.next = oldHead;
        }
    }

    public int pop() {
        var ret = Integer.MIN_VALUE;
        if (head != null) {
            ret = head.val;
            head = head.next;
        }
        return ret;
    }

    public int top() {
        var ret = Integer.MIN_VALUE;
        if (head != null) {
            ret = head.val;
        }
        return ret;
    }

    public int peekMax() {
        var max = Integer.MIN_VALUE;
        var curr = head;
        while (curr != null) {
            if (curr.val > max) {
                max = curr.val;
            }
            curr = curr.next;
        }
        return max;
    }

    public int popMax() {
        var max = peekMax();
        var curr = head;
        StackNode prev = null;
        while (curr != null) {
            var next = curr.next;
            if (curr.val != max) {
                prev = curr;
                curr = next;
                continue;
            }
            if (curr.equals(head)) {
                head = next;
            }
            if (prev != null) {
                prev.next = next;
            }
            break;
        }
        return max;
    }
}
