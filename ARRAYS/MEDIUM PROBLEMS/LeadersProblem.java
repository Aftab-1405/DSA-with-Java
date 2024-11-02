import java.util.ArrayList;
import java.util.Collections;

public class LeadersProblem {

    // Approach 01: This is brute force approach where we can use two loop one for
    // picking one elements and other for linear seach on remaining elements to find
    // out whether the selected element is as leader or not. This will take O(n^2)
    // TC since we are using nested loop and space wouldd be same as optimal because
    // we have to store result somewhere.

    // Approach 02: This is an optimal solution which take TC as O(n) only since we
    // are using single loop but SC would be O(n) cause here we need to store the
    // leaders in arraylist so in worst case if all the elements of an array are
    // leaders then it will take O(n) sapce.
    public static ArrayList<Integer> findLeaders(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        int maxElement = Integer.MIN_VALUE;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] >= maxElement) {
                maxElement = arr[i];
                result.add(arr[i]);
            }
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 16, 17, 4, 3, 5, 2 };
        System.out.println(findLeaders(arr));
    }
}