package BINARY;

public class UpperBoundProblem {

    // Approach 01 : This is an linear search approach which will take time O(n) in
    // worst case scenario. This is the same problem as lower bound problem but the
    // only difference is that in change of sign from >= to just >.
    public static int findUpperBoundLinear(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > target) { // =====> Here
                return i;
            }
        }

        return arr.length;
    }

    // Approch 02 : This is an optimal solution where I am using binary search
    // technique to reduce down the seach space. The time complexity of this
    // approach will be O(logN)
    public static int findUpperBoundBinarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int result = arr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) { // ======> Here
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
        System.out.println("Answer from brute solution: " + findUpperBoundLinear(arr, 20));
        System.out.println("Answer from brute solution: " + findUpperBoundBinarySearch(arr, 20));

    }

}
