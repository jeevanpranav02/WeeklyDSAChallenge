package Day_6;

public class FindMinimumSortedArray {

	public static void main(String[] args) {
		int[] nums = {2,2,2,0,1};
		System.out.println(findMin(nums));
	}
	
	public static int findMin(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        return findClif(nums);
    }

    private static int findClif(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                return linearSearch(nums, left, right); 
            } else if (nums[left] <= nums[mid]) {
                if (nums[mid] <= nums[right]) {
                    return nums[left]; 
                } else {
                    left = mid + 1; 
                }
            } else {
                right = mid; 
            }
        }
        return nums[left];
    }

    private static int linearSearch(int[] nums, int left, int right) {
        int min = Integer.MAX_VALUE; 
        for (int i = left; i <= right; i++) {
            min = Math.min(nums[i], min);
        }
        return min;
    }
}
