import java.util.*;

public class RearrangeArray {
    public static void main(String[] args) {
        int[] nums = { 3, 1, -2, -5, 2, -4 };
        System.out.println(rearrangeArray(nums));
    }

    static int[] rearrangeArray(int[] nums) {
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for (int x : nums) {
            if (x < 0) {
                negative.add(x);
            } else {
                positive.add(x);
            }
        }

        int[] res = new int[nums.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < positive.size() && j < negative.size()) {
            res[k++] = positive.get(i++);
            res[k++] = negative.get(j++);
        }

        while (i < positive.size()) {
            res[k++] = positive.get(i++);
        }
        while (j < positive.size()) {
            res[k++] = negative.get(j++);
        }
        return res;
    }
}
