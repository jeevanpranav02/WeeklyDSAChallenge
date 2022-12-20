import java.util.HashMap;
import java.util.Map;

public class TwoPointerFindDuplicate {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        System.out.println(findDuplicate(arr));;
    }
    public static int findDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length - 1;
        int duplicate = 0;

        for(int i = 1; i <= n; i++)
        {
            map.put(i,0);
        }

        for(int i:nums)
        {
            int value = map.get(i);
            if(map.containsKey(i))
            {
                map.put(i,value++);
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if(value > 1)
            {
                duplicate = (int) key;
            }
        }

        return duplicate;
    }
}
