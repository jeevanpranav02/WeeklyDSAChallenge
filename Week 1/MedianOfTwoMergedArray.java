import java.util.Arrays;

public class MedianOfTwoMergedArray {
    public static void main(String[] args) {
        int[] a1 = {1,2,6,3};
        int[] a2 = {10,22,11,9};
        System.out.println(findMedianSortedArrays(a1, a2));
    }
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        double result;
        int[] mergedArray = new int[m + n];
        boolean evenCheck = mergedArray.length % 2 == 0;
        int mid = evenCheck ? (mergedArray.length / 2) - 1 : mergedArray.length / 2;
        for(int i = 0; i < mergedArray.length; i++)
        {
            if(i < m)
            {
                mergedArray[i] = nums1[i];
            }
            if(i >= m)
            {
                mergedArray[i] = nums2[i - m];
            }
        }
        Arrays.sort(mergedArray);    
        if(evenCheck)
        {
            result = (double) (mergedArray[mid] + mergedArray[mid + 1]) / 2;
        }
        else
        {
            result = (double) (mergedArray[mid]);
        }    
        return result;
    }
}