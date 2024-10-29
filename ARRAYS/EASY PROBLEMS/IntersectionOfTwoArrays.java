import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoArrays {

    // Approach 01 -> Brute force : This method using two loop approah and hashing
    // to solve the problem.

    public static ArrayList<Integer> intersect(int[] array1, int[] array2) {
        int lenA = array1.length;
        int lenB = array2.length;
        int visSize;
        if (lenA < lenB) {
            visSize = lenA;
        } else {
            visSize = lenB;
        }

        int[] visArray = new int[visSize];

        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < lenA; i++) {
            for (int j = 0; j < lenB; j++) {
                if (array1[i] == array2[j] && visArray[j] == 0) {
                    result.add(array1[i]);
                    visArray[j] = 1;
                    break;
                }

                if (array1[i] < array2[j]) {
                    break;
                }
            }

        }

        return result;
    }

    // Approach 02: This is an optimal implementation for intersection of two
    // arrays, where two pointers approach is being used. One more edge case is
    // resolved in this implementation which is our intesection result should not
    // have duplicates.
    public static ArrayList<Integer> intersectOptimal(int[] arr1, int[] arr2) {
        // Function to return a list containing the intersection of two arrays.
        int i = 0;
        int j = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();

        // Using two pointers to traverse both arrays
        while (i < arr1.length && j < arr2.length) {
            // If arr1[i] is smaller, move the pointer i
            if (arr1[i] < arr2[j]) {
                i++;
            }
            // If arr2[j] is smaller, move the pointer j
            else if (arr1[i] > arr2[j]) {
                j++;
            }
            // If both elements are the same, check for duplicates
            else {
                // Add the common element only if it is not a duplicate
                if (result.isEmpty() || result.get(result.size() - 1) != arr1[i]) {
                    result.add(arr1[i]);
                }
                // Move both pointers forward
                i++;
                j++;
            }
        }

        // If no intersection was found, return -1
        return result.isEmpty() ? new ArrayList<>(List.of(-1)) : result;
    }

    public static void main(String[] args) {

        int[] arr1 = { 1, 1, 2, 3, 4, 5, 5, 6 };
        int[] arr2 = { 2, 2, 4, 4, 7 };
        System.out.println(intersectOptimal(arr1, arr2));

    }

}
