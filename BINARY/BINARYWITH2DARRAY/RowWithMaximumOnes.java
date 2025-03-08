package BINARY.BINARYWITH2DARRAY;

import java.util.Arrays;

public class RowWithMaximumOnes {

    public static int[] rowWithMaxOnes(int matrix[][]) {

        int maxCount = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < matrix.length; i++) {
            int count = 0;

            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                index = i;
            }
        }

        return new int[] { index, maxCount };
    }

    public static void main(String[] args) {
        int matrix[][] = { { 0, 1, 1, 1 }, { 0, 0, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 } };
        System.out.println(Arrays.toString(rowWithMaxOnes(matrix)));
    }

}
