package Day_2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SwapNumbers {
    public static void main(String[] args) {
        int a = 29;
        int b = 90;
        System.out.println(Arrays.toString(new List[]{get(a, b)}));
    }


    static List<Integer> get(int a, int b)
    {
        // code here
        a ^= b;
        b ^= a;
        a ^= b;
        return new ArrayList<>(Arrays.asList(a,b));
    }
}
