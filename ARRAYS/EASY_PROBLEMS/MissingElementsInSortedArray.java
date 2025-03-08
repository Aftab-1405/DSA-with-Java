package ARRAYS.EASY_PROBLEMS;

import java.util.ArrayList;

public class MissingElementsInSortedArray {

    public static void findMissingElements(int[] arr) {
        ArrayList<Integer> missingValues = new ArrayList<Integer>();

        for (int i = 0; i < arr.length - 1; i++) { // Fix for ArrayIndexOutOfBoundsException
            if ((arr[i + 1] - arr[i]) == 1) {
                // No missing value
            } else {
                missingValues.add(arr[i] + 1); // Fix to add actual missing values
            }
        }

        for (int i = 0; i < missingValues.size(); i++) {
            System.out.println(missingValues.get(i));
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 5, 7, 8, 10 };
        findMissingElements(arr);
    }
}
