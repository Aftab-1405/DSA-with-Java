package BINARY.MEDIUM;

public class FindTheSmallestDivisorGivenAThreshold {

    // Approach 01: (Brute) This is brute force solution where I am linearly going
    // through each and every elements within a range, so the TC will be O(n) for
    // this perticular solution.
    public static int smallestDivisorLinear(int[] nums, int threshold) {
        int tResult = Integer.MAX_VALUE; // Initialize to maximum value

        // Loop through possible divisors from 1 to max(nums)
        for (int i = 1; i <= findMax(nums); i++) { // Iterate divisors from 1 to max value
            int result = 0;

            // Calculate the sum for current divisor i
            for (int j = 0; j < nums.length; j++) {
                result += Math.ceil((double) nums[j] / i); // Ensure floating-point division
            }

            // If result is within threshold, update tResult
            if (result <= threshold) { // Use <= instead of ==
                tResult = Math.min(tResult, i); // Track the smallest divisor
            }
        }
        return tResult;
    }

    // Helper method to find the maximum element in nums
    private static int findMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    // Approach 02: (Optimal) Here I am using binary search technique so apparently
    // TC will be trimmed down to O(logn).
    public static int smallestDivisorBinary(int[] nums, int threshold) {
        int left = 1, right = Integer.MAX_VALUE;

        // Find max element in nums
        for (int num : nums) {
            right = Math.max(right, num);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Calculate the sum
            int sum = 0;
            for (int num : nums) {
                sum += Math.ceil((double) num / mid);
            }

            // Binary search logic
            if (sum > threshold) {
                left = mid + 1; // Increase divisor
            } else {
                right = mid; // Try smaller divisor
            }
        }

        return left; // Smallest divisor
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 7, 4, 10 };
        System.out.println("Result from brute force: " + smallestDivisorLinear(arr, 5));
        System.out.println("Result from optimal solution: " + smallestDivisorBinary(arr, 5));
    }
}
