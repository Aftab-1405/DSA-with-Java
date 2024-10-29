import java.util.Arrays;

public class CountSort {
    public static void sort(int[] arr) {
        int max = Arrays.stream(arr).max().orElse(Integer.MIN_VALUE);
        
        int[] countArray = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            countArray[arr[i]]++;
        }

        int j = 0;
        int k = 0;

        while (j < countArray.length) {
            if (countArray[j] > 0) {
                arr[k++] = j;
                countArray[j]--;
            } else {
                j++;
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 2, 6, 7, 1, 25, 77 };
        sort(arr);
        for (int x : arr) {
            System.out.println(x + " ");
        }
    }
}
