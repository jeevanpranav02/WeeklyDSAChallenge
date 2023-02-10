package Daily_Challenges;

import java.util.HashMap;
import java.util.Map;

public class FruitsInBaskets {

	public static void main(String[] args) {
//		int[] fruits = {0, 1, 2};
//		int[] fruits = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };
		int[] fruits = { 1, 2, 3, 2, 2 };
		System.out.println(totalFruit(fruits));
	}

	public static int totalFruit(int[] fruits) {
		int n = fruits.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int j = i; j <= n; j++) {
				if (map.size() <= 2 && j < n) {
					map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
				} else if (map.size() > 2 || j >= n) {
					map.put(fruits[j - 1], map.get(fruits[j - 1]) - 1);
					break;
				}
			}
			int temp = countValue(map);
			count = Math.max(count, temp);
		}
		return count;
	}

	private static int countValue(Map<Integer, Integer> map) {
		int sum = 0;
		for (int f : map.values()) {
			sum += f;
		}
		return sum;
	}
}
