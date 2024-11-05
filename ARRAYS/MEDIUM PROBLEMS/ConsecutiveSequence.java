import java.util.Arrays;

public class ConsecutiveSequence {

    // Approach 01 : (Brute force) This is the brute force solution where I an using
    // two loops to interate over an array. First loop always take out one element
    // and second element perform a linear search to find out next element for
    // picked up element. This approach in worst case would require TC O(n^2). Since
    // we are not using any extra space so space complexity wouldd be O(1).
    public static int findLongestSequenceBrute(int[] arr) {
        int longestSequenceLength = 1;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];

            for (int j = 0; j < arr.length; j++) {
                if ((value + 1) == arr[j]) {
                    count++;
                    value = arr[j];
                }
            }
        }

        longestSequenceLength = Math.max(count, longestSequenceLength);

        return longestSequenceLength;
    }

    // Approach 02 : (Better) In this approach I am first sorting an entire array
    // and then looking for the consecutive sequence. This approach will take TC
    // O(nlogn) and space complexity O(1).
    public static int findLongestSequenceBetter(int[] arr) {
        Arrays.sort(arr);

        int lastSmaller = Integer.MIN_VALUE;
        int count = 0;
        int maxLength = 1;

        for (int i = 0; i < arr.length; i++) {
            // Skip duplicates to prevent resetting the sequence for duplicates
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            if (arr[i] - 1 == lastSmaller) {
                count++;
                lastSmaller = arr[i];
            } else {
                count = 1;
                lastSmaller = arr[i];
            }

            maxLength = Math.max(count, maxLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 6, 1, 9, 4, 5, 3 };
        System.out.println("Longest consecutive sequence length: " + findLongestSequenceBetter(arr));
    }

}
