import java.util.Arrays;

public class MajorityELements {

    // Approach 01: ( Brute Solution) This solution is utilizing two loops that will
    // lead to TC of O(n^2).

    public static int majorityElement01(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count > len / 2) {
                return arr[i];
            }
        }
        return -1;
    }

    // Approach 02 (Better Solution): This solution utilizes the hashing technique,
    // and based on that find out which element occurs more that the arr.length/2
    // times in and array. This will take extra space but minimizes the time
    // complexity. TC would be O(n) and SC would be O(n), since we are using hash.
    public static int majorityElement02(int[] arr) {
        int max = Arrays.stream(arr).max().orElseThrow();
        int[] hash = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > arr.length / 2) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 2, 3, 2, 1, 4 };
        System.out.println(majorityElement02(arr));
    }
}
