package ARRAYS.HARD;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    // Approach 01: (Brute) This is the brute force approach where I am using 2
    // pointers approach to iterate over both the sorted arrays and compying them
    // into extra array with size of a.length + b.length. This approach will take TC
    // as O(n + m) and SC will be O(n + M).

    public static void mergeArraysBrute(int a[], int b[]) {
        // Create a new array of the exact combined size
        int[] arr = new int[a.length + b.length];
        int i = 0; // Pointer for a[]
        int j = 0; // Pointer for b[]
        int k = 0; // Pointer for arr[]

        // Merge a[] and b[] into arr[]
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                arr[k] = a[i];
                i++;
            } else {
                arr[k] = b[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from a[] (if any)
        while (i < a.length) {
            arr[k] = a[i];
            i++;
            k++;
        }

        // Copy remaining elements from b[] (if any)
        while (j < b.length) {
            arr[k] = b[j];
            j++;
            k++;
        }

        // Distribute arr[] back to a[] and b[]
        for (int l = 0; l < arr.length; l++) {
            if (l < a.length) {
                a[l] = arr[l]; // Fill a[] first
            } else {
                b[l - a.length] = arr[l]; // Fill remaining in b[]
            }
        }
    }

    // Approach 02: (Optimal) This is the optimal approach where I am used a simple
    // logic, where from first array I am looking for max element and from second
    // array I am looking for smaller elements. After that if any element from 2nd
    // array is smaller than in 1st array then I am swapping them and at last I am
    // again sorting both the arrays. This approach will take time near about O(n)
    // in worst case if all the elements from 2nd array would be smaller and SC will
    // be O(1) since we are not using any extra space.
    public static void mergeArraysOptimal(int a[], int b[]) {
        int lenA = a.length - 1;
        int lenB = 0;

        while (lenA >= 0 && lenB < b.length) {
            if (a[lenA] > b[lenB]) {
                int temp = a[lenA];
                a[lenA] = b[lenB];
                b[lenB] = temp;
            }

            lenA--;
            lenB++;
        }

        Arrays.sort(a);
        Arrays.sort(b);
    }

    public static void main(String[] args) {

        int a[] = { 1, 5, 9, 10, 15, 20 };
        int b[] = { 2, 3, 8, 13 };
        mergeArraysOptimal(a, b);
    }

}
