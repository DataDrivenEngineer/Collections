package dbelousov.petprojects.collections.hashtable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTable<K, V> {

    private static final int HASH_DIVIDER = 13;
    private static final int CAPACITY = 16;

    private final List<LinkedList<Node<K, V>>> table = new ArrayList<>(CAPACITY);

    public HashTable() {
        int i = 0;
        while(i < CAPACITY) {
            table.add(new LinkedList<>());
            i++;
        }
    }

    private int hash(K key) {
        return key.hashCode() % HASH_DIVIDER;
    }

    private int getIndex(int hash) {
        return hash % CAPACITY;
    }

    private int getIndexFromKey(K key) {
        int hash = hash(key);
        return getIndex(hash);
    }

    private V search(K key) {
        int index = getIndexFromKey(key);
        LinkedList<Node<K, V>> listAtIndex = table.get(index);
        for (Node<K, V> node : listAtIndex) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
        }
        return null;
    }

    public void to(K key, V value) {
        int index = getIndexFromKey(key);
        if (search(key) != null) {
            throw new UnsupportedOperationException("Item with the same key already exists in the table");
        }
        else {
            table.get(index).add(new Node<>(key, value));
        }
    }

    public V from(K key) {
        return search(key);
    }

    public void clear() {
        for (LinkedList<Node<K, V>> listItem : table) {
            listItem.clear();
        }
    }
}
