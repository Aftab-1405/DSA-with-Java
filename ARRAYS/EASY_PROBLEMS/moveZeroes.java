package ARRAYS.EASY_PROBLEMS;

public class moveZeroes {

    // Method 01: In this approach, we need to create a multiple array which can
    // store '0' then non zero values and then another array to store them and after
    // that again overwrite our main array with the new array. This requires lots of
    // memory and steps.

    // Method 02: This is an optimal solution for this problem.
    public static void moveZero(int[] nums) {
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 0, 1 };
        moveZero(arr);
        for (int x : arr) {
            System.out.println(x + " ");
        }
    }
}