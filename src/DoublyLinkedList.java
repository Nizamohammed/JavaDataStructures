/**
 * DoublyLinkedList.java
 *
 * Custom implementation of a doubly linked list in Java.
 * Supports operations such as insertion, deletion, search, reverse, and sorting.
 * 
 * Author: Nizam Mohammed
 */

public class DoublyLinkedList {

    private Node first;
    private Node last;
    private int size;

    // ==== Constructors ====

    public DoublyLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    // ==== Private Helpers ====

    /** Returns the node at a specific index */
    private Node nodeAt(int index) {
        if (!isValidIndex(index)) return null;
        Node p;
        if (index <= size / 2) {
            p = first;
            for (int i = 0; i < index; i++) p = p.next;
        } else {
            p = last;
            for (int i = size - 1; i > index; i--) p = p.prev;
        }
        return p;
    }

    /** Returns the node with a specific value, or null if not found */
    private Node node(int val) {
        Node p = first;
        while (p != null) {
            if (p.value == val) return p;
            p = p.next;
        }
        return null;
    }

    /** Validates if the index is within bounds */
    private boolean isValidIndex(int index) {
        return index >= 0 && index < size;
    }

    // ==== Core Operations ====

    /** Adds a value to the start of the list */
    public void addFirst(int val) {
        Node x = new Node(val);
        if (isEmpty()) {
            first = last = x;
        } else {
            x.next = first;
            first.prev = x;
            first = x;
        }
        size++;
    }

    /** Adds a value to the end of the list */
    public void addLast(int val) {
        Node x = new Node(val);
        if (isEmpty()) {
            first = last = x;
        } else {
            last.next = x;
            x.prev = last;
            last = x;
        }
        size++;
    }

    /** Adds a value at the specified index */
    public void addAt(int val, int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index out of range");

        if (index == 0) {
            addFirst(val);
        } else if (index == size) {
            addLast(val);
        } else {
            Node p = nodeAt(index);
            Node x = new Node(val);
            x.prev = p.prev;
            x.next = p;
            p.prev.next = x;
            p.prev = x;
            size++;
        }
    }

    /** Removes the first element */
    public void removeFirst() {
        if (isEmpty()) return;
        if (size == 1) {
            first = last = null;
        } else {
            first = first.next;
            first.prev = null;
        }
        size--;
    }

    /** Removes the last element */
    public void removeLast() {
        if (isEmpty()) return;
        if (size == 1) {
            first = last = null;
        } else {
            last = last.prev;
            last.next = null;
        }
        size--;
    }

    /** Removes the element at a specific index */
    public void removeAt(int index) {
        if (!isValidIndex(index)) throw new IndexOutOfBoundsException("Index out of range");

        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node p = nodeAt(index);
            p.prev.next = p.next;
            p.next.prev = p.prev;
            size--;
        }
    }

    /** Returns the value at a specific index */
    public int get(int index) {
        Node p = nodeAt(index);
        if (p == null) throw new IndexOutOfBoundsException("Index out of range");
        return p.value;
    }

    /** Updates the value at a specific index */
    public void set(int val, int index) {
        Node p = nodeAt(index);
        if (p == null) throw new IndexOutOfBoundsException("Index out of range");
        p.value = val;
    }

    /** Returns true if the list contains the value */
    public boolean contains(int val) {
        return node(val) != null;
    }

    /** Clears the entire list */
    public void clear() {
        first = last = null;
        size = 0;
    }

    /** Returns true if the list is empty */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns the index of the value, or -1 if not found */
    public int indexOf(int val) {
        Node p = first;
        for (int i = 0; p != null; i++) {
            if (p.value == val) return i;
            p = p.next;
        }
        return -1;
    }

    // ==== Utility Methods ====

    /** Reverses the linked list in place */
    public void reverse() {
        Node p = first;
        while (p != null) {
            Node temp = p.next;
            p.next = p.prev;
            p.prev = temp;
            p = temp;
        }
        Node temp = first;
        first = last;
        last = temp;
    }

    /** Sorts the linked list using merge sort */
    public void sort() {
        first = mergesort(first);
        last = nodeAt(size - 1);
    }

    private Node mergesort(Node head) {
        if (head == null || head.next == null) return head;

        Node mid = getMiddle(head);
        Node right = mid.next;
        mid.next = null;
        if (right != null) right.prev = null;

        Node leftSorted = mergesort(head);
        Node rightSorted = mergesort(right);

        return merge(leftSorted, rightSorted);
    }

    private Node merge(Node left, Node right) {
        Node head;
        if (left.value <= right.value) {
            head = left;
            left = left.next;
        } else {
            head = right;
            right = right.next;
        }
        Node tail = head;

        while (left != null && right != null) {
            if (left.value <= right.value) {
                tail.next = left;
                left.prev = tail;
                left = left.next;
            } else {
                tail.next = right;
                right.prev = tail;
                right = right.next;
            }
            tail = tail.next;
        }

        while (left != null) {
            tail.next = left;
            left.prev = tail;
            tail = left;
            left = left.next;
        }

        while (right != null) {
            tail.next = right;
            right.prev = tail;
            tail = right;
            right = right.next;
        }

        return head;
    }

    private Node getMiddle(Node head) {
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /** Prints the list in a readable format */
    public String toString() {
        if (isEmpty()) return "[ ]";
        StringBuilder sb = new StringBuilder("[ ");
        Node p = first;
        while (p != null) {
            sb.append(p.value).append(p.next != null ? ", " : " ");
            p = p.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
