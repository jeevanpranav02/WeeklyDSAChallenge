import java.util.*;

public class TripletSumOfElementsOfArray {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> ans = threeSum(nums);
        for(List<Integer> i : ans)
        {
            System.out.println(i.toString());
        }
    }

    static public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) 
        {
            return results;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) 
        {
            if (i > 0 && nums[i] == nums[i - 1]) 
            {
                continue;
            }

            int left = i + 1, right = nums.length - 1;
            while (left < right) 
            {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) 
                {
                    --right;
                } 
                else if (sum < 0) 
                {
                    ++left;
                } 
                else 
                {
                    results.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    boolean fail = true;
                    for (int j = left + 1; j < right; ++j) 
                    {
                        if (nums[j] != nums[left]) 
                        {
                            left = j;
                            fail = false;
                            break;
                        }
                    }
                    if (fail) 
                    {
                        break;
                    }
                }
            }
        }
        return results;
    }
}