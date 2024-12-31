package BINARY.EASY;

public class BinarySearch {
    /*
     * Imp Note : Binary search algorithm only work if the given array or any other
     * data structure is in its sorted form.
     * Approach 01 : Iterative approach
     */
    public static int binarySearchIterative(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int low, int high, int k) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        if (arr[mid] == k) {
            return mid;
        }

        else if (arr[mid] < k) {
            return binarySearchRecursive(arr, mid + 1, high, k);
        }

        return binarySearchRecursive(arr, low, mid - 1, k);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 5, 7, 11, 12, 17 };
        System.out.println(binarySearchRecursive(arr, 0, 7, 90));
    }
}