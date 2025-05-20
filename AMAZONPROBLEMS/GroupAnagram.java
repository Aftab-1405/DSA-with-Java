package AMAZONPROBLEMS;

import java.util.*;

public class GroupAnagram {

    // Approach 01 : In this solution, the entire string array's elements are being
    // sorted and then checking for an anagram. This leads to the TC of K * nlogn,
    // where K => size of an array and n => size of each array element which is
    // being sorted.

    public static List<List<String>> groupAnagramsBruteList(String[] strs) {
        // Step 1: Create a HashMap to group anagrams
        Map<String, List<String>> map = new HashMap<>();

        // Step 2: Iterate over each string in the array
        for (String str : strs) {
            // Step 3: Convert string to char array, sort it, then create a key
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = new String(charArray);

            // Step 4: Check if the key exists. If not, create a new list
            if (!map.containsKey(sortedKey)) {
                map.put(sortedKey, new ArrayList<>());
            }

            // Step 5: Add the string to the corresponding list
            map.get(sortedKey).add(str);
        }

        // Step 6: Return the values of the map as an ArrayList
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        String[] arr = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagramsBruteList(arr));
    }
}
