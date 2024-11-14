package ARRAYS.HARD;

import java.util.HashMap;

public class longestSubarrayWithZeroSum {

    // Approach 01: (Brute) In this brute force approach I am just forming all the
    // sub arrays and checking whether their sum is equal to 0 or not, after that I
    // am checking length of each subarray which has given me 0 sum and comparing
    // length and returning max length. Since we are running two loops here the TC
    // is obvious which is near about O(n^2) and SC will be O(1) becuase we are not
    // using any extra space.
    public static int findMaxLengthBrute(int[] arr) {
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == 0) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    // Approach 02; (Better) This approach follows the kadane's algorithm which
    // allows me to use only single loop and calculate the subarray which is maximum
    // in length and also gives sum 0. The TC of this solution is O(n) and SC will
    // be near about O(n) becuase we are using hasmap which would have end up taking
    // n space in worsth case.
    public static int findMaxLengthBetter(int[] arr) {
        HashMap<Integer, Integer> mpp = new HashMap<Integer, Integer>();

        int maxi = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            if (sum == 0) {
                maxi = i + 1;
            } else {
                if (mpp.get(sum) != null) {

                    maxi = Math.max(maxi, i - mpp.get(sum));
                } else {

                    mpp.put(sum, i);
                }
            }
        }
        return maxi;
    }

    public static void main(String[] args) {
        int a[] = { 9, -3, 3, -1, 6, -5 };
        System.out.println(findMaxLengthBetter(a));
    }

}
