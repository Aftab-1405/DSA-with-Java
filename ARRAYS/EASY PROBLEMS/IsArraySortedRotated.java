public class IsArraySortedRotated {
    // Method 01:
    public static boolean check01(int[] nums) {
        int len = nums.length;
        int count = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] > nums[(i + 1) % len]) {
                count++;
            }
        }

        return count <= 1;
    }

    // Method 02:
    public static boolean check02(int[] nums) {
        int len = nums.length;
        int count = 0;

        for (int i = 0; i < len - 1; i++) {
            if (nums[i] > nums[(i + 1)]) {
                count++;
            }
        }

        return count <= 1;
    }

    public static void main(String[] args) {
        int[] arr = { 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1 };
        if (check01(arr)) {
            System.out.println("Sorted and not rotated");
        } else {
            System.out.println("Sorted and rotated");
        }
    }
}
