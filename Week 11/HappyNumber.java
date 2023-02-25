package Day_2;

public class HappyNumber {
    public static void main(String[] args) {
        int n = 100000000;
        System.out.println(isHappy(n));
    }
    private static boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do {
            fast = squareOfDigits(squareOfDigits(fast));
            slow = squareOfDigits(slow);
        } while(fast != slow);

        if(slow == 1) {
            return true;
        }
        return false;
    }
    private static int squareOfDigits(int n) {
        int sum = 0;
        while(n != 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }
}
