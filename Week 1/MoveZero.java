public class TwoPointersMoveZero {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        moveZeroes(arr);
    }
    public static void moveZeroes(int[] nums){
        int zeroCounter=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
                zeroCounter++;
            else{
                if(zeroCounter!=0){
                    nums[i-zeroCounter] = nums[i];
                    nums[i]=0;
                }
            }
        }
    }
}
