package ARRAYS.HARD;

import java.util.*;

public class TripletSum {
    /*
     * Approach 01: (Brute) This is the brute force solution where I am using three
     * loop in order to find out the triplets which will leads to sumation of 0.
     * Since we are using 3 loops so the TC will be O(n^3) and space complexity
     * would be O(n^3) if all the triplets are unique.
     */
    public static List<List<Integer>> tripletBrute(int n, int[] arr) {
        Set<List<Integer>> st = new HashSet<>();

        // check all possible triplets:
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        temp.sort(null);
                        st.add(temp);
                    }
                }
            }
        }

        // store the set elements in the answer:
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }

    /*
     * Approach 02 : (Better) This is the better approach where I am using hash set
     * to store and find third elements so that I could form a proper triplates.
     * This approach allows us to solve a problem with TC as O(n^2) only. In worst
     * case overall space complexity of this solution is O(n^2) only.
     */
    public static List<List<Integer>> tripletBetter(int n, int[] arr) {
        HashSet<List<Integer>> st = new HashSet<>();

        for (int i = 0; i <= n - 2; i++) {
            HashSet<Integer> hashset = new HashSet<>();
            for (int j = i + 1; j <= n - 1; j++) {
                // Calculate the 3rd element:
                int third = -(arr[i] + arr[j]);

                // Find the element in the set:
                if (hashset.contains(third)) {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    temp.sort(null);
                    st.add(temp);
                }
                hashset.add(arr[j]);
            }
        }

        // store the set elements in the answer:
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }

    /*
     * Variation of 2nd approach where x value is given and we have to find out
     * triplates which makes the given sum x. GFG problem asked in: Accolite,
     * Amazon, Microsoft, OYO Rooms, Samsung, CarWale
     */
    // public static boolean find3Numbers(int arr[], int n, int x) {
    // // Loop through each element to find a triplet
    // for (int i = 0; i < n - 2; i++) {
    // HashSet<Integer> thirdElements = new HashSet<>();

    // // Inner loop to check for pairs with the first element arr[i]
    // for (int j = i + 1; j < n; j++) {
    // // Calculate the third element needed to reach the sum x
    // int third = x - (arr[i] + arr[j]);

    // // Check if the third element exists in the set
    // if (thirdElements.contains(third)) {
    // return true; // Triplet found
    // }

    // // Add the current element arr[j] to the set for future pair checks
    // thirdElements.add(arr[j]);
    // }
    // }

    // // No triplet found
    // return false;
    // }

    public static List<List<Integer>> tripletOptimal(int n, int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            // remove duplicates:
            if (i != 0 && arr[i] == arr[i - 1])
                continue;

            // moving 2 pointers:
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    // skip the duplicates:
                    while (j < k && arr[j] == arr[j - 1])
                        j++;
                    while (j < k && arr[k] == arr[k + 1])
                        k--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        int n = arr.length;
        List<List<Integer>> ans = tripletBrute(n, arr);
        for (List<Integer> it : ans) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }
}
