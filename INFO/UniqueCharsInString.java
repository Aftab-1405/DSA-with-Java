import java.util.HashSet;
import java.util.ArrayList;

public class UniqueCharsInString {
    // Approach 01: This is a brute force approach to find out unique characters in
    // a string. This will take O(n^2) time and space O(n).
    public static int uniqueChars01(String str) {

        char[] ch = str.toCharArray();
        ArrayList<Character> list = new ArrayList<Character>();

        for (int i = 0; i < ch.length; i++) {
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[i] == ch[j]) {
                    break;
                }
            }
            list.add(ch[i]);
        }

        return list.size();

    }

    // Approach 02: This is an optimal approach for creating unique characters HashSet and time complexity is O(n) and space complexity O(n).
    public static int uniqueChars02(String str) {
        // Here we are using HashSet to keep only unique characters in HashSet's object.
        HashSet<Character> chars = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            chars.add(str.charAt(i));
        }

        return chars.size();
    }

    public static void main(String[] args) {
        String s = "Aftab";
        System.out.println(uniqueChars01(s));
    }
}
