package Day_7;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class UglyNumber {
    public static void main(String[] args) {
        UglyNumber ugly = new UglyNumber();
//        System.out.println(ugly.nthUglyNumber(1690));
        System.out.println(ugly.nthUglyNumberOptimized(10));
    }

    public int nthUglyNumberOptimized(int n) {
        PriorityQueue<Long> queue = new PriorityQueue<Long>();
        queue.add(1l);
        for (int i = 0; i < n - 1; i++) {
            Long element = queue.poll();
            if (!queue.contains(element * 2)) {
                queue.add(element * 2);
            }
            if (!queue.contains(element * 3)) {
                queue.add(element * 3);
            }
            if (!queue.contains(element * 5)) {
                queue.add(element * 5);
            }
        }
        return queue.poll().intValue();
    }

    // TLE for below Function
    public int nthUglyNumber(int n) {
        int count = 0;
        int num = 2;
        int i = 1;
        while (true) {
            if (isUgly(i)) {
                count++;
            }
            if (count == n) {
                num = i;
                break;
            }
            i++;
        }
        return num;
    }

    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        List<Integer> list = Arrays.asList(2, 3, 5);
        for (int i = 0; i < list.size(); i++) {
            while (n % list.get(i) == 0) {
                n = n / list.get(i);
            }
        }
        return n == 1;
    }
}
