public class SpiralPatternmatrixrix {
    /*
     * This problem only be having one single solution to which we can consider
     * brute, better and optimal solution. The time complexity of this solution is
     * O(n * m) since we are iterating for each element. For this current solution I
     * am directly printing spiral pattern but sometimes we needs to return this
     * pattern so at that time SC would be O(n * m) only.
     */
    public static void printSpiral(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;

        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++) {
                System.out.print(arr[top][i] + " ");
            }
            top++;
            System.out.println();

            for (int i = top; i <= bottom; i++) {
                System.out.print(arr[i][right] + " ");
            }
            right--;
            System.out.println();

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(arr[bottom][i] + " ");
                }
                bottom--;
            }
            System.out.println();

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(arr[i][left] + " ");
                }
                left++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };

        printSpiral(arr);
    }
}
