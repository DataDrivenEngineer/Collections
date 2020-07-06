package dbelousov.petprojects.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    private final HashTable<String, String> strings = new HashTable<>();

    @BeforeEach
    void setUp() {
        strings.clear();
    }

    @Test
    void testToSuccess() {
        strings.to("a", "value a");
        strings.to("b", "value b");
        strings.to("c", "value c");

        assertEquals("value a", strings.from("a"));
        assertEquals("value b", strings.from("b"));
        assertEquals("value c", strings.from("c"));
    }

    @Test
    void testToFailure() {
        strings.to("a", "value a");
        assertThrows(UnsupportedOperationException.class, () -> strings.to("a", "value a"));
    }
}