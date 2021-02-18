package dbelousov.petprojects.collections.array;

import dbelousov.petprojects.collections.array.DynamicArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayTest {
    
     private DynamicArray<Integer> integers;

    @BeforeEach
    void setUp() {
        integers = new DynamicArray<>(0);
        integers.add(4);
        integers.add(3);
        integers.add(2);
    }

    @Test
    void testAddAndGet() {
        assertEquals(3, integers.get(1));
        assertEquals(4, integers.get(0));
        assertEquals(2, integers.get(2));

        integers.add(1, 5);
        assertEquals(5, integers.get(1));
    }

    @Test
    void testClear() {
        integers.clear();
        assertNull(integers.get(0));
    }
}