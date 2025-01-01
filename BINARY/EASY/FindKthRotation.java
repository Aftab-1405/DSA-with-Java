package BINARY.EASY;

import java.util.*;

public class FindKthRotation {

    // Approach 01 : (Brute) Here I am using built in methods which might end up
    // taking TC O(n) in worst case.
    public static int findKthPositionLinear(List<Integer> arr) {
        return arr.indexOf(Collections.min(arr)) - arr.indexOf(arr.get(0));
    }

    // Approach 02 : (Optimal) Since this solution is using binary seach technique
    // at its core that's why it will end up taking O(logn) time comlexity.
    public static int findKthPositionBinary(List<Integer> arr) {
        int low = 0;
        int high = arr.size() - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr.get(mid) > arr.get(high)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {

        List<Integer> arr = new ArrayList<>();
        arr.addAll(Arrays.asList(5, 1, 2, 3, 4));

        System.out.println("Result from brute solution: " + findKthPositionLinear(arr));
        System.out.println("Result from optimal solution: " + findKthPositionBinary(arr));

    }
}
