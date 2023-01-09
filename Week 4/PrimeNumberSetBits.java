package Day_4;

import java.util.Arrays;

public class PrimeNumberSetBits {
    public static void main(String[] args) {
        int left = 6;
        int right = 10;
        System.out.println(countPrimeSetBits(left, right));
    }

    static int countPrimeSetBits(int left, int right) {
        int count = 0;
        int[] primeArr = {2, 3, 5, 7, 11, 13, 17, 19};
        while (left <= right) {
            int bits = Integer.bitCount(left++);
            if (Arrays.binarySearch(primeArr, bits) >= 0) {
                count++;
            }
        }
        return count;
    }
}
