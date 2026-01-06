public class linkedList {
    class Node {
        int val;  
        Node next;  

        // Constructor 
        public Node(int val) {
            this.val = val;
            this.next = null;  // Initially, no next node 
        }
    }

    private Node head;  // The head of the linked list (the first node).

    // Constructor to initialize the linked list.
    public linkedList() {
        head = null;  // Initially, the list is empty (head is null).
    }
//Method - Search
    // Get the value of the node at the given index. Return -1 if the index is invalid.
    public int get(int index) {
        Node current = head;  // Start from the head of the list.
        int count = 0;  // Counter to keep track of the current node's index.

        // Loop through the list until we reach the desired index.
        while (current != null) {
            if (count == index) {
                return current.val;  // Return the value if we find the node.
            }
            count++;  
            current = current.next;  // Move to the next node.
        }
        return -1;  // Return -1 if the index is out of range.
    }
//Method - add at head
    // Add a node at the beginning (head) of the list.
    public void addAtHead(int val) {
        Node newNode = new Node(val);  // Create a new node 
        newNode.next = head;  // Point the new node to the current head.
        head = newNode;  // Make the new node the new head of the list.
    }
//Method - add at tail
    // Add a node at the end (tail) of the list.
    public void addAtTail(int val) {
        Node newNode = new Node(val);  // Create a new node with the given value.
        if (head == null) {  // If the list is empty, make the new node the head.
            head = newNode;
            return;
        }
        Node current = head;  // Start from the head of the list.
        // Loop through the list to find the last node.
        while (current.next != null) {
            current = current.next;  // Move to the next node.
        }
        current.next = newNode;  // Make the last node's next pointer point to the new node.
    }

    //Method -  Add a node at the specified index in the list.
    public void addAtIndex(int index, int val) {
        if (index < 0) return;  // If the index is negative, return.

        Node newNode = new Node(val);  // Create a new node
        if (index == 0) {  // If we want to add the node at the beginning (head).
            newNode.next = head;  // Point the new node to the current head.
            head = newNode;  // Make the new node the head of the list.
            return;
        }

        Node current = head;
        // Loop through the list to find the node just before the index.
        for (int i = 0; i < index - 1; i++) {
            if (current == null) return;  // If the index is out of range, do nothing.
            current = current.next;  // Move to the next node.
        }
 if (current == null) return;
        // Now, insert the new node at the given index.
        newNode.next = current.next;  // Point the new node to the next node.
        current.next = newNode;  // Link the current node to the new node.
    }
//EdgeCase: If current == null after the loop, it indicates that the index is out of bounds, so the method exits without performing any further operations.
    // Method - Delete the node at the specified index.
    public void deleteAtIndex(int index) {
        if (index < 0 || head == null) return;  // If the index is invalid or the list is empty, do nothing.

        if (index == 0) {  // If we want to delete the head (first node).
            head = head.next;  // Make the second node the new head.
            return;
        }

        Node current = head;
        // Loop through the list to find the node just before the node to be deleted.
        for (int i = 0; i < index - 1; i++) {
            if (current == null || current.next == null) return;  // If the index is out of range, do nothing.
            current = current.next;  // Move to the next node.
        }

        // Now, delete the node by skipping over it.
  if (current.next != null) {
        current.next = current.next.next;  // Set the current node’s 'next' to skip over the node to be deleted.
    }
    }



// Main method to run the code
public static void main(String[] args) {
    linkedList list = new linkedList();

    // Adding elements to the linked list
    list.addAtHead(1);
    list.addAtTail(2);
    list.addAtTail(3);
    
    // Print values at different indices
    System.out.println("Value at index 0: " + list.get(0)); // Expected: 1
    System.out.println("Value at index 1: " + list.get(1)); // Expected: 2
    System.out.println("Value at index 2: " + list.get(2)); // Expected: 3

    // Add element at specific index and print
    list.addAtIndex(1, 5);
    System.out.println("Value at index 1 after insertion: " + list.get(1)); // Expected: 5

    // Delete element at specific index and print
    list.deleteAtIndex(1);
    System.out.println("Value at index 1 after deletion: " + list.get(1)); // Expected: 2
}
}

