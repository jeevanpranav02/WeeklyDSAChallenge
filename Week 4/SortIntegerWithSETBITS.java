package Day_6;

import java.util.Arrays;

public class SortIntegerWithSETBITS {
    public static void main(String[] args) {
        int[] arr = {};
        System.out.println(Arrays.toString(sortByBits(arr)));
    }

    static int[] sortByBits(int[] arr) {
        int countBits[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                countBits[i] = 0;
            else
                countBits[i] = Integer.bitCount(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (countBits[j] > countBits[j + 1]) {

                    countBits[j + 1] ^= countBits[j];
                    countBits[j] ^= countBits[j + 1];
                    countBits[j + 1] ^= countBits[j];

                    arr[j + 1] ^= arr[j];
                    arr[j] ^= arr[j + 1];
                    arr[j + 1] ^= arr[j];

                } else if (countBits[j] == countBits[j + 1]) {
                    if (arr[j] > arr[j + 1]) {

                        arr[j + 1] ^= arr[j];
                        arr[j] ^= arr[j + 1];
                        arr[j + 1] ^= arr[j];
                    }
                }
            }
        }
        return arr;
    }
}
