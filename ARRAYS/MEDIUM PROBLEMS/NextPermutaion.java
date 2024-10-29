import java.util.Arrays;

// Aprraoch 02 : Optimal=> This logic implements the next permutation function of C++ STL library. 
public class NextPermutaion {
    public static int[] nextPermutation(int[] nums) {
        int index = -1;

        // Step 1: Find the rightmost element that is smaller than the element next to
        // it
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // Step 2: If such an element is found, find the element to swap
        if (index != -1) {
            for (int i = nums.length - 1; i > index; i--) {
                if (nums[i] > nums[index]) {
                    // Swap nums[index] and nums[i]
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                    break;
                }
            }
        }

        // Step 3: Reverse the part of the array after index
        reverse(nums, index + 1, nums.length - 1);

        return nums;
    }

    // Helper function to reverse a subarray
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
        int[] arr = { 2, 3, 1 };
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr)); // Correctly print the array contents
    }
}
