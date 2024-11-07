import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithGivenSum {

    /*
     * Approach 01: ( Brute ) This is one of the common brute force approach comes
     * up to our mind when we try to find out sub arrays from given array. In this
     * solution 3 loops would be used where 1st for row traversal, 2nd for columns
     * and within first and second loop will get range of our sub arrays. This
     * approach will take O(n^3) in order to find out all the subarrays, hence we
     * will not prefer this solution.
     */

    /*
     * Approach 02: ( Better ) This solution is not better as we think, it just
     * removing third loop from the brute force solution. Since we are just adding
     * up the next guy into result so we can directly use arr[j] instead of running
     * one more loop from (i to z), this little change will boil down TC to near
     * about O(n^2).
     */

    /*
     * Approach 03 : ( Optimal ) This is an optimal solution where I am using prefix
     * sum technique to solve this problem along with has map. The time complexity
     * of problem with this approach would be near about O(n) and space complexity
     * would be O(n) in worst case.
     */
    public static int findSubArraySum(int k, int arr[]) {
        // code here
        int preSum = 0;
        int count = 0;

        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1);

        for (int i = 0; i < arr.length; i++) {

            // add current element to prefix Sum:
            preSum += arr[i];

            // Calculate x-k:
            int remove = preSum - k;

            // Add the number of subarrays to be removed:
            count += mpp.getOrDefault(remove, 0);

            // Update the count of prefix sum
            // in the map.
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);

        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        System.out.println(findSubArraySum(4, arr));

    }
}
