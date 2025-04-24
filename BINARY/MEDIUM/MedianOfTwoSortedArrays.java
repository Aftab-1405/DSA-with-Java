package BINARY.MEDIUM;

public class MedianOfTwoSortedArrays {

    // Approach 01: (Linear) Merge the two sorted arrays and find the median in O(N)
    // time.
    public static double medianOf2Linear(int nums1[], int nums2[]) {
        // Your Code Here
        int[] merged = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;

        // Merge the two sorted arrays
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        // Add remaining elements from nums1
        while (i < nums1.length) {
            merged[k++] = nums1[i++];
        }

        // Add remaining elements from nums2
        while (j < nums2.length) {
            merged[k++] = nums2[j++];
        }

        // Find the median
        int mid = merged.length / 2;
        if (merged.length % 2 == 0) {
            return (merged[mid - 1] + merged[mid]) / 2.0;
        } else {
            return merged[mid];
        }
    }

    // Approach 02 : (Optimal) Using Binary Search to find the median of two sorted
    // arrays in O(log(min(N, M))) time complexity.

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;
        int low = 0, high = x;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            // Handle edge cases for partitions
            int maxX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
            int maxY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            // Check if the partition is correct
            if (maxX <= minY && maxY <= minX) {
                // Found the correct partition
                if ((x + y) % 2 == 0) {
                    return (Math.max(maxX, maxY) + Math.min(minX, minY)) / 2.0;
                } else {
                    return Math.max(maxX, maxY);
                }
            } else if (maxX > minY) {
                // Move partitionX left
                high = partitionX - 1;
            } else {
                // Move partitionX right
                low = partitionX + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted.");
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2 };
        System.out.println(medianOf2Linear(nums1, nums2)); // Output: 2.0

        int[] nums3 = { 1, 2 };
        int[] nums4 = { 3, 4 };
        System.out.println(findMedianSortedArrays(nums3, nums4)); // Output: 2.5
    }
}
