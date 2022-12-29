import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int nums[] = { 1000000000, 1000000000, 1000000000, 1000000000 };
        int target = -294967296;
        List<List<Integer>> lst = fourSum(nums, target);
        for (List<Integer> x : lst) {
            for (int a : x) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length <= 3 || target == Integer.MAX_VALUE || target == Integer.MIN_VALUE) {
            return list;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for (int a = 0; a < n - 3; a++) {
            for (int b = a + 1; b < n - 2; b++) {
                int c = b + 1;
                int d = n - 1;
                while (c < d) {
                    long temp = (long) nums[a] + nums[b] + nums[c] + nums[d];
                    if (temp == target) {
                        List<Integer> innerList = new ArrayList<>();
                        innerList.add(nums[a]);
                        innerList.add(nums[b]);
                        innerList.add(nums[c]);
                        innerList.add(nums[d]);
                        if (!list.contains(innerList)) {
                            list.add(innerList);
                        }
                        c++;
                        d--;
                    } else if (temp < target) {
                        c++;
                    } else {
                        d--;
                    }
                }
            }
        }
        return list;
    }
}
