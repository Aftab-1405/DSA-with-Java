package ARRAYS.HARD;

public class MaximumProductSubArray {
    // Approach 01 : (Brute) In this approach we can use 2 nested loops and generate
    // all the sub arrays, after that we can calculate product of each sub array and
    // try to return the maximum sub array product. Since this will be using 2
    // nested loops so it will take time near about O(n^2) and SC would be O(1)
    // only.

    public static int findMaximumProductSubArrayBrute(int[] nums) {
        int maxProd = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = i; j < nums.length; j++) {
                product *= nums[j];
                maxProd = Math.max(maxProd, product);
            }
        }

        return maxProd;
    }

    // Approach 02 : (Optimal) This is an optimal solution where I am using a single
    // loop so thereby the TC will be O(n) and since we are not using extra space
    // the SC would be O(1) only.

    public static int findMaximumProductSubArrayOptimal(int[] nums) {
        int maxProd = Integer.MIN_VALUE;
        int pre = 1;
        int suf = 1;

        for (int i = 0; i < nums.length; i++) {
            if (pre == 0)
                pre = 1;
            if (suf == 0)
                suf = 1;

            pre = pre * nums[i];
            suf = suf * nums[nums.length - i - 1];

            maxProd = Math.max(maxProd, Math.max(pre, suf));
        }

        return maxProd;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, -1, 6 };
        System.out.println(findMaximumProductSubArrayOptimal(arr));
    }
}