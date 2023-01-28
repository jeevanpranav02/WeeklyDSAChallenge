package Day_2;

public class FirstBadVersion {

	static int bad = 4;
	public static void main(String[] args) {
		int n = 5;
		System.out.println(firstBadVersion(n));
	}
	
	private static boolean isBadVersion(int n) {
		if(n == bad) {
			return true;
		} else if (n < bad) {
			return false;
		} else {
			return true;
		}
	}
	
	private static int firstBadVersion(int n) {
        int bad = 1;
        int left = 1;
        int right = n;
        while(left <= right) {
            int mid = left + ((right - left) >> 1);
            if(isBadVersion(mid) && isBadVersion(mid-1) == false) {
                bad = mid;
                break;
            } else if(isBadVersion(mid) && isBadVersion(mid-1) == true){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return bad;
    }

}
