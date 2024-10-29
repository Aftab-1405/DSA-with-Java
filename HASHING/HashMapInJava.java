package HASHING;

import java.util.HashMap;

public class HashMapInJava {

    public static void main(String[] args) {

        String s = "abcdeabcdeabcdefghifhifghijklmnjklmnnnomns";

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character key = s.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        // To print the map to see the frequency of characters
        System.out.println(map);
    }
}
