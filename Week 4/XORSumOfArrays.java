package Day_7;

public class XORSumOfArrays {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = {6,5};
        System.out.println(getXORSum(a,b));
    }
    static int getXORSum(int[] arr1, int[] arr2) {
        int XORArray1 = 0;
        int XORArray2 = 0;
        for(int i = 0; i < arr1.length; i++) {
            XORArray1 ^= arr1[i];
        }
        for(int i = 0; i < arr2.length; i++) {
            XORArray2 ^= arr2[i];
        }
        return XORArray1 & XORArray2;
    }
}
