import java.util.*;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> res = spiralOrder(matrix);
        System.out.println(res.toString());
    }
    static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int top = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        while(top <= bottom && left <= right)
        {
            //Traversing left to right
            for(int i = left; i <= right; i++)
            {
                result.add(matrix[top][i]);
            }
            top++;

            //Traversing top to bottom
            for(int i = top; i <= bottom; i++)
            {
                result.add(matrix[i][right]);
            }
            right--;

            //Traversing right to left
            if(top <= bottom)
            {
                for(int i = right; i >= left; i--)
                {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            //Traversing bottom to top
            if(left <= right)
            {
                for(int i = bottom; i >= top; i--)
                {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}
