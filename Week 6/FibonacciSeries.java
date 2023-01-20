package Day_1;

public class FibonacciSeries {
	public static void main(String[] args) {
		int n = 10;
		System.out.println(fib(n));
	}

	static int fib(int n) {
		if (n < 2) {
			return n;
		}
		return fib(n - 1) + fib(n - 2);
	}
}
