public class JumpToZero {
    public static void main(String[] args) {
        String s = "011010";
        int minJump = 2, maxJump = 3;
        System.out.println(canReach(s, minJump, maxJump));
    }

    static boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] canReach = new boolean[n];
        canReach[0] = true;
        int left = 0;
        for (int i = 0; i < n; ++i) {
            if (canReach[i]) {
                int right = Math.min(i + maxJump, n - 1);
                for (int j = Math.max(left, i + minJump); j <= right; ++j) {
                    if (s.charAt(j) == '0') {
                        canReach[j] = true;
                    }
                }
                left = right + 1;
            }
        }
        return canReach[n - 1];
    }
}
