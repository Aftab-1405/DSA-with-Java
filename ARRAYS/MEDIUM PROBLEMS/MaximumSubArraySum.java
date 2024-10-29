public class MaximumSubArraySum {

    // Approach 01 (Brute) : Utilizes the nested loop to calculate sum of all the
    // sub arrays and then figure out the max sum fron it. It take TC as (O^3) if
    // three loops are used and with little bit optimization we can reduce it up to
    // o(n^2). SC will be O(1) only.

    // Approach 02 (Optimal) : This approach utilizes the kadanes algorithm, which
    // will take TC as O(n) and SC as O(1).

    public static int kadanesAlgo(int[] arr) {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // Reset sum to 0 if it becomes negative
            if (sum < 0) {
                sum = 0;
            }

            // Track the maximum sum found
            max = Math.max(max, sum);
        }

        // Return the maximum found, handle case when all elements are negative
        return max == 0 ? Integer.MIN_VALUE : max;
    }

    public static void main(String[] args) {
        int[] arr = { -1, -3, 1, 2, 3, -5 };
        System.out.println(kadanesAlgo(arr));
    }
}
