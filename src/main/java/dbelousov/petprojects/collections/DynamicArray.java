package dbelousov.petprojects.collections;

public class DynamicArray<T> {

    private static final int EXTENSION_RATE = 2;

    private T[] elements;
    private int size;

    public DynamicArray(int capacity) {
        if (capacity < 0)
            throw new UnsupportedOperationException("Capacity must be greater or equal to 0");
        elements = (T[]) new Object[capacity];
    }

    public boolean add(int index, T item) {
        if (index < 0 || index >= elements.length || item == null) {
            return false;
        }
        elements[index] = item;
        size++;
        return true;
    }

    public boolean add(T item) {
        if (item == null) {
            return false;
        }
        if (elements.length == size) {
            elements = extendArray(elements);
        }
        return add(size, item);
    }

    private T[] extendArray(T[] oldElements) {
        T[] newElements = size == 0 ? (T[]) new Object[1] : (T[]) new Object[size * EXTENSION_RATE];
        for (int i = 0; i < size; i++) {
            newElements[i] = oldElements[i];
        }
        return newElements;
    }

    public T get(int index) {
        if (index < 0 || index >= elements.length) {
            return null;
        }
        return elements[index];
    }

    public void clear() {
        elements = (T[]) new Object[elements.length];
    }
}
