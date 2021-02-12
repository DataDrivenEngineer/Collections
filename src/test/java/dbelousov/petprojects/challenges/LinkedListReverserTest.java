package dbelousov.petprojects.challenges;

import dbelousov.petprojects.collections.UnidirectionalNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListReverserTest {

    private final LinkedListReverser linkedListReverser = new LinkedListReverser();

    private final UnidirectionalNode<Integer> testList = new UnidirectionalNode<>(
            2,
            new UnidirectionalNode<>(1,
                    new UnidirectionalNode<>(3,
                            new UnidirectionalNode<>(5,
                                    new UnidirectionalNode<>(7,
                                            new UnidirectionalNode<>(4,
                                                    new UnidirectionalNode<>(6,
                                                            new UnidirectionalNode<>(7,null)))))))
            );

    private final UnidirectionalNode<Integer> palindromeList = new UnidirectionalNode<>(
            1,
            new UnidirectionalNode<>(2,
                    new UnidirectionalNode<>(3,
                            new UnidirectionalNode<>(4,
                                    new UnidirectionalNode<>(4,
                                            new UnidirectionalNode<>(3,
                                                    new UnidirectionalNode<>(2,
                                                            new UnidirectionalNode<>(1,null)))))))
    );

    @Test
    void testListReverseRecursivelyNullList() {
        UnidirectionalNode<?> reversedList = linkedListReverser.reverseLinkedListRecursively(new UnidirectionalNode<>(null, null));
        System.out.println("Out: " + linkedListReverser.listToString(reversedList));
    }

    @Test
    void testListReverseRecursivelySuccess() {
        System.out.println("In: " + linkedListReverser.listToString(testList));
        UnidirectionalNode<?> reversedList = linkedListReverser.reverseLinkedListRecursively(testList);
        System.out.println("Out: " + linkedListReverser.listToString(reversedList));
    }

    @Test
    void testListReversIterativelyNullList() {
        UnidirectionalNode<?> reversedList = linkedListReverser.reverseLinkedListIteratively(new UnidirectionalNode<>(null, null));
        System.out.println("Out: " + linkedListReverser.listToString(reversedList));
    }

    @Test
    void testListReverseIteratively() {
        System.out.println("In: " + linkedListReverser.listToString(testList));
        UnidirectionalNode<?> reversedList = linkedListReverser.reverseLinkedListIteratively(testList);
        System.out.println("Out: " + linkedListReverser.listToString(reversedList));
    }

    @Test
    void testListRemoveMiddleElement() {
        System.out.println("In: " + linkedListReverser.listToString(testList));
        System.out.println("Out: " + linkedListReverser.listToString(testList.remove(3)));
    }

    @Test
    void testListRemoveFirstElement() {
        System.out.println("In: " + linkedListReverser.listToString(testList));
        System.out.println("Out: " + linkedListReverser.listToString(testList.remove(1)));
    }

    @Test
    void testListRemoveLastElement() {
        System.out.println("In: " + linkedListReverser.listToString(testList));
        System.out.println("Out: " + linkedListReverser.listToString(testList.remove(5)));
    }

    @Test
    void testOrderOddFirst() {
        System.out.println("In: " + linkedListReverser.listToString(testList));
        testList.orderOddFirst();
        System.out.println("Out: " + linkedListReverser.listToString(testList));
    }

    @Test
    void testIsPalindrome() {
        assertTrue(palindromeList.isPalindrome());
    }
}