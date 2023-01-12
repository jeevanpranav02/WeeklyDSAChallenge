package Day_7;

import java.util.ArrayList;

public class XORSubArray {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(solve(list));
    }

    static int solve(ArrayList<Integer> list) {
        int N = list.size();
        if (N % 2 == 0) return 0;
        int ans = 0;
        for (int i = 0; i < N; i += 2) {
            ans ^= list.get(i);
        }
        return ans;


//        int XOR = 0;
//        for (int i = 0; i < list.size(); i++) {
//            int freq = (i + 1) * (list.size() - i);
//            if (freq % 2 == 1)
//                XOR = XOR ^ list.get(i);
//        }
//        return XOR;
    }
}