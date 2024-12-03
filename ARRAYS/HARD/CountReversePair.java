package ARRAYS.HARD;

public class CountReversePair {

    // Approach 01 : (Brute)
    public static int countRevPairsBrute(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((long) arr[i] > 2L * (long) arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // Appproach 02 : (Optimal)
    public static int countRevPairs(int N, int arr[]) {
        return mergeSort(arr, 0, N - 1);
    }

    private static int mergeSort(int[] nums, int left, int right) {
        if (left >= right)
            return 0;

        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);

        count += merge(nums, left, mid, right);
        return count;
    }

    private static int merge(int[] nums, int left, int mid, int right) {
        int count = 0;
        int j = mid + 1;

        // Count reverse pairs
        for (int i = left; i <= mid; i++) {
            while (j <= right && (long) nums[i] > 2L * (long) nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }

        // Merge sorted arrays
        int[] temp = new int[right - left + 1];
        int k = 0;
        int p1 = left, p2 = mid + 1;

        while (p1 <= mid && p2 <= right) {
            temp[k++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }

        while (p1 <= mid)
            temp[k++] = nums[p1++];
        while (p2 <= right)
            temp[k++] = nums[p2++];

        // Copy back to original array
        System.arraycopy(temp, 0, nums, left, temp.length);

        return count;
    }

    public static void main(String[] args) {

    }

}
