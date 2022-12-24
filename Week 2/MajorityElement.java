import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {3,2,3,2,3,3,4,4,5,5,5,3,3,1,1,1,2,2,3};
        System.out.println(majorityElement(nums));
    }

     static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ret = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (!map.containsKey(nums[i])) map.put(nums[i] , 1);
            else map.put(nums[i] , map.get(nums[i] )+1);
            if (map.get(nums[i]) > nums.length/2) 
            {
                ret = nums[i];
                break;
            }
        }
        return ret;
    }
}