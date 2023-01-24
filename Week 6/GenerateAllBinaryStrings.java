package Day_5;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllBinaryStrings {
	public static void main(String[] args) {
		int n = 3;
		System.out.println(generateBinaryStrings(n));
	}
	
	public static List<String> generateBinaryStrings(int n) {
	    return generateHelper("" , n);
	 } 
	
	public static List<String> generateHelper(String p, int n) {
		for(int i = 0; i < p.length(); i++) {
			if(i > 0 && p.charAt(i) == '1' && p.charAt(i - 1) == '1') {
				return new ArrayList<>();
			}
		}
		if(n <= 0) {
			List<String> list = new ArrayList<>();
			list.add(p);
			return list;
		}
		List<String> leftList = generateHelper(p + '0', n - 1);
		List<String> rightList = generateHelper(p + '1', n - 1);
		leftList.addAll(rightList);
		return leftList;
	}
}
