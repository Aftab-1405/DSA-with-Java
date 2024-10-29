package RECURSION;

public class Palindrome {

    // Approach 01: Iterative Method
    public static boolean isPalindromeCheck(String name, int i) {
        for (i = 0; i < name.length() / 2; i++) {

            if (name.charAt(i) != name.charAt(name.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    // Approach 02: Recursive Method
    public static boolean isPalindrome(String name, int i) {

        if (i >= name.length() / 2) {
            return true;
        }

        if (name.charAt(i) != name.charAt(name.length() - i - 1)) {
            return false;
        }

        return isPalindrome(name, i + 1);

    }

    public static void main(String[] args) {
        String name = "Aftab";
        System.out.println(isPalindromeCheck(name, 0));
    }
}
