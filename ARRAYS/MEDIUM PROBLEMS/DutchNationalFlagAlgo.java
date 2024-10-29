public class DutchNationalFlagAlgo {

    // Approach 01 (Brute) : Use any of the sorting algorithms like selection,
    // bubble, insertion, merge and quik sort. Here we will max to max reduce TC at
    // O(nlogn).

    // Approach 02 (Better) : Here we can use hash, which will store the count of
    // each numbers. After that we will run three loops to set the values 0, 1 and 2
    // respectively based on the count they have in hash then return the array. This
    // will take TC as O(3n) and SC as O(n), since we are using extra hash and three
    // loops.

    // Approach 03 (Optimal): This is the dutch national flag algorithm used to
    // solve 0's, 1's and 2's problem with TC of O(n) and SC od O(1);
    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap nums[low] and nums[mid], and increment both low and mid
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // Just move mid
                mid++;
            } else if (nums[mid] == 2) {
                // Swap nums[mid] and nums[high], decrement high
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 2, 0, 2, 1, 1, 0 };
        sortColors(nums);
        for (int i : nums) {
            System.out.println(i);
        }

    }
}
