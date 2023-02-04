package Biweekly_Contest_97;

import java.util.LinkedHashSet;
import java.util.Set;

public class MaxNumberOfIntegers {

	public static void main(String[] args) {
		int[] banned = {1,2,3,4,5,6,7};
		int n = 8;
		int maxSum = 1;
		System.out.println(maxCount(banned, n, maxSum));
	}
	
	public static int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new LinkedHashSet<>();
        
        for(int i = 0 ; i < banned.length; i++) {
            set.add(banned[i]);
        }
        
        int countInt = 0;
        int currentSum = 0;
        for(int i = 1; i <= n; i++) {
            if(!set.contains(i)) {
                countInt++;
                currentSum += i;
            }
            if(currentSum > maxSum) {
                countInt--;
                break;
            }
        }
        return countInt;
    }

}
