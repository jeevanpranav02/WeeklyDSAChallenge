package GFG;

public class TracePath {
    public static int isPossible(int n, int m, String s) {
        int left = 0;
        int right = 0;
        int up = 0;
        int down = 0;
        int dx = 0;
        int dy = 0;

        for (char ch : s.toCharArray()) {
            switch (ch) {
                case 'L' -> dx--;
                case 'R' -> dx++;
                case 'U' -> dy--;
                case 'D' -> dy++;
            }

            left = Math.min(left, dx);
            right = Math.max(right, dx);
            up = Math.max(up, dy);
            down = Math.min(down, dy);
        }

        if (right - left < m && up - down < n) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPossible(1, 1, "R"));  // Output: 0
        System.out.println(isPossible(2, 3, "LLRU"));  // Output: 1
    }
}
