import java.util.ArrayList;

public class RotateArrayByKPlaces {

    // Method 01 : Recursive Approach (Brute Force Approache) my own implementation
    // 😍
    public static void rotate(int[] arr, int k) {
        k = k % arr.length;

        if (k <= 0)
            return;

        int i = 0;
        int j = arr.length - 1;
        int temp = arr[j];

        while (j > i) {
            arr[j] = arr[j - 1];
            j--;
        }

        arr[i] = temp;

        rotate(arr, k - 1);

    }

    // Method 02 : Using ArraList (Brute Force Approache)
    public static void rotateAgain(int[] arr, int k) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            temp.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            arr[i - k] = arr[i];
        }

        int j = 0;
        for (int i = arr.length - k; i < arr.length; i++) {
            arr[i] = temp.get(j++);
        }
    }

    // Method 03 : This is am optimal solution in the context of space. It takes
    // O(1) space complexity. Here we are just reversing the sub arrays.
    public static void rotateOptimal(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1); // Reverse complete array : 7,6,5,4,3,2,1
        reverse(nums, 0, k - 1); // Reverse subarray : 7,6,5 -> 5,6,7
        reverse(nums, k, n - 1); // Reverse subarray : 4,3,2,1 -> 1,2,3,4

    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        rotateOptimal(arr, k);
        for (int x : arr) {
            System.out.println(x + " ");
        }
    }
}
