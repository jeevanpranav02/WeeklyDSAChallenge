package Day_4;

import java.util.Arrays;

public class SpecialArraywithXelementsGreaterThanX {

	public static void main(String[] args) {
		int arr[] ={2,3,4,10,912,221,241,223,221,44,22,441,222,999};
		System.out.println(specialArray(arr));
	}
	
	public static int specialArray(int[] nums) {
        if(nums.length == 1 && nums[0] != 0) {
            return 1;
        }
        if(nums.length == 1 && nums[0] == 0) {
            return -1;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length;
        while(left <= right){
            int mid = left + ((right - left) >> 1);
            int count = getNumCount(nums,mid);
            if(count == mid) {
                return mid;
            } else if(count > mid) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return -1;
    }

    static int getNumCount(int arr[], int index){
        int count = 0;
        for(int a : arr) {
            if(a >= index) {
                count++;
            }
        }
        return count;
    }
}
