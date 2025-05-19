package AMAZONPROBLEMS;

public class ProductOfArrayExceptSelf {

    public static int[] productOfArrayExceptSelfBrute(int[] nums) { // Handles only non-zeros values.
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int prod = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    prod *= nums[j];
                }
            }
            result[i] = prod;
        }

        return result;
    }

    public static int[] productOfArrayExceptSelfHandleZero(int[] nums) { // Handles zeros and non-zeros values.
        int prodWithoutZeros = 1;
        int coutZeros = 0;

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                prodWithoutZeros *= nums[i];
            } else {
                coutZeros++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) { // This condition will be executed if nums[i] != 0.
                if (coutZeros > 0) {
                    result[i] = 0;
                } else {
                    result[i] = prodWithoutZeros / nums[i];
                }
            } else { // This condition will be executed if nums[i] == 0.
                if (coutZeros > 1) { // Check for count of zero > 1, if it is then total product will be 0 only.
                    result[i] = 0;
                } else {
                    result[i] = prodWithoutZeros;
                }
            }
        }

        return result;
    }

    // Approach 03: Optimal appaoch with TC of O(n) and SC of O(n).
    public static int[] productOfArrayExceptSelfOptimal(int[] nums) {
        int[] result = new int[nums.length];
        int[] left = new int[nums.length]; // Left prefix product
        left[0] = 1;
        int[] right = new int[nums.length]; // Right suffix product
        right[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 0, 3, 4 };
        int[] result = productOfArrayExceptSelfHandleZero(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
