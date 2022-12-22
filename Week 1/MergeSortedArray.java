import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};
        mergeArray(arr1, 3, arr2, 3);

    }
    static void mergeArray(int[] a1, int m, int[] a2, int n)
    {
        for(int i = m, j = 0; i < a1.length && j < n; i++, j++)
        {
            a1[i] = a2[j];
        }
        Arrays.sort(a1);
    }
}