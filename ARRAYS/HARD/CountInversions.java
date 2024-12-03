package ARRAYS.HARD;

import java.util.ArrayList;

public class CountInversions {

    // Aprroach 01 : (Brute) This is my brute force approach which is being used to
    // count inversions for given array. Since I am using two nested loops so the
    // time complexity of this solution would be near about O(n^2) and if we could
    // talk about space complexity then it would be O(1) becuase we are not using
    // extra space rather than just count variable.
    public static int inversionCount(int arr[]) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    // Approach 02 : (Optimal) Here I am utilizing merge sort algorithm in order to
    // figure out all the counts of inversions. Since I am using merge sort
    // implementation the time complexity would be reduced to near about O(nLogn).
    public static int merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low; // starting index of left half of arr
        int right = mid + 1; // starting index of right half of arr

        // Modification 1: cnt variable to count the pairs:
        int cnt = 0;

        // storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                cnt += (mid - left + 1); // Modification 2
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
        return cnt; // Modification 3
    }

    public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high)
            return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid); // left half
        cnt += mergeSort(arr, mid + 1, high); // right half
        cnt += merge(arr, low, mid, high); // merging sorted halves
        return cnt;
    }

    public static int numberOfInversions(int[] a, int n) {
        // Count the number of pairs:
        return mergeSort(a, 0, n - 1);
    }

    public static void main(String[] args) {

        int[] arr = { 2, 4, 1, 3, 5 };
        System.out.println(inversionCount(arr));

        System.out.println(numberOfInversions(arr, arr.length));

    }
}
