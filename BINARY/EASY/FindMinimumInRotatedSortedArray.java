package BINARY.EASY;

public class FindMinimumInRotatedSortedArray {

    // Approach 01 : (Brute)
    public static int finMinLinearBrute(int[] arr) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        return min;
    }

    // Approach 02 : (Better (Works only for certain test cases.))
    // This is my solution, It will work as expected but in edge cases it might
    // fail. So below is an universal solution which cal handle any kind of test
    // cases properly.
    public static int findMinBinaryOptimal(int[] arr) {
        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (arr[mid] < min) {
                min = arr[mid];
            } else if (arr[low] < arr[high]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return min;
    }

    // Approach 03 : (Optimal)
    public static int findMinBinaryOptimalUniversal(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = low + ((high - low) / 2);
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }

        }

        return arr[low];
    }

    public static void main(String[] args) {
        int[] arr = { 5, 1, 2, 3, 4 };
        System.out.println(findMinBinaryOptimalUniversal(arr));
    }
}
