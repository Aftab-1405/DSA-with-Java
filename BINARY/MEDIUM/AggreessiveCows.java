package BINARY.MEDIUM;

import java.util.Arrays;

/**
 * Problem: Aggressive Cows
 * Place k cows in n stalls such that minimum distance between any two cows is
 * maximized
 */
public class AggreessiveCows {
    /**
     * Linear search approach to find maximum minimum distance between cows
     * Time Complexity: O(N * M) where N is range of positions, M is array length
     * Space Complexity: O(1) as no extra space is used
     */
    public static int aggressiveCowsLinear(int[] stalls, int k) {
        int n = stalls[stalls.length - 1] - stalls[0]; // Get range of positions
        int ans = -1;
        // Try each possible distance from 1 to max range
        for (int i = 1; i <= n; i++) {
            if (isPossible(stalls, i, k)) {
                ans = i;
            }
        }
        return ans;
    }

    /**
     * Binary search approach to find maximum minimum distance between cows
     * Time Complexity: O(N * log M) where N is array length, M is range of
     * positions
     * Space Complexity: O(1) excluding the sort space complexity
     */
    public static int aggressiveCowsBinary(int[] stalls, int k) {
        Arrays.sort(stalls); // Sort stalls in ascending order

        // Define search space
        int low = 1; // Minimum possible distance
        int high = stalls[stalls.length - 1] - stalls[0]; // Maximum possible distance

        // Binary search for optimal distance
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(stalls, mid, k)) {
                low = mid + 1; // Try larger distance
            } else {
                high = mid - 1; // Try smaller distance
            }
        }
        return high; // Return largest valid distance
    }

    /**
     * Helper method to check if placing cows with given minimum distance is
     * possible
     * Time Complexity: O(N) where N is array length
     * Space Complexity: O(1)
     */
    private static boolean isPossible(int[] arr, int distance, int cows) {
        int countOfCows = 1;
        int lastCowPlaced = arr[0]; // Place first cow at first position

        // Try to place remaining cows
        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] - lastCowPlaced) >= distance) {
                countOfCows++;
                lastCowPlaced = arr[i];
            }
        }

        return countOfCows >= cows;
    }

    /**
     * Main method for testing
     * Example: stalls = [1,2,4,8,9], k = 3
     * Expected output: 3
     */
    public static void main(String[] args) {
        int[] stalls = { 1, 2, 4, 8, 9 };
        int k = 3;
        System.out.println(aggressiveCowsLinear(stalls, k)); // 3
    }
}
