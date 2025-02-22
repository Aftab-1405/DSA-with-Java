package BINARY.MEDIUM;

public class FindNthRootOfM {

    // Approach 01 : (Brute) This is a brute force solution where I am going through
    // each and every element and finding its powered value and after that checking
    // it with the given value. In best case the TC will be O(1) for this if we
    // would be able to caught first element as out result else in worst case TC
    // will be O(n).
    public static int findNthrootofMLinear(int n, int m) {
        if (n == 1)
            return m;

        // code here
        for (int i = 1; i <= m; i++) {
            if (Math.pow(i, n) == m) {
                return i;
            } else if (Math.pow(i, n) > m) {
                break;
            }
        }

        return -1;
    }

    // Approach 02: (Optimal) Here I am using binary search technique so this
    // solution will take logarithmic time to execute the ginen task. The TC for
    // this solution would be O(logn).
    public static int findNthrootofMBinary(int n, int m) {
        int low = 1;
        int high = m;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (Math.pow(mid, n) == m) {
                return mid;
            } else if (Math.pow(mid, n) > m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
