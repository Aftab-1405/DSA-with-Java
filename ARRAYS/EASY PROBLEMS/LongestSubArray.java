public class LongestSubArray {

    // Approach 01: This is the brute-force approach to find out the longest
    // subarray length. This has time complexity of o(n^3).

    public static int findLongestSubArrayLen01(int[] arr, int value) {
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum == value) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        return len;
    }

    // Approach 02: This is just a little bit improved solution in terms of time
    // complexity, where in we have removed an extra for loop and bring down the
    // time complexity up to O(n^2).

    public static int findLongestSubArrayLen02(int[] arr, int value) {
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == value) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        return len;
    }

    // Approch 04: This method is optimized for calculating the length of longest
    // subarray whose sum is equivalent to given 'K'. Here we are using sliding
    // window technique by utilizing two pointers appraoch. TC would be O(2N) and SC
    // would be O(1).
    // Note : This approach will perform better only if the array contains non
    // negative numbers.

    public static int findLongestSubArrayLen03(int[] arr, int value) {
        int i = 0, j = 0;
        int sum = 0;
        int maxLen = 0;
        while (j < arr.length) {
            // Expand the window by adding arr[j]
            sum += arr[j];

            // Shrink the window while sum is greater than the target value
            while (sum > value) {
                sum -= arr[i++];
            }

            // Check if the current window has the required sum
            if (sum == value) {
                maxLen = Math.max(maxLen, j - i + 1);
            }

            j++; // Always move the right pointer
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 1, 2, 1, 1, 1 };
        System.out.println(findLongestSubArrayLen03(arr, 3));
    }

}
