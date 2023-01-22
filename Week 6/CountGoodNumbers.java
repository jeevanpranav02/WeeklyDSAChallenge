package Day_2;

public class CountGoodNumbers {
	public static void main(String[] args) {
		int n = 4;
		System.out.println(countGoodNumbers(n));
	}

	static int mod = (int) 1e9 + 7;

	static int countGoodNumbers(long n) {
		return (int) (solution(4, n / 2) * solution(5, n - n / 2) % mod);
	}

	static long solution(int x, long n) {
		if (n == 0) {
			return 1;
		}
		long result = solution(x, n / 2);
		if (n % 2 == 0) {
			result = (result * result) % mod;
		} else {
			result = (result * result * x) % mod;
		}
		return result;
	}
}
