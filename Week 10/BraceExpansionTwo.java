package Day_5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BraceExpansionTwo {
	public static void main(String[] args) {
		String expressionString = "{a,b}{c,{d,e}}";
		System.out.println(braceExpansionII(expressionString));
	}

	public static List<String> braceExpansionII(String expression) {
		Set<String> set = new HashSet<>();
		if (expression.length() == 1) {
			set.add(expression);
			return new ArrayList<String>(set);
		}
		Deque<String> queue = new ArrayDeque<>();
		queue.offer(expression);

		while (!queue.isEmpty()) {
			String currentString = queue.poll();
			if (currentString.indexOf("{") == -1) {
				set.add(currentString);
				continue;
			}

			int left = currentString.indexOf("{");
			int index = left;
			while (index < currentString.length() && currentString.charAt(index) != '}') {
				if (currentString.charAt(index) == '{') {
					left = index;
				}
				index++;
			}
			int right = index;
			String processed = currentString.substring(0, left);
			String[] processing = currentString.substring(left + 1, right).split(",");
			String unprocessed = currentString.substring(right + 1);

			for (String processingStrings : processing) {
				StringBuilder sb = new StringBuilder(processed);
				sb.append(processingStrings).append(unprocessed);
				queue.offer(sb.toString());
			}
		}

		List<String> resultList = new ArrayList<String>(set);
		Collections.sort(resultList);

		return resultList;
	}
}
