package Day_7;

import java.util.ArrayList;
import java.util.Collections;

public class MinimumXOR {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(2);
        list.add(5);
        list.add(7);
        System.out.println(findMinXor((list)));

    }
    static int findMinXor(ArrayList<Integer> list) {
        Collections.sort(list);

        int minimum = Integer.MAX_VALUE;
        int val = 0;

        for (int i = 0; i < list.size() - 1; i++) {
            val = list.get(i) ^ list.get(i + 1);
            minimum = Math.min(minimum, val);
        }

        return minimum;
    }
}
