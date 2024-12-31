package BINARY.EASY;

public class SearchInRotatedDuplicateSortedArray {

    // Approach 01 : (Brute) This solution is using linear seach, which in worst
    // case might end up taking linear time so the TC of this solution is O(n).
    public static boolean linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return true;
            }
        }

        return false;
    }

    // Approach 02: (Optimal) In here I am using binary search algorithm to search
    // the given element. This will take TC as O(logn) since we are deviding problem
    // in multiple halves as we go further. The key point over here to identify
    // which part of the given array is sorted.

    // Note Imp : This solution will handle the problem that we have disccued in
    // previous example where we have to handle this condition => (arr[low] ==
    // arr[mid] && arr[mid] == arr[high]).
    public static boolean binSearch(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == k) {
                return true;
            }

            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low = low + 1;
                high = high - 1;
                continue;
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

        return false; // Key not found
    }

    public static void main(String[] args) {

        int arr[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
        int key = 3;

        System.out.println(binSearch(arr, key));
    }

}
