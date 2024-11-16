package ARRAYS.HARD;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfSubarraysWithGivenXORK {

    /*
     * Approach 01: (Brute) This is the brute force solution where I am first
     * finding all the subarrays from an array. After that I am performing XOR
     * operation and checking whether the the calculated answer is equal to given
     * value or not and based on that updating the state of counter. The time
     * complexity is near about O(n^3) since I am using three loops and space
     * complexity is O(1) because I am not using extra space.
     */
    public static int findNumOfSubArraysBrute(int[] arr, int value) {
        int len = arr.length;
        int count = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum = sum ^ arr[k];
                }
                if (sum == value) {
                    count++;
                }
            }
        }
        return count;
    }

    /*
     * Approach 02: (Better) This is the better approach where I have removed extra
     * loop and reduced down the time complexity from O(n^3) to O(n^2). Space
     * complexity is still O(1).
     */
    public static int findNumOfSubArraysBetter(int[] arr, int value) {
        int len = arr.length;
        int count = 0;

        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum = sum ^ arr[j];

                if (sum == value) {
                    count++;
                }
            }

        }
        return count;
    }

    /*
     * Approach 03: (Optimal) This is an optimal approach where I am using reverse
     * engineering approach to find out the number of sub arrays which are giving
     * sum as given value. The TC would be O(n) only and SC will be O(n) becuase I
     * am here using map so in worst case I might end up taking n size.
     */
    public static int findMaxLengthOptimal(int[] arr, int value) {
        int n = arr.length; // size of the given array.
        int xr = 0;
        Map<Integer, Integer> mpp = new HashMap<>(); // declaring the map.
        mpp.put(xr, 1); // setting the value of 0.
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            // prefix XOR till index i:
            xr = xr ^ arr[i];

            // By formula: x = xr^k:
            int x = xr ^ value;

            // add the occurrence of xr^k
            // to the count:
            if (mpp.containsKey(x)) {
                cnt += mpp.get(x);
            }

            // Insert the prefix xor till index i
            // into the map:
            if (mpp.containsKey(xr)) {
                mpp.put(xr, mpp.get(xr) + 1);
            } else {
                mpp.put(xr, 1);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

        // Test Case 1: Should return 4 (Subarrays: [4,2], [2,2,6], [6], [4,2,2,6])
        int[] arr1 = { 4, 2, 2, 6, 4 };
        int value1 = 6;
        System.out.println("Test Case 1: " + findNumOfSubArraysBetter(arr1, value1)); // Should print 4

        // Test Case 2: Should return 1 (Subarray: [6])
        int[] arr2 = { 6 };
        int value2 = 6;
        System.out.println("Test Case 2: " + findNumOfSubArraysBrute(arr2, value2)); // Should print 1

        // Test Case 3: Should return 2 (Subarrays: [5], [5,7,2])
        int[] arr3 = { 5, 7, 2 };
        int value3 = 5;
        System.out.println("Test Case 3: " + findNumOfSubArraysBrute(arr3, value3)); // Should print 2

        // Test Case 4: Should return 0 (No subarrays with XOR 7)
        int[] arr4 = { 1, 2, 3 };
        int value4 = 7;
        System.out.println("Test Case 4: " + findNumOfSubArraysBrute(arr4, value4)); // Should print 0
    }

}
