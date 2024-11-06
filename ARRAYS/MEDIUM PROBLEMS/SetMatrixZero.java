public class SetMatrixZero {

    /*
     * Approach 01 : ( Brute ) This is the brute force approacch where I am using
     * two helper functions (1 loop each) and setMatrixZero function to do rest of
     * the task. So the time complexity of this solution would be near about O(n^3)
     * becuase for two helper functions it would be O(n) + O(m), in
     * setMatrixFunxtion first to find out zeros TC would be O(n^2) and for marking
     * all -1 elements to 0 again will end up with TC as O(n^2) so hence
     * approxmately we can say this solution might end up taking O(n^3) time in
     * worst case. SC would be O(1) only.
     */

    /*
     * This is a helper function uased to set a row's non-zero elements to -1 if we
     * encounter arr[i][j] == 0 in main setMatrixZero() function.
     */
    private static void markNegativeOneRow(int i, int[][] arr) {
        for (int j = 0; j < arr[i].length; j++) {
            if (arr[i][j] != 0) {
                arr[i][j] = -1;
            }
        }
    }

    // This is a helper function uased to set a column's
    // non-zero elements to -1 if we encounter arr[i][j] ==
    // 0 in main setMatrixZero() function.
    private static void markNegativeOneColumn(int j, int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][j] != 0) {
                arr[i][j] = -1;
            }
        }
    }

    public static void setMatrixZeroesBrute(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    markNegativeOneRow(i, arr); // Calling row set -1 helper function
                    markNegativeOneColumn(j, arr); // // Calling column set -1 helper function
                }
            }
        }

        // Iterating again and marking all the elements that are marked -1.
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == -1) {
                    arr[i][j] = 0;
                }
            }
        }
    }

    /*
     * Approach 02: (Better) Here I ma trying to pull down TC from O(n^3) to near
     * about O(2n^2), but in order to acheive this we had to use extra arrays to
     * keep track of which column and row has at least single '0' inside it.
     */

    public static void setMatrixZeroesBetter(int[][] arr) {
        int[] row = new int[arr.length];
        int[] column = new int[arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (row[i] == 1 || column[j] == 1) {
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 }
        };
        setMatrixZeroesBrute(arr);
    }

}
