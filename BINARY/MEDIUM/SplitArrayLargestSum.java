package BINARY.MEDIUM;

public class SplitArrayLargestSum {

    // Approach 02: (Optimal) Using Binary Search to find the minimum possible
    // maximum sum of subarrays after splitting the array into K subarrays with each
    // subarray sum <= maxSum (mid). The time complexity of this approach is O(N *
    // log(sum of array elements)).
    static int splitArray(int[] arr, int N, int K) {
        int low = 0, high = 0;

        // Calculate the initial low and high values
        for (int num : arr) {
            low = Math.max(low, num);
            high += num;
        }

        // Binary search to find the minimum possible maximum sum
        while (low < high) {
            int mid = low + (high - low) / 2;

            // Check if it's possible to split with maximum sum = mid
            if (canSplit(arr, N, K, mid)) {
                high = mid; // Try for a smaller maximum sum
            } else {
                low = mid + 1; // Increase the maximum sum
            }
        }

        return low; // The smallest possible maximum sum
    }

    // Helper function to check if we can split the array into <= K subarrays
    // with each subarray sum <= maxSum
    static boolean canSplit(int[] arr, int N, int K, int maxSum) {
        int currentSum = 0;
        int splitsRequired = 1;

        for (int num : arr) {
            if (currentSum + num > maxSum) {
                // Start a new subarray
                splitsRequired++;
                currentSum = num;

                // If splits exceed K, it's not possible
                if (splitsRequired > K) {
                    return false;
                }
            } else {
                currentSum += num;
            }
        }

        return true; // It's possible to split
    }

    public static void main(String[] args) {
        int[] arr = { 7, 2, 5, 10, 8 };
        int N = arr.length;
        int K = 2;

        System.out.println(splitArray(arr, N, K)); // Output: 18
    }
}
