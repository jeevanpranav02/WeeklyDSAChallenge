public class BinarySearchForMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(matrix, 3));
    }
    static boolean searchMatrix(int[][] matrix, int target) {
        int r = 0;
        int c = matrix[0].length - 1;
        while(r < matrix.length && c >= 0){
            if(matrix[r][c] == target) return true;
            if(target < matrix[r][c])
            {
                c--;
            }
            else
            {
                r++;
            }
        }
        return false;
    }
}