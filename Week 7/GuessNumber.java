package Day_2;

public class GuessNumber {

	static int ges = 6;
	public static void main(String[] args) {
		int n = 10;
		System.out.println(GuessNumber(n));
	}

	private static int guess(int n) {
		if(n == ges) {
			return 0;
		} else if(n > ges) {
			return -1;
		} else {
			return 1;
		}
	}
	
	private static int GuessNumber(int n) {
		int pick = 1;
        int left = 1;
        int right = n;
        while(left <= right) {
            int mid = left + ((right - left) >> 1);
            int guess = guess(mid);
            if(guess == 0) {
                pick = mid;
                break;
            } else if(guess == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return pick;
	}

}
