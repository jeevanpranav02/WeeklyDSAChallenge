package Day_3;

public class kth_Factor_of_N {
    public static void main(String[] args) {
        int n = 12;
        int k = 3;
        System.out.println(kthFactor(n, k));
    }

    static int kthFactor(int n, int k) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
            if (count == k) {
                return i;
            }
        }
        return -1;
    }
}
