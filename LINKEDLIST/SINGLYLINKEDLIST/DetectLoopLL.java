package LINKEDLIST.SINGLYLINKEDLIST;

import java.util.HashMap;

public class DetectLoopLL {
    // Approach 01 : This is brute force approach where the problem is being solved
    // with an extra space. TC & SC of this solution is O(n).
    public static boolean detectLoopBrute(Node head) {
        HashMap<Node, Integer> map = new HashMap<>();
        Node temp = head;

        while (temp != null) {
            if (map.containsKey(temp)) {
                return true;
            }

            map.put(temp, 1);
            temp = temp.next;
        }

        return false;
    }

    // Approach 02 : This is an optimized approach where the problem is being solved
    // without any extra space. Time Complexity of this solution is O(n). This
    // approach is using tortoise and hare algorithm.
    // The idea is to use two pointers, one moving at twice the speed of the other.
    public static boolean detectLoopOpt(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);
        Node fifth = new Node(50);

        // Connect the nodes to form a singly linked list
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = second; // Creating a loop

        System.out.println("Detect Loop (Brute Force): " + detectLoopBrute(head));
        System.out.println("Detect Loop (Optimized): " + detectLoopOpt(head));
    }
}
