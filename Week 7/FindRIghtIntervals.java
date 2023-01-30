package Day_4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindRIghtIntervals {

	public static void main(String[] args) {
		int[][] intervals = {
				{3,4},
				{2,3},
				{1,2}
		};
		System.out.println(Arrays.toString(findRightInterval(intervals)));
	}
	
	static int[] findRightInterval(int[][] intervals) {
		if(intervals.length == 1) {
            return new int[]{-1};
        }
        int result[] = new int[intervals.length];
        Arrays.fill(result, -1);
        for(int i = 0; i < intervals.length; i++) {
            int current[] = intervals[i];
            if(current[0] == current[1]) {
                result[i] = i;
                continue;
            }
            int tempMin = Integer.MAX_VALUE;
            for(int j = 0; j < intervals.length; j++) {
                if(intervals[j][0] == current[1]) {
                    result[i] = j;
                    break;
                }
                if(intervals[j][0] > current[1]) {
                    tempMin = Math.min(tempMin,j);
                    result[i] = tempMin;
                }
            }
        }
        return result;
    }
}
