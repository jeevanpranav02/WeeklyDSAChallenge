package Day_4;

public class SquareRoot {
	public static void main(String[] args) {
		int n = 8;
		System.out.println(mySqrt(n));
	}
	
	static int mySqrt(int x) {
        if(x <= 1) {
        	return x;
        }
        
        long start = 1;
        long end = x >> 1;
        long ans = 0;
        
        while(start <= end ) {
        	long mid = start +((end - start) >> 1);
        	if(mid * mid == x) {
        		return (int) mid;
        	}
        	if(mid * mid < x) {
        		start = mid + 1;
        		ans = mid;
        	} else {
        		end = mid - 1; 
        	}
        }
        return (int) ans;
    }
}
