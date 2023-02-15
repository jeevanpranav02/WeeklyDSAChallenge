package Day_5;

import java.util.Arrays;

public class NumberOfNGE {
	public static void main(String[] args) {
		int arr[] = { 3, 4, 2, 7, 5, 8, 10, 6 };
		int queries = 2;
		int indices[] = { 0, 5 };
		System.out.println(Arrays.toString(count_NGEs(arr.length, arr, queries, indices)));
	}

	public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
		int[] result = new int[queries];
		int i = 0;
		for (int it : indices) {
			int cnt = 0;
			for (int j = it + 1; j < arr.length; j++) {
				if (arr[j] > arr[it])
					cnt++;
			}
			result[i++] = cnt;
		}
		return result;
	}
}
