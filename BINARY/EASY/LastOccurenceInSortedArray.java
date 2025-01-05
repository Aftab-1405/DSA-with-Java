package BINARY.EASY;

import java.util.Arrays;

/**
 * Problem: Find first and last occurrence of an element in a sorted array
 * Input: Sorted array and target element
 * Output: Array containing first and last indices of target element
 */
public class LastOccurenceInSortedArray {

    /**
     * Wrapper method that returns both first and last occurrences
     * Uses optimized binary search approach for both searches
     * Time Complexity: O(log n) - Two binary searches
     * Space Complexity: O(1) - Only uses constant extra space
     */
    public static int[] findOccurence(int[] arr, int k) {
        int first = -1;
        int last = -1;

        first = findFirst(arr, k);
        last = findLast(arr, k);

        return new int[] { first, last };
    }

    /**
     * Binary Search to find first occurrence
     * When element is found, continue searching in left half
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int findFirst(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        int first = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == k) {
                first = mid;
                high = mid - 1; // Keep searching in left half
            } else if (arr[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return first;
    }

    /**
     * Binary Search to find last occurrence
     * When element is found, continue searching in right half
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int findLast(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        int last = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == k) {
                last = mid;
                low = mid + 1; // Keep searching in right half
            } else if (arr[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return last;
    }

    // Driver code
    public static void main(String[] args) {
        int array[] = { 3, 4, 13, 13, 13, 20, 40 };
        System.out.println(Arrays.toString(findOccurence(array, 13)));
    }
}