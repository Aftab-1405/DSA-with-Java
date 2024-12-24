package BINARY;

public class LowerBoundProblem {

    // Approach 01 : This is an linear search approach which will take time O(n) in
    // worst case scenario.
    public static int findLowerBoundLinear(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= target) {
                return i;
            }
        }

        return arr.length;
    }

    // Approch 02 : This is an optimal solution where I am using binary search
    // technique to reduce down the seach space. The time complexity of this
    // approach will be O(logN)
    public static int findLowerBoundBinarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int result = arr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 8, 10, 11, 12, 19 };
        System.out.println(findLowerBoundBinarySearch(arr, 20));

    }

}
