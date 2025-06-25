package ds;

/**
 * Main.java
 *
 * Entry point to demonstrate and test the functionality of DynamicArray.
 * Includes grow/shrink behavior, insertion, deletion, and access.
 *
 * Author: Nizam Mohammed
 */

public class Main {
    public static void main(String[] args) {
    	
    	// === Testing DynamicArray ===
        System.out.println("=== DynamicArray Tests ===");
        DynamicArray<Integer> arr = new DynamicArray<>(4);  // Start with small capacity for easy grow/shrink

        System.out.println("🔧 Initializing DynamicArray with capacity 4");
        System.out.println("Initial capacity: " + arr.capacity());
        System.out.println("Initial size: " + arr.size());

        // Trigger grow
        System.out.println("\n➕ Adding elements to trigger growth...");
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);  // Should fill it
        System.out.println("After 4 adds: " + arr);
        System.out.println("Capacity: " + arr.capacity()); // Should be 4

        arr.add(5);  // Should trigger grow to 8
        System.out.println("Added 5th element to trigger grow:");
        System.out.println("Current array: " + arr);
        System.out.println("Capacity after grow: " + arr.capacity());

        // Trigger shrink
        System.out.println("\n❌ Removing elements to trigger shrink...");
        arr.pop();  // removes 5
        arr.pop();  // removes 4
        arr.pop();  // removes 3
        System.out.println("After popping 3 times:");
        System.out.println("Current array: " + arr);
        System.out.println("Capacity after shrink check: " + arr.capacity());  // Should shrink to 4 again

        // Normal operations
        System.out.println("\n📤 Insert and delete test:");
        arr.insert(1, 99);  // [1, 99, 2]
        System.out.println("After insert at index 1: " + arr);

        arr.delete(0);  // delete 1
        System.out.println("After deleting index 0: " + arr);

        // Final report
        System.out.println("\n📏 Final size: " + arr.size());
        System.out.println("📦 Final capacity: " + arr.capacity());
        System.out.println("✅ DynamicArray tests completed.");
        
        
        
        
        
     // === Testing DoublyLinkedList ===
        System.out.println("\n=== DoublyLinkedList Tests ===");
        DoublyLinkedList list = new DoublyLinkedList();

        // Add elements
        list.addFirst(10);
        list.addLast(20);
        list.addAt(15, 1);  // Insert 15 at index 1
        list.addLast(25);
        list.addFirst(5);

        System.out.println("List after adds: " + list);

        // Get and set
        System.out.println("Element at index 2: " + list.get(2));  // should be 15
        list.set(17, 2);
        System.out.println("After setting index 2 to 17: " + list);

        // Contains & indexOf
        System.out.println("Contains 20? " + list.contains(20));
        System.out.println("Index of 25: " + list.indexOf(25));

        // Remove elements
        list.removeFirst();
        System.out.println("After removeFirst(): " + list);

        list.removeLast();
        System.out.println("After removeLast(): " + list);

        list.removeAt(1);
        System.out.println("After removeAt(1): " + list);

        // Reverse list
        list.reverse();
        System.out.println("After reverse(): " + list);

        // Sort list
        list.addLast(12);
        list.addLast(3);
        list.addLast(30);
        System.out.println("Before sort: " + list);

        list.sort();
        System.out.println("After sort: " + list);

        // Clear list
        list.clear();
        System.out.println("After clear(): " + list);
        System.out.println("Is empty? " + list.isEmpty());
    }
}