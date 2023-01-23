package Day_4;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		int target = 7;
		List<List<Integer>> ansList = combinationSum(candidates, target);
		for (List<Integer> list : ansList) {
			System.out.println(list);
		}
	}

	static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		findSum(candidates, target, result, new ArrayList<Integer>(), 0);
		return result;
	}

	static void findSum(int[] candidates, int target, List<List<Integer>> result, List<Integer> innerList, int index) {
		int sum = 0;
		for (int num : innerList) {
			sum = sum + num;
		}
		if (sum == target) {
			result.add(new ArrayList<Integer>(innerList));
			return;
		} else if (sum > target) {
			return;
		}

		for (int i = index; i < candidates.length; i++) {
			innerList.add(candidates[i]);
			findSum(candidates, target, result, innerList, i);
			innerList.remove(innerList.size() - 1);
		}
	}
}
