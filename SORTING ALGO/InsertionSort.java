/*

 * This algorithm takes:
 * 1. Comarisons = n -1 (max to max)
 * 2. Swaps = n -1 (max to max)
 * 3. Adaptive = By nature it is adaptive and we dont need to inroducing flag to make it adaptive.
 * 4. Stable = Yes, In case of duplicate elemets it dont change their positions.
    -------------------------------------------------------------------------------------------------
 * Worst Case Time Complexity = O(n^2) if array is sorted in desceding or randomly scattered.
 * Best Case Time Complexity = Ω(n) if array is sorted in ascending order.

 */

public class InsertionSort {

    public static void sort(int[] arr) {
        int n = arr.length - 1;
        for (int i = 0; i <= n; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 1, 5, 7, 3, 9, 15 };
        sort(arr);
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
