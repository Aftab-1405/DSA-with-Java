/*
    If the input array is in already sorting either in ascending or descending order then this algorithm performs worst in that case. However if the array is not sorted then it performs better, in this case it might be having "O(nlogn)" time complexity. But in case of sorted input time complexity would be "O(n^2)". So in this case if we select pivot as a middle element then we can be able to redule time complexity up to a certain threshold.
 */

public class QuickSort {
    public static int partion(int[] arr, int start, int end) {

        int pivot = arr[start]; // Select pivot as a middle element if input array is already sorted.
        int i = start;
        int j = end;

        while (i <= j) {
            while (i <= end && arr[i] <= pivot) {
                i++;
            }

            while (j >= start && arr[j] > pivot) {
                j--;
            }

            if (i < j) {
                int temp_01 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp_01;
            }
        }

        int temp_02 = arr[start];
        arr[start] = arr[j];
        arr[j] = temp_02;
        return j;
    }

    public static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int partion = partion(arr, start, end);
            sort(arr, start, partion - 1);
            sort(arr, partion + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 4, 2, 5, 7, 3, 8, 10, 12, 0, 6 };
        int end = arr.length - 1;
        sort(arr, 0, end);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
