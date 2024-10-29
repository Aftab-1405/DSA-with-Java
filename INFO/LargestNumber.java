import java.util.Arrays;

public class LargestNumber {
    public static String largestNumber(int[] nums) {
        int n = nums.length;
        String[] str = new String[n];

        // Convert each integer to a string
        for (int i = 0; i < n; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        // Sort strings using a custom comparator
        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));

        // Build the largest number from sorted strings
        StringBuilder s = new StringBuilder();
        for (String ch : str) {
            s.append(ch);
        }

        // Handle the case where the largest number is "0"
        String result = s.toString();
        return result.startsWith("0") ? "0" : result;
    }

    public static void main(String[] args) {
        // Test cases
        int[] numbers1 = {1, 2, 3, 4, 5, 6};
        int[] numbers2 = {10, 2};
        int[] numbers3 = {3, 30, 34, 5, 9};
        int[] numbers4 = {0, 0};

        System.out.println(largestNumber(numbers1)); // Expected: "654321"
        System.out.println(largestNumber(numbers2)); // Expected: "210"
        System.out.println(largestNumber(numbers3)); // Expected: "9534330"
        System.out.println(largestNumber(numbers4)); // Expected: "0"
    }
}