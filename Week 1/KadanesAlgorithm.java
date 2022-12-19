public class KadanesAlgorithm {
    public static void main(String[] args) {
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        int maxArr = maxSubArray(array);
        System.out.println("Maximum : " + maxArr );
    }

    static int maxSubArray(int[] array)
    {
        int maximum = array[0];
        int sum = 0;
        int n = array.length;
        for(int i = 0; i < n; i++)
        {
            sum += array[i];
            maximum = maximum < sum ? sum : maximum;
            sum = sum < 0 ? 0 : sum;
        }
        return maximum;
    }
}
