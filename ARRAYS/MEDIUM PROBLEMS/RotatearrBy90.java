public class RotatearrBy90 {

    /*
     * My Approach: This solution is not derived from standard methods. It
     * reflects my intuition and thought process with respect to the problem. What
     * I'm doing here is taking out the "max" element of the matrix and following
     * a bottom-up approach. I start from the last row and the first column, then
     * in the next iteration, I change the column and reset the row to arr.length
     * - 1. This is because I need to start again from the last row concerning the
     * next column. Each time, I reduce the max element by one. This solution
     * currently only works for matrices with consecutive elements. If there is a
     * possibility to generalize it, I will do so and post the update, but if you
     * can suggest any optimizations to my logic, I would be grateful.
     */
    public static int[][] rotate90OwnLogic(int[][] arr, int max) {
        int maxEle = max;
        int i = 0;

        while (i < arr[0].length) {
            int row = (arr.length - 1);
            while (row >= 0) {
                arr[row--][i] = maxEle--;
            }
            i++;
        }

        return arr; // Return the modified arr
    }

    /*
     * Approach 01 : (Brute) Here we are using two loops in order to rotate an
     * square arr to 90 degree clockwise, so the TC would be near about O(n^2) since
     * we are looping through entire array and space complexity would be O(1)
     * becuase I am doing it inplace.
     */

    public static int[][] rotate90Brute(int[][] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[j][n - 1 - i] = arr[i][j];
            }
        }

        return arr;
    }

    /*
     * Approach 02: (Optimal) This is an optimla approach where array rotation at 90
     * degree clockwise can be done in two steps where first step iclude transposing
     * the entire arraya and then reversing it in row wise.
     * The time complexity for tranposition of an array would be O(N/2 * N/2)
     * since I am working only on half of the array and for reversing it TC would be
     * O(N * N/2) so the total TC would be O(N/2 * N/2) + O(N * N/2). SC is still
     * O(1).
     */
    public static int[][] rotate90Optimal(int[][] arr) {
        // Step 01 : Transpose the arr by keeping diagonal intact.

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length / 2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][arr.length - 1 - j];
                arr[i][arr.length - 1 - j] = temp;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };

        int[][] rotatedArr = rotate90Brute(arr);

        // Print the rotated arr
        for (int i = 0; i < rotatedArr.length; i++) {
            for (int j = 0; j < rotatedArr[0].length; j++) {
                System.out.print(rotatedArr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
