package ARRAYS.HARD;

import java.util.ArrayList;

public class PascalTriangle {

    /*
     * Vairation No 01: In this variation you have just given a row and column
     * number and you have to find the element present at that position in pascal
     * triangle.
     * Approach: The time complexity of this solution would be O(r)
     * becuase we are running a loop 'r' times. Space complexity would be O(1).
     */
    public static long nCr(int n, int r) {
        long res = 1;

        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i); // (n-0), (n-1), (n-2) .... (n-(r-1)).
            res = res / (i + 1);
        }
        return res;
    }

    /*
     * VARIATION NO 02: In this variation you would have asked to print entire row
     * for given 'nth' row.
     */
    /*
     * * Approach 01 :(Brute for variation no 02) In this approach I am just calling
     * the nCr function and
     * running
     * a loop to pass a column so that it would calculate element at each position.
     * Since we are calling function which state TC as O(r) and we are running loop
     * n times so this approach might end up taking TC near about O(n * r).
     */
    public static void pascalTriangleRowBute(int n) {
        // printing the entire row n:
        for (int c = 0; c < n; c++) {
            System.out.print(nCr(n - 1, c) + " ");
        }
        System.out.println();
    }

    /*
     * Approach No 02: (Optimal for variation no 02) This is the optimal solution
     * for variation number 2, here
     * instead of calling nCr() function each time, I have written a complete new
     * logic where first result is being kept 1 and then calculation would be done
     * as per logic. This solution boil down the TC to O(n) only since we are using
     * single loop.
     */
    public static void pascalTriangleRowOptimal(int n) {
        int result = 1;
        System.out.print(result + " ");
        // printing the entire row n:
        for (int c = 1; c < n; c++) {
            result = result * (n - c);
            result = result / c;
            System.out.print(result + " ");
        }
        System.out.println();
    }

    /*
     * VARIATION NO 03: In this variation there might be a chance where interviewer
     * ask to print entire pascal triangle for given n.
     */

    /*
     * Approach No 01: ( Brute for variation 03) In this approach we can call the
     * first nCr function
     * to print out our triangle. This solution might end up taking O(n^3) time
     * complexity, thats why we need to improve this solution.
     */
    public static void printPascalTriangleBrute(int n) {
        ArrayList<Long> resultantRow;

        for (int row = 0; row < n; row++) {
            resultantRow = new ArrayList<>();
            for (int column = 0; column <= row; column++) {
                long element = nCr(row, column); // Corrected order: nCr(row - 1, column - 1)
                resultantRow.add(element);
            }
            System.out.println(resultantRow); // Print each row of the triangle separately
        }
    }

    /*
     * Approach No 02: (Better for variation 03) In this approach I am calling the
     * pascalTriangleRowOptimal(i) function which is optimized to print a single row
     * with TC of O(n) and passing it i as a n. This will allow to print all the
     * pascal triangle with TC of O(n^2)
     */
    public static void printPascalTriangleOptimal(int n) {
        for (int i = 1; i <= n; i++) {
            pascalTriangleRowOptimal(i);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        printPascalTriangleOptimal(n);
    }

}
