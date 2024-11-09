package ARRAYS.HARD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class N3TimesProblem {

    /*
     * Approach 01 : (Brute) This approach might end up taking TC as P(n^2) becuase
     * we are using two loops here. Space complexity would be O(2) becuase at max it
     * will store two elements.
     */

    public static ArrayList<Integer> findElementsN3Brute(int[] arr) {

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) { // O(n)
            int count = 0;
            if (!result.contains(arr[i])) {
                for (int j = 0; j < arr.length; j++) { // O(n)
                    if (arr[i] == arr[j]) {
                        count++;
                        if (count > arr.length / 3) {
                            result.add(arr[i]);
                        }
                    }
                }
            }
        }

        return result;
    }

    /*
     * Approach 02: (Better) This is the better approach where I am using HashMap to
     * store all unique elements with there count. This approach requires only a
     * single loop to solve the entire problem. Hence the TC will be O(n) and TC
     * would be O(n + 2) becuase in worst case HashMap will store all the unique
     * elements and ArrayList at max store 2 values.
     */

    public static ArrayList<Integer> findElementsN3Better(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> countMap = new HashMap<>();

        int min = nums.length / 3;

        // First pass: count occurrences
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Second pass: collect elements with count > n/3
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > min) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 1, 3, 3, 3, 2, 2, 2, 2 };
        System.out.println(findElementsN3Better(arr));
    }

}
