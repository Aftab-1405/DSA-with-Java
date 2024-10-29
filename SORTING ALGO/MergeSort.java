import java.util.ArrayList;

public class MergeSort {
    public static ArrayList<Integer> merge(int[] arr, int l, int h) {
        int mid = (l + h) / 2;
        int i = l;
        int j = mid + 1;

        ArrayList<Integer> sortedArray = new ArrayList<Integer>();

        while (i <= mid && j <= h) {
            if (arr[i] < arr[j]) {
                sortedArray.add(arr[i++]);
            } else {
                sortedArray.add(arr[j++]);
            }
        }

        // Add the remaining elements from the left half
        while (i <= mid) {
            sortedArray.add(arr[i++]);
        }

        // Add the remaining elements from the right half
        while (j <= h) {
            sortedArray.add(arr[j++]);
        }

        return sortedArray;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 4, 3, 5, 9, 1, 2, 8, 10 };
        int low = 0;
        int high = arr.length - 1;
        ArrayList<Integer> sortedList = merge(arr, low, high);

        System.out.println(sortedList);
    }
}