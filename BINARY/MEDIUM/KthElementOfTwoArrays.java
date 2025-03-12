package BINARY.MEDIUM;

public class KthElementOfTwoArrays {

    public int kthElement(int a[], int b[], int k) {
        // Ensure 'a' is the smaller array
        if (a.length > b.length) {
            return kthElement(b, a, k);
        }

        int n = a.length;
        int m = b.length;
        int low = Math.max(0, k - m); // Minimum elements to take from 'a'
        int high = Math.min(k, n); // Maximum elements to take from 'a'

        while (low <= high) {
            int i = low + (high - low) / 2; // Partition in 'a'
            int j = k - i; // Partition in 'b'

            int aLeft = (i == 0) ? Integer.MIN_VALUE : a[i - 1];
            int aRight = (i == n) ? Integer.MAX_VALUE : a[i];
            int bLeft = (j == 0) ? Integer.MIN_VALUE : b[j - 1];
            int bRight = (j == m) ? Integer.MAX_VALUE : b[j];

            if (aLeft <= bRight && bLeft <= aRight) {
                // Valid partition
                return Math.max(aLeft, bLeft);
            } else if (aLeft > bRight) {
                // Move 'i' to the left
                high = i - 1;
            } else {
                // Move 'i' to the right
                low = i + 1;
            }
        }

        // Should never reach here if inputs are valid
        throw new IllegalArgumentException("Invalid input");
    }

    public static void main(String[] args) {
        KthElementOfTwoArrays kthElementOfTwoArrays = new KthElementOfTwoArrays();
        int a[] = { 2, 3, 6, 7, 9 };
        int b[] = { 1, 4, 8, 10 };
        int k = 5;
        System.out.println(kthElementOfTwoArrays.kthElement(a, b, k)); // Output: 6
    }

}
