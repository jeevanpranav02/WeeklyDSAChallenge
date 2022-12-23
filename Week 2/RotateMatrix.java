public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Matrix before transformation : ");
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix.length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        rotate(matrix);
        System.out.println("Matrix after transformation : ");
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix.length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // Here the transpose of the matrix is found
        for(int i = n - 1; i >= 0; i--)
        {
            for(int j = i; j < n; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Here the matrix colums are interchanged with the last ones
        for(int  i = 0; i < n; i++)
        {
            for (int j = 0; j < n / 2; j++) 
            {
                int temp = matrix[i][j];
                matrix[i][j]  = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}