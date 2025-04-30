package LINKEDLIST.SINGLYLINKEDLIST;

import java.util.Stack;

// Class to reverse a singly linked list using different approaches
public class ReverseSLL {

    /**
     * Reverses a singly linked list using a stack.
     * 
     * @param head The head node of the original linked list.
     * @return The new head node of the reversed linked list.
     */
    public static Node reverseBrute(Node head) {
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

    /**
     * Reverses a singly linked list using the optimized in-place approach.
     * This method uses constant extra space O(1) compared to stack-based approach.
     * 
     * @param head The head node of the original linked list.
     * @return The new head node of the reversed linked list.
     * @throws NullPointerException if head is null
     */
    public static Node reverseOptimized(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    /**
     * Reverses a singly linked list using recursion.
     * 
     * @param head The head node of the original linked list.
     * @return The new head node of the reversed linked list.
     */
    public static Node reverseRecursive(Node head) {
        // Base case: if the list is empty or has only one node, return the head
        if (head == null || head.next == null) {
            return head;
        }
        // Recursively reverse the rest of the list
        Node newHead = reverseRecursive(head.next);
        // Set the next node's next pointer to point to the current node
        Node front = head.next;
        // Set the current node's next pointer to null
        front.next = head;
        head.next = null;
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
        head = reverseRecursive(head);

        // Print the reversed linked list: should output 30 20 10
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}