package BINARY.MEDIUM;

import java.util.Arrays;

public class KthMissingPossitiveNumber {

    // Approach 01 : (Brute) This is my brute force approach to solve this problem.
    // Here I am following linear approach therefore time complexity of this
    // solution would be O(Max(arr) + k) which is nothing but a O(n) where n is the
    // length of the array.

    public static int findKthPositiveLinear(int[] arr, int k) {
        int max = Arrays.stream(arr).max().getAsInt();

        int[] vec = new int[(max + k) + 1];

        for (int i = 0; i < arr.length; i++) {
            vec[arr[i]]++;
        }

        int val = k;
        for (int i = 1; i < vec.length; i++) {
            if (vec[i] == 0) {
                --val;
                if (val == 0) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }

}
