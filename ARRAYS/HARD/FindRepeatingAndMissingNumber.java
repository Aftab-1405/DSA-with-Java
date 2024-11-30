package ARRAYS.HARD;

import java.util.ArrayList;

class FindRepeatingAndMissingNumber {

    // Approach 0: (Brute) This is brute force solution where I am first looping
    // from 1 to n, then I am looping on given array, finding out the number of
    // counts of each elements, if count is equals to 2 then that number will be my
    // repeating number and if count is equal to 0 then that number will be my
    // missing number. Since I am using 2 nested loop so the time complexity of this
    // solution would be O(n^2) and SC will be O(1) becuase no extra space is being
    // used here.
    public static ArrayList<Integer> findRepeatingMissingNumbersBrute(int[] arr) {
        int n = arr.length;
        int missingElement = -1;
        int repeatedElement = -1;

        ArrayList<Integer> values = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (arr[j] == i) {
                    count++;
                }
            }

            if (count == 2) {
                repeatedElement = i;
            }
            if (count == 0) {
                missingElement = i;
            }
        }

        values.add(repeatedElement);
        values.add(missingElement);

        return values;

    }

    // Approach 02: (Better) This is the better solution where I am using hashing
    // technique to find out count of occurences of each number after that I am
    // again iterating over the hash and looking for their values if value is 2 it
    // means that element is repeating and if value is 0 then that element is
    // missing. The SC of this solution would be O(n) becuase I am using hash of N+1
    // and TC will be O(2n) which is equivalent to O(n).
    public static ArrayList<Integer> findRepeatingMissingNumbersBetter(int[] arr) {

        int n = arr.length;
        int[] hash = new int[n + 1];

        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }

        int missingElement = -1;
        int repeatedElement = -1;
        ArrayList<Integer> values = new ArrayList<>();

        for (int i = 1; i < hash.length; i++) {
            if (hash[i] == 2) {
                repeatedElement = i;
            } else if (hash[i] == 0) {
                missingElement = i;
            }
        }

        values.add(repeatedElement);
        values.add(missingElement);

        return values;
    }

    public static void main(String[] args) {

        int[] arr = { 4, 3, 6, 2, 1, 1 };
        System.out.println(findRepeatingMissingNumbersBetter(arr));
    }
}