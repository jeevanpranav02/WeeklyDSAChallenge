package Daily_Challenge;

import java.util.LinkedList;
import java.util.List;

public class AddToArrayForm {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 6, 3, 0, 7, 1, 7, 1, 9, 7, 5, 6, 6, 4, 4, 0, 0, 6, 3 };
		int k = 516;
		System.out.println(addToArrayForm(nums, k));
	}

	public static List<Integer> addToArrayForm(int[] nums, int k) {
		int n = nums.length - 1;
        LinkedList<Integer> list = new LinkedList<>();
        while(n >= 0 || k != 0){
            
            if(n >= 0) {
                k += nums[n--];
            }
            
            list.addFirst(k % 10);
            k /= 10;
        }
        return list;
	}
}
