import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleWeek1 {
    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));

    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < numRows; i++) {
            List<Integer> child = new ArrayList<>();
            num = 1;
            for (int j = 0; j <= i; j++) {
                child.add(num);
                System.out.println("num = " + num);
                num = num * (i - j) / (j + 1);
            }
            result.add(child);
            System.out.println(result.get(i));
            System.out.println();
        }

        return result;
    }
}
