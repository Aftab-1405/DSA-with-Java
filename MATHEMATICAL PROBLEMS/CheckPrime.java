class Solution {

    public static void sortColors2(int[] colors) {

        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == 0)
                count0++;
            if (colors[i] == 1)
                count1++;
            if (colors[i] == 2)
                count2++;
        }

        System.out.print(count0);
        System.out.println(count1);
        System.out.println(count2);

    }

    /**
     * Approach 03(Optimal) : Dutch National Flag Algorithm for sorting colors (0,
     * 1, 2)
     * 
     * Algorithm description:
     * 1. Use three pointers: low, mid, and high
     * - low: rightmost boundary of 0s (next position to place 0)
     * - mid: current element being examined
     * - high: leftmost boundary of 2s (next position to place 2)
     * 
     * 2. Iterate while mid <= high:
     * a. If nums[mid] is 0:
     * - Swap nums[low] with nums[mid]
     * - Increment low and mid
     * b. If nums[mid] is 1:
     * - Leave it in place and increment mid
     * c. If nums[mid] is 2:
     * - Swap nums[mid] with nums[high]
     * - Decrement high
     * - Don't increment mid (new element needs to be examined)
     * 
     * 3. After the loop, the array will be sorted with:
     * - 0s from index 0 to (low - 1)
     * - 1s from index low to (high)
     * - 2s from index (high + 1) to the end
     * 
     * Time Complexity: O(n)
     * - The algorithm makes a single pass through the array.
     * - Each element is examined at most twice (once by mid, and possibly once more
     * after a swap with high).
     * 
     * Space Complexity: O(1)
     * - Only a constant amount of extra space is used (for the three pointers and
     * temp variable).
     */

    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap with low pointer and move both low and mid forward
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // 1 is in the correct position, just move mid forward
                mid++;
            } else {
                // nums[mid] == 2, swap with high pointer and move high backward
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
                // Note: mid is not incremented as the swapped element needs to be examined
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 2, 0, 2, 1, 1, 0 };
        sortColors2(nums);
    }
}