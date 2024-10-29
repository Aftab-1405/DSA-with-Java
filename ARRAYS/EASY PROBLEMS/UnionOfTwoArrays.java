import java.util.ArrayList;

public class UnionOfTwoArrays {

    public static ArrayList<Integer> unionOfTwoArrays(int[] l, int[] r) {
        int i = 0;
        int j = 0;

        ArrayList<Integer> result = new ArrayList<Integer>();

        while (i < l.length && j < r.length) {
            // Step 1: Handle duplicates of each array.
            while (i > 0 && i < l.length && l[i] == l[i - 1]) {
                i++;
            }

            while (j > 0 && j < r.length && r[j] == r[j - 1]) {
                j++;
            }

            // Step 2: Handle array exhausting conditions.
            if (i >= l.length) {
                result.add(r[j]);
                j++;
                continue;
            }

            if (j >= r.length) {
                result.add(l[i]);
                i++;
                continue;
            }

            // Step 3: Compare two arrays
            if (l[i] < r[j]) {
                result.add(l[i]);
                i++;
            } else if (l[i] > r[j]) {
                result.add(r[j]);
                j++;
            } else {
                result.add(l[i]);
                i++;
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] left = { 1, 1, 2, 3, 3, 4, 5, 5 };
        int[] right = { 2, 4, 6 };
        System.out.println(unionOfTwoArrays(left, right));
    }
}