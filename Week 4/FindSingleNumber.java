package Day_3;

public class FindSingleNumber {
    public static void main(String[] args) {
        int nums[] = {0,1,0,1,0,1,99};
        System.out.println(singleNumber(nums));
    }
    static int singleNumber(int[] nums) {
        int count = 0;
        for(int i = 0; i < 32; i++) {
            int bitSum = 0;
            for(int j = 0; j < nums.length; j++) {
                if(((nums[j] >> i) & 1) == 1) {
                    bitSum++;
                    bitSum %= 3;
                }
            }
            if(bitSum != 0) {
                count |= bitSum << i;
            }
        }
        return count;
    }
}
