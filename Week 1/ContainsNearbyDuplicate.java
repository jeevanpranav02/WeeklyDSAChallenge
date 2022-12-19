import java.util.*;

public class ContainsNearbyDuplicate {
    public static void main(String[] args) {
        int[] num = { 1, 2, 1 };
        int k = 1;
        System.out.println(containsNearbyDuplicate(num, k));
    }

    static boolean containsNearbyDuplicate(int[] num, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            if(map.containsKey(num[i]) && i - map.get(num[i]) <= k) {
                return true;
            }
            else{
                map.put(num[i],i);
            }
        }
        return false;
    }
}
