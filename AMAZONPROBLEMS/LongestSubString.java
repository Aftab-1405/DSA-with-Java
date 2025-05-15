package AMAZONPROBLEMS;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {

    // Approach 01 : (Brute) This solution is a brute force solution which is using
    // nested loop and one hash table of 256 size. So the TC would be O(n)2 in wrost
    // case and SC would be O(256).

    public static int maxSubStringLengthBrute(String s) {
        int[] arr = new int[256];
        int maxLength = 0;
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            for (int j = i; j < str.length; j++) {
                if (arr[str[j]] == 0) {
                    arr[str[j]]++;
                } else {
                    break;
                }
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        return maxLength;
    }

    // Approach 02 : (Optimized) Since this solution is using sliding window
    // technique, we have to iterate over the array just single time hence the TC
    // would be O(n) and SC would be unique of O(n).

    public static int maxSubStringLengthOptimized(String s) {
        char[] str = s.toCharArray();
        int left = 0, right = 0;
        int maxLength = 0;

        Map<Character, Integer> map = new HashMap<>();
        while (right < str.length) {
            if (map.containsKey(str[right]) && map.get(str[right]) >= left) {
                left = map.get(str[right]) + 1;
            }
            map.put(str[right], right);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String s = "abcabcbb";
        int result = maxSubStringLengthOptimized(s);
        System.out.println("The length of the longest substring without repeating characters is: " + result);
    }
}
