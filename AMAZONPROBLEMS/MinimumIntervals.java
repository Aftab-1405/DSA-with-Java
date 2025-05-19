package AMAZONPROBLEMS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumIntervals {

    public static int[][] minimumIntervalsOptimal(int[][] intervals) {
        // Handle edge case
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] lastInterval = result.get(result.size() - 1);
            int lastEnd = lastInterval[1];

            // Check if current interval overlaps with the last interval in result
            if (intervals[i][0] <= lastEnd) {
                // Merge intervals by updating the end time
                lastInterval[1] = Math.max(lastEnd, intervals[i][1]);
            } else {
                // No overlap, add current interval to result
                result.add(intervals[i]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        int[][] result = minimumIntervalsOptimal(intervals);

        // Alternative detailed output format
        System.out.println("\nDetailed output:");
        for (int i = 0; i < result.length; i++) {
            System.out.println("Interval " + (i + 1) + ": [" + result[i][0] + ", " + result[i][1] + "]");
        }
    }
}