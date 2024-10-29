import java.util.Arrays;

public class RemoveDuplicates {

    // Method 01: This is the solution where in you can just create your own set and put elements inside it and return its count thats it. No need to code here

    // Method 02 : This is an optimal solution which uses minimal time and space complexity i.e., O(n).
    
    public static int uniqueElements(int[] arr) {

        Arrays.sort(arr); // Sort the array first in case given array is not sorted correctly.

        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                arr[i + 1] = arr[j];
                i++;
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 3, 3, 4, 5, 5, 4, 6, 1, 1 };
        System.out.println(uniqueElements(arr));
    }
}
