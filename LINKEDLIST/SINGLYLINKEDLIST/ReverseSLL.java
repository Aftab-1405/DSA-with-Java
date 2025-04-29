package LINKEDLIST.SINGLYLINKEDLIST;

import java.util.Stack;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    // Add toString() method to properly print the node
    @Override
    public String toString() {
        return String.valueOf(this.data);
    }
}

// Class to reverse a singly linked list using a stack (brute force approach)
public class ReverseSLL {

    /**
     * Reverses a singly linked list using a stack.
     * 
     * @param head The head node of the original linked list.
     * @return The new head node of the reversed linked list.
     */
    public static Node reverse(Node head) {
        // If the list is empty, return null
        if (head == null) {
            return null;
        }
        // Create a stack to store nodes of the linked list
        Stack<Node> stack = new Stack<>();
        Node temp = head;
        // Traverse the linked list and push all nodes onto the stack
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        // Pop the top node from the stack, which will be the new head
        Node newHead = stack.pop();
        Node current = newHead;
        // Pop remaining nodes and link them in reverse order
        while (!stack.isEmpty()) {
            current.next = stack.pop();
            current = current.next;
        }
        // Set the next of the last node to null to terminate the reversed list
        current.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        // Example usage:

        // Create nodes of the linked list
        Node head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);

        // Link the nodes together: 10 -> 20 -> 30
        head.next = second;
        second.next = third;

        // Reverse the linked list using the reverse method
        head = reverse(head);

        // Print the reversed linked list: should output 30 20 10
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
