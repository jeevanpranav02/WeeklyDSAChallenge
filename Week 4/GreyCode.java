package Day_4;

import java.util.*;

public class GreyCode {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(Arrays.toString(grayCode(n).toArray()));
    }

    static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList((1 << n));
        list.add(0);
        for (int i = 0; i < n; i++) {
            int temp = 1 << i;
            for (int j = list.size() - 1; j >= 0; j--) {
                list.add(list.get(j) | temp);
            }
        }
        return list;
    }
}
