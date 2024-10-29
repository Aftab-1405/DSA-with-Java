public class MatrixMultiplication {

    // Function to multiply two matrices and return the result
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;

        // Check if multiplication is possible (columns of matrix1 must equal rows of
        // matrix2)
        if (cols1 != rows2) {
            throw new IllegalArgumentException("Matrix multiplication not possible: incompatible dimensions.");
        }

        int[][] result = new int[rows1][cols2]; // Resultant matrix of size rows1 x cols2

        // Perform matrix multiplication
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                result[i][j] = 0; // Initialize the cell
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result; // Return the resulting matrix
    }

    public static void main(String[] args) {
        // Example matrices
        int[][] matrix1 = {
                { 1, 2 },
                { 3, 4 },
                { 3, 1 }
        };

        int[][] matrix2 = {
                { 5, 6, 1 },
                { 7, 8, 8 }
        };

        // Call the multiplyMatrices function and get the result
        int[][] result = multiplyMatrices(matrix1, matrix2);

        // Print the result
        System.out.println("Product of the matrices is:");
        for (int x[] : result) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
