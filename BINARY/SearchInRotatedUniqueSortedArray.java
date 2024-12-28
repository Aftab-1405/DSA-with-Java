package BINARY;

public class SearchInRotatedUniqueSortedArray {

    // Approach 01 : (Brute) This solution is using linear seach, which in worst
    // case might end up taking linear time so the TC of this solution is O(n).
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }

        return -1;
    }

    // Approach 02: (Optimal) In here I am using binary search algorithm to search
    // the given element. This will take TC as O(logn) since we are deviding problem
    // in multiple halves as we go further. The key point over here to identify
    // which part of the given array is sorted.

    // Note Imp : This solution can work only for the condition where rotated array
    // is not having duplicates, becuase if some elements in an array are repeating
    // then we might end up facing this conditon (arr[low] == arr[mid] && arr[mid]
    // == arr[high]) where our algorithm will fail to identify which half is sorted
    // so for that we have to add some extra lines of code to handle this conditon.
    // This will be the next problem.
    public static int binSearch(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == k) {
                return mid;
            }

            // Check which half is sorted
            if (arr[low] <= arr[mid]) { // Left half is sorted
                if (arr[low] <= k && k < arr[mid]) {
                    high = mid - 1; // Target is in the left half
                } else {
                    low = mid + 1; // Target is in the right half
                }
            } else { // Right half is sorted
                if (arr[mid] < k && k <= arr[high]) {
                    low = mid + 1; // Target is in the right half
                } else {
                    high = mid - 1; // Target is in the left half
                }
            }
        }

        return -1; // Key not found
    }

    public static void main(String[] args) {

        int arr[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
        int key = 3;

        System.out.println(binSearch(arr, key));
    }
}
