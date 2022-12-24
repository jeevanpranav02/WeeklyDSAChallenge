import java.util.*;

public class MakeZeros
{
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},
                        {5,0,7,8},
                        {0,10,11,12},
                        {13,14,15,0}};
        setZeroes(matrix); 
    }

    static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> setRow = new HashSet<>();
        Set<Integer> setCol = new HashSet<>();
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                int temp = matrix[i][j];
                if(temp == 0) 
                {
                    setRow.add(i);
                    setCol.add(j);
                }
            }
        }
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(setRow.contains(i) || setCol.contains(j))
                {
                    matrix[i][j] = 0;
                }
            }
        }
        for(int i = 0; i < m; i++)
        {
            System.out.print("[");
            for(int j = 0; j < n; j++)
            {
                System.out.print(matrix[i][j]+", ");
            }
            System.out.print("]");
        }
        
    }
}