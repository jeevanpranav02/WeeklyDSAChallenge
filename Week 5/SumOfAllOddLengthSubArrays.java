package Day_7;

public class SumOfAllOddLengthSubArrays {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 5, 3};
        System.out.println(sumOddLengthSubarrays(arr));
    }

    static int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int count = 0;
        int[] sum = new int[n];
        sum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (((j - i + 1) & 1) == 0) {
                    continue;
                }
                if (i - 1 < 0) {
                    count += sum[j];
                } else {
                    count += (sum[j] - sum[i - 1]);
                }
            }
        }
        return count;
    }
}
