package ds;
/**
 * Node.java
 *
 * Internal node class for use in DoublyLinkedList.
 * Each node holds an integer value and links to the next and previous nodes.
 *
 * Author: Nizam Mohammed
 */
class Node {
    int value;
    Node next;
    Node prev;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
