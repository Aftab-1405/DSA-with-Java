/*
Problem Statement:
    Determine the minimum eating speed (k) at which Koko can eat all the bananas within h hours.

Thought Process:
    1. Brute Force Solution:
        - Start with k = 1 and increment until Koko can finish all bananas within h hours.
    2. Optimal Solution (Binary Search):
        - Use binary search to find the minimum k.
        - Check if Koko can finish all bananas within h hours for a given k.

Detailed Comments:
    - The KokoEatingBananas class contains methods to find the minimum eating speed using both brute force and optimal solutions.
    - The canFinish method checks if Koko can eat all bananas within h hours at a given speed k.
*/

package BINARY.MEDIUM;

import java.util.*;

public class KokoEatingBananas {

    // Brute Force Solution
    public static int minEatingSpeedBrute(int[] piles, int h) {
        int k = 1;
        while (true) {
            if (canFinish(piles, h, k)) {
                return k;
            }
            k++;
        }
    }

    // Helper function to check if Koko can eat all bananas in h hours
    private static boolean canFinish(int[] piles, int h, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += Math.ceil((double) pile / k); // Calculate hours needed for this pile
        }
        return hours <= h;
    }

    // Optimal Solution (Binary Search)
    public static int minEatingSpeedOptimal(int[] piles, int h) {
        int left = 1, right = Arrays.stream(piles).max().getAsInt();
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, h, mid)) {
                result = mid; // Update result if mid is a valid speed
                right = mid - 1; // Try for a smaller speed
            } else {
                left = mid + 1; // Increase speed
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] piles1 = { 3, 6, 7, 11 };
        int h1 = 8;
        System.out.println("Brute Force Output: " + minEatingSpeedBrute(piles1, h1)); // Output: 4
        System.out.println("Optimal Output: " + minEatingSpeedOptimal(piles1, h1)); // Output: 4

        int[] piles2 = { 30, 11, 23, 4, 20 };
        int h2 = 5;
        System.out.println("Brute Force Output: " + minEatingSpeedBrute(piles2, h2)); // Output: 30
        System.out.println("Optimal Output: " + minEatingSpeedOptimal(piles2, h2)); // Output: 30

        int[] piles3 = { 30, 11, 23, 4, 20 };
        int h3 = 6;
        System.out.println("Brute Force Output: " + minEatingSpeedBrute(piles3, h3)); // Output: 23
        System.out.println("Optimal Output: " + minEatingSpeedOptimal(piles3, h3)); // Output: 23
    }
}