package dbelousov.petprojects.collections.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxStackTest {

    MaxStack stack = new MaxStack();

    @Test
    void testPush() {
        stack.push(5);
        stack.push(1);
        stack.push(5);
        assertEquals(5, stack.top());
        assertEquals(5, stack.popMax());
        assertEquals(1, stack.top());
        assertEquals(5, stack.peekMax());
        assertEquals(1, stack.pop());
        assertEquals(5, stack.top());
    }
}