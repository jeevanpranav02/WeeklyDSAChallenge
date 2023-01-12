package Day_7;

import java.util.ArrayList;

public class DifferentBitSumPairWise {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        System.out.println(cntBits(list));
    }

    static int cntBits(ArrayList<Integer> list) {
        int[] nSetBits = new int[31];
        for (int i = 0; i < list.size(); i ++) {
            int val = list.get(i);
            for (int j = 0; j < 32; j ++) {
                if (((val >> j) & 1) == 1) {
                    nSetBits[j]++;
                }
            }
        }
        long sum = 0;
        for (int i = 0; i < nSetBits.length; i ++) {
            sum += (long) nSetBits[i] * (list.size() - nSetBits[i]) * 2;
        }
        return (int) (sum % 1000000007);
    }
}
