package CodeChef_JAN231D;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SymmetricSwap {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws java.lang.Exception {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    static void solve() throws java.lang.Exception {
        int n = sc.nextInt();
        int[] arrayOne = new int[n];
        int[] arrayTwo = new int[n];

        for (int i = 0; i < n; i++) {
            arrayOne[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arrayTwo[i] = sc.nextInt();
        }

        // Swapping elements of arrayOne with elements of arrayTwo if (element of a1 < element of a2)
        for (int i = 0; i < n; i++) {
            if (arrayOne[i] < arrayTwo[i]) {
                swapElementsInArray(arrayOne, arrayTwo, i, i);
            }
        }

        // Combining arrays to be a matrix
        int[][] joinArray = new int[n][2];
        for (int i = 0; i < n; i++) {
            joinArray[i][0] = arrayOne[i];
            joinArray[i][1] = arrayTwo[i];
        }


        //Sorting elements of matrix based on Column 1 i.e., ArrayOne Elements after swapping
        Arrays.sort(joinArray, Comparator.comparingInt(i -> i[0]));
        int maximum = joinArray[n - 1][0];
        int minimum = joinArray[0][0];
        int result = maximum - minimum;

        // To make a track of minimum and maximum values of the arrays separate arrays are made
        int[] arrayOneMin = new int[n];
        int[] arrayOneMax = new int[n];
        int[] arrayTwoMin = new int[n];
        int[] arrayTwoMax = new int[n];

        arrayOneMin[0] = joinArray[0][0];
        arrayOneMax[0] = joinArray[0][0];
        arrayTwoMin[n - 1] = joinArray[n - 1][1];
        arrayTwoMax[n - 1] = joinArray[n - 1][1];

        for (int i = 1; i < n; i++) {
            arrayOneMin[i] = Math.min(arrayOneMin[i - 1], joinArray[i][0]);
            arrayOneMax[i] = Math.max(arrayOneMax[i - 1], joinArray[i][0]);
        }

        for (int i = n - 2; i >= 0; i--) {
            arrayTwoMin[i] = Math.min(arrayTwoMin[i + 1], joinArray[i][1]);
        }


        //Tracked elements of arrays one and two are compared and are subtracted to find the minimum of result and their difference
        for (int i = n - 1; i >= 0; i--) {
            swap(joinArray[i][0], joinArray[i][1]);
            if (i == 0) {
                maximum = arrayTwoMax[0];
                minimum = arrayTwoMin[0];
            } else {
                maximum = Math.max(arrayOneMax[i - 1], arrayTwoMax[i]);
                minimum = Math.min(arrayOneMin[i - 1], arrayTwoMin[i]);
            }
            result = Math.min(result, maximum - minimum);
        }
        System.out.println(result);
    }

    static void swapElementsInArray(int[] arrayOne, int[] arrayTwo, int i, int j) {
        arrayOne[i] ^= arrayTwo[j];
        arrayTwo[j] ^= arrayOne[i];
        arrayOne[i] ^= arrayTwo[j];
    }

    static void swap(int a, int b) {
        a ^= b;
        b ^= a;
        a ^= b;
    }
}


//        Joined array Before Swapping Matrix :
//        5 4
//        3 2
//        5 4
//        1 1
//        Joined array after Swapping Matrix :
//        1 1
//        3 2
//        5 4
//        5 4
//        Arrays before adding values :
//        [1, 0, 0, 0]
//        [1, 0, 0, 0]
//        [0, 0, 0, 4]
//        [0, 0, 0, 4]
//        Arrays after adding value :
//        [1, 1, 1, 1]
//        [1, 3, 5, 5]
//        [1, 2, 4, 4]
//        [4, 4, 4, 4]
//        Before Swapping Matrix :
//        1 1
//        3 2
//        5 4
//        5 4
//        After Sorting Matrix
//        1 1
//        3 2
//        5 4
//        5 4
//
//        Result :
//        3