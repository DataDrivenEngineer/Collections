package dbelousov.petprojects.challenges;

import dbelousov.petprojects.collections.UnidirectionalNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListReverserTest {

    private final LinkedListReverser<Integer> linkedListReverser = new LinkedListReverser<>();

    private final UnidirectionalNode<Integer> testList = new UnidirectionalNode<>(
            1,
            new UnidirectionalNode<>(2,
                    new UnidirectionalNode<>(3,
                            new UnidirectionalNode<>(4,
                                    new UnidirectionalNode<>(5, null))))
            );

    @Test
    void testListReverseRecursivelyNullList() {
        UnidirectionalNode<Integer> reversedList = linkedListReverser.reverseLinkedListRecursively(new UnidirectionalNode<>(null, null));
        System.out.println("Out: " + linkedListReverser.listToString(reversedList));
    }

    @Test
    void testListReverseRecursivelySuccess() {
        System.out.println("In: " + linkedListReverser.listToString(testList));
        UnidirectionalNode<Integer> reversedList = linkedListReverser.reverseLinkedListRecursively(testList);
        System.out.println("Out: " + linkedListReverser.listToString(reversedList));
    }

    @Test
    void testListReversIterativelyNullList() {
        UnidirectionalNode<Integer> reversedList = linkedListReverser.reverseLinkedListIteratively(new UnidirectionalNode<>(null, null));
        System.out.println("Out: " + linkedListReverser.listToString(reversedList));
    }

    @Test
    void testListReverseIteratively() {
        System.out.println("In: " + linkedListReverser.listToString(testList));
        UnidirectionalNode<Integer> reversedList = linkedListReverser.reverseLinkedListIteratively(testList);
        System.out.println("Out: " + linkedListReverser.listToString(reversedList));
    }
}