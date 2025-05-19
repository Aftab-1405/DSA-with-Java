package AMAZONPROBLEMS;

import java.util.PriorityQueue;

public class MedianOfDataStream {

    PriorityQueue<Integer> rHeap = new PriorityQueue<>(); // min heap
    PriorityQueue<Integer> lHeap = new PriorityQueue<>((a, b) -> b - a); // max heap

    public void addNum(int num) {

        if (lHeap.isEmpty() || num < lHeap.peek()) {
            lHeap.add(num);
        } else {
            rHeap.add(num);
        }

        if (Math.abs(lHeap.size() - rHeap.size()) > 1) { // balance the left heaps.
            rHeap.add(lHeap.poll());
        } else if (lHeap.size() < rHeap.size()) { // balance the right heap.
            lHeap.add(rHeap.poll());
        }
    }

    public double findMedian() {
        if (lHeap.size() == rHeap.size()) { // even number of elements.
            return (lHeap.peek() + rHeap.peek()) / 2.0;
        } else {
            return lHeap.peek(); // odd number of elements.
        }
    }

    public static void main(String[] args) {
        MedianOfDataStream medianFinder = new MedianOfDataStream();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian()); // Output: 1.5
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian()); // Output: 2.0
    }
}
