package LINKEDLIST.SINGLYLINKEDLIST;

import java.util.HashMap;

public class LengthOfLoop {
    // Approach 01 : This is brute force approach where the problem is being solved
    // with an extra space. TC & SC of this solution is O(n).
    public static int lengthOfLoopBrute(Node head) {
        HashMap<Node, Integer> map = new HashMap<>();
        Node temp = head;
        int length = 0;
        int timer = 1;

        while (temp != null) {
            if (map.containsKey(temp)) {
                length = timer - map.get(temp);
                return length;
            }

            map.put(temp, timer++);
            temp = temp.next;
        }

        return length;
    }

    // Approach 02 : This is an optimized approach where the problem is being solved
    // without any extra space. Time Complexity of this solution is O(n). This
    // solution uses tortoise and hare algorithm.
    // The idea is to use two pointers, one moving at twice the speed of the other.
    public static int lengthOfLoopOpt(Node head) {
        Node slow = head;
        Node fast = head;
        int totalLenght = 0;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                int length = 1;
                Node temp = fast.next;

                while (temp != slow) {
                    length++;
                    temp = temp.next;
                }
                return length;
            }
        }

        return totalLenght;
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

        System.out.println("Length of Loop (Brute Force): " + lengthOfLoopOpt(head));
    }

}
