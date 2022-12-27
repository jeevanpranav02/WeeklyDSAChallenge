import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingSubInterval {
    public static void main(String[] args) {
         
        int[][] intervals = {{1,4},{4,10}};
        int[][] res = merge(intervals);
        for(int[] i : res)
        {
            for(int ele : i)
            {
                System.out.print(ele+"\t");
            }
            System.out.println();
        }
    }
    static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		List<int[]> result = new ArrayList<>();
		int[] temp = intervals[0];
		result.add(temp);
		for (int[] interval : intervals) 
        {
			if (interval[0] <= temp[1])  
				temp[1] = Math.max(temp[1], interval[1]);
			else 
            {                              
				temp = interval;
				result.add(temp);
			}
		}
        return result.toArray(new int[result.size()][]);
    }
}