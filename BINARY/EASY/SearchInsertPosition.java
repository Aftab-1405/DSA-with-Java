package BINARY.EASY;

public class SearchInsertPosition {

    // Approach 01 : (Brute) This solution is utilizing the brute force approach
    // where I am just checking whether the next element is greater than or equal to
    // given element 'k'. If it does then that ith postion will be our insert
    // position.
    public static int searchInsertPosition(int[] arr, int k) {
        int i = 0;

        while (i < arr.length) {
            if (arr[i] >= k) {
                return i;
            }
            i++;
        }
        return arr.length;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 6 };
        System.out.println(searchInsertPosition(arr, 7));

    }
}