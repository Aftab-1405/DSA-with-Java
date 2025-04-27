package BINARY.MEDIUM;

public class MinimumDaysToMakeMBouquets {

    // Brute Force Approach
    public int minDaysBrute(int[] bloomDay, int m, int k) {
        // Check if it's even possible to make m bouquets
        if ((long) bloomDay.length < (long) m * k)
            return -1;

        // Find the minimum and maximum bloom days
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            min = Math.min(min, day);
            max = Math.max(max, day);
        }

        // Brute force check for each day from min to max
        for (int day = min; day <= max; day++) {
            if (isPossible(bloomDay, day, m, k)) {
                return day;
            }
        }
        return -1; // Return -1 if no solution is found
    }

    // Optimal Solution using Binary Search
    public int minDays(int[] bloomDay, int m, int k) {
        // Check if it's even possible to make m bouquets
        if ((long) bloomDay.length < (long) m * k)
            return -1;

        // Find the minimum and maximum bloom days
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            min = Math.min(min, day);
            max = Math.max(max, day);
        }

        // Perform binary search on the number of days
        int left = min, right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isPossible(bloomDay, mid, m, k)) {
                right = mid; // Try to minimize the days further
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // Helper function to check if it's possible to make m bouquets in 'day' days
    public static boolean isPossible(int[] arr, int day, int m, int k) {
        int count = 0, bouquets = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= day) {
                count++;
                if (count == k) { // Form a bouquet
                    bouquets++;
                    count = 0; // Reset count for the next bouquet
                }
            } else {
                count = 0; // Reset count if the flower hasn't bloomed
            }
            if (bouquets >= m)
                return true; // Stop early if we reach required bouquets
        }
        return bouquets >= m;
    }
}
