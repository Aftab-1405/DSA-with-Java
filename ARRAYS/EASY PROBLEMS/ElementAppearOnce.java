import java.util.Arrays;

public class ElementAppearOnce {

    // Approach 01: This is a brute force approach to find element that appears once
    // in an array. This approach will take TC O(n^2) and SC O(1). Here we are not
    // using extra space.

    public static int elementFound1(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count == 1) {
                return arr[i];
            }
        }
        return -1;
    }

    // Approach 02: This is a better approach to find element that appears once,
    // where in we can utilize the hashing technique. Here we made little bit
    // improvements in terms of TC which is now O(2n) but we used extra space so
    // thats why out SC will be O(n).

    public static int elementFound2(int[] arr) {
        int max = Arrays.stream(arr).max().orElseThrow();
        int[] hash = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == 1) {
                return i;
            }
        }

        return -1;
    }

    // Approach 03: This is an optimal solution where we are using xor (Bitwise
    // Operator) to solve the problem In this solution we can reduce time upto O(n)
    // and SC will be O(n).

    public static int elementFound3(int[] arr) {
        int xorr = 0;
        for (int i = 0; i < arr.length; i++) {
            xorr = xorr ^ arr[i];
        }
        return xorr;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 3, 3, 4, 4 };
        System.out.println(elementFound3(arr));
    }

}
