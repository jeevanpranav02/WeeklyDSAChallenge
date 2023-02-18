package Day_1;

import java.util.Arrays;
import java.util.LinkedList;

public class AsteroidCollision {
	public static void main(String[] args) {
		int[] asteroids = { 10, 2, -5 };
		System.out.println(Arrays.toString(asteroidCollision(asteroids)));
	}

	public static int[] asteroidCollision(int[] asteroids) {
		int n = asteroids.length;
		LinkedList<Integer> list = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			int ast = asteroids[i];
			if (ast > 0) {
				list.add(ast);
			} else {
				while (!list.isEmpty() && list.getLast() > 0 && list.getLast() < Math.abs(ast)) {
					list.pollLast();
				}
				if (list.isEmpty() || list.getLast() < 0) {
					list.add(ast);
				} else if (ast + list.getLast() == 0) {
					list.pollLast();
				}
			}
		}

		return list.stream().mapToInt(i -> i).toArray();
	}
}
