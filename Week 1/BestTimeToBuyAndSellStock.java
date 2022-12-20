public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }

    static int maxProfit(int[] nums)
    {
        int currentProfit = 0, maximumProfit = 0;
        for(int i = 1; i < nums.length; i++) {
            currentProfit = Math.max(0, currentProfit += nums[i] - nums[i-1]);
            maximumProfit = Math.max(currentProfit, maximumProfit);
        }
        return maximumProfit;
    }
}
