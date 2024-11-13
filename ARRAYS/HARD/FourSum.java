package ARRAYS.HARD;

import java.util.*;

public class FourSum {

    // Approach 01: (Brute) This is the same solution that were did for 3 sum
    // problem, the only difference is that here I am using 4 loops since our task
    // is to find out quadruples. The time complexity of this solution would be
    // O(n^4) and the space complexity is O(n^4) in the worst case.

    public static List<List<Integer>> fourSumBrute(int n, int[] arr, int target) {
        Set<List<Integer>> st = new HashSet<>();

        // Check all possible quadruples:
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (arr[i] + arr[j] + arr[k] + arr[l] == target) {
                            List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                            Collections.sort(temp);
                            st.add(temp);
                        }
                    }
                }
            }
        }

        // Store the set elements in the answer:
        return new ArrayList<>(st);
    }

    // Approach 02: (Better) In this approach I am using hashset in order to store
    // 4th element. Since this approacch is using only 3 loops so the time
    // complexity would be O(n^3) and space complexity also O(n^3) if all triplets
    // are unique which is worst case.

    public static List<List<Integer>> fourSumBetter(int n, int[] arr, int target) {
        HashSet<List<Integer>> st = new HashSet<>();
        Arrays.sort(arr); // Sort to handle duplicates easily

        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                HashSet<Integer> hashset = new HashSet<>();
                int remainingSum = target - (arr[i] + arr[j]);

                for (int k = j + 1; k < n; k++) {
                    int fourth = remainingSum - arr[k];
                    if (hashset.contains(fourth)) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], fourth);
                        Collections.sort(temp); // Sorting to avoid duplicates
                        st.add(temp);
                    }
                    hashset.add(arr[k]);
                }
            }
        }

        return new ArrayList<>(st);
    }

    // Approach 03: (Optimal) In this approach I am just trying to get rid of the
    // extra hash set we were using to store fourth element. Here I am using 2
    // pointer approach to solve this problem. The time complexity remains the same
    // as better solution but space complexity would be reduced to O(k), where k is
    // the number of unique quadruples.

    public static List<List<Integer>> fourSumOptimal(int n, int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < n - 3; i++) {
            // Skip duplicates for the first number
            if (i > 0 && arr[i] == arr[i - 1])
                continue;

            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates for the second number
                if (j > i + 1 && arr[j] == arr[j - 1])
                    continue;

                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    int sum = arr[i] + arr[j] + arr[left] + arr[right];
                    if (sum == target) {
                        ans.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));

                        // Skip duplicates for the third and fourth numbers
                        while (left < right && arr[left] == arr[left + 1])
                            left++;
                        while (left < right && arr[right] == arr[right - 1])
                            right--;

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 0, -1, 0, -2, 2 };
        int n = arr.length;
        int target = 0;

        List<List<Integer>> ans = fourSumOptimal(n, arr, target);

        for (List<Integer> quad : ans) {
            System.out.print("[");
            for (Integer num : quad) {
                System.out.print(num + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }

}
