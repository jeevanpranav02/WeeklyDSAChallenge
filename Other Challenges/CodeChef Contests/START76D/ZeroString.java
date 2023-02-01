package START76D;

import java.util.Scanner;

public class ZeroString {
	static Scanner  sc = new Scanner(System.in);
	public static void main(String[] args) {
		try {
			solve();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static void solve() throws java.lang.Exception {
		int n = Integer.parseInt(sc.nextLine());
	    String s = sc.nextLine();
	    int one = 0;
	    int zero = 0;
	    for(int i = 0; i < n; i++) {
	        if(s.charAt(i) == '0') {
	            zero++;
	        } else {
	            one++;
	        }
	    }
	    if(one == 0) {
	        System.out.println(0);
	        return;
	    }
	    if(one <= zero) {
	        System.out.println(one);
	        return;
	    } else {
	        System.out.println(zero + 1);
	        return;
	    }
	}
}
