package LINKEDLIST.SINGLYLINKEDLIST;

// Add public modifier to make it accessible from other packages
public class Node {
    public int data;
    public Node next;

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