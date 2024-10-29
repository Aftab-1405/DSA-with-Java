public class FindSingleMissingElementInArray {

    // Approach 01: Here we can utilize linear search to find out each and every
    // element, is someone is not found then thats the missing element. Time
    // Complexity O(n^2), utilizes nested for loops.

    // Approach 02: Better solution, where in we can find the max element of an
    // array, then will create hash of that size. Once these things are done we will
    // go across our actaul array and mark then in the hash table. In hash all
    // present elements would have non zero values, so we return the indexes which
    // has 0 values. These indexes will be our missing values. Super easy. Time
    // Complexity O(2n) we need to separate for loops.

    // Approach 03: Optimal solution for finding out missing value. Time complexity
    // is O(n) and Space complexity is O(1).
    public static int missingNumber(int[] nums) {
        int n = nums.length;

        // Step 1: Calculate the expected sum of numbers from 0 to n
        int expectedSum = n * (n + 1) / 2;

        // Step 2: Calculate the actual sum of numbers in the array
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        // Step 3: The missing number is the difference between expected and actual sum
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 3, 4 };
        System.out.println(missingNumber(arr));
    }
}