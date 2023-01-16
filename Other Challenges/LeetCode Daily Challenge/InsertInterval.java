package Daily_Challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        int[][] newArrayInterval = insert(intervals, newInterval);
        for (int[] interval : newArrayInterval) {
            System.out.println(Arrays.toString(interval));
        }
    }

    static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> newArrayInterval = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            // If the Interval second element is lessthan new Intervals first element add the current array to LIST
            if (intervals[i][1] < newInterval[0]) {
                newArrayInterval.add(intervals[i]);
            }

            //If the interval first element is greater than new interval second element then add current array to LIST
            else if (intervals[i][0] > newInterval[1]) {
                newArrayInterval.add(newInterval);
                newInterval = intervals[i];
            }

            // In case of both skips then assign the minimum among first elements of newInterval and current array to first value of new interval
            // Then assign the maximum value of second element of newInterval and current array to the second element of new interval
            else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        newArrayInterval.add(newInterval);
        return newArrayInterval.toArray(new int[newArrayInterval.size()][]);
    }
}
