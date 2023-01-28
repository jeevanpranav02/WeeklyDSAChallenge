package Day_2;

public class PerfectSquare {

	public static void main(String[] args) {
		int n = 16;
		System.out.println(isPerfectSquare(n));
	}
	static boolean isPerfectSquare(int num) {
        int left = 1;
        int right = Integer.MAX_VALUE;
        while(left <= right) {
            long mid = (long)(left + ((right - left) >> 1));
            if(mid * mid == num) {
                return true;
            } else if(mid * mid < num) {
                left =(int) mid + 1;
            } else {
                right =(int) mid - 1;
            }
        }
        return false;
    }

}
