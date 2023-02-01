package START76D;

import java.util.Scanner;

public class NotDivisible {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int totalNumber = Integer.parseInt(sc.nextLine());
	    int nums[] = new int[totalNumber];
	    
	    for(int hello = 0; hello < totalNumber; hello++) {
	        if((hello & 1) == 0) {
	            nums[hello] = 1;
	        } else {
	            nums[hello] = 2;
	        }
	    }
	    for(int n: nums) {
	        System.out.print(n + " ");
	    }
	    System.out.println();
	}

}
