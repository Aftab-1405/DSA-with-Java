import java.util.HashMap;
import java.util.*;

public class TwoSum {

    // Approach 01 (Brute): Here we are using two for loops and try to find out the
    // two elements whose sum will end up with our result. This will end up with TC
    // O(n^2)

    public static int[] getIndexes01(int[] arr, int k) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] + arr[j]) == k) {
                    return new int[] { i, j };
                }
            }
        }

        return new int[] {};
    }

    // Approach 02 (Better): This is a better approach which is using hashmap to
    // solve the problem. Here we are first finding out the complement which is the
    // difference between the current element and the required sum, in case if we
    // find the required sum then will return the value of the required element
    // since it is in map and then value of 'i' which i pointing to our current
    // element. In case if we cannot find the required sum then will return empty
    // array. Time complexity is O(nLogn) and space complexity is O(n) since we are
    // using extra map.

    public static int[] getIndexes02(int[] arr, int k) {
        // HashMap to store the value and its corresponding index
        HashMap<Integer, Integer> h = new HashMap<>();

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            int complement = k - arr[i]; // Find the complement

            // If complement exists in the map, return its index and current index
            if (h.containsKey(complement)) {
                return new int[] { h.get(complement), i };
            }

            // Otherwise, store the current value and its index
            h.put(arr[i], i);
        }

        // Return an empty array if no solution is found
        return new int[] {};
    }

    // Appraoch 03(Optimal-Greedy Approach): Here we can use two pointer approach,
    // this will only be usable in case of first variety of this problem where we
    // just have to return "YES" or "NO".

    public static String twoSum(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return "YES";
            } else if (sum < target)
                left++;
            else
                right--;
        }
        return "NO";
    }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = getIndexes01(arr, target);

        System.out.println(twoSum(arr, target));

        if (result.length == 2) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No solution found");
        }
    }
}
