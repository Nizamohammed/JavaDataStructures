package ds;
/**
 * DynamicArray.java
 * 
 * A simplified generic implementation of a dynamic array (similar to Java's ArrayList).
 * Supports automatic resizing, insertion, deletion, and dynamic shrinking/growing.
 * 
 * Author: Nizam Mohammed
 */

public class DynamicArray<T> {
    private int size = 0;
    private int capacity = 10;
    private Object[] array;

    // Constructors
    public DynamicArray() {
        array = new Object[capacity];
    }

    public DynamicArray(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        this.capacity = initialCapacity;
        this.array = new Object[capacity];
    }

    // Add an element to the end
    public void add(T element) {
        if (size >= capacity) grow();
        array[size++] = element;
    }

    // Insert at specific index
    public void insert(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (size >= capacity) grow();
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    // Remove the last element
    public void pop() {
        if (isEmpty()) return;
        array[--size] = null;
        if (size <= capacity / 3) shrink();
    }

    // Delete at specific index
    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
        if (size <= capacity / 3) shrink();
    }

    // Resize array to double the capacity
    private void grow() {
        capacity *= 2;
        Object[] newArray = new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    // Shrink array to half the capacity
    private void shrink() {
        capacity = Math.max(10, capacity / 2);
        Object[] newArray = new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    // Convert array to string
    @Override
    public String toString() {
        if (isEmpty()) return "[ ]";
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append(" ]");
        return sb.toString();
    }

    // Check if array is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Optional: Get element at index
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        return (T) array[index];
    }

    // Optional: Get current size
    public int size() {
        return size;
    }

    // Optional: Get current capacity
    public int capacity() {
        return capacity;
    }
}
