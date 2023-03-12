package Daily_Challenges;

public class BinaryMatrixWithMaxOne {
    public int[] findMaxRow(int[][] mat, int n) {
        // code here
        int row = 0;
        int maxOnes = 0;

        for (int i = 0; i < n; i++) {
            int leftmostOneIndex = binarySearch(mat[i], 0, n-1);
            int ones = n - leftmostOneIndex;
            if (ones > maxOnes) {
                maxOnes = ones;
                row = i;
            }
        }
        return new int[]{row, maxOnes};
    }
    private static int binarySearch(int[] row, int left, int right) {
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] == 1) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index == -1 ? left : index;
    }
}
